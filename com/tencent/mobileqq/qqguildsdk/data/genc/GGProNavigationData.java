package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProNavigationData;

/* loaded from: classes17.dex */
public class GGProNavigationData implements IGProNavigationData {
    public final GProNavigationData mInfo;

    public GGProNavigationData(GProNavigationData gProNavigationData) {
        this.mInfo = gProNavigationData;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProNavigationData
    public String getIcon() {
        return this.mInfo.getIcon();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProNavigationData
    public String getJumpLink() {
        return this.mInfo.getJumpLink();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProNavigationData
    public String getName() {
        return this.mInfo.getName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProNavigationData
    public int getType() {
        return this.mInfo.getType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProNavigationData
    public String toString() {
        return this.mInfo.toString();
    }
}
