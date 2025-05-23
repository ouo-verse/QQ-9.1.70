package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class AddFriendBlockedInfo {
    public int age;
    public long blockTime;
    public int commFriends;
    public boolean isRead;
    public int sex;
    public AccountInfo acc = new AccountInfo();
    public String nick = "";
    public String sourceDsp = "";

    public AccountInfo getAcc() {
        return this.acc;
    }

    public int getAge() {
        return this.age;
    }

    public long getBlockTime() {
        return this.blockTime;
    }

    public int getCommFriends() {
        return this.commFriends;
    }

    public boolean getIsRead() {
        return this.isRead;
    }

    public String getNick() {
        return this.nick;
    }

    public int getSex() {
        return this.sex;
    }

    public String getSourceDsp() {
        return this.sourceDsp;
    }
}
