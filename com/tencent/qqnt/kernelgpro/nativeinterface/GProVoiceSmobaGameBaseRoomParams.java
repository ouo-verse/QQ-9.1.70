package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProVoiceSmobaGameBaseRoomParams {
    public long channelId;
    public long guildId;
    public int roomType;

    public GProVoiceSmobaGameBaseRoomParams() {
    }

    public long getChannelId() {
        return this.channelId;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public int getRoomType() {
        return this.roomType;
    }

    public void setChannelId(long j3) {
        this.channelId = j3;
    }

    public void setGuildId(long j3) {
        this.guildId = j3;
    }

    public void setRoomType(int i3) {
        this.roomType = i3;
    }

    public String toString() {
        return "GProVoiceSmobaGameBaseRoomParams{roomType=" + this.roomType + ",guildId=" + this.guildId + ",channelId=" + this.channelId + ",}";
    }

    public GProVoiceSmobaGameBaseRoomParams(int i3, long j3, long j16) {
        this.roomType = i3;
        this.guildId = j3;
        this.channelId = j16;
    }
}
