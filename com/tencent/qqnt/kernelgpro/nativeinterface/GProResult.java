package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProResult {
    public String errMsg = "";
    public long memberTid;
    public int result;

    public String getErrMsg() {
        return this.errMsg;
    }

    public long getMemberTid() {
        return this.memberTid;
    }

    public int getResult() {
        return this.result;
    }

    public String toString() {
        return "GProResult{memberTid=" + this.memberTid + ",result=" + this.result + ",errMsg=" + this.errMsg + ",}";
    }
}
