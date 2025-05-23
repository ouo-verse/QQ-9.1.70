package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProMoveFeedReq {
    public long channelId;
    public String feedId = "";
    public long guildId;
    public long originalChannelId;

    public long getChannelId() {
        return this.channelId;
    }

    public String getFeedId() {
        return this.feedId;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public long getOriginalChannelId() {
        return this.originalChannelId;
    }

    public String toString() {
        return "GProMoveFeedReq{guildId=" + this.guildId + ",channelId=" + this.channelId + ",originalChannelId=" + this.originalChannelId + ",feedId=" + this.feedId + ",}";
    }
}
