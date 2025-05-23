package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class BatteryStatus {
    public boolean chargingState;
    public int percent;

    public BatteryStatus() {
    }

    public boolean getChargingState() {
        return this.chargingState;
    }

    public int getPercent() {
        return this.percent;
    }

    public String toString() {
        return "BatteryStatus{percent=" + this.percent + ",chargingState=" + this.chargingState + ",}";
    }

    public BatteryStatus(int i3, boolean z16) {
        this.percent = i3;
        this.chargingState = z16;
    }
}
