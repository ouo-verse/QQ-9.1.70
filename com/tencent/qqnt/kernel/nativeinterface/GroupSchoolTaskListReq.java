package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GroupSchoolTaskListReq {
    public long groupCode;
    public int pageSize;
    public long pageTime;

    public GroupSchoolTaskListReq() {
    }

    public long getGroupCode() {
        return this.groupCode;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public long getPageTime() {
        return this.pageTime;
    }

    public String toString() {
        return "GroupSchoolTaskListReq{groupCode=" + this.groupCode + ",pageTime=" + this.pageTime + ",pageSize=" + this.pageSize + ",}";
    }

    public GroupSchoolTaskListReq(long j3, long j16, int i3) {
        this.groupCode = j3;
        this.pageTime = j16;
        this.pageSize = i3;
    }
}
