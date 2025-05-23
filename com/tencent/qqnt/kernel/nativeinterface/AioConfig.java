package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class AioConfig {
    public int supportAutoTts;
    public int supportHalfScreenSwitch;
    public int supportNewInteraction;
    public int supportWideScreen;

    public int getSupportAutoTts() {
        return this.supportAutoTts;
    }

    public int getSupportHalfScreenSwitch() {
        return this.supportHalfScreenSwitch;
    }

    public int getSupportNewInteraction() {
        return this.supportNewInteraction;
    }

    public int getSupportWideScreen() {
        return this.supportWideScreen;
    }

    public String toString() {
        return "AioConfig{supportHalfScreenSwitch=" + this.supportHalfScreenSwitch + ",supportAutoTts=" + this.supportAutoTts + ",supportNewInteraction=" + this.supportNewInteraction + ",supportWideScreen=" + this.supportWideScreen + ",}";
    }
}
