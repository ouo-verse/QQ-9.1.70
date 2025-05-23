package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProSpeakTimeCtl implements Serializable {
    public int queueSpeakS;
    long serialVersionUID = 1;
    public long startSpeakMs;
    public long stopSpeakMs;

    public GProSpeakTimeCtl() {
    }

    public int getQueueSpeakS() {
        return this.queueSpeakS;
    }

    public long getStartSpeakMs() {
        return this.startSpeakMs;
    }

    public long getStopSpeakMs() {
        return this.stopSpeakMs;
    }

    public String toString() {
        return "GProSpeakTimeCtl{startSpeakMs=" + this.startSpeakMs + ",stopSpeakMs=" + this.stopSpeakMs + ",queueSpeakS=" + this.queueSpeakS + ",}";
    }

    public GProSpeakTimeCtl(long j3, long j16, int i3) {
        this.startSpeakMs = j3;
        this.stopSpeakMs = j16;
        this.queueSpeakS = i3;
    }
}
