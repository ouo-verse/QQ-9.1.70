package com.tencent.tav.decoder;

import com.tencent.tav.coremedia.CMTimeRange;

/* compiled from: P */
/* loaded from: classes26.dex */
public class VideoDecoderQuickSeekHelper {
    private boolean careForSeekTime;
    private long lastReadSampleTime;
    private long segmentStartTime;
    private float speed;
    private CMTimeRange timeRange;
    private DecoderTrackSegment trackSegment;

    private boolean isContinuesBackSeek(long j3) {
        if (this.careForSeekTime && SeekTimeStore.compareNewSeekTime(j3) > 0) {
            return true;
        }
        return false;
    }

    private boolean isContinuesForwardSeek(long j3, long j16) {
        if (this.careForSeekTime && SeekTimeStore.compareNewSeekTime(j3) < 0 && this.lastReadSampleTime < j3 && SeekTimeStore.compareNewSeekTime(j16) < 0 && j16 > 0) {
            return true;
        }
        return false;
    }

    private boolean isFreelyCornerSeek(long j3, long j16) {
        if (this.careForSeekTime && SeekTimeStore.compareNewSeekTime(j3) < 0 && SeekTimeStore.compareNewSeekTime(j16) < 0 && j16 > 0) {
            return true;
        }
        return false;
    }

    public boolean isCanQuicklyFinish(long j3, long j16) {
        return isFreelyCornerSeek(((float) this.segmentStartTime) + (((float) (j3 - this.timeRange.getStartUs())) * this.speed), ((float) this.segmentStartTime) + (((float) (j16 - this.timeRange.getStartUs())) * this.speed));
    }

    public boolean isCanSkipCurDecoder(long j3, long j16) {
        long startUs = ((float) this.segmentStartTime) + (((float) (j3 - this.timeRange.getStartUs())) * this.speed);
        long startUs2 = ((float) this.segmentStartTime) + (((float) (j16 - this.timeRange.getStartUs())) * this.speed);
        if (!isContinuesBackSeek(startUs) && !isContinuesForwardSeek(startUs, startUs2) && (j3 <= this.timeRange.getStartUs() || !isCanQuicklyFinish(startUs, startUs2))) {
            return false;
        }
        return true;
    }

    public boolean isCareForSeekTime() {
        return this.careForSeekTime;
    }

    public void setLastReadSampleTime(long j3) {
        this.lastReadSampleTime = j3;
    }

    public VideoDecoderQuickSeekHelper(boolean z16, DecoderTrackSegment decoderTrackSegment, long j3) {
        this.speed = 1.0f;
        this.lastReadSampleTime = -1L;
        this.segmentStartTime = 0L;
        this.careForSeekTime = z16;
        this.trackSegment = decoderTrackSegment;
        this.timeRange = decoderTrackSegment.getTimeRange();
        this.segmentStartTime = j3;
        if (decoderTrackSegment.getScaledDuration().getTimeUs() > 0) {
            this.speed = (((float) decoderTrackSegment.getTimeRange().getDurationUs()) * 1.0f) / ((float) decoderTrackSegment.getScaledDuration().getTimeUs());
        }
    }

    VideoDecoderQuickSeekHelper() {
        this.careForSeekTime = false;
        this.speed = 1.0f;
        this.lastReadSampleTime = -1L;
        this.segmentStartTime = 0L;
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static class DefaultVideoDecoderQuickSeekHelper extends VideoDecoderQuickSeekHelper {
        public DefaultVideoDecoderQuickSeekHelper() {
            super();
        }

        @Override // com.tencent.tav.decoder.VideoDecoderQuickSeekHelper
        public boolean isCanQuicklyFinish(long j3, long j16) {
            return false;
        }

        @Override // com.tencent.tav.decoder.VideoDecoderQuickSeekHelper
        public boolean isCanSkipCurDecoder(long j3, long j16) {
            return false;
        }

        @Override // com.tencent.tav.decoder.VideoDecoderQuickSeekHelper
        public boolean isCareForSeekTime() {
            return false;
        }

        @Override // com.tencent.tav.decoder.VideoDecoderQuickSeekHelper
        public void setLastReadSampleTime(long j3) {
        }
    }
}
