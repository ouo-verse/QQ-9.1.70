package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class PublishGroupSchoolTaskReq {
    public boolean allowMakeUp;
    public GroupSchoolNoticeContent content;
    public long groupCode;
    public long reminderTime;
    public ArrayList<Long> syncGroups;
    public GroupSchoolTaskTimeSettings timeSettings;

    public PublishGroupSchoolTaskReq() {
        this.content = new GroupSchoolNoticeContent();
        this.syncGroups = new ArrayList<>();
        this.timeSettings = new GroupSchoolTaskTimeSettings();
    }

    public boolean getAllowMakeUp() {
        return this.allowMakeUp;
    }

    public GroupSchoolNoticeContent getContent() {
        return this.content;
    }

    public long getGroupCode() {
        return this.groupCode;
    }

    public long getReminderTime() {
        return this.reminderTime;
    }

    public ArrayList<Long> getSyncGroups() {
        return this.syncGroups;
    }

    public GroupSchoolTaskTimeSettings getTimeSettings() {
        return this.timeSettings;
    }

    public String toString() {
        return "PublishGroupSchoolTaskReq{groupCode=" + this.groupCode + ",content=" + this.content + ",syncGroups=" + this.syncGroups + ",timeSettings=" + this.timeSettings + ",reminderTime=" + this.reminderTime + ",allowMakeUp=" + this.allowMakeUp + ",}";
    }

    public PublishGroupSchoolTaskReq(long j3, GroupSchoolNoticeContent groupSchoolNoticeContent, ArrayList<Long> arrayList, GroupSchoolTaskTimeSettings groupSchoolTaskTimeSettings, long j16, boolean z16) {
        this.content = new GroupSchoolNoticeContent();
        this.syncGroups = new ArrayList<>();
        new GroupSchoolTaskTimeSettings();
        this.groupCode = j3;
        this.content = groupSchoolNoticeContent;
        this.syncGroups = arrayList;
        this.timeSettings = groupSchoolTaskTimeSettings;
        this.reminderTime = j16;
        this.allowMakeUp = z16;
    }
}
