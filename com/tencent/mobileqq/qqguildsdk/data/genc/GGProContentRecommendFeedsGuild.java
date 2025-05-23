package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProContentRecommendFeed;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProContentRecommendFeedsGuild;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes17.dex */
public class GGProContentRecommendFeedsGuild implements IGProContentRecommendFeedsGuild {
    public final GProContentRecommendFeedsGuild mInfo;

    public GGProContentRecommendFeedsGuild(GProContentRecommendFeedsGuild gProContentRecommendFeedsGuild) {
        this.mInfo = gProContentRecommendFeedsGuild;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendFeedsGuild
    public ArrayList<IGProContentRecommendFeed> getFeeds() {
        ArrayList<GProContentRecommendFeed> feeds = this.mInfo.getFeeds();
        ArrayList<IGProContentRecommendFeed> arrayList = new ArrayList<>();
        Iterator<GProContentRecommendFeed> it = feeds.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProContentRecommendFeed(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendFeedsGuild
    public String toString() {
        return this.mInfo.toString();
    }
}
