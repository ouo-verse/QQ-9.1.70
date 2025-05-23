package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;
import java.io.IOException;

/* loaded from: classes2.dex */
public final class ClippingMediaPeriod implements MediaPeriod, MediaPeriod.Callback {
    private MediaPeriod.Callback callback;
    long endUs;
    public final MediaPeriod mediaPeriod;
    private long pendingInitialDiscontinuityPositionUs;
    private ClippingSampleStream[] sampleStreams = new ClippingSampleStream[0];
    long startUs;

    /* loaded from: classes2.dex */
    private final class ClippingSampleStream implements SampleStream {
        public final SampleStream childStream;
        private boolean sentEos;

        public ClippingSampleStream(SampleStream sampleStream) {
            this.childStream = sampleStream;
        }

        public void clearSentEos() {
            this.sentEos = false;
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public boolean isReady() {
            if (!ClippingMediaPeriod.this.isPendingInitialDiscontinuity() && this.childStream.isReady()) {
                return true;
            }
            return false;
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public void maybeThrowError() throws IOException {
            this.childStream.maybeThrowError();
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public int readData(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, boolean z16) {
            if (ClippingMediaPeriod.this.isPendingInitialDiscontinuity()) {
                return -3;
            }
            if (this.sentEos) {
                decoderInputBuffer.setFlags(4);
                return -4;
            }
            int readData = this.childStream.readData(formatHolder, decoderInputBuffer, z16);
            if (readData == -5) {
                Format format = formatHolder.format;
                int i3 = format.encoderDelay;
                if (i3 != -1 || format.encoderPadding != -1) {
                    ClippingMediaPeriod clippingMediaPeriod = ClippingMediaPeriod.this;
                    int i16 = 0;
                    if (clippingMediaPeriod.startUs != 0) {
                        i3 = 0;
                    }
                    if (clippingMediaPeriod.endUs == Long.MIN_VALUE) {
                        i16 = format.encoderPadding;
                    }
                    formatHolder.format = format.copyWithGaplessInfo(i3, i16);
                }
                return -5;
            }
            ClippingMediaPeriod clippingMediaPeriod2 = ClippingMediaPeriod.this;
            long j3 = clippingMediaPeriod2.endUs;
            if (j3 != Long.MIN_VALUE && ((readData == -4 && decoderInputBuffer.timeUs >= j3) || (readData == -3 && clippingMediaPeriod2.getBufferedPositionUs() == Long.MIN_VALUE))) {
                decoderInputBuffer.clear();
                decoderInputBuffer.setFlags(4);
                this.sentEos = true;
                return -4;
            }
            if (readData == -4 && !decoderInputBuffer.isEndOfStream()) {
                decoderInputBuffer.timeUs -= ClippingMediaPeriod.this.startUs;
            }
            return readData;
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public int skipData(long j3) {
            if (ClippingMediaPeriod.this.isPendingInitialDiscontinuity()) {
                return -3;
            }
            return this.childStream.skipData(ClippingMediaPeriod.this.startUs + j3);
        }
    }

    public ClippingMediaPeriod(MediaPeriod mediaPeriod, boolean z16) {
        long j3;
        this.mediaPeriod = mediaPeriod;
        if (z16) {
            j3 = 0;
        } else {
            j3 = -9223372036854775807L;
        }
        this.pendingInitialDiscontinuityPositionUs = j3;
        this.startUs = -9223372036854775807L;
        this.endUs = -9223372036854775807L;
    }

    private SeekParameters clipSeekParameters(long j3, SeekParameters seekParameters) {
        long min;
        long min2 = Math.min(j3 - this.startUs, seekParameters.toleranceBeforeUs);
        long j16 = this.endUs;
        if (j16 == Long.MIN_VALUE) {
            min = seekParameters.toleranceAfterUs;
        } else {
            min = Math.min(j16 - j3, seekParameters.toleranceAfterUs);
        }
        if (min2 == seekParameters.toleranceBeforeUs && min == seekParameters.toleranceAfterUs) {
            return seekParameters;
        }
        return new SeekParameters(min2, min);
    }

    private static boolean shouldKeepInitialDiscontinuity(long j3, TrackSelection[] trackSelectionArr) {
        if (j3 != 0) {
            for (TrackSelection trackSelection : trackSelectionArr) {
                if (trackSelection != null && !MimeTypes.isAudio(trackSelection.getSelectedFormat().sampleMimeType)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public boolean continueLoading(long j3) {
        return this.mediaPeriod.continueLoading(j3 + this.startUs);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void discardBuffer(long j3, boolean z16) {
        this.mediaPeriod.discardBuffer(j3 + this.startUs, z16);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long getAdjustedSeekPositionUs(long j3, SeekParameters seekParameters) {
        long j16 = this.startUs;
        if (j3 == j16) {
            return 0L;
        }
        long j17 = j3 + j16;
        return this.mediaPeriod.getAdjustedSeekPositionUs(j17, clipSeekParameters(j17, seekParameters)) - this.startUs;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public long getBufferedPositionUs() {
        long bufferedPositionUs = this.mediaPeriod.getBufferedPositionUs();
        if (bufferedPositionUs != Long.MIN_VALUE) {
            long j3 = this.endUs;
            if (j3 == Long.MIN_VALUE || bufferedPositionUs < j3) {
                return Math.max(0L, bufferedPositionUs - this.startUs);
            }
        }
        return Long.MIN_VALUE;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public long getNextLoadPositionUs() {
        long nextLoadPositionUs = this.mediaPeriod.getNextLoadPositionUs();
        if (nextLoadPositionUs != Long.MIN_VALUE) {
            long j3 = this.endUs;
            if (j3 == Long.MIN_VALUE || nextLoadPositionUs < j3) {
                return nextLoadPositionUs - this.startUs;
            }
        }
        return Long.MIN_VALUE;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public TrackGroupArray getTrackGroups() {
        return this.mediaPeriod.getTrackGroups();
    }

    boolean isPendingInitialDiscontinuity() {
        if (this.pendingInitialDiscontinuityPositionUs != -9223372036854775807L) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void maybeThrowPrepareError() throws IOException {
        this.mediaPeriod.maybeThrowPrepareError();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod.Callback
    public void onPrepared(MediaPeriod mediaPeriod) {
        boolean z16;
        if (this.startUs != -9223372036854775807L && this.endUs != -9223372036854775807L) {
            z16 = true;
        } else {
            z16 = false;
        }
        Assertions.checkState(z16);
        this.callback.onPrepared(this);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void prepare(MediaPeriod.Callback callback, long j3) {
        this.callback = callback;
        this.mediaPeriod.prepare(this, this.startUs + j3);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long readDiscontinuity() {
        boolean z16;
        if (isPendingInitialDiscontinuity()) {
            long j3 = this.pendingInitialDiscontinuityPositionUs;
            this.pendingInitialDiscontinuityPositionUs = -9223372036854775807L;
            long readDiscontinuity = readDiscontinuity();
            if (readDiscontinuity != -9223372036854775807L) {
                return readDiscontinuity;
            }
            return j3;
        }
        long readDiscontinuity2 = this.mediaPeriod.readDiscontinuity();
        if (readDiscontinuity2 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        boolean z17 = true;
        if (readDiscontinuity2 >= this.startUs) {
            z16 = true;
        } else {
            z16 = false;
        }
        Assertions.checkState(z16);
        long j16 = this.endUs;
        if (j16 != Long.MIN_VALUE && readDiscontinuity2 > j16) {
            z17 = false;
        }
        Assertions.checkState(z17);
        return readDiscontinuity2 - this.startUs;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public void reevaluateBuffer(long j3) {
        this.mediaPeriod.reevaluateBuffer(j3 + this.startUs);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0035, code lost:
    
        if (r0 > r6) goto L17;
     */
    @Override // com.google.android.exoplayer2.source.MediaPeriod
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long seekToUs(long j3) {
        this.pendingInitialDiscontinuityPositionUs = -9223372036854775807L;
        boolean z16 = false;
        for (ClippingSampleStream clippingSampleStream : this.sampleStreams) {
            if (clippingSampleStream != null) {
                clippingSampleStream.clearSentEos();
            }
        }
        long j16 = j3 + this.startUs;
        long seekToUs = this.mediaPeriod.seekToUs(j16);
        if (seekToUs != j16) {
            if (seekToUs >= this.startUs) {
                long j17 = this.endUs;
                if (j17 != Long.MIN_VALUE) {
                }
            }
            Assertions.checkState(z16);
            return seekToUs - this.startUs;
        }
        z16 = true;
        Assertions.checkState(z16);
        return seekToUs - this.startUs;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0066, code lost:
    
        if ((r12.startUs + r3) > r5) goto L26;
     */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0072  */
    @Override // com.google.android.exoplayer2.source.MediaPeriod
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long selectTracks(TrackSelection[] trackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j3) {
        long j16;
        boolean z16;
        this.sampleStreams = new ClippingSampleStream[sampleStreamArr.length];
        SampleStream[] sampleStreamArr2 = new SampleStream[sampleStreamArr.length];
        int i3 = 0;
        while (true) {
            SampleStream sampleStream = null;
            if (i3 >= sampleStreamArr.length) {
                break;
            }
            ClippingSampleStream[] clippingSampleStreamArr = this.sampleStreams;
            ClippingSampleStream clippingSampleStream = (ClippingSampleStream) sampleStreamArr[i3];
            clippingSampleStreamArr[i3] = clippingSampleStream;
            if (clippingSampleStream != null) {
                sampleStream = clippingSampleStream.childStream;
            }
            sampleStreamArr2[i3] = sampleStream;
            i3++;
        }
        long selectTracks = this.mediaPeriod.selectTracks(trackSelectionArr, zArr, sampleStreamArr2, zArr2, j3 + this.startUs) - this.startUs;
        if (isPendingInitialDiscontinuity() && j3 == 0 && shouldKeepInitialDiscontinuity(this.startUs, trackSelectionArr)) {
            j16 = selectTracks;
        } else {
            j16 = -9223372036854775807L;
        }
        this.pendingInitialDiscontinuityPositionUs = j16;
        if (selectTracks != j3) {
            if (selectTracks >= 0) {
                long j17 = this.endUs;
                if (j17 != Long.MIN_VALUE) {
                }
            }
            z16 = false;
            Assertions.checkState(z16);
            for (int i16 = 0; i16 < sampleStreamArr.length; i16++) {
                SampleStream sampleStream2 = sampleStreamArr2[i16];
                if (sampleStream2 == null) {
                    this.sampleStreams[i16] = null;
                } else if (sampleStreamArr[i16] == null || this.sampleStreams[i16].childStream != sampleStream2) {
                    this.sampleStreams[i16] = new ClippingSampleStream(sampleStream2);
                }
                sampleStreamArr[i16] = this.sampleStreams[i16];
            }
            return selectTracks;
        }
        z16 = true;
        Assertions.checkState(z16);
        while (i16 < sampleStreamArr.length) {
        }
        return selectTracks;
    }

    public void setClipping(long j3, long j16) {
        this.startUs = j3;
        this.endUs = j16;
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader.Callback
    public void onContinueLoadingRequested(MediaPeriod mediaPeriod) {
        this.callback.onContinueLoadingRequested(this);
    }
}
