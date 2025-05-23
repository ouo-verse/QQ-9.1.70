package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProRecommendShareInfo implements Serializable {
    public GProBusinessData bizData;
    public long channelId;
    public String guildCoverUrl;
    public String guildIcon;
    public long guildId;
    public String guildName;
    public String joinGuildSig;
    public int joinedGuild;
    public int memberRole;
    long serialVersionUID;
    public String shareLink;
    public GProRecommendShareLive shareLive;
    public int shareTag;
    public int shareType;

    public GProRecommendShareInfo() {
        this.serialVersionUID = 1L;
        this.shareLink = "";
        this.guildName = "";
        this.guildIcon = "";
        this.shareLive = new GProRecommendShareLive();
        this.guildCoverUrl = "";
        this.joinGuildSig = "";
        this.bizData = new GProBusinessData();
    }

    public GProBusinessData getBizData() {
        return this.bizData;
    }

    public long getChannelId() {
        return this.channelId;
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

    public String getJoinGuildSig() {
        return this.joinGuildSig;
    }

    public int getJoinedGuild() {
        return this.joinedGuild;
    }

    public int getMemberRole() {
        return this.memberRole;
    }

    public String getShareLink() {
        return this.shareLink;
    }

    public GProRecommendShareLive getShareLive() {
        return this.shareLive;
    }

    public int getShareTag() {
        return this.shareTag;
    }

    public int getShareType() {
        return this.shareType;
    }

    public String toString() {
        return "GProRecommendShareInfo{shareLink=" + this.shareLink + ",guildName=" + this.guildName + ",guildIcon=" + this.guildIcon + ",shareType=" + this.shareType + ",shareLive=" + this.shareLive + ",guildId=" + this.guildId + ",guildCoverUrl=" + this.guildCoverUrl + ",joinedGuild=" + this.joinedGuild + ",joinGuildSig=" + this.joinGuildSig + ",channelId=" + this.channelId + ",bizData=" + this.bizData + ",memberRole=" + this.memberRole + ",shareTag=" + this.shareTag + ",}";
    }

    public GProRecommendShareInfo(String str, String str2, String str3, int i3, GProRecommendShareLive gProRecommendShareLive, long j3, String str4, int i16, String str5, long j16, GProBusinessData gProBusinessData, int i17, int i18) {
        this.serialVersionUID = 1L;
        this.shareLink = "";
        this.guildName = "";
        this.guildIcon = "";
        this.shareLive = new GProRecommendShareLive();
        this.guildCoverUrl = "";
        this.joinGuildSig = "";
        new GProBusinessData();
        this.shareLink = str;
        this.guildName = str2;
        this.guildIcon = str3;
        this.shareType = i3;
        this.shareLive = gProRecommendShareLive;
        this.guildId = j3;
        this.guildCoverUrl = str4;
        this.joinedGuild = i16;
        this.joinGuildSig = str5;
        this.channelId = j16;
        this.bizData = gProBusinessData;
        this.memberRole = i17;
        this.shareTag = i18;
    }
}
