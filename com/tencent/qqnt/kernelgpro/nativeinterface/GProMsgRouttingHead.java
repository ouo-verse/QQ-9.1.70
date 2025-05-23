package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProMsgRouttingHead {
    public long channelId;
    public int directMsgFlag;
    public long fromTinyid;
    public long fromUin;
    public long guildCode;
    public long guildId;

    public GProMsgRouttingHead() {
    }

    public long getChannelId() {
        return this.channelId;
    }

    public int getDirectMsgFlag() {
        return this.directMsgFlag;
    }

    public long getFromTinyid() {
        return this.fromTinyid;
    }

    public long getFromUin() {
        return this.fromUin;
    }

    public long getGuildCode() {
        return this.guildCode;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public String toString() {
        return "GProMsgRouttingHead{guildId=" + this.guildId + ",channelId=" + this.channelId + ",fromUin=" + this.fromUin + ",fromTinyid=" + this.fromTinyid + ",guildCode=" + this.guildCode + ",directMsgFlag=" + this.directMsgFlag + ",}";
    }

    public GProMsgRouttingHead(long j3, long j16, long j17, long j18, long j19, int i3) {
        this.guildId = j3;
        this.channelId = j16;
        this.fromUin = j17;
        this.fromTinyid = j18;
        this.guildCode = j19;
        this.directMsgFlag = i3;
    }
}
