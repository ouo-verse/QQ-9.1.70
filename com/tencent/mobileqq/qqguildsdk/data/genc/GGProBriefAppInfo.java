package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProBriefAppInfo;

/* loaded from: classes17.dex */
public class GGProBriefAppInfo implements IGProBriefAppInfo {
    public final GProBriefAppInfo mInfo;

    public GGProBriefAppInfo(GProBriefAppInfo gProBriefAppInfo) {
        this.mInfo = gProBriefAppInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProBriefAppInfo
    public String getAppAvatarUrl() {
        return this.mInfo.getAppAvatarUrl();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProBriefAppInfo
    public String getAppId() {
        return this.mInfo.getAppId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProBriefAppInfo
    public String getAppName() {
        return this.mInfo.getAppName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProBriefAppInfo
    public String toString() {
        return this.mInfo.toString();
    }
}
