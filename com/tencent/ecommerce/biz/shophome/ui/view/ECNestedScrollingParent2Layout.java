package com.tencent.ecommerce.biz.shophome.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.view.NestedScrollingParent2;
import androidx.core.view.NestedScrollingParentHelper;
import cg0.a;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.ecommerce.biz.util.e;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import tl.h;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 82\u00020\u00012\u00020\u0002:\u00029:B\u0011\b\u0016\u0012\u0006\u00100\u001a\u00020/\u00a2\u0006\u0004\b1\u00102B\u0019\b\u0016\u0012\u0006\u00100\u001a\u00020/\u0012\u0006\u00104\u001a\u000203\u00a2\u0006\u0004\b1\u00105B!\b\u0016\u0012\u0006\u00100\u001a\u00020/\u0012\u0006\u00104\u001a\u000203\u0012\u0006\u00106\u001a\u00020\u0006\u00a2\u0006\u0004\b1\u00107J(\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016J(\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016J0\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\u0006H\u0016J\u0018\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0006H\u0016J8\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016J\b\u0010\u0018\u001a\u00020\u0006H\u0016J\u0018\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0006H\u0016J(\u0010 \u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u0006H\u0014J\u000e\u0010\"\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u0006R\u0018\u0010&\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010*\u001a\u00020'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010!\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010.\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010-\u00a8\u0006;"}, d2 = {"Lcom/tencent/ecommerce/biz/shophome/ui/view/ECNestedScrollingParent2Layout;", "Landroid/widget/LinearLayout;", "Landroidx/core/view/NestedScrollingParent2;", "Landroid/view/View;", "child", "target", "", "axes", "type", "", "onStartNestedScroll", "", "onNestedScrollAccepted", "dx", "dy", "", "consumed", "onNestedPreScroll", "onStopNestedScroll", "dxConsumed", "dyConsumed", "dxUnconsumed", "dyUnconsumed", "onNestedScroll", "getNestedScrollAxes", HippyTKDListViewAdapter.X, "y", "scrollTo", "w", h.F, "oldw", "oldh", MosaicConstants$JsFunction.FUNC_ON_SIZE_CHANGED, "topViewHeight", "b", "Lcom/tencent/ecommerce/biz/shophome/ui/view/ECNestedScrollingParent2Layout$ECNestedScrollListener;", "d", "Lcom/tencent/ecommerce/biz/shophome/ui/view/ECNestedScrollingParent2Layout$ECNestedScrollListener;", "nestedScrollListener", "Landroidx/core/view/NestedScrollingParentHelper;", "e", "Landroidx/core/view/NestedScrollingParentHelper;", "nestedScrollingParentHelper", "f", "I", "Z", "hasExpandHeight", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "ECNestedScrollListener", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECNestedScrollingParent2Layout extends LinearLayout implements NestedScrollingParent2 {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ECNestedScrollListener nestedScrollListener;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final NestedScrollingParentHelper nestedScrollingParentHelper;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int topViewHeight;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean hasExpandHeight;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: i, reason: collision with root package name */
    private static final int f104371i = e.c(80.0f);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/ecommerce/biz/shophome/ui/view/ECNestedScrollingParent2Layout$ECNestedScrollListener;", "", "scrolled", "", "dx", "", "dy", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public interface ECNestedScrollListener {
        void scrolled(int dx5, int dy5);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2 = {"Lcom/tencent/ecommerce/biz/shophome/ui/view/ECNestedScrollingParent2Layout$a;", "", "", "DEFAULT_TOP_VIEW_HEIGHT", "I", "a", "()I", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.biz.shophome.ui.view.ECNestedScrollingParent2Layout$a, reason: from kotlin metadata */
    /* loaded from: classes31.dex */
    public static final class Companion {
        Companion() {
        }

        public final int a() {
            return ECNestedScrollingParent2Layout.f104371i;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ECNestedScrollingParent2Layout(Context context) {
        super(context);
        this.nestedScrollingParentHelper = new NestedScrollingParentHelper(this);
        this.topViewHeight = f104371i;
        setOrientation(1);
    }

    public final void b(int topViewHeight) {
        this.topViewHeight = topViewHeight;
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return this.nestedScrollingParentHelper.getNestedScrollAxes();
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScrollAccepted(View child, View target, int axes, int type) {
        this.nestedScrollingParentHelper.onNestedScrollAccepted(child, target, axes, type);
    }

    @Override // android.view.View
    protected void onSizeChanged(int w3, int h16, int oldw, int oldh) {
        super.onSizeChanged(w3, h16, oldw, oldh);
        a.b("ECNestedScrollingParent2Layout ", "[onSizeChanged] w = " + w3 + ", h = " + h16 + ", oldw = " + oldw + ", oldh = " + oldh + ", topViewHeight = " + this.topViewHeight);
        if (this.hasExpandHeight) {
            return;
        }
        this.hasExpandHeight = true;
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = h16 + this.topViewHeight;
        setLayoutParams(layoutParams);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public boolean onStartNestedScroll(View child, View target, int axes, int type) {
        if ((axes & 2) != 0) {
            return true;
        }
        return false;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onStopNestedScroll(View target, int type) {
        this.nestedScrollingParentHelper.onStopNestedScroll(target, type);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScroll(View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int type) {
        if (dyUnconsumed < 0) {
            scrollBy(0, dyUnconsumed);
        }
    }

    @Override // android.view.View
    public void scrollTo(int x16, int y16) {
        if (y16 < 0) {
            y16 = 0;
        }
        int i3 = this.topViewHeight;
        if (y16 > i3) {
            y16 = i3;
        }
        ECNestedScrollListener eCNestedScrollListener = this.nestedScrollListener;
        if (eCNestedScrollListener != null) {
            eCNestedScrollListener.scrolled(x16, y16);
        }
        super.scrollTo(x16, y16);
    }

    public ECNestedScrollingParent2Layout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nestedScrollingParentHelper = new NestedScrollingParentHelper(this);
        this.topViewHeight = f104371i;
        setOrientation(1);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedPreScroll(View target, int dx5, int dy5, int[] consumed, int type) {
        boolean z16 = dy5 > 0 && getScrollY() < this.topViewHeight;
        boolean z17 = dy5 < 0 && getScrollY() >= 0 && !target.canScrollVertically(-1);
        if (z16 || z17) {
            scrollBy(0, dy5);
            consumed[1] = dy5;
        }
    }

    public ECNestedScrollingParent2Layout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.nestedScrollingParentHelper = new NestedScrollingParentHelper(this);
        this.topViewHeight = f104371i;
        setOrientation(1);
    }
}
