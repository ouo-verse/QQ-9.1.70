package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProChannelStateItemInfo implements Serializable {
    public int channelState;
    long serialVersionUID = 1;
    public int statePriority;

    public int getChannelState() {
        return this.channelState;
    }

    public int getStatePriority() {
        return this.statePriority;
    }

    public String toString() {
        return "GProChannelStateItemInfo{channelState=" + this.channelState + ",statePriority=" + this.statePriority + ",}";
    }
}
