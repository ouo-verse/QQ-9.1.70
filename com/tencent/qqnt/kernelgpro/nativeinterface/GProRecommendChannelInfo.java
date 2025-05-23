package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProRecommendChannelInfo implements Serializable {
    public long channelId;
    public String channelName;
    public int channelType;
    public String coverUrl;
    public String guildIcon;
    public long guildId;
    public String guildName;
    public String guildNumber;
    public String guildProfile;
    public int isWhole;
    public int isXWorldGuild;
    public String itemId;
    public String joinGuildSig;
    public int joinedGuild;
    public ArrayList<GProMedalInfo> medalInfoList;
    public int medalLevel;
    public int memberRole;
    public GProRecommendSeqInfo seqInfo;
    long serialVersionUID;
    public String shareLink;
    public int shareTag;
    public ArrayList<GProRecommendGuildState> stateList;
    public ArrayList<GProRecommendLabel> tagList;
    public String titleName;
    public long unreadAtMeCount;

    public GProRecommendChannelInfo() {
        this.serialVersionUID = 1L;
        this.guildName = "";
        this.guildIcon = "";
        this.guildProfile = "";
        this.stateList = new ArrayList<>();
        this.shareLink = "";
        this.coverUrl = "";
        this.joinGuildSig = "";
        this.channelName = "";
        this.itemId = "";
        this.tagList = new ArrayList<>();
        this.seqInfo = new GProRecommendSeqInfo();
        this.guildNumber = "";
        this.titleName = "";
        this.medalInfoList = new ArrayList<>();
    }

    public long getChannelId() {
        return this.channelId;
    }

    public String getChannelName() {
        return this.channelName;
    }

    public int getChannelType() {
        return this.channelType;
    }

    public String getCoverUrl() {
        return this.coverUrl;
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

    public String getGuildNumber() {
        return this.guildNumber;
    }

    public String getGuildProfile() {
        return this.guildProfile;
    }

    public int getIsWhole() {
        return this.isWhole;
    }

    public int getIsXWorldGuild() {
        return this.isXWorldGuild;
    }

    public String getItemId() {
        return this.itemId;
    }

    public String getJoinGuildSig() {
        return this.joinGuildSig;
    }

    public int getJoinedGuild() {
        return this.joinedGuild;
    }

    public ArrayList<GProMedalInfo> getMedalInfoList() {
        return this.medalInfoList;
    }

    public int getMedalLevel() {
        return this.medalLevel;
    }

    public int getMemberRole() {
        return this.memberRole;
    }

    public GProRecommendSeqInfo getSeqInfo() {
        return this.seqInfo;
    }

    public String getShareLink() {
        return this.shareLink;
    }

    public int getShareTag() {
        return this.shareTag;
    }

    public ArrayList<GProRecommendGuildState> getStateList() {
        return this.stateList;
    }

    public ArrayList<GProRecommendLabel> getTagList() {
        return this.tagList;
    }

    public String getTitleName() {
        return this.titleName;
    }

    public long getUnreadAtMeCount() {
        return this.unreadAtMeCount;
    }

    public String toString() {
        return "GProRecommendChannelInfo{guildId=" + this.guildId + ",guildName=" + this.guildName + ",guildIcon=" + this.guildIcon + ",guildProfile=" + this.guildProfile + ",stateList=" + this.stateList + ",shareLink=" + this.shareLink + ",joinedGuild=" + this.joinedGuild + ",coverUrl=" + this.coverUrl + ",joinGuildSig=" + this.joinGuildSig + ",memberRole=" + this.memberRole + ",channelId=" + this.channelId + ",channelName=" + this.channelName + ",channelType=" + this.channelType + ",itemId=" + this.itemId + ",tagList=" + this.tagList + ",seqInfo=" + this.seqInfo + ",guildNumber=" + this.guildNumber + ",medalLevel=" + this.medalLevel + ",titleName=" + this.titleName + ",shareTag=" + this.shareTag + ",isWhole=" + this.isWhole + ",unreadAtMeCount=" + this.unreadAtMeCount + ",medalInfoList=" + this.medalInfoList + ",isXWorldGuild=" + this.isXWorldGuild + ",}";
    }

    public GProRecommendChannelInfo(long j3, String str, String str2, String str3, ArrayList<GProRecommendGuildState> arrayList, String str4, int i3, String str5, String str6, int i16, long j16, String str7, int i17, String str8, ArrayList<GProRecommendLabel> arrayList2, GProRecommendSeqInfo gProRecommendSeqInfo, String str9, int i18, String str10, int i19, int i26, long j17, ArrayList<GProMedalInfo> arrayList3) {
        this.serialVersionUID = 1L;
        this.guildName = "";
        this.guildIcon = "";
        this.guildProfile = "";
        this.stateList = new ArrayList<>();
        this.shareLink = "";
        this.coverUrl = "";
        this.joinGuildSig = "";
        this.channelName = "";
        this.itemId = "";
        this.tagList = new ArrayList<>();
        this.seqInfo = new GProRecommendSeqInfo();
        this.guildNumber = "";
        this.titleName = "";
        new ArrayList();
        this.guildId = j3;
        this.guildName = str;
        this.guildIcon = str2;
        this.guildProfile = str3;
        this.stateList = arrayList;
        this.shareLink = str4;
        this.joinedGuild = i3;
        this.coverUrl = str5;
        this.joinGuildSig = str6;
        this.memberRole = i16;
        this.channelId = j16;
        this.channelName = str7;
        this.channelType = i17;
        this.itemId = str8;
        this.tagList = arrayList2;
        this.seqInfo = gProRecommendSeqInfo;
        this.guildNumber = str9;
        this.medalLevel = i18;
        this.titleName = str10;
        this.shareTag = i19;
        this.isWhole = i26;
        this.unreadAtMeCount = j17;
        this.medalInfoList = arrayList3;
    }
}
