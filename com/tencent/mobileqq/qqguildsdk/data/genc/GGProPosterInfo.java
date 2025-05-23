package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProPosterInfo;

/* loaded from: classes17.dex */
public class GGProPosterInfo implements IGProPosterInfo {
    public final GProPosterInfo mInfo;

    public GGProPosterInfo(GProPosterInfo gProPosterInfo) {
        this.mInfo = gProPosterInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProPosterInfo
    public int getAge() {
        return this.mInfo.getAge();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProPosterInfo
    public int getGender() {
        return this.mInfo.getGender();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProPosterInfo
    public String toString() {
        return this.mInfo.toString();
    }
}
