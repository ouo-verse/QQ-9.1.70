package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes24.dex */
public final class GProGuildRobotInlineSearchReq {
    public long botTinyid;
    public long channelId;
    public long guildId;
    public String keyword;

    public GProGuildRobotInlineSearchReq() {
        this.keyword = "";
    }

    public long getBotTinyid() {
        return this.botTinyid;
    }

    public long getChannelId() {
        return this.channelId;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public String getKeyword() {
        return this.keyword;
    }

    public String toString() {
        return "GProGuildRobotInlineSearchReq{guildId=" + this.guildId + ",channelId=" + this.channelId + ",botTinyid=" + this.botTinyid + ",keyword=" + this.keyword + ",}";
    }

    public GProGuildRobotInlineSearchReq(long j3, long j16, long j17, String str) {
        this.guildId = j3;
        this.channelId = j16;
        this.botTinyid = j17;
        this.keyword = str;
    }
}
