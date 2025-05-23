package com.google.android.exoplayer2.source;

import android.net.Uri;
import android.os.Handler;
import android.support.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.extractor.DefaultExtractorInput;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.SampleQueue;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ConditionVariable;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.TraceUtil;
import com.google.android.exoplayer2.util.Util;
import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;

/* loaded from: classes2.dex */
final class ExtractorMediaPeriod implements MediaPeriod, ExtractorOutput, Loader.Callback<ExtractingLoadable>, Loader.ReleaseCallback, SampleQueue.UpstreamFormatChangedListener {
    private static final long DEFAULT_LAST_SAMPLE_DURATION_US = 10000;
    private int actualMinLoadableRetryCount;
    private final Allocator allocator;
    private MediaPeriod.Callback callback;
    private final long continueLoadingCheckIntervalBytes;

    @Nullable
    private final String customCacheKey;
    private final DataSource dataSource;
    private int enabledTrackCount;
    private final MediaSourceEventListener.EventDispatcher eventDispatcher;
    private int extractedSamplesCountAtStartOfLoad;
    private final ExtractorHolder extractorHolder;
    private boolean haveAudioVideoTracks;
    private long lastSeekPositionUs;
    private final Listener listener;
    private boolean loadingFinished;
    private final int minLoadableRetryCount;
    private boolean notifyDiscontinuity;
    private boolean pendingDeferredRetry;
    private boolean prepared;
    private boolean released;
    private boolean sampleQueuesBuilt;
    private SeekMap seekMap;
    private boolean seenFirstTrackSelection;
    private boolean[] trackEnabledStates;
    private boolean[] trackFormatNotificationSent;
    private boolean[] trackIsAudioVideoFlags;
    private TrackGroupArray tracks;
    private final Uri uri;
    private final Loader loader = new Loader("Loader:ExtractorMediaPeriod");
    private final ConditionVariable loadCondition = new ConditionVariable();
    private final Runnable maybeFinishPrepareRunnable = new Runnable() { // from class: com.google.android.exoplayer2.source.ExtractorMediaPeriod.1
        @Override // java.lang.Runnable
        public void run() {
            ExtractorMediaPeriod.this.maybeFinishPrepare();
        }
    };
    private final Runnable onContinueLoadingRequestedRunnable = new Runnable() { // from class: com.google.android.exoplayer2.source.ExtractorMediaPeriod.2
        @Override // java.lang.Runnable
        public void run() {
            if (!ExtractorMediaPeriod.this.released) {
                ExtractorMediaPeriod.this.callback.onContinueLoadingRequested(ExtractorMediaPeriod.this);
            }
        }
    };
    private final Handler handler = new Handler();
    private int[] sampleQueueTrackIds = new int[0];
    private int[] sampleQueueTrackTypes = new int[0];
    private SampleQueue[] sampleQueues = new SampleQueue[0];
    private long pendingResetPositionUs = -9223372036854775807L;
    private long length = -1;
    private long durationUs = -9223372036854775807L;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public final class ExtractingLoadable implements Loader.Loadable {
        private long bytesLoaded;
        private final DataSource dataSource;
        private DataSpec dataSpec;
        private final ExtractorHolder extractorHolder;
        private volatile boolean loadCanceled;
        private final ConditionVariable loadCondition;
        private long seekTimeUs;
        private final Uri uri;
        private final PositionHolder positionHolder = new PositionHolder();
        private boolean pendingExtractorSeek = true;
        private long length = -1;

        public ExtractingLoadable(Uri uri, DataSource dataSource, ExtractorHolder extractorHolder, ConditionVariable conditionVariable) {
            this.uri = (Uri) Assertions.checkNotNull(uri);
            this.dataSource = (DataSource) Assertions.checkNotNull(dataSource);
            this.extractorHolder = (ExtractorHolder) Assertions.checkNotNull(extractorHolder);
            this.loadCondition = conditionVariable;
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
        public void cancelLoad() {
            this.loadCanceled = true;
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
        public boolean isLoadCanceled() {
            return this.loadCanceled;
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.Loadable
        public void load() throws IOException, InterruptedException {
            long j3;
            DefaultExtractorInput defaultExtractorInput;
            int i3 = 0;
            while (i3 == 0 && !this.loadCanceled) {
                DefaultExtractorInput defaultExtractorInput2 = null;
                try {
                    j3 = this.positionHolder.position;
                    DataSpec dataSpec = new DataSpec(this.uri, j3, -1L, ExtractorMediaPeriod.this.customCacheKey);
                    this.dataSpec = dataSpec;
                    long open = this.dataSource.open(dataSpec);
                    this.length = open;
                    if (open != -1) {
                        this.length = open + j3;
                    }
                    defaultExtractorInput = new DefaultExtractorInput(this.dataSource, j3, this.length);
                } catch (Throwable th5) {
                    th = th5;
                }
                try {
                    Extractor selectExtractor = this.extractorHolder.selectExtractor(defaultExtractorInput, this.dataSource.getUri());
                    if (this.pendingExtractorSeek) {
                        selectExtractor.seek(j3, this.seekTimeUs);
                        this.pendingExtractorSeek = false;
                    }
                    TraceUtil.beginSection("ExtractorRead");
                    while (i3 == 0 && !this.loadCanceled) {
                        this.loadCondition.block();
                        i3 = selectExtractor.read(defaultExtractorInput, this.positionHolder);
                        if (defaultExtractorInput.getPosition() > ExtractorMediaPeriod.this.continueLoadingCheckIntervalBytes + j3) {
                            j3 = defaultExtractorInput.getPosition();
                            this.loadCondition.close();
                            ExtractorMediaPeriod.this.handler.post(ExtractorMediaPeriod.this.onContinueLoadingRequestedRunnable);
                        }
                    }
                    TraceUtil.endSection();
                    if (i3 == 1) {
                        i3 = 0;
                    } else {
                        this.positionHolder.position = defaultExtractorInput.getPosition();
                        this.bytesLoaded = this.positionHolder.position - this.dataSpec.absoluteStreamPosition;
                    }
                    Util.closeQuietly(this.dataSource);
                } catch (Throwable th6) {
                    th = th6;
                    defaultExtractorInput2 = defaultExtractorInput;
                    if (i3 != 1 && defaultExtractorInput2 != null) {
                        this.positionHolder.position = defaultExtractorInput2.getPosition();
                        this.bytesLoaded = this.positionHolder.position - this.dataSpec.absoluteStreamPosition;
                    }
                    Util.closeQuietly(this.dataSource);
                    throw th;
                }
            }
        }

        public void setLoadPosition(long j3, long j16) {
            this.positionHolder.position = j3;
            this.seekTimeUs = j16;
            this.pendingExtractorSeek = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class ExtractorHolder {
        private Extractor extractor;
        private final ExtractorOutput extractorOutput;
        private final Extractor[] extractors;

        public ExtractorHolder(Extractor[] extractorArr, ExtractorOutput extractorOutput) {
            this.extractors = extractorArr;
            this.extractorOutput = extractorOutput;
        }

        public void release() {
            Extractor extractor = this.extractor;
            if (extractor != null) {
                extractor.release();
                this.extractor = null;
            }
        }

        public Extractor selectExtractor(ExtractorInput extractorInput, Uri uri) throws IOException, InterruptedException {
            Extractor extractor = this.extractor;
            if (extractor != null) {
                return extractor;
            }
            Extractor[] extractorArr = this.extractors;
            int length = extractorArr.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    break;
                }
                Extractor extractor2 = extractorArr[i3];
                try {
                } catch (EOFException unused) {
                } catch (Throwable th5) {
                    extractorInput.resetPeekPosition();
                    throw th5;
                }
                if (extractor2.sniff(extractorInput)) {
                    this.extractor = extractor2;
                    extractorInput.resetPeekPosition();
                    break;
                }
                continue;
                extractorInput.resetPeekPosition();
                i3++;
            }
            Extractor extractor3 = this.extractor;
            if (extractor3 != null) {
                extractor3.init(this.extractorOutput);
                return this.extractor;
            }
            throw new UnrecognizedInputFormatException("None of the available extractors (" + Util.getCommaDelimitedSimpleClassNames(this.extractors) + ") could read the stream.", uri);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public interface Listener {
        void onSourceInfoRefreshed(long j3, boolean z16);
    }

    /* loaded from: classes2.dex */
    private final class SampleStreamImpl implements SampleStream {
        private final int track;

        public SampleStreamImpl(int i3) {
            this.track = i3;
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public boolean isReady() {
            return ExtractorMediaPeriod.this.isReady(this.track);
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public void maybeThrowError() throws IOException {
            ExtractorMediaPeriod.this.maybeThrowError();
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public int readData(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, boolean z16) {
            return ExtractorMediaPeriod.this.readData(this.track, formatHolder, decoderInputBuffer, z16);
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public int skipData(long j3) {
            return ExtractorMediaPeriod.this.skipData(this.track, j3);
        }
    }

    public ExtractorMediaPeriod(Uri uri, DataSource dataSource, Extractor[] extractorArr, int i3, MediaSourceEventListener.EventDispatcher eventDispatcher, Listener listener, Allocator allocator, @Nullable String str, int i16) {
        this.uri = uri;
        this.dataSource = dataSource;
        this.minLoadableRetryCount = i3;
        this.eventDispatcher = eventDispatcher;
        this.listener = listener;
        this.allocator = allocator;
        this.customCacheKey = str;
        this.continueLoadingCheckIntervalBytes = i16;
        this.extractorHolder = new ExtractorHolder(extractorArr, this);
        this.actualMinLoadableRetryCount = i3 == -1 ? 3 : i3;
    }

    private boolean configureRetry(ExtractingLoadable extractingLoadable, int i3) {
        SeekMap seekMap;
        if (this.length == -1 && ((seekMap = this.seekMap) == null || seekMap.getDurationUs() == -9223372036854775807L)) {
            if (this.prepared && !suppressRead()) {
                this.pendingDeferredRetry = true;
                return false;
            }
            this.notifyDiscontinuity = this.prepared;
            this.lastSeekPositionUs = 0L;
            this.extractedSamplesCountAtStartOfLoad = 0;
            for (SampleQueue sampleQueue : this.sampleQueues) {
                sampleQueue.reset();
            }
            extractingLoadable.setLoadPosition(0L, 0L);
            return true;
        }
        this.extractedSamplesCountAtStartOfLoad = i3;
        return true;
    }

    private void copyLengthFromLoader(ExtractingLoadable extractingLoadable) {
        if (this.length == -1) {
            this.length = extractingLoadable.length;
        }
    }

    private int getExtractedSamplesCount() {
        int i3 = 0;
        for (SampleQueue sampleQueue : this.sampleQueues) {
            i3 += sampleQueue.getWriteIndex();
        }
        return i3;
    }

    private long getLargestQueuedTimestampUs() {
        long j3 = Long.MIN_VALUE;
        for (SampleQueue sampleQueue : this.sampleQueues) {
            j3 = Math.max(j3, sampleQueue.getLargestQueuedTimestampUs());
        }
        return j3;
    }

    private static boolean isLoadableExceptionFatal(IOException iOException) {
        return iOException instanceof UnrecognizedInputFormatException;
    }

    private boolean isPendingReset() {
        if (this.pendingResetPositionUs != -9223372036854775807L) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void maybeFinishPrepare() {
        if (!this.released && !this.prepared && this.seekMap != null && this.sampleQueuesBuilt) {
            for (SampleQueue sampleQueue : this.sampleQueues) {
                if (sampleQueue.getUpstreamFormat() == null) {
                    return;
                }
            }
            this.loadCondition.close();
            int length = this.sampleQueues.length;
            TrackGroup[] trackGroupArr = new TrackGroup[length];
            this.trackIsAudioVideoFlags = new boolean[length];
            this.trackEnabledStates = new boolean[length];
            this.trackFormatNotificationSent = new boolean[length];
            this.durationUs = this.seekMap.getDurationUs();
            int i3 = 0;
            while (true) {
                boolean z16 = true;
                if (i3 >= length) {
                    break;
                }
                Format upstreamFormat = this.sampleQueues[i3].getUpstreamFormat();
                trackGroupArr[i3] = new TrackGroup(upstreamFormat);
                String str = upstreamFormat.sampleMimeType;
                if (!MimeTypes.isVideo(str) && !MimeTypes.isAudio(str)) {
                    z16 = false;
                }
                this.trackIsAudioVideoFlags[i3] = z16;
                this.haveAudioVideoTracks = z16 | this.haveAudioVideoTracks;
                i3++;
            }
            this.tracks = new TrackGroupArray(trackGroupArr);
            if (this.minLoadableRetryCount == -1 && this.length == -1 && this.seekMap.getDurationUs() == -9223372036854775807L) {
                this.actualMinLoadableRetryCount = 6;
            }
            this.prepared = true;
            this.listener.onSourceInfoRefreshed(this.durationUs, this.seekMap.isSeekable());
            this.callback.onPrepared(this);
        }
    }

    private void maybeNotifyTrackFormat(int i3) {
        if (!this.trackFormatNotificationSent[i3]) {
            Format format = this.tracks.get(i3).getFormat(0);
            this.eventDispatcher.downstreamFormatChanged(MimeTypes.getTrackType(format.sampleMimeType), format, 0, null, this.lastSeekPositionUs);
            this.trackFormatNotificationSent[i3] = true;
        }
    }

    private void maybeStartDeferredRetry(int i3) {
        if (this.pendingDeferredRetry && this.trackIsAudioVideoFlags[i3] && !this.sampleQueues[i3].hasNextSample()) {
            this.pendingResetPositionUs = 0L;
            this.pendingDeferredRetry = false;
            this.notifyDiscontinuity = true;
            this.lastSeekPositionUs = 0L;
            this.extractedSamplesCountAtStartOfLoad = 0;
            for (SampleQueue sampleQueue : this.sampleQueues) {
                sampleQueue.reset();
            }
            this.callback.onContinueLoadingRequested(this);
        }
    }

    private boolean seekInsideBufferUs(long j3) {
        int length = this.sampleQueues.length;
        int i3 = 0;
        while (true) {
            boolean z16 = true;
            if (i3 >= length) {
                return true;
            }
            SampleQueue sampleQueue = this.sampleQueues[i3];
            sampleQueue.rewind();
            if (sampleQueue.advanceTo(j3, true, false) == -1) {
                z16 = false;
            }
            if (z16 || (!this.trackIsAudioVideoFlags[i3] && this.haveAudioVideoTracks)) {
                i3++;
            }
        }
        return false;
    }

    private void startLoading() {
        ExtractingLoadable extractingLoadable = new ExtractingLoadable(this.uri, this.dataSource, this.extractorHolder, this.loadCondition);
        if (this.prepared) {
            Assertions.checkState(isPendingReset());
            long j3 = this.durationUs;
            if (j3 != -9223372036854775807L && this.pendingResetPositionUs >= j3) {
                this.loadingFinished = true;
                this.pendingResetPositionUs = -9223372036854775807L;
                return;
            } else {
                extractingLoadable.setLoadPosition(this.seekMap.getSeekPoints(this.pendingResetPositionUs).first.position, this.pendingResetPositionUs);
                this.pendingResetPositionUs = -9223372036854775807L;
            }
        }
        this.extractedSamplesCountAtStartOfLoad = getExtractedSamplesCount();
        this.eventDispatcher.loadStarted(extractingLoadable.dataSpec, 1, -1, null, 0, null, extractingLoadable.seekTimeUs, this.durationUs, this.loader.startLoading(extractingLoadable, this, this.actualMinLoadableRetryCount));
    }

    private boolean suppressRead() {
        if (!this.notifyDiscontinuity && !isPendingReset()) {
            return false;
        }
        return true;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public boolean continueLoading(long j3) {
        if (!this.loadingFinished && !this.pendingDeferredRetry) {
            if (!this.prepared || this.enabledTrackCount != 0) {
                boolean open = this.loadCondition.open();
                if (!this.loader.isLoading()) {
                    startLoading();
                    return true;
                }
                return open;
            }
            return false;
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void discardBuffer(long j3, boolean z16) {
        int length = this.sampleQueues.length;
        for (int i3 = 0; i3 < length; i3++) {
            this.sampleQueues[i3].discardTo(j3, z16, this.trackEnabledStates[i3]);
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorOutput
    public void endTracks() {
        this.sampleQueuesBuilt = true;
        this.handler.post(this.maybeFinishPrepareRunnable);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long getAdjustedSeekPositionUs(long j3, SeekParameters seekParameters) {
        if (!this.seekMap.isSeekable()) {
            return 0L;
        }
        SeekMap.SeekPoints seekPoints = this.seekMap.getSeekPoints(j3);
        return Util.resolveSeekPositionUs(j3, seekParameters, seekPoints.first.timeUs, seekPoints.second.timeUs);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public long getBufferedPositionUs() {
        long largestQueuedTimestampUs;
        if (this.loadingFinished) {
            return Long.MIN_VALUE;
        }
        if (isPendingReset()) {
            return this.pendingResetPositionUs;
        }
        if (this.haveAudioVideoTracks) {
            int length = this.sampleQueues.length;
            largestQueuedTimestampUs = Long.MAX_VALUE;
            for (int i3 = 0; i3 < length; i3++) {
                if (this.trackIsAudioVideoFlags[i3]) {
                    largestQueuedTimestampUs = Math.min(largestQueuedTimestampUs, this.sampleQueues[i3].getLargestQueuedTimestampUs());
                }
            }
        } else {
            largestQueuedTimestampUs = getLargestQueuedTimestampUs();
        }
        if (largestQueuedTimestampUs == Long.MIN_VALUE) {
            return this.lastSeekPositionUs;
        }
        return largestQueuedTimestampUs;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public long getNextLoadPositionUs() {
        if (this.enabledTrackCount == 0) {
            return Long.MIN_VALUE;
        }
        return getBufferedPositionUs();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public TrackGroupArray getTrackGroups() {
        return this.tracks;
    }

    boolean isReady(int i3) {
        if (!suppressRead() && (this.loadingFinished || this.sampleQueues[i3].hasNextSample())) {
            return true;
        }
        return false;
    }

    void maybeThrowError() throws IOException {
        this.loader.maybeThrowError(this.actualMinLoadableRetryCount);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void maybeThrowPrepareError() throws IOException {
        maybeThrowError();
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.ReleaseCallback
    public void onLoaderReleased() {
        for (SampleQueue sampleQueue : this.sampleQueues) {
            sampleQueue.reset();
        }
        this.extractorHolder.release();
    }

    @Override // com.google.android.exoplayer2.source.SampleQueue.UpstreamFormatChangedListener
    public void onUpstreamFormatChanged(Format format) {
        this.handler.post(this.maybeFinishPrepareRunnable);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void prepare(MediaPeriod.Callback callback, long j3) {
        this.callback = callback;
        this.loadCondition.open();
        startLoading();
    }

    int readData(int i3, FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, boolean z16) {
        if (suppressRead()) {
            return -3;
        }
        int read = this.sampleQueues[i3].read(formatHolder, decoderInputBuffer, z16, this.loadingFinished, this.lastSeekPositionUs);
        if (read == -4) {
            maybeNotifyTrackFormat(i3);
        } else if (read == -3) {
            maybeStartDeferredRetry(i3);
        }
        return read;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long readDiscontinuity() {
        if (this.notifyDiscontinuity) {
            if (this.loadingFinished || getExtractedSamplesCount() > this.extractedSamplesCountAtStartOfLoad) {
                this.notifyDiscontinuity = false;
                return this.lastSeekPositionUs;
            }
            return -9223372036854775807L;
        }
        return -9223372036854775807L;
    }

    public void release() {
        if (this.prepared) {
            for (SampleQueue sampleQueue : this.sampleQueues) {
                sampleQueue.discardToEnd();
            }
        }
        this.loader.release(this);
        this.handler.removeCallbacksAndMessages(null);
        this.released = true;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorOutput
    public void seekMap(SeekMap seekMap) {
        this.seekMap = seekMap;
        this.handler.post(this.maybeFinishPrepareRunnable);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long seekToUs(long j3) {
        if (!this.seekMap.isSeekable()) {
            j3 = 0;
        }
        this.lastSeekPositionUs = j3;
        this.notifyDiscontinuity = false;
        if (!isPendingReset() && seekInsideBufferUs(j3)) {
            return j3;
        }
        this.pendingDeferredRetry = false;
        this.pendingResetPositionUs = j3;
        this.loadingFinished = false;
        if (this.loader.isLoading()) {
            this.loader.cancelLoading();
        } else {
            for (SampleQueue sampleQueue : this.sampleQueues) {
                sampleQueue.reset();
            }
        }
        return j3;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long selectTracks(TrackSelection[] trackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j3) {
        boolean z16;
        TrackSelection trackSelection;
        boolean z17;
        boolean z18;
        Assertions.checkState(this.prepared);
        int i3 = this.enabledTrackCount;
        int i16 = 0;
        for (int i17 = 0; i17 < trackSelectionArr.length; i17++) {
            SampleStream sampleStream = sampleStreamArr[i17];
            if (sampleStream != null && (trackSelectionArr[i17] == null || !zArr[i17])) {
                int i18 = ((SampleStreamImpl) sampleStream).track;
                Assertions.checkState(this.trackEnabledStates[i18]);
                this.enabledTrackCount--;
                this.trackEnabledStates[i18] = false;
                sampleStreamArr[i17] = null;
            }
        }
        if (!this.seenFirstTrackSelection ? j3 != 0 : i3 == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        for (int i19 = 0; i19 < trackSelectionArr.length; i19++) {
            if (sampleStreamArr[i19] == null && (trackSelection = trackSelectionArr[i19]) != null) {
                if (trackSelection.length() == 1) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                Assertions.checkState(z17);
                if (trackSelection.getIndexInTrackGroup(0) == 0) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                Assertions.checkState(z18);
                int indexOf = this.tracks.indexOf(trackSelection.getTrackGroup());
                Assertions.checkState(!this.trackEnabledStates[indexOf]);
                this.enabledTrackCount++;
                this.trackEnabledStates[indexOf] = true;
                sampleStreamArr[i19] = new SampleStreamImpl(indexOf);
                zArr2[i19] = true;
                if (!z16) {
                    SampleQueue sampleQueue = this.sampleQueues[indexOf];
                    sampleQueue.rewind();
                    if (sampleQueue.advanceTo(j3, true, true) == -1 && sampleQueue.getReadIndex() != 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                }
            }
        }
        if (this.enabledTrackCount == 0) {
            this.pendingDeferredRetry = false;
            this.notifyDiscontinuity = false;
            if (this.loader.isLoading()) {
                SampleQueue[] sampleQueueArr = this.sampleQueues;
                int length = sampleQueueArr.length;
                while (i16 < length) {
                    sampleQueueArr[i16].discardToEnd();
                    i16++;
                }
                this.loader.cancelLoading();
            } else {
                SampleQueue[] sampleQueueArr2 = this.sampleQueues;
                int length2 = sampleQueueArr2.length;
                while (i16 < length2) {
                    sampleQueueArr2[i16].reset();
                    i16++;
                }
            }
        } else if (z16) {
            j3 = seekToUs(j3);
            while (i16 < sampleStreamArr.length) {
                if (sampleStreamArr[i16] != null) {
                    zArr2[i16] = true;
                }
                i16++;
            }
        }
        this.seenFirstTrackSelection = true;
        return j3;
    }

    int skipData(int i3, long j3) {
        int i16 = 0;
        if (suppressRead()) {
            return 0;
        }
        SampleQueue sampleQueue = this.sampleQueues[i3];
        if (this.loadingFinished && j3 > sampleQueue.getLargestQueuedTimestampUs()) {
            i16 = sampleQueue.advanceToEnd();
        } else {
            int advanceTo = sampleQueue.advanceTo(j3, true, true);
            if (advanceTo != -1) {
                i16 = advanceTo;
            }
        }
        if (i16 > 0) {
            maybeNotifyTrackFormat(i3);
        } else {
            maybeStartDeferredRetry(i3);
        }
        return i16;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorOutput
    public TrackOutput track(int i3, int i16) {
        int length = this.sampleQueues.length;
        for (int i17 = 0; i17 < length; i17++) {
            if (this.sampleQueueTrackIds[i17] == i3) {
                return this.sampleQueues[i17];
            }
        }
        SampleQueue sampleQueue = new SampleQueue(this.allocator);
        sampleQueue.setUpstreamFormatChangeListener(this);
        int i18 = length + 1;
        int[] copyOf = Arrays.copyOf(this.sampleQueueTrackIds, i18);
        this.sampleQueueTrackIds = copyOf;
        copyOf[length] = i3;
        int[] copyOf2 = Arrays.copyOf(this.sampleQueueTrackTypes, i18);
        this.sampleQueueTrackTypes = copyOf2;
        copyOf2[length] = i16;
        SampleQueue[] sampleQueueArr = (SampleQueue[]) Arrays.copyOf(this.sampleQueues, i18);
        this.sampleQueues = sampleQueueArr;
        sampleQueueArr[length] = sampleQueue;
        return sampleQueue;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    public void onLoadCanceled(ExtractingLoadable extractingLoadable, long j3, long j16, boolean z16) {
        this.eventDispatcher.loadCanceled(extractingLoadable.dataSpec, 1, -1, null, 0, null, extractingLoadable.seekTimeUs, this.durationUs, j3, j16, extractingLoadable.bytesLoaded);
        if (z16) {
            return;
        }
        copyLengthFromLoader(extractingLoadable);
        for (SampleQueue sampleQueue : this.sampleQueues) {
            sampleQueue.reset();
        }
        if (this.enabledTrackCount > 0) {
            this.callback.onContinueLoadingRequested(this);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    public void onLoadCompleted(ExtractingLoadable extractingLoadable, long j3, long j16) {
        if (this.durationUs == -9223372036854775807L) {
            long largestQueuedTimestampUs = getLargestQueuedTimestampUs();
            long j17 = largestQueuedTimestampUs == Long.MIN_VALUE ? 0L : largestQueuedTimestampUs + 10000;
            this.durationUs = j17;
            this.listener.onSourceInfoRefreshed(j17, this.seekMap.isSeekable());
        }
        this.eventDispatcher.loadCompleted(extractingLoadable.dataSpec, 1, -1, null, 0, null, extractingLoadable.seekTimeUs, this.durationUs, j3, j16, extractingLoadable.bytesLoaded);
        copyLengthFromLoader(extractingLoadable);
        this.loadingFinished = true;
        this.callback.onContinueLoadingRequested(this);
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    public int onLoadError(ExtractingLoadable extractingLoadable, long j3, long j16, IOException iOException) {
        ExtractingLoadable extractingLoadable2;
        boolean z16;
        boolean isLoadableExceptionFatal = isLoadableExceptionFatal(iOException);
        this.eventDispatcher.loadError(extractingLoadable.dataSpec, 1, -1, null, 0, null, extractingLoadable.seekTimeUs, this.durationUs, j3, j16, extractingLoadable.bytesLoaded, iOException, isLoadableExceptionFatal);
        copyLengthFromLoader(extractingLoadable);
        if (isLoadableExceptionFatal) {
            return 3;
        }
        int extractedSamplesCount = getExtractedSamplesCount();
        if (extractedSamplesCount > this.extractedSamplesCountAtStartOfLoad) {
            extractingLoadable2 = extractingLoadable;
            z16 = true;
        } else {
            extractingLoadable2 = extractingLoadable;
            z16 = false;
        }
        if (configureRetry(extractingLoadable2, extractedSamplesCount)) {
            return z16 ? 1 : 0;
        }
        return 2;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public void reevaluateBuffer(long j3) {
    }
}
