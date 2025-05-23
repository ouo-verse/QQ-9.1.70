package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProPollingChannelState {
    public long channelId;
    public long guildId;
    public int source;
    public int type;
    public long updateTime;
    public GProChannelMemberInfos voiceChannelPresence = new GProChannelMemberInfos();
    public GProLiveRoomInfo liveChannelPresence = new GProLiveRoomInfo();
    public GProAppChnnPreInfo appChannelPresence = new GProAppChnnPreInfo();
    public GProGlobalBanner guildGlobalBanner = new GProGlobalBanner();
    public GProCreateGuildGuideInfo createGuildGuideInfo = new GProCreateGuildGuideInfo();
    public GProOnlineMemberInfo onlineMemberInfo = new GProOnlineMemberInfo();
    public GProRecommendEssenceSvrRsp recommendEssence = new GProRecommendEssenceSvrRsp();
    public GProChannel channelInfo = new GProChannel();
    public GProGuildNavigationInfo guildNavigation = new GProGuildNavigationInfo();
    public GProRecentVisitChannelList recentVisitChannelList = new GProRecentVisitChannelList();
    public GProRealTimeChannels realTimeChannelList = new GProRealTimeChannels();
    public GProSchedulePollingInfo schedulePollingInfo = new GProSchedulePollingInfo();

    public GProAppChnnPreInfo getAppChannelPresence() {
        return this.appChannelPresence;
    }

    public long getChannelId() {
        return this.channelId;
    }

    public GProChannel getChannelInfo() {
        return this.channelInfo;
    }

    public GProCreateGuildGuideInfo getCreateGuildGuideInfo() {
        return this.createGuildGuideInfo;
    }

    public GProGlobalBanner getGuildGlobalBanner() {
        return this.guildGlobalBanner;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public GProGuildNavigationInfo getGuildNavigation() {
        return this.guildNavigation;
    }

    public GProLiveRoomInfo getLiveChannelPresence() {
        return this.liveChannelPresence;
    }

    public GProOnlineMemberInfo getOnlineMemberInfo() {
        return this.onlineMemberInfo;
    }

    public GProRealTimeChannels getRealTimeChannelList() {
        return this.realTimeChannelList;
    }

    public GProRecentVisitChannelList getRecentVisitChannelList() {
        return this.recentVisitChannelList;
    }

    public GProRecommendEssenceSvrRsp getRecommendEssence() {
        return this.recommendEssence;
    }

    public GProSchedulePollingInfo getSchedulePollingInfo() {
        return this.schedulePollingInfo;
    }

    public int getSource() {
        return this.source;
    }

    public int getType() {
        return this.type;
    }

    public long getUpdateTime() {
        return this.updateTime;
    }

    public GProChannelMemberInfos getVoiceChannelPresence() {
        return this.voiceChannelPresence;
    }

    public String toString() {
        return "GProPollingChannelState{guildId=" + this.guildId + ",channelId=" + this.channelId + ",type=" + this.type + ",updateTime=" + this.updateTime + ",source=" + this.source + ",voiceChannelPresence=" + this.voiceChannelPresence + ",liveChannelPresence=" + this.liveChannelPresence + ",appChannelPresence=" + this.appChannelPresence + ",guildGlobalBanner=" + this.guildGlobalBanner + ",createGuildGuideInfo=" + this.createGuildGuideInfo + ",onlineMemberInfo=" + this.onlineMemberInfo + ",recommendEssence=" + this.recommendEssence + ",channelInfo=" + this.channelInfo + ",guildNavigation=" + this.guildNavigation + ",recentVisitChannelList=" + this.recentVisitChannelList + ",realTimeChannelList=" + this.realTimeChannelList + ",schedulePollingInfo=" + this.schedulePollingInfo + ",}";
    }
}
