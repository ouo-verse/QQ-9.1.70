package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProRecommendCoverInfo;

/* loaded from: classes17.dex */
public class GGProRecommendCoverInfo implements IGProRecommendCoverInfo {
    public final GProRecommendCoverInfo mInfo;

    public GGProRecommendCoverInfo(GProRecommendCoverInfo gProRecommendCoverInfo) {
        this.mInfo = gProRecommendCoverInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendCoverInfo
    public String getFlvStreamUrl() {
        return this.mInfo.getFlvStreamUrl();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendCoverInfo
    public String getImageUrl() {
        return this.mInfo.getImageUrl();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendCoverInfo
    public String getStreamUrl() {
        return this.mInfo.getStreamUrl();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendCoverInfo
    public int getType() {
        return this.mInfo.getType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendCoverInfo
    public String toString() {
        return this.mInfo.toString();
    }
}
