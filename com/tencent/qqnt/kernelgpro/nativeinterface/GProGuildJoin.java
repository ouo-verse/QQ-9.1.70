package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProGuildJoin {
    public long guildId;
    public int isMember;
    public long userId;
    public int userType;
    public String name = "";
    public String avatar = "";
    public String joinSig = "";

    public String getAvatar() {
        return this.avatar;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public int getIsMember() {
        return this.isMember;
    }

    public String getJoinSig() {
        return this.joinSig;
    }

    public String getName() {
        return this.name;
    }

    public long getUserId() {
        return this.userId;
    }

    public int getUserType() {
        return this.userType;
    }

    public String toString() {
        return "GProGuildJoin{guildId=" + this.guildId + ",name=" + this.name + ",avatar=" + this.avatar + ",joinSig=" + this.joinSig + ",userId=" + this.userId + ",userType=" + this.userType + ",isMember=" + this.isMember + ",}";
    }
}
