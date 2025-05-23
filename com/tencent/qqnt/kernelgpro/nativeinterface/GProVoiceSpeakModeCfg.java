package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProVoiceSpeakModeCfg implements Serializable {
    long serialVersionUID = 1;
    public int speakMode;
    public int speakSecond;

    public GProVoiceSpeakModeCfg() {
    }

    public int getSpeakMode() {
        return this.speakMode;
    }

    public int getSpeakSecond() {
        return this.speakSecond;
    }

    public void setSpeakMode(int i3) {
        this.speakMode = i3;
    }

    public void setSpeakSecond(int i3) {
        this.speakSecond = i3;
    }

    public String toString() {
        return "GProVoiceSpeakModeCfg{speakMode=" + this.speakMode + ",speakSecond=" + this.speakSecond + ",}";
    }

    public GProVoiceSpeakModeCfg(int i3, int i16) {
        this.speakMode = i3;
        this.speakSecond = i16;
    }
}
