package com.tencent.mobileqq.activity.aio.intimate.flingappbar;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.math.MathUtils;
import androidx.core.util.ObjectsCompat;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.shape.d;
import com.tencent.mobileqq.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes10.dex */
public class FlingAppBarLayout extends LinearLayout implements CoordinatorLayout.AttachedBehavior {
    private static final int G = 2131953241;

    @Nullable
    private WindowInsetsCompat C;
    private List<b> D;
    private int[] E;

    @Nullable
    private Drawable F;

    /* renamed from: d, reason: collision with root package name */
    private int f178927d;

    /* renamed from: e, reason: collision with root package name */
    private int f178928e;

    /* renamed from: f, reason: collision with root package name */
    private int f178929f;

    /* renamed from: h, reason: collision with root package name */
    private int f178930h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f178931i;

    /* renamed from: m, reason: collision with root package name */
    private int f178932m;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class Behavior extends BaseBehavior<FlingAppBarLayout> {
        public Behavior() {
        }

        @Override // com.tencent.mobileqq.activity.aio.intimate.flingappbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ int getTopAndBottomOffset() {
            return super.getTopAndBottomOffset();
        }

        @Override // com.tencent.mobileqq.activity.aio.intimate.flingappbar.FlingAppBarLayout.BaseBehavior
        /* renamed from: o */
        public /* bridge */ /* synthetic */ boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull FlingAppBarLayout flingAppBarLayout, int i3) {
            return super.onLayoutChild(coordinatorLayout, flingAppBarLayout, i3);
        }

        @Override // com.tencent.mobileqq.activity.aio.intimate.flingappbar.HeaderBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onInterceptTouchEvent(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull MotionEvent motionEvent) {
            return super.onInterceptTouchEvent(coordinatorLayout, view, motionEvent);
        }

        @Override // com.tencent.mobileqq.activity.aio.intimate.flingappbar.HeaderBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onTouchEvent(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull MotionEvent motionEvent) {
            return super.onTouchEvent(coordinatorLayout, view, motionEvent);
        }

        @Override // com.tencent.mobileqq.activity.aio.intimate.flingappbar.FlingAppBarLayout.BaseBehavior
        /* renamed from: p */
        public /* bridge */ /* synthetic */ boolean onMeasureChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull FlingAppBarLayout flingAppBarLayout, int i3, int i16, int i17, int i18) {
            return super.onMeasureChild(coordinatorLayout, flingAppBarLayout, i3, i16, i17, i18);
        }

        @Override // com.tencent.mobileqq.activity.aio.intimate.flingappbar.FlingAppBarLayout.BaseBehavior
        /* renamed from: q */
        public /* bridge */ /* synthetic */ void onNestedPreScroll(CoordinatorLayout coordinatorLayout, @NonNull FlingAppBarLayout flingAppBarLayout, View view, int i3, int i16, int[] iArr, int i17) {
            super.onNestedPreScroll(coordinatorLayout, flingAppBarLayout, view, i3, i16, iArr, i17);
        }

        @Override // com.tencent.mobileqq.activity.aio.intimate.flingappbar.FlingAppBarLayout.BaseBehavior
        /* renamed from: r */
        public /* bridge */ /* synthetic */ void onNestedScroll(CoordinatorLayout coordinatorLayout, @NonNull FlingAppBarLayout flingAppBarLayout, View view, int i3, int i16, int i17, int i18, int i19, int[] iArr) {
            super.onNestedScroll(coordinatorLayout, flingAppBarLayout, view, i3, i16, i17, i18, i19, iArr);
        }

        @Override // com.tencent.mobileqq.activity.aio.intimate.flingappbar.FlingAppBarLayout.BaseBehavior
        /* renamed from: s */
        public /* bridge */ /* synthetic */ void onRestoreInstanceState(@NonNull CoordinatorLayout coordinatorLayout, @NonNull FlingAppBarLayout flingAppBarLayout, Parcelable parcelable) {
            super.onRestoreInstanceState(coordinatorLayout, flingAppBarLayout, parcelable);
        }

        @Override // com.tencent.mobileqq.activity.aio.intimate.flingappbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ boolean setTopAndBottomOffset(int i3) {
            return super.setTopAndBottomOffset(i3);
        }

        @Override // com.tencent.mobileqq.activity.aio.intimate.flingappbar.FlingAppBarLayout.BaseBehavior
        /* renamed from: t */
        public /* bridge */ /* synthetic */ Parcelable onSaveInstanceState(@NonNull CoordinatorLayout coordinatorLayout, @NonNull FlingAppBarLayout flingAppBarLayout) {
            return super.onSaveInstanceState(coordinatorLayout, flingAppBarLayout);
        }

        @Override // com.tencent.mobileqq.activity.aio.intimate.flingappbar.FlingAppBarLayout.BaseBehavior
        /* renamed from: u */
        public /* bridge */ /* synthetic */ boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull FlingAppBarLayout flingAppBarLayout, @NonNull View view, View view2, int i3, int i16) {
            return super.onStartNestedScroll(coordinatorLayout, flingAppBarLayout, view, view2, i3, i16);
        }

        @Override // com.tencent.mobileqq.activity.aio.intimate.flingappbar.FlingAppBarLayout.BaseBehavior
        /* renamed from: v */
        public /* bridge */ /* synthetic */ void onStopNestedScroll(CoordinatorLayout coordinatorLayout, @NonNull FlingAppBarLayout flingAppBarLayout, View view, int i3) {
            super.onStopNestedScroll(coordinatorLayout, flingAppBarLayout, view, i3);
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class ScrollingViewBehavior extends HeaderScrollingViewBehavior {
        public ScrollingViewBehavior() {
        }

        private static int c(@NonNull FlingAppBarLayout flingAppBarLayout) {
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) flingAppBarLayout.getLayoutParams()).getBehavior();
            if (behavior instanceof BaseBehavior) {
                return ((BaseBehavior) behavior).getTopBottomOffsetForScrollingSibling();
            }
            return 0;
        }

        private void offsetChildAsNeeded(@NonNull View view, @NonNull View view2) {
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) view2.getLayoutParams()).getBehavior();
            if (behavior instanceof BaseBehavior) {
                ViewCompat.offsetTopAndBottom(view, (((view2.getBottom() - view.getTop()) + ((BaseBehavior) behavior).f178934r) + getVerticalLayoutGap()) - getOverlapPixelsForOffset(view2));
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.tencent.mobileqq.activity.aio.intimate.flingappbar.HeaderScrollingViewBehavior
        @Nullable
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public FlingAppBarLayout findFirstDependency(@NonNull List<View> list) {
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                View view = list.get(i3);
                if (view instanceof FlingAppBarLayout) {
                    return (FlingAppBarLayout) view;
                }
            }
            return null;
        }

        @Override // com.tencent.mobileqq.activity.aio.intimate.flingappbar.HeaderScrollingViewBehavior
        float getOverlapRatioForOffset(View view) {
            int i3;
            if (view instanceof FlingAppBarLayout) {
                FlingAppBarLayout flingAppBarLayout = (FlingAppBarLayout) view;
                int j3 = flingAppBarLayout.j();
                int f16 = flingAppBarLayout.f();
                int c16 = c(flingAppBarLayout);
                if ((f16 == 0 || j3 + c16 > f16) && (i3 = j3 - f16) != 0) {
                    return (c16 / i3) + 1.0f;
                }
            }
            return 0.0f;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.tencent.mobileqq.activity.aio.intimate.flingappbar.HeaderScrollingViewBehavior
        public int getScrollRange(View view) {
            if (view instanceof FlingAppBarLayout) {
                return ((FlingAppBarLayout) view).j();
            }
            return super.getScrollRange(view);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return view2 instanceof FlingAppBarLayout;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onDependentViewChanged(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull View view2) {
            offsetChildAsNeeded(view, view2);
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public void onDependentViewRemoved(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull View view2) {
            if (view2 instanceof FlingAppBarLayout) {
                ViewCompat.removeAccessibilityAction(coordinatorLayout, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD.getId());
                ViewCompat.removeAccessibilityAction(coordinatorLayout, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD.getId());
            }
        }

        @Override // com.tencent.mobileqq.activity.aio.intimate.flingappbar.ViewOffsetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, int i3) {
            return super.onLayoutChild(coordinatorLayout, view, i3);
        }

        @Override // com.tencent.mobileqq.activity.aio.intimate.flingappbar.HeaderScrollingViewBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onMeasureChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, int i3, int i16, int i17, int i18) {
            return super.onMeasureChild(coordinatorLayout, view, i3, i16, i17, i18);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onRequestChildRectangleOnScreen(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull Rect rect, boolean z16) {
            FlingAppBarLayout findFirstDependency = findFirstDependency(coordinatorLayout.getDependencies(view));
            if (findFirstDependency != null) {
                rect.offset(view.getLeft(), view.getTop());
                Rect rect2 = this.f178967j;
                rect2.set(0, 0, coordinatorLayout.getWidth(), coordinatorLayout.getHeight());
                if (!rect2.contains(rect)) {
                    findFirstDependency.setExpanded(false, !z16);
                    return true;
                }
            }
            return false;
        }

        public ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, w0.a.f443900h7);
            setOverlayTop(obtainStyledAttributes.getDimensionPixelSize(w0.a.f443911i7, 0));
            obtainStyledAttributes.recycle();
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a implements OnApplyWindowInsetsListener {
        a() {
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            return FlingAppBarLayout.this.p(windowInsetsCompat);
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public interface b<T extends FlingAppBarLayout> {
        void a(T t16, int i3);
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public interface c extends b<FlingAppBarLayout> {
    }

    public FlingAppBarLayout(@NonNull Context context) {
        this(context, null);
    }

    private void n() {
        this.f178928e = -1;
        this.f178929f = -1;
        this.f178930h = -1;
    }

    private void t(boolean z16, boolean z17, boolean z18) {
        int i3;
        int i16;
        if (z16) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        int i17 = 0;
        if (z17) {
            i16 = 4;
        } else {
            i16 = 0;
        }
        int i18 = i3 | i16;
        if (z18) {
            i17 = 8;
        }
        this.f178932m = i18 | i17;
        requestLayout();
    }

    private boolean u() {
        if (this.F != null && i() > 0) {
            return true;
        }
        return false;
    }

    private boolean v() {
        if (getChildCount() <= 0) {
            return false;
        }
        View childAt = getChildAt(0);
        if (childAt.getVisibility() == 8 || ViewCompat.getFitsSystemWindows(childAt)) {
            return false;
        }
        return true;
    }

    private void w() {
        setWillNotDraw(!u());
    }

    public void a(@Nullable b bVar) {
        if (this.D == null) {
            this.D = new ArrayList();
        }
        if (bVar != null && !this.D.contains(bVar)) {
            this.D.add(bVar);
        }
    }

    public void b(c cVar) {
        a(cVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -2);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.View
    public void draw(@NonNull Canvas canvas) {
        super.draw(canvas);
        if (u()) {
            int save = canvas.save();
            canvas.translate(0.0f, -this.f178927d);
            this.F.draw(canvas);
            canvas.restoreToCount(save);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.F;
        if (drawable != null && drawable.isStateful() && drawable.setState(drawableState)) {
            invalidateDrawable(drawable);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            return new LayoutParams((LinearLayout.LayoutParams) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    int f() {
        int i3;
        int minimumHeight;
        int i16 = this.f178929f;
        if (i16 != -1) {
            return i16;
        }
        int i17 = 0;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i18 = layoutParams.f178955a;
            if ((i18 & 5) == 5) {
                int i19 = ((LinearLayout.LayoutParams) layoutParams).topMargin + ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                if ((i18 & 8) != 0) {
                    minimumHeight = ViewCompat.getMinimumHeight(childAt);
                } else if ((i18 & 2) != 0) {
                    minimumHeight = measuredHeight - ViewCompat.getMinimumHeight(childAt);
                } else {
                    i3 = i19 + measuredHeight;
                    if (childCount == 0 && ViewCompat.getFitsSystemWindows(childAt)) {
                        i3 = Math.min(i3, measuredHeight - i());
                    }
                    i17 += i3;
                }
                i3 = i19 + minimumHeight;
                if (childCount == 0) {
                    i3 = Math.min(i3, measuredHeight - i());
                }
                i17 += i3;
            } else if (i17 > 0) {
                break;
            }
        }
        int max = Math.max(0, i17);
        this.f178929f = max;
        return max;
    }

    int g() {
        int i3 = this.f178930h;
        if (i3 != -1) {
            return i3;
        }
        int childCount = getChildCount();
        int i16 = 0;
        int i17 = 0;
        while (true) {
            if (i16 >= childCount) {
                break;
            }
            View childAt = getChildAt(i16);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight() + ((LinearLayout.LayoutParams) layoutParams).topMargin + ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
            int i18 = layoutParams.f178955a;
            if ((i18 & 1) == 0) {
                break;
            }
            i17 += measuredHeight;
            if ((i18 & 2) != 0) {
                i17 -= ViewCompat.getMinimumHeight(childAt);
                break;
            }
            i16++;
        }
        int max = Math.max(0, i17);
        this.f178930h = max;
        return max;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior
    @NonNull
    public CoordinatorLayout.Behavior<FlingAppBarLayout> getBehavior() {
        return new Behavior();
    }

    int h() {
        return this.f178932m;
    }

    @VisibleForTesting
    final int i() {
        WindowInsetsCompat windowInsetsCompat = this.C;
        if (windowInsetsCompat != null) {
            return windowInsetsCompat.getSystemWindowInsetTop();
        }
        return 0;
    }

    public final int j() {
        int i3 = this.f178928e;
        if (i3 != -1) {
            return i3;
        }
        int childCount = getChildCount();
        int i16 = 0;
        int i17 = 0;
        while (true) {
            if (i16 >= childCount) {
                break;
            }
            View childAt = getChildAt(i16);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i18 = layoutParams.f178955a;
            if ((i18 & 1) == 0) {
                break;
            }
            i17 += measuredHeight + ((LinearLayout.LayoutParams) layoutParams).topMargin + ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
            if (i16 == 0 && ViewCompat.getFitsSystemWindows(childAt)) {
                i17 -= i();
            }
            if ((i18 & 2) != 0) {
                i17 -= ViewCompat.getMinimumHeight(childAt);
                break;
            }
            i16++;
        }
        int max = Math.max(0, i17);
        this.f178928e = max;
        return max;
    }

    int k() {
        if (getLayoutParams() instanceof CoordinatorLayout.LayoutParams) {
            CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) getLayoutParams();
            if (layoutParams.getBehavior() instanceof Behavior) {
                return Math.min(((Behavior) layoutParams.getBehavior()).getScrollRangeForDragFling(this), j());
            }
        }
        return j();
    }

    boolean l() {
        return this.f178931i;
    }

    boolean m() {
        if (j() != 0) {
            return true;
        }
        return false;
    }

    void o(int i3) {
        this.f178927d = i3;
        if (!willNotDraw()) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
        List<b> list = this.D;
        if (list != null) {
            int size = list.size();
            for (int i16 = 0; i16 < size; i16++) {
                b bVar = this.D.get(i16);
                if (bVar != null) {
                    bVar.a(this, i3);
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        d.e(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected int[] onCreateDrawableState(int i3) {
        if (this.E == null) {
            this.E = new int[4];
        }
        int[] iArr = this.E;
        int[] onCreateDrawableState = super.onCreateDrawableState(i3 + iArr.length);
        iArr[0] = -2130971406;
        iArr[1] = -2130971407;
        iArr[2] = -2130971404;
        iArr[3] = -2130971403;
        return View.mergeDrawableStates(onCreateDrawableState, iArr);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
        if (ViewCompat.getFitsSystemWindows(this) && v()) {
            int i19 = i();
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                ViewCompat.offsetTopAndBottom(getChildAt(childCount), i19);
            }
        }
        n();
        this.f178931i = false;
        int childCount2 = getChildCount();
        int i26 = 0;
        while (true) {
            if (i26 >= childCount2) {
                break;
            }
            if (((LayoutParams) getChildAt(i26).getLayoutParams()).b() != null) {
                this.f178931i = true;
                break;
            }
            i26++;
        }
        Drawable drawable = this.F;
        if (drawable != null) {
            drawable.setBounds(0, 0, getWidth(), i());
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
        int mode = View.MeasureSpec.getMode(i16);
        if (mode != 1073741824 && ViewCompat.getFitsSystemWindows(this) && v()) {
            int measuredHeight = getMeasuredHeight();
            if (mode != Integer.MIN_VALUE) {
                if (mode == 0) {
                    measuredHeight += i();
                }
            } else {
                measuredHeight = MathUtils.clamp(getMeasuredHeight() + i(), 0, View.MeasureSpec.getSize(i16));
            }
            setMeasuredDimension(getMeasuredWidth(), measuredHeight);
        }
        n();
    }

    WindowInsetsCompat p(WindowInsetsCompat windowInsetsCompat) {
        WindowInsetsCompat windowInsetsCompat2;
        if (ViewCompat.getFitsSystemWindows(this)) {
            windowInsetsCompat2 = windowInsetsCompat;
        } else {
            windowInsetsCompat2 = null;
        }
        if (!ObjectsCompat.equals(this.C, windowInsetsCompat2)) {
            this.C = windowInsetsCompat2;
            w();
            requestLayout();
        }
        return windowInsetsCompat;
    }

    public void q(@Nullable b bVar) {
        List<b> list = this.D;
        if (list != null && bVar != null) {
            list.remove(bVar);
        }
    }

    public void r(c cVar) {
        q(cVar);
    }

    void s() {
        this.f178932m = 0;
    }

    @Override // android.view.View
    @RequiresApi(21)
    public void setElevation(float f16) {
        super.setElevation(f16);
        d.d(this, f16);
    }

    public void setExpanded(boolean z16) {
        setExpanded(z16, ViewCompat.isLaidOut(this));
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int i3) {
        if (i3 == 1) {
            super.setOrientation(i3);
            return;
        }
        throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
    }

    @Override // android.view.View
    public void setVisibility(int i3) {
        boolean z16;
        super.setVisibility(i3);
        if (i3 == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        Drawable drawable = this.F;
        if (drawable != null) {
            drawable.setVisible(z16, false);
        }
    }

    @Override // android.view.View
    protected boolean verifyDrawable(@NonNull Drawable drawable) {
        if (!super.verifyDrawable(drawable) && drawable != this.F) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class BaseBehavior<T extends FlingAppBarLayout> extends HeaderBehavior<T> {

        /* renamed from: q, reason: collision with root package name */
        private int f178933q;

        /* renamed from: r, reason: collision with root package name */
        private int f178934r;

        /* renamed from: s, reason: collision with root package name */
        private int f178935s;

        /* renamed from: t, reason: collision with root package name */
        private ValueAnimator f178936t;

        /* renamed from: u, reason: collision with root package name */
        private int f178937u;

        /* renamed from: v, reason: collision with root package name */
        private boolean f178938v;

        /* renamed from: w, reason: collision with root package name */
        private float f178939w;

        /* renamed from: x, reason: collision with root package name */
        @Nullable
        private WeakReference<View> f178940x;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes10.dex */
        public class a implements ValueAnimator.AnimatorUpdateListener {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ CoordinatorLayout f178944d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ FlingAppBarLayout f178945e;

            a(CoordinatorLayout coordinatorLayout, FlingAppBarLayout flingAppBarLayout) {
                this.f178944d = coordinatorLayout;
                this.f178945e = flingAppBarLayout;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
                BaseBehavior.this.setHeaderTopBottomOffset(this.f178944d, this.f178945e, ((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes10.dex */
        public class b implements AccessibilityViewCommand {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ CoordinatorLayout f178947a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ FlingAppBarLayout f178948b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ View f178949c;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ int f178950d;

            b(CoordinatorLayout coordinatorLayout, FlingAppBarLayout flingAppBarLayout, View view, int i3) {
                this.f178947a = coordinatorLayout;
                this.f178948b = flingAppBarLayout;
                this.f178949c = view;
                this.f178950d = i3;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // androidx.core.view.accessibility.AccessibilityViewCommand
            public boolean perform(@NonNull View view, @Nullable AccessibilityViewCommand.CommandArguments commandArguments) {
                BaseBehavior.this.onNestedPreScroll(this.f178947a, this.f178948b, this.f178949c, 0, this.f178950d, new int[]{0, 0}, 1);
                return true;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes10.dex */
        public class c implements AccessibilityViewCommand {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ FlingAppBarLayout f178952a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ boolean f178953b;

            c(FlingAppBarLayout flingAppBarLayout, boolean z16) {
                this.f178952a = flingAppBarLayout;
                this.f178953b = z16;
            }

            @Override // androidx.core.view.accessibility.AccessibilityViewCommand
            public boolean perform(@NonNull View view, @Nullable AccessibilityViewCommand.CommandArguments commandArguments) {
                this.f178952a.setExpanded(this.f178953b);
                return true;
            }
        }

        public BaseBehavior() {
            this.f178937u = -1;
        }

        private void c(CoordinatorLayout coordinatorLayout, @NonNull T t16, @NonNull View view) {
            if (getTopBottomOffsetForScrollingSibling() != (-t16.j()) && view.canScrollVertically(1)) {
                d(coordinatorLayout, t16, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD, false);
            }
            if (getTopBottomOffsetForScrollingSibling() != 0) {
                if (view.canScrollVertically(-1)) {
                    int i3 = -t16.f();
                    if (i3 != 0) {
                        ViewCompat.replaceAccessibilityAction(coordinatorLayout, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD, null, new b(coordinatorLayout, t16, view, i3));
                        return;
                    }
                    return;
                }
                d(coordinatorLayout, t16, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD, true);
            }
        }

        private static boolean checkFlag(int i3, int i16) {
            if ((i3 & i16) == i16) {
                return true;
            }
            return false;
        }

        private void d(CoordinatorLayout coordinatorLayout, @NonNull T t16, @NonNull AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat, boolean z16) {
            ViewCompat.replaceAccessibilityAction(coordinatorLayout, accessibilityActionCompat, null, new c(t16, z16));
        }

        private void e(CoordinatorLayout coordinatorLayout, @NonNull T t16, int i3, float f16) {
            int height;
            int abs = Math.abs(getTopBottomOffsetForScrollingSibling() - i3);
            float abs2 = Math.abs(f16);
            if (abs2 > 0.0f) {
                height = Math.round((abs / abs2) * 1000.0f) * 3;
            } else {
                height = (int) (((abs / t16.getHeight()) + 1.0f) * 150.0f);
            }
            f(coordinatorLayout, t16, i3, height);
        }

        private void f(CoordinatorLayout coordinatorLayout, T t16, int i3, int i16) {
            int topBottomOffsetForScrollingSibling = getTopBottomOffsetForScrollingSibling();
            if (topBottomOffsetForScrollingSibling == i3) {
                ValueAnimator valueAnimator = this.f178936t;
                if (valueAnimator != null && valueAnimator.isRunning()) {
                    this.f178936t.cancel();
                    return;
                }
                return;
            }
            ValueAnimator valueAnimator2 = this.f178936t;
            if (valueAnimator2 == null) {
                ValueAnimator valueAnimator3 = new ValueAnimator();
                this.f178936t = valueAnimator3;
                valueAnimator3.setInterpolator(new DecelerateInterpolator());
                this.f178936t.addUpdateListener(new a(coordinatorLayout, t16));
            } else {
                valueAnimator2.cancel();
            }
            this.f178936t.setDuration(Math.min(i16, 600));
            this.f178936t.setIntValues(topBottomOffsetForScrollingSibling, i3);
            this.f178936t.start();
        }

        @Nullable
        private View findFirstScrollingChild(@NonNull CoordinatorLayout coordinatorLayout) {
            int childCount = coordinatorLayout.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = coordinatorLayout.getChildAt(i3);
                if ((childAt instanceof NestedScrollingChild) || (childAt instanceof ListView) || (childAt instanceof ScrollView)) {
                    return childAt;
                }
            }
            return null;
        }

        private boolean h(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t16, @NonNull View view) {
            if (t16.m() && coordinatorLayout.getHeight() - view.getHeight() <= t16.getHeight()) {
                return true;
            }
            return false;
        }

        @Nullable
        private static View i(@NonNull FlingAppBarLayout flingAppBarLayout, int i3) {
            int abs = Math.abs(i3);
            int childCount = flingAppBarLayout.getChildCount();
            for (int i16 = 0; i16 < childCount; i16++) {
                View childAt = flingAppBarLayout.getChildAt(i16);
                if (abs >= childAt.getTop() && abs <= childAt.getBottom()) {
                    return childAt;
                }
            }
            return null;
        }

        private int j(@NonNull T t16, int i3) {
            int childCount = t16.getChildCount();
            for (int i16 = 0; i16 < childCount; i16++) {
                View childAt = t16.getChildAt(i16);
                int top = childAt.getTop();
                int bottom = childAt.getBottom();
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (checkFlag(layoutParams.a(), 32)) {
                    top -= ((LinearLayout.LayoutParams) layoutParams).topMargin;
                    bottom += ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                }
                int i17 = -i3;
                if (top <= i17 && bottom >= i17) {
                    return i16;
                }
            }
            return -1;
        }

        private int m(@NonNull T t16, int i3) {
            int abs = Math.abs(i3);
            int childCount = t16.getChildCount();
            int i16 = 0;
            int i17 = 0;
            while (true) {
                if (i17 >= childCount) {
                    break;
                }
                View childAt = t16.getChildAt(i17);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                Interpolator b16 = layoutParams.b();
                if (abs >= childAt.getTop() && abs <= childAt.getBottom()) {
                    if (b16 != null) {
                        int a16 = layoutParams.a();
                        if ((a16 & 1) != 0) {
                            i16 = 0 + childAt.getHeight() + ((LinearLayout.LayoutParams) layoutParams).topMargin + ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                            if ((a16 & 2) != 0) {
                                i16 -= ViewCompat.getMinimumHeight(childAt);
                            }
                        }
                        if (ViewCompat.getFitsSystemWindows(childAt)) {
                            i16 -= t16.i();
                        }
                        if (i16 > 0) {
                            float f16 = i16;
                            return Integer.signum(i3) * (childAt.getTop() + Math.round(f16 * b16.getInterpolation((abs - childAt.getTop()) / f16)));
                        }
                    }
                } else {
                    i17++;
                }
            }
            return i3;
        }

        private void x(CoordinatorLayout coordinatorLayout, @NonNull T t16) {
            int topBottomOffsetForScrollingSibling = getTopBottomOffsetForScrollingSibling();
            int j3 = j(t16, topBottomOffsetForScrollingSibling);
            if (j3 >= 0) {
                View childAt = t16.getChildAt(j3);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int a16 = layoutParams.a();
                if ((a16 & 17) == 17) {
                    int i3 = -childAt.getTop();
                    int i16 = -childAt.getBottom();
                    if (j3 == t16.getChildCount() - 1) {
                        i16 += t16.i();
                    }
                    if (checkFlag(a16, 2)) {
                        i16 += ViewCompat.getMinimumHeight(childAt);
                    } else if (checkFlag(a16, 5)) {
                        int minimumHeight = ViewCompat.getMinimumHeight(childAt) + i16;
                        if (topBottomOffsetForScrollingSibling < minimumHeight) {
                            i3 = minimumHeight;
                        } else {
                            i16 = minimumHeight;
                        }
                    }
                    if (checkFlag(a16, 32)) {
                        i3 += ((LinearLayout.LayoutParams) layoutParams).topMargin;
                        i16 -= ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                    }
                    if (topBottomOffsetForScrollingSibling < (i16 + i3) / 2) {
                        i3 = i16;
                    }
                    e(coordinatorLayout, t16, MathUtils.clamp(i3, -t16.j(), 0), 0.0f);
                }
            }
        }

        private void y(CoordinatorLayout coordinatorLayout, @NonNull T t16) {
            ViewCompat.removeAccessibilityAction(coordinatorLayout, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD.getId());
            ViewCompat.removeAccessibilityAction(coordinatorLayout, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD.getId());
            View findFirstScrollingChild = findFirstScrollingChild(coordinatorLayout);
            if (findFirstScrollingChild == null || t16.j() == 0 || !(((CoordinatorLayout.LayoutParams) findFirstScrollingChild.getLayoutParams()).getBehavior() instanceof ScrollingViewBehavior)) {
                return;
            }
            c(coordinatorLayout, t16, findFirstScrollingChild);
        }

        private void z(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t16, int i3, int i16, boolean z16) {
            if (i(t16, i3) != null && z16) {
                t16.jumpDrawablesToCurrentState();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.tencent.mobileqq.activity.aio.intimate.flingappbar.HeaderBehavior
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public boolean canDragView(T t16) {
            WeakReference<View> weakReference = this.f178940x;
            if (weakReference == null) {
                return true;
            }
            View view = weakReference.get();
            if (view != null && view.isShown() && !view.canScrollVertically(-1)) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.mobileqq.activity.aio.intimate.flingappbar.HeaderBehavior
        int getTopBottomOffsetForScrollingSibling() {
            return getTopAndBottomOffset() + this.f178934r;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.tencent.mobileqq.activity.aio.intimate.flingappbar.HeaderBehavior
        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public int getMaxDragOffset(@NonNull T t16) {
            return -t16.g();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.tencent.mobileqq.activity.aio.intimate.flingappbar.HeaderBehavior
        /* renamed from: l, reason: merged with bridge method [inline-methods] */
        public int getScrollRangeForDragFling(@NonNull T t16) {
            return t16.j();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.tencent.mobileqq.activity.aio.intimate.flingappbar.HeaderBehavior
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public void onFlingFinished(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t16) {
            x(coordinatorLayout, t16);
        }

        @Override // com.tencent.mobileqq.activity.aio.intimate.flingappbar.ViewOffsetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* renamed from: o, reason: merged with bridge method [inline-methods] */
        public boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t16, int i3) {
            boolean z16;
            int round;
            boolean onLayoutChild = super.onLayoutChild(coordinatorLayout, t16, i3);
            int h16 = t16.h();
            int i16 = this.f178937u;
            if (i16 >= 0 && (h16 & 8) == 0) {
                View childAt = t16.getChildAt(i16);
                int i17 = -childAt.getBottom();
                if (this.f178938v) {
                    round = ViewCompat.getMinimumHeight(childAt) + t16.i();
                } else {
                    round = Math.round(childAt.getHeight() * this.f178939w);
                }
                setHeaderTopBottomOffset(coordinatorLayout, t16, i17 + round);
            } else if (h16 != 0) {
                if ((h16 & 4) != 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if ((h16 & 2) != 0) {
                    int i18 = -t16.k();
                    if (z16) {
                        e(coordinatorLayout, t16, i18, 0.0f);
                    } else {
                        setHeaderTopBottomOffset(coordinatorLayout, t16, i18);
                    }
                } else if ((h16 & 1) != 0) {
                    if (z16) {
                        e(coordinatorLayout, t16, 0, 0.0f);
                    } else {
                        setHeaderTopBottomOffset(coordinatorLayout, t16, 0);
                    }
                }
            }
            t16.s();
            this.f178937u = -1;
            int topAndBottomOffset = getTopAndBottomOffset();
            if (topAndBottomOffset < (-t16.j())) {
                this.f178933q = topAndBottomOffset;
            }
            int i19 = this.f178933q;
            if (i19 < topAndBottomOffset) {
                topAndBottomOffset = i19;
            }
            if (i19 >= (-t16.j())) {
                this.f178933q = 0;
            }
            setTopAndBottomOffset(MathUtils.clamp(topAndBottomOffset, -t16.j(), 0));
            z(coordinatorLayout, t16, getTopAndBottomOffset(), 0, true);
            t16.o(getTopAndBottomOffset());
            y(coordinatorLayout, t16);
            return onLayoutChild;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* renamed from: p, reason: merged with bridge method [inline-methods] */
        public boolean onMeasureChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t16, int i3, int i16, int i17, int i18) {
            if (((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.LayoutParams) t16.getLayoutParams())).height == -2) {
                coordinatorLayout.onMeasureChild(t16, i3, i16, View.MeasureSpec.makeMeasureSpec(0, 0), i18);
                return true;
            }
            return super.onMeasureChild(coordinatorLayout, t16, i3, i16, i17, i18);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* renamed from: q, reason: merged with bridge method [inline-methods] */
        public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, @NonNull T t16, View view, int i3, int i16, int[] iArr, int i17) {
            int i18;
            int i19;
            if (i16 != 0) {
                if (i16 < 0) {
                    i18 = -t16.j();
                    i19 = t16.f() + i18;
                } else {
                    i18 = -t16.k();
                    i19 = 0;
                }
                int i26 = i18;
                int i27 = i19;
                if (i26 != i27) {
                    iArr[1] = scroll(coordinatorLayout, t16, i16, i26, i27);
                }
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* renamed from: r, reason: merged with bridge method [inline-methods] */
        public void onNestedScroll(CoordinatorLayout coordinatorLayout, @NonNull T t16, View view, int i3, int i16, int i17, int i18, int i19, int[] iArr) {
            if (i18 < 0) {
                iArr[1] = scroll(coordinatorLayout, t16, i18, -t16.g(), 0);
            }
            if (i18 == 0) {
                y(coordinatorLayout, t16);
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* renamed from: s, reason: merged with bridge method [inline-methods] */
        public void onRestoreInstanceState(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t16, Parcelable parcelable) {
            if (parcelable instanceof SavedState) {
                SavedState savedState = (SavedState) parcelable;
                super.onRestoreInstanceState(coordinatorLayout, t16, savedState.getSuperState());
                this.f178937u = savedState.f178941d;
                this.f178939w = savedState.f178942e;
                this.f178938v = savedState.f178943f;
                return;
            }
            super.onRestoreInstanceState(coordinatorLayout, t16, parcelable);
            this.f178937u = -1;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* renamed from: t, reason: merged with bridge method [inline-methods] */
        public Parcelable onSaveInstanceState(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t16) {
            Parcelable onSaveInstanceState = super.onSaveInstanceState(coordinatorLayout, t16);
            int topAndBottomOffset = getTopAndBottomOffset();
            int childCount = t16.getChildCount();
            boolean z16 = false;
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = t16.getChildAt(i3);
                int bottom = childAt.getBottom() + topAndBottomOffset;
                if (childAt.getTop() + topAndBottomOffset <= 0 && bottom >= 0) {
                    SavedState savedState = new SavedState(onSaveInstanceState);
                    savedState.f178941d = i3;
                    if (bottom == ViewCompat.getMinimumHeight(childAt) + t16.i()) {
                        z16 = true;
                    }
                    savedState.f178943f = z16;
                    savedState.f178942e = bottom / childAt.getHeight();
                    return savedState;
                }
            }
            return onSaveInstanceState;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* renamed from: u, reason: merged with bridge method [inline-methods] */
        public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t16, @NonNull View view, View view2, int i3, int i16) {
            boolean z16;
            ValueAnimator valueAnimator;
            if ((i3 & 2) != 0 && h(coordinatorLayout, t16, view)) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16 && (valueAnimator = this.f178936t) != null) {
                valueAnimator.cancel();
            }
            this.f178940x = null;
            this.f178935s = i16;
            return z16;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* renamed from: v, reason: merged with bridge method [inline-methods] */
        public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, @NonNull T t16, View view, int i3) {
            if (this.f178935s == 0 || i3 == 1) {
                x(coordinatorLayout, t16);
            }
            this.f178940x = new WeakReference<>(view);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.tencent.mobileqq.activity.aio.intimate.flingappbar.HeaderBehavior
        /* renamed from: w, reason: merged with bridge method [inline-methods] */
        public int setHeaderTopBottomOffset(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t16, int i3, int i16, int i17) {
            int i18;
            int i19;
            int topBottomOffsetForScrollingSibling = getTopBottomOffsetForScrollingSibling();
            int i26 = 0;
            if (i16 != 0 && topBottomOffsetForScrollingSibling >= i16 && topBottomOffsetForScrollingSibling <= i17) {
                int clamp = MathUtils.clamp(i3, i16, i17);
                if (topBottomOffsetForScrollingSibling != clamp) {
                    if (t16.l()) {
                        i18 = m(t16, clamp);
                    } else {
                        i18 = clamp;
                    }
                    boolean topAndBottomOffset = setTopAndBottomOffset(i18);
                    i26 = topBottomOffsetForScrollingSibling - clamp;
                    this.f178934r = clamp - i18;
                    if (!topAndBottomOffset && t16.l()) {
                        coordinatorLayout.dispatchDependentViewsChanged(t16);
                    }
                    t16.o(getTopAndBottomOffset());
                    if (clamp < topBottomOffsetForScrollingSibling) {
                        i19 = -1;
                    } else {
                        i19 = 1;
                    }
                    z(coordinatorLayout, t16, clamp, i19, false);
                }
            } else {
                this.f178934r = 0;
            }
            y(coordinatorLayout, t16);
            return i26;
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f178937u = -1;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* compiled from: P */
        /* loaded from: classes10.dex */
        public static class SavedState extends AbsSavedState {
            public static final Parcelable.Creator<SavedState> CREATOR = new a();

            /* renamed from: d, reason: collision with root package name */
            int f178941d;

            /* renamed from: e, reason: collision with root package name */
            float f178942e;

            /* renamed from: f, reason: collision with root package name */
            boolean f178943f;

            /* compiled from: P */
            /* loaded from: classes10.dex */
            class a implements Parcelable.ClassLoaderCreator<SavedState> {
                a() {
                }

                @Override // android.os.Parcelable.Creator
                @Nullable
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public SavedState createFromParcel(@NonNull Parcel parcel) {
                    return new SavedState(parcel, null);
                }

                @Override // android.os.Parcelable.ClassLoaderCreator
                @NonNull
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public SavedState createFromParcel(@NonNull Parcel parcel, ClassLoader classLoader) {
                    return new SavedState(parcel, classLoader);
                }

                @Override // android.os.Parcelable.Creator
                @NonNull
                /* renamed from: c, reason: merged with bridge method [inline-methods] */
                public SavedState[] newArray(int i3) {
                    return new SavedState[i3];
                }
            }

            public SavedState(@NonNull Parcel parcel, ClassLoader classLoader) {
                super(parcel, classLoader);
                this.f178941d = parcel.readInt();
                this.f178942e = parcel.readFloat();
                this.f178943f = parcel.readByte() != 0;
            }

            @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
            public void writeToParcel(@NonNull Parcel parcel, int i3) {
                super.writeToParcel(parcel, i3);
                parcel.writeInt(this.f178941d);
                parcel.writeFloat(this.f178942e);
                parcel.writeByte(this.f178943f ? (byte) 1 : (byte) 0);
            }

            public SavedState(Parcelable parcelable) {
                super(parcelable);
            }
        }
    }

    public FlingAppBarLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.f50081);
    }

    public void setExpanded(boolean z16, boolean z17) {
        t(z16, z17, true);
    }

    public FlingAppBarLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(k1.a.c(context, attributeSet, i3, G), attributeSet, i3);
        this.f178928e = -1;
        this.f178929f = -1;
        this.f178930h = -1;
        this.f178932m = 0;
        setOrientation(1);
        ViewCompat.setOnApplyWindowInsetsListener(this, new a());
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class LayoutParams extends LinearLayout.LayoutParams {

        /* renamed from: a, reason: collision with root package name */
        int f178955a;

        /* renamed from: b, reason: collision with root package name */
        Interpolator f178956b;

        /* compiled from: P */
        @Retention(RetentionPolicy.SOURCE)
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        /* loaded from: classes10.dex */
        public @interface ScrollFlags {
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f178955a = 1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, w0.a.f444042u);
            this.f178955a = obtainStyledAttributes.getInt(w0.a.f444065w, 0);
            int i3 = w0.a.f444076x;
            if (obtainStyledAttributes.hasValue(i3)) {
                this.f178956b = AnimationUtils.loadInterpolator(context, obtainStyledAttributes.getResourceId(i3, 0));
            }
            obtainStyledAttributes.recycle();
        }

        public int a() {
            return this.f178955a;
        }

        public Interpolator b() {
            return this.f178956b;
        }

        public LayoutParams(int i3, int i16) {
            super(i3, i16);
            this.f178955a = 1;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f178955a = 1;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f178955a = 1;
        }

        @RequiresApi(19)
        public LayoutParams(LinearLayout.LayoutParams layoutParams) {
            super(layoutParams);
            this.f178955a = 1;
        }
    }
}
