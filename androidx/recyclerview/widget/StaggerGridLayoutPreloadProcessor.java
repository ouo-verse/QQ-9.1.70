package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016\u00a8\u0006\u000b"}, d2 = {"Landroidx/recyclerview/widget/StaggerGridLayoutPreloadProcessor;", "Landroidx/recyclerview/widget/SimpleCountProcessor;", "()V", "getLastVisibleItemPosition", "", "manager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "isTargetProcess", "", "view", "Landroidx/recyclerview/widget/RecyclerView;", "argus-recyclerview-preload_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes.dex */
public final class StaggerGridLayoutPreloadProcessor extends SimpleCountProcessor {
    @Override // androidx.recyclerview.widget.SimpleCountProcessor
    public int getLastVisibleItemPosition(@NotNull RecyclerView.LayoutManager manager) {
        Integer maxOrNull;
        Intrinsics.checkNotNullParameter(manager, "manager");
        StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) manager;
        int[] iArr = new int[staggeredGridLayoutManager.getSpanCount()];
        staggeredGridLayoutManager.findLastVisibleItemPositions(iArr);
        maxOrNull = ArraysKt___ArraysKt.maxOrNull(iArr);
        if (maxOrNull != null) {
            return maxOrNull.intValue();
        }
        return -1;
    }

    @Override // androidx.recyclerview.widget.SimpleCountProcessor, androidx.recyclerview.widget.AbsPreloadProcessor
    public boolean isTargetProcess(@NotNull RecyclerView view) {
        Intrinsics.checkNotNullParameter(view, "view");
        return view.getLayoutManager() instanceof StaggeredGridLayoutManager;
    }
}
