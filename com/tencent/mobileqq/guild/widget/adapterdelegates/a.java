package com.tencent.mobileqq.guild.widget.adapterdelegates;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

/* compiled from: P */
/* loaded from: classes14.dex */
public abstract class a<T> extends RecyclerView.Adapter {
    protected T C;

    /* renamed from: m, reason: collision with root package name */
    protected c<T> f236199m;

    public a() {
        this(new c());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i3) {
        return this.f236199m.f(this.C, i3);
    }

    public T i0() {
        return this.C;
    }

    public void j0(T t16) {
        this.C = t16;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i3) {
        this.f236199m.j(this.C, i3, viewHolder, null);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        return this.f236199m.l(viewGroup, i3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public boolean onFailedToRecycleView(@NonNull RecyclerView.ViewHolder viewHolder) {
        return this.f236199m.n(viewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(@NonNull RecyclerView.ViewHolder viewHolder) {
        this.f236199m.o(viewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(@NonNull RecyclerView.ViewHolder viewHolder) {
        this.f236199m.p(viewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(@NonNull RecyclerView.ViewHolder viewHolder) {
        this.f236199m.q(viewHolder);
    }

    public a(@NonNull c<T> cVar) {
        if (cVar != null) {
            this.f236199m = cVar;
            return;
        }
        throw new NullPointerException("AdapterDelegatesManager is null");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i3, @NonNull List list) {
        this.f236199m.j(this.C, i3, viewHolder, list);
    }
}
