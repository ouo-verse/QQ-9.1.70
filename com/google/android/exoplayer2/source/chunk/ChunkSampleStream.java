package com.google.android.exoplayer2.source.chunk;

import android.support.annotation.Nullable;
import android.util.Log;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.SampleQueue;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.source.SequenceableLoader;
import com.google.android.exoplayer2.source.chunk.ChunkSource;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: P */
/* loaded from: classes2.dex */
public class ChunkSampleStream<T extends ChunkSource> implements SampleStream, SequenceableLoader, Loader.Callback<Chunk>, Loader.ReleaseCallback {
    private static final String TAG = "ChunkSampleStream";
    private final SequenceableLoader.Callback<ChunkSampleStream<T>> callback;
    private final T chunkSource;
    long decodeOnlyUntilPositionUs;
    private final SampleQueue[] embeddedSampleQueues;
    private final Format[] embeddedTrackFormats;
    private final int[] embeddedTrackTypes;
    private final boolean[] embeddedTracksSelected;
    private final MediaSourceEventListener.EventDispatcher eventDispatcher;
    private long lastSeekPositionUs;
    boolean loadingFinished;
    private final BaseMediaChunkOutput mediaChunkOutput;
    private final ArrayList<BaseMediaChunk> mediaChunks;
    private final int minLoadableRetryCount;
    private long pendingResetPositionUs;
    private Format primaryDownstreamTrackFormat;
    private final SampleQueue primarySampleQueue;
    public final int primaryTrackType;
    private final List<BaseMediaChunk> readOnlyMediaChunks;

    @Nullable
    private ReleaseCallback<T> releaseCallback;
    private final Loader loader = new Loader("Loader:ChunkSampleStream");
    private final ChunkHolder nextChunkHolder = new ChunkHolder();

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface ReleaseCallback<T extends ChunkSource> {
        void onSampleStreamReleased(ChunkSampleStream<T> chunkSampleStream);
    }

    public ChunkSampleStream(int i3, int[] iArr, Format[] formatArr, T t16, SequenceableLoader.Callback<ChunkSampleStream<T>> callback, Allocator allocator, long j3, int i16, MediaSourceEventListener.EventDispatcher eventDispatcher) {
        int length;
        this.primaryTrackType = i3;
        this.embeddedTrackTypes = iArr;
        this.embeddedTrackFormats = formatArr;
        this.chunkSource = t16;
        this.callback = callback;
        this.eventDispatcher = eventDispatcher;
        this.minLoadableRetryCount = i16;
        ArrayList<BaseMediaChunk> arrayList = new ArrayList<>();
        this.mediaChunks = arrayList;
        this.readOnlyMediaChunks = Collections.unmodifiableList(arrayList);
        int i17 = 0;
        if (iArr == null) {
            length = 0;
        } else {
            length = iArr.length;
        }
        this.embeddedSampleQueues = new SampleQueue[length];
        this.embeddedTracksSelected = new boolean[length];
        int i18 = length + 1;
        int[] iArr2 = new int[i18];
        SampleQueue[] sampleQueueArr = new SampleQueue[i18];
        SampleQueue sampleQueue = new SampleQueue(allocator);
        this.primarySampleQueue = sampleQueue;
        iArr2[0] = i3;
        sampleQueueArr[0] = sampleQueue;
        while (i17 < length) {
            SampleQueue sampleQueue2 = new SampleQueue(allocator);
            this.embeddedSampleQueues[i17] = sampleQueue2;
            int i19 = i17 + 1;
            sampleQueueArr[i19] = sampleQueue2;
            iArr2[i19] = iArr[i17];
            i17 = i19;
        }
        this.mediaChunkOutput = new BaseMediaChunkOutput(iArr2, sampleQueueArr);
        this.pendingResetPositionUs = j3;
        this.lastSeekPositionUs = j3;
    }

    private void discardDownstreamMediaChunks(int i3) {
        int primaryStreamIndexToMediaChunkIndex = primaryStreamIndexToMediaChunkIndex(i3, 0);
        if (primaryStreamIndexToMediaChunkIndex > 0) {
            Util.removeRange(this.mediaChunks, 0, primaryStreamIndexToMediaChunkIndex);
        }
    }

