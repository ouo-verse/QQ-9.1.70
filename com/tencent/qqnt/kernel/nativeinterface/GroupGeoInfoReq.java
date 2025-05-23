package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GroupGeoInfoReq {
    public long groupCode;
    public GroupGeoInfo groupGeoInfo = new GroupGeoInfo();
    public long ownerUin;

    public long getGroupCode() {
        return this.groupCode;
    }

    public GroupGeoInfo getGroupGeoInfo() {
        return this.groupGeoInfo;
    }

    public long getOwnerUin() {
        return this.ownerUin;
    }

    public String toString() {
        return "GroupGeoInfoReq{groupCode=" + this.groupCode + ",ownerUin=" + this.ownerUin + ",groupGeoInfo=" + this.groupGeoInfo + ",}";
    }
}
