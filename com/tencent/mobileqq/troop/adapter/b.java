package com.tencent.mobileqq.troop.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes19.dex */
public class b<T> extends RecyclerView.Adapter<com.tencent.mobileqq.troop.adapter.base.c> {
    static IPatchRedirector $redirector_;
    protected int C;
    protected int D;
    private View E;
    private int F;
    protected boolean G;

    /* renamed from: d, reason: collision with root package name */
    protected List<T> f293780d;

    /* renamed from: e, reason: collision with root package name */
    protected com.tencent.mobileqq.troop.adapter.base.b f293781e;

    /* renamed from: f, reason: collision with root package name */
    protected d f293782f;

    /* renamed from: h, reason: collision with root package name */
    private SparseArray<View> f293783h;

    /* renamed from: i, reason: collision with root package name */
    private SparseArray<View> f293784i;

    /* renamed from: m, reason: collision with root package name */
    protected View f293785m;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class a extends GridLayoutManager.SpanSizeLookup {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ GridLayoutManager f293786a;

        a(GridLayoutManager gridLayoutManager) {
            this.f293786a = gridLayoutManager;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this, (Object) gridLayoutManager);
            }
        }

        @Override // android.support.v7.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanSize(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, i3)).intValue();
            }
            if (!b.this.C(i3) && !b.this.B(i3) && !b.this.D(i3) && !b.this.A()) {
                return 1;
            }
            return this.f293786a.getSpanCount();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.troop.adapter.b$b, reason: collision with other inner class name */
    /* loaded from: classes19.dex */
    public class ViewOnClickListenerC8666b implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.troop.adapter.base.c f293788d;

        ViewOnClickListenerC8666b(com.tencent.mobileqq.troop.adapter.base.c cVar) {
            this.f293788d = cVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this, (Object) cVar);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else if (b.this.f293782f != null) {
                b.this.f293782f.b(view, this.f293788d, this.f293788d.getAdapterPosition());
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class c implements View.OnLongClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.troop.adapter.base.c f293790d;

        c(com.tencent.mobileqq.troop.adapter.base.c cVar) {
            this.f293790d = cVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this, (Object) cVar);
            }
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            boolean z16;
            EventCollector.getInstance().onViewLongClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                z16 = ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view)).booleanValue();
            } else if (b.this.f293782f != null) {
                z16 = b.this.f293782f.a(view, this.f293790d, this.f293790d.getAdapterPosition());
            } else {
                z16 = false;
            }
            EventCollector.getInstance().onViewLongClicked(view);
            return z16;
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public interface d {
        boolean a(View view, RecyclerView.ViewHolder viewHolder, int i3);

        void b(View view, RecyclerView.ViewHolder viewHolder, int i3);
    }

    public b(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f293780d = new ArrayList();
        this.f293783h = new SparseArray<>();
        this.f293784i = new SparseArray<>();
        this.D = -1;
        this.G = false;
        this.f293781e = new com.tencent.mobileqq.troop.adapter.base.b();
    }

    protected boolean A() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return ((Boolean) iPatchRedirector.redirect((short) 33, (Object) this)).booleanValue();
        }
        if ((this.f293785m != null || this.C != 0) && y() == 0) {
            return true;
        }
        return false;
    }

    protected boolean B(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this, i3)).booleanValue();
        }
        if (i3 >= y() + w() + u() && i3 < y() + w() + u() + v()) {
            return true;
        }
        return false;
    }

    protected boolean C(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this, i3)).booleanValue();
        }
        if (i3 < w()) {
            return true;
        }
        return false;
    }

    protected boolean D(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this, i3)).booleanValue();
        }
        if (E() && i3 == y() + w() + u() + v()) {
            return true;
        }
        return false;
    }

    public boolean E() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return ((Boolean) iPatchRedirector.redirect((short) 31, (Object) this)).booleanValue();
        }
        if (this.G && (this.E != null || this.F != 0)) {
            return true;
        }
        return false;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: F, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(com.tencent.mobileqq.troop.adapter.base.c cVar, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) cVar, i3);
        } else if (!C(i3) && !B(i3) && !A() && !D(i3)) {
            s(cVar, J(i3));
        }
        EventCollector.getInstance().onRecyclerBindViewHolder(cVar, i3, getItemId(i3));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: G, reason: merged with bridge method [inline-methods] */
    public com.tencent.mobileqq.troop.adapter.base.c onCreateViewHolder(ViewGroup viewGroup, int i3) {
        SparseArray<View> sparseArray;
        SparseArray<View> sparseArray2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.troop.adapter.base.c) iPatchRedirector.redirect((short) 2, (Object) this, (Object) viewGroup, i3);
        }
        if (i3 == 2147483646) {
            if (this.f293785m != null) {
                return com.tencent.mobileqq.troop.adapter.base.c.b(viewGroup.getContext(), this.f293785m);
            }
            return com.tencent.mobileqq.troop.adapter.base.c.c(viewGroup.getContext(), viewGroup, this.C);
        }
        if (i3 == 2147483645 && E()) {
            if (this.E != null) {
                return com.tencent.mobileqq.troop.adapter.base.c.b(viewGroup.getContext(), this.E);
            }
            return com.tencent.mobileqq.troop.adapter.base.c.c(viewGroup.getContext(), viewGroup, this.F);
        }
        if (i3 >= 1000000 && (sparseArray2 = this.f293783h) != null && sparseArray2.get(i3) != null) {
            return com.tencent.mobileqq.troop.adapter.base.c.b(viewGroup.getContext(), this.f293783h.get(i3));
        }
        if (i3 >= 2000000 && (sparseArray = this.f293784i) != null && sparseArray.get(i3) != null) {
            return com.tencent.mobileqq.troop.adapter.base.c.b(viewGroup.getContext(), this.f293784i.get(i3));
        }
        com.tencent.mobileqq.troop.adapter.base.c t16 = t(viewGroup.getContext(), viewGroup, this.f293781e.c(i3).c());
        I(t16, t16.d());
        L(viewGroup, t16, i3);
        return t16;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: H, reason: merged with bridge method [inline-methods] */
    public void onViewAttachedToWindow(com.tencent.mobileqq.troop.adapter.base.c cVar) {
        ViewGroup.LayoutParams layoutParams;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) cVar);
            return;
        }
        super.onViewAttachedToWindow(cVar);
        if ((C(cVar.getLayoutPosition()) || B(cVar.getLayoutPosition()) || D(cVar.getLayoutPosition()) || A()) && (layoutParams = cVar.itemView.getLayoutParams()) != null && (layoutParams instanceof StaggeredGridLayoutManager.LayoutParams)) {
            ((StaggeredGridLayoutManager.LayoutParams) layoutParams).setFullSpan(true);
        }
    }

    public void I(com.tencent.mobileqq.troop.adapter.base.c cVar, View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) cVar, (Object) view);
        }
    }

    protected T J(int i3) {
        int w3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (T) iPatchRedirector.redirect((short) 7, (Object) this, i3);
        }
        if (this.f293780d == null || (w3 = i3 - w()) >= this.f293780d.size()) {
            return null;
        }
        return this.f293780d.get(w3);
    }

    public void K(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this, (Object) view);
        } else {
            this.f293785m = view;
        }
    }

    protected void L(ViewGroup viewGroup, com.tencent.mobileqq.troop.adapter.base.c cVar, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            iPatchRedirector.redirect((short) 43, this, viewGroup, cVar, Integer.valueOf(i3));
        } else {
            if (!z(i3)) {
                return;
            }
            cVar.d().setOnClickListener(new ViewOnClickListenerC8666b(cVar));
            cVar.d().setOnLongClickListener(new c(cVar));
        }
    }

    public b M(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return (b) iPatchRedirector.redirect((short) 30, (Object) this, i3);
        }
        this.F = i3;
        return this;
    }

    public void N(d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            iPatchRedirector.redirect((short) 47, (Object) this, (Object) dVar);
        } else {
            this.f293782f = dVar;
        }
    }

    protected boolean O() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            return ((Boolean) iPatchRedirector.redirect((short) 46, (Object) this)).booleanValue();
        }
        if (this.f293781e.d() > 0) {
            return true;
        }
        return false;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
        }
        return w() + v() + y() + u() + x();
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i3) {
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this, i3)).intValue();
        }
        if (C(i3)) {
            return this.f293783h.keyAt(i3);
        }
        if (A() && ((i16 = this.D) == -1 || i3 == i16)) {
            this.D = i3;
            return 2147483646;
        }
        if (B(i3)) {
            return this.f293784i.keyAt(((i3 - w()) - y()) - u());
        }
        if (D(i3)) {
            return 2147483645;
        }
        if (O()) {
            return this.f293781e.e(J(i3), i3);
        }
        return super.getItemViewType(i3);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) recyclerView);
            return;
        }
        super.onAttachedToRecyclerView(recyclerView);
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
            gridLayoutManager.setSpanSizeLookup(new a(gridLayoutManager));
            gridLayoutManager.setSpanCount(gridLayoutManager.getSpanCount());
        }
    }

    public void p(List<T> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) list);
            return;
        }
        if (list != null && list.size() > 0) {
            if (A()) {
                notifyItemRemoved(this.D);
                notifyDataSetChanged();
            }
            int w3 = w() + y();
            this.f293780d.addAll(list);
            notifyItemRangeInserted(w3, list.size());
        }
    }

    public b q(com.tencent.mobileqq.troop.adapter.base.a<T> aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            return (b) iPatchRedirector.redirect((short) 44, (Object) this, (Object) aVar);
        }
        this.f293781e.a(aVar);
        return this;
    }

    public void r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else {
            this.f293780d.clear();
            notifyDataSetChanged();
        }
    }

    public void s(com.tencent.mobileqq.troop.adapter.base.c cVar, T t16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) cVar, (Object) t16);
        } else {
            this.f293781e.b(cVar, t16, cVar.getAdapterPosition());
        }
    }

    public com.tencent.mobileqq.troop.adapter.base.c t(Context context, ViewGroup viewGroup, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (com.tencent.mobileqq.troop.adapter.base.c) iPatchRedirector.redirect((short) 5, this, context, viewGroup, Integer.valueOf(i3));
        }
        return com.tencent.mobileqq.troop.adapter.base.c.c(context, viewGroup, i3);
    }

    protected int u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 40)) {
            return A() ? 1 : 0;
        }
        return ((Integer) iPatchRedirector.redirect((short) 40, (Object) this)).intValue();
    }

    public int v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            return ((Integer) iPatchRedirector.redirect((short) 38, (Object) this)).intValue();
        }
        SparseArray<View> sparseArray = this.f293784i;
        if (sparseArray != null) {
            return sparseArray.size();
        }
        return 0;
    }

    public int w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            return ((Integer) iPatchRedirector.redirect((short) 37, (Object) this)).intValue();
        }
        SparseArray<View> sparseArray = this.f293783h;
        if (sparseArray != null) {
            return sparseArray.size();
        }
        return 0;
    }

    protected int x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 39)) {
            return E() ? 1 : 0;
        }
        return ((Integer) iPatchRedirector.redirect((short) 39, (Object) this)).intValue();
    }

    public int y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        List<T> list = this.f293780d;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    protected boolean z(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            return ((Boolean) iPatchRedirector.redirect((short) 42, (Object) this, i3)).booleanValue();
        }
        return true;
    }
}
