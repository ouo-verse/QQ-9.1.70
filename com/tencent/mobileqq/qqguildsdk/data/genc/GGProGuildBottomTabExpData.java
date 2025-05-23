package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildBottomTabExpData;

/* loaded from: classes17.dex */
public class GGProGuildBottomTabExpData implements IGProGuildBottomTabExpData {
    public final GProGuildBottomTabExpData mInfo;

    public GGProGuildBottomTabExpData(GProGuildBottomTabExpData gProGuildBottomTabExpData) {
        this.mInfo = gProGuildBottomTabExpData;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildBottomTabExpData
    public IGProDiscoveryData getDiscoveryData() {
        return new GGProDiscoveryData(this.mInfo.getDiscoveryData());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildBottomTabExpData
    public long getExpId() {
        return this.mInfo.getExpId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildBottomTabExpData
    public String getExpIndex() {
        return this.mInfo.getExpIndex();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildBottomTabExpData
    public boolean getIsHit() {
        return this.mInfo.getIsHit();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildBottomTabExpData
    public int getTabType() {
        return this.mInfo.getTabType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildBottomTabExpData
    public IGProNewUserGuideData getUserGuideData() {
        return new GGProNewUserGuideData(this.mInfo.getUserGuideData());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildBottomTabExpData
    public String toString() {
        return this.mInfo.toString();
    }
}
