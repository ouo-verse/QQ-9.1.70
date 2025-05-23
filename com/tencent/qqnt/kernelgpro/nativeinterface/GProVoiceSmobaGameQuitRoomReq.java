package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProVoiceSmobaGameQuitRoomReq {
    public long channelId;
    public int forceExit;
    public long guildId;
    public long roomId;

    public GProVoiceSmobaGameQuitRoomReq() {
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

    public String toString() {
        return "GProVoiceSmobaGameQuitRoomReq{roomId=" + this.roomId + ",guildId=" + this.guildId + ",channelId=" + this.channelId + ",forceExit=" + this.forceExit + ",}";
    }

    public GProVoiceSmobaGameQuitRoomReq(long j3, long j16, long j17, int i3) {
        this.roomId = j3;
        this.guildId = j16;
        this.channelId = j17;
        this.forceExit = i3;
    }
}
