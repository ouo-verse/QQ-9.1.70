package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProScheduleUser {
    public String avatar;
    public String nick;
    public int role;
    public long tinyId;

    public GProScheduleUser() {
        this.nick = "";
        this.avatar = "";
    }

    public String getAvatar() {
        return this.avatar;
    }

    public String getNick() {
        return this.nick;
    }

    public int getRole() {
        return this.role;
    }

    public long getTinyId() {
        return this.tinyId;
    }

    public String toString() {
        return "GProScheduleUser{nick=" + this.nick + ",tinyId=" + this.tinyId + ",avatar=" + this.avatar + ",role=" + this.role + ",}";
    }

    public GProScheduleUser(String str, long j3, String str2, int i3) {
        this.nick = str;
        this.tinyId = j3;
        this.avatar = str2;
        this.role = i3;
    }
}
