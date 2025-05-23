package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GroupSchoolTaskUnCheckInReq {
    public long date;
    public long groupCode;
    public int pageIndex;
    public int pageSize;
    public String taskId;

    public GroupSchoolTaskUnCheckInReq() {
        this.taskId = "";
    }

    public long getDate() {
        return this.date;
    }

    public long getGroupCode() {
        return this.groupCode;
    }

    public int getPageIndex() {
        return this.pageIndex;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public String getTaskId() {
        return this.taskId;
    }

    public String toString() {
        return "GroupSchoolTaskUnCheckInReq{groupCode=" + this.groupCode + ",taskId=" + this.taskId + ",date=" + this.date + ",pageIndex=" + this.pageIndex + ",pageSize=" + this.pageSize + ",}";
    }

    public GroupSchoolTaskUnCheckInReq(long j3, String str, long j16, int i3, int i16) {
        this.groupCode = j3;
        this.taskId = str;
        this.date = j16;
        this.pageIndex = i3;
        this.pageSize = i16;
    }
}
