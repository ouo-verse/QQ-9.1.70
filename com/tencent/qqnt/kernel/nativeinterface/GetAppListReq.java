package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GetAppListReq {
    public long groupId;
    public int groupType;
    public int miniAppDisable;
    public int mode;

    public long getGroupId() {
        return this.groupId;
    }

    public int getGroupType() {
        return this.groupType;
    }

    public int getMiniAppDisable() {
        return this.miniAppDisable;
    }

    public int getMode() {
        return this.mode;
    }

    public String toString() {
        return "GetAppListReq{groupId=" + this.groupId + ",groupType=" + this.groupType + ",miniAppDisable=" + this.miniAppDisable + ",mode=" + this.mode + ",}";
    }
}
