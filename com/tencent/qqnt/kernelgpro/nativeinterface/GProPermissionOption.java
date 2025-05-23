package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProPermissionOption {
    public boolean authorized;
    public boolean relatedMember;
    public boolean relatedRoleMember;

    public boolean getAuthorized() {
        return this.authorized;
    }

    public boolean getRelatedMember() {
        return this.relatedMember;
    }

    public boolean getRelatedRoleMember() {
        return this.relatedRoleMember;
    }

    public String toString() {
        return "GProPermissionOption{relatedRoleMember=" + this.relatedRoleMember + ",relatedMember=" + this.relatedMember + ",authorized=" + this.authorized + ",}";
    }
}
