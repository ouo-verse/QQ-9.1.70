package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProSubscribeUserGuide {
    public String avatar;
    public String cover;
    public long guildId;
    public String guildName;
    public String profile;

    public GProSubscribeUserGuide() {
        this.guildName = "";
        this.avatar = "";
        this.profile = "";
        this.cover = "";
    }

    public String getAvatar() {
        return this.avatar;
    }

    public String getCover() {
        return this.cover;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public String getGuildName() {
        return this.guildName;
    }

    public String getProfile() {
        return this.profile;
    }

    public String toString() {
        return "GProSubscribeUserGuide{guildId=" + this.guildId + ",guildName=" + this.guildName + ",avatar=" + this.avatar + ",profile=" + this.profile + ",cover=" + this.cover + ",}";
    }

    public GProSubscribeUserGuide(long j3, String str, String str2, String str3, String str4) {
        this.guildId = j3;
        this.guildName = str;
        this.avatar = str2;
        this.profile = str3;
        this.cover = str4;
    }
}
