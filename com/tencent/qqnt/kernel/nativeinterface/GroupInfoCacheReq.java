package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GroupInfoCacheReq {
    public GroupDetailInfo detailInfo = new GroupDetailInfo();
    public GroupInfoCacheFilter filter = new GroupInfoCacheFilter();
    public long groupCode;

    public GroupDetailInfo getDetailInfo() {
        return this.detailInfo;
    }

    public GroupInfoCacheFilter getFilter() {
        return this.filter;
    }

    public long getGroupCode() {
        return this.groupCode;
    }

    public String toString() {
        return "GroupInfoCacheReq{groupCode=" + this.groupCode + ",detailInfo=" + this.detailInfo + ",filter=" + this.filter + ",}";
    }
}
