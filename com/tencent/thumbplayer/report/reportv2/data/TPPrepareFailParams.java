package com.tencent.thumbplayer.report.reportv2.data;

import com.tencent.thumbplayer.report.reportv2.data.TPCommonParams;

/* loaded from: classes26.dex */
public class TPPrepareFailParams extends TPCommonParams {

    @TPCommonParams.TPReportParam(key = "errorcode")
    private int mErrorCode = -1;

    public int getErrorCode() {
        return this.mErrorCode;
    }

    public void setErrorCode(int i3) {
        this.mErrorCode = i3;
    }
}
