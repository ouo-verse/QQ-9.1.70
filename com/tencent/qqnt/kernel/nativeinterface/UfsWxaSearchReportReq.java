package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class UfsWxaSearchReportReq {
    public int reqActionType;
    public UfsWxaSearchCommParams commParams = new UfsWxaSearchCommParams();
    public String reqJson = "";
    public String wxFuncToken = "";

    public UfsWxaSearchCommParams getCommParams() {
        return this.commParams;
    }

    public int getReqActionType() {
        return this.reqActionType;
    }

    public String getReqJson() {
        return this.reqJson;
    }

    public String getWxFuncToken() {
        return this.wxFuncToken;
    }

    public String toString() {
        return "UfsWxaSearchReportReq{commParams=" + this.commParams + ",reqActionType=" + this.reqActionType + ",reqJson=" + this.reqJson + ",wxFuncToken=" + this.wxFuncToken + ",}";
    }
}
