package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProGuildTaskJoinChannelRsp {
    public long channelId;
    public long guildId;
    public GProCmd0xf5dGuildInfo guildChannels = new GProCmd0xf5dGuildInfo();
    public GProGuild guildInfo = new GProGuild();

    public long getChannelId() {
        return this.channelId;
    }

    public GProCmd0xf5dGuildInfo getGuildChannels() {
        return this.guildChannels;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public GProGuild getGuildInfo() {
        return this.guildInfo;
    }

    public String toString() {
        return "GProGuildTaskJoinChannelRsp{guildChannels=" + this.guildChannels + ",guildInfo=" + this.guildInfo + ",guildId=" + this.guildId + ",channelId=" + this.channelId + ",}";
    }
}
