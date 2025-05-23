package com.tencent.biz.qqcircle.immersive.aggregation.bean;

import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import feedcloud.FeedCloudMeta$StFeedMusic;
import feedcloud.FeedCloudMeta$StUnifiedTag;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSFlowAggregationInitBean extends QCircleInitBean {
    private int mAggregationType;
    private byte[] mFeedMusicByteArray;
    private byte[] mFeedUnifiedTagByteArray;

    public int getAggregationType() {
        return this.mAggregationType;
    }

    public FeedCloudMeta$StFeedMusic getFeedMusic() {
        FeedCloudMeta$StFeedMusic feedCloudMeta$StFeedMusic = new FeedCloudMeta$StFeedMusic();
        try {
            feedCloudMeta$StFeedMusic.mergeFrom(this.mFeedMusicByteArray);
        } catch (Exception unused) {
        }
        return feedCloudMeta$StFeedMusic;
    }

    public FeedCloudMeta$StUnifiedTag getFeedUnifiedTag() {
        FeedCloudMeta$StUnifiedTag feedCloudMeta$StUnifiedTag = new FeedCloudMeta$StUnifiedTag();
        try {
            feedCloudMeta$StUnifiedTag.mergeFrom(this.mFeedUnifiedTagByteArray);
        } catch (Exception unused) {
        }
        return feedCloudMeta$StUnifiedTag;
    }

    public void setAggregationType(int i3) {
        this.mAggregationType = i3;
    }

    public void setFeedMusic(FeedCloudMeta$StFeedMusic feedCloudMeta$StFeedMusic) {
        if (feedCloudMeta$StFeedMusic != null) {
            this.mFeedMusicByteArray = feedCloudMeta$StFeedMusic.toByteArray();
        }
    }

    public void setFeedUnifiedTag(FeedCloudMeta$StUnifiedTag feedCloudMeta$StUnifiedTag) {
        if (feedCloudMeta$StUnifiedTag != null) {
            this.mFeedUnifiedTagByteArray = feedCloudMeta$StUnifiedTag.toByteArray();
        }
    }
}
