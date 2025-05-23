package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class SubmitIdentityInfoReq {
    public byte[] identity;
    public UserInfo phoneInfo;
    public int type;

    public byte[] getIdentity() {
        return this.identity;
    }

    public UserInfo getPhoneInfo() {
        return this.phoneInfo;
    }

    public int getType() {
        return this.type;
    }

    public String toString() {
        return "SubmitIdentityInfoReq{type=" + this.type + ",phoneInfo=" + this.phoneInfo + ",identity=" + this.identity + ",}";
    }
}
