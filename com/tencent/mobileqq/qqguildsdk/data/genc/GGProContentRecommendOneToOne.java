package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProContentRecommendOneToOne;

/* loaded from: classes17.dex */
public class GGProContentRecommendOneToOne implements IGProContentRecommendOneToOne {
    public final GProContentRecommendOneToOne mInfo;

    public GGProContentRecommendOneToOne(GProContentRecommendOneToOne gProContentRecommendOneToOne) {
        this.mInfo = gProContentRecommendOneToOne;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendOneToOne
    public IGProContentRecommendGuild getGuild() {
        return new GGProContentRecommendGuild(this.mInfo.getGuild());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendOneToOne
    public byte[] getStFeed() {
        return this.mInfo.getStFeed();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendOneToOne
    public String toString() {
        return this.mInfo.toString();
    }
}
