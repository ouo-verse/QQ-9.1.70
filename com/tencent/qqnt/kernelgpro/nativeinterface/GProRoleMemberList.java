package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProRoleMemberList {
    public GProGuildRole role = new GProGuildRole();
    public ArrayList<GProUser> members = new ArrayList<>();

    public ArrayList<GProUser> getMembers() {
        return this.members;
    }

    public GProGuildRole getRole() {
        return this.role;
    }

    public String toString() {
        return "GProRoleMemberList{role=" + this.role + ",members=" + this.members + ",}";
    }
}
