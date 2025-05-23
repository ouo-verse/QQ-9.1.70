package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.LinkedHashSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u001e\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\b0\nj\b\u0012\u0004\u0012\u00020\b`\u000b2\u0006\u0010\f\u001a\u00020\rJ\u0010\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u000f"}, d2 = {"Landroidx/recyclerview/widget/RecyclerViewHelper;", "", "()V", "bindViewHolderToItemView", "", "itemView", "Landroid/view/View;", "viewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "getAllAttachedViewHolder", "Ljava/util/LinkedHashSet;", "Lkotlin/collections/LinkedHashSet;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getOwnerRecyclerView", "part-adapter_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes.dex */
public final class RecyclerViewHelper {

    @NotNull
    public static final RecyclerViewHelper INSTANCE = new RecyclerViewHelper();

    RecyclerViewHelper() {
    }

    public final void bindViewHolderToItemView(@NotNull View itemView, @NotNull RecyclerView.ViewHolder viewHolder) {
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        ViewGroup.LayoutParams layoutParams = itemView.getLayoutParams();
        if (!(layoutParams instanceof RecyclerView.LayoutParams)) {
            layoutParams = null;
        }
        RecyclerView.LayoutParams layoutParams2 = (RecyclerView.LayoutParams) layoutParams;
        if (layoutParams2 != null) {
            layoutParams2.mViewHolder = viewHolder;
        }
    }

    @NotNull
    public final LinkedHashSet<RecyclerView.ViewHolder> getAllAttachedViewHolder(@NotNull RecyclerView recyclerView) {
        RecyclerView.ViewHolder viewHolder;
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        LinkedHashSet<RecyclerView.ViewHolder> linkedHashSet = new LinkedHashSet<>();
        int childCount = recyclerView.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View itemView = recyclerView.getChildAt(i3);
            Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
            ViewGroup.LayoutParams layoutParams = itemView.getLayoutParams();
            if (!(layoutParams instanceof RecyclerView.LayoutParams)) {
                layoutParams = null;
            }
            RecyclerView.LayoutParams layoutParams2 = (RecyclerView.LayoutParams) layoutParams;
            if (layoutParams2 != null && (viewHolder = layoutParams2.mViewHolder) != null) {
                linkedHashSet.add(viewHolder);
            }
        }
        return linkedHashSet;
    }

    @Nullable
    public final RecyclerView getOwnerRecyclerView(@NotNull View itemView) {
        RecyclerView.ViewHolder viewHolder;
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        ViewGroup.LayoutParams layoutParams = itemView.getLayoutParams();
        if (!(layoutParams instanceof RecyclerView.LayoutParams)) {
            layoutParams = null;
        }
        RecyclerView.LayoutParams layoutParams2 = (RecyclerView.LayoutParams) layoutParams;
        if (layoutParams2 == null || (viewHolder = layoutParams2.mViewHolder) == null) {
            return null;
        }
        return viewHolder.mOwnerRecyclerView;
    }
}
