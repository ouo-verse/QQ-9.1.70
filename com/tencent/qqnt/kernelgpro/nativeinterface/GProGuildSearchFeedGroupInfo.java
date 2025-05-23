package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProGuildSearchFeedGroupInfo {
    public long channelId;
    public String channelName = "";
    public long feedCnt;
    public long guildId;

    public long getChannelId() {
        return this.channelId;
    }

    public String getChannelName() {
        return this.channelName;
    }

    public long getFeedCnt() {
        return this.feedCnt;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public String toString() {
        return "GProGuildSearchFeedGroupInfo{guildId=" + this.guildId + ",channelId=" + this.channelId + ",channelName=" + this.channelName + ",feedCnt=" + this.feedCnt + ",}";
    }
}
