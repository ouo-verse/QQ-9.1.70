package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes24.dex */
public final class GProGuildRobotDownMicReq {
    public long channelId;
    public long guildId;
    public long robotTinyid;
    public long robotUin;

    public GProGuildRobotDownMicReq() {
    }

    public long getChannelId() {
        return this.channelId;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public long getRobotTinyid() {
        return this.robotTinyid;
    }

    public long getRobotUin() {
        return this.robotUin;
    }

    public String toString() {
        return "GProGuildRobotDownMicReq{guildId=" + this.guildId + ",channelId=" + this.channelId + ",robotUin=" + this.robotUin + ",robotTinyid=" + this.robotTinyid + ",}";
    }

    public GProGuildRobotDownMicReq(long j3, long j16, long j17, long j18) {
        this.guildId = j3;
        this.channelId = j16;
        this.robotUin = j17;
        this.robotTinyid = j18;
    }
}
