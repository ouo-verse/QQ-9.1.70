package com.tencent.mobileqq.qcircle.api.coldboot;

import androidx.annotation.NonNull;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudRead$StGetFeedListRsp;
import qqcircle.QQCircleFeedBase$PrePullRspFeedsOpActionDesc;

/* loaded from: classes16.dex */
public interface IPreloadTask {
    void clearAllCacheInfo();

    void dealWithPagePrePullRsp(FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp);

    void filterFeedById(String str);

    FeedCloudMeta$StFeed getPreloadFeed();

    Object getPreloadRsp();

    byte[] getPreloadRspData();

    void handlePreloadRsp(@NonNull FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp, @NonNull QQCircleFeedBase$PrePullRspFeedsOpActionDesc qQCircleFeedBase$PrePullRspFeedsOpActionDesc);

    boolean hasPreloadData();

    void preloadFeed();
}
