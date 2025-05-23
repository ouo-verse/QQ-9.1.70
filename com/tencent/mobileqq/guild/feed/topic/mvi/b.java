package com.tencent.mobileqq.guild.feed.topic.mvi;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\t\u001a\u00060\u0002j\u0002`\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\t\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/topic/mvi/b;", "", "Lcom/tencent/mobileqq/guild/feed/topic/g;", "Lcom/tencent/mobileqq/guild/feed/topic/LoadMoreRsp;", "a", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "firstFeedId", "Lcom/tencent/mobileqq/guild/feed/topic/RefreshRsp;", "b", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public interface b {
    @Nullable
    Object a(@NotNull Continuation<? super com.tencent.mobileqq.guild.feed.topic.g> continuation);

    @Nullable
    Object b(@NotNull String str, @NotNull Continuation<? super com.tencent.mobileqq.guild.feed.topic.g> continuation);
}
