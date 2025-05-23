package com.google.android.exoplayer2.source.hls;

import android.os.Handler;
import android.util.Log;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.extractor.DummyTrackOutput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.SampleQueue;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.source.SequenceableLoader;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.chunk.Chunk;
import com.google.android.exoplayer2.source.hls.HlsChunkSource;
import com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes2.dex */
public final class HlsSampleStreamWrapper implements Loader.Callback<Chunk>, Loader.ReleaseCallback, SequenceableLoader, ExtractorOutput, SampleQueue.UpstreamFormatChangedListener {
    private static final int PRIMARY_TYPE_AUDIO = 2;
    private static final int PRIMARY_TYPE_NONE = 0;
    private static final int PRIMARY_TYPE_TEXT = 1;
    private static final int PRIMARY_TYPE_VIDEO = 3;
    private static final String TAG = "HlsSampleStreamWrapper";
    private final Allocator allocator;
    private boolean audioSampleQueueMappingDone;
    private final Callback callback;
    private final HlsChunkSource chunkSource;
    private Format downstreamTrackFormat;
    private int enabledTrackGroupCount;
    private final MediaSourceEventListener.EventDispatcher eventDispatcher;
    private boolean haveAudioVideoSampleQueues;
    private long lastSeekPositionUs;
    private boolean loadingFinished;
    private final int minLoadableRetryCount;
    private final Format muxedAudioFormat;
    private long pendingResetPositionUs;
    private boolean pendingResetUpstreamFormats;
    private boolean prepared;
    private int primaryTrackGroupIndex;
    private boolean released;
    private long sampleOffsetUs;
    private boolean sampleQueuesBuilt;
    private boolean seenFirstTrackSelection;
    private int[] trackGroupToSampleQueueIndex;
    private TrackGroupArray trackGroups;
    private final int trackType;
    private boolean tracksEnded;
    private boolean videoSampleQueueMappingDone;
    private final Loader loader = new Loader("Loader:HlsSampleStreamWrapper");
    private final HlsChunkSource.HlsChunkHolder nextChunkHolder = new HlsChunkSource.HlsChunkHolder();
    private int[] sampleQueueTrackIds = new int[0];
    private int audioSampleQueueIndex = -1;
    private int videoSampleQueueIndex = -1;
    private SampleQueue[] sampleQueues = new SampleQueue[0];
    private boolean[] sampleQueueIsAudioVideoFlags = new boolean[0];
    private boolean[] sampleQueuesEnabledStates = new boolean[0];
    private final ArrayList<HlsMediaChunk> mediaChunks = new ArrayList<>();
    private final Runnable maybeFinishPrepareRunnable = new Runnable() { // from class: com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper.1
        @Override // java.lang.Runnable
        public void run() {
            HlsSampleStreamWrapper.this.maybeFinishPrepare();
        }
    };
    private final Runnable onTracksEndedRunnable = new Runnable() { // from class: com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper.2
        @Override // java.lang.Runnable
        public void run() {
            HlsSampleStreamWrapper.this.onTracksEnded();
        }
    };
    private final Handler handler = new Handler();

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface Callback extends SequenceableLoader.Callback<HlsSampleStreamWrapper> {
        void onPlaylistRefreshRequired(HlsMasterPlaylist.HlsUrl hlsUrl);

        void onPrepared();
    }

    public HlsSampleStreamWrapper(int i3, Callback callback, HlsChunkSource hlsChunkSource, Allocator allocator, long j3, Format format, int i16, MediaSourceEventListener.EventDispatcher eventDispatcher) {
        this.trackType = i3;
        this.callback = callback;
        this.chunkSource = hlsChunkSource;
        this.allocator = allocator;
        this.muxedAudioFormat = format;
        this.minLoadableRetryCount = i16;
        this.eventDispatcher = eventDispatcher;
        this.lastSeekPositionUs = j3;
        this.pendingResetPositionUs = j3;
    }

