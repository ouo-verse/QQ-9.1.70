package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProSwitchInfo implements Serializable {
    public int closeReason;
    long serialVersionUID = 1;
    public int switchState;
    public int switchType;

    public GProSwitchInfo() {
    }

    public int getCloseReason() {
        return this.closeReason;
    }

    public int getSwitchState() {
        return this.switchState;
    }

    public int getSwitchType() {
        return this.switchType;
    }

    public String toString() {
        return "GProSwitchInfo{switchType=" + this.switchType + ",switchState=" + this.switchState + ",closeReason=" + this.closeReason + ",}";
    }

    public GProSwitchInfo(int i3, int i16, int i17) {
        this.switchType = i3;
        this.switchState = i16;
        this.closeReason = i17;
    }
}
