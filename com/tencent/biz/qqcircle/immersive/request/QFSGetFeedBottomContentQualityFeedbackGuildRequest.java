package com.tencent.biz.qqcircle.immersive.request;

import com.tencent.biz.qqcircle.utils.bh;
import feedcloud.FeedCloudCommon$StCommonExt;
import feedcloud.FeedCloudMeta$StFeed;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSGetFeedBottomContentQualityFeedbackGuildRequest extends QFSGetFeedDetailSecondaryLoadRequest {
    public QFSGetFeedBottomContentQualityFeedbackGuildRequest(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3, boolean z16) {
        super(feedCloudMeta$StFeed);
        String str;
        this.mRequest.source.set(i3);
        this.mRequest.mask.add(4);
        FeedCloudCommon$StCommonExt feedCloudCommon$StCommonExt = this.mRequest.extInfo;
        if (z16) {
            str = "true";
        } else {
            str = "";
        }
        bh.b(feedCloudCommon$StCommonExt, "has_behavior", str);
    }
}
