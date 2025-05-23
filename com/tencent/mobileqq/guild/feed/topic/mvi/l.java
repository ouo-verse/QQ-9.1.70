package com.tencent.mobileqq.guild.feed.topic.mvi;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/topic/mvi/l;", "Lcom/tencent/mobileqq/guild/feed/topic/mvi/h;", "Lcom/tencent/mobileqq/guild/feed/topic/mvi/a;", "oldState", "a", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class l extends h {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final l f223664a = new l();

    l() {
        super(null);
    }

    @Override // com.tencent.mobileqq.guild.feed.topic.mvi.h
    @NotNull
    public FeedListState a(@NotNull FeedListState oldState) {
        Intrinsics.checkNotNullParameter(oldState, "oldState");
        ri1.a a16 = ri1.a.a(-1);
        Intrinsics.checkNotNullExpressionValue(a16, "error(GProStateCode.TYPE_DEFAULT_VALUE)");
        return FeedListState.b(oldState, a16, false, null, false, 0, false, 62, null);
    }
}
