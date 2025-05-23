package com.tencent.biz.richframework.part.adapter;

import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

/* compiled from: P */
/* loaded from: classes5.dex */
public abstract class VisibleNotifyAdapter<VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {
    protected RecyclerView mRecyclerView;
    public final ViewHolderVisibleAwareNotifier visibleAwareNotifier = new ViewHolderVisibleAwareNotifier() { // from class: com.tencent.biz.richframework.part.adapter.VisibleNotifyAdapter.1
        @Override // com.tencent.biz.richframework.part.adapter.ViewHolderVisibleAwareNotifier
        public void onAwareDestroyed() {
            VisibleNotifyAdapter visibleNotifyAdapter = VisibleNotifyAdapter.this;
            visibleNotifyAdapter.onAdapterDestroyed(visibleNotifyAdapter.mRecyclerView);
        }
    };

    public RecyclerView getRecyclerView() {
        return this.mRecyclerView;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @CallSuper
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.mRecyclerView = recyclerView;
        this.visibleAwareNotifier.install(recyclerView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @CallSuper
    public void onDetachedFromRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        this.mRecyclerView = null;
        this.visibleAwareNotifier.unInstall();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @CallSuper
    public void onViewAttachedToWindow(@NonNull RecyclerView.ViewHolder viewHolder) {
        this.visibleAwareNotifier.notifyViewAttachedToWindow(viewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @CallSuper
    public void onViewDetachedFromWindow(@NonNull RecyclerView.ViewHolder viewHolder) {
        this.visibleAwareNotifier.notifyViewDetachedFromWindow(viewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @CallSuper
    public void onViewRecycled(@NonNull RecyclerView.ViewHolder viewHolder) {
        this.visibleAwareNotifier.notifyViewRecycled(viewHolder);
    }

    @CallSuper
    public void onAdapterDestroyed(RecyclerView recyclerView) {
    }
}
