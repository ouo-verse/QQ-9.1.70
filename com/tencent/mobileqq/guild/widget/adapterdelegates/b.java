package com.tencent.mobileqq.guild.widget.adapterdelegates;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

/* compiled from: P */
/* loaded from: classes14.dex */
public abstract class b<T> {
    /* JADX INFO: Access modifiers changed from: protected */
    public abstract boolean a(@NonNull T t16, int i3);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void c(@NonNull T t16, int i3, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull List<Object> list);

    /* JADX INFO: Access modifiers changed from: protected */
    @NonNull
    public abstract RecyclerView.ViewHolder d(@NonNull ViewGroup viewGroup);

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean f(@NonNull RecyclerView.ViewHolder viewHolder) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(RecyclerView recyclerView) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(RecyclerView recyclerView) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(@NonNull RecyclerView.ViewHolder viewHolder) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h(@NonNull RecyclerView.ViewHolder viewHolder) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i(@NonNull RecyclerView.ViewHolder viewHolder) {
    }
}
