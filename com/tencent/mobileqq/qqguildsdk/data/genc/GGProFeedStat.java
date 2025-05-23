package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProFeedStat;

/* loaded from: classes17.dex */
public class GGProFeedStat implements IGProFeedStat {
    public final GProFeedStat mInfo;

    public GGProFeedStat(GProFeedStat gProFeedStat) {
        this.mInfo = gProFeedStat;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProFeedStat
    public long getPageView() {
        return this.mInfo.getPageView();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProFeedStat
    public long getPreferCount() {
        return this.mInfo.getPreferCount();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProFeedStat
    public int getPreferStatus() {
        return this.mInfo.getPreferStatus();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProFeedStat
    public long getShareCount() {
        return this.mInfo.getShareCount();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProFeedStat
    public long getTotalCommentCount() {
        return this.mInfo.getTotalCommentCount();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProFeedStat
    public String toString() {
        return this.mInfo.toString();
    }
}
