package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProRecommendV2Label;

/* loaded from: classes17.dex */
public class GGProRecommendV2Label implements IGProRecommendV2Label {
    public final GProRecommendV2Label mInfo;

    public GGProRecommendV2Label(GProRecommendV2Label gProRecommendV2Label) {
        this.mInfo = gProRecommendV2Label;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendV2Label
    public IGProRecommendV2Color getEdgingColor() {
        return new GGProRecommendV2Color(this.mInfo.getEdgingColor());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendV2Label
    public int getLabelAttr() {
        return this.mInfo.getLabelAttr();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendV2Label
    public int getLabelType() {
        return this.mInfo.getLabelType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendV2Label
    public String getName() {
        return this.mInfo.getName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendV2Label
    public IGProRecommendV2Color getTextColor() {
        return new GGProRecommendV2Color(this.mInfo.getTextColor());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendV2Label
    public String toString() {
        return this.mInfo.toString();
    }
}
