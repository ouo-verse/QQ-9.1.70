package com.tencent.thumbplayer.report.reportv2.data.live;

import com.tencent.thumbplayer.report.reportv2.data.TPCommonParams;

/* loaded from: classes26.dex */
public class TPLiveEndParams extends TPCommonParams {

    @TPCommonParams.TPReportParam(key = "retentiondurationms")
    private long mRetentionDurationMs = -1;

    @TPCommonParams.TPReportParam(key = "errorcode")
    private int mErrorCode = -1;

    @TPCommonParams.TPReportParam(key = "videodecodertype")
    private int mVideoDecoderType = -1;

    @TPCommonParams.TPReportParam(key = "audiodecodertype")
    private int mAudioDecoderType = -1;

    @TPCommonParams.TPReportParam(key = "demuxertype")
    private int mDemuxerType = -1;

    @TPCommonParams.TPReportParam(key = "videorendertype")
    private int mVideoRenderType = -1;

    @TPCommonParams.TPReportParam(key = "audiorendertype")
    private int mAudioRenderType = -1;

    public int getAudioDecoderType() {
        return this.mAudioDecoderType;
    }

    public int getAudioRenderType() {
        return this.mAudioRenderType;
    }

    public int getDemuxerType() {
        return this.mDemuxerType;
    }

    public int getErrorCode() {
        return this.mErrorCode;
    }

    public long getRetentionDurationMs() {
        return this.mRetentionDurationMs;
    }

    public int getVideoDecoderType() {
        return this.mVideoDecoderType;
    }

    public int getVideoRenderType() {
        return this.mVideoRenderType;
    }

    public void setAudioDecoderType(int i3) {
        this.mAudioDecoderType = i3;
    }

    public void setAudioRenderType(int i3) {
        this.mAudioRenderType = i3;
    }

    public void setDemuxerType(int i3) {
        this.mDemuxerType = i3;
    }

    public void setErrorCode(int i3) {
        this.mErrorCode = i3;
    }

    public void setRetentionDurationMs(long j3) {
        this.mRetentionDurationMs = j3;
    }

    public void setVideoDecoderType(int i3) {
        this.mVideoDecoderType = i3;
    }

    public void setVideoRenderType(int i3) {
        this.mVideoRenderType = i3;
    }
}
