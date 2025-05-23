package com.tencent.mobileqq.guild.base.extension;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J$\u0010\n\u001a\u00020\t*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J(\u0010\u000f\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rH\u0016J \u0010\u0011\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rH\u0016R\u0017\u0010\u0016\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/guild/base/extension/e;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/drawable/Drawable;", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/graphics/Canvas;", PM.CANVAS, "", "a", "Landroid/graphics/Rect;", "outRect", "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "getItemOffsets", "c", "onDraw", "d", "Landroid/graphics/drawable/Drawable;", "getDivider", "()Landroid/graphics/drawable/Drawable;", "divider", "<init>", "(Landroid/graphics/drawable/Drawable;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
final class e extends RecyclerView.ItemDecoration {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Drawable divider;

    public e(@NotNull Drawable divider) {
        Intrinsics.checkNotNullParameter(divider, "divider");
        this.divider = divider;
    }

    private final void a(Drawable drawable, View view, RecyclerView recyclerView, Canvas canvas) {
        int left = view.getLeft();
        int right = view.getRight();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
        int bottom = view.getBottom() + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) layoutParams)).bottomMargin;
        drawable.setBounds(new Rect(left, bottom, right, this.divider.getIntrinsicHeight() + bottom));
        drawable.draw(canvas);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(@NotNull Rect outRect, @NotNull View view, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
        int i3;
        Intrinsics.checkNotNullParameter(outRect, "outRect");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        RecyclerView.Adapter adapter = parent.getAdapter();
        if (adapter == null) {
            return;
        }
        Object childViewHolder = parent.getChildViewHolder(view);
        int childAdapterPosition = parent.getChildAdapterPosition(view);
        if ((childViewHolder instanceof f) && (i3 = childAdapterPosition + 1) < adapter.getItemCount()) {
            if (!((f) childViewHolder).c(adapter.getItemViewType(i3))) {
                return;
            }
            outRect.bottom = this.divider.getIntrinsicHeight();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(@NotNull Canvas c16, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
        IntRange until;
        Intrinsics.checkNotNullParameter(c16, "c");
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        RecyclerView.Adapter adapter = parent.getAdapter();
        if (adapter != null) {
            until = RangesKt___RangesKt.until(0, parent.getChildCount());
            Iterator<Integer> it = until.iterator();
            if (!it.hasNext()) {
                CollectionsKt__CollectionsKt.emptyList();
                return;
            }
            ArrayList arrayList = new ArrayList();
            IntIterator intIterator = (IntIterator) it;
            int nextInt = intIterator.nextInt();
            while (it.hasNext()) {
                int nextInt2 = intIterator.nextInt();
                View childView = parent.getChildAt(nextInt);
                Object childViewHolder = parent.getChildViewHolder(childView);
                int childAdapterPosition = parent.getChildAdapterPosition(parent.getChildAt(nextInt2));
                if (childAdapterPosition >= 0) {
                    int itemViewType = adapter.getItemViewType(childAdapterPosition);
                    if ((childViewHolder instanceof f) && ((f) childViewHolder).c(itemViewType)) {
                        Drawable drawable = this.divider;
                        Intrinsics.checkNotNullExpressionValue(childView, "childView");
                        a(drawable, childView, parent, c16);
                    }
                }
                arrayList.add(Unit.INSTANCE);
                nextInt = nextInt2;
            }
        }
    }
}
