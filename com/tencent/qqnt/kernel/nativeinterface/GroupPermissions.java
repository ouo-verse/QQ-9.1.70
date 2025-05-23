package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GroupPermissions implements Serializable {
    public int reqAllFlag;
    long serialVersionUID = 1;
    public ArrayList<GroupPermission> permissions = new ArrayList<>();

    public ArrayList<GroupPermission> getPermissions() {
        return this.permissions;
    }

    public int getReqAllFlag() {
        return this.reqAllFlag;
    }

    public String toString() {
        return "GroupPermissions{permissions=" + this.permissions + ",reqAllFlag=" + this.reqAllFlag + ",}";
    }
}
