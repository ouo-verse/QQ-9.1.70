package com.tencent.biz.richframework.part.adapter.delegate;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public abstract class AbsListItemAdapterDelegate<I extends T, T, VH extends RecyclerView.ViewHolder> extends AdapterDelegate<List<T>> {
    protected abstract boolean isForViewType(@NonNull T t16, @NonNull List<T> list, int i3);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.delegate.AdapterDelegate
    public /* bridge */ /* synthetic */ void onBindViewHolder(@NonNull Object obj, int i3, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull List list) {
        onBindViewHolder((List) obj, i3, viewHolder, (List<Object>) list);
    }

    /* renamed from: onBindViewHolder */
    protected abstract void onBindViewHolder2(@NonNull I i3, @NonNull VH vh5, int i16, @NonNull List<Object> list);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.delegate.AdapterDelegate
    @NonNull
    public abstract VH onCreateViewHolder(@NonNull ViewGroup viewGroup);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.delegate.AdapterDelegate
    public final boolean isForViewType(@NonNull List<T> list, int i3) {
        if (i3 >= list.size()) {
            return false;
        }
        return isForViewType(list.get(i3), list, i3);
    }

    protected final void onBindViewHolder(@NonNull List<T> list, int i3, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull List<Object> list2) {
        onBindViewHolder2((AbsListItemAdapterDelegate<I, T, VH>) list.get(i3), (T) viewHolder, i3, list2);
    }
}
