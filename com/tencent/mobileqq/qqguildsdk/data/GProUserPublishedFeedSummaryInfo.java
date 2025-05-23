package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProUserPublishedFeedSummary;
import java.util.ArrayList;

/* loaded from: classes17.dex */
public class GProUserPublishedFeedSummaryInfo implements IGProUserPublishedFeedSummary {
    public final GProUserPublishedFeedSummary mInfo;

    public GProUserPublishedFeedSummaryInfo(GProUserPublishedFeedSummary gProUserPublishedFeedSummary) {
        this.mInfo = gProUserPublishedFeedSummary;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserPublishedFeedSummary
    public ArrayList<byte[]> getFeedList() {
        return this.mInfo.getFeedList();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserPublishedFeedSummary
    public String getPublishedCountStr() {
        return this.mInfo.getPublishedCountStr();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserPublishedFeedSummary
    public String toString() {
        return this.mInfo.toString();
    }
}
