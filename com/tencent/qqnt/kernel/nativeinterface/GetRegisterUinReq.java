package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GetRegisterUinReq {
    public BindInfo bindInfo;
    public byte[] context;
    public RegisterAccountInfo registerInfo = new RegisterAccountInfo();

    public BindInfo getBindInfo() {
        return this.bindInfo;
    }

    public byte[] getContext() {
        return this.context;
    }

    public RegisterAccountInfo getRegisterInfo() {
        return this.registerInfo;
    }

    public String toString() {
        return "GetRegisterUinReq{context=" + this.context + ",registerInfo=" + this.registerInfo + ",bindInfo=" + this.bindInfo + ",}";
    }
}
