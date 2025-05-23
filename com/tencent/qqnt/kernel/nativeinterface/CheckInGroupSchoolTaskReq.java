package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class CheckInGroupSchoolTaskReq {
    public GroupSchoolNoticeContent content;
    public long groupCode;
    public boolean isMakeUp;
    public long makeUpDate;
    public long modRecordDate;
    public String taskId;

    public CheckInGroupSchoolTaskReq() {
        this.taskId = "";
        this.content = new GroupSchoolNoticeContent();
    }

    public GroupSchoolNoticeContent getContent() {
        return this.content;
    }

    public long getGroupCode() {
        return this.groupCode;
    }

    public boolean getIsMakeUp() {
        return this.isMakeUp;
    }

    public long getMakeUpDate() {
        return this.makeUpDate;
    }

    public long getModRecordDate() {
        return this.modRecordDate;
    }

    public String getTaskId() {
        return this.taskId;
    }

    public String toString() {
        return "CheckInGroupSchoolTaskReq{groupCode=" + this.groupCode + ",taskId=" + this.taskId + ",content=" + this.content + ",isMakeUp=" + this.isMakeUp + ",makeUpDate=" + this.makeUpDate + ",modRecordDate=" + this.modRecordDate + ",}";
    }

    public CheckInGroupSchoolTaskReq(long j3, String str, GroupSchoolNoticeContent groupSchoolNoticeContent, boolean z16, long j16, long j17) {
        this.taskId = "";
        new GroupSchoolNoticeContent();
        this.groupCode = j3;
        this.taskId = str;
        this.content = groupSchoolNoticeContent;
        this.isMakeUp = z16;
        this.makeUpDate = j16;
        this.modRecordDate = j17;
    }
}
