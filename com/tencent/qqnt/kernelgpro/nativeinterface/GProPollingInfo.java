package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProPollingInfo {
    public long channelId;
    public long guildId;
    public int pollingType;
    public ArrayList<Integer> pollingTypes = new ArrayList<>();
    public int source;

    public GProPollingInfo() {
    }

    public long getChannelId() {
        return this.channelId;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public int getPollingType() {
        return this.pollingType;
    }

    public ArrayList<Integer> getPollingTypes() {
        return this.pollingTypes;
    }

    public int getSource() {
        return this.source;
    }

    public String toString() {
        return "GProPollingInfo{guildId=" + this.guildId + ",channelId=" + this.channelId + ",pollingType=" + this.pollingType + ",pollingTypes=" + this.pollingTypes + ",source=" + this.source + ",}";
    }

    public GProPollingInfo(long j3, long j16, int i3, int i16) {
        this.guildId = j3;
        this.channelId = j16;
        this.pollingType = i3;
        this.source = i16;
    }
}
