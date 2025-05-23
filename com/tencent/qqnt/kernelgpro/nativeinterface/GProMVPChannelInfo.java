package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProMVPChannelInfo {
    public long channelId;
    public long guildId;
    public byte[] joinGuildSign = new byte[0];

    public long getChannelId() {
        return this.channelId;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public byte[] getJoinGuildSign() {
        return this.joinGuildSign;
    }

    public String toString() {
        return "GProMVPChannelInfo{guildId=" + this.guildId + ",channelId=" + this.channelId + ",joinGuildSign=" + this.joinGuildSign + ",}";
    }
}
