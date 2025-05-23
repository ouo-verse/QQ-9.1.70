package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProRecommendFeedShareInfo;

/* loaded from: classes17.dex */
public class GGProRecommendFeedShareInfo implements IGProRecommendFeedShareInfo {
    public final GProRecommendFeedShareInfo mInfo;

    public GGProRecommendFeedShareInfo(GProRecommendFeedShareInfo gProRecommendFeedShareInfo) {
        this.mInfo = gProRecommendFeedShareInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendFeedShareInfo
    public String getShareLink() {
        return this.mInfo.getShareLink();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendFeedShareInfo
    public int getShareType() {
        return this.mInfo.getShareType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendFeedShareInfo
    public String toString() {
        return this.mInfo.toString();
    }
}
