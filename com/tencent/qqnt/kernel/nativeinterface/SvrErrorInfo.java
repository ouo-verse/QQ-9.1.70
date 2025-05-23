package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class SvrErrorInfo {
    public int errCode;
    public String errMsg = "";

    public int getErrCode() {
        return this.errCode;
    }

    public String getErrMsg() {
        return this.errMsg;
    }

    public String toString() {
        return "SvrErrorInfo{errCode=" + this.errCode + ",errMsg=" + this.errMsg + ",}";
    }
}
