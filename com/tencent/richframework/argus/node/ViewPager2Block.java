package com.tencent.richframework.argus.node;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u00a2\u0006\u0002\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\t\u00a8\u0006\n"}, d2 = {"Lcom/tencent/richframework/argus/node/ViewPager2Block;", "Lcom/tencent/richframework/argus/node/ArgusNode;", "Landroidx/viewpager2/widget/ViewPager2;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Landroid/view/View;", "viewPager2", "(Landroid/view/View;Landroidx/viewpager2/widget/ViewPager2;)V", "isSelfVisible", "", "()Z", "lifecycle_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes25.dex */
public final class ViewPager2Block extends ArgusNode<ViewPager2> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewPager2Block(@NotNull View rootView, @NotNull ViewPager2 viewPager2) {
        super(rootView, viewPager2);
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Intrinsics.checkNotNullParameter(viewPager2, "viewPager2");
    }

    @Override // com.tencent.richframework.argus.node.ArgusNode
    public boolean isSelfVisible() {
        ViewPager2 viewPager2 = getContainerWrf().get();
        View view = getNodeViewWrf().get();
        if (viewPager2 == null || view == null || viewPager2.getChildCount() <= 0) {
            return false;
        }
        View childAt = viewPager2.getChildAt(0);
        View view2 = null;
        if (!(childAt instanceof RecyclerView)) {
            childAt = null;
        }
        RecyclerView recyclerView = (RecyclerView) childAt;
        if (recyclerView == null) {
            return false;
        }
        int currentItem = viewPager2.getCurrentItem();
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if (adapter == null || currentItem >= adapter.getItemCount()) {
            return false;
        }
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager != null) {
            view2 = layoutManager.findViewByPosition(currentItem);
        }
        if (view2 != view || !super.isSelfVisible()) {
            return false;
        }
        return true;
    }
}
