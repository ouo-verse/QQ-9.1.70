package com.tencent.mobileqq.guild.feed.topic.mvi;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B\t\b\u0004\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u0082\u0001\u0005\u0007\b\t\n\u000b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/topic/mvi/h;", "", "Lcom/tencent/mobileqq/guild/feed/topic/mvi/a;", "oldState", "a", "<init>", "()V", "Lcom/tencent/mobileqq/guild/feed/topic/mvi/e;", "Lcom/tencent/mobileqq/guild/feed/topic/mvi/g;", "Lcom/tencent/mobileqq/guild/feed/topic/mvi/i;", "Lcom/tencent/mobileqq/guild/feed/topic/mvi/k;", "Lcom/tencent/mobileqq/guild/feed/topic/mvi/l;", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public abstract class h {
    public /* synthetic */ h(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @NotNull
    public FeedListState a(@NotNull FeedListState oldState) {
        Intrinsics.checkNotNullParameter(oldState, "oldState");
        return oldState;
    }

    h() {
    }
}
