package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes24.dex */
public final class ThirdPartySigSvrErrorInfo {
    public int errCode;
    public String errMsg = "";

    public int getErrCode() {
        return this.errCode;
    }

    public String getErrMsg() {
        return this.errMsg;
    }

    public String toString() {
        return "ThirdPartySigSvrErrorInfo{errCode=" + this.errCode + ",errMsg=" + this.errMsg + ",}";
    }
}
