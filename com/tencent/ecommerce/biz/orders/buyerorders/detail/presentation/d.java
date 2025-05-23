package com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/d;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class d extends RecyclerView.ItemDecoration {
    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof StaggeredGridLayoutManager.LayoutParams)) {
            layoutParams = null;
        }
        StaggeredGridLayoutManager.LayoutParams layoutParams2 = (StaggeredGridLayoutManager.LayoutParams) layoutParams;
        if (layoutParams2 != null) {
            int childAdapterPosition = parent.getChildAdapterPosition(view);
            RecyclerView.Adapter adapter = parent.getAdapter();
            Integer valueOf = adapter != null ? Integer.valueOf(adapter.getItemViewType(childAdapterPosition)) : null;
            if (valueOf != null && valueOf.intValue() == 9) {
                outRect.bottom = com.tencent.ecommerce.biz.util.e.c(6.0f);
                if (layoutParams2.getSpanIndex() == 0) {
                    outRect.left = com.tencent.ecommerce.biz.util.e.c(16.0f);
                    outRect.right = com.tencent.ecommerce.biz.util.e.c(6.0f);
                } else {
                    outRect.left = com.tencent.ecommerce.biz.util.e.c(6.0f);
                    outRect.right = com.tencent.ecommerce.biz.util.e.c(16.0f);
                }
            }
        }
    }
}
