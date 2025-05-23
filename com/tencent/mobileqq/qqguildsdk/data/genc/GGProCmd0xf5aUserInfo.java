package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProCmd0xf5aUserInfo;

/* loaded from: classes17.dex */
public class GGProCmd0xf5aUserInfo implements IGProCmd0xf5aUserInfo {
    public final GProCmd0xf5aUserInfo mInfo;

    public GGProCmd0xf5aUserInfo(GProCmd0xf5aUserInfo gProCmd0xf5aUserInfo) {
        this.mInfo = gProCmd0xf5aUserInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProCmd0xf5aUserInfo
    public byte[] getAvatar() {
        return this.mInfo.getAvatar();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProCmd0xf5aUserInfo
    public int getIsMember() {
        return this.mInfo.getIsMember();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProCmd0xf5aUserInfo
    public String getNickname() {
        return this.mInfo.getNickname();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProCmd0xf5aUserInfo
    public long getUin() {
        return this.mInfo.getUin();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProCmd0xf5aUserInfo
    public int getVisitorRole() {
        return this.mInfo.getVisitorRole();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProCmd0xf5aUserInfo
    public String toString() {
        return this.mInfo.toString();
    }
}
