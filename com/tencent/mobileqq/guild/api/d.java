package com.tencent.mobileqq.guild.api;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\r\u001a\u00020\u0002H\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/guild/api/d;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "", "g", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "e", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "holder", tl.h.F, "i", "", "d", "f", "<init>", "()V", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public abstract class d extends RecyclerView.OnScrollListener {
    @NotNull
    public abstract int[] d();

    public abstract void e(@NotNull RecyclerView recyclerView);

    public abstract void f();

    public abstract void g();

    public abstract void h(@NotNull RecyclerView.ViewHolder holder);

    public abstract void i(@NotNull RecyclerView.ViewHolder holder);
}
