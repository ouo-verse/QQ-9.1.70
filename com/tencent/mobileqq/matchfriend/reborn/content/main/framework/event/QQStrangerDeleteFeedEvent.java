package com.tencent.mobileqq.matchfriend.reborn.content.main.framework.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.trpcprotocol.qqstranger.common.feed.FeedPB$Feed;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/main/framework/event/QQStrangerDeleteFeedEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "feed", "Lcom/tencent/trpcprotocol/qqstranger/common/feed/FeedPB$Feed;", "(Lcom/tencent/trpcprotocol/qqstranger/common/feed/FeedPB$Feed;)V", "getFeed", "()Lcom/tencent/trpcprotocol/qqstranger/common/feed/FeedPB$Feed;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final /* data */ class QQStrangerDeleteFeedEvent extends SimpleBaseEvent {
    private final FeedPB$Feed feed;

    public QQStrangerDeleteFeedEvent(FeedPB$Feed feed) {
        Intrinsics.checkNotNullParameter(feed, "feed");
        this.feed = feed;
    }

    /* renamed from: component1, reason: from getter */
    public final FeedPB$Feed getFeed() {
        return this.feed;
    }

    public final QQStrangerDeleteFeedEvent copy(FeedPB$Feed feed) {
        Intrinsics.checkNotNullParameter(feed, "feed");
        return new QQStrangerDeleteFeedEvent(feed);
    }

    public final FeedPB$Feed getFeed() {
        return this.feed;
    }

    public int hashCode() {
        return this.feed.hashCode();
    }

    public String toString() {
        return "QQStrangerDeleteFeedEvent(feed=" + this.feed + ")";
    }

    public static /* synthetic */ QQStrangerDeleteFeedEvent copy$default(QQStrangerDeleteFeedEvent qQStrangerDeleteFeedEvent, FeedPB$Feed feedPB$Feed, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            feedPB$Feed = qQStrangerDeleteFeedEvent.feed;
        }
        return qQStrangerDeleteFeedEvent.copy(feedPB$Feed);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof QQStrangerDeleteFeedEvent) && Intrinsics.areEqual(this.feed, ((QQStrangerDeleteFeedEvent) other).feed);
    }
}
