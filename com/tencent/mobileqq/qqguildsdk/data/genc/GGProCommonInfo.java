package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProCommonInfo;

/* loaded from: classes17.dex */
public class GGProCommonInfo implements IGProCommonInfo {
    public final GProCommonInfo mInfo;

    public GGProCommonInfo(GProCommonInfo gProCommonInfo) {
        this.mInfo = gProCommonInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProCommonInfo
    public String getStr() {
        return this.mInfo.getStr();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProCommonInfo
    public long getValue() {
        return this.mInfo.getValue();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProCommonInfo
    public String toString() {
        return this.mInfo.toString();
    }
}
