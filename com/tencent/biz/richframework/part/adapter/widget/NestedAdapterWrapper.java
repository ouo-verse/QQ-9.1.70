package com.tencent.biz.richframework.part.adapter.widget;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.ViewHolderHelper;
import com.tencent.biz.richframework.part.adapter.widget.StableIdStorage;
import com.tencent.biz.richframework.part.adapter.widget.ViewTypeStorage;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes5.dex */
public class NestedAdapterWrapper {
    public final RecyclerView.Adapter<RecyclerView.ViewHolder> adapter;
    private final RecyclerView.AdapterDataObserver mAdapterObserver;
    private int mCachedItemCount;
    private final Callback mCallback;

    @NonNull
    private final StableIdStorage.StableIdLookup mStableIdLookup;

    @NonNull
    private final ViewTypeStorage.ViewTypeLookup mViewTypeLookup;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface Callback {
        void onChanged(@NonNull NestedAdapterWrapper nestedAdapterWrapper);

        void onItemRangeChanged(@NonNull NestedAdapterWrapper nestedAdapterWrapper, int i3, int i16, @Nullable Object obj);

        void onItemRangeInserted(@NonNull NestedAdapterWrapper nestedAdapterWrapper, int i3, int i16);

        void onItemRangeMoved(@NonNull NestedAdapterWrapper nestedAdapterWrapper, int i3, int i16);

        void onItemRangeRemoved(@NonNull NestedAdapterWrapper nestedAdapterWrapper, int i3, int i16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public NestedAdapterWrapper(RecyclerView.Adapter<RecyclerView.ViewHolder> adapter, Callback callback, ViewTypeStorage viewTypeStorage, StableIdStorage.StableIdLookup stableIdLookup) {
        RecyclerView.AdapterDataObserver adapterDataObserver = new RecyclerView.AdapterDataObserver() { // from class: com.tencent.biz.richframework.part.adapter.widget.NestedAdapterWrapper.1
            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onChanged() {
                NestedAdapterWrapper nestedAdapterWrapper = NestedAdapterWrapper.this;
                nestedAdapterWrapper.mCachedItemCount = nestedAdapterWrapper.adapter.getItemCount();
                NestedAdapterWrapper.this.mCallback.onChanged(NestedAdapterWrapper.this);
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeChanged(int i3, int i16) {
                NestedAdapterWrapper.this.mCallback.onItemRangeChanged(NestedAdapterWrapper.this, i3, i16, null);
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeInserted(int i3, int i16) {
                NestedAdapterWrapper.access$012(NestedAdapterWrapper.this, i16);
                NestedAdapterWrapper.this.mCallback.onItemRangeInserted(NestedAdapterWrapper.this, i3, i16);
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeMoved(int i3, int i16, int i17) {
                NestedAdapterWrapper.this.mCallback.onItemRangeMoved(NestedAdapterWrapper.this, i3, i16);
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeRemoved(int i3, int i16) {
                NestedAdapterWrapper.access$020(NestedAdapterWrapper.this, i16);
                NestedAdapterWrapper.this.mCallback.onItemRangeRemoved(NestedAdapterWrapper.this, i3, i16);
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeChanged(int i3, int i16, @Nullable Object obj) {
                NestedAdapterWrapper.this.mCallback.onItemRangeChanged(NestedAdapterWrapper.this, i3, i16, obj);
            }
        };
        this.mAdapterObserver = adapterDataObserver;
        this.adapter = adapter;
        this.mCallback = callback;
        this.mViewTypeLookup = viewTypeStorage.createViewTypeWrapper(this);
        this.mStableIdLookup = stableIdLookup;
        this.mCachedItemCount = adapter.getItemCount();
        adapter.registerAdapterDataObserver(adapterDataObserver);
    }

    static /* synthetic */ int access$012(NestedAdapterWrapper nestedAdapterWrapper, int i3) {
        int i16 = nestedAdapterWrapper.mCachedItemCount + i3;
        nestedAdapterWrapper.mCachedItemCount = i16;
        return i16;
    }

    static /* synthetic */ int access$020(NestedAdapterWrapper nestedAdapterWrapper, int i3) {
        int i16 = nestedAdapterWrapper.mCachedItemCount - i3;
        nestedAdapterWrapper.mCachedItemCount = i16;
        return i16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dispose() {
        this.adapter.unregisterAdapterDataObserver(this.mAdapterObserver);
        this.mViewTypeLookup.dispose();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getCachedItemCount() {
        return this.mCachedItemCount;
    }

    public long getItemId(int i3) {
        return this.mStableIdLookup.localToGlobal(this.adapter.getItemId(i3));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getItemViewType(int i3) {
        return this.mViewTypeLookup.localToGlobal(this.adapter.getItemViewType(i3));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i3) {
        this.adapter.onBindViewHolder(viewHolder, i3, ViewHolderHelper.getUnmodifiedPayloads(viewHolder));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i3) {
        return this.adapter.onCreateViewHolder(viewGroup, this.mViewTypeLookup.globalToLocal(i3));
    }
}
