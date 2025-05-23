package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProRecommendChannelExtendInfo {
    public int areaType;
    public long channelId;
    public String channelLink;
    public int channelLinkType;
    public String guildFace;
    public int hideVisitorStyle;

    public GProRecommendChannelExtendInfo() {
        this.channelLink = "";
        this.guildFace = "";
    }

    public int getAreaType() {
        return this.areaType;
    }

    public long getChannelId() {
        return this.channelId;
    }

    public String getChannelLink() {
        return this.channelLink;
    }

    public int getChannelLinkType() {
        return this.channelLinkType;
    }

    public String getGuildFace() {
        return this.guildFace;
    }

    public int getHideVisitorStyle() {
        return this.hideVisitorStyle;
    }

    public String toString() {
        return "GProRecommendChannelExtendInfo{channelId=" + this.channelId + ",channelLink=" + this.channelLink + ",guildFace=" + this.guildFace + ",areaType=" + this.areaType + ",channelLinkType=" + this.channelLinkType + ",hideVisitorStyle=" + this.hideVisitorStyle + ",}";
    }

    public GProRecommendChannelExtendInfo(long j3, String str, String str2, int i3, int i16, int i17) {
        this.channelId = j3;
        this.channelLink = str;
        this.guildFace = str2;
        this.areaType = i3;
        this.channelLinkType = i16;
        this.hideVisitorStyle = i17;
    }
}
