package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProRoleMemberChangeInfo {
    public ArrayList<Long> addMembers = new ArrayList<>();
    public ArrayList<Long> removeMembers = new ArrayList<>();
    public long roleId;

    public ArrayList<Long> getAddMembers() {
        return this.addMembers;
    }

    public ArrayList<Long> getRemoveMembers() {
        return this.removeMembers;
    }

    public long getRoleId() {
        return this.roleId;
    }

    public String toString() {
        return "GProRoleMemberChangeInfo{roleId=" + this.roleId + ",addMembers=" + this.addMembers + ",removeMembers=" + this.removeMembers + ",}";
    }
}
