package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class UfsWxaSearchReportResp {
    public int errcode;
    public int qcode;
    public String respJson = "";
    public String errmsg = "";

    public int getErrcode() {
        return this.errcode;
    }

    public String getErrmsg() {
        return this.errmsg;
    }

    public int getQcode() {
        return this.qcode;
    }

    public String getRespJson() {
        return this.respJson;
    }

    public String toString() {
        return "UfsWxaSearchReportResp{respJson=" + this.respJson + ",errcode=" + this.errcode + ",qcode=" + this.qcode + ",errmsg=" + this.errmsg + ",}";
    }
}
