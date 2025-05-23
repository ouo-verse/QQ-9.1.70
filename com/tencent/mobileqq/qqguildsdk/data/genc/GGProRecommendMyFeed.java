package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProRecommendMyFeed;

/* loaded from: classes17.dex */
public class GGProRecommendMyFeed implements IGProRecommendMyFeed {
    public final GProRecommendMyFeed mInfo;

    public GGProRecommendMyFeed(GProRecommendMyFeed gProRecommendMyFeed) {
        this.mInfo = gProRecommendMyFeed;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendMyFeed
    public byte[] getData() {
        return this.mInfo.getData();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendMyFeed
    public IGProPosterInfo getPoster() {
        return new GGProPosterInfo(this.mInfo.getPoster());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendMyFeed
    public IGProRecommendFeedShareInfo getShareInfo() {
        return new GGProRecommendFeedShareInfo(this.mInfo.getShareInfo());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendMyFeed
    public String toString() {
        return this.mInfo.toString();
    }
}
