package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class SideBarConfig {
    public int barId;
    public SideBarStatus status;
    public int weight;

    public SideBarConfig() {
        this.status = SideBarStatus.values()[0];
    }

    public int getBarId() {
        return this.barId;
    }

    public SideBarStatus getStatus() {
        return this.status;
    }

    public int getWeight() {
        return this.weight;
    }

    public SideBarConfig(int i3, SideBarStatus sideBarStatus, int i16) {
        SideBarStatus sideBarStatus2 = SideBarStatus.values()[0];
        this.barId = i3;
        this.status = sideBarStatus;
        this.weight = i16;
    }
}
