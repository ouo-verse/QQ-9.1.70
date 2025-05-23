package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProSlowModeInfo implements Serializable {
    public int slowModeCircle;
    public int slowModeKey;
    public int speakFrequency;
    long serialVersionUID = 1;
    public String slowModeText = "";

    public int getSlowModeCircle() {
        return this.slowModeCircle;
    }

    public int getSlowModeKey() {
        return this.slowModeKey;
    }

    public String getSlowModeText() {
        return this.slowModeText;
    }

    public int getSpeakFrequency() {
        return this.speakFrequency;
    }

    public String toString() {
        return "GProSlowModeInfo{slowModeKey=" + this.slowModeKey + ",speakFrequency=" + this.speakFrequency + ",slowModeCircle=" + this.slowModeCircle + ",slowModeText=" + this.slowModeText + ",}";
    }
}
