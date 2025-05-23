package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProImgPair;

/* loaded from: classes17.dex */
public class GGProImgPair implements IGProImgPair {
    public final GProImgPair mInfo;

    public GGProImgPair(GProImgPair gProImgPair) {
        this.mInfo = gProImgPair;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProImgPair
    public String getImgDayMode() {
        return this.mInfo.getImgDayMode();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProImgPair
    public String getImgNightMode() {
        return this.mInfo.getImgNightMode();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProImgPair
    public String toString() {
        return this.mInfo.toString();
    }
}
