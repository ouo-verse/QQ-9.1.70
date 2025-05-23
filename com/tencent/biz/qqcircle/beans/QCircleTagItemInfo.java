package com.tencent.biz.qqcircle.beans;

import feedcloud.FeedCloudMeta$StMedalInfo;
import feedcloud.FeedCloudMeta$StTagInfo;
import qqcircle.QQCircleBase$CircleRankingData;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QCircleTagItemInfo {
    public static final int TYPE_NEW_RANK_DATA = 3;
    public static final int TYPE_RANK_DATA = 2;
    public static final int TYPE_TAG_DATA = 1;
    private FeedCloudMeta$StMedalInfo mMedalInfo;
    private QQCircleBase$CircleRankingData mRankingData;
    private FeedCloudMeta$StTagInfo mTagInfo;
    private int mType;

    public QCircleTagItemInfo(int i3, QQCircleBase$CircleRankingData qQCircleBase$CircleRankingData) {
        this.mType = i3;
        this.mRankingData = qQCircleBase$CircleRankingData;
    }

    public FeedCloudMeta$StMedalInfo getMedalInfo() {
        return this.mMedalInfo;
    }

    public QQCircleBase$CircleRankingData getRankingData() {
        return this.mRankingData;
    }

    public FeedCloudMeta$StTagInfo getTagInfo() {
        return this.mTagInfo;
    }

    public int getType() {
        return this.mType;
    }

    public QCircleTagItemInfo(int i3, FeedCloudMeta$StTagInfo feedCloudMeta$StTagInfo) {
        this.mType = i3;
        this.mTagInfo = feedCloudMeta$StTagInfo;
    }

    public QCircleTagItemInfo(int i3, FeedCloudMeta$StMedalInfo feedCloudMeta$StMedalInfo) {
        this.mType = i3;
        this.mMedalInfo = feedCloudMeta$StMedalInfo;
    }
}
