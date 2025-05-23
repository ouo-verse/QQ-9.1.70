package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GroupSchoolNoticeData {
    public long authorUin;
    public int confirmedCount;
    public GroupSchoolNoticeContent content;
    public boolean isConfirm;
    public String noticeId;
    public long publishTime;
    public int state;
    public int total;

    public GroupSchoolNoticeData() {
        this.noticeId = "";
        this.content = new GroupSchoolNoticeContent();
    }

    public long getAuthorUin() {
        return this.authorUin;
    }

    public int getConfirmedCount() {
        return this.confirmedCount;
    }

    public GroupSchoolNoticeContent getContent() {
        return this.content;
    }

    public boolean getIsConfirm() {
        return this.isConfirm;
    }

    public String getNoticeId() {
        return this.noticeId;
    }

    public long getPublishTime() {
        return this.publishTime;
    }

    public int getState() {
        return this.state;
    }

    public int getTotal() {
        return this.total;
    }

    public String toString() {
        return "GroupSchoolNoticeData{noticeId=" + this.noticeId + ",authorUin=" + this.authorUin + ",content=" + this.content + ",state=" + this.state + ",publishTime=" + this.publishTime + ",isConfirm=" + this.isConfirm + ",total=" + this.total + ",confirmedCount=" + this.confirmedCount + ",}";
    }

    public GroupSchoolNoticeData(String str, long j3, GroupSchoolNoticeContent groupSchoolNoticeContent, int i3, long j16, boolean z16, int i16, int i17) {
        this.noticeId = "";
        new GroupSchoolNoticeContent();
        this.noticeId = str;
        this.authorUin = j3;
        this.content = groupSchoolNoticeContent;
        this.state = i3;
        this.publishTime = j16;
        this.isConfirm = z16;
        this.total = i16;
        this.confirmedCount = i17;
    }
}
