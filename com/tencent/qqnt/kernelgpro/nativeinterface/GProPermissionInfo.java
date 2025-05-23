package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProPermissionInfo {
    public ArrayList<Integer> childIds;
    public int rootId;

    public GProPermissionInfo() {
        this.childIds = new ArrayList<>();
    }

    public ArrayList<Integer> getChildIds() {
        return this.childIds;
    }

    public int getRootId() {
        return this.rootId;
    }

    public String toString() {
        return "GProPermissionInfo{rootId=" + this.rootId + ",childIds=" + this.childIds + ",}";
    }

    public GProPermissionInfo(int i3, ArrayList<Integer> arrayList) {
        new ArrayList();
        this.rootId = i3;
        this.childIds = arrayList;
    }
}
