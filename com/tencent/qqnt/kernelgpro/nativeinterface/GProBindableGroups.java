package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProBindableGroups {
    public int activeGroups;
    public ArrayList<GProBindingGroup> groups = new ArrayList<>();

    public int getActiveGroups() {
        return this.activeGroups;
    }

    public ArrayList<GProBindingGroup> getGroups() {
        return this.groups;
    }

    public String toString() {
        return "GProBindableGroups{groups=" + this.groups + ",activeGroups=" + this.activeGroups + ",}";
    }
}
