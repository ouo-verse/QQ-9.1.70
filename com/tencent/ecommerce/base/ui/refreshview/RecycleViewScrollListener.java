package com.tencent.ecommerce.base.ui.refreshview;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import kotlin.Metadata;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0016\u0018\u00002\u00020\u0001:\u0001\u001eB\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0016J\u0018\u0010\r\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0004H\u0016J\b\u0010\u000e\u001a\u00020\nH\u0016R$\u0010\u0015\u001a\u0004\u0018\u00010\u000f8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0016R\u0016\u0010\u0019\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001b\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0018\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/ecommerce/base/ui/refreshview/RecycleViewScrollListener;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "", "lastPositions", "", "d", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "dx", "dy", "", "onScrolled", "newState", "onScrollStateChanged", "e", "Lcom/tencent/ecommerce/base/ui/refreshview/RecycleViewScrollListener$LAYOUT_MANAGER_TYPE;", "Lcom/tencent/ecommerce/base/ui/refreshview/RecycleViewScrollListener$LAYOUT_MANAGER_TYPE;", "getLayoutManagerType", "()Lcom/tencent/ecommerce/base/ui/refreshview/RecycleViewScrollListener$LAYOUT_MANAGER_TYPE;", "setLayoutManagerType", "(Lcom/tencent/ecommerce/base/ui/refreshview/RecycleViewScrollListener$LAYOUT_MANAGER_TYPE;)V", "layoutManagerType", "[I", "f", "I", "lastVisibleItemPosition", h.F, "currentScrollState", "<init>", "()V", "LAYOUT_MANAGER_TYPE", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes32.dex */
public class RecycleViewScrollListener extends RecyclerView.OnScrollListener {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private LAYOUT_MANAGER_TYPE layoutManagerType;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int[] lastPositions;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int lastVisibleItemPosition;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int currentScrollState;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/ecommerce/base/ui/refreshview/RecycleViewScrollListener$LAYOUT_MANAGER_TYPE;", "", "(Ljava/lang/String;I)V", "LINEAR", "GRID", "STAGGERED_GRID", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes32.dex */
    public enum LAYOUT_MANAGER_TYPE {
        LINEAR,
        GRID,
        STAGGERED_GRID
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
        super.onScrollStateChanged(recyclerView, newState);
        this.currentScrollState = newState;
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager != null) {
            int childCount = layoutManager.getChildCount();
            int itemCount = layoutManager.getItemCount();
            if (childCount <= 0 || this.currentScrollState != 0 || this.lastVisibleItemPosition < itemCount - 2) {
                return;
            }
            e();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrolled(RecyclerView recyclerView, int dx5, int dy5) {
        LAYOUT_MANAGER_TYPE layout_manager_type;
        super.onScrolled(recyclerView, dx5, dy5);
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (this.layoutManagerType == null) {
            if (layoutManager instanceof LinearLayoutManager) {
                layout_manager_type = LAYOUT_MANAGER_TYPE.LINEAR;
            } else if (layoutManager instanceof GridLayoutManager) {
                layout_manager_type = LAYOUT_MANAGER_TYPE.GRID;
            } else if (layoutManager instanceof StaggeredGridLayoutManager) {
                layout_manager_type = LAYOUT_MANAGER_TYPE.STAGGERED_GRID;
            } else {
                throw new UnsupportedOperationException("Unsupported LayoutManager used. Valid ones are LinearLayoutManager, GridLayoutManager and StaggeredGridLayoutManager");
            }
            this.layoutManagerType = layout_manager_type;
        }
        LAYOUT_MANAGER_TYPE layout_manager_type2 = this.layoutManagerType;
        if (layout_manager_type2 == null) {
            return;
        }
        int i3 = b.f101231a[layout_manager_type2.ordinal()];
        if (i3 == 1) {
            if (layoutManager != null) {
                this.lastVisibleItemPosition = ((LinearLayoutManager) layoutManager).findLastVisibleItemPosition();
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        }
        if (i3 == 2) {
            if (layoutManager != null) {
                this.lastVisibleItemPosition = ((GridLayoutManager) layoutManager).findLastVisibleItemPosition();
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager");
        }
        if (i3 != 3) {
            return;
        }
        if (layoutManager != null) {
            StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) layoutManager;
            if (this.lastPositions == null) {
                this.lastPositions = new int[staggeredGridLayoutManager.getSpanCount()];
            }
            staggeredGridLayoutManager.findLastVisibleItemPositions(this.lastPositions);
            int[] iArr = this.lastPositions;
            if (iArr != null) {
                this.lastVisibleItemPosition = d(iArr);
                return;
            }
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.StaggeredGridLayoutManager");
    }

    private final int d(int[] lastPositions) {
        int i3 = lastPositions[0];
        for (int i16 : lastPositions) {
            if (i16 > i3) {
                i3 = i16;
            }
        }
        return i3;
    }

    public void e() {
    }
}
