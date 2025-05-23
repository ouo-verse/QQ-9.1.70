package com.tencent.mobileqq.guild.feed.feedsquare.part.remake.delegate.impl;

import android.content.Context;
import com.tencent.biz.richframework.part.adapter.delegate.AdapterDelegatesManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0010\u0010\u0011J+\u0010\u0006\u001a\u00028\u0000\"\f\b\u0000\u0010\u0003*\u0006\u0012\u0002\b\u00030\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u001a\u0010\r\u001a\u00020\b8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/delegate/impl/a;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/j;", "Lcom/tencent/biz/richframework/part/adapter/delegate/AdapterDelegatesManager;", "T", "Ljava/lang/Class;", "type", "b", "(Ljava/lang/Class;)Lcom/tencent/biz/richframework/part/adapter/delegate/AdapterDelegatesManager;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/widget/a;", "a", "Lcom/tencent/mobileqq/guild/feed/feedsquare/widget/a;", "c", "()Lcom/tencent/mobileqq/guild/feed/feedsquare/widget/a;", "recyclerViewPool", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class a implements com.tencent.mobileqq.guild.feed.feedsquare.part.remake.j {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.feed.feedsquare.widget.a recyclerViewPool;

    public a(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.recyclerViewPool = new com.tencent.mobileqq.guild.feed.feedsquare.widget.a(context);
    }

    @Override // com.tencent.mobileqq.guild.feed.feedsquare.part.remake.j
    @NotNull
    public <T extends AdapterDelegatesManager<?>> T b(@NotNull Class<T> type) {
        Intrinsics.checkNotNullParameter(type, "type");
        if (Intrinsics.areEqual(type, yj1.d.class)) {
            yj1.d dVar = yj1.d.f450494a;
            Intrinsics.checkNotNull(dVar, "null cannot be cast to non-null type T of com.tencent.mobileqq.guild.feed.feedsquare.part.remake.delegate.impl.DefaultFeedRecyclerViewGlobalConfig.obtainDelegateManager");
            return dVar;
        }
        throw new IllegalArgumentException("please check the caller side of delegateManager type: " + type);
    }

    @Override // com.tencent.mobileqq.guild.feed.feedsquare.part.remake.j
    @NotNull
    /* renamed from: c, reason: from getter and merged with bridge method [inline-methods] */
    public com.tencent.mobileqq.guild.feed.feedsquare.widget.a a() {
        return this.recyclerViewPool;
    }
}
