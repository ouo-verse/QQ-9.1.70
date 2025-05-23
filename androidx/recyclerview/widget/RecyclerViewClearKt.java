package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u00a8\u0006\u0003"}, d2 = {"clearAllCachedViews", "", "Landroidx/recyclerview/widget/RecyclerView;", "cardcontainer_impl_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class RecyclerViewClearKt {
    public static final void clearAllCachedViews(@NotNull RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "<this>");
        RecyclerView.Recycler recycler = recyclerView.mRecycler;
        for (int size = recycler.mCachedViews.size() - 1; size >= 0; size--) {
            recycler.recycleCachedViewAt(size);
        }
    }
}
