package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProGuildGlobalAuthFilter {
    public int associatedRoleFilter;
    public ArrayList<Integer> authTypes = new ArrayList<>();

    public int getAssociatedRoleFilter() {
        return this.associatedRoleFilter;
    }

    public ArrayList<Integer> getAuthTypes() {
        return this.authTypes;
    }

    public String toString() {
        return "GProGuildGlobalAuthFilter{authTypes=" + this.authTypes + ",associatedRoleFilter=" + this.associatedRoleFilter + ",}";
    }
}
