package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProScheduleInfo {
    public int acceptedNums;
    public ArrayList<GProScheduleUser> acceptedUser;
    public GProScheduleChannelInfo channelInfo;
    public String content;
    public long createTimeMs;
    public GProScheduleUser creator;
    public long endTimeMs;
    public int inviteStatus;
    public boolean isNotified;
    public GProOtherJumpAddress otherJumpAddress;
    public int rejectedNums;
    public int reminderTimeType;
    public long scheduleId;
    public long startTimeMs;
    public String title;

    public GProScheduleInfo() {
        this.title = "";
        this.content = "";
        this.channelInfo = new GProScheduleChannelInfo();
        this.otherJumpAddress = new GProOtherJumpAddress();
        this.creator = new GProScheduleUser();
        this.acceptedUser = new ArrayList<>();
    }

    public int getAcceptedNums() {
        return this.acceptedNums;
    }

    public ArrayList<GProScheduleUser> getAcceptedUser() {
        return this.acceptedUser;
    }

    public GProScheduleChannelInfo getChannelInfo() {
        return this.channelInfo;
    }

    public String getContent() {
        return this.content;
    }

    public long getCreateTimeMs() {
        return this.createTimeMs;
    }

    public GProScheduleUser getCreator() {
        return this.creator;
    }

    public long getEndTimeMs() {
        return this.endTimeMs;
    }

    public int getInviteStatus() {
        return this.inviteStatus;
    }

    public boolean getIsNotified() {
        return this.isNotified;
    }

    public GProOtherJumpAddress getOtherJumpAddress() {
        return this.otherJumpAddress;
    }

    public int getRejectedNums() {
        return this.rejectedNums;
    }

    public int getReminderTimeType() {
        return this.reminderTimeType;
    }

    public long getScheduleId() {
        return this.scheduleId;
    }

    public long getStartTimeMs() {
        return this.startTimeMs;
    }

    public String getTitle() {
        return this.title;
    }

    public String toString() {
        return "GProScheduleInfo{scheduleId=" + this.scheduleId + ",title=" + this.title + ",startTimeMs=" + this.startTimeMs + ",endTimeMs=" + this.endTimeMs + ",content=" + this.content + ",reminderTimeType=" + this.reminderTimeType + ",channelInfo=" + this.channelInfo + ",otherJumpAddress=" + this.otherJumpAddress + ",inviteStatus=" + this.inviteStatus + ",createTimeMs=" + this.createTimeMs + ",creator=" + this.creator + ",acceptedNums=" + this.acceptedNums + ",rejectedNums=" + this.rejectedNums + ",acceptedUser=" + this.acceptedUser + ",isNotified=" + this.isNotified + ",}";
    }

    public GProScheduleInfo(long j3, String str, long j16, long j17, String str2, int i3, GProScheduleChannelInfo gProScheduleChannelInfo, int i16, long j18, GProScheduleUser gProScheduleUser, int i17, int i18, ArrayList<GProScheduleUser> arrayList, boolean z16) {
        this.title = "";
        this.content = "";
        this.channelInfo = new GProScheduleChannelInfo();
        this.otherJumpAddress = new GProOtherJumpAddress();
        this.creator = new GProScheduleUser();
        new ArrayList();
        this.scheduleId = j3;
        this.title = str;
        this.startTimeMs = j16;
        this.endTimeMs = j17;
        this.content = str2;
        this.reminderTimeType = i3;
        this.channelInfo = gProScheduleChannelInfo;
        this.inviteStatus = i16;
        this.createTimeMs = j18;
        this.creator = gProScheduleUser;
        this.acceptedNums = i17;
        this.rejectedNums = i18;
        this.acceptedUser = arrayList;
        this.isNotified = z16;
    }
}
