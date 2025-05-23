package com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/event/FeedContentScrollEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "newState", "", "(I)V", "getNewState", "()I", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
public final class FeedContentScrollEvent extends SimpleBaseEvent {
    private final int newState;

    public FeedContentScrollEvent(int i3) {
        this.newState = i3;
    }

    public final int getNewState() {
        return this.newState;
    }
}
