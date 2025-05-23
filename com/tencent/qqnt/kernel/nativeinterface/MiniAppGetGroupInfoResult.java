package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class MiniAppGetGroupInfoResult {
    public byte[] errorMsg = new byte[0];
    public int resultCode;

    public byte[] getErrorMsg() {
        return this.errorMsg;
    }

    public int getResultCode() {
        return this.resultCode;
    }

    public String toString() {
        return "MiniAppGetGroupInfoResult{resultCode=" + this.resultCode + ",errorMsg=" + this.errorMsg + ",}";
    }
}
