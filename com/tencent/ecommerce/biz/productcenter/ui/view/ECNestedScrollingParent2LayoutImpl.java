package com.tencent.ecommerce.biz.productcenter.ui.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import cg0.a;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.ecommerce.biz.util.q;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 B2\u00020\u00012\u00020\u0002:\u0001\u0004B)\b\u0007\u0012\b\u0010<\u001a\u0004\u0018\u00010;\u0012\n\b\u0002\u0010>\u001a\u0004\u0018\u00010=\u0012\b\b\u0002\u0010?\u001a\u00020\b\u00a2\u0006\u0004\b@\u0010AJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J(\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016J0\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\bH\u0016J8\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016J \u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0017H\u0016J(\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u0010\u001a\u00020\u000bH\u0016J\u0018\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\bH\u0014J(\u0010#\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\b2\u0006\u0010 \u001a\u00020\b2\u0006\u0010!\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\bH\u0014J\u0018\u0010&\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\b2\u0006\u0010%\u001a\u00020\bH\u0016J\u0010\u0010(\u001a\u00020\u00032\b\u0010'\u001a\u0004\u0018\u00010\u0005J\u0010\u0010*\u001a\u00020\u00032\b\u0010)\u001a\u0004\u0018\u00010\u0005J\u0010\u0010,\u001a\u00020\u00032\b\u0010+\u001a\u0004\u0018\u00010\u0005J\u000e\u0010/\u001a\u00020\u00032\u0006\u0010.\u001a\u00020-R\u0018\u0010.\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0018\u00104\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0018\u00105\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u00103R\u0018\u00107\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00103R\u0016\u0010:\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109\u00a8\u0006C"}, d2 = {"Lcom/tencent/ecommerce/biz/productcenter/ui/view/ECNestedScrollingParent2LayoutImpl;", "Lcom/tencent/ecommerce/biz/productcenter/ui/view/ECNestedScrollingParent2Layout;", "Landroidx/core/view/NestedScrollingParent2;", "", "a", "Landroid/view/View;", "child", "target", "", "nestedScrollAxes", "type", "", "onStartNestedScroll", "dx", "dy", "", "consumed", "onNestedPreScroll", "dxConsumed", "dyConsumed", "dxUnconsumed", "dyUnconsumed", "onNestedScroll", "", "velocityX", "velocityY", "onNestedPreFling", "onNestedFling", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "w", h.F, "oldw", "oldh", MosaicConstants$JsFunction.FUNC_ON_SIZE_CHANGED, HippyTKDListViewAdapter.X, "y", "scrollTo", "mTopView", "setTopView", "mTabLayout", "setTabLayout", "mViewPager", "setViewPager", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "setActivity", "e", "Landroid/app/Activity;", "f", "Landroid/view/View;", "topView", "tabLayout", "i", "viewPager", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "I", "topViewHeight", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BdhLogUtil.LogTag.Tag_Conn, "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECNestedScrollingParent2LayoutImpl extends ECNestedScrollingParent2Layout {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private Activity activity;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private View topView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private View tabLayout;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private View viewPager;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int topViewHeight;

    public ECNestedScrollingParent2LayoutImpl(Context context) {
        this(context, null, 0, 6, null);
    }

    private final void a() {
        int i3;
        View view = this.viewPager;
        if (view != null) {
            try {
                Intrinsics.checkNotNull(view);
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                layoutParams.height = getMeasuredHeight();
                View view2 = this.viewPager;
                Intrinsics.checkNotNull(view2);
                view2.setLayoutParams(layoutParams);
            } catch (Exception e16) {
                a.a("ECNestedScrollingParent2LayoutImpl", "onMeasure", "[onMeasure] error = " + e16);
            }
        }
        View view3 = this.topView;
        if (view3 != null) {
            i3 = view3.getMeasuredHeight();
        } else {
            i3 = this.topViewHeight;
        }
        this.topViewHeight = i3;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        a();
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override // com.tencent.ecommerce.biz.productcenter.ui.view.ECNestedScrollingParent2Layout, android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(View target, float velocityX, float velocityY, boolean consumed) {
        return false;
    }

    @Override // com.tencent.ecommerce.biz.productcenter.ui.view.ECNestedScrollingParent2Layout, android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(View target, float velocityX, float velocityY) {
        return false;
    }

    @Override // com.tencent.ecommerce.biz.productcenter.ui.view.ECNestedScrollingParent2Layout, androidx.core.view.NestedScrollingParent2
    public void onNestedPreScroll(View target, int dx5, int dy5, int[] consumed, int type) {
        Activity activity = this.activity;
        if (activity != null) {
            q.f104879a.a(activity, getContext());
            a();
        }
        boolean z16 = dy5 > 0 && getScrollY() < this.topViewHeight;
        boolean z17 = dy5 < 0 && getScrollY() >= 0 && !target.canScrollVertically(-1);
        if (z16 || z17) {
            scrollBy(0, dy5);
            consumed[1] = dy5;
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int w3, int h16, int oldw, int oldh) {
        int i3;
        super.onSizeChanged(w3, h16, oldw, oldh);
        View view = this.topView;
        if (view != null) {
            i3 = view.getMeasuredHeight();
        } else {
            i3 = this.topViewHeight;
        }
        this.topViewHeight = i3;
    }

    @Override // com.tencent.ecommerce.biz.productcenter.ui.view.ECNestedScrollingParent2Layout, androidx.core.view.NestedScrollingParent2
    public boolean onStartNestedScroll(View child, View target, int nestedScrollAxes, int type) {
        if ((nestedScrollAxes & 2) != 0) {
            return true;
        }
        return false;
    }

    public final void setActivity(Activity activity) {
        this.activity = activity;
    }

    public final void setTabLayout(View mTabLayout) {
        this.tabLayout = mTabLayout;
    }

    public final void setTopView(View mTopView) {
        this.topView = mTopView;
    }

    public final void setViewPager(View mViewPager) {
        this.viewPager = mViewPager;
    }

    public ECNestedScrollingParent2LayoutImpl(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ ECNestedScrollingParent2LayoutImpl(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    public ECNestedScrollingParent2LayoutImpl(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        setOrientation(1);
    }

    @Override // com.tencent.ecommerce.biz.productcenter.ui.view.ECNestedScrollingParent2Layout, androidx.core.view.NestedScrollingParent2
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
        super.scrollTo(x16, y16);
    }
}
