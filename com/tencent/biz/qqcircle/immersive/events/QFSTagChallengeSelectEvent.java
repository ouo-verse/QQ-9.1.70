package com.tencent.biz.qqcircle.immersive.events;

import com.tencent.biz.qqcircle.beans.QCircleTagChallengeInfo;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import feedcloud.FeedCloudMeta$StFeed;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSTagChallengeSelectEvent extends SimpleBaseEvent {
    public FeedCloudMeta$StFeed mStFeed;
    public QCircleTagChallengeInfo mTagChallengeInfo;

    public QFSTagChallengeSelectEvent(QCircleTagChallengeInfo qCircleTagChallengeInfo, FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        this.mTagChallengeInfo = qCircleTagChallengeInfo;
        this.mStFeed = feedCloudMeta$StFeed;
    }
}
