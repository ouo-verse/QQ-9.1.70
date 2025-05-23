package com.qzone.reborn.intimate.widget;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0016B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\f\u00a2\u0006\u0004\b\u0014\u0010\u0012J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016R\"\u0010\u0013\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0017"}, d2 = {"Lcom/qzone/reborn/intimate/widget/z;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "", "d", "I", "getGridCount", "()I", "setGridCount", "(I)V", "gridCount", "<init>", "e", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class z extends RecyclerView.ItemDecoration {

    /* renamed from: f, reason: collision with root package name */
    private static final int f57757f = ImmersiveUtils.dpToPx(1.0f);

    /* renamed from: h, reason: collision with root package name */
    private static final int f57758h = ImmersiveUtils.dpToPx(16.0f);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int gridCount;

    public z(int i3) {
        this.gridCount = i3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(outRect, "outRect");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        super.getItemOffsets(outRect, view, parent, state);
        int childAdapterPosition = parent.getChildAdapterPosition(view);
        int i3 = this.gridCount;
        if (childAdapterPosition % i3 == 0) {
            outRect.left = 0;
            outRect.right = (int) ((f57757f / i3) * 2);
        } else if (childAdapterPosition % i3 == 1) {
            int i16 = f57757f;
            outRect.left = i16 / i3;
            outRect.right = i16 / i3;
        } else {
            outRect.left = (int) ((f57757f / i3) * 2);
            outRect.right = 0;
        }
        if (childAdapterPosition < i3) {
            outRect.top = f57758h;
            outRect.bottom = f57757f;
        } else {
            outRect.top = 0;
            outRect.bottom = f57757f;
        }
    }
}
