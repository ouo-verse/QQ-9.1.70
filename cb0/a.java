package cb0;

import feedcloud.FeedCloudMeta$StFeed;

/* compiled from: P */
/* loaded from: classes5.dex */
public interface a {
    void doPreloadImage(FeedCloudMeta$StFeed feedCloudMeta$StFeed);

    void doPreloadVideo(FeedCloudMeta$StFeed feedCloudMeta$StFeed, boolean z16);

    void onPreloadFeedChange(FeedCloudMeta$StFeed feedCloudMeta$StFeed);

    void onRspPreload();
}
