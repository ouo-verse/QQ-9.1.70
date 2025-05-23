package com.tencent.biz.richframework.part.adapter.widget;

import android.annotation.SuppressLint;
import android.util.Pair;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.part.adapter.widget.NestedAdapterWrapper;
import com.tencent.biz.richframework.part.adapter.widget.RFWConcatAdapter;
import com.tencent.biz.richframework.part.adapter.widget.StableIdStorage;
import com.tencent.biz.richframework.part.adapter.widget.ViewTypeStorage;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes5.dex */
public class ConcatAdapterController implements NestedAdapterWrapper.Callback {
    private final RFWConcatAdapter mConcatAdapter;

    @NonNull
    private final RFWConcatAdapter.Config.StableIdMode mStableIdMode;
    private final StableIdStorage mStableIdStorage;
    private final ViewTypeStorage mViewTypeStorage;
    private final List<WeakReference<RecyclerView>> mAttachedRecyclerViews = new ArrayList();
    private final IdentityHashMap<RecyclerView.ViewHolder, NestedAdapterWrapper> mBinderLookup = new IdentityHashMap<>();
    private final List<NestedAdapterWrapper> mWrappers = new ArrayList();
    private WrapperAndLocalPosition mReusableHolder = new WrapperAndLocalPosition();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class WrapperAndLocalPosition {
        boolean mInUse;
        int mLocalPosition;
        NestedAdapterWrapper mWrapper;

        WrapperAndLocalPosition() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ConcatAdapterController(RFWConcatAdapter rFWConcatAdapter, RFWConcatAdapter.Config config) {
        this.mConcatAdapter = rFWConcatAdapter;
        if (config.isolateViewTypes) {
            this.mViewTypeStorage = new ViewTypeStorage.IsolatedViewTypeStorage();
        } else {
            this.mViewTypeStorage = new ViewTypeStorage.SharedIdRangeViewTypeStorage();
        }
        RFWConcatAdapter.Config.StableIdMode stableIdMode = config.stableIdMode;
        this.mStableIdMode = stableIdMode;
        if (stableIdMode == RFWConcatAdapter.Config.StableIdMode.NO_STABLE_IDS) {
            this.mStableIdStorage = new StableIdStorage.NoStableIdStorage();
        } else if (stableIdMode == RFWConcatAdapter.Config.StableIdMode.ISOLATED_STABLE_IDS) {
            this.mStableIdStorage = new StableIdStorage.IsolatedStableIdStorage();
        } else {
            if (stableIdMode == RFWConcatAdapter.Config.StableIdMode.SHARED_STABLE_IDS) {
                this.mStableIdStorage = new StableIdStorage.SharedPoolStableIdStorage();
                return;
            }
            throw new IllegalArgumentException("unknown stable id mode");
        }
    }

    private int countItemsBefore(NestedAdapterWrapper nestedAdapterWrapper) {
        NestedAdapterWrapper next;
        Iterator<NestedAdapterWrapper> it = this.mWrappers.iterator();
        int i3 = 0;
        while (it.hasNext() && (next = it.next()) != nestedAdapterWrapper) {
            i3 += next.getCachedItemCount();
        }
        return i3;
    }

    @NonNull
    private WrapperAndLocalPosition findWrapperAndLocalPosition(int i3) {
        WrapperAndLocalPosition wrapperAndLocalPosition = this.mReusableHolder;
        if (wrapperAndLocalPosition.mInUse) {
            wrapperAndLocalPosition = new WrapperAndLocalPosition();
        } else {
            wrapperAndLocalPosition.mInUse = true;
        }
        Iterator<NestedAdapterWrapper> it = this.mWrappers.iterator();
        int i16 = i3;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            NestedAdapterWrapper next = it.next();
            if (next.getCachedItemCount() > i16) {
                wrapperAndLocalPosition.mWrapper = next;
                wrapperAndLocalPosition.mLocalPosition = i16;
                break;
            }
            i16 -= next.getCachedItemCount();
        }
        if (wrapperAndLocalPosition.mWrapper != null) {
            return wrapperAndLocalPosition;
        }
        throw new IllegalArgumentException("Cannot find wrapper for " + i3);
    }

