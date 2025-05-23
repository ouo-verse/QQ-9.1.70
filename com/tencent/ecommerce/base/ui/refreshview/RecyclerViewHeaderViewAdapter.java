package com.tencent.ecommerce.base.ui.refreshview;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes32.dex */
public class RecyclerViewHeaderViewAdapter<T extends RecyclerView.Adapter> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final List<View> C = new ArrayList();
    private final List<View> D = new ArrayList();
    private ContentDataObserver E;
    private OnBindHeaderObserver F;

    /* renamed from: m, reason: collision with root package name */
    private final T f101209m;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface ContentDataObserver {
        void contentDataChange(RecyclerView.Adapter adapter);
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface OnBindHeaderObserver {
        void onBindHeader(RecyclerView.ViewHolder viewHolder, int i3);
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class b extends RecyclerView.ViewHolder {
        b(View view) {
            super(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class c extends RecyclerView.ViewHolder {
        c(View view) {
            super(view);
        }
    }

    public RecyclerViewHeaderViewAdapter(T t16) {
        this.f101209m = t16;
        t16.registerAdapterDataObserver(new a());
    }

    public int getHeaderCount() {
        return this.C.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.C.size() + this.f101209m.getItemCount() + this.D.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i3) {
        if (i3 < this.C.size()) {
            return this.C.get(i3).hashCode();
        }
        if (i3 < this.C.size() + this.f101209m.getItemCount()) {
            return this.f101209m.getItemId(i3 - this.C.size());
        }
        return this.D.get((i3 - this.C.size()) - this.f101209m.getItemCount()).hashCode();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i3) {
        if (i3 < this.C.size()) {
            return i3 - 1000;
        }
        if (i3 < this.C.size() + this.f101209m.getItemCount()) {
            return this.f101209m.getItemViewType(i3 - this.C.size());
        }
        return ((i3 - 2000) - this.C.size()) - this.f101209m.getItemCount();
    }

    public boolean isFooterPosition(int i3) {
        return i3 >= getItemCount() - this.D.size();
    }

    public boolean isHeaderPosition(int i3) {
        return i3 < this.C.size();
    }

    public void l0(View view) {
        this.D.add(view);
    }

    public void m0(View view) {
        this.C.add(view);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i3, List<Object> list) {
        if (i3 < this.C.size()) {
            super.onBindViewHolder(viewHolder, i3, list);
        } else if (i3 < this.C.size() + this.f101209m.getItemCount()) {
            this.f101209m.onBindViewHolder(viewHolder, i3 - this.C.size(), list);
        } else {
            super.onBindViewHolder(viewHolder, i3, list);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i3) {
        if (o0(i3)) {
            return new b(this.C.get(Math.abs(i3 + 1000)));
        }
        if (n0(i3)) {
            return new c(this.D.get(Math.abs(i3 + 2000)));
        }
        return this.f101209m.onCreateViewHolder(viewGroup, i3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
        super.onViewAttachedToWindow(viewHolder);
        T t16 = this.f101209m;
        if (t16 != null) {
            t16.onViewAttachedToWindow(viewHolder);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(RecyclerView.ViewHolder viewHolder) {
        super.onViewDetachedFromWindow(viewHolder);
        T t16 = this.f101209m;
        if (t16 != null) {
            t16.onViewDetachedFromWindow(viewHolder);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
        super.onViewRecycled(viewHolder);
        T t16 = this.f101209m;
        if (t16 != null) {
            t16.onViewRecycled(viewHolder);
        }
    }

    protected void p0(RecyclerView.ViewHolder viewHolder, int i3) {
        OnBindHeaderObserver onBindHeaderObserver = this.F;
        if (onBindHeaderObserver != null) {
            onBindHeaderObserver.onBindHeader(viewHolder, i3);
        }
    }

    public void q0(View view) {
        this.C.remove(view);
    }

    public RecyclerViewHeaderViewAdapter r0(ContentDataObserver contentDataObserver) {
        this.E = contentDataObserver;
        return this;
    }

    public void s0(OnBindHeaderObserver onBindHeaderObserver) {
        this.F = onBindHeaderObserver;
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class a extends RecyclerView.AdapterDataObserver {
        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            RecyclerViewHeaderViewAdapter.this.notifyDataSetChanged();
            if (RecyclerViewHeaderViewAdapter.this.E != null) {
                RecyclerViewHeaderViewAdapter.this.E.contentDataChange(RecyclerViewHeaderViewAdapter.this.f101209m);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i3, int i16) {
            RecyclerViewHeaderViewAdapter recyclerViewHeaderViewAdapter = RecyclerViewHeaderViewAdapter.this;
            recyclerViewHeaderViewAdapter.notifyItemRangeChanged(i3 + recyclerViewHeaderViewAdapter.C.size(), i16);
            if (RecyclerViewHeaderViewAdapter.this.E != null) {
                RecyclerViewHeaderViewAdapter.this.E.contentDataChange(RecyclerViewHeaderViewAdapter.this.f101209m);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeInserted(int i3, int i16) {
            RecyclerViewHeaderViewAdapter recyclerViewHeaderViewAdapter = RecyclerViewHeaderViewAdapter.this;
            recyclerViewHeaderViewAdapter.notifyItemRangeInserted(i3 + recyclerViewHeaderViewAdapter.C.size(), i16);
            if (RecyclerViewHeaderViewAdapter.this.E != null) {
                RecyclerViewHeaderViewAdapter.this.E.contentDataChange(RecyclerViewHeaderViewAdapter.this.f101209m);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeMoved(int i3, int i16, int i17) {
            RecyclerViewHeaderViewAdapter recyclerViewHeaderViewAdapter = RecyclerViewHeaderViewAdapter.this;
            recyclerViewHeaderViewAdapter.notifyItemMoved(i3 + recyclerViewHeaderViewAdapter.C.size(), i16 + RecyclerViewHeaderViewAdapter.this.C.size());
            if (RecyclerViewHeaderViewAdapter.this.E != null) {
                RecyclerViewHeaderViewAdapter.this.E.contentDataChange(RecyclerViewHeaderViewAdapter.this.f101209m);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeRemoved(int i3, int i16) {
            RecyclerViewHeaderViewAdapter recyclerViewHeaderViewAdapter = RecyclerViewHeaderViewAdapter.this;
            recyclerViewHeaderViewAdapter.notifyItemRangeRemoved(i3 + recyclerViewHeaderViewAdapter.C.size(), i16);
            if (RecyclerViewHeaderViewAdapter.this.E != null) {
                RecyclerViewHeaderViewAdapter.this.E.contentDataChange(RecyclerViewHeaderViewAdapter.this.f101209m);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i3, int i16, Object obj) {
            RecyclerViewHeaderViewAdapter recyclerViewHeaderViewAdapter = RecyclerViewHeaderViewAdapter.this;
            recyclerViewHeaderViewAdapter.notifyItemRangeChanged(i3 + recyclerViewHeaderViewAdapter.C.size(), i16, obj);
            if (RecyclerViewHeaderViewAdapter.this.E != null) {
                RecyclerViewHeaderViewAdapter.this.E.contentDataChange(RecyclerViewHeaderViewAdapter.this.f101209m);
            }
        }
    }

    public boolean n0(int i3) {
        return i3 >= -2000 && i3 < this.D.size() + (-2000);
    }

    public boolean o0(int i3) {
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
            p0(viewHolder, i3);
            return;
        }
        if (i3 < this.C.size() + this.f101209m.getItemCount()) {
            this.f101209m.onBindViewHolder(viewHolder, i3 - this.C.size());
            return;
        }
        layoutParams = StaggeredGridLayoutManager.LayoutParams.class.isInstance(viewHolder.itemView.getLayoutParams()) ? (StaggeredGridLayoutManager.LayoutParams) viewHolder.itemView.getLayoutParams() : null;
        if (layoutParams == null) {
            layoutParams = new StaggeredGridLayoutManager.LayoutParams(-1, -2);
            viewHolder.itemView.setLayoutParams(layoutParams);
        }
        layoutParams.setFullSpan(true);
    }
}
