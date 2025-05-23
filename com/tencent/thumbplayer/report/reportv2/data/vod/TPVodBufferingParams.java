package com.tencent.thumbplayer.report.reportv2.data.vod;

import com.tencent.thumbplayer.report.reportv2.data.TPCommonParams;

/* loaded from: classes26.dex */
public class TPVodBufferingParams extends TPCommonParams {

    @TPCommonParams.TPReportParam(key = "costtimems")
    private long mCostTimeMs = -1;

    @TPCommonParams.TPReportParam(key = "playspeed")
    private float mPlaySpeed = -1.0f;

    public long getCostTimeMs() {
        return this.mCostTimeMs;
    }

    public float getPlaySpeed() {
        return this.mPlaySpeed;
    }

    public void setCostTimeMs(long j3) {
        this.mCostTimeMs = j3;
    }

    public void setPlaySpeed(float f16) {
        this.mPlaySpeed = f16;
    }
}
