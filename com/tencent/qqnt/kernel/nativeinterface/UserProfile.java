package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes24.dex */
public final class UserProfile {
    public byte[] nickName = new byte[0];
    public boolean registerWithoutPwd;

    public byte[] getNickName() {
        return this.nickName;
    }

    public boolean getRegisterWithoutPwd() {
        return this.registerWithoutPwd;
    }

    public String toString() {
        return "UserProfile{nickName=" + this.nickName + ",registerWithoutPwd=" + this.registerWithoutPwd + ",}";
    }
}
