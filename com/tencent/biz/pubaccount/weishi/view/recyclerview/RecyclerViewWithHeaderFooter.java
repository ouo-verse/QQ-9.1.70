package com.tencent.biz.pubaccount.weishi.view.recyclerview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.pubaccount.weishi.view.recyclerview.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import z10.d;

/* compiled from: P */
/* loaded from: classes32.dex */
public class RecyclerViewWithHeaderFooter extends RecyclerView {

    /* renamed from: f, reason: collision with root package name */
    private final List<View> f82475f;

    /* renamed from: h, reason: collision with root package name */
    private final List<View> f82476h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f82477i;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class a extends RecyclerView.RecycledViewPool {
        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.RecycledViewPool
        public RecyclerView.ViewHolder getRecycledView(int i3) {
            RecyclerView.Adapter adapter = RecyclerViewWithHeaderFooter.this.getAdapter();
            RecyclerView.ViewHolder recycledView = super.getRecycledView(i3);
            if (recycledView != null && (adapter instanceof com.tencent.biz.pubaccount.weishi.view.recyclerview.a)) {
                com.tencent.biz.pubaccount.weishi.view.recyclerview.a aVar = (com.tencent.biz.pubaccount.weishi.view.recyclerview.a) adapter;
                if (aVar.m0(i3)) {
                    if (!RecyclerViewWithHeaderFooter.this.f82476h.contains(recycledView.itemView)) {
                        putRecycledView(recycledView);
                        return null;
                    }
                } else if (aVar.n0(i3) && !RecyclerViewWithHeaderFooter.this.f82475f.contains(recycledView.itemView)) {
                    putRecycledView(recycledView);
                    return null;
                }
            }
            return recycledView;
        }
    }

    public RecyclerViewWithHeaderFooter(Context context) {
        super(context);
        this.f82475f = new ArrayList();
        this.f82476h = new ArrayList();
        this.f82477i = false;
    }

    public void E(View view) {
        this.f82476h.add(view);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f82477i) {
            super.onInterceptTouchEvent(motionEvent);
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f82477i) {
            if (motionEvent.getAction() == 1) {
                this.f82477i = false;
            }
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setAdapter(RecyclerView.Adapter adapter) {
        if (this.f82475f.size() > 0 || this.f82476h.size() > 0) {
            com.tencent.biz.pubaccount.weishi.view.recyclerview.a aVar = new com.tencent.biz.pubaccount.weishi.view.recyclerview.a(adapter);
            Iterator<View> it = this.f82475f.iterator();
            while (it.hasNext()) {
                aVar.l0(it.next());
            }
            Iterator<View> it5 = this.f82476h.iterator();
            while (it5.hasNext()) {
                aVar.k0(it5.next());
            }
            aVar.setHasStableIds(adapter.hasStableIds());
            if (getLayoutManager() instanceof GridLayoutManager) {
                GridLayoutManager gridLayoutManager = (GridLayoutManager) getLayoutManager();
                gridLayoutManager.setSpanSizeLookup(new d(aVar, gridLayoutManager));
            }
            adapter = aVar;
        }
        super.setAdapter(adapter);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setLayoutManager(RecyclerView.LayoutManager layoutManager) {
        super.setLayoutManager(layoutManager);
        if (getAdapter() == null || !(getAdapter() instanceof com.tencent.biz.pubaccount.weishi.view.recyclerview.a)) {
            return;
        }
        com.tencent.biz.pubaccount.weishi.view.recyclerview.a aVar = (com.tencent.biz.pubaccount.weishi.view.recyclerview.a) getAdapter();
        if (getLayoutManager() instanceof GridLayoutManager) {
            GridLayoutManager gridLayoutManager = (GridLayoutManager) getLayoutManager();
            d dVar = new d(aVar, gridLayoutManager);
            dVar.a(gridLayoutManager.getSpanSizeLookup());
            gridLayoutManager.setSpanSizeLookup(dVar);
        }
    }

    public void setOnBindHeaderObserver(a.e eVar) {
        if (getAdapter() instanceof com.tencent.biz.pubaccount.weishi.view.recyclerview.a) {
            ((com.tencent.biz.pubaccount.weishi.view.recyclerview.a) getAdapter()).p0(eVar);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setRecycledViewPool(RecyclerView.RecycledViewPool recycledViewPool) {
        super.setRecycledViewPool(new a());
    }

    public RecyclerViewWithHeaderFooter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f82475f = new ArrayList();
        this.f82476h = new ArrayList();
        this.f82477i = false;
    }

    public RecyclerViewWithHeaderFooter(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f82475f = new ArrayList();
        this.f82476h = new ArrayList();
        this.f82477i = false;
    }
}
