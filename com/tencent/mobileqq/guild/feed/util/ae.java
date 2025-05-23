package com.tencent.mobileqq.guild.feed.util;

import com.tencent.guild.aio.util.GuildAIODispatchers;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.ExecutorsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\n\u0010\u0001\u001a\u00020\u0000*\u00020\u0000\"\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\u00a8\u0006\u0007"}, d2 = {"Lkotlinx/coroutines/CoroutineDispatcher;", "b", "Lcom/tencent/guild/aio/util/GuildAIODispatchers;", "a", "Lcom/tencent/guild/aio/util/GuildAIODispatchers;", "()Lcom/tencent/guild/aio/util/GuildAIODispatchers;", "GuildFeedDispatchers", "qqguild_feed_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class ae {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private static final GuildAIODispatchers f223837a = GuildAIODispatchers.f112358a;

    @NotNull
    public static final GuildAIODispatchers a() {
        return f223837a;
    }

    @NotNull
    public static final CoroutineDispatcher b(@NotNull CoroutineDispatcher coroutineDispatcher) {
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "<this>");
        return ExecutorsKt.from(new bk(ExecutorsKt.asExecutor(coroutineDispatcher)));
    }
}
