package com.tencent.thumbplayer.report.reportv2.data.vod;

import com.tencent.thumbplayer.report.reportv2.data.TPCommonParams;

/* loaded from: classes26.dex */
public class TPVodFirstLoadParams extends TPCommonParams {

    @TPCommonParams.TPReportParam(key = "costtimems")
    private long mCostTimeMs = -1;

    public long getCostTimeMs() {
        return this.mCostTimeMs;
    }

    public void setCostTimeMs(long j3) {
        this.mCostTimeMs = j3;
    }
}
