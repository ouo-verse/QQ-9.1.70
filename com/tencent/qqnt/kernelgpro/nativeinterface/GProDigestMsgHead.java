package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProDigestMsgHead {
    public int bizType;
    public long channelId;
    public long createTimeMs;
    public long fromUin;
    public long guildId;
    public long uin;
    public long updateTimeMs;
    public String msgId = "";
    public GProMsgVisibility visibility = new GProMsgVisibility();

    public int getBizType() {
        return this.bizType;
    }

    public long getChannelId() {
        return this.channelId;
    }

    public long getCreateTimeMs() {
        return this.createTimeMs;
    }

    public long getFromUin() {
        return this.fromUin;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public String getMsgId() {
        return this.msgId;
    }

    public long getUin() {
        return this.uin;
    }

    public long getUpdateTimeMs() {
        return this.updateTimeMs;
    }

    public GProMsgVisibility getVisibility() {
        return this.visibility;
    }

    public String toString() {
        return "GProDigestMsgHead{msgId=" + this.msgId + ",bizType=" + this.bizType + ",createTimeMs=" + this.createTimeMs + ",updateTimeMs=" + this.updateTimeMs + ",fromUin=" + this.fromUin + ",uin=" + this.uin + ",guildId=" + this.guildId + ",channelId=" + this.channelId + ",visibility=" + this.visibility + ",}";
    }
}
