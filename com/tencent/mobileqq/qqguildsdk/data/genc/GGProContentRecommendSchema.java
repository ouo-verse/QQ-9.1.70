package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProContentRecommendSchema;

/* loaded from: classes17.dex */
public class GGProContentRecommendSchema implements IGProContentRecommendSchema {
    public final GProContentRecommendSchema mInfo;

    public GGProContentRecommendSchema(GProContentRecommendSchema gProContentRecommendSchema) {
        this.mInfo = gProContentRecommendSchema;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendSchema
    public String getCover() {
        return this.mInfo.getCover();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendSchema
    public String getJumpUrl() {
        return this.mInfo.getJumpUrl();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendSchema
    public String toString() {
        return this.mInfo.toString();
    }
}
