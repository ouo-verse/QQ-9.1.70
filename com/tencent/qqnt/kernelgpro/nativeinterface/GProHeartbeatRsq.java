package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProHeartbeatRsq implements Serializable {
    public GProAVChannelConfig avChannelConfig;
    public long channelId;
    public int forceExit;
    public long guildId;
    public long nextHeartBeatInterval;
    public long noStreamDisconnectTrtcSecond;
    long serialVersionUID;
    public String showTips;

    public GProHeartbeatRsq() {
        this.serialVersionUID = 1L;
        this.showTips = "";
        this.avChannelConfig = new GProAVChannelConfig();
    }

    public GProAVChannelConfig getAvChannelConfig() {
        return this.avChannelConfig;
    }

    public long getChannelId() {
        return this.channelId;
    }

    public int getForceExit() {
        return this.forceExit;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public long getNextHeartBeatInterval() {
        return this.nextHeartBeatInterval;
    }

    public long getNoStreamDisconnectTrtcSecond() {
        return this.noStreamDisconnectTrtcSecond;
    }

    public String getShowTips() {
        return this.showTips;
    }

    public String toString() {
        return "GProHeartbeatRsq{guildId=" + this.guildId + ",channelId=" + this.channelId + ",nextHeartBeatInterval=" + this.nextHeartBeatInterval + ",forceExit=" + this.forceExit + ",showTips=" + this.showTips + ",avChannelConfig=" + this.avChannelConfig + ",noStreamDisconnectTrtcSecond=" + this.noStreamDisconnectTrtcSecond + ",}";
    }

    public GProHeartbeatRsq(long j3, long j16, long j17, int i3, String str, GProAVChannelConfig gProAVChannelConfig, long j18) {
        this.serialVersionUID = 1L;
        this.showTips = "";
        new GProAVChannelConfig();
        this.guildId = j3;
        this.channelId = j16;
        this.nextHeartBeatInterval = j17;
        this.forceExit = i3;
        this.showTips = str;
        this.avChannelConfig = gProAVChannelConfig;
        this.noStreamDisconnectTrtcSecond = j18;
    }
}
