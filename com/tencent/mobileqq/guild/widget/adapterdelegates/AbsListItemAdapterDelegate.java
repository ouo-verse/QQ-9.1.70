package com.tencent.mobileqq.guild.widget.adapterdelegates;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import java.util.List;

/* compiled from: P */
/* loaded from: classes14.dex */
public abstract class AbsListItemAdapterDelegate<I extends T, T, VH extends RecyclerView.ViewHolder> extends b<List<T>> {
    protected abstract boolean j(@NonNull T t16, @NonNull List<T> list, int i3);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.b
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public final boolean a(@NonNull List<T> list, int i3) {
        return j(list.get(i3), list, i3);
    }

    protected abstract void l(@NonNull I i3, @NonNull VH vh5, @NonNull List<Object> list);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.b
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public final void c(@NonNull List<T> list, int i3, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull List<Object> list2) {
        l(list.get(i3), viewHolder, list2);
        m(list.get(i3), viewHolder, list2, i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void m(@NonNull I i3, @NonNull VH vh5, @NonNull List<Object> list, @NonNull int i16) {
    }
}
