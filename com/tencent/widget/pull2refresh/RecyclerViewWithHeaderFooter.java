package com.tencent.widget.pull2refresh;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.widget.pull2refresh.RecyclerViewHeaderViewAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes27.dex */
public class RecyclerViewWithHeaderFooter extends RecyclerViewCompat {
    static IPatchRedirector $redirector_;
    private RecyclerViewHeaderViewAdapter.ContentDataObserver contentDataObserver;
    private final List<View> mFooters;
    private final List<View> mHeaders;
    public boolean mInterceptTouchEvent;
    private RecyclerViewHeaderViewAdapter.OnBindHeaderObserver onBindHeaderObserver;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    class a extends RecyclerView.RecycledViewPool {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) RecyclerViewWithHeaderFooter.this);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.RecycledViewPool
        public RecyclerView.ViewHolder getRecycledView(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (RecyclerView.ViewHolder) iPatchRedirector.redirect((short) 2, (Object) this, i3);
            }
            RecyclerView.Adapter adapter = RecyclerViewWithHeaderFooter.this.getAdapter();
            RecyclerView.ViewHolder recycledView = super.getRecycledView(i3);
            if (recycledView != null && (adapter instanceof RecyclerViewHeaderViewAdapter)) {
                RecyclerViewHeaderViewAdapter recyclerViewHeaderViewAdapter = (RecyclerViewHeaderViewAdapter) adapter;
                if (recyclerViewHeaderViewAdapter.isFooter(i3)) {
                    if (!RecyclerViewWithHeaderFooter.this.mFooters.contains(recycledView.itemView)) {
                        putRecycledView(recycledView);
                        return null;
                    }
                } else if (recyclerViewHeaderViewAdapter.isHeader(i3) && !RecyclerViewWithHeaderFooter.this.mHeaders.contains(recycledView.itemView)) {
                    putRecycledView(recycledView);
                    return null;
                }
            }
            return recycledView;
        }
    }

    public RecyclerViewWithHeaderFooter(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.mHeaders = new ArrayList();
        this.mFooters = new ArrayList();
        this.mInterceptTouchEvent = false;
    }

    public void addFooterView(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) view);
        } else {
            this.mFooters.add(view);
        }
    }

    public void addHeaderView(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) view);
        } else {
            this.mHeaders.add(view);
        }
    }

    public RecyclerViewHeaderViewAdapter.ContentDataObserver getContentDataObserver() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (RecyclerViewHeaderViewAdapter.ContentDataObserver) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this.contentDataObserver;
    }

    public int getFooterViewsCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        List<View> list = this.mFooters;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public int getHeaderViewsCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        List<View> list = this.mHeaders;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public boolean hasHeader(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) view)).booleanValue();
        }
        return this.mHeaders.contains(view);
    }

    @Override // android.support.v7.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this, (Object) motionEvent)).booleanValue();
        }
        if (this.mInterceptTouchEvent) {
            super.onInterceptTouchEvent(motionEvent);
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.support.v7.widget.RecyclerView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this, (Object) motionEvent)).booleanValue();
        }
        if (this.mInterceptTouchEvent) {
            if (motionEvent.getAction() == 1) {
                this.mInterceptTouchEvent = false;
            }
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void removeFooterView(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) view);
        } else {
            this.mFooters.remove(view);
        }
    }

    public void removeHeaderView(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) view);
        } else {
            this.mHeaders.remove(view);
        }
    }

    @Override // com.tencent.widget.pull2refresh.RecyclerViewCompat, android.support.v7.widget.RecyclerView
    public void setAdapter(RecyclerView.Adapter adapter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) adapter);
            return;
        }
        if (this.mHeaders.size() > 0 || this.mFooters.size() > 0) {
            RecyclerViewHeaderViewAdapter recyclerViewHeaderViewAdapter = new RecyclerViewHeaderViewAdapter(adapter);
            Iterator<View> it = this.mHeaders.iterator();
            while (it.hasNext()) {
                recyclerViewHeaderViewAdapter.addHeader(it.next());
            }
            Iterator<View> it5 = this.mFooters.iterator();
            while (it5.hasNext()) {
                recyclerViewHeaderViewAdapter.addFooter(it5.next());
            }
            recyclerViewHeaderViewAdapter.setHasStableIds(adapter.hasStableIds());
            if (getLayoutManager() instanceof GridLayoutManager) {
                GridLayoutManager gridLayoutManager = (GridLayoutManager) getLayoutManager();
                gridLayoutManager.setSpanSizeLookup(new HeaderSpanSizeLookup(recyclerViewHeaderViewAdapter, gridLayoutManager));
            }
            RecyclerViewHeaderViewAdapter.ContentDataObserver contentDataObserver = this.contentDataObserver;
            if (contentDataObserver != null) {
                recyclerViewHeaderViewAdapter.setContentDataObserver(contentDataObserver);
            }
            RecyclerViewHeaderViewAdapter.OnBindHeaderObserver onBindHeaderObserver = this.onBindHeaderObserver;
            if (onBindHeaderObserver != null) {
                recyclerViewHeaderViewAdapter.setOnBindHeaderObserver(onBindHeaderObserver);
            }
            adapter = recyclerViewHeaderViewAdapter;
        }
        super.setAdapter(adapter);
    }

    public RecyclerViewWithHeaderFooter setContentDataObserver(RecyclerViewHeaderViewAdapter.ContentDataObserver contentDataObserver) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (RecyclerViewWithHeaderFooter) iPatchRedirector.redirect((short) 14, (Object) this, (Object) contentDataObserver);
        }
        this.contentDataObserver = contentDataObserver;
        RecyclerView.Adapter adapter = getAdapter();
        if (adapter != null && (adapter instanceof RecyclerViewHeaderViewAdapter)) {
            ((RecyclerViewHeaderViewAdapter) adapter).setContentDataObserver(contentDataObserver);
        }
        return this;
    }

    @Override // android.support.v7.widget.RecyclerView
    public void setLayoutManager(RecyclerView.LayoutManager layoutManager) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) layoutManager);
            return;
        }
        super.setLayoutManager(layoutManager);
        if (getAdapter() != null && (getAdapter() instanceof RecyclerViewHeaderViewAdapter)) {
            RecyclerViewHeaderViewAdapter recyclerViewHeaderViewAdapter = (RecyclerViewHeaderViewAdapter) getAdapter();
            if (getLayoutManager() instanceof GridLayoutManager) {
                GridLayoutManager gridLayoutManager = (GridLayoutManager) getLayoutManager();
                HeaderSpanSizeLookup headerSpanSizeLookup = new HeaderSpanSizeLookup(recyclerViewHeaderViewAdapter, gridLayoutManager);
                headerSpanSizeLookup.setSpanSizeLookup(gridLayoutManager.getSpanSizeLookup());
                gridLayoutManager.setSpanSizeLookup(headerSpanSizeLookup);
            }
        }
    }

    public void setOnBindHeaderObserver(RecyclerViewHeaderViewAdapter.OnBindHeaderObserver onBindHeaderObserver) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) onBindHeaderObserver);
            return;
        }
        this.onBindHeaderObserver = onBindHeaderObserver;
        if (getAdapter() instanceof RecyclerViewHeaderViewAdapter) {
            ((RecyclerViewHeaderViewAdapter) getAdapter()).setOnBindHeaderObserver(onBindHeaderObserver);
        }
    }

    @Override // android.support.v7.widget.RecyclerView
    public void setRecycledViewPool(RecyclerView.RecycledViewPool recycledViewPool) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) recycledViewPool);
        } else {
            super.setRecycledViewPool(new a());
        }
    }

    public RecyclerViewWithHeaderFooter(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.mHeaders = new ArrayList();
        this.mFooters = new ArrayList();
        this.mInterceptTouchEvent = false;
    }

    public RecyclerViewWithHeaderFooter(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.mHeaders = new ArrayList();
        this.mFooters = new ArrayList();
        this.mInterceptTouchEvent = false;
    }
}
