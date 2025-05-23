package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProGuildChannelState implements Serializable {
    public int state;
    long serialVersionUID = 1;
    public String desc = "";

    public String getDesc() {
        return this.desc;
    }

    public int getState() {
        return this.state;
    }

    public String toString() {
        return "GProGuildChannelState{state=" + this.state + ",desc=" + this.desc + ",}";
    }
}
