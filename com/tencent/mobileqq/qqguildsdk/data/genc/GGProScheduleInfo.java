package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProScheduleInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProScheduleUser;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes17.dex */
public class GGProScheduleInfo implements IGProScheduleInfo {
    public final GProScheduleInfo mInfo;

    public GGProScheduleInfo(GProScheduleInfo gProScheduleInfo) {
        this.mInfo = gProScheduleInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProScheduleInfo
    public int getAcceptedNums() {
        return this.mInfo.getAcceptedNums();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProScheduleInfo
    public ArrayList<IGProScheduleUser> getAcceptedUser() {
        ArrayList<GProScheduleUser> acceptedUser = this.mInfo.getAcceptedUser();
        ArrayList<IGProScheduleUser> arrayList = new ArrayList<>();
        Iterator<GProScheduleUser> it = acceptedUser.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProScheduleUser(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProScheduleInfo
    public IGProScheduleChannelInfo getChannelInfo() {
        return new GGProScheduleChannelInfo(this.mInfo.getChannelInfo());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProScheduleInfo
    public String getContent() {
        return this.mInfo.getContent();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProScheduleInfo
    public long getCreateTimeMs() {
        return this.mInfo.getCreateTimeMs();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProScheduleInfo
    public IGProScheduleUser getCreator() {
        return new GGProScheduleUser(this.mInfo.getCreator());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProScheduleInfo
    public long getEndTimeMs() {
        return this.mInfo.getEndTimeMs();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProScheduleInfo
    public int getInviteStatus() {
        return this.mInfo.getInviteStatus();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProScheduleInfo
    public boolean getIsNotified() {
        return this.mInfo.getIsNotified();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProScheduleInfo
    public IGProOtherJumpAddress getOtherJumpAddress() {
        return new GGProOtherJumpAddress(this.mInfo.getOtherJumpAddress());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProScheduleInfo
    public int getRejectedNums() {
        return this.mInfo.getRejectedNums();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProScheduleInfo
    public int getReminderTimeType() {
        return this.mInfo.getReminderTimeType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProScheduleInfo
    public long getScheduleId() {
        return this.mInfo.getScheduleId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProScheduleInfo
    public long getStartTimeMs() {
        return this.mInfo.getStartTimeMs();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProScheduleInfo
    public String getTitle() {
        return this.mInfo.getTitle();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProScheduleInfo
    public String toString() {
        return this.mInfo.toString();
    }
}
