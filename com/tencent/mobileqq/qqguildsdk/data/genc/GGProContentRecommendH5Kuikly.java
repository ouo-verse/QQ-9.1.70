package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProContentRecommendH5Kuikly;

/* loaded from: classes17.dex */
public class GGProContentRecommendH5Kuikly implements IGProContentRecommendH5Kuikly {
    public final GProContentRecommendH5Kuikly mInfo;

    public GGProContentRecommendH5Kuikly(GProContentRecommendH5Kuikly gProContentRecommendH5Kuikly) {
        this.mInfo = gProContentRecommendH5Kuikly;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendH5Kuikly
    public String getIconUrl() {
        return this.mInfo.getIconUrl();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendH5Kuikly
    public String getJumpUrl() {
        return this.mInfo.getJumpUrl();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendH5Kuikly
    public int getJumpUrlType() {
        return this.mInfo.getJumpUrlType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendH5Kuikly
    public String getName() {
        return this.mInfo.getName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendH5Kuikly
    public String getTitle() {
        return this.mInfo.getTitle();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendH5Kuikly
    public String toString() {
        return this.mInfo.toString();
    }
}
