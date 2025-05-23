package com.tencent.mobileqq.nearbypro.feeds.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import op4.i;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/feeds/event/NBPFeedRefreshEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Lop4/i;", "statusFeed", "Lop4/i;", "getStatusFeed", "()Lop4/i;", "<init>", "(Lop4/i;)V", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class NBPFeedRefreshEvent extends SimpleBaseEvent {

    @NotNull
    private final i statusFeed;

    public NBPFeedRefreshEvent(@NotNull i statusFeed) {
        Intrinsics.checkNotNullParameter(statusFeed, "statusFeed");
        this.statusFeed = statusFeed;
    }

    @NotNull
    public final i getStatusFeed() {
        return this.statusFeed;
    }
}
