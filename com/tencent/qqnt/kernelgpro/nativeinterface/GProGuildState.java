package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProGuildState {
    public ArrayList<GProChannelState> channelStateList;
    public long guildId;
    public long stateSeq;
    public GProUserChannelState userChannelState;

    public GProGuildState() {
        this.channelStateList = new ArrayList<>();
        this.userChannelState = new GProUserChannelState();
    }

    public ArrayList<GProChannelState> getChannelStateList() {
        return this.channelStateList;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public long getStateSeq() {
        return this.stateSeq;
    }

    public GProUserChannelState getUserChannelState() {
        return this.userChannelState;
    }

    public String toString() {
        return "GProGuildState{guildId=" + this.guildId + ",channelStateList=" + this.channelStateList + ",stateSeq=" + this.stateSeq + ",userChannelState=" + this.userChannelState + ",}";
    }

    public GProGuildState(long j3, ArrayList<GProChannelState> arrayList, long j16, GProUserChannelState gProUserChannelState) {
        this.channelStateList = new ArrayList<>();
        new GProUserChannelState();
        this.guildId = j3;
        this.channelStateList = arrayList;
        this.stateSeq = j16;
        this.userChannelState = gProUserChannelState;
    }
}
