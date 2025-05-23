package com.tencent.state.event;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.qzone.module.feedcomponent.manage.FeedManager;
import com.tencent.state.square.SquareBaseKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u001d\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0002\u0010\u0007J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0003H\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/tencent/state/event/LoadMoreListener;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "loadMoreLastCount", "", FeedManager.LOAD_MORE, "Lkotlin/Function0;", "", "(ILkotlin/jvm/functions/Function0;)V", "onScrollStateChanged", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes33.dex */
public class LoadMoreListener extends RecyclerView.OnScrollListener {
    private final Function0<Unit> loadMore;
    private final int loadMoreLastCount;

    public /* synthetic */ LoadMoreListener(int i3, Function0 function0, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? 1 : i3, function0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
        int lastIndex;
        Integer valueOf;
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onScrollStateChanged(recyclerView, newState);
        if (newState != 0) {
            return;
        }
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof StaggeredGridLayoutManager) {
            StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) layoutManager;
            int[] findLastVisibleItemPositions = staggeredGridLayoutManager.findLastVisibleItemPositions(new int[staggeredGridLayoutManager.getSpanCount()]);
            Intrinsics.checkNotNullExpressionValue(findLastVisibleItemPositions, "layoutManager.findLastVi\u2026layoutManager.spanCount))");
            if (findLastVisibleItemPositions.length == 0) {
                valueOf = null;
            } else {
                int i3 = findLastVisibleItemPositions[0];
                lastIndex = ArraysKt___ArraysKt.getLastIndex(findLastVisibleItemPositions);
                if (lastIndex == 0) {
                    valueOf = Integer.valueOf(i3);
                } else {
                    if (1 <= lastIndex) {
                        int i16 = 1;
                        int i17 = i3;
                        while (true) {
                            int i18 = findLastVisibleItemPositions[i16];
                            if (i3 < i18) {
                                i3 = i18;
                                i17 = i3;
                            }
                            if (i16 == lastIndex) {
                                break;
                            } else {
                                i16++;
                            }
                        }
                        i3 = i17;
                    }
                    valueOf = Integer.valueOf(i3);
                }
            }
            if (valueOf != null) {
                int intValue = valueOf.intValue();
                RecyclerView.Adapter adapter = recyclerView.getAdapter();
                if (intValue >= (adapter != null ? adapter.getItemCount() : 0) - this.loadMoreLastCount) {
                    this.loadMore.invoke();
                    return;
                }
                return;
            }
            return;
        }
        if (layoutManager instanceof GridLayoutManager) {
            int findLastVisibleItemPosition = ((GridLayoutManager) layoutManager).findLastVisibleItemPosition();
            RecyclerView.Adapter adapter2 = recyclerView.getAdapter();
            if (findLastVisibleItemPosition >= (adapter2 != null ? adapter2.getItemCount() : 0) - this.loadMoreLastCount) {
                this.loadMore.invoke();
                return;
            }
            return;
        }
        if (layoutManager instanceof LinearLayoutManager) {
            int findLastVisibleItemPosition2 = ((LinearLayoutManager) layoutManager).findLastVisibleItemPosition();
            RecyclerView.Adapter adapter3 = recyclerView.getAdapter();
            if (findLastVisibleItemPosition2 >= (adapter3 != null ? adapter3.getItemCount() : 0) - this.loadMoreLastCount) {
                this.loadMore.invoke();
                return;
            }
            return;
        }
        SquareBaseKt.getSquareLog().w("LoadMoreListener", "not support layoutManager " + recyclerView.getLayoutManager());
    }

    public LoadMoreListener(int i3, Function0<Unit> loadMore) {
        Intrinsics.checkNotNullParameter(loadMore, "loadMore");
        this.loadMoreLastCount = i3;
        this.loadMore = loadMore;
    }
}