    private void buildTracks() {
        Format format;
        int length = this.sampleQueues.length;
        int i3 = 0;
        char c16 = 0;
        int i16 = -1;
        while (true) {
            char c17 = 3;
            if (i3 >= length) {
                break;
            }
            String str = this.sampleQueues[i3].getUpstreamFormat().sampleMimeType;
            if (!MimeTypes.isVideo(str)) {
                if (MimeTypes.isAudio(str)) {
                    c17 = 2;
                } else if (MimeTypes.isText(str)) {
                    c17 = 1;
                } else {
                    c17 = 0;
                }
            }
            if (c17 > c16) {
                i16 = i3;
                c16 = c17;
            } else if (c17 == c16 && i16 != -1) {
                i16 = -1;
            }
            i3++;
        }
        TrackGroup trackGroup = this.chunkSource.getTrackGroup();
        int i17 = trackGroup.length;
        this.primaryTrackGroupIndex = -1;
        this.trackGroupToSampleQueueIndex = new int[length];
        for (int i18 = 0; i18 < length; i18++) {
            this.trackGroupToSampleQueueIndex[i18] = i18;
        }
        TrackGroup[] trackGroupArr = new TrackGroup[length];
        for (int i19 = 0; i19 < length; i19++) {
            Format upstreamFormat = this.sampleQueues[i19].getUpstreamFormat();
            if (i19 == i16) {
                Format[] formatArr = new Format[i17];
                for (int i26 = 0; i26 < i17; i26++) {
                    formatArr[i26] = deriveFormat(trackGroup.getFormat(i26), upstreamFormat, true);
                }
                trackGroupArr[i19] = new TrackGroup(formatArr);
                this.primaryTrackGroupIndex = i19;
            } else {
                if (c16 == 3 && MimeTypes.isAudio(upstreamFormat.sampleMimeType)) {
                    format = this.muxedAudioFormat;
                } else {
                    format = null;
                }
                trackGroupArr[i19] = new TrackGroup(deriveFormat(format, upstreamFormat, false));
            }
        }
        this.trackGroups = new TrackGroupArray(trackGroupArr);
    }

    private static DummyTrackOutput createDummyTrackOutput(int i3, int i16) {
        Log.w(TAG, "Unmapped track with id " + i3 + " of type " + i16);
        return new DummyTrackOutput();
    }

    private static Format deriveFormat(Format format, Format format2, boolean z16) {
        int i3;
        if (format == null) {
            return format2;
        }
        if (z16) {
            i3 = format.bitrate;
        } else {
            i3 = -1;
        }
        int i16 = i3;
        String codecsOfType = Util.getCodecsOfType(format.codecs, MimeTypes.getTrackType(format2.sampleMimeType));
        String mediaMimeType = MimeTypes.getMediaMimeType(codecsOfType);
        if (mediaMimeType == null) {
            mediaMimeType = format2.sampleMimeType;
        }
        return format2.copyWithContainerInfo(format.f32936id, mediaMimeType, codecsOfType, i16, format.width, format.height, format.selectionFlags, format.language);
    }

    private boolean finishedReadingChunk(HlsMediaChunk hlsMediaChunk) {
        int i3 = hlsMediaChunk.uid;
        int length = this.sampleQueues.length;
        for (int i16 = 0; i16 < length; i16++) {
            if (this.sampleQueuesEnabledStates[i16] && this.sampleQueues[i16].peekSourceId() == i3) {
                return false;
            }
        }
        return true;
    }

    private static boolean formatsMatch(Format format, Format format2) {
        String str = format.sampleMimeType;
        String str2 = format2.sampleMimeType;
        int trackType = MimeTypes.getTrackType(str);
        if (trackType != 3) {
            if (trackType == MimeTypes.getTrackType(str2)) {
                return true;
            }
            return false;
        }
        if (!Util.areEqual(str, str2)) {
            return false;
        }
        if ((!"application/cea-608".equals(str) && !"application/cea-708".equals(str)) || format.accessibilityChannel == format2.accessibilityChannel) {
            return true;
        }
        return false;
    }

