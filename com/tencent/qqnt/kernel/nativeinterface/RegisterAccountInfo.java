package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class RegisterAccountInfo {
    public byte[] nickname = new byte[0];
    public String password = "";

    public byte[] getNickname() {
        return this.nickname;
    }

    public String getPassword() {
        return this.password;
    }

    public String toString() {
        return "RegisterAccountInfo{nickname=" + this.nickname + ",password=" + this.password + ",}";
    }
}
