package com.tencent.mobileqq.search.searchdetail.filter;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\b\u0002\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u0011\u001a\u00020\f\u0012\u0006\u0010\u0013\u001a\u00020\f\u0012\u0006\u0010\u0015\u001a\u00020\f\u0012\u0006\u0010\u0017\u001a\u00020\f\u00a2\u0006\u0004\b\u0018\u0010\u0019J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016R\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u000eR\u0014\u0010\u0015\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u000eR\u0014\u0010\u0017\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u000e\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/filter/c;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "", "d", "I", "spanCount", "e", "spacingHorizontal", "f", "spacingVertical", tl.h.F, "edgeSpacingHorizontal", "i", "edgeSpacingVertical", "<init>", "(IIIII)V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
final class c extends RecyclerView.ItemDecoration {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int spanCount;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int spacingHorizontal;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final int spacingVertical;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final int edgeSpacingHorizontal;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final int edgeSpacingVertical;

    public c(int i3, int i16, int i17, int i18, int i19) {
        this.spanCount = i3;
        this.spacingHorizontal = i16;
        this.spacingVertical = i17;
        this.edgeSpacingHorizontal = i18;
        this.edgeSpacingVertical = i19;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(@NotNull Rect outRect, @NotNull View view, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(outRect, "outRect");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        int childAdapterPosition = parent.getChildAdapterPosition(view);
        int i3 = this.spanCount;
        int i16 = childAdapterPosition % i3;
        int i17 = this.spacingHorizontal;
        outRect.left = i17 - ((i16 * i17) / i3);
        outRect.right = ((i16 + 1) * i17) / i3;
        if (childAdapterPosition < i3) {
            outRect.top = this.edgeSpacingVertical;
        }
        outRect.bottom = this.spacingVertical;
        if (i16 == 0) {
            outRect.left = this.edgeSpacingHorizontal;
        }
        if (i16 == i3 - 1) {
            outRect.right = this.edgeSpacingHorizontal;
        }
    }
}