    private HlsMediaChunk getLastMediaChunk() {
        return this.mediaChunks.get(r0.size() - 1);
    }

    private static boolean isMediaChunk(Chunk chunk) {
        return chunk instanceof HlsMediaChunk;
    }

    private boolean isPendingReset() {
        if (this.pendingResetPositionUs != -9223372036854775807L) {
            return true;
        }
        return false;
    }

    private void mapSampleQueuesToMatchTrackGroups() {
        int i3 = this.trackGroups.length;
        int[] iArr = new int[i3];
        this.trackGroupToSampleQueueIndex = iArr;
        Arrays.fill(iArr, -1);
        for (int i16 = 0; i16 < i3; i16++) {
            int i17 = 0;
            while (true) {
                SampleQueue[] sampleQueueArr = this.sampleQueues;
                if (i17 >= sampleQueueArr.length) {
                    break;
                }
                if (formatsMatch(sampleQueueArr[i17].getUpstreamFormat(), this.trackGroups.get(i16).getFormat(0))) {
                    this.trackGroupToSampleQueueIndex[i16] = i17;
                    break;
                }
                i17++;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void maybeFinishPrepare() {
        if (!this.released && this.trackGroupToSampleQueueIndex == null && this.sampleQueuesBuilt) {
            for (SampleQueue sampleQueue : this.sampleQueues) {
                if (sampleQueue.getUpstreamFormat() == null) {
                    return;
                }
            }
            if (this.trackGroups != null) {
                mapSampleQueuesToMatchTrackGroups();
                return;
            }
            buildTracks();
            this.prepared = true;
            this.callback.onPrepared();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onTracksEnded() {
        this.sampleQueuesBuilt = true;
        maybeFinishPrepare();
    }

    private void resetSampleQueues() {
        for (SampleQueue sampleQueue : this.sampleQueues) {
            sampleQueue.reset(this.pendingResetUpstreamFormats);
        }
        this.pendingResetUpstreamFormats = false;
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
            if (z16 || (!this.sampleQueueIsAudioVideoFlags[i3] && this.haveAudioVideoSampleQueues)) {
                i3++;
            }
        }
        return false;
    }

    public int bindSampleQueueToSampleStream(int i3) {
        int i16;
        if (!isMappingFinished() || (i16 = this.trackGroupToSampleQueueIndex[i3]) == -1) {
            return -1;
        }
        boolean[] zArr = this.sampleQueuesEnabledStates;
        if (zArr[i16]) {
            return -1;
        }
        zArr[i16] = true;
        return i16;
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    public boolean continueLoading(long j3) {
        HlsMediaChunk lastMediaChunk;
        long j16;
        if (this.loadingFinished || this.loader.isLoading()) {
            return false;
        }
        if (isPendingReset()) {
            j16 = this.pendingResetPositionUs;
            lastMediaChunk = null;
        } else {
            lastMediaChunk = getLastMediaChunk();
            j16 = lastMediaChunk.endTimeUs;
        }
        this.chunkSource.getNextChunk(lastMediaChunk, j3, j16, this.nextChunkHolder);
        HlsChunkSource.HlsChunkHolder hlsChunkHolder = this.nextChunkHolder;
        boolean z16 = hlsChunkHolder.endOfStream;
        Chunk chunk = hlsChunkHolder.chunk;
        HlsMasterPlaylist.HlsUrl hlsUrl = hlsChunkHolder.playlist;
        hlsChunkHolder.clear();
        if (z16) {
            this.pendingResetPositionUs = -9223372036854775807L;
            this.loadingFinished = true;
            return true;
        }
        if (chunk == null) {
            if (hlsUrl != null) {
                this.callback.onPlaylistRefreshRequired(hlsUrl);
            }
            return false;
        }
        if (isMediaChunk(chunk)) {
            this.pendingResetPositionUs = -9223372036854775807L;
            HlsMediaChunk hlsMediaChunk = (HlsMediaChunk) chunk;
            hlsMediaChunk.init(this);
            this.mediaChunks.add(hlsMediaChunk);
        }
        this.eventDispatcher.loadStarted(chunk.dataSpec, chunk.type, this.trackType, chunk.trackFormat, chunk.trackSelectionReason, chunk.trackSelectionData, chunk.startTimeUs, chunk.endTimeUs, this.loader.startLoading(chunk, this, this.minLoadableRetryCount));
        return true;
    }

    public void continuePreparing() {
        if (!this.prepared) {
            continueLoading(this.lastSeekPositionUs);
        }
    }

    public void discardBuffer(long j3, boolean z16) {
        if (!this.sampleQueuesBuilt) {
            return;
        }
        int length = this.sampleQueues.length;
        for (int i3 = 0; i3 < length; i3++) {
            this.sampleQueues[i3].discardTo(j3, z16, this.sampleQueuesEnabledStates[i3]);
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorOutput
    public void endTracks() {
        this.tracksEnded = true;
        this.handler.post(this.onTracksEndedRunnable);
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
        HlsMediaChunk lastMediaChunk = getLastMediaChunk();
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
        if (this.sampleQueuesBuilt) {
            for (SampleQueue sampleQueue : this.sampleQueues) {
                j3 = Math.max(j3, sampleQueue.getLargestQueuedTimestampUs());
            }
        }
        return j3;
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

    public TrackGroupArray getTrackGroups() {
        return this.trackGroups;
    }

    public void init(int i3, boolean z16, boolean z17) {
        if (!z17) {
            this.audioSampleQueueMappingDone = false;
            this.videoSampleQueueMappingDone = false;
        }
        for (SampleQueue sampleQueue : this.sampleQueues) {
            sampleQueue.sourceId(i3);
        }
        if (z16) {
            for (SampleQueue sampleQueue2 : this.sampleQueues) {
                sampleQueue2.splice();
            }
        }
    }

    public boolean isMappingFinished() {
        if (this.trackGroupToSampleQueueIndex != null) {
            return true;
        }
        return false;
    }

    public boolean isReady(int i3) {
        if (!this.loadingFinished && (isPendingReset() || !this.sampleQueues[i3].hasNextSample())) {
            return false;
        }
        return true;
    }

    public void maybeThrowError() throws IOException {
        this.loader.maybeThrowError();
        this.chunkSource.maybeThrowError();
    }

    public void maybeThrowPrepareError() throws IOException {
        maybeThrowError();
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.ReleaseCallback
    public void onLoaderReleased() {
        resetSampleQueues();
    }

    public void onPlaylistBlacklisted(HlsMasterPlaylist.HlsUrl hlsUrl, long j3) {
        this.chunkSource.onPlaylistBlacklisted(hlsUrl, j3);
    }

    @Override // com.google.android.exoplayer2.source.SampleQueue.UpstreamFormatChangedListener
    public void onUpstreamFormatChanged(Format format) {
        this.handler.post(this.maybeFinishPrepareRunnable);
    }

    public void prepareWithMasterPlaylistInfo(TrackGroupArray trackGroupArray, int i3) {
        this.prepared = true;
        this.trackGroups = trackGroupArray;
        this.primaryTrackGroupIndex = i3;
        this.callback.onPrepared();
    }

    public int readData(int i3, FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, boolean z16) {
        if (isPendingReset()) {
            return -3;
        }
        if (!this.mediaChunks.isEmpty()) {
            int i16 = 0;
            while (i16 < this.mediaChunks.size() - 1 && finishedReadingChunk(this.mediaChunks.get(i16))) {
                i16++;
            }
            if (i16 > 0) {
                Util.removeRange(this.mediaChunks, 0, i16);
            }
            HlsMediaChunk hlsMediaChunk = this.mediaChunks.get(0);
            Format format = hlsMediaChunk.trackFormat;
            if (!format.equals(this.downstreamTrackFormat)) {
                this.eventDispatcher.downstreamFormatChanged(this.trackType, format, hlsMediaChunk.trackSelectionReason, hlsMediaChunk.trackSelectionData, hlsMediaChunk.startTimeUs);
            }
            this.downstreamTrackFormat = format;
        }
        return this.sampleQueues[i3].read(formatHolder, decoderInputBuffer, z16, this.loadingFinished, this.lastSeekPositionUs);
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

    public boolean seekToUs(long j3, boolean z16) {
        this.lastSeekPositionUs = j3;
        if (this.sampleQueuesBuilt && !z16 && !isPendingReset() && seekInsideBufferUs(j3)) {
            return false;
        }
        this.pendingResetPositionUs = j3;
        this.loadingFinished = false;
        this.mediaChunks.clear();
        if (this.loader.isLoading()) {
            this.loader.cancelLoading();
            return true;
        }
        resetSampleQueues();
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:76:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x011d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean selectTracks(TrackSelection[] trackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j3, boolean z16) {
        boolean z17;
        boolean z18;
        boolean z19;
        TrackSelection trackSelection;
        boolean z26;
        Assertions.checkState(this.prepared);
        int i3 = this.enabledTrackGroupCount;
        int i16 = 0;
        for (int i17 = 0; i17 < trackSelectionArr.length; i17++) {
            SampleStream sampleStream = sampleStreamArr[i17];
            if (sampleStream != null && (trackSelectionArr[i17] == null || !zArr[i17])) {
                this.enabledTrackGroupCount--;
                ((HlsSampleStream) sampleStream).unbindSampleQueue();
                sampleStreamArr[i17] = null;
            }
        }
        if (!z16 && (!this.seenFirstTrackSelection ? j3 == this.lastSeekPositionUs : i3 != 0)) {
            z17 = false;
        } else {
            z17 = true;
        }
        TrackSelection trackSelection2 = this.chunkSource.getTrackSelection();
        boolean z27 = z17;
        TrackSelection trackSelection3 = trackSelection2;
        for (int i18 = 0; i18 < trackSelectionArr.length; i18++) {
            if (sampleStreamArr[i18] == null && (trackSelection = trackSelectionArr[i18]) != null) {
                this.enabledTrackGroupCount++;
                int indexOf = this.trackGroups.indexOf(trackSelection.getTrackGroup());
                if (indexOf == this.primaryTrackGroupIndex) {
                    this.chunkSource.selectTracks(trackSelection);
                    trackSelection3 = trackSelection;
                }
                sampleStreamArr[i18] = new HlsSampleStream(this, indexOf);
                zArr2[i18] = true;
                if (this.sampleQueuesBuilt && !z27) {
                    SampleQueue sampleQueue = this.sampleQueues[this.trackGroupToSampleQueueIndex[indexOf]];
                    sampleQueue.rewind();
                    if (sampleQueue.advanceTo(j3, true, true) == -1 && sampleQueue.getReadIndex() != 0) {
                        z26 = true;
                    } else {
                        z26 = false;
                    }
                    z27 = z26;
                }
            }
        }
        if (this.enabledTrackGroupCount == 0) {
            this.chunkSource.reset();
            this.downstreamTrackFormat = null;
            this.mediaChunks.clear();
            if (this.loader.isLoading()) {
                if (this.sampleQueuesBuilt) {
                    SampleQueue[] sampleQueueArr = this.sampleQueues;
                    int length = sampleQueueArr.length;
                    while (i16 < length) {
                        sampleQueueArr[i16].discardToEnd();
                        i16++;
                    }
                }
                this.loader.cancelLoading();
            } else {
                resetSampleQueues();
            }
        } else {
            if (!this.mediaChunks.isEmpty() && !Util.areEqual(trackSelection3, trackSelection2)) {
                if (!this.seenFirstTrackSelection) {
                    long j16 = 0;
                    if (j3 < 0) {
                        j16 = -j3;
                    }
                    trackSelection3.updateSelectedTrack(j3, j16, -9223372036854775807L);
                    if (trackSelection3.getSelectedIndexInTrackGroup() == this.chunkSource.getTrackGroup().indexOf(getLastMediaChunk().trackFormat)) {
                        z19 = false;
                        if (z19) {
                            this.pendingResetUpstreamFormats = true;
                            z18 = true;
                            z27 = true;
                            if (z27) {
                                seekToUs(j3, z18);
                                while (i16 < sampleStreamArr.length) {
                                    if (sampleStreamArr[i16] != null) {
                                        zArr2[i16] = true;
                                    }
                                    i16++;
                                }
                            }
                        }
                    }
                }
                z19 = true;
                if (z19) {
                }
            }
            z18 = z16;
            if (z27) {
            }
        }
        this.seenFirstTrackSelection = true;
        return z27;
    }

    public void setIsTimestampMaster(boolean z16) {
        this.chunkSource.setIsTimestampMaster(z16);
    }

    public void setSampleOffsetUs(long j3) {
        this.sampleOffsetUs = j3;
        for (SampleQueue sampleQueue : this.sampleQueues) {
            sampleQueue.setSampleOffsetUs(j3);
        }
    }

    public int skipData(int i3, long j3) {
        if (isPendingReset()) {
            return 0;
        }
        SampleQueue sampleQueue = this.sampleQueues[i3];
        if (this.loadingFinished && j3 > sampleQueue.getLargestQueuedTimestampUs()) {
            return sampleQueue.advanceToEnd();
        }
        int advanceTo = sampleQueue.advanceTo(j3, true, true);
        if (advanceTo == -1) {
            return 0;
        }
        return advanceTo;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorOutput
    public TrackOutput track(int i3, int i16) {
        SampleQueue[] sampleQueueArr = this.sampleQueues;
        int length = sampleQueueArr.length;
        boolean z16 = false;
        if (i16 == 1) {
            int i17 = this.audioSampleQueueIndex;
            if (i17 != -1) {
                if (this.audioSampleQueueMappingDone) {
                    if (this.sampleQueueTrackIds[i17] == i3) {
                        return sampleQueueArr[i17];
                    }
                    return createDummyTrackOutput(i3, i16);
                }
                this.audioSampleQueueMappingDone = true;
                this.sampleQueueTrackIds[i17] = i3;
                return sampleQueueArr[i17];
            }
            if (this.tracksEnded) {
                return createDummyTrackOutput(i3, i16);
            }
        } else if (i16 == 2) {
            int i18 = this.videoSampleQueueIndex;
            if (i18 != -1) {
                if (this.videoSampleQueueMappingDone) {
                    if (this.sampleQueueTrackIds[i18] == i3) {
                        return sampleQueueArr[i18];
                    }
                    return createDummyTrackOutput(i3, i16);
                }
                this.videoSampleQueueMappingDone = true;
                this.sampleQueueTrackIds[i18] = i3;
                return sampleQueueArr[i18];
            }
            if (this.tracksEnded) {
                return createDummyTrackOutput(i3, i16);
            }
        } else {
            for (int i19 = 0; i19 < length; i19++) {
                if (this.sampleQueueTrackIds[i19] == i3) {
                    return this.sampleQueues[i19];
                }
            }
            if (this.tracksEnded) {
                return createDummyTrackOutput(i3, i16);
            }
        }
        SampleQueue sampleQueue = new SampleQueue(this.allocator);
        sampleQueue.setSampleOffsetUs(this.sampleOffsetUs);
        sampleQueue.setUpstreamFormatChangeListener(this);
        int i26 = length + 1;
        int[] copyOf = Arrays.copyOf(this.sampleQueueTrackIds, i26);
        this.sampleQueueTrackIds = copyOf;
        copyOf[length] = i3;
        SampleQueue[] sampleQueueArr2 = (SampleQueue[]) Arrays.copyOf(this.sampleQueues, i26);
        this.sampleQueues = sampleQueueArr2;
        sampleQueueArr2[length] = sampleQueue;
        boolean[] copyOf2 = Arrays.copyOf(this.sampleQueueIsAudioVideoFlags, i26);
        this.sampleQueueIsAudioVideoFlags = copyOf2;
        if (i16 == 1 || i16 == 2) {
            z16 = true;
        }
        copyOf2[length] = z16;
        this.haveAudioVideoSampleQueues |= z16;
        if (i16 == 1) {
            this.audioSampleQueueMappingDone = true;
            this.audioSampleQueueIndex = length;
        } else if (i16 == 2) {
            this.videoSampleQueueMappingDone = true;
            this.videoSampleQueueIndex = length;
        }
        this.sampleQueuesEnabledStates = Arrays.copyOf(this.sampleQueuesEnabledStates, i26);
        return sampleQueue;
    }

    public void unbindSampleQueue(int i3) {
        int i16 = this.trackGroupToSampleQueueIndex[i3];
        Assertions.checkState(this.sampleQueuesEnabledStates[i16]);
        this.sampleQueuesEnabledStates[i16] = false;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    public void onLoadCanceled(Chunk chunk, long j3, long j16, boolean z16) {
        this.eventDispatcher.loadCanceled(chunk.dataSpec, chunk.type, this.trackType, chunk.trackFormat, chunk.trackSelectionReason, chunk.trackSelectionData, chunk.startTimeUs, chunk.endTimeUs, j3, j16, chunk.bytesLoaded());
        if (z16) {
            return;
        }
        resetSampleQueues();
        if (this.enabledTrackGroupCount > 0) {
            this.callback.onContinueLoadingRequested(this);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    public void onLoadCompleted(Chunk chunk, long j3, long j16) {
        this.chunkSource.onChunkLoadCompleted(chunk);
        this.eventDispatcher.loadCompleted(chunk.dataSpec, chunk.type, this.trackType, chunk.trackFormat, chunk.trackSelectionReason, chunk.trackSelectionData, chunk.startTimeUs, chunk.endTimeUs, j3, j16, chunk.bytesLoaded());
        if (!this.prepared) {
            continueLoading(this.lastSeekPositionUs);
        } else {
            this.callback.onContinueLoadingRequested(this);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.Callback
    public int onLoadError(Chunk chunk, long j3, long j16, IOException iOException) {
        long bytesLoaded = chunk.bytesLoaded();
        boolean isMediaChunk = isMediaChunk(chunk);
        boolean z16 = true;
        if (!this.chunkSource.onChunkLoadError(chunk, !isMediaChunk || bytesLoaded == 0, iOException)) {
            z16 = false;
        } else if (isMediaChunk) {
            ArrayList<HlsMediaChunk> arrayList = this.mediaChunks;
            Assertions.checkState(arrayList.remove(arrayList.size() - 1) == chunk);
            if (this.mediaChunks.isEmpty()) {
                this.pendingResetPositionUs = this.lastSeekPositionUs;
            }
        }
        this.eventDispatcher.loadError(chunk.dataSpec, chunk.type, this.trackType, chunk.trackFormat, chunk.trackSelectionReason, chunk.trackSelectionData, chunk.startTimeUs, chunk.endTimeUs, j3, j16, chunk.bytesLoaded(), iOException, z16);
        if (!z16) {
            return 0;
        }
        if (!this.prepared) {
            continueLoading(this.lastSeekPositionUs);
            return 2;
        }
        this.callback.onContinueLoadingRequested(this);
        return 2;
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader
    public void reevaluateBuffer(long j3) {
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorOutput
    public void seekMap(SeekMap seekMap) {
    }
}
