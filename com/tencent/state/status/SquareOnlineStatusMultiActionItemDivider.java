package com.tencent.state.status;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.state.square.SquareBase;
import com.tencent.state.square.common.ViewExtensionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J(\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/state/status/SquareOnlineStatusMultiActionItemDivider;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "()V", "itemSpace", "", "topSpace", "topSpaceOnlyTwoCount", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquareOnlineStatusMultiActionItemDivider extends RecyclerView.ItemDecoration {
    private final int itemSpace;
    private final int topSpace;
    private final int topSpaceOnlyTwoCount;

    public SquareOnlineStatusMultiActionItemDivider() {
        SquareBase squareBase = SquareBase.INSTANCE;
        this.itemSpace = ViewExtensionsKt.dip((Context) squareBase.getApp(), 2);
        this.topSpace = ViewExtensionsKt.dip((Context) squareBase.getApp(), 66);
        this.topSpaceOnlyTwoCount = ViewExtensionsKt.dip((Context) squareBase.getApp(), 20);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        int i3;
        int dip;
        Intrinsics.checkNotNullParameter(outRect, "outRect");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        super.getItemOffsets(outRect, view, parent, state);
        int childAdapterPosition = parent.getChildAdapterPosition(view);
        RecyclerView.Adapter adapter = parent.getAdapter();
        int itemCount = adapter != null ? adapter.getItemCount() : 0;
        if (childAdapterPosition < 0) {
            return;
        }
        if (itemCount != 2) {
            i3 = this.topSpace;
        } else {
            i3 = this.topSpaceOnlyTwoCount;
        }
        if (itemCount == 2) {
            dip = ViewExtensionsKt.dip((Context) SquareBase.INSTANCE.getApp(), 76);
        } else if (itemCount != 3) {
            dip = ViewExtensionsKt.dip((Context) SquareBase.INSTANCE.getApp(), 102);
        } else {
            dip = ViewExtensionsKt.dip((Context) SquareBase.INSTANCE.getApp(), 66);
        }
        if (childAdapterPosition == 0) {
            outRect.top = i3;
        } else if (childAdapterPosition == itemCount - 1) {
            outRect.top = this.itemSpace;
            outRect.bottom = dip;
        } else {
            outRect.top = this.itemSpace;
        }
    }
}
