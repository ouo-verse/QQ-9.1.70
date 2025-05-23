package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProNewUserGuideData;

/* loaded from: classes17.dex */
public class GGProNewUserGuideData implements IGProNewUserGuideData {
    public final GProNewUserGuideData mInfo;

    public GGProNewUserGuideData(GProNewUserGuideData gProNewUserGuideData) {
        this.mInfo = gProNewUserGuideData;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProNewUserGuideData
    public String getAnimationUrl() {
        return this.mInfo.getAnimationUrl();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProNewUserGuideData
    public int getTabExposeFlag() {
        return this.mInfo.getTabExposeFlag();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProNewUserGuideData
    public String toString() {
        return this.mInfo.toString();
    }
}
