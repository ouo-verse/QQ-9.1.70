package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProTransVideo;

/* loaded from: classes17.dex */
public class GGProTransVideo implements IGProTransVideo {
    public final GProTransVideo mInfo;

    public GGProTransVideo(GProTransVideo gProTransVideo) {
        this.mInfo = gProTransVideo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProTransVideo
    public String getPlayUrl() {
        return this.mInfo.getPlayUrl();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProTransVideo
    public int getPrior() {
        return this.mInfo.getPrior();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProTransVideo
    public int getRate() {
        return this.mInfo.getRate();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProTransVideo
    public int getSpecification() {
        return this.mInfo.getSpecification();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProTransVideo
    public String toString() {
        return this.mInfo.toString();
    }
}
