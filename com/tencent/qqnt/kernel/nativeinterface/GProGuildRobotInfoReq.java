package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes24.dex */
public final class GProGuildRobotInfoReq {
    public long channelId;
    public GProGuildRobotClientInfo clientInfo;
    public long featureScene;
    public int fetchScene;
    public long guildId;
    public long robotAppid;
    public long robotTid;
    public long robotUin;

    public GProGuildRobotInfoReq() {
        this.clientInfo = new GProGuildRobotClientInfo();
    }

    public long getChannelId() {
        return this.channelId;
    }

    public GProGuildRobotClientInfo getClientInfo() {
        return this.clientInfo;
    }

    public long getFeatureScene() {
        return this.featureScene;
    }

    public int getFetchScene() {
        return this.fetchScene;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public long getRobotAppid() {
        return this.robotAppid;
    }

    public long getRobotTid() {
        return this.robotTid;
    }

    public long getRobotUin() {
        return this.robotUin;
    }

    public String toString() {
        return "GProGuildRobotInfoReq{guildId=" + this.guildId + ",robotUin=" + this.robotUin + ",robotTid=" + this.robotTid + ",channelId=" + this.channelId + ",clientInfo=" + this.clientInfo + ",fetchScene=" + this.fetchScene + ",featureScene=" + this.featureScene + ",robotAppid=" + this.robotAppid + ",}";
    }

    public GProGuildRobotInfoReq(long j3, long j16, long j17, long j18, GProGuildRobotClientInfo gProGuildRobotClientInfo, int i3, long j19, long j26) {
        new GProGuildRobotClientInfo();
        this.guildId = j3;
        this.robotUin = j16;
        this.robotTid = j17;
        this.channelId = j18;
        this.clientInfo = gProGuildRobotClientInfo;
        this.fetchScene = i3;
        this.featureScene = j19;
        this.robotAppid = j26;
    }
}
