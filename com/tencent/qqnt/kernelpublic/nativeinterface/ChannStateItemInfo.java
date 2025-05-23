package com.tencent.qqnt.kernelpublic.nativeinterface;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class ChannStateItemInfo implements Serializable {
    public int channelState;
    public String channelStateStr;
    public int priority;
    long serialVersionUID;
    public long updateTs;

    public ChannStateItemInfo() {
        this.serialVersionUID = 1L;
        this.channelStateStr = "";
    }

    public int getChannelState() {
        return this.channelState;
    }

    public String getChannelStateStr() {
        return this.channelStateStr;
    }

    public int getPriority() {
        return this.priority;
    }

    public long getUpdateTs() {
        return this.updateTs;
    }

    public String toString() {
        return "ChannStateItemInfo{channelState=" + this.channelState + ",priority=" + this.priority + ",updateTs=" + this.updateTs + ",channelStateStr=" + this.channelStateStr + ",}";
    }

    public ChannStateItemInfo(int i3, int i16, long j3, String str) {
        this.serialVersionUID = 1L;
        this.channelState = i3;
        this.priority = i16;
        this.updateTs = j3;
        this.channelStateStr = str;
    }
}
