package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProGuildMainFrameHeaderInfo {
    public GProGlobalBanner globalBannerInfo;
    public GProFaceAuthInfo guildCreatorFaceAuthInfo;
    public GProGuildCreatorTaskInfo guildCreatorTasks;
    public GProGuild guildInfo;
    public GProGuildNavigationInfo guildNavigationInfo;
    public GProRealTimeChannels realTimeChannelInfos;
    public GProRecentVisitChannelList recentVisitChannelList;
    public GProRecommendEssenceSvrRsp recommendEssence;

    public GProGuildMainFrameHeaderInfo() {
    }

    public GProGlobalBanner getGlobalBannerInfo() {
        return this.globalBannerInfo;
    }

    public GProFaceAuthInfo getGuildCreatorFaceAuthInfo() {
        return this.guildCreatorFaceAuthInfo;
    }

    public GProGuildCreatorTaskInfo getGuildCreatorTasks() {
        return this.guildCreatorTasks;
    }

    public GProGuild getGuildInfo() {
        return this.guildInfo;
    }

    public GProGuildNavigationInfo getGuildNavigationInfo() {
        return this.guildNavigationInfo;
    }

    public GProRealTimeChannels getRealTimeChannelInfos() {
        return this.realTimeChannelInfos;
    }

    public GProRecentVisitChannelList getRecentVisitChannelList() {
        return this.recentVisitChannelList;
    }

    public GProRecommendEssenceSvrRsp getRecommendEssence() {
        return this.recommendEssence;
    }

    public String toString() {
        return "GProGuildMainFrameHeaderInfo{guildInfo=" + this.guildInfo + ",guildCreatorTasks=" + this.guildCreatorTasks + ",guildCreatorFaceAuthInfo=" + this.guildCreatorFaceAuthInfo + ",recommendEssence=" + this.recommendEssence + ",globalBannerInfo=" + this.globalBannerInfo + ",guildNavigationInfo=" + this.guildNavigationInfo + ",recentVisitChannelList=" + this.recentVisitChannelList + ",realTimeChannelInfos=" + this.realTimeChannelInfos + ",}";
    }

    public GProGuildMainFrameHeaderInfo(GProGuild gProGuild, GProGuildCreatorTaskInfo gProGuildCreatorTaskInfo, GProFaceAuthInfo gProFaceAuthInfo, GProRecommendEssenceSvrRsp gProRecommendEssenceSvrRsp, GProGlobalBanner gProGlobalBanner, GProGuildNavigationInfo gProGuildNavigationInfo, GProRecentVisitChannelList gProRecentVisitChannelList, GProRealTimeChannels gProRealTimeChannels) {
        this.guildInfo = gProGuild;
        this.guildCreatorTasks = gProGuildCreatorTaskInfo;
        this.guildCreatorFaceAuthInfo = gProFaceAuthInfo;
        this.recommendEssence = gProRecommendEssenceSvrRsp;
        this.globalBannerInfo = gProGlobalBanner;
        this.guildNavigationInfo = gProGuildNavigationInfo;
        this.recentVisitChannelList = gProRecentVisitChannelList;
        this.realTimeChannelInfos = gProRealTimeChannels;
    }
}
