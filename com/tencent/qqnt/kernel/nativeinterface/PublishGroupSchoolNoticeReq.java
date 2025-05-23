package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class PublishGroupSchoolNoticeReq {
    public GroupSchoolNoticeContent content;
    public long groupCode;
    public long publishTime;
    public ArrayList<Long> syncGroups;

    public PublishGroupSchoolNoticeReq() {
        this.content = new GroupSchoolNoticeContent();
        this.syncGroups = new ArrayList<>();
    }

    public GroupSchoolNoticeContent getContent() {
        return this.content;
    }

    public long getGroupCode() {
        return this.groupCode;
    }

    public long getPublishTime() {
        return this.publishTime;
    }

    public ArrayList<Long> getSyncGroups() {
        return this.syncGroups;
    }

    public String toString() {
        return "PublishGroupSchoolNoticeReq{content=" + this.content + ",groupCode=" + this.groupCode + ",syncGroups=" + this.syncGroups + ",publishTime=" + this.publishTime + ",}";
    }

    public PublishGroupSchoolNoticeReq(GroupSchoolNoticeContent groupSchoolNoticeContent, long j3, ArrayList<Long> arrayList, long j16) {
        this.content = new GroupSchoolNoticeContent();
        new ArrayList();
        this.content = groupSchoolNoticeContent;
        this.groupCode = j3;
        this.syncGroups = arrayList;
        this.publishTime = j16;
    }
}
