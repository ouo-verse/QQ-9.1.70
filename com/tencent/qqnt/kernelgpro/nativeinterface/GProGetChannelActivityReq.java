package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProGetChannelActivityReq {
    public int channelType;
    public long guildId;

    public GProGetChannelActivityReq() {
    }

    public int getChannelType() {
        return this.channelType;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public void setChannelType(int i3) {
        this.channelType = i3;
    }

    public void setGuildId(long j3) {
        this.guildId = j3;
    }

    public String toString() {
        return "GProGetChannelActivityReq{guildId=" + this.guildId + ",channelType=" + this.channelType + ",}";
    }

    public GProGetChannelActivityReq(long j3, int i3) {
        this.guildId = j3;
        this.channelType = i3;
    }
}
