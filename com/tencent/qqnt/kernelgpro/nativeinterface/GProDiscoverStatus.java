package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProDiscoverStatus implements Serializable {
    public int nextTs;
    long serialVersionUID = 1;
    public int state;
    public int type;

    public GProDiscoverStatus() {
    }

    public int getNextTs() {
        return this.nextTs;
    }

    public int getState() {
        return this.state;
    }

    public int getType() {
        return this.type;
    }

    public String toString() {
        return "GProDiscoverStatus{type=" + this.type + ",state=" + this.state + ",nextTs=" + this.nextTs + ",}";
    }

    public GProDiscoverStatus(int i3, int i16, int i17) {
        this.type = i3;
        this.state = i16;
        this.nextTs = i17;
    }
}
