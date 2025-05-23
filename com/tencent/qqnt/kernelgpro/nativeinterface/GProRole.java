package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProRole implements Serializable {
    public boolean isBind;
    long serialVersionUID = 1;
    public String roleId = "";
    public String roleName = "";
    public String roleDescribe = "";

    public boolean getIsBind() {
        return this.isBind;
    }

    public String getRoleDescribe() {
        return this.roleDescribe;
    }

    public String getRoleId() {
        return this.roleId;
    }

    public String getRoleName() {
        return this.roleName;
    }

    public String toString() {
        return "GProRole{roleId=" + this.roleId + ",roleName=" + this.roleName + ",roleDescribe=" + this.roleDescribe + ",isBind=" + this.isBind + ",}";
    }
}
