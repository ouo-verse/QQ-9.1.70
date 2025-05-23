package com.tencent.ecommerce.base.ui.refreshview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ecommerce.base.ui.refreshview.RecyclerViewHeaderViewAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes32.dex */
public class RecyclerViewWithHeaderFooter extends RecyclerView {
    private RecyclerViewHeaderViewAdapter.OnBindHeaderObserver C;

    /* renamed from: f, reason: collision with root package name */
    private final List<View> f101211f;

    /* renamed from: h, reason: collision with root package name */
    private final List<View> f101212h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f101213i;

    /* renamed from: m, reason: collision with root package name */
    private RecyclerViewHeaderViewAdapter.ContentDataObserver f101214m;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class a extends RecyclerView.RecycledViewPool {
        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.RecycledViewPool
        public RecyclerView.ViewHolder getRecycledView(int i3) {
            RecyclerView.Adapter adapter = RecyclerViewWithHeaderFooter.this.getAdapter();
            RecyclerView.ViewHolder recycledView = super.getRecycledView(i3);
            if (recycledView != null && (adapter instanceof RecyclerViewHeaderViewAdapter)) {
                RecyclerViewHeaderViewAdapter recyclerViewHeaderViewAdapter = (RecyclerViewHeaderViewAdapter) adapter;
                if (recyclerViewHeaderViewAdapter.n0(i3)) {
                    if (!RecyclerViewWithHeaderFooter.this.f101212h.contains(recycledView.itemView)) {
                        putRecycledView(recycledView);
                        return null;
                    }
                } else if (recyclerViewHeaderViewAdapter.o0(i3) && !RecyclerViewWithHeaderFooter.this.f101211f.contains(recycledView.itemView)) {
                    putRecycledView(recycledView);
                    return null;
                }
            }
            return recycledView;
        }
    }

    public RecyclerViewWithHeaderFooter(Context context) {
        super(context);
        this.f101211f = new ArrayList();
        this.f101212h = new ArrayList();
        this.f101213i = false;
    }

    public void E(View view) {
        this.f101212h.add(view);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f101213i) {
            super.onInterceptTouchEvent(motionEvent);
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f101213i) {
            if (motionEvent.getAction() == 1) {
                this.f101213i = false;
            }
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setAdapter(RecyclerView.Adapter adapter) {
        if (this.f101211f.size() > 0 || this.f101212h.size() > 0) {
            RecyclerViewHeaderViewAdapter recyclerViewHeaderViewAdapter = new RecyclerViewHeaderViewAdapter(adapter);
            Iterator<View> it = this.f101211f.iterator();
            while (it.hasNext()) {
                recyclerViewHeaderViewAdapter.m0(it.next());
            }
            Iterator<View> it5 = this.f101212h.iterator();
            while (it5.hasNext()) {
                recyclerViewHeaderViewAdapter.l0(it5.next());
            }
            recyclerViewHeaderViewAdapter.setHasStableIds(adapter.hasStableIds());
            if (getLayoutManager() instanceof GridLayoutManager) {
                GridLayoutManager gridLayoutManager = (GridLayoutManager) getLayoutManager();
                gridLayoutManager.setSpanSizeLookup(new com.tencent.ecommerce.base.ui.refreshview.a(recyclerViewHeaderViewAdapter, gridLayoutManager));
            }
            RecyclerViewHeaderViewAdapter.ContentDataObserver contentDataObserver = this.f101214m;
            if (contentDataObserver != null) {
                recyclerViewHeaderViewAdapter.r0(contentDataObserver);
            }
            RecyclerViewHeaderViewAdapter.OnBindHeaderObserver onBindHeaderObserver = this.C;
            if (onBindHeaderObserver != null) {
                recyclerViewHeaderViewAdapter.s0(onBindHeaderObserver);
            }
            adapter = recyclerViewHeaderViewAdapter;
        }
        super.setAdapter(adapter);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setLayoutManager(RecyclerView.LayoutManager layoutManager) {
        super.setLayoutManager(layoutManager);
        if (getAdapter() == null || !(getAdapter() instanceof RecyclerViewHeaderViewAdapter)) {
            return;
        }
        RecyclerViewHeaderViewAdapter recyclerViewHeaderViewAdapter = (RecyclerViewHeaderViewAdapter) getAdapter();
        if (getLayoutManager() instanceof GridLayoutManager) {
            GridLayoutManager gridLayoutManager = (GridLayoutManager) getLayoutManager();
            com.tencent.ecommerce.base.ui.refreshview.a aVar = new com.tencent.ecommerce.base.ui.refreshview.a(recyclerViewHeaderViewAdapter, gridLayoutManager);
            aVar.a(gridLayoutManager.getSpanSizeLookup());
            gridLayoutManager.setSpanSizeLookup(aVar);
        }
    }

    public void setOnBindHeaderObserver(RecyclerViewHeaderViewAdapter.OnBindHeaderObserver onBindHeaderObserver) {
        this.C = onBindHeaderObserver;
        if (getAdapter() instanceof RecyclerViewHeaderViewAdapter) {
            ((RecyclerViewHeaderViewAdapter) getAdapter()).s0(onBindHeaderObserver);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setRecycledViewPool(RecyclerView.RecycledViewPool recycledViewPool) {
        super.setRecycledViewPool(new a());
    }

    public RecyclerViewWithHeaderFooter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f101211f = new ArrayList();
        this.f101212h = new ArrayList();
        this.f101213i = false;
    }

    public RecyclerViewWithHeaderFooter(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f101211f = new ArrayList();
        this.f101212h = new ArrayList();
        this.f101213i = false;
    }
}
