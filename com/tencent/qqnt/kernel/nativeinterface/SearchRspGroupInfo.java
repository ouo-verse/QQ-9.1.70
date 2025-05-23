package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class SearchRspGroupInfo {
    public long groupCode;
    public int privilege;
    public GroupAllInfo searchGroupInfo;

    public SearchRspGroupInfo() {
        this.searchGroupInfo = new GroupAllInfo();
    }

    public long getGroupCode() {
        return this.groupCode;
    }

    public int getPrivilege() {
        return this.privilege;
    }

    public GroupAllInfo getSearchGroupInfo() {
        return this.searchGroupInfo;
    }

    public String toString() {
        return "SearchRspGroupInfo{groupCode=" + this.groupCode + ",searchGroupInfo=" + this.searchGroupInfo + ",privilege=" + this.privilege + ",}";
    }

    public SearchRspGroupInfo(long j3, GroupAllInfo groupAllInfo, int i3) {
        new GroupAllInfo();
        this.groupCode = j3;
        this.searchGroupInfo = groupAllInfo;
        this.privilege = i3;
    }
}
