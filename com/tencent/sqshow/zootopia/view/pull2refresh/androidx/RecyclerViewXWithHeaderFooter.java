package com.tencent.sqshow.zootopia.view.pull2refresh.androidx;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.sqshow.zootopia.view.pull2refresh.androidx.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes34.dex */
public class RecyclerViewXWithHeaderFooter extends NestTouchFixRecyclerView {
    private final List<View> C;
    private final List<View> D;
    public boolean E;

    /* compiled from: P */
    /* loaded from: classes34.dex */
    class a extends RecyclerView.RecycledViewPool {
        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.RecycledViewPool
        public RecyclerView.ViewHolder getRecycledView(int i3) {
            RecyclerView.Adapter adapter = RecyclerViewXWithHeaderFooter.this.getAdapter();
            RecyclerView.ViewHolder recycledView = super.getRecycledView(i3);
            if (recycledView != null && (adapter instanceof com.tencent.sqshow.zootopia.view.pull2refresh.androidx.a)) {
                com.tencent.sqshow.zootopia.view.pull2refresh.androidx.a aVar = (com.tencent.sqshow.zootopia.view.pull2refresh.androidx.a) adapter;
                if (aVar.m0(i3)) {
                    if (!RecyclerViewXWithHeaderFooter.this.D.contains(recycledView.itemView)) {
                        putRecycledView(recycledView);
                        return null;
                    }
                } else if (aVar.n0(i3) && !RecyclerViewXWithHeaderFooter.this.C.contains(recycledView.itemView)) {
                    putRecycledView(recycledView);
                    return null;
                }
            }
            return recycledView;
        }
    }

    public RecyclerViewXWithHeaderFooter(Context context) {
        super(context);
        this.C = new ArrayList();
        this.D = new ArrayList();
        this.E = false;
    }

    public void E(View view) {
        this.D.add(view);
    }

    @Override // com.tencent.sqshow.zootopia.view.pull2refresh.androidx.NestTouchFixRecyclerView, androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.E) {
            super.onInterceptTouchEvent(motionEvent);
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.E) {
            if (motionEvent.getAction() == 1) {
                this.E = false;
            }
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setAdapter(RecyclerView.Adapter adapter) {
        if (this.C.size() > 0 || this.D.size() > 0) {
            com.tencent.sqshow.zootopia.view.pull2refresh.androidx.a aVar = new com.tencent.sqshow.zootopia.view.pull2refresh.androidx.a(adapter);
            Iterator<View> it = this.C.iterator();
            while (it.hasNext()) {
                aVar.l0(it.next());
            }
            Iterator<View> it5 = this.D.iterator();
            while (it5.hasNext()) {
                aVar.k0(it5.next());
            }
            aVar.setHasStableIds(adapter.hasStableIds());
            if (getLayoutManager() instanceof GridLayoutManager) {
                GridLayoutManager gridLayoutManager = (GridLayoutManager) getLayoutManager();
                rc4.a aVar2 = new rc4.a(aVar, gridLayoutManager);
                aVar2.a(gridLayoutManager.getSpanSizeLookup());
                gridLayoutManager.setSpanSizeLookup(aVar2);
            }
            adapter = aVar;
        }
        super.setAdapter(adapter);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setLayoutManager(RecyclerView.LayoutManager layoutManager) {
        super.setLayoutManager(layoutManager);
        if (getAdapter() == null || !(getAdapter() instanceof com.tencent.sqshow.zootopia.view.pull2refresh.androidx.a)) {
            return;
        }
        com.tencent.sqshow.zootopia.view.pull2refresh.androidx.a aVar = (com.tencent.sqshow.zootopia.view.pull2refresh.androidx.a) getAdapter();
        if (getLayoutManager() instanceof GridLayoutManager) {
            GridLayoutManager gridLayoutManager = (GridLayoutManager) getLayoutManager();
            rc4.a aVar2 = new rc4.a(aVar, gridLayoutManager);
            aVar2.a(gridLayoutManager.getSpanSizeLookup());
            gridLayoutManager.setSpanSizeLookup(aVar2);
        }
    }

    public void setOnBindHeaderObserver(a.e eVar) {
        if (getAdapter() instanceof com.tencent.sqshow.zootopia.view.pull2refresh.androidx.a) {
            ((com.tencent.sqshow.zootopia.view.pull2refresh.androidx.a) getAdapter()).p0(eVar);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setRecycledViewPool(RecyclerView.RecycledViewPool recycledViewPool) {
        super.setRecycledViewPool(new a());
    }

    public RecyclerViewXWithHeaderFooter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.C = new ArrayList();
        this.D = new ArrayList();
        this.E = false;
    }

    public RecyclerViewXWithHeaderFooter(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.C = new ArrayList();
        this.D = new ArrayList();
        this.E = false;
    }
}
