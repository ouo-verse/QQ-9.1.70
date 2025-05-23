package com.tencent.sqshow.zootopia.view.pull2refresh.androidx;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes34.dex */
public class a<T extends RecyclerView.Adapter> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final List<View> C = new ArrayList();
    private final List<View> D = new ArrayList();

    /* renamed from: m, reason: collision with root package name */
    private final T f373382m;

    /* compiled from: P */
    /* loaded from: classes34.dex */
    class b extends RecyclerView.ViewHolder {
        b(View view) {
            super(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes34.dex */
    class c extends RecyclerView.ViewHolder {
        c(View view) {
            super(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes34.dex */
    public interface d {
    }

    /* compiled from: P */
    /* loaded from: classes34.dex */
    public interface e {
    }

    public a(T t16) {
        this.f373382m = t16;
        t16.registerAdapterDataObserver(new C9845a());
    }

    static /* synthetic */ d i0(a aVar) {
        aVar.getClass();
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.C.size() + this.f373382m.getItemCount() + this.D.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i3) {
        if (i3 < this.C.size()) {
            return this.C.get(i3).hashCode();
        }
        if (i3 < this.C.size() + this.f373382m.getItemCount()) {
            return this.f373382m.getItemId(i3 - this.C.size());
        }
        return this.D.get((i3 - this.C.size()) - this.f373382m.getItemCount()).hashCode();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i3) {
        if (i3 < this.C.size()) {
            return i3 - 1000;
        }
        if (i3 < this.C.size() + this.f373382m.getItemCount()) {
            return this.f373382m.getItemViewType(i3 - this.C.size());
        }
        return ((i3 - 2000) - this.C.size()) - this.f373382m.getItemCount();
    }

    public void k0(View view) {
        this.D.add(view);
    }

    public void l0(View view) {
        this.C.add(view);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i3, List<Object> list) {
        if (i3 < this.C.size()) {
            super.onBindViewHolder(viewHolder, i3, list);
        } else if (i3 < this.C.size() + this.f373382m.getItemCount()) {
            this.f373382m.onBindViewHolder(viewHolder, i3 - this.C.size(), list);
        } else {
            super.onBindViewHolder(viewHolder, i3, list);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i3) {
        if (n0(i3)) {
            return new b(this.C.get(Math.abs(i3 + 1000)));
        }
        if (m0(i3)) {
            return new c(this.D.get(Math.abs(i3 + 2000)));
        }
        return this.f373382m.onCreateViewHolder(viewGroup, i3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
        super.onViewAttachedToWindow(viewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(RecyclerView.ViewHolder viewHolder) {
        super.onViewDetachedFromWindow(viewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
        super.onViewRecycled(viewHolder);
    }

    /* compiled from: P */
    /* renamed from: com.tencent.sqshow.zootopia.view.pull2refresh.androidx.a$a, reason: collision with other inner class name */
    /* loaded from: classes34.dex */
    class C9845a extends RecyclerView.AdapterDataObserver {
        C9845a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            a.this.notifyDataSetChanged();
            a.i0(a.this);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i3, int i16) {
            a aVar = a.this;
            aVar.notifyItemRangeChanged(i3 + aVar.C.size(), i16);
            a.i0(a.this);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeInserted(int i3, int i16) {
            a aVar = a.this;
            aVar.notifyItemRangeInserted(i3 + aVar.C.size(), i16);
            a.i0(a.this);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeMoved(int i3, int i16, int i17) {
            a aVar = a.this;
            aVar.notifyItemMoved(i3 + aVar.C.size(), i16 + a.this.C.size());
            a.i0(a.this);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeRemoved(int i3, int i16) {
            a aVar = a.this;
            aVar.notifyItemRangeRemoved(i3 + aVar.C.size(), i16);
            a.i0(a.this);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i3, int i16, Object obj) {
            a aVar = a.this;
            aVar.notifyItemRangeChanged(i3 + aVar.C.size(), i16, obj);
            a.i0(a.this);
        }
    }

    public boolean m0(int i3) {
        return i3 >= -2000 && i3 < this.D.size() + (-2000);
    }

    public boolean n0(int i3) {
        return i3 >= -1000 && i3 < this.C.size() + (-1000);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i3) {
        StaggeredGridLayoutManager.LayoutParams layoutParams;
        if (i3 < this.C.size()) {
            layoutParams = StaggeredGridLayoutManager.LayoutParams.class.isInstance(viewHolder.itemView.getLayoutParams()) ? (StaggeredGridLayoutManager.LayoutParams) viewHolder.itemView.getLayoutParams() : null;
            if (layoutParams == null) {
                layoutParams = new StaggeredGridLayoutManager.LayoutParams(-1, -2);
                viewHolder.itemView.setLayoutParams(layoutParams);
            }
            layoutParams.setFullSpan(true);
            o0(viewHolder, i3);
            return;
        }
        if (i3 < this.C.size() + this.f373382m.getItemCount()) {
            this.f373382m.onBindViewHolder(viewHolder, i3 - this.C.size());
            return;
        }
        layoutParams = StaggeredGridLayoutManager.LayoutParams.class.isInstance(viewHolder.itemView.getLayoutParams()) ? (StaggeredGridLayoutManager.LayoutParams) viewHolder.itemView.getLayoutParams() : null;
        if (layoutParams == null) {
            layoutParams = new StaggeredGridLayoutManager.LayoutParams(-1, -2);
            viewHolder.itemView.setLayoutParams(layoutParams);
        }
        layoutParams.setFullSpan(true);
    }

    public void p0(e eVar) {
    }

    protected void o0(RecyclerView.ViewHolder viewHolder, int i3) {
    }
}
