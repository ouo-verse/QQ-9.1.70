package com.tencent.mobileqq.mini.entry.expDesktop.part.adapter;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005J(\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/expDesktop/part/adapter/MiniAppExpDesktopRvItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "margin", "Landroid/graphics/Rect;", "firstMargin", "(Landroid/graphics/Rect;Landroid/graphics/Rect;)V", "getItemOffsets", "", "outRect", "view", "Landroid/view/View;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniAppExpDesktopRvItemDecoration extends RecyclerView.ItemDecoration {
    private static final String TAG = "MiniAppExpDesktopRvItemDecoration";
    private final Rect firstMargin;
    private final Rect margin;

    public /* synthetic */ MiniAppExpDesktopRvItemDecoration(Rect rect, Rect rect2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(rect, (i3 & 2) != 0 ? new Rect() : rect2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(outRect, "outRect");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        super.getItemOffsets(outRect, view, parent, state);
        if (parent.getChildAdapterPosition(view) == 0) {
            Rect rect = this.firstMargin;
            outRect.top = rect.top;
            outRect.left = rect.left;
            outRect.bottom = rect.bottom;
            outRect.right = rect.right;
            return;
        }
        Rect rect2 = this.margin;
        outRect.top = rect2.top;
        outRect.left = rect2.left;
        outRect.bottom = rect2.bottom;
        outRect.right = rect2.right;
    }

    public MiniAppExpDesktopRvItemDecoration(Rect margin, Rect firstMargin) {
        Intrinsics.checkNotNullParameter(margin, "margin");
        Intrinsics.checkNotNullParameter(firstMargin, "firstMargin");
        this.margin = margin;
        this.firstMargin = firstMargin;
    }
}
