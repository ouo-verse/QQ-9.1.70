package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProBindMembers {
    public int authControlSwitchType;
    public ArrayList<Long> memberIds;

    public GProBindMembers() {
        this.memberIds = new ArrayList<>();
    }

    public int getAuthControlSwitchType() {
        return this.authControlSwitchType;
    }

    public ArrayList<Long> getMemberIds() {
        return this.memberIds;
    }

    public String toString() {
        return "GProBindMembers{authControlSwitchType=" + this.authControlSwitchType + ",memberIds=" + this.memberIds + ",}";
    }

    public GProBindMembers(int i3, ArrayList<Long> arrayList) {
        new ArrayList();
        this.authControlSwitchType = i3;
        this.memberIds = arrayList;
    }
}
