package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GroupFlagForThirdApp {
    public long groupCode;
    public int hlGuildAppid;
    public int hlGuildBinary;
    public int hlGuildOrgId;
    public int hlGuildSubType;
    public int isConfGroup;

    public long getGroupCode() {
        return this.groupCode;
    }

    public int getHlGuildAppid() {
        return this.hlGuildAppid;
    }

    public int getHlGuildBinary() {
        return this.hlGuildBinary;
    }

    public int getHlGuildOrgId() {
        return this.hlGuildOrgId;
    }

    public int getHlGuildSubType() {
        return this.hlGuildSubType;
    }

    public int getIsConfGroup() {
        return this.isConfGroup;
    }

    public String toString() {
        return "GroupFlagForThirdApp{groupCode=" + this.groupCode + ",isConfGroup=" + this.isConfGroup + ",hlGuildAppid=" + this.hlGuildAppid + ",hlGuildSubType=" + this.hlGuildSubType + ",hlGuildOrgId=" + this.hlGuildOrgId + ",hlGuildBinary=" + this.hlGuildBinary + ",}";
    }
}
