package androidx.recyclerview.widget;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: P */
/* loaded from: classes.dex */
public final class AdapterListUpdateCallback implements ListUpdateCallback {

    @NonNull
    private final RecyclerView.Adapter mAdapter;

    public AdapterListUpdateCallback(@NonNull RecyclerView.Adapter adapter) {
        this.mAdapter = adapter;
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onChanged(int i3, int i16, Object obj) {
        this.mAdapter.notifyItemRangeChanged(i3, i16, obj);
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
}
