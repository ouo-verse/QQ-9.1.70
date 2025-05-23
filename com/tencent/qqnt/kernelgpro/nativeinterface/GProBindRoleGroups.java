package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProBindRoleGroups {
    public int authControlSwitchType;
    public ArrayList<Long> roleGroupIds;

    public GProBindRoleGroups() {
        this.roleGroupIds = new ArrayList<>();
    }

    public int getAuthControlSwitchType() {
        return this.authControlSwitchType;
    }

    public ArrayList<Long> getRoleGroupIds() {
        return this.roleGroupIds;
    }

    public String toString() {
        return "GProBindRoleGroups{authControlSwitchType=" + this.authControlSwitchType + ",roleGroupIds=" + this.roleGroupIds + ",}";
    }

    public GProBindRoleGroups(int i3, ArrayList<Long> arrayList) {
        new ArrayList();
        this.authControlSwitchType = i3;
        this.roleGroupIds = arrayList;
    }
}
