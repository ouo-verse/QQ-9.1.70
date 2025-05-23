package com.tencent.mobileqq.guild.widget.adapterdelegates;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.AdapterListUpdateCallback;
import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.AsyncListDiffer;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.app.ThreadManagerV2;
import java.util.List;
import java.util.concurrent.Executor;

/* compiled from: P */
/* loaded from: classes14.dex */
public class d<T> extends RecyclerView.Adapter {
    protected final AsyncListDiffer<T> C;
    protected boolean D;
    private final String E;
    private RecyclerView.AdapterDataObserver F;
    private Runnable G;
    private final AsyncListDiffer.ListListener<T> H;

    /* renamed from: m, reason: collision with root package name */
    protected final com.tencent.mobileqq.guild.widget.adapterdelegates.c<List<T>> f236209m;

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class a implements AsyncListDiffer.ListListener<T> {
        a() {
        }

        @Override // androidx.recyclerview.widget.AsyncListDiffer.ListListener
        public void onCurrentListChanged(@NonNull List<T> list, @NonNull List<T> list2) {
            if (d.this.G != null) {
                d.this.G.run();
                d.this.G = null;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class b extends RecyclerView.AdapterDataObserver {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ RecyclerView f236211d;

        b(RecyclerView recyclerView) {
            this.f236211d = recyclerView;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeInserted(int i3, int i16) {
            super.onItemRangeInserted(i3, i16);
            d.this.unregisterAdapterDataObserver(this);
            if (this.f236211d != null && i3 == 0 && d.this.getItemCount() == i16) {
                this.f236211d.scrollToPosition(0);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    static class c implements Executor {
        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            ThreadManagerV2.excute(runnable, 16, null, true);
        }
    }

    public d(@NonNull DiffUtil.ItemCallback<T> itemCallback) {
        this(itemCallback, new com.tencent.mobileqq.guild.widget.adapterdelegates.c());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.C.getCurrentList().size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i3) {
        return this.f236209m.f(this.C.getCurrentList(), i3);
    }

    public List<T> getItems() {
        return this.C.getCurrentList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        this.f236209m.i(recyclerView);
        if (this.D && this.F == null) {
            b bVar = new b(recyclerView);
            this.F = bVar;
            registerAdapterDataObserver(bVar);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i3) {
        this.f236209m.j(this.C.getCurrentList(), i3, viewHolder, null);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        return this.f236209m.l(viewGroup, i3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(@NonNull RecyclerView recyclerView) {
        this.f236209m.m(recyclerView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public boolean onFailedToRecycleView(@NonNull RecyclerView.ViewHolder viewHolder) {
        return this.f236209m.n(viewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(@NonNull RecyclerView.ViewHolder viewHolder) {
        this.f236209m.o(viewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(@NonNull RecyclerView.ViewHolder viewHolder) {
        this.f236209m.p(viewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(@NonNull RecyclerView.ViewHolder viewHolder) {
        this.f236209m.q(viewHolder);
    }

    public void setItems(List<T> list) {
        this.C.submitList(list);
    }

    public void submitList(List<T> list, Runnable runnable) {
        this.C.submitList(list, runnable);
    }

    public d(@NonNull DiffUtil.ItemCallback<T> itemCallback, @NonNull com.tencent.mobileqq.guild.widget.adapterdelegates.c<List<T>> cVar) {
        this.D = true;
        this.E = getClass().getCanonicalName();
        a aVar = new a();
        this.H = aVar;
        if (itemCallback == null) {
            throw new NullPointerException("ItemCallback is null");
        }
        if (cVar != null) {
            AsyncListDiffer<T> asyncListDiffer = new AsyncListDiffer<>(new AdapterListUpdateCallback(this), new AsyncDifferConfig.Builder(itemCallback).setBackgroundThreadExecutor(new c()).build());
            this.C = asyncListDiffer;
            this.f236209m = cVar;
            asyncListDiffer.addListListener(aVar);
            return;
        }
        throw new NullPointerException("AdapterDelegatesManager is null");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i3, @NonNull List list) {
        this.f236209m.j(this.C.getCurrentList(), i3, viewHolder, list);
    }

    public void setItems(List<T> list, Runnable runnable) {
        if (runnable != null) {
            this.G = runnable;
        }
        this.C.submitList(list);
    }
}
