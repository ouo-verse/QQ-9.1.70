package com.tencent.mobileqq.guild.feed.feedsquare.part.remake.delegate.impl;

import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.guild.feed.event.GuildFeedSquareFeedScrollEvent;
import com.tencent.mobileqq.guild.feed.util.bl;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u001a\f\u0010\u0001\u001a\u00020\u0000*\u00020\u0000H\u0000*\u0082\u0001\u0010\u000b\">\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u00022>\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0002*\u009a\u0001\u0010\r\"J\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\t\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\n0\u00022J\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\t\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\n0\u0002\u00a8\u0006\u000e"}, d2 = {"Landroidx/recyclerview/widget/RecyclerView;", "a", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "isScrolling", "Lkotlin/Pair;", "", "visiblePositionPair", "", "ListScrollStateChangeCallback", "completelyVisiblePositionPair", "ListScrolledChangeCallback", "qqguild_feed_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class i {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/feed/feedsquare/part/remake/delegate/impl/i$a", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a extends RecyclerView.OnScrollListener {
        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int newState) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, newState);
            if (newState == 0) {
                bl.c().a(new GuildFeedSquareFeedScrollEvent());
            }
        }
    }

    @NotNull
    public static final RecyclerView a(@NotNull RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "<this>");
        recyclerView.addOnScrollListener(new a());
        return recyclerView;
    }
}
