package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProGuildSearchMsgGroupInfo {
    public long channelId;
    public long guildId;
    public long msgCnt;
    public String channelName = "";
    public GProGuildSearchGuildMsg data = new GProGuildSearchGuildMsg();
    public String summary = "";

    public long getChannelId() {
        return this.channelId;
    }

    public String getChannelName() {
        return this.channelName;
    }

    public GProGuildSearchGuildMsg getData() {
        return this.data;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public long getMsgCnt() {
        return this.msgCnt;
    }

    public String getSummary() {
        return this.summary;
    }

    public String toString() {
        return "GProGuildSearchMsgGroupInfo{guildId=" + this.guildId + ",channelId=" + this.channelId + ",channelName=" + this.channelName + ",msgCnt=" + this.msgCnt + ",data=" + this.data + ",summary=" + this.summary + ",}";
    }
}