    private BaseMediaChunk discardUpstreamMediaChunksFromIndex(int i3) {
        BaseMediaChunk baseMediaChunk = this.mediaChunks.get(i3);
        ArrayList<BaseMediaChunk> arrayList = this.mediaChunks;
        Util.removeRange(arrayList, i3, arrayList.size());
        int i16 = 0;
        this.primarySampleQueue.discardUpstreamSamples(baseMediaChunk.getFirstSampleIndex(0));
        while (true) {
            SampleQueue[] sampleQueueArr = this.embeddedSampleQueues;
            if (i16 < sampleQueueArr.length) {
                SampleQueue sampleQueue = sampleQueueArr[i16];
                i16++;
                sampleQueue.discardUpstreamSamples(baseMediaChunk.getFirstSampleIndex(i16));
            } else {
                return baseMediaChunk;
            }
        }
    }

    private BaseMediaChunk getLastMediaChunk() {
        return this.mediaChunks.get(r0.size() - 1);
    }

    private boolean haveReadFromMediaChunk(int i3) {
        int readIndex;
        BaseMediaChunk baseMediaChunk = this.mediaChunks.get(i3);
        if (this.primarySampleQueue.getReadIndex() > baseMediaChunk.getFirstSampleIndex(0)) {
            return true;
        }
        int i16 = 0;
        do {
            SampleQueue[] sampleQueueArr = this.embeddedSampleQueues;
            if (i16 >= sampleQueueArr.length) {
                return false;
            }
            readIndex = sampleQueueArr[i16].getReadIndex();
            i16++;
        } while (readIndex <= baseMediaChunk.getFirstSampleIndex(i16));
        return true;
    }

    private boolean isMediaChunk(Chunk chunk) {
        return chunk instanceof BaseMediaChunk;
    }

    private void maybeNotifyPrimaryTrackFormatChanged(int i3, int i16) {
        int primaryStreamIndexToMediaChunkIndex = primaryStreamIndexToMediaChunkIndex(i3 - i16, 0);
        int primaryStreamIndexToMediaChunkIndex2 = i16 == 1 ? primaryStreamIndexToMediaChunkIndex : primaryStreamIndexToMediaChunkIndex(i3 - 1, primaryStreamIndexToMediaChunkIndex);
        while (primaryStreamIndexToMediaChunkIndex <= primaryStreamIndexToMediaChunkIndex2) {
            maybeNotifyPrimaryTrackFormatChanged(primaryStreamIndexToMediaChunkIndex);
            primaryStreamIndexToMediaChunkIndex++;
        }
    }

