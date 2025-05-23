package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProFetchRecommendChannelRsp {
    public long channelId;
    public String channelName;
    public String guildCoverUrl;
    public String guildIcon;
    public long guildId;
    public String guildName;
    public String guildProfile;

    public GProFetchRecommendChannelRsp() {
        this.guildName = "";
        this.guildProfile = "";
        this.guildIcon = "";
        this.guildCoverUrl = "";
        this.channelName = "";
    }

    public long getChannelId() {
        return this.channelId;
    }

    public String getChannelName() {
        return this.channelName;
    }

    public String getGuildCoverUrl() {
        return this.guildCoverUrl;
    }

    public String getGuildIcon() {
        return this.guildIcon;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public String getGuildName() {
        return this.guildName;
    }

    public String getGuildProfile() {
        return this.guildProfile;
    }

    public String toString() {
        return "GProFetchRecommendChannelRsp{guildId=" + this.guildId + ",guildName=" + this.guildName + ",guildProfile=" + this.guildProfile + ",guildIcon=" + this.guildIcon + ",guildCoverUrl=" + this.guildCoverUrl + ",channelId=" + this.channelId + ",channelName=" + this.channelName + ",}";
    }

    public GProFetchRecommendChannelRsp(long j3, String str, String str2, String str3, String str4, long j16, String str5) {
        this.guildId = j3;
        this.guildName = str;
        this.guildProfile = str2;
        this.guildIcon = str3;
        this.guildCoverUrl = str4;
        this.channelId = j16;
        this.channelName = str5;
    }
}
