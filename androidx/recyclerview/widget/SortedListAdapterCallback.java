package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SortedList;

/* compiled from: P */
/* loaded from: classes.dex */
public abstract class SortedListAdapterCallback<T2> extends SortedList.Callback<T2> {
    final RecyclerView.Adapter mAdapter;

    public SortedListAdapterCallback(RecyclerView.Adapter adapter) {
        this.mAdapter = adapter;
    }

    @Override // androidx.recyclerview.widget.SortedList.Callback
    public void onChanged(int i3, int i16) {
        this.mAdapter.notifyItemRangeChanged(i3, i16);
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onInserted(int i3, int i16) {
        this.mAdapter.notifyItemRangeInserted(i3, i16);
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onMoved(int i3, int i16) {
        this.mAdapter.notifyItemMoved(i3, i16);
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onRemoved(int i3, int i16) {
        this.mAdapter.notifyItemRangeRemoved(i3, i16);
    }

    @Override // androidx.recyclerview.widget.SortedList.Callback, androidx.recyclerview.widget.ListUpdateCallback
    public void onChanged(int i3, int i16, Object obj) {
        this.mAdapter.notifyItemRangeChanged(i3, i16, obj);
    }
}
