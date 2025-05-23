package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProVoiceSmobaGameBaseRoomInfo {
    public long captainTinyId;
    public long channelId;
    public long guildId;
    public long roomId;
    public int roomType;

    public GProVoiceSmobaGameBaseRoomInfo() {
    }

    public long getCaptainTinyId() {
        return this.captainTinyId;
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

    public int getRoomType() {
        return this.roomType;
    }

    public String toString() {
        return "GProVoiceSmobaGameBaseRoomInfo{roomId=" + this.roomId + ",roomType=" + this.roomType + ",guildId=" + this.guildId + ",channelId=" + this.channelId + ",captainTinyId=" + this.captainTinyId + ",}";
    }

    public GProVoiceSmobaGameBaseRoomInfo(long j3, int i3, long j16, long j17, long j18) {
        this.roomId = j3;
        this.roomType = i3;
        this.guildId = j16;
        this.channelId = j17;
        this.captainTinyId = j18;
    }
}
