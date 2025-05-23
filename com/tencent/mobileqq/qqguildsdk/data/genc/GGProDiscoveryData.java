package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProDiscoveryData;

/* loaded from: classes17.dex */
public class GGProDiscoveryData implements IGProDiscoveryData {
    public final GProDiscoveryData mInfo;

    public GGProDiscoveryData(GProDiscoveryData gProDiscoveryData) {
        this.mInfo = gProDiscoveryData;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProDiscoveryData
    public String getAnimationUrl() {
        return this.mInfo.getAnimationUrl();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProDiscoveryData
    public int getPlayAnimationFlag() {
        return this.mInfo.getPlayAnimationFlag();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProDiscoveryData
    public int getUseModel() {
        return this.mInfo.getUseModel();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProDiscoveryData
    public String toString() {
        return this.mInfo.toString();
    }
}
