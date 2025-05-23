package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProRolePermission {
    public boolean hasRolePermission;
    public ArrayList<GProPermissionInfo> permissionList;

    public GProRolePermission() {
        this.permissionList = new ArrayList<>();
    }

    public boolean getHasRolePermission() {
        return this.hasRolePermission;
    }

    public ArrayList<GProPermissionInfo> getPermissionList() {
        return this.permissionList;
    }

    public String toString() {
        return "GProRolePermission{hasRolePermission=" + this.hasRolePermission + ",permissionList=" + this.permissionList + ",}";
    }

    public GProRolePermission(boolean z16, ArrayList<GProPermissionInfo> arrayList) {
        new ArrayList();
        this.hasRolePermission = z16;
        this.permissionList = arrayList;
    }
}
