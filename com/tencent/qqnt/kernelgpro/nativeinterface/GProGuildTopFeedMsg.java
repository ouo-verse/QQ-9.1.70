package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProGuildTopFeedMsg {
    public int action;
    public long channelId;
    public long guildId;
    public long readTimestamp;
    public GProTopFeedMsg topFeedMsg = new GProTopFeedMsg();
    public String recallFeedId = "";

    public int getAction() {
        return this.action;
    }

    public long getChannelId() {
        return this.channelId;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public long getReadTimestamp() {
        return this.readTimestamp;
    }

    public String getRecallFeedId() {
        return this.recallFeedId;
    }

    public GProTopFeedMsg getTopFeedMsg() {
        return this.topFeedMsg;
    }

    public String toString() {
        return "GProGuildTopFeedMsg{guildId=" + this.guildId + ",action=" + this.action + ",readTimestamp=" + this.readTimestamp + ",topFeedMsg=" + this.topFeedMsg + ",recallFeedId=" + this.recallFeedId + ",channelId=" + this.channelId + ",}";
    }
}
