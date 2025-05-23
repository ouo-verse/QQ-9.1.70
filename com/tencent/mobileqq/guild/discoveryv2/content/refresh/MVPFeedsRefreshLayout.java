package com.tencent.mobileqq.guild.discoveryv2.content.refresh;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.view.NestedScrollingChild;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.richframework.widget.refresh.layout.SmartRefreshLayout;
import com.tencent.richframework.widget.refresh.layout.util.SmartUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u00a2\u0006\u0004\b \u0010!J \u0010\b\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J2\u0010\u0010\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u0018\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0016J,\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\t2\b\u0010\u0007\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J \u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\tH\u0016J\u000e\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0005\u001a\u00020\u0003\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/content/refresh/MVPFeedsRefreshLayout;", "Lcom/tencent/richframework/widget/refresh/layout/SmartRefreshLayout;", "Landroidx/core/view/NestedScrollingChild;", "", "velocityX", "velocityY", "", "consumed", "dispatchNestedFling", "", "dxConsumed", "dyConsumed", "dxUnconsumed", "dyUnconsumed", "", "offsetInWindow", "dispatchNestedScroll", "dispatchNestedPreFling", "dx", "dy", "dispatchNestedPreScroll", "Landroid/view/View;", "child", "target", "nestedScrollAxes", "onStartNestedScroll", "", "c", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class MVPFeedsRefreshLayout extends SmartRefreshLayout implements NestedScrollingChild {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MVPFeedsRefreshLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void c(float velocityY) {
        Logger.f235387a.d().i("MVPFeedsRefreshLayout", 1, "fling: velocityY=" + velocityY + ", spinner=" + this.mSpinner + ", " + this.mState);
        SmartUtil.fling(this.mRefreshContent.getScrollableView(), (int) velocityY);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedFling(float velocityX, float velocityY, boolean consumed) {
        Logger.f235387a.d().i("MVPFeedsRefreshLayout", 1, "dispatchNestedFling: velocityX=" + velocityX + ", velocityY=" + velocityY + ", consumed=" + consumed);
        return this.mNestedChild.dispatchNestedFling(velocityX, velocityY, consumed);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float velocityX, float velocityY) {
        Logger.f235387a.d().i("MVPFeedsRefreshLayout", 1, "dispatchNestedPreFling: velocityX=" + velocityX + ", velocityY=" + velocityY);
        return this.mNestedChild.dispatchNestedPreFling(velocityX, velocityY);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int dx5, int dy5, @Nullable int[] consumed, @Nullable int[] offsetInWindow) {
        Logger.f235387a.d().i("MVPFeedsRefreshLayout", 1, "dispatchNestedPreScroll: dx=" + dx5 + ", dy=" + dy5);
        return this.mNestedChild.dispatchNestedPreScroll(dx5, dy5, consumed, offsetInWindow);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, @Nullable int[] offsetInWindow) {
        Logger.f235387a.d().i("MVPFeedsRefreshLayout", 1, "dispatchNestedScroll: dxConsumed=" + dxConsumed + ", dyConsumed=" + dyConsumed + ", dxUnconsumed=" + dxUnconsumed + ", dyUnconsumed=" + dyUnconsumed);
        return this.mNestedChild.dispatchNestedScroll(dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, offsetInWindow);
    }

    @Override // com.tencent.richframework.widget.refresh.layout.SmartRefreshLayout, android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onStartNestedScroll(@NotNull View child, @NotNull View target, int nestedScrollAxes) {
        Intrinsics.checkNotNullParameter(child, "child");
        Intrinsics.checkNotNullParameter(target, "target");
        Logger logger = Logger.f235387a;
        logger.d().i("MVPFeedsRefreshLayout", 1, "onStartNestedScroll: child=" + child.getClass().getSimpleName() + ", target=" + target.getClass().getSimpleName() + ", nestedScrollAxes=" + nestedScrollAxes);
        boolean onStartNestedScroll = super.onStartNestedScroll(child, target, nestedScrollAxes);
        Logger.a d16 = logger.d();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("onStartNestedScroll: ret=");
        sb5.append(onStartNestedScroll);
        d16.i("MVPFeedsRefreshLayout", 1, sb5.toString());
        return onStartNestedScroll;
    }
}
