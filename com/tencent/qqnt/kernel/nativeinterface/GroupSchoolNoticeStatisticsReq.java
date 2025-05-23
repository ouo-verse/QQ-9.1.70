package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GroupSchoolNoticeStatisticsReq {
    public long groupCode;
    public String noticeId;
    public int page;
    public int pageSize;
    public int type;

    public GroupSchoolNoticeStatisticsReq() {
        this.noticeId = "";
    }

    public long getGroupCode() {
        return this.groupCode;
    }

    public String getNoticeId() {
        return this.noticeId;
    }

    public int getPage() {
        return this.page;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public int getType() {
        return this.type;
    }

    public String toString() {
        return "GroupSchoolNoticeStatisticsReq{noticeId=" + this.noticeId + ",groupCode=" + this.groupCode + ",type=" + this.type + ",page=" + this.page + ",pageSize=" + this.pageSize + ",}";
    }

    public GroupSchoolNoticeStatisticsReq(String str, long j3, int i3, int i16, int i17) {
        this.noticeId = str;
        this.groupCode = j3;
        this.type = i3;
        this.page = i16;
        this.pageSize = i17;
    }
}
