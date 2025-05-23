package com.tencent.richframework.argus.node;

import android.view.View;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.ViewPagerLifecycleCompat;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u00a2\u0006\u0002\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\t\u00a8\u0006\n"}, d2 = {"Lcom/tencent/richframework/argus/node/ViewPagerNode;", "Lcom/tencent/richframework/argus/node/ArgusNode;", "Landroidx/viewpager/widget/ViewPager;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Landroid/view/View;", ParseCommon.CONTAINER, "(Landroid/view/View;Landroidx/viewpager/widget/ViewPager;)V", "isSelfVisible", "", "()Z", "lifecycle_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes25.dex */
public final class ViewPagerNode extends ArgusNode<ViewPager> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewPagerNode(@NotNull View rootView, @NotNull ViewPager container) {
        super(rootView, container);
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Intrinsics.checkNotNullParameter(container, "container");
    }

    @Override // com.tencent.richframework.argus.node.ArgusNode
    public boolean isSelfVisible() {
        ViewPager viewPager = getContainerWrf().get();
        if (viewPager == null) {
            return false;
        }
        Intrinsics.checkNotNullExpressionValue(viewPager, "containerWrf.get()?:return false");
        if (ViewPagerLifecycleCompat.INSTANCE.getCurrentView(viewPager) != getNodeViewWrf().get() || !super.isSelfVisible()) {
            return false;
        }
        return true;
    }
}
