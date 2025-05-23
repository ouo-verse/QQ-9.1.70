package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProGuildUserState {
    public long channelId;
    public long guildId;
    public boolean hasEnteredChannel;

    public GProGuildUserState() {
    }

    public long getChannelId() {
        return this.channelId;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public boolean getHasEnteredChannel() {
        return this.hasEnteredChannel;
    }

    public String toString() {
        return "GProGuildUserState{guildId=" + this.guildId + ",channelId=" + this.channelId + ",hasEnteredChannel=" + this.hasEnteredChannel + ",}";
    }

    public GProGuildUserState(long j3, long j16, boolean z16) {
        this.guildId = j3;
        this.channelId = j16;
        this.hasEnteredChannel = z16;
    }
}
