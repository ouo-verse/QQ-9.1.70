package com.tencent.ecommerce.biz.productcenter.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.core.view.NestedScrollingParent2;
import androidx.core.view.NestedScrollingParentHelper;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u0013\b\u0016\u0012\b\u0010$\u001a\u0004\u0018\u00010#\u00a2\u0006\u0004\b%\u0010&B\u001d\b\u0016\u0012\b\u0010$\u001a\u0004\u0018\u00010#\u0012\b\u0010(\u001a\u0004\u0018\u00010'\u00a2\u0006\u0004\b%\u0010)B%\b\u0016\u0012\b\u0010$\u001a\u0004\u0018\u00010#\u0012\b\u0010(\u001a\u0004\u0018\u00010'\u0012\u0006\u0010*\u001a\u00020\u0006\u00a2\u0006\u0004\b%\u0010+J(\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016J(\u0010\r\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016J0\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\u0006H\u0016J8\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016J\u0018\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0006H\u0016J \u0010\u001c\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0019H\u0016J(\u0010\u001d\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u0011\u001a\u00020\tH\u0016J\b\u0010\u001e\u001a\u00020\u0006H\u0016R\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!\u00a8\u0006,"}, d2 = {"Lcom/tencent/ecommerce/biz/productcenter/ui/view/ECNestedScrollingParent2Layout;", "Landroid/widget/LinearLayout;", "Landroidx/core/view/NestedScrollingParent2;", "Landroid/view/View;", "child", "target", "", "nestedScrollAxes", "type", "", "onStartNestedScroll", "axes", "", "onNestedScrollAccepted", "dx", "dy", "", "consumed", "onNestedPreScroll", "dxConsumed", "dyConsumed", "dxUnconsumed", "dyUnconsumed", "onNestedScroll", "onStopNestedScroll", "", "velocityX", "velocityY", "onNestedPreFling", "onNestedFling", "getNestedScrollAxes", "Landroidx/core/view/NestedScrollingParentHelper;", "d", "Landroidx/core/view/NestedScrollingParentHelper;", "nestedScrollingParentHelper", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public class ECNestedScrollingParent2Layout extends LinearLayout implements NestedScrollingParent2 {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final NestedScrollingParentHelper nestedScrollingParentHelper;

    public ECNestedScrollingParent2Layout(Context context) {
        super(context);
        this.nestedScrollingParentHelper = new NestedScrollingParentHelper(this);
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return this.nestedScrollingParentHelper.getNestedScrollAxes();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(View target, float velocityX, float velocityY, boolean consumed) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(View target, float velocityX, float velocityY) {
        return false;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScrollAccepted(View child, View target, int axes, int type) {
        this.nestedScrollingParentHelper.onNestedScrollAccepted(child, target, axes, type);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public boolean onStartNestedScroll(View child, View target, int nestedScrollAxes, int type) {
        return true;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onStopNestedScroll(View child, int type) {
        this.nestedScrollingParentHelper.onStopNestedScroll(child, type);
    }

    public ECNestedScrollingParent2Layout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nestedScrollingParentHelper = new NestedScrollingParentHelper(this);
    }

    public ECNestedScrollingParent2Layout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.nestedScrollingParentHelper = new NestedScrollingParentHelper(this);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedPreScroll(View target, int dx5, int dy5, int[] consumed, int type) {
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScroll(View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int type) {
    }
}
