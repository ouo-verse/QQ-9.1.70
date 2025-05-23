package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProCmd0xf5aUserInfo {
    public int isMember;
    public long uin;
    public int visitorRole;
    public String nickname = "";
    public byte[] avatar = new byte[0];

    public byte[] getAvatar() {
        return this.avatar;
    }

    public int getIsMember() {
        return this.isMember;
    }

    public String getNickname() {
        return this.nickname;
    }

    public long getUin() {
        return this.uin;
    }

    public int getVisitorRole() {
        return this.visitorRole;
    }

    public String toString() {
        return "GProCmd0xf5aUserInfo{nickname=" + this.nickname + ",visitorRole=" + this.visitorRole + ",isMember=" + this.isMember + ",avatar=" + this.avatar + ",uin=" + this.uin + ",}";
    }
}
