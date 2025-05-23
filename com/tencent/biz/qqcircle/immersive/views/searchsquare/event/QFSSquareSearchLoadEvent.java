package com.tencent.biz.qqcircle.immersive.views.searchsquare.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSSquareSearchLoadEvent extends SimpleBaseEvent {
    public final List<FeedCloudMeta$StFeed> feedList;
    public final boolean isLoadMore;

    public QFSSquareSearchLoadEvent(List<FeedCloudMeta$StFeed> list, boolean z16) {
        this.feedList = list;
        this.isLoadMore = z16;
    }
}
