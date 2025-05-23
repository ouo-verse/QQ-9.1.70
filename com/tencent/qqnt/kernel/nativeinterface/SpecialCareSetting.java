package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class SpecialCareSetting {
    public boolean isOn;
    public boolean isRingOn;
    public boolean isZoneOn;

    public SpecialCareSetting() {
    }

    public boolean getIsOn() {
        return this.isOn;
    }

    public boolean getIsRingOn() {
        return this.isRingOn;
    }

    public boolean getIsZoneOn() {
        return this.isZoneOn;
    }

    public SpecialCareSetting(boolean z16, boolean z17, boolean z18) {
        this.isRingOn = z16;
        this.isZoneOn = z17;
        this.isOn = z18;
    }
}
