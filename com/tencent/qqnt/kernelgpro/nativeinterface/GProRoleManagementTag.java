package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProRoleManagementTag implements Serializable {
    public long color;
    public long roleId;
    long serialVersionUID;
    public String tagName;

    public GProRoleManagementTag() {
        this.serialVersionUID = 1L;
        this.tagName = "";
    }

    public long getColor() {
        return this.color;
    }

    public long getRoleId() {
        return this.roleId;
    }

    public String getTagName() {
        return this.tagName;
    }

    public String toString() {
        return "GProRoleManagementTag{roleId=" + this.roleId + ",tagName=" + this.tagName + ",color=" + this.color + ",}";
    }

    public GProRoleManagementTag(long j3, String str, long j16) {
        this.serialVersionUID = 1L;
        this.roleId = j3;
        this.tagName = str;
        this.color = j16;
    }
}
