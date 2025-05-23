package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProRecallInfo;

/* loaded from: classes17.dex */
public class GGProRecallInfo implements IGProRecallInfo {
    public final GProRecallInfo mInfo;

    public GGProRecallInfo(GProRecallInfo gProRecallInfo) {
        this.mInfo = gProRecallInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecallInfo, com.tencent.mobileqq.qqguildsdk.data.IRecallInfo
    public float getQualityScore() {
        return this.mInfo.getQualityScore();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecallInfo, com.tencent.mobileqq.qqguildsdk.data.IRecallInfo
    public String getQuery() {
        return this.mInfo.getQuery();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecallInfo, com.tencent.mobileqq.qqguildsdk.data.IRecallInfo
    public String getRecallName() {
        return this.mInfo.getRecallName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecallInfo, com.tencent.mobileqq.qqguildsdk.data.IRecallInfo
    public float getRelevanceScore() {
        return this.mInfo.getRelevanceScore();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecallInfo, com.tencent.mobileqq.qqguildsdk.data.IRecallInfo
    public float getScore() {
        return this.mInfo.getScore();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecallInfo, com.tencent.mobileqq.qqguildsdk.data.IRecallInfo
    public String getTraceId() {
        return this.mInfo.getTraceId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecallInfo
    public String toString() {
        return this.mInfo.toString();
    }
}
