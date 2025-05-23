package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class DeleteGroupSchoolNoticeReq {
    public long groupCode;
    public String noticeId;

    public DeleteGroupSchoolNoticeReq() {
        this.noticeId = "";
    }

    public long getGroupCode() {
        return this.groupCode;
    }

    public String getNoticeId() {
        return this.noticeId;
    }

    public String toString() {
        return "DeleteGroupSchoolNoticeReq{noticeId=" + this.noticeId + ",groupCode=" + this.groupCode + ",}";
    }

    public DeleteGroupSchoolNoticeReq(String str, long j3) {
        this.noticeId = str;
        this.groupCode = j3;
    }
}
