package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProScreenShareUser {
    public int state;
    public long tinyId;

    public GProScreenShareUser() {
    }

    public int getState() {
        return this.state;
    }

    public long getTinyId() {
        return this.tinyId;
    }

    public String toString() {
        return "GProScreenShareUser{tinyId=" + this.tinyId + ",state=" + this.state + ",}";
    }

    public GProScreenShareUser(long j3, int i3) {
        this.tinyId = j3;
        this.state = i3;
    }
}
