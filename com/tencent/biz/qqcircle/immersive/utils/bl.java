package com.tencent.biz.qqcircle.immersive.utils;

import androidx.lifecycle.MutableLiveData;
import feedcloud.FeedCloudMeta$StFeed;

/* compiled from: P */
/* loaded from: classes4.dex */
public class bl {
    /* JADX WARN: Multi-variable type inference failed */
    private static e30.b a(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        MutableLiveData globalData;
        if (feedCloudMeta$StFeed == null || (globalData = w20.a.j().getGlobalData(e30.b.class, feedCloudMeta$StFeed.f398449id.get())) == null) {
            return null;
        }
        return (e30.b) globalData.getValue();
    }

    public static void b(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        FeedCloudMeta$StFeed g16;
        e30.b a16 = a(feedCloudMeta$StFeed);
        if (a16 == null || (g16 = a16.g()) == null) {
            return;
        }
        g16.visitorInfo.viewCount.set(g16.visitorInfo.viewCount.get() + 1);
        w20.a.j().initOrUpdateGlobalState((w20.a) a16, true);
    }
}
