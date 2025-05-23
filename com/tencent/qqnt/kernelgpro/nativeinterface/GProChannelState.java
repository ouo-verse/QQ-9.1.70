package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProChannelState implements Serializable {
    public long channelId;
    public int channelState;
    public long channelStateSeq;
    public int channelType;
    public long guildId;
    long serialVersionUID = 1;
    public ArrayList<GProChannelStateItemInfo> channelStateList = new ArrayList<>();

    public long getChannelId() {
        return this.channelId;
    }

    public int getChannelState() {
        return this.channelState;
    }

    public ArrayList<GProChannelStateItemInfo> getChannelStateList() {
        return this.channelStateList;
    }

    public long getChannelStateSeq() {
        return this.channelStateSeq;
    }

    public int getChannelType() {
        return this.channelType;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public String toString() {
        return "GProChannelState{guildId=" + this.guildId + ",channelId=" + this.channelId + ",channelState=" + this.channelState + ",channelType=" + this.channelType + ",channelStateList=" + this.channelStateList + ",channelStateSeq=" + this.channelStateSeq + ",}";
    }
}
