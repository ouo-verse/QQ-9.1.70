package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProVoiceSmobaGameKickOutRoomReq {
    public long channelId;
    public int forceExit;
    public long guildId;
    public long roomId;
    public long second;
    public long tinyId;

    public GProVoiceSmobaGameKickOutRoomReq() {
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

    public long getRoomId() {
        return this.roomId;
    }

    public long getSecond() {
        return this.second;
    }

    public long getTinyId() {
        return this.tinyId;
    }

    public void setChannelId(long j3) {
        this.channelId = j3;
    }

    public void setForceExit(int i3) {
        this.forceExit = i3;
    }

    public void setGuildId(long j3) {
        this.guildId = j3;
    }

    public void setRoomId(long j3) {
        this.roomId = j3;
    }

    public void setSecond(long j3) {
        this.second = j3;
    }

    public void setTinyId(long j3) {
        this.tinyId = j3;
    }

    public String toString() {
        return "GProVoiceSmobaGameKickOutRoomReq{tinyId=" + this.tinyId + ",roomId=" + this.roomId + ",guildId=" + this.guildId + ",channelId=" + this.channelId + ",forceExit=" + this.forceExit + ",second=" + this.second + ",}";
    }

    public GProVoiceSmobaGameKickOutRoomReq(long j3, long j16, long j17, long j18, int i3, long j19) {
        this.tinyId = j3;
        this.roomId = j16;
        this.guildId = j17;
        this.channelId = j18;
        this.forceExit = i3;
        this.second = j19;
    }
}