    private int primaryStreamIndexToMediaChunkIndex(int i3, int i16) {
        do {
            i16++;
            if (i16 >= this.mediaChunks.size()) {
                return this.mediaChunks.size() - 1;
            }
        } while (this.mediaChunks.get(i16).getFirstSampleIndex(0) <= i3);
        return i16 - 1;
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    public boolean continueLoading(long j3) {
        BaseMediaChunk lastMediaChunk;
        long j16;
        boolean z16 = false;
        if (this.loadingFinished || this.loader.isLoading()) {
            return false;
        }
        boolean isPendingReset = isPendingReset();
        if (isPendingReset) {
            j16 = this.pendingResetPositionUs;
            lastMediaChunk = null;
        } else {
            lastMediaChunk = getLastMediaChunk();
            j16 = lastMediaChunk.endTimeUs;
        }
        this.chunkSource.getNextChunk(lastMediaChunk, j3, j16, this.nextChunkHolder);
        ChunkHolder chunkHolder = this.nextChunkHolder;
        boolean z17 = chunkHolder.endOfStream;
        Chunk chunk = chunkHolder.chunk;
        chunkHolder.clear();
        if (z17) {
            this.pendingResetPositionUs = -9223372036854775807L;
            this.loadingFinished = true;
            return true;
        }
        if (chunk == null) {
            return false;
        }
        if (isMediaChunk(chunk)) {
            BaseMediaChunk baseMediaChunk = (BaseMediaChunk) chunk;
            if (isPendingReset) {
                long j17 = baseMediaChunk.startTimeUs;
                long j18 = this.pendingResetPositionUs;
                if (j17 == j18) {
                    z16 = true;
                }
                if (z16) {
                    j18 = Long.MIN_VALUE;
                }
                this.decodeOnlyUntilPositionUs = j18;
                this.pendingResetPositionUs = -9223372036854775807L;
            }
            baseMediaChunk.init(this.mediaChunkOutput);
            this.mediaChunks.add(baseMediaChunk);
        }
        this.eventDispatcher.loadStarted(chunk.dataSpec, chunk.type, this.primaryTrackType, chunk.trackFormat, chunk.trackSelectionReason, chunk.trackSelectionData, chunk.startTimeUs, chunk.endTimeUs, this.loader.startLoading(chunk, this, this.minLoadableRetryCount));
        return true;
    }

    public void discardBuffer(long j3, boolean z16) {
        int firstIndex = this.primarySampleQueue.getFirstIndex();
        this.primarySampleQueue.discardTo(j3, z16, true);
        int firstIndex2 = this.primarySampleQueue.getFirstIndex();
        if (firstIndex2 > firstIndex) {
            long firstTimestampUs = this.primarySampleQueue.getFirstTimestampUs();
            int i3 = 0;
            while (true) {
                SampleQueue[] sampleQueueArr = this.embeddedSampleQueues;
                if (i3 < sampleQueueArr.length) {
                    sampleQueueArr[i3].discardTo(firstTimestampUs, z16, this.embeddedTracksSelected[i3]);
                    i3++;
                } else {
                    discardDownstreamMediaChunks(firstIndex2);
                    return;
                }
            }
        }
    }

    public long getAdjustedSeekPositionUs(long j3, SeekParameters seekParameters) {
        return this.chunkSource.getAdjustedSeekPositionUs(j3, seekParameters);
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    public long getBufferedPositionUs() {
        if (this.loadingFinished) {
            return Long.MIN_VALUE;
        }
        if (isPendingReset()) {
            return this.pendingResetPositionUs;
        }
        long j3 = this.lastSeekPositionUs;
        BaseMediaChunk lastMediaChunk = getLastMediaChunk();
        if (!lastMediaChunk.isLoadCompleted()) {
            if (this.mediaChunks.size() > 1) {
                lastMediaChunk = this.mediaChunks.get(r2.size() - 2);
            } else {
                lastMediaChunk = null;
            }
        }
        if (lastMediaChunk != null) {
            j3 = Math.max(j3, lastMediaChunk.endTimeUs);
        }
        return Math.max(j3, this.primarySampleQueue.getLargestQueuedTimestampUs());
    }

    public T getChunkSource() {
        return this.chunkSource;
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    public long getNextLoadPositionUs() {
        if (isPendingReset()) {
            return this.pendingResetPositionUs;
        }
        if (this.loadingFinished) {
            return Long.MIN_VALUE;
        }
        return getLastMediaChunk().endTimeUs;
    }

    boolean isPendingReset() {
        if (this.pendingResetPositionUs != -9223372036854775807L) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public boolean isReady() {
        if (!this.loadingFinished && (isPendingReset() || !this.primarySampleQueue.hasNextSample())) {
            return false;
        }
        return true;
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public void maybeThrowError() throws IOException {
        this.loader.maybeThrowError();
        if (!this.loader.isLoading()) {
            this.chunkSource.maybeThrowError();
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.ReleaseCallback
    public void onLoaderReleased() {
        this.primarySampleQueue.reset();
        for (SampleQueue sampleQueue : this.embeddedSampleQueues) {
            sampleQueue.reset();
        }
        ReleaseCallback<T> releaseCallback = this.releaseCallback;
        if (releaseCallback != null) {
            releaseCallback.onSampleStreamReleased(this);
        }
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public int readData(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, boolean z16) {
        if (isPendingReset()) {
            return -3;
        }
        int read = this.primarySampleQueue.read(formatHolder, decoderInputBuffer, z16, this.loadingFinished, this.decodeOnlyUntilPositionUs);
        if (read == -4) {
            maybeNotifyPrimaryTrackFormatChanged(this.primarySampleQueue.getReadIndex(), 1);
        }
        return read;
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    public void reevaluateBuffer(long j3) {
        int size;
        int preferredQueueSize;
        if (this.loader.isLoading() || isPendingReset() || (size = this.mediaChunks.size()) <= (preferredQueueSize = this.chunkSource.getPreferredQueueSize(j3, this.readOnlyMediaChunks))) {
            return;
        }
        while (true) {
            if (preferredQueueSize < size) {
                if (!haveReadFromMediaChunk(preferredQueueSize)) {
                    break;
                } else {
                    preferredQueueSize++;
                }
            } else {
                preferredQueueSize = size;
                break;
            }
        }
        if (preferredQueueSize == size) {
            return;
        }
        long j16 = getLastMediaChunk().endTimeUs;
        BaseMediaChunk discardUpstreamMediaChunksFromIndex = discardUpstreamMediaChunksFromIndex(preferredQueueSize);
        if (this.mediaChunks.isEmpty()) {
            this.pendingResetPositionUs = this.lastSeekPositionUs;
        }
        this.loadingFinished = false;
        this.eventDispatcher.upstreamDiscarded(this.primaryTrackType, discardUpstreamMediaChunksFromIndex.startTimeUs, j16);
    }

    public void release() {
        release(null);
    }

    public void seekToUs(long j3) {
        BaseMediaChunk baseMediaChunk;
        boolean z16;
        boolean z17;
        this.lastSeekPositionUs = j3;
        this.primarySampleQueue.rewind();
        if (isPendingReset()) {
            z17 = false;
        } else {
            for (int i3 = 0; i3 < this.mediaChunks.size(); i3++) {
                baseMediaChunk = this.mediaChunks.get(i3);
                long j16 = baseMediaChunk.startTimeUs;
                if (j16 == j3) {
                    break;
                } else {
                    if (j16 > j3) {
                        break;
                    }
                }
            }
            baseMediaChunk = null;
            if (baseMediaChunk != null) {
                z17 = this.primarySampleQueue.setReadPosition(baseMediaChunk.getFirstSampleIndex(0));
                this.decodeOnlyUntilPositionUs = Long.MIN_VALUE;
            } else {
                SampleQueue sampleQueue = this.primarySampleQueue;
                if (j3 < getNextLoadPositionUs()) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (sampleQueue.advanceTo(j3, true, z16) != -1) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                this.decodeOnlyUntilPositionUs = this.lastSeekPositionUs;
            }
        }
        if (z17) {
            for (SampleQueue sampleQueue2 : this.embeddedSampleQueues) {
                sampleQueue2.rewind();
                sampleQueue2.advanceTo(j3, true, false);
            }
            return;
        }
        this.pendingResetPositionUs = j3;
        this.loadingFinished = false;
        this.mediaChunks.clear();
        if (this.loader.isLoading()) {
            this.loader.cancelLoading();
            return;
        }
        this.primarySampleQueue.reset();
        for (SampleQueue sampleQueue3 : this.embeddedSampleQueues) {
            sampleQueue3.reset();
        }
    }

    public ChunkSampleStream<T>.EmbeddedSampleStream selectEmbeddedTrack(long j3, int i3) {
        for (int i16 = 0; i16 < this.embeddedSampleQueues.length; i16++) {
            if (this.embeddedTrackTypes[i16] == i3) {
                Assertions.checkState(!this.embeddedTracksSelected[i16]);
                this.embeddedTracksSelected[i16] = true;
                this.embeddedSampleQueues[i16].rewind();
                this.embeddedSampleQueues[i16].advanceTo(j3, true, true);
                return new EmbeddedSampleStream(this, this.embeddedSampleQueues[i16], i16);
            }
        }
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.source.SampleStream
    public int skipData(long j3) {
        int i3 = 0;
        if (isPendingReset()) {
            return 0;
        }
        if (this.loadingFinished && j3 > this.primarySampleQueue.getLargestQueuedTimestampUs()) {
            i3 = this.primarySampleQueue.advanceToEnd();
        } else {
            int advanceTo = this.primarySampleQueue.advanceTo(j3, true, true);
            if (advanceTo != -1) {
                i3 = advanceTo;
            }
        }
        if (i3 > 0) {
            maybeNotifyPrimaryTrackFormatChanged(this.primarySampleQueue.getReadIndex(), i3);
        }
        return i3;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    public void onLoadCanceled(Chunk chunk, long j3, long j16, boolean z16) {
        this.eventDispatcher.loadCanceled(chunk.dataSpec, chunk.type, this.primaryTrackType, chunk.trackFormat, chunk.trackSelectionReason, chunk.trackSelectionData, chunk.startTimeUs, chunk.endTimeUs, j3, j16, chunk.bytesLoaded());
        if (z16) {
            return;
        }
        this.primarySampleQueue.reset();
        for (SampleQueue sampleQueue : this.embeddedSampleQueues) {
            sampleQueue.reset();
        }
        this.callback.onContinueLoadingRequested(this);
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    public void onLoadCompleted(Chunk chunk, long j3, long j16) {
        this.chunkSource.onChunkLoadCompleted(chunk);
        this.eventDispatcher.loadCompleted(chunk.dataSpec, chunk.type, this.primaryTrackType, chunk.trackFormat, chunk.trackSelectionReason, chunk.trackSelectionData, chunk.startTimeUs, chunk.endTimeUs, j3, j16, chunk.bytesLoaded());
        this.callback.onContinueLoadingRequested(this);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0085 A[RETURN] */
    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int onLoadError(Chunk chunk, long j3, long j16, IOException iOException) {
        boolean z16;
        long bytesLoaded = chunk.bytesLoaded();
        boolean isMediaChunk = isMediaChunk(chunk);
        int size = this.mediaChunks.size() - 1;
        boolean z17 = (bytesLoaded != 0 && isMediaChunk && haveReadFromMediaChunk(size)) ? false : true;
        if (this.chunkSource.onChunkLoadError(chunk, z17, iOException)) {
            if (!z17) {
                Log.w(TAG, "Ignoring attempt to cancel non-cancelable load.");
            } else {
                if (isMediaChunk) {
                    Assertions.checkState(discardUpstreamMediaChunksFromIndex(size) == chunk);
                    if (this.mediaChunks.isEmpty()) {
                        this.pendingResetPositionUs = this.lastSeekPositionUs;
                    }
                }
                z16 = true;
                this.eventDispatcher.loadError(chunk.dataSpec, chunk.type, this.primaryTrackType, chunk.trackFormat, chunk.trackSelectionReason, chunk.trackSelectionData, chunk.startTimeUs, chunk.endTimeUs, j3, j16, bytesLoaded, iOException, z16);
                if (z16) {
                    return 0;
                }
                this.callback.onContinueLoadingRequested(this);
                return 2;
            }
        }
        z16 = false;
        this.eventDispatcher.loadError(chunk.dataSpec, chunk.type, this.primaryTrackType, chunk.trackFormat, chunk.trackSelectionReason, chunk.trackSelectionData, chunk.startTimeUs, chunk.endTimeUs, j3, j16, bytesLoaded, iOException, z16);
        if (z16) {
        }
    }

    public void release(@Nullable ReleaseCallback<T> releaseCallback) {
        this.releaseCallback = releaseCallback;
        this.primarySampleQueue.discardToEnd();
        for (SampleQueue sampleQueue : this.embeddedSampleQueues) {
            sampleQueue.discardToEnd();
        }
        this.loader.release(this);
    }

    private void maybeNotifyPrimaryTrackFormatChanged(int i3) {
        BaseMediaChunk baseMediaChunk = this.mediaChunks.get(i3);
        Format format = baseMediaChunk.trackFormat;
        if (!format.equals(this.primaryDownstreamTrackFormat)) {
            this.eventDispatcher.downstreamFormatChanged(this.primaryTrackType, format, baseMediaChunk.trackSelectionReason, baseMediaChunk.trackSelectionData, baseMediaChunk.startTimeUs);
        }
        this.primaryDownstreamTrackFormat = format;
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public final class EmbeddedSampleStream implements SampleStream {
        private boolean formatNotificationSent;
        private final int index;
        public final ChunkSampleStream<T> parent;
        private final SampleQueue sampleQueue;

        public EmbeddedSampleStream(ChunkSampleStream<T> chunkSampleStream, SampleQueue sampleQueue, int i3) {
            this.parent = chunkSampleStream;
            this.sampleQueue = sampleQueue;
            this.index = i3;
        }

        private void maybeNotifyTrackFormatChanged() {
            if (!this.formatNotificationSent) {
                ChunkSampleStream.this.eventDispatcher.downstreamFormatChanged(ChunkSampleStream.this.embeddedTrackTypes[this.index], ChunkSampleStream.this.embeddedTrackFormats[this.index], 0, null, ChunkSampleStream.this.lastSeekPositionUs);
                this.formatNotificationSent = true;
            }
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public boolean isReady() {
            ChunkSampleStream chunkSampleStream = ChunkSampleStream.this;
            if (!chunkSampleStream.loadingFinished && (chunkSampleStream.isPendingReset() || !this.sampleQueue.hasNextSample())) {
                return false;
            }
            return true;
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public int readData(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, boolean z16) {
            if (ChunkSampleStream.this.isPendingReset()) {
                return -3;
            }
            SampleQueue sampleQueue = this.sampleQueue;
            ChunkSampleStream chunkSampleStream = ChunkSampleStream.this;
            int read = sampleQueue.read(formatHolder, decoderInputBuffer, z16, chunkSampleStream.loadingFinished, chunkSampleStream.decodeOnlyUntilPositionUs);
            if (read == -4) {
                maybeNotifyTrackFormatChanged();
            }
            return read;
        }

        public void release() {
            Assertions.checkState(ChunkSampleStream.this.embeddedTracksSelected[this.index]);
            ChunkSampleStream.this.embeddedTracksSelected[this.index] = false;
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public int skipData(long j3) {
            int advanceTo;
            if (ChunkSampleStream.this.loadingFinished && j3 > this.sampleQueue.getLargestQueuedTimestampUs()) {
                advanceTo = this.sampleQueue.advanceToEnd();
            } else {
                advanceTo = this.sampleQueue.advanceTo(j3, true, true);
                if (advanceTo == -1) {
                    advanceTo = 0;
                }
            }
            if (advanceTo > 0) {
                maybeNotifyTrackFormatChanged();
            }
            return advanceTo;
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public void maybeThrowError() throws IOException {
        }
    }
}
