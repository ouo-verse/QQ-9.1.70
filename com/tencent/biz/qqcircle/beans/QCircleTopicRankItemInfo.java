package com.tencent.biz.qqcircle.beans;

import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StTagInfo;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QCircleTopicRankItemInfo {
    public static final String TAG = "com.tencent.biz.qqcircle.beans.QCircleTopicRankItemInfo";
    private List<FeedCloudMeta$StFeed> mFeeds;
    private boolean mIsPlaying;
    private FeedCloudMeta$StTagInfo mTagInfo;
    private String mTopicName;

    public QCircleTopicRankItemInfo(String str, List<FeedCloudMeta$StFeed> list, FeedCloudMeta$StTagInfo feedCloudMeta$StTagInfo) {
        this.mTopicName = str;
        this.mFeeds = list;
        this.mTagInfo = feedCloudMeta$StTagInfo;
    }

    public List<FeedCloudMeta$StFeed> getFeeds() {
        return this.mFeeds;
    }

    public FeedCloudMeta$StTagInfo getTagInfo() {
        return this.mTagInfo;
    }

    public String getTopicName() {
        return this.mTopicName;
    }

    public boolean isIsPlaying() {
        return this.mIsPlaying;
    }

    public void setIsPlaying(boolean z16) {
        this.mIsPlaying = z16;
    }
}
