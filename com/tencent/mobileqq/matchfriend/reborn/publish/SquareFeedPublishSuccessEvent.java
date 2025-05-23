package com.tencent.mobileqq.matchfriend.reborn.publish;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.trpcprotocol.qqstranger.common.feed.FeedPB$Feed;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/publish/SquareFeedPublishSuccessEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "feed", "Lcom/tencent/trpcprotocol/qqstranger/common/feed/FeedPB$Feed;", "(Lcom/tencent/trpcprotocol/qqstranger/common/feed/FeedPB$Feed;)V", "getFeed", "()Lcom/tencent/trpcprotocol/qqstranger/common/feed/FeedPB$Feed;", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class SquareFeedPublishSuccessEvent extends SimpleBaseEvent {
    private final FeedPB$Feed feed;

    public SquareFeedPublishSuccessEvent(FeedPB$Feed feedPB$Feed) {
        this.feed = feedPB$Feed;
    }

    public final FeedPB$Feed getFeed() {
        return this.feed;
    }
}
