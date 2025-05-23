package androidx.recyclerview.widget;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016\u00a8\u0006\b"}, d2 = {"Landroidx/recyclerview/widget/ArgusGapWorker;", "Landroidx/recyclerview/widget/GapWorker;", "()V", "add", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "Companion", "argus-recyclerview-preload_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes.dex */
public final class ArgusGapWorker extends GapWorker {
    private static final String TAG = "ArgusGapWorker";

    @Override // androidx.recyclerview.widget.GapWorker
    public void add(@NotNull RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.add(recyclerView);
    }
}
