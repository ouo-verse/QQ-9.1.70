package com.tencent.richframework.widget.refresh.layout.util;

import android.content.res.Resources;
import android.graphics.PointF;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.webkit.WebView;
import android.widget.AbsListView;
import android.widget.ScrollView;
import androidx.annotation.NonNull;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.ScrollingView;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.tencent.mobileqq.R;
import com.tencent.richframework.widget.refresh.layout.api.IRefreshComponent;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;

/* compiled from: P */
/* loaded from: classes25.dex */
public class SmartUtil implements Interpolator {
    public static int INTERPOLATOR_DECELERATE = 1;
    public static int INTERPOLATOR_VISCOUS_FLUID;
    private static final float VISCOUS_FLUID_NORMALIZE;
    private static final float VISCOUS_FLUID_OFFSET;
    private static float density = Resources.getSystem().getDisplayMetrics().density;
    private int type;

    static {
        float viscousFluid = 1.0f / viscousFluid(1.0f);
        VISCOUS_FLUID_NORMALIZE = viscousFluid;
        VISCOUS_FLUID_OFFSET = 1.0f - (viscousFluid * viscousFluid(1.0f));
    }

    public SmartUtil(int i3) {
        this.type = i3;
    }

    public static boolean canLoadMore(@NonNull View view, PointF pointF, boolean z16) {
        if (view.canScrollVertically(1) && view.getVisibility() == 0) {
            return false;
        }
        if ((view instanceof ViewGroup) && pointF != null && !isScrollableView(view)) {
            ViewGroup viewGroup = (ViewGroup) view;
            PointF pointF2 = new PointF();
            for (int childCount = viewGroup.getChildCount(); childCount > 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount - 1);
                if (isTransformedTouchPointInView(viewGroup, childAt, pointF.x, pointF.y, pointF2)) {
                    Object tag = childAt.getTag(R.id.f87754v8);
                    if (QCircleDaTongConstant.ElementParamValue.FIXED.equals(tag) || "fixed-top".equals(tag)) {
                        return false;
                    }
                    pointF.offset(pointF2.x, pointF2.y);
                    boolean canLoadMore = canLoadMore(childAt, pointF, z16);
                    pointF.offset(-pointF2.x, -pointF2.y);
                    return canLoadMore;
                }
            }
        }
        if (z16 || view.canScrollVertically(-1)) {
            return true;
        }
        return false;
    }

    public static boolean canRefresh(@NonNull View view, PointF pointF) {
        if (view.canScrollVertically(-1) && view.getVisibility() == 0) {
            return false;
        }
        if ((view instanceof ViewGroup) && pointF != null) {
            ViewGroup viewGroup = (ViewGroup) view;
            PointF pointF2 = new PointF();
            for (int childCount = viewGroup.getChildCount(); childCount > 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount - 1);
                if (isTransformedTouchPointInView(viewGroup, childAt, pointF.x, pointF.y, pointF2)) {
                    Object tag = childAt.getTag(R.id.f87754v8);
                    if (QCircleDaTongConstant.ElementParamValue.FIXED.equals(tag) || "fixed-bottom".equals(tag)) {
                        return false;
                    }
                    pointF.offset(pointF2.x, pointF2.y);
                    boolean canRefresh = canRefresh(childAt, pointF);
                    pointF.offset(-pointF2.x, -pointF2.y);
                    return canRefresh;
                }
            }
            return true;
        }
        return true;
    }

    public static int dp2px(float f16) {
        return (int) ((f16 * density) + 0.5f);
    }

    public static void fling(View view, int i3) {
        if (view instanceof ScrollView) {
            ((ScrollView) view).fling(i3);
            return;
        }
        if (view instanceof AbsListView) {
            ((AbsListView) view).fling(i3);
            return;
        }
        if (view instanceof WebView) {
            ((WebView) view).flingScroll(0, i3);
        } else if (view instanceof NestedScrollView) {
            ((NestedScrollView) view).fling(i3);
        } else if (view instanceof RecyclerView) {
            ((RecyclerView) view).fling(0, i3);
        }
    }

    public static boolean isContentView(View view) {
        if (view instanceof IRefreshComponent) {
            return false;
        }
        if (!isScrollableView(view) && !(view instanceof ViewPager) && !(view instanceof NestedScrollingParent)) {
            return false;
        }
        return true;
    }

    public static boolean isScrollableView(View view) {
        if (view instanceof IRefreshComponent) {
            return false;
        }
        if (!(view instanceof AbsListView) && !(view instanceof ScrollView) && !(view instanceof ScrollingView) && !(view instanceof WebView) && !(view instanceof NestedScrollingChild)) {
            return false;
        }
        return true;
    }

    public static boolean isTransformedTouchPointInView(@NonNull View view, @NonNull View view2, float f16, float f17, PointF pointF) {
        boolean z16;
        if (view2.getVisibility() != 0) {
            return false;
        }
        float[] fArr = {f16, f17};
        fArr[0] = (view.getScrollX() - view2.getLeft()) + f16;
        float scrollY = fArr[1] + (view.getScrollY() - view2.getTop());
        fArr[1] = scrollY;
        float f18 = fArr[0];
        if (f18 >= 0.0f && scrollY >= 0.0f && f18 < view2.getWidth() && fArr[1] < view2.getHeight()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && pointF != null) {
            pointF.set(fArr[0] - f16, fArr[1] - f17);
        }
        return z16;
    }

    public static int measureViewHeight(View view) {
        int makeMeasureSpec;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-1, -2);
        }
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(0, 0, layoutParams.width);
        int i3 = layoutParams.height;
        if (i3 > 0) {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i3, 1073741824);
        } else {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        }
        view.measure(childMeasureSpec, makeMeasureSpec);
        return view.getMeasuredHeight();
    }

    public static float px2dp(int i3) {
        return i3 / density;
    }

    public static void scrollListBy(@NonNull AbsListView absListView, int i3) {
        absListView.scrollListBy(i3);
    }

    private static float viscousFluid(float f16) {
        float f17 = f16 * 8.0f;
        if (f17 < 1.0f) {
            return f17 - (1.0f - ((float) Math.exp(-f17)));
        }
        return 0.36787945f + ((1.0f - ((float) Math.exp(1.0f - f17))) * 0.63212055f);
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f16) {
        if (this.type == INTERPOLATOR_DECELERATE) {
            float f17 = 1.0f - f16;
            return 1.0f - (f17 * f17);
        }
        float viscousFluid = VISCOUS_FLUID_NORMALIZE * viscousFluid(f16);
        if (viscousFluid > 0.0f) {
            return viscousFluid + VISCOUS_FLUID_OFFSET;
        }
        return viscousFluid;
    }
}
