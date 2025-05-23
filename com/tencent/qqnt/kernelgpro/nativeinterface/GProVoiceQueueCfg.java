package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProVoiceQueueCfg implements Serializable {
    long serialVersionUID = 1;
    public int voiceQueueState;

    public GProVoiceQueueCfg() {
    }

    public int getVoiceQueueState() {
        return this.voiceQueueState;
    }

    public void setVoiceQueueState(int i3) {
        this.voiceQueueState = i3;
    }

    public String toString() {
        return "GProVoiceQueueCfg{voiceQueueState=" + this.voiceQueueState + ",}";
    }

    public GProVoiceQueueCfg(int i3) {
        this.voiceQueueState = i3;
    }
}
