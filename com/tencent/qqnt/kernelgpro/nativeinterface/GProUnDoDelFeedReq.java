package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProUnDoDelFeedReq {
    public long channelId;
    public long createTime;
    public long guildId;
    public String feedId = "";
    public String userId = "";

    public long getChannelId() {
        return this.channelId;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public String getFeedId() {
        return this.feedId;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public String getUserId() {
        return this.userId;
    }

    public String toString() {
        return "GProUnDoDelFeedReq{feedId=" + this.feedId + ",createTime=" + this.createTime + ",userId=" + this.userId + ",guildId=" + this.guildId + ",channelId=" + this.channelId + ",}";
    }
}
