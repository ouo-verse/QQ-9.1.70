package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProScheduleUser;

/* loaded from: classes17.dex */
public class GGProScheduleUser implements IGProScheduleUser {
    public final GProScheduleUser mInfo;

    public GGProScheduleUser(GProScheduleUser gProScheduleUser) {
        this.mInfo = gProScheduleUser;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProScheduleUser
    public String getAvatar() {
        return this.mInfo.getAvatar();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProScheduleUser
    public String getNick() {
        return this.mInfo.getNick();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProScheduleUser
    public int getRole() {
        return this.mInfo.getRole();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProScheduleUser
    public long getTinyId() {
        return this.mInfo.getTinyId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProScheduleUser
    public String toString() {
        return this.mInfo.toString();
    }
}
