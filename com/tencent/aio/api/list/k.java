package com.tencent.aio.api.list;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.AIORecycleView;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J \u0010\u000e\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/aio/api/list/k;", "", "Landroid/content/Context;", "context", "Landroidx/fragment/app/Fragment;", "hostFragment", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "b", "recycledViewPool", "Landroidx/recyclerview/widget/AIORecycleView;", "aioRecycleView", "Lkotlinx/coroutines/CoroutineScope;", "scope", "", "a", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public interface k {
    void a(@NotNull RecyclerView.RecycledViewPool recycledViewPool, @NotNull AIORecycleView aioRecycleView, @NotNull CoroutineScope scope);

    @Nullable
    RecyclerView.RecycledViewPool b(@NotNull Context context, @NotNull Fragment hostFragment);
}
