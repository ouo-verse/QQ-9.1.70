package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProImageBasicInfo;

/* loaded from: classes17.dex */
public class GGProImageBasicInfo implements IGProImageBasicInfo {
    public final GProImageBasicInfo mInfo;

    public GGProImageBasicInfo(GProImageBasicInfo gProImageBasicInfo) {
        this.mInfo = gProImageBasicInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProImageBasicInfo
    public int getHeight() {
        return this.mInfo.getHeight();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProImageBasicInfo
    public String getPicUrl() {
        return this.mInfo.getPicUrl();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProImageBasicInfo
    public int getWidth() {
        return this.mInfo.getWidth();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProImageBasicInfo
    public String toString() {
        return this.mInfo.toString();
    }
}
