package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProRolePermissionCategory {
    public String name;
    public int packCount;

    public GProRolePermissionCategory() {
        this.name = "";
    }

    public String getName() {
        return this.name;
    }

    public int getPackCount() {
        return this.packCount;
    }

    public String toString() {
        return "GProRolePermissionCategory{name=" + this.name + ",packCount=" + this.packCount + ",}";
    }

    public GProRolePermissionCategory(String str, int i3) {
        this.name = str;
        this.packCount = i3;
    }
}
