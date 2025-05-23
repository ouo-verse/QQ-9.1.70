package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProRecommendExtInfo;

/* loaded from: classes17.dex */
public class GGProRecommendExtInfo implements IGProRecommendExtInfo {
    public final GProRecommendExtInfo mInfo;

    public GGProRecommendExtInfo(GProRecommendExtInfo gProRecommendExtInfo) {
        this.mInfo = gProRecommendExtInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendExtInfo
    public String getTraceId() {
        return this.mInfo.getTraceId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendExtInfo
    public String toString() {
        return this.mInfo.toString();
    }
}
