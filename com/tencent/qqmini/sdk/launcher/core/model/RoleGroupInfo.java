package com.tencent.qqmini.sdk.launcher.core.model;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes23.dex */
public class RoleGroupInfo implements Serializable {
    public long color;
    public String roleID;
    public String roleName;

    public long getColor() {
        return this.color;
    }

    public String getRoleID() {
        return this.roleID;
    }

    public String getRoleName() {
        return this.roleName;
    }

    public void setColor(long j3) {
        this.color = j3;
    }

    public void setRoleID(String str) {
        this.roleID = str;
    }

    public void setRoleName(String str) {
        this.roleName = str;
    }
}
