package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class FromRoleInfo {
    public int color;
    public String name;
    public long roleId;

    public FromRoleInfo() {
        this.name = "";
    }

    public int getColor() {
        return this.color;
    }

    public String getName() {
        return this.name;
    }

    public long getRoleId() {
        return this.roleId;
    }

    public String toString() {
        return "FromRoleInfo{roleId=" + this.roleId + ",name=" + this.name + ",color=" + this.color + ",}";
    }

    public FromRoleInfo(long j3, String str, int i3) {
        this.roleId = j3;
        this.name = str;
        this.color = i3;
    }
}
