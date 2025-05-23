package com.tencent.biz.qqcircle.utils;

import feedcloud.FeedCloudCommon$Entry;
import feedcloud.FeedCloudMeta$StFeed;

/* compiled from: P */
/* loaded from: classes5.dex */
public class q {
    public static String a(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StFeed == null) {
            return "";
        }
        for (FeedCloudCommon$Entry feedCloudCommon$Entry : feedCloudMeta$StFeed.clientInfo.clientMap.get()) {
            if ("key_polymerize_recommend_info".equals(feedCloudCommon$Entry.key.get())) {
                return feedCloudCommon$Entry.value.get();
            }
        }
        return "";
    }
}
