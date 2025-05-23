package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProActiveUser;

/* loaded from: classes17.dex */
public class GGProActiveUser implements IGProActiveUser {
    public final GProActiveUser mInfo;

    public GGProActiveUser(GProActiveUser gProActiveUser) {
        this.mInfo = gProActiveUser;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProActiveUser
    public long getAge() {
        return this.mInfo.getAge();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProActiveUser
    public String getAvatarMeta() {
        return this.mInfo.getAvatarMeta();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProActiveUser
    public String getCityName() {
        return this.mInfo.getCityName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProActiveUser
    public int getGender() {
        return this.mInfo.getGender();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProActiveUser
    public long getGuildId() {
        return this.mInfo.getGuildId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProActiveUser
    public boolean getIsQQFriend() {
        return this.mInfo.getIsQQFriend();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProActiveUser
    public String getNickName() {
        return this.mInfo.getNickName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProActiveUser
    public String getOpenid() {
        return this.mInfo.getOpenid();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProActiveUser
    public long getStateType() {
        return this.mInfo.getStateType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProActiveUser
    public long getTinyid() {
        return this.mInfo.getTinyid();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProActiveUser
    public String toString() {
        return this.mInfo.toString();
    }
}
