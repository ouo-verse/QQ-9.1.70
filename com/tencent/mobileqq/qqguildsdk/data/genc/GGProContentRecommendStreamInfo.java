package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProContentRecommendStreamInfo;

/* loaded from: classes17.dex */
public class GGProContentRecommendStreamInfo implements IGProContentRecommendStreamInfo {
    public final GProContentRecommendStreamInfo mInfo;

    public GGProContentRecommendStreamInfo(GProContentRecommendStreamInfo gProContentRecommendStreamInfo) {
        this.mInfo = gProContentRecommendStreamInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendStreamInfo
    public String getFlvUrl() {
        return this.mInfo.getFlvUrl();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendStreamInfo
    public String getRtmpUrl() {
        return this.mInfo.getRtmpUrl();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendStreamInfo
    public String toString() {
        return this.mInfo.toString();
    }
}
