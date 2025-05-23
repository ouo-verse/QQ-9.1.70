package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProVoiceSmobaGameDissmissRoomReq {
    public long channelId;
    public long guildId;
    public long roomId;
    public int source;

    public GProVoiceSmobaGameDissmissRoomReq() {
    }

    public long getChannelId() {
        return this.channelId;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public long getRoomId() {
        return this.roomId;
    }

    public int getSource() {
        return this.source;
    }

    public void setChannelId(long j3) {
        this.channelId = j3;
    }

    public void setGuildId(long j3) {
        this.guildId = j3;
    }

    public void setRoomId(long j3) {
        this.roomId = j3;
    }

    public void setSource(int i3) {
        this.source = i3;
    }

    public String toString() {
        return "GProVoiceSmobaGameDissmissRoomReq{roomId=" + this.roomId + ",guildId=" + this.guildId + ",channelId=" + this.channelId + ",source=" + this.source + ",}";
    }

    public GProVoiceSmobaGameDissmissRoomReq(long j3, long j16, long j17, int i3) {
        this.roomId = j3;
        this.guildId = j16;
        this.channelId = j17;
        this.source = i3;
    }
}
