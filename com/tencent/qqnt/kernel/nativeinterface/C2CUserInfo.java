package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class C2CUserInfo {
    public int accountType;
    public String uid = "";
    public byte[] tempSessionKey = new byte[0];

    public int getAccountType() {
        return this.accountType;
    }

    public byte[] getTempSessionKey() {
        return this.tempSessionKey;
    }

    public String getUid() {
        return this.uid;
    }
}
