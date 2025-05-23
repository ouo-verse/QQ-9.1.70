package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class Account implements IKernelModel, Serializable {
    public long uin;
    long serialVersionUID = 1;
    public String uid = "";
    public UserProfile userProfile = new UserProfile();

    public String getUid() {
        return this.uid;
    }

    public long getUin() {
        return this.uin;
    }

    public UserProfile getUserProfile() {
        return this.userProfile;
    }

    public void setUid(String str) {
        this.uid = str;
    }

    public void setUin(long j3) {
        this.uin = j3;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }

    public String toString() {
        return "Account{uin=" + this.uin + ",uid=" + this.uid + ",userProfile=" + this.userProfile + ",}";
    }
}
