package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProAuthControlSwitchInfo {
    public int authControlSwitchType;
    public int changePermission;

    public GProAuthControlSwitchInfo() {
    }

    public int getAuthControlSwitchType() {
        return this.authControlSwitchType;
    }

    public int getChangePermission() {
        return this.changePermission;
    }

    public String toString() {
        return "GProAuthControlSwitchInfo{authControlSwitchType=" + this.authControlSwitchType + ",changePermission=" + this.changePermission + ",}";
    }

    public GProAuthControlSwitchInfo(int i3, int i16) {
        this.authControlSwitchType = i3;
        this.changePermission = i16;
    }
}
