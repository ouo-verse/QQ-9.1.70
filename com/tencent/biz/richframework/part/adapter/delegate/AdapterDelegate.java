package com.tencent.biz.richframework.part.adapter.delegate;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public abstract class AdapterDelegate<T> {
    /* JADX INFO: Access modifiers changed from: protected */
    public abstract boolean isForViewType(@NonNull T t16, int i3);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void onBindViewHolder(@NonNull T t16, int i3, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull List<Object> list);

    /* JADX INFO: Access modifiers changed from: protected */
    @NonNull
    public abstract RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup);

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean onFailedToRecycleView(@NonNull RecyclerView.ViewHolder viewHolder) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onViewAttachedToWindow(@NonNull RecyclerView.ViewHolder viewHolder) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onViewDetachedFromWindow(@NonNull RecyclerView.ViewHolder viewHolder) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onViewRecycled(@NonNull RecyclerView.ViewHolder viewHolder) {
    }
}
