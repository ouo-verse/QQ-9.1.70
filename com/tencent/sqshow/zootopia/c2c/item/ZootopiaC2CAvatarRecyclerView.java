package com.tencent.sqshow.zootopia.c2c.item;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.AttributeSet;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.widget.pull2refresh.LoadingMoreHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 &2\u00020\u00012\u00020\u0002:\u0003'(\u0013B\u0011\b\u0016\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u00a2\u0006\u0004\b\u001e\u0010\u001fB\u001d\b\u0016\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u0012\b\u0010!\u001a\u0004\u0018\u00010 \u00a2\u0006\u0004\b\u001e\u0010\"B%\b\u0016\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u0012\b\u0010!\u001a\u0004\u0018\u00010 \u0012\u0006\u0010$\u001a\u00020#\u00a2\u0006\u0004\b\u001e\u0010%J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007J\u0016\u0010\f\u001a\u00020\u00052\f\u0010\u000b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\nH\u0016J\u0012\u0010\u000f\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u0016\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010J\u0010\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0010H\u0016J\b\u0010\u0016\u001a\u00020\u0005H\u0016R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0017R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006)"}, d2 = {"Lcom/tencent/sqshow/zootopia/c2c/item/ZootopiaC2CAvatarRecyclerView;", "Landroid/support/v7/widget/RecyclerView;", "Lcom/tencent/widget/pull2refresh/LoadingMoreHelper$OnLoadMoreListener;", "Lcom/tencent/sqshow/zootopia/view/pull2refresh/a;", "helper", "", "setLoadMoreHelper", "Lcom/tencent/sqshow/zootopia/c2c/item/ZootopiaC2CAvatarRecyclerView$d;", "listener", "setLoadMoreListener", "Landroid/support/v7/widget/RecyclerView$Adapter;", "adapter", "setAdapter", "Landroid/support/v7/widget/RecyclerView$LayoutManager;", TtmlNode.TAG_LAYOUT, "setLayoutManager", "", "isSuccess", "hasMore", "d", "isManual", "onLoadMore", "onLoadMoreComplete", "Lcom/tencent/sqshow/zootopia/c2c/item/ZootopiaC2CAvatarRecyclerView$d;", "loadMoreListener", "e", "Lcom/tencent/sqshow/zootopia/view/pull2refresh/a;", "loadMoreHelper", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "f", "b", "c", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZootopiaC2CAvatarRecyclerView extends RecyclerView implements LoadingMoreHelper.OnLoadMoreListener {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private d loadMoreListener;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private com.tencent.sqshow.zootopia.view.pull2refresh.a loadMoreHelper;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/sqshow/zootopia/c2c/item/ZootopiaC2CAvatarRecyclerView$a", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "Landroid/support/v7/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class a extends RecyclerView.OnScrollListener {
        a() {
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            com.tencent.sqshow.zootopia.view.pull2refresh.a aVar;
            com.tencent.sqshow.zootopia.view.pull2refresh.a aVar2;
            super.onScrollStateChanged(recyclerView, newState);
            if (recyclerView == null) {
                return;
            }
            int childCount = recyclerView.getChildCount();
            int itemCount = recyclerView.getLayoutManager().getItemCount();
            com.tencent.sqshow.zootopia.view.pull2refresh.a aVar3 = ZootopiaC2CAvatarRecyclerView.this.loadMoreHelper;
            int proLoaderCount = aVar3 != null ? aVar3.getProLoaderCount() : 10;
            if (recyclerView.getLayoutManager() instanceof StaggeredGridLayoutManager) {
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type android.support.v7.widget.StaggeredGridLayoutManager");
                if (!(itemCount - childCount <= ((StaggeredGridLayoutManager) layoutManager).findFirstVisibleItemPositions(null)[0] + proLoaderCount) || (aVar2 = ZootopiaC2CAvatarRecyclerView.this.loadMoreHelper) == null) {
                    return;
                }
                aVar2.setLoadMore(true);
                return;
            }
            if (recyclerView.getLayoutManager() instanceof LinearLayoutManager) {
                RecyclerView.LayoutManager layoutManager2 = recyclerView.getLayoutManager();
                Intrinsics.checkNotNull(layoutManager2, "null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
                if (!(itemCount - childCount <= ((LinearLayoutManager) layoutManager2).findFirstVisibleItemPosition() + proLoaderCount) || (aVar = ZootopiaC2CAvatarRecyclerView.this.loadMoreHelper) == null) {
                    return;
                }
                aVar.setLoadMore(true);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001f\u0012\u000e\u0010\b\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0005\u0012\u0006\u0010\f\u001a\u00020\t\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u001c\u0010\b\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/sqshow/zootopia/c2c/item/ZootopiaC2CAvatarRecyclerView$c;", "Landroid/support/v7/widget/GridLayoutManager$SpanSizeLookup;", "", "position", "getSpanSize", "Lj84/c;", "a", "Lj84/c;", "mAdapter", "Landroid/support/v7/widget/GridLayoutManager;", "b", "Landroid/support/v7/widget/GridLayoutManager;", "mLayoutManager", "<init>", "(Lj84/c;Landroid/support/v7/widget/GridLayoutManager;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c extends GridLayoutManager.SpanSizeLookup {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final j84.c<?, ?> mAdapter;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final GridLayoutManager mLayoutManager;

        public c(j84.c<?, ?> mAdapter, GridLayoutManager mLayoutManager) {
            Intrinsics.checkNotNullParameter(mAdapter, "mAdapter");
            Intrinsics.checkNotNullParameter(mLayoutManager, "mLayoutManager");
            this.mAdapter = mAdapter;
            this.mLayoutManager = mLayoutManager;
        }

        @Override // android.support.v7.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanSize(int position) {
            if (this.mAdapter.isFooterPosition(position)) {
                return this.mLayoutManager.getSpanCount();
            }
            return 1;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/sqshow/zootopia/c2c/item/ZootopiaC2CAvatarRecyclerView$d;", "", "", "doLoadMore", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public interface d {
        void doLoadMore();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZootopiaC2CAvatarRecyclerView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        addOnScrollListener(new a());
    }

    public final void d(boolean isSuccess, boolean hasMore) {
        com.tencent.sqshow.zootopia.view.pull2refresh.a aVar = this.loadMoreHelper;
        if (aVar != null) {
            aVar.setLoadMoreComplete(isSuccess, hasMore);
        }
        com.tencent.sqshow.zootopia.view.pull2refresh.a aVar2 = this.loadMoreHelper;
        if (aVar2 != null) {
            aVar2.setLoadMoreEnabled(hasMore);
        }
    }

    @Override // com.tencent.widget.pull2refresh.LoadingMoreHelper.OnLoadMoreListener
    public boolean onLoadMore(boolean isManual) {
        d dVar = this.loadMoreListener;
        if (dVar == null) {
            return true;
        }
        dVar.doLoadMore();
        return true;
    }

    @Override // android.support.v7.widget.RecyclerView
    public void setAdapter(RecyclerView.Adapter<?> adapter) {
        if (getLayoutManager() instanceof GridLayoutManager) {
            RecyclerView.LayoutManager layoutManager = getLayoutManager();
            Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type android.support.v7.widget.GridLayoutManager");
            GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
            j84.c cVar = adapter instanceof j84.c ? (j84.c) adapter : null;
            if (cVar != null) {
                gridLayoutManager.setSpanSizeLookup(new c(cVar, gridLayoutManager));
            }
        }
        super.setAdapter(adapter);
    }

    @Override // android.support.v7.widget.RecyclerView
    public void setLayoutManager(RecyclerView.LayoutManager layout) {
        super.setLayoutManager(layout);
        if (getLayoutManager() instanceof GridLayoutManager) {
            RecyclerView.LayoutManager layoutManager = getLayoutManager();
            Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type android.support.v7.widget.GridLayoutManager");
            GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
            RecyclerView.Adapter adapter = getAdapter();
            j84.c cVar = adapter instanceof j84.c ? (j84.c) adapter : null;
            if (cVar != null) {
                gridLayoutManager.setSpanSizeLookup(new c(cVar, gridLayoutManager));
            }
        }
    }

    public final void setLoadMoreHelper(com.tencent.sqshow.zootopia.view.pull2refresh.a helper) {
        Intrinsics.checkNotNullParameter(helper, "helper");
        this.loadMoreHelper = helper;
        if (helper != null) {
            helper.setLoadMoreEnabled(true);
        }
        com.tencent.sqshow.zootopia.view.pull2refresh.a aVar = this.loadMoreHelper;
        if (aVar != null) {
            aVar.setOnLoadMoreListener(this);
        }
    }

    public final void setLoadMoreListener(d listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.loadMoreListener = listener;
    }

    public ZootopiaC2CAvatarRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        addOnScrollListener(new a());
    }

    public ZootopiaC2CAvatarRecyclerView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        addOnScrollListener(new a());
    }

    @Override // com.tencent.widget.pull2refresh.LoadingMoreHelper.OnLoadMoreListener
    public void onLoadMoreComplete() {
    }
}
