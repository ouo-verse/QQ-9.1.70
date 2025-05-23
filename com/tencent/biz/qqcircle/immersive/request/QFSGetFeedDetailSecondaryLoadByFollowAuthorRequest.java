package com.tencent.biz.qqcircle.immersive.request;

import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudCommon$Entry;
import feedcloud.FeedCloudCommon$StCommonExt;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StUser;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSGetFeedDetailSecondaryLoadByFollowAuthorRequest extends QFSGetFeedDetailSecondaryLoadRequest {
    public QFSGetFeedDetailSecondaryLoadByFollowAuthorRequest(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        super(feedCloudMeta$StFeed);
        this.mRequest.mask.add(7);
        FeedCloudCommon$StCommonExt feedCloudCommon$StCommonExt = new FeedCloudCommon$StCommonExt();
        feedCloudCommon$StCommonExt.mapInfo.add(a(feedCloudMeta$StFeed));
        this.mRequest.extInfo.set(feedCloudCommon$StCommonExt);
        QLog.d("QFSGetFeedDetailSecondaryLoadByFollowAuthorRequest", 1, "[request] mask is FeedCloudRead.LOAD_PMYL");
    }

    private FeedCloudCommon$Entry a(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        FeedCloudCommon$Entry feedCloudCommon$Entry = new FeedCloudCommon$Entry();
        feedCloudCommon$Entry.key.set("pyml_uin");
        feedCloudCommon$Entry.value.set(b(feedCloudMeta$StFeed));
        return feedCloudCommon$Entry;
    }

    private String b(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        FeedCloudMeta$StUser feedCloudMeta$StUser;
        PBStringField pBStringField;
        if (feedCloudMeta$StFeed != null && (feedCloudMeta$StUser = feedCloudMeta$StFeed.poster) != null && (pBStringField = feedCloudMeta$StUser.f398463id) != null) {
            return pBStringField.get();
        }
        return "";
    }
}
