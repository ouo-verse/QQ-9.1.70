package com.tencent.biz.qqcircle.utils;

import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StPoiInfoV2;

/* compiled from: P */
/* loaded from: classes5.dex */
public class aa {
    public static String a(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StFeed == null) {
            return "";
        }
        return b(feedCloudMeta$StFeed.poiInfo);
    }

    public static String b(FeedCloudMeta$StPoiInfoV2 feedCloudMeta$StPoiInfoV2) {
        if (feedCloudMeta$StPoiInfoV2 == null) {
            return "";
        }
        return feedCloudMeta$StPoiInfoV2.displayName.get();
    }
}
