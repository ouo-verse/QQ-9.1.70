package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GroupSchoolTaskCheckInInfoReq {
    public long date;
    public long groupCode;
    public boolean needState;
    public String taskId;

    public GroupSchoolTaskCheckInInfoReq() {
        this.taskId = "";
    }

    public long getDate() {
        return this.date;
    }

    public long getGroupCode() {
        return this.groupCode;
    }

    public boolean getNeedState() {
        return this.needState;
    }

    public String getTaskId() {
        return this.taskId;
    }

    public String toString() {
        return "GroupSchoolTaskCheckInInfoReq{groupCode=" + this.groupCode + ",taskId=" + this.taskId + ",date=" + this.date + ",needState=" + this.needState + ",}";
    }

    public GroupSchoolTaskCheckInInfoReq(long j3, String str, long j16, boolean z16) {
        this.groupCode = j3;
        this.taskId = str;
        this.date = j16;
        this.needState = z16;
    }
}
