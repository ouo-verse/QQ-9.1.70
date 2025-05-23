package com.tencent.mobileqq.nearbypro.feeds.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/feeds/event/NBPFeedCommentEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "feedId", "", "commentCount", "", "(Ljava/lang/String;I)V", "getCommentCount", "()I", "getFeedId", "()Ljava/lang/String;", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes15.dex */
public final class NBPFeedCommentEvent extends SimpleBaseEvent {
    private final int commentCount;

    @NotNull
    private final String feedId;

    public NBPFeedCommentEvent(@NotNull String feedId, int i3) {
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        this.feedId = feedId;
        this.commentCount = i3;
    }

    public final int getCommentCount() {
        return this.commentCount;
    }

    @NotNull
    public final String getFeedId() {
        return this.feedId;
    }
}
