package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProRolePermissionDesc {
    public int permType;
    public int rootId;
    public String title = "";
    public String desc = "";

    public String getDesc() {
        return this.desc;
    }

    public int getPermType() {
        return this.permType;
    }

    public int getRootId() {
        return this.rootId;
    }

    public String getTitle() {
        return this.title;
    }

    public String toString() {
        return "GProRolePermissionDesc{rootId=" + this.rootId + ",title=" + this.title + ",desc=" + this.desc + ",permType=" + this.permType + ",}";
    }
}
