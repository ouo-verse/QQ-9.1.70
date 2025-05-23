package com.tencent.thumbplayer.report.reportv2.data.vod;

import com.tencent.thumbplayer.report.reportv2.data.TPCommonParams;

/* loaded from: classes26.dex */
public class TPVodSelectTrackParams extends TPCommonParams {

    @TPCommonParams.TPReportParam(key = "costtimems")
    private long mCostTimeMs = -1;

    @TPCommonParams.TPReportParam(key = "errorcode")
    private int mErrorCode = -1;

    @TPCommonParams.TPReportParam(key = "mediatype")
    private int mMediaType = -1;

    @TPCommonParams.TPReportParam(key = "attachformat")
    private int mAttachFormat = -1;

    public int getAttachFormat() {
        return this.mAttachFormat;
    }

    public long getCostTimeMs() {
        return this.mCostTimeMs;
    }

    public long getErrorCode() {
        return this.mErrorCode;
    }

    public int getMediaType() {
        return this.mMediaType;
    }

    public void setAttachFormat(int i3) {
        this.mAttachFormat = i3;
    }

    public void setCostTimeMs(long j3) {
        this.mCostTimeMs = j3;
    }

    public void setErrorCode(int i3) {
        this.mErrorCode = i3;
    }

    public void setMediaType(int i3) {
        this.mMediaType = i3;
    }
}
