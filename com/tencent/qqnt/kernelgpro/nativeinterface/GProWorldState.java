package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProWorldState {
    public long channelId;
    public long guildId;
    public byte[] roomChange = new byte[0];

    public long getChannelId() {
        return this.channelId;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public byte[] getRoomChange() {
        return this.roomChange;
    }

    public String toString() {
        return "GProWorldState{guildId=" + this.guildId + ",channelId=" + this.channelId + ",roomChange=" + this.roomChange + ",}";
    }
}
