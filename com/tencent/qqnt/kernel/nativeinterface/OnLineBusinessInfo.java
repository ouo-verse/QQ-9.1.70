package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class OnLineBusinessInfo {
    public int bindUinNotifySwitch;
    public int kikPc;
    public int notifySwitch;

    public OnLineBusinessInfo() {
    }

    public int getBindUinNotifySwitch() {
        return this.bindUinNotifySwitch;
    }

    public int getKikPc() {
        return this.kikPc;
    }

    public int getNotifySwitch() {
        return this.notifySwitch;
    }

    public String toString() {
        return "OnLineBusinessInfo{kikPc=" + this.kikPc + ",notifySwitch=" + this.notifySwitch + ",bindUinNotifySwitch=" + this.bindUinNotifySwitch + ",}";
    }

    public OnLineBusinessInfo(int i3, int i16, int i17) {
        this.kikPc = i3;
        this.notifySwitch = i16;
        this.bindUinNotifySwitch = i17;
    }
}
