package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProFeedChannelStateInfo implements Serializable {
    public int priority;
    long serialVersionUID = 1;
    public int state;

    public int getPriority() {
        return this.priority;
    }

    public int getState() {
        return this.state;
    }

    public String toString() {
        return "GProFeedChannelStateInfo{state=" + this.state + ",priority=" + this.priority + ",}";
    }
}