    @Nullable
    private NestedAdapterWrapper findWrapperFor(RecyclerView.Adapter<RecyclerView.ViewHolder> adapter) {
        int indexOfWrapper = indexOfWrapper(adapter);
        if (indexOfWrapper == -1) {
            return null;
        }
        return this.mWrappers.get(indexOfWrapper);
    }

    @NonNull
    private NestedAdapterWrapper getWrapper(RecyclerView.ViewHolder viewHolder) {
        NestedAdapterWrapper nestedAdapterWrapper = this.mBinderLookup.get(viewHolder);
        if (nestedAdapterWrapper != null) {
            return nestedAdapterWrapper;
        }
        throw new IllegalStateException("Cannot find wrapper for " + viewHolder + ", seems like it is not bound by this adapter: " + this);
    }

    private int indexOfWrapper(RecyclerView.Adapter<RecyclerView.ViewHolder> adapter) {
        int size = this.mWrappers.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (this.mWrappers.get(i3).adapter == adapter) {
                return i3;
            }
        }
        return -1;
    }

    private boolean isAttachedTo(RecyclerView recyclerView) {
        Iterator<WeakReference<RecyclerView>> it = this.mAttachedRecyclerViews.iterator();
        while (it.hasNext()) {
            if (it.next().get() == recyclerView) {
                return true;
            }
        }
        return false;
    }

    private void releaseWrapperAndLocalPosition(WrapperAndLocalPosition wrapperAndLocalPosition) {
        wrapperAndLocalPosition.mInUse = false;
        wrapperAndLocalPosition.mWrapper = null;
        wrapperAndLocalPosition.mLocalPosition = -1;
        this.mReusableHolder = wrapperAndLocalPosition;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean addAdapter(RecyclerView.Adapter<RecyclerView.ViewHolder> adapter) {
        return addAdapter(this.mWrappers.size(), adapter);
    }

    public List<RecyclerView.Adapter<? extends RecyclerView.ViewHolder>> getCopyOfAdapters() {
        if (this.mWrappers.isEmpty()) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(this.mWrappers.size());
        Iterator<NestedAdapterWrapper> it = this.mWrappers.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().adapter);
        }
        return arrayList;
    }

    public long getItemId(int i3) {
        WrapperAndLocalPosition findWrapperAndLocalPosition = findWrapperAndLocalPosition(i3);
        long itemId = findWrapperAndLocalPosition.mWrapper.getItemId(findWrapperAndLocalPosition.mLocalPosition);
        releaseWrapperAndLocalPosition(findWrapperAndLocalPosition);
        return itemId;
    }

    public int getItemViewType(int i3) {
        WrapperAndLocalPosition findWrapperAndLocalPosition = findWrapperAndLocalPosition(i3);
        int itemViewType = findWrapperAndLocalPosition.mWrapper.getItemViewType(findWrapperAndLocalPosition.mLocalPosition);
        releaseWrapperAndLocalPosition(findWrapperAndLocalPosition);
        return itemViewType;
    }

    public int getTotalCount() {
        Iterator<NestedAdapterWrapper> it = this.mWrappers.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            i3 += it.next().getCachedItemCount();
        }
        return i3;
    }

    public Pair<RecyclerView.Adapter<? extends RecyclerView.ViewHolder>, Integer> getWrappedAdapterAndPosition(int i3) {
        WrapperAndLocalPosition findWrapperAndLocalPosition = findWrapperAndLocalPosition(i3);
        Pair<RecyclerView.Adapter<? extends RecyclerView.ViewHolder>, Integer> pair = new Pair<>(findWrapperAndLocalPosition.mWrapper.adapter, Integer.valueOf(findWrapperAndLocalPosition.mLocalPosition));
        releaseWrapperAndLocalPosition(findWrapperAndLocalPosition);
        return pair;
    }

    public boolean hasStableIds() {
        if (this.mStableIdMode != RFWConcatAdapter.Config.StableIdMode.NO_STABLE_IDS) {
            return true;
        }
        return false;
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        if (isAttachedTo(recyclerView)) {
            return;
        }
        this.mAttachedRecyclerViews.add(new WeakReference<>(recyclerView));
        Iterator<NestedAdapterWrapper> it = this.mWrappers.iterator();
        while (it.hasNext()) {
            it.next().adapter.onAttachedToRecyclerView(recyclerView);
        }
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i3) {
        WrapperAndLocalPosition findWrapperAndLocalPosition = findWrapperAndLocalPosition(i3);
        this.mBinderLookup.put(viewHolder, findWrapperAndLocalPosition.mWrapper);
        findWrapperAndLocalPosition.mWrapper.onBindViewHolder(viewHolder, findWrapperAndLocalPosition.mLocalPosition);
        releaseWrapperAndLocalPosition(findWrapperAndLocalPosition);
    }

    @Override // com.tencent.biz.richframework.part.adapter.widget.NestedAdapterWrapper.Callback
    @SuppressLint({"NotifyDataSetChanged"})
    public void onChanged(@NonNull NestedAdapterWrapper nestedAdapterWrapper) {
        this.mConcatAdapter.notifyDataSetChanged();
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i3) {
        return this.mViewTypeStorage.getWrapperForGlobalType(i3).onCreateViewHolder(viewGroup, i3);
    }

    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        int size = this.mAttachedRecyclerViews.size() - 1;
        while (true) {
            if (size < 0) {
                break;
            }
            WeakReference<RecyclerView> weakReference = this.mAttachedRecyclerViews.get(size);
            if (weakReference.get() == null) {
                this.mAttachedRecyclerViews.remove(size);
            } else if (weakReference.get() == recyclerView) {
                this.mAttachedRecyclerViews.remove(size);
                break;
            }
            size--;
        }
        Iterator<NestedAdapterWrapper> it = this.mWrappers.iterator();
        while (it.hasNext()) {
            it.next().adapter.onDetachedFromRecyclerView(recyclerView);
        }
    }

    public boolean onFailedToRecycleView(RecyclerView.ViewHolder viewHolder) {
        NestedAdapterWrapper nestedAdapterWrapper = this.mBinderLookup.get(viewHolder);
        if (nestedAdapterWrapper != null) {
            boolean onFailedToRecycleView = nestedAdapterWrapper.adapter.onFailedToRecycleView(viewHolder);
            this.mBinderLookup.remove(viewHolder);
            return onFailedToRecycleView;
        }
        throw new IllegalStateException("Cannot find wrapper for " + viewHolder + ", seems like it is not bound by this adapter: " + this);
    }

    @Override // com.tencent.biz.richframework.part.adapter.widget.NestedAdapterWrapper.Callback
    public void onItemRangeChanged(@NonNull NestedAdapterWrapper nestedAdapterWrapper, int i3, int i16, @Nullable Object obj) {
        this.mConcatAdapter.notifyItemRangeChanged(i3 + countItemsBefore(nestedAdapterWrapper), i16, obj);
    }

    @Override // com.tencent.biz.richframework.part.adapter.widget.NestedAdapterWrapper.Callback
    public void onItemRangeInserted(@NonNull NestedAdapterWrapper nestedAdapterWrapper, int i3, int i16) {
        this.mConcatAdapter.notifyItemRangeInserted(i3 + countItemsBefore(nestedAdapterWrapper), i16);
    }

    @Override // com.tencent.biz.richframework.part.adapter.widget.NestedAdapterWrapper.Callback
    public void onItemRangeMoved(@NonNull NestedAdapterWrapper nestedAdapterWrapper, int i3, int i16) {
        int countItemsBefore = countItemsBefore(nestedAdapterWrapper);
        this.mConcatAdapter.notifyItemMoved(i3 + countItemsBefore, i16 + countItemsBefore);
    }

    @Override // com.tencent.biz.richframework.part.adapter.widget.NestedAdapterWrapper.Callback
    public void onItemRangeRemoved(@NonNull NestedAdapterWrapper nestedAdapterWrapper, int i3, int i16) {
        this.mConcatAdapter.notifyItemRangeRemoved(i3 + countItemsBefore(nestedAdapterWrapper), i16);
    }

    public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
        getWrapper(viewHolder).adapter.onViewAttachedToWindow(viewHolder);
    }

    public void onViewDetachedFromWindow(RecyclerView.ViewHolder viewHolder) {
        getWrapper(viewHolder).adapter.onViewDetachedFromWindow(viewHolder);
    }

    public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
        NestedAdapterWrapper nestedAdapterWrapper = this.mBinderLookup.get(viewHolder);
        if (nestedAdapterWrapper != null) {
            nestedAdapterWrapper.adapter.onViewRecycled(viewHolder);
            this.mBinderLookup.remove(viewHolder);
            return;
        }
        throw new IllegalStateException("Cannot find wrapper for " + viewHolder + ", seems like it is not bound by this adapter: " + this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean removeAdapter(RecyclerView.Adapter<RecyclerView.ViewHolder> adapter) {
        int indexOfWrapper = indexOfWrapper(adapter);
        if (indexOfWrapper == -1) {
            return false;
        }
        NestedAdapterWrapper nestedAdapterWrapper = this.mWrappers.get(indexOfWrapper);
        int countItemsBefore = countItemsBefore(nestedAdapterWrapper);
        this.mWrappers.remove(indexOfWrapper);
        this.mConcatAdapter.notifyItemRangeRemoved(countItemsBefore, nestedAdapterWrapper.getCachedItemCount());
        Iterator<WeakReference<RecyclerView>> it = this.mAttachedRecyclerViews.iterator();
        while (it.hasNext()) {
            RecyclerView recyclerView = it.next().get();
            if (recyclerView != null) {
                adapter.onDetachedFromRecyclerView(recyclerView);
            }
        }
        nestedAdapterWrapper.dispose();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SuppressLint({"RestrictedApi"})
    public boolean addAdapter(int i3, RecyclerView.Adapter<RecyclerView.ViewHolder> adapter) {
        if (i3 >= 0 && i3 <= this.mWrappers.size()) {
            if (hasStableIds()) {
                if (!adapter.hasStableIds()) {
                    RFWLog.w("ConcatAdapter", RFWLog.DEV, "All sub adapters must have stable ids when stable id mode is ISOLATED_STABLE_IDS or SHARED_STABLE_IDS");
                    adapter.setHasStableIds(true);
                }
            } else if (adapter.hasStableIds()) {
                RFWLog.w("ConcatAdapter", RFWLog.DEV, "Stable ids in the adapter will be ignored as the ConcatAdapter is configured not to have stable ids");
            }
            if (findWrapperFor(adapter) != null) {
                return false;
            }
            NestedAdapterWrapper nestedAdapterWrapper = new NestedAdapterWrapper(adapter, this, this.mViewTypeStorage, this.mStableIdStorage.createStableIdLookup());
            this.mWrappers.add(i3, nestedAdapterWrapper);
            Iterator<WeakReference<RecyclerView>> it = this.mAttachedRecyclerViews.iterator();
            while (it.hasNext()) {
                RecyclerView recyclerView = it.next().get();
                if (recyclerView != null) {
                    adapter.onAttachedToRecyclerView(recyclerView);
                }
            }
            if (nestedAdapterWrapper.getCachedItemCount() > 0) {
                this.mConcatAdapter.notifyItemRangeInserted(countItemsBefore(nestedAdapterWrapper), nestedAdapterWrapper.getCachedItemCount());
            }
            return true;
        }
        throw new IndexOutOfBoundsException("Index must be between 0 and " + this.mWrappers.size() + ". Given:" + i3);
    }
}
