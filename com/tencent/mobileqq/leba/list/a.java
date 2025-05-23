package com.tencent.mobileqq.leba.list;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import androidx.collection.SparseArrayCompat;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes15.dex */
public class a extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private SparseArrayCompat<View> f240638d;

    /* renamed from: e, reason: collision with root package name */
    private SparseArrayCompat<View> f240639e;

    /* renamed from: f, reason: collision with root package name */
    private RecyclerView.Adapter f240640f;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.leba.list.a$a, reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    class C7964a implements d {
        static IPatchRedirector $redirector_;

        C7964a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            }
        }

        @Override // com.tencent.mobileqq.leba.list.a.d
        public int a(GridLayoutManager gridLayoutManager, GridLayoutManager.SpanSizeLookup spanSizeLookup, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, this, gridLayoutManager, spanSizeLookup, Integer.valueOf(i3))).intValue();
            }
            int itemViewType = a.this.getItemViewType(i3);
            if (a.this.f240638d.get(itemViewType) != null) {
                return gridLayoutManager.getSpanCount();
            }
            if (a.this.f240639e.get(itemViewType) != null) {
                return gridLayoutManager.getSpanCount();
            }
            if (spanSizeLookup == null) {
                return 1;
            }
            return spanSizeLookup.getSpanSize(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class b extends GridLayoutManager.SpanSizeLookup {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f240642a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ GridLayoutManager f240643b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ GridLayoutManager.SpanSizeLookup f240644c;

        b(d dVar, GridLayoutManager gridLayoutManager, GridLayoutManager.SpanSizeLookup spanSizeLookup) {
            this.f240642a = dVar;
            this.f240643b = gridLayoutManager;
            this.f240644c = spanSizeLookup;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, dVar, gridLayoutManager, spanSizeLookup);
            }
        }

        @Override // android.support.v7.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanSize(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, i3)).intValue();
            }
            return this.f240642a.a(this.f240643b, this.f240644c, i3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class c extends RecyclerView.ViewHolder {
        static IPatchRedirector $redirector_;

        public c(View view) {
            super(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) view);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public interface d {
        int a(GridLayoutManager gridLayoutManager, GridLayoutManager.SpanSizeLookup spanSizeLookup, int i3);
    }

    public a(RecyclerView.Adapter adapter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) adapter);
            return;
        }
        this.f240638d = new SparseArrayCompat<>();
        this.f240639e = new SparseArrayCompat<>();
        this.f240640f = adapter;
    }

    public static RecyclerView.ViewHolder r(Context context, View view) {
        return new c(view);
    }

    private int u() {
        return this.f240640f.getItemCount();
    }

    private boolean v(int i3) {
        if (i3 >= t() + u()) {
            return true;
        }
        return false;
    }

    private boolean w(int i3) {
        if (i3 < t()) {
            return true;
        }
        return false;
    }

    public static void x(RecyclerView.Adapter adapter, RecyclerView recyclerView, d dVar) {
        adapter.onAttachedToRecyclerView(recyclerView);
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
            gridLayoutManager.setSpanSizeLookup(new b(dVar, gridLayoutManager, gridLayoutManager.getSpanSizeLookup()));
            gridLayoutManager.setSpanCount(gridLayoutManager.getSpanCount());
        }
    }

    public static void y(RecyclerView.ViewHolder viewHolder) {
        ViewGroup.LayoutParams layoutParams = viewHolder.itemView.getLayoutParams();
        if (layoutParams instanceof StaggeredGridLayoutManager.LayoutParams) {
            ((StaggeredGridLayoutManager.LayoutParams) layoutParams).setFullSpan(true);
        }
    }

    public void addHeaderView(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) view);
        } else {
            SparseArrayCompat<View> sparseArrayCompat = this.f240638d;
            sparseArrayCompat.put(sparseArrayCompat.size() + 100000, view);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return t() + s() + u();
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this, i3)).intValue();
        }
        if (w(i3)) {
            return this.f240638d.keyAt(i3);
        }
        if (v(i3)) {
            return this.f240639e.keyAt((i3 - t()) - u());
        }
        return this.f240640f.getItemViewType(i3 - t());
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) recyclerView);
        } else {
            x(this.f240640f, recyclerView, new C7964a());
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) viewHolder, i3);
        } else if (!w(i3) && !v(i3)) {
            this.f240640f.onBindViewHolder(viewHolder, i3 - t());
        }
        EventCollector.getInstance().onRecyclerBindViewHolder(viewHolder, i3, getItemId(i3));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (RecyclerView.ViewHolder) iPatchRedirector.redirect((short) 2, (Object) this, (Object) viewGroup, i3);
        }
        if (this.f240638d.get(i3) != null) {
            return r(viewGroup.getContext(), this.f240638d.get(i3));
        }
        if (this.f240639e.get(i3) != null) {
            return r(viewGroup.getContext(), this.f240639e.get(i3));
        }
        return this.f240640f.onCreateViewHolder(viewGroup, i3);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) viewHolder);
            return;
        }
        this.f240640f.onViewAttachedToWindow(viewHolder);
        int layoutPosition = viewHolder.getLayoutPosition();
        if (w(layoutPosition) || v(layoutPosition)) {
            y(viewHolder);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void registerAdapterDataObserver(RecyclerView.AdapterDataObserver adapterDataObserver) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) adapterDataObserver);
        } else {
            this.f240640f.registerAdapterDataObserver(adapterDataObserver);
        }
    }

    public int s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        return this.f240639e.size();
    }

    public int t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return this.f240638d.size();
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void unregisterAdapterDataObserver(RecyclerView.AdapterDataObserver adapterDataObserver) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) adapterDataObserver);
        } else {
            this.f240640f.unregisterAdapterDataObserver(adapterDataObserver);
        }
    }
}
