package com.tencent.biz.richframework.part.adapter;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.AdapterListUpdateCallback;
import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.AsyncListDiffer;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.part.adapter.delegate.AdapterDelegate;
import com.tencent.biz.richframework.part.adapter.delegate.AdapterDelegatesManager;
import com.tencent.richframework.thread.RFWThreadManager;
import java.util.List;
import java.util.concurrent.Executor;

/* compiled from: P */
/* loaded from: classes5.dex */
public class AsyncListDifferDelegationAdapter<T> extends VisibleNotifyAdapter {
    protected final AdapterDelegatesManager<List<T>> delegatesManager;
    protected final AsyncListDiffer<T> differ;
    private RecyclerView.AdapterDataObserver mFixScrollToEndObserver;
    private final AsyncListDiffer.ListListener<T> mListener;
    private Runnable submitListCallback;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    static class InnerAsyncExecutor implements Executor {
        InnerAsyncExecutor() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            RFWThreadManager.getInstance().execOnAsyncDisplayThread(runnable);
        }
    }

    public AsyncListDifferDelegationAdapter(@NonNull DiffUtil.ItemCallback<T> itemCallback) {
        this(itemCallback, new AdapterDelegatesManager());
    }

    public AdapterDelegatesManager getDelegatesManager() {
        return this.delegatesManager;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.differ.getCurrentList().size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i3) {
        return i3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i3) {
        return this.delegatesManager.getItemViewType(this.differ.getCurrentList(), i3);
    }

    public List<T> getItems() {
        return this.differ.getCurrentList();
    }

    @Override // com.tencent.biz.richframework.part.adapter.VisibleNotifyAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        if (this.mFixScrollToEndObserver == null) {
            RecyclerView.AdapterDataObserver adapterDataObserver = new RecyclerView.AdapterDataObserver() { // from class: com.tencent.biz.richframework.part.adapter.AsyncListDifferDelegationAdapter.2
                @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
                public void onItemRangeInserted(int i3, int i16) {
                    super.onItemRangeInserted(i3, i16);
                    AsyncListDifferDelegationAdapter.this.unregisterAdapterDataObserver(this);
                    AsyncListDifferDelegationAdapter asyncListDifferDelegationAdapter = AsyncListDifferDelegationAdapter.this;
                    if (asyncListDifferDelegationAdapter.mRecyclerView != null && i3 == 0 && asyncListDifferDelegationAdapter.getItemCount() == i16) {
                        AsyncListDifferDelegationAdapter.this.mRecyclerView.scrollToPosition(0);
                    }
                }
            };
            this.mFixScrollToEndObserver = adapterDataObserver;
            registerAdapterDataObserver(adapterDataObserver);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i3) {
        this.delegatesManager.onBindViewHolder(this.differ.getCurrentList(), i3, viewHolder, null);
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

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void registerAdapterDataObserver(@NonNull RecyclerView.AdapterDataObserver adapterDataObserver) {
        super.registerAdapterDataObserver(adapterDataObserver);
    }

    public void setItems(List<T> list) {
        this.differ.submitList(list);
    }

    public AsyncListDifferDelegationAdapter(@NonNull DiffUtil.ItemCallback<T> itemCallback, @NonNull AdapterDelegatesManager<List<T>> adapterDelegatesManager) {
        AsyncListDiffer.ListListener<T> listListener = new AsyncListDiffer.ListListener<T>() { // from class: com.tencent.biz.richframework.part.adapter.AsyncListDifferDelegationAdapter.1
            @Override // androidx.recyclerview.widget.AsyncListDiffer.ListListener
            public void onCurrentListChanged(@NonNull List<T> list, @NonNull List<T> list2) {
                if (AsyncListDifferDelegationAdapter.this.submitListCallback != null) {
                    AsyncListDifferDelegationAdapter.this.submitListCallback.run();
                    AsyncListDifferDelegationAdapter.this.submitListCallback = null;
                }
            }
        };
        this.mListener = listListener;
        if (itemCallback == null) {
            throw new NullPointerException("ItemCallback is null");
        }
        if (adapterDelegatesManager != null) {
            AsyncListDiffer<T> asyncListDiffer = new AsyncListDiffer<>(new AdapterListUpdateCallback(this), new AsyncDifferConfig.Builder(itemCallback).setBackgroundThreadExecutor(new InnerAsyncExecutor()).build());
            this.differ = asyncListDiffer;
            this.delegatesManager = adapterDelegatesManager;
            asyncListDiffer.addListListener(listListener);
            return;
        }
        throw new NullPointerException("AdapterDelegatesManager is null");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i3, @NonNull List list) {
        this.delegatesManager.onBindViewHolder(this.differ.getCurrentList(), i3, viewHolder, list);
    }

    public void setItems(List<T> list, Runnable runnable) {
        if (runnable != null) {
            this.submitListCallback = runnable;
        }
        this.differ.submitList(list);
    }

    public AsyncListDifferDelegationAdapter(@NonNull AsyncDifferConfig asyncDifferConfig, @NonNull AdapterDelegatesManager<List<T>> adapterDelegatesManager) {
        AsyncListDiffer.ListListener<T> listListener = new AsyncListDiffer.ListListener<T>() { // from class: com.tencent.biz.richframework.part.adapter.AsyncListDifferDelegationAdapter.1
            @Override // androidx.recyclerview.widget.AsyncListDiffer.ListListener
            public void onCurrentListChanged(@NonNull List<T> list, @NonNull List<T> list2) {
                if (AsyncListDifferDelegationAdapter.this.submitListCallback != null) {
                    AsyncListDifferDelegationAdapter.this.submitListCallback.run();
                    AsyncListDifferDelegationAdapter.this.submitListCallback = null;
                }
            }
        };
        this.mListener = listListener;
        if (asyncDifferConfig == null) {
            throw new NullPointerException("AsyncDifferConfig is null");
        }
        if (adapterDelegatesManager != null) {
            AsyncListDiffer<T> asyncListDiffer = new AsyncListDiffer<>(new AdapterListUpdateCallback(this), asyncDifferConfig);
            this.differ = asyncListDiffer;
            this.delegatesManager = adapterDelegatesManager;
            asyncListDiffer.addListListener(listListener);
            return;
        }
        throw new NullPointerException("AdapterDelegatesManager is null");
    }

    public AsyncListDifferDelegationAdapter(@NonNull DiffUtil.ItemCallback<T> itemCallback, @NonNull AdapterDelegate<List<T>>... adapterDelegateArr) {
        AsyncListDiffer.ListListener<T> listListener = new AsyncListDiffer.ListListener<T>() { // from class: com.tencent.biz.richframework.part.adapter.AsyncListDifferDelegationAdapter.1
            @Override // androidx.recyclerview.widget.AsyncListDiffer.ListListener
            public void onCurrentListChanged(@NonNull List<T> list, @NonNull List<T> list2) {
                if (AsyncListDifferDelegationAdapter.this.submitListCallback != null) {
                    AsyncListDifferDelegationAdapter.this.submitListCallback.run();
                    AsyncListDifferDelegationAdapter.this.submitListCallback = null;
                }
            }
        };
        this.mListener = listListener;
        if (itemCallback != null) {
            AsyncListDiffer<T> asyncListDiffer = new AsyncListDiffer<>(this, itemCallback);
            this.differ = asyncListDiffer;
            this.delegatesManager = new AdapterDelegatesManager<>(adapterDelegateArr);
            asyncListDiffer.addListListener(listListener);
            return;
        }
        throw new NullPointerException("ItemCallback is null");
    }

    public AsyncListDifferDelegationAdapter(@NonNull AsyncDifferConfig asyncDifferConfig, @NonNull AdapterDelegate<List<T>>... adapterDelegateArr) {
        this.mListener = new AsyncListDiffer.ListListener<T>() { // from class: com.tencent.biz.richframework.part.adapter.AsyncListDifferDelegationAdapter.1
            @Override // androidx.recyclerview.widget.AsyncListDiffer.ListListener
            public void onCurrentListChanged(@NonNull List<T> list, @NonNull List<T> list2) {
                if (AsyncListDifferDelegationAdapter.this.submitListCallback != null) {
                    AsyncListDifferDelegationAdapter.this.submitListCallback.run();
                    AsyncListDifferDelegationAdapter.this.submitListCallback = null;
                }
            }
        };
        if (asyncDifferConfig != null) {
            this.differ = new AsyncListDiffer<>(new AdapterListUpdateCallback(this), asyncDifferConfig);
            this.delegatesManager = new AdapterDelegatesManager<>(adapterDelegateArr);
            return;
        }
        throw new NullPointerException("AsyncDifferConfig is null");
    }
}
