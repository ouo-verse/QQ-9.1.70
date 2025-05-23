package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProRecommendGuildPersonalSetting;

/* loaded from: classes17.dex */
public class GGProRecommendGuildPersonalSetting implements IGProRecommendGuildPersonalSetting {
    public final GProRecommendGuildPersonalSetting mInfo;

    public GGProRecommendGuildPersonalSetting(GProRecommendGuildPersonalSetting gProRecommendGuildPersonalSetting) {
        this.mInfo = gProRecommendGuildPersonalSetting;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProRecommendGuildPersonalSetting
    public int getExitOption() {
        return this.mInfo.getExitOption();
    }
}
