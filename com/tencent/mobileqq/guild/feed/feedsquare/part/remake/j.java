package com.tencent.mobileqq.guild.feed.feedsquare.part.remake;

import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.part.adapter.delegate.AdapterDelegatesManager;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J+\u0010\u0006\u001a\u00028\u0000\"\f\b\u0000\u0010\u0003*\u0006\u0012\u0002\b\u00030\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H&\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u000b\u001a\u00020\b8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\n\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/j;", "", "Lcom/tencent/biz/richframework/part/adapter/delegate/AdapterDelegatesManager;", "T", "Ljava/lang/Class;", "type", "b", "(Ljava/lang/Class;)Lcom/tencent/biz/richframework/part/adapter/delegate/AdapterDelegatesManager;", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "a", "()Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "recyclerViewPool", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public interface j {
    @NotNull
    RecyclerView.RecycledViewPool a();

    @NotNull
    <T extends AdapterDelegatesManager<?>> T b(@NotNull Class<T> type);
}
