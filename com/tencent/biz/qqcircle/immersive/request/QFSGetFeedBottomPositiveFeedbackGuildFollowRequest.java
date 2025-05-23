package com.tencent.biz.qqcircle.immersive.request;

import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudCommon$Entry;
import feedcloud.FeedCloudMeta$StFeed;

/* loaded from: classes4.dex */
public class QFSGetFeedBottomPositiveFeedbackGuildFollowRequest extends QFSGetFeedDetailSecondaryLoadRequest {
    public QFSGetFeedBottomPositiveFeedbackGuildFollowRequest(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3, int i16) {
        super(feedCloudMeta$StFeed);
        QLog.d("QFSGetFeedBottomPositiveFeedbackGuildFollowRequest", 1, "[request] feedSourceType = " + i16 + ", showTimes = " + i3);
        this.mRequest.source.set(i16);
        this.mRequest.mask.add(5);
        FeedCloudCommon$Entry feedCloudCommon$Entry = new FeedCloudCommon$Entry();
        feedCloudCommon$Entry.key.set("sub_button_count");
        feedCloudCommon$Entry.value.set(String.valueOf(i3));
        this.mRequest.extInfo.mapInfo.add(feedCloudCommon$Entry);
        this.mRequest.extInfo.setHasFlag(true);
    }
}
