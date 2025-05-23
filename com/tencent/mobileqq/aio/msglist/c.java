package com.tencent.mobileqq.aio.msglist;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u001a\u0012\u0010\u0003\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001\u00a8\u0006\u0004"}, d2 = {"Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "", "viewType", "a", "aio_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class c {
    public static final synchronized int a(@NotNull RecyclerView.RecycledViewPool recycledViewPool, int i3) {
        int recycledViewCount;
        synchronized (c.class) {
            Intrinsics.checkNotNullParameter(recycledViewPool, "<this>");
            recycledViewCount = recycledViewPool.getRecycledViewCount(i3);
        }
        return recycledViewCount;
    }
}
