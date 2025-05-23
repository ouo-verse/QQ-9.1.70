package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProRoleGroupInfo implements Serializable {
    public int color;
    public long roleId;
    long serialVersionUID = 1;
    public String name = "";

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
        return "GProRoleGroupInfo{roleId=" + this.roleId + ",name=" + this.name + ",color=" + this.color + ",}";
    }
}
