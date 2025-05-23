package com.tencent.mobileqq.qcircle.api.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import feedcloud.FeedCloudRead$StGetFeedListRsp;

/* loaded from: classes16.dex */
public class QFSRedPointFeedAddEvent extends SimpleBaseEvent {
    private final FeedCloudRead$StGetFeedListRsp mFeedListRsp;
    private final int mSource;

    public QFSRedPointFeedAddEvent(int i3, FeedCloudRead$StGetFeedListRsp feedCloudRead$StGetFeedListRsp) {
        this.mSource = i3;
        this.mFeedListRsp = feedCloudRead$StGetFeedListRsp;
    }

    public FeedCloudRead$StGetFeedListRsp getFeedListRsp() {
        return this.mFeedListRsp;
    }

    public int getSource() {
        return this.mSource;
    }
}
