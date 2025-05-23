package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProRoleCreateInfo {
    public boolean bHoist;
    public long color;
    public String name;
    public GProRolePermission rolePermissions;

    public GProRoleCreateInfo() {
        this.name = "";
        this.rolePermissions = new GProRolePermission();
    }

    public boolean getBHoist() {
        return this.bHoist;
    }

    public long getColor() {
        return this.color;
    }

    public String getName() {
        return this.name;
    }

    public GProRolePermission getRolePermissions() {
        return this.rolePermissions;
    }

    public String toString() {
        return "GProRoleCreateInfo{name=" + this.name + ",color=" + this.color + ",bHoist=" + this.bHoist + ",rolePermissions=" + this.rolePermissions + ",}";
    }

    public GProRoleCreateInfo(String str, long j3, boolean z16, GProRolePermission gProRolePermission) {
        this.name = "";
        new GProRolePermission();
        this.name = str;
        this.color = j3;
        this.bHoist = z16;
        this.rolePermissions = gProRolePermission;
    }
}
