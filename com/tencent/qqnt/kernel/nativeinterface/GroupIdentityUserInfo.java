package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GroupIdentityUserInfo {
    public String nick = "";
    public long uin;

    public String getNick() {
        return this.nick;
    }

    public long getUin() {
        return this.uin;
    }

    public String toString() {
        return "GroupIdentityUserInfo{uin=" + this.uin + ",nick=" + this.nick + ",}";
    }
}
