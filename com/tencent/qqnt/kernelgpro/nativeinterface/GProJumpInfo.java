package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProJumpInfo implements Serializable {
    public long channel;
    long serialVersionUID = 1;
    public int uint32Switch;

    public long getChannel() {
        return this.channel;
    }

    public int getUint32Switch() {
        return this.uint32Switch;
    }

    public void setChannel(long j3) {
        this.channel = j3;
    }

    public void setUint32Switch(int i3) {
        this.uint32Switch = i3;
    }

    public String toString() {
        return "GProJumpInfo{uint32Switch=" + this.uint32Switch + ",channel=" + this.channel + ",}";
    }
}
