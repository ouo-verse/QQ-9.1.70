package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProGetImmersiveFeedsReq {
    public long channelId;
    public int count;
    public int from;
    public long guildId;
    public long topicId;
    public byte[] attachInfo = new byte[0];
    public String feedId = "";
    public byte[] visitorMsg = new byte[0];
    public String sessionId = "";

    public byte[] getAttachInfo() {
        return this.attachInfo;
    }

    public long getChannelId() {
        return this.channelId;
    }

    public int getCount() {
        return this.count;
    }

    public String getFeedId() {
        return this.feedId;
    }

    public int getFrom() {
        return this.from;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public long getTopicId() {
        return this.topicId;
    }

    public byte[] getVisitorMsg() {
        return this.visitorMsg;
    }

    public String toString() {
        return "GProGetImmersiveFeedsReq{from=" + this.from + ",guildId=" + this.guildId + ",channelId=" + this.channelId + ",count=" + this.count + ",attachInfo=" + this.attachInfo + ",feedId=" + this.feedId + ",visitorMsg=" + this.visitorMsg + ",topicId=" + this.topicId + ",sessionId=" + this.sessionId + ",}";
    }
}
