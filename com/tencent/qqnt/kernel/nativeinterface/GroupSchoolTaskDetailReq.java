package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GroupSchoolTaskDetailReq {
    public long groupCode;
    public String taskId;

    public GroupSchoolTaskDetailReq() {
        this.taskId = "";
    }

    public long getGroupCode() {
        return this.groupCode;
    }

    public String getTaskId() {
        return this.taskId;
    }

    public String toString() {
        return "GroupSchoolTaskDetailReq{groupCode=" + this.groupCode + ",taskId=" + this.taskId + ",}";
    }

    public GroupSchoolTaskDetailReq(long j3, String str) {
        this.groupCode = j3;
        this.taskId = str;
    }
}
