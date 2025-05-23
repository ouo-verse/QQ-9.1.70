package com.tencent.biz.richframework.part.adapter;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.part.adapter.delegate.AdapterDelegatesManager;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public class ListDelegationAdapter<T> extends VisibleNotifyAdapter {

    @NonNull
    protected AdapterDelegatesManager<List<T>> delegatesManager;
    protected List<T> items;

    public ListDelegationAdapter(@NonNull AdapterDelegatesManager<List<T>> adapterDelegatesManager) {
        if (adapterDelegatesManager != null) {
            this.delegatesManager = adapterDelegatesManager;
            return;
        }
        throw new NullPointerException("AdapterDelegatesManager is null");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<T> list = this.items;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i3) {
        return this.delegatesManager.getItemViewType(this.items, i3);
    }

    public List<T> getItems() {
        return this.items;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i3) {
        this.delegatesManager.onBindViewHolder(this.items, i3, viewHolder, null);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        RecyclerView.ViewHolder onCreateViewHolder = this.delegatesManager.onCreateViewHolder(viewGroup, i3);
        this.visibleAwareNotifier.registerViewHolder(onCreateViewHolder);
        return onCreateViewHolder;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public boolean onFailedToRecycleView(@NonNull RecyclerView.ViewHolder viewHolder) {
        return this.delegatesManager.onFailedToRecycleView(viewHolder);
    }

    @Override // com.tencent.biz.richframework.part.adapter.VisibleNotifyAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(@NonNull RecyclerView.ViewHolder viewHolder) {
        super.onViewAttachedToWindow(viewHolder);
        this.delegatesManager.onViewAttachedToWindow(viewHolder);
    }

    @Override // com.tencent.biz.richframework.part.adapter.VisibleNotifyAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(@NonNull RecyclerView.ViewHolder viewHolder) {
        super.onViewDetachedFromWindow(viewHolder);
        this.delegatesManager.onViewDetachedFromWindow(viewHolder);
    }

    @Override // com.tencent.biz.richframework.part.adapter.VisibleNotifyAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(@NonNull RecyclerView.ViewHolder viewHolder) {
        super.onViewRecycled(viewHolder);
        this.delegatesManager.onViewRecycled(viewHolder);
    }

    public void setItems(List<T> list) {
        this.items = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i3, @NonNull List list) {
        this.delegatesManager.onBindViewHolder(this.items, i3, viewHolder, list);
    }
}
