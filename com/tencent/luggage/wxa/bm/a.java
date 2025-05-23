package com.tencent.luggage.wxa.bm;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.tencent.mobileqq.R;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a extends RecyclerView.Adapter {

    /* renamed from: i, reason: collision with root package name */
    public static ViewGroup.LayoutParams f123053i = new ViewGroup.LayoutParams(-1, -2);

    /* renamed from: a, reason: collision with root package name */
    public RecyclerView.Adapter f123054a;

    /* renamed from: b, reason: collision with root package name */
    public ViewGroup f123055b;

    /* renamed from: c, reason: collision with root package name */
    public ViewGroup f123056c;

    /* renamed from: f, reason: collision with root package name */
    public com.tencent.luggage.wxa.bm.c f123059f;

    /* renamed from: g, reason: collision with root package name */
    public com.tencent.luggage.wxa.bm.d f123060g;

    /* renamed from: d, reason: collision with root package name */
    public List f123057d = new LinkedList();

    /* renamed from: e, reason: collision with root package name */
    public List f123058e = new LinkedList();

    /* renamed from: h, reason: collision with root package name */
    public RecyclerView.AdapterDataObserver f123061h = new C6083a();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RecyclerView.ViewHolder f123063a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f123064b;

        public b(RecyclerView.ViewHolder viewHolder, int i3) {
            this.f123063a = viewHolder;
            this.f123064b = i3;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f123059f != null) {
                com.tencent.luggage.wxa.bm.c cVar = a.this.f123059f;
                RecyclerView.ViewHolder viewHolder = this.f123063a;
                cVar.a(viewHolder.itemView, this.f123064b, viewHolder.getItemId());
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements View.OnLongClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RecyclerView.ViewHolder f123066a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f123067b;

        public c(RecyclerView.ViewHolder viewHolder, int i3) {
            this.f123066a = viewHolder;
            this.f123067b = i3;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (a.this.f123060g != null) {
                com.tencent.luggage.wxa.bm.d dVar = a.this.f123060g;
                RecyclerView.ViewHolder viewHolder = this.f123066a;
                return dVar.a(viewHolder.itemView, this.f123067b, viewHolder.getItemId());
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class d implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RecyclerView.ViewHolder f123069a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f123070b;

        public d(RecyclerView.ViewHolder viewHolder, int i3) {
            this.f123069a = viewHolder;
            this.f123070b = i3;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f123059f != null) {
                com.tencent.luggage.wxa.bm.c cVar = a.this.f123059f;
                RecyclerView.ViewHolder viewHolder = this.f123069a;
                cVar.a(viewHolder.itemView, this.f123070b, viewHolder.getItemId());
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class e implements View.OnLongClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RecyclerView.ViewHolder f123072a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f123073b;

        public e(RecyclerView.ViewHolder viewHolder, int i3) {
            this.f123072a = viewHolder;
            this.f123073b = i3;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (a.this.f123060g != null) {
                com.tencent.luggage.wxa.bm.d dVar = a.this.f123060g;
                RecyclerView.ViewHolder viewHolder = this.f123072a;
                return dVar.a(viewHolder.itemView, this.f123073b, viewHolder.getItemId());
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class f extends RecyclerView.ViewHolder {
        public f(View view) {
            super(view);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        int itemCount;
        RecyclerView.Adapter adapter = this.f123054a;
        if (adapter == null) {
            itemCount = 0;
        } else {
            itemCount = adapter.getItemCount();
        }
        if (!this.f123057d.isEmpty()) {
            itemCount++;
        }
        if (!this.f123058e.isEmpty()) {
            return itemCount + 1;
        }
        return itemCount;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i3) {
        if (getItemViewType(i3) == Integer.MAX_VALUE) {
            return -1782095970;
        }
        if (getItemViewType(i3) == 2147483646) {
            return 1955920812;
        }
        if (!this.f123054a.hasStableIds()) {
            return i3;
        }
        return this.f123054a.getItemId(i3 - (!this.f123057d.isEmpty() ? 1 : 0));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int i3) {
        if (!this.f123057d.isEmpty() && i3 == 0) {
            return Integer.MAX_VALUE;
        }
        if (!this.f123058e.isEmpty() && i3 == getItemCount() - 1) {
            return 2147483646;
        }
        return this.f123054a.getItemViewType(i3 - (!this.f123057d.isEmpty() ? 1 : 0));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i3) {
        if (!this.f123057d.isEmpty() && i3 == 0) {
            a(viewHolder);
            return;
        }
        if (!this.f123058e.isEmpty() && i3 == getItemCount() - 1) {
            a(viewHolder);
            return;
        }
        int i16 = i3 - (!this.f123057d.isEmpty() ? 1 : 0);
        this.f123054a.onBindViewHolder(viewHolder, i16);
        if (this.f123059f != null) {
            viewHolder.itemView.setOnClickListener(new b(viewHolder, i16));
        }
        if (this.f123060g != null) {
            viewHolder.itemView.setOnLongClickListener(new c(viewHolder, i16));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i3) {
        if (i3 == 2147483646) {
            ViewGroup viewGroup2 = this.f123055b;
            if (viewGroup2 != null) {
                viewGroup2.removeAllViews();
            }
            ViewGroup a16 = a(viewGroup);
            this.f123055b = a16;
            for (View view : this.f123058e) {
                if (view.getParent() instanceof ViewGroup) {
                    ((ViewGroup) view.getParent()).removeView(view);
                }
                a16.addView(view, f123053i);
            }
            return new f(a16);
        }
        if (i3 == Integer.MAX_VALUE) {
            ViewGroup viewGroup3 = this.f123056c;
            if (viewGroup3 != null) {
                viewGroup3.removeAllViews();
            }
            ViewGroup b16 = b(viewGroup);
            this.f123056c = b16;
            Iterator it = this.f123057d.iterator();
            while (it.hasNext()) {
                b16.addView((View) it.next(), f123053i);
            }
            return new f(b16);
        }
        return this.f123054a.onCreateViewHolder(viewGroup, i3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
        super.onViewAttachedToWindow(viewHolder);
        if (viewHolder.getItemViewType() != Integer.MAX_VALUE && viewHolder.getItemViewType() != 2147483646) {
            this.f123054a.onViewAttachedToWindow(viewHolder);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(RecyclerView.ViewHolder viewHolder) {
        super.onViewDetachedFromWindow(viewHolder);
        if (viewHolder.getItemViewType() != Integer.MAX_VALUE && viewHolder.getItemViewType() != 2147483646) {
            this.f123054a.onViewDetachedFromWindow(viewHolder);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.bm.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C6083a extends RecyclerView.AdapterDataObserver {
        public C6083a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            a.this.notifyDataSetChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i3, int i16) {
            a.this.notifyItemRangeChanged(i3 + (!a.this.f123057d.isEmpty() ? 1 : 0), i16);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeInserted(int i3, int i16) {
            a.this.notifyItemRangeInserted(i3 + (!a.this.f123057d.isEmpty() ? 1 : 0), i16);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeMoved(int i3, int i16, int i17) {
            if (i17 == 1) {
                a aVar = a.this;
                aVar.notifyItemMoved(i3 + (!aVar.f123057d.isEmpty() ? 1 : 0), i16 + (1 ^ (a.this.f123057d.isEmpty() ? 1 : 0)));
            } else {
                a.this.notifyDataSetChanged();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeRemoved(int i3, int i16) {
            a.this.notifyItemRangeRemoved(i3 + (!a.this.f123057d.isEmpty() ? 1 : 0), i16);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i3, int i16, Object obj) {
            a.this.notifyItemRangeChanged(i3 + (!a.this.f123057d.isEmpty() ? 1 : 0), i16, obj);
        }
    }

    public final void a(RecyclerView.ViewHolder viewHolder) {
        if (viewHolder.itemView.getLayoutParams() instanceof StaggeredGridLayoutManager.LayoutParams) {
            StaggeredGridLayoutManager.LayoutParams layoutParams = (StaggeredGridLayoutManager.LayoutParams) viewHolder.itemView.getLayoutParams();
            layoutParams.setFullSpan(true);
            viewHolder.itemView.setLayoutParams(layoutParams);
        }
    }

    public RecyclerView.Adapter b() {
        return this.f123054a;
    }

    public void c(View view) {
        this.f123058e.remove(view);
        notifyItemRangeChanged(getItemCount() - 1, 1);
    }

    public void b(View view) {
        this.f123057d.add(view);
        notifyItemRangeChanged(0, 1);
    }

    public final ViewGroup b(ViewGroup viewGroup) {
        return (ViewGroup) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.hrj, viewGroup, false);
    }

    public void a(RecyclerView.Adapter adapter) {
        RecyclerView.Adapter adapter2 = this.f123054a;
        if (adapter2 != null) {
            if (adapter2.equals(adapter)) {
                return;
            } else {
                this.f123054a.unregisterAdapterDataObserver(this.f123061h);
            }
        }
        this.f123054a = adapter;
        if (adapter != null) {
            adapter.registerAdapterDataObserver(this.f123061h);
        }
    }

    public int a() {
        return this.f123058e.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i3, List list) {
        if (!this.f123057d.isEmpty() && i3 == 0) {
            a(viewHolder);
            return;
        }
        if (!this.f123058e.isEmpty() && i3 == getItemCount() - 1) {
            a(viewHolder);
            return;
        }
        int i16 = i3 - (!this.f123057d.isEmpty() ? 1 : 0);
        this.f123054a.onBindViewHolder(viewHolder, i16, list);
        if (this.f123059f != null) {
            viewHolder.itemView.setOnClickListener(new d(viewHolder, i16));
        }
        if (this.f123060g != null) {
            viewHolder.itemView.setOnLongClickListener(new e(viewHolder, i16));
        }
    }

    public void a(View view) {
        this.f123058e.add(view);
        notifyItemRangeChanged(getItemCount() - 1, 1);
    }

    public void a(int i3, View view) {
        this.f123058e.add(i3, view);
        notifyItemRangeChanged(getItemCount() - 1, 1);
    }

    public void a(com.tencent.luggage.wxa.bm.c cVar) {
        this.f123059f = cVar;
    }

    public void a(com.tencent.luggage.wxa.bm.d dVar) {
        this.f123060g = dVar;
    }

    public final ViewGroup a(ViewGroup viewGroup) {
        return (ViewGroup) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.hrj, viewGroup, false);
    }
}
