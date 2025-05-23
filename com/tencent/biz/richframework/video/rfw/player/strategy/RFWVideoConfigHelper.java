package com.tencent.biz.richframework.video.rfw.player.strategy;

import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta$StFeed;

/* compiled from: P */
/* loaded from: classes5.dex */
public class RFWVideoConfigHelper {
    private static int getPrefetchFeedVideoPreloadTimeFromWns() {
        return uq3.c.X0("qqcircle", "qqcircle_video_preload_duration_prefetch_feed", 3000).intValue();
    }

    public static int getPreloadFeedPreloadVideoTime(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        int prefetchFeedVideoPreloadTimeFromWns;
        boolean isSimpleFeed = isSimpleFeed(feedCloudMeta$StFeed);
        if (isSimpleFeed) {
            prefetchFeedVideoPreloadTimeFromWns = getSimpleFeedVideoPreloadTimeFromWns();
        } else {
            prefetchFeedVideoPreloadTimeFromWns = getPrefetchFeedVideoPreloadTimeFromWns();
        }
        QLog.d("FeedLine_QFSVideoConfigHelper", 1, "[getPreloadFeedPreloadVideoTime] simpleFeed:" + isSimpleFeed + ", preloadDuration:" + prefetchFeedVideoPreloadTimeFromWns);
        return prefetchFeedVideoPreloadTimeFromWns;
    }

    public static int getSimpleFeedVideoPreloadTimeFromWns() {
        return uq3.c.X0("qqcircle", "qqcircle_video_preload_duration_simple_feed", 3000).intValue();
    }

    public static boolean isSimpleFeed(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        return feedCloudMeta$StFeed.opMask2.get().contains(44);
    }
}
