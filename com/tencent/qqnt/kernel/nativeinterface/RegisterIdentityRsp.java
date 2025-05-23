package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class RegisterIdentityRsp {
    public byte[] context;
    public String errorMsg = "";
    public RegisterIdentityLimit limit;
    public int retCode;

    public byte[] getContext() {
        return this.context;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public RegisterIdentityLimit getLimit() {
        return this.limit;
    }

    public int getRetCode() {
        return this.retCode;
    }

    public String toString() {
        return "RegisterIdentityRsp{retCode=" + this.retCode + ",errorMsg=" + this.errorMsg + ",limit=" + this.limit + ",context=" + this.context + ",}";
    }
}
