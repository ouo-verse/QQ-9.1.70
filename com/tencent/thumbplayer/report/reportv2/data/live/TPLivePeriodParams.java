package com.tencent.thumbplayer.report.reportv2.data.live;

import com.tencent.thumbplayer.report.reportv2.data.TPCommonParams;

/* loaded from: classes26.dex */
public class TPLivePeriodParams extends TPCommonParams {

    @TPCommonParams.TPReportParam(key = "bufferingdurationms")
    private long mBufferingDurationMs = -1;

    @TPCommonParams.TPReportParam(key = "bufferingcount")
    private int mBufferingCount = -1;

    @TPCommonParams.TPReportParam(key = "playeddurationms")
    private long mPlayedDurationMs = -1;

    @TPCommonParams.TPReportParam(key = "maxstreambitratekbps")
    private long mMaxStreamBitrateKbps = -1;

    @TPCommonParams.TPReportParam(key = "avgstreambitratekbps")
    private long mAvgStreamBitrateKbps = -1;

    @TPCommonParams.TPReportParam(key = "minstreambitratekbps")
    private long mMinStreamBitrateKbps = -1;

    @TPCommonParams.TPReportParam(key = "maxvideodecodecosttimems")
    private long mMaxVideoDecodeCostTimeMs = -1;

    @TPCommonParams.TPReportParam(key = "avgvideodecodecosttimems")
    private long mAvgVideoDecodeCostTimeMs = -1;

    @TPCommonParams.TPReportParam(key = "minvideodecodecosttimems")
    private long mMinVideoDecodeCostTimeMs = -1;

    @TPCommonParams.TPReportParam(key = "minvideogopsize")
    private int mMinVideoGopSize = -1;

    @TPCommonParams.TPReportParam(key = "avgvideogopsize")
    private int mAvgVideoGopSize = -1;

    @TPCommonParams.TPReportParam(key = "maxvideogopsize")
    private int mMaxVideoGopSize = -1;

    @TPCommonParams.TPReportParam(key = "videodecodeframecount")
    private int mVideoDecodeFrameCount = -1;

    @TPCommonParams.TPReportParam(key = "videorenderframecount")
    private int mVideoRenderFrameCount = -1;

    @TPCommonParams.TPReportParam(key = "videobuffereddurationms")
    private long mVideoBufferedDurationMs = -1;

    @TPCommonParams.TPReportParam(key = "audiobuffereddurationms")
    private long mAudioBufferedDurationMs = -1;

    public long getAudioBufferedDurationMs() {
        return this.mAudioBufferedDurationMs;
    }

    public long getAvgStreamBitrateKbps() {
        return this.mAvgStreamBitrateKbps;
    }

    public long getAvgVideoDecodeCostTimeMs() {
        return this.mAvgVideoDecodeCostTimeMs;
    }

    public long getAvgVideoGopSize() {
        return this.mAvgVideoGopSize;
    }

    public int getBufferingCount() {
        return this.mBufferingCount;
    }

    public long getBufferingDurationMs() {
        return this.mBufferingDurationMs;
    }

    public long getMaxStreamBitrateKbps() {
        return this.mMaxStreamBitrateKbps;
    }

    public long getMaxVideoDecodeCostTimeMs() {
        return this.mMaxVideoDecodeCostTimeMs;
    }

    public long getMaxVideoGopSize() {
        return this.mMaxVideoGopSize;
    }

    public long getMinStreamBitrateKbps() {
        return this.mMinStreamBitrateKbps;
    }

    public long getMinVideoDecodeCostTimeMs() {
        return this.mMinVideoDecodeCostTimeMs;
    }

    public long getMinVideoGopSize() {
        return this.mMinVideoGopSize;
    }

    public long getPlayedDurationMs() {
        return this.mPlayedDurationMs;
    }

    public long getVideoBufferedDurationMs() {
        return this.mVideoBufferedDurationMs;
    }

    public long getVideoDecodeFrameCount() {
        return this.mVideoDecodeFrameCount;
    }

    public long getVideoRenderFrameCount() {
        return this.mVideoRenderFrameCount;
    }

    public void setAudioBufferedDurationMs(long j3) {
        this.mAudioBufferedDurationMs = j3;
    }

    public void setAvgStreamBitrate(long j3) {
        this.mAvgStreamBitrateKbps = j3;
    }

    public void setAvgVideoDecodeCostTimeMs(long j3) {
        this.mAvgVideoDecodeCostTimeMs = j3;
    }

    public void setAvgVideoGopSize(int i3) {
        this.mAvgVideoGopSize = i3;
    }

    public void setBufferingCount(int i3) {
        this.mBufferingCount = i3;
    }

    public void setBufferingDurationMs(long j3) {
        this.mBufferingDurationMs = j3;
    }

    public void setMaxStreamBitrate(long j3) {
        this.mMaxStreamBitrateKbps = j3;
    }

    public void setMaxVideoDecodeCostTimeMs(long j3) {
        this.mMaxVideoDecodeCostTimeMs = j3;
    }

    public void setMaxVideoGopSize(int i3) {
        this.mMaxVideoGopSize = i3;
    }

    public void setMinStreamBitrate(long j3) {
        this.mMinStreamBitrateKbps = j3;
    }

    public void setMinVideoDecodeCostTimeMs(long j3) {
        this.mMinVideoDecodeCostTimeMs = j3;
    }

    public void setMinVideoGopSize(int i3) {
        this.mMinVideoGopSize = i3;
    }

    public void setPlayedDurationMs(long j3) {
        this.mPlayedDurationMs = j3;
    }

    public void setVideoBufferedDurationMs(long j3) {
        this.mVideoBufferedDurationMs = j3;
    }

    public void setVideoDecodeFrameCount(int i3) {
        this.mVideoDecodeFrameCount = i3;
    }

    public void setVideoRenderFrameCount(int i3) {
        this.mVideoRenderFrameCount = i3;
    }
}
