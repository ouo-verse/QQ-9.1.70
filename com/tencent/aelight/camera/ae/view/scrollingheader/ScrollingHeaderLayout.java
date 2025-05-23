package com.tencent.aelight.camera.ae.view.scrollingheader;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.math.MathUtils;
import androidx.core.util.ObjectsCompat;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import java.util.List;

/* compiled from: P */
/* loaded from: classes32.dex */
public class ScrollingHeaderLayout extends LinearLayout implements CoordinatorLayout.AttachedBehavior {

    /* renamed from: d, reason: collision with root package name */
    private int f65940d;

    /* renamed from: e, reason: collision with root package name */
    private int f65941e;

    /* renamed from: f, reason: collision with root package name */
    private int f65942f;

    /* renamed from: h, reason: collision with root package name */
    private WindowInsetsCompat f65943h;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class BaseBehavior<T extends ScrollingHeaderLayout> extends HeaderBehavior<T> {

        /* renamed from: q, reason: collision with root package name */
        private int f65944q;

        /* renamed from: r, reason: collision with root package name */
        private int f65945r;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes32.dex */
        public class a implements AccessibilityViewCommand {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ CoordinatorLayout f65946a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ ScrollingHeaderLayout f65947b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ View f65948c;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ int f65949d;

            a(CoordinatorLayout coordinatorLayout, ScrollingHeaderLayout scrollingHeaderLayout, View view, int i3) {
                this.f65946a = coordinatorLayout;
                this.f65947b = scrollingHeaderLayout;
                this.f65948c = view;
                this.f65949d = i3;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // androidx.core.view.accessibility.AccessibilityViewCommand
            public boolean perform(View view, AccessibilityViewCommand.CommandArguments commandArguments) {
                BaseBehavior.this.onNestedPreScroll(this.f65946a, this.f65947b, this.f65948c, 0, this.f65949d, new int[]{0, 0}, 1);
                return true;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes32.dex */
        public class b implements AccessibilityViewCommand {
            b() {
            }

            @Override // androidx.core.view.accessibility.AccessibilityViewCommand
            public boolean perform(View view, AccessibilityViewCommand.CommandArguments commandArguments) {
                return true;
            }
        }

        public BaseBehavior() {
        }

        private void c(CoordinatorLayout coordinatorLayout, T t16, View view) {
            if (getTopBottomOffsetForScrollingSibling() != (-t16.d()) && view.canScrollVertically(1)) {
                d(coordinatorLayout, t16, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD, false);
            }
            if (getTopBottomOffsetForScrollingSibling() != 0) {
                if (view.canScrollVertically(-1)) {
                    int i3 = -t16.a();
                    if (i3 != 0) {
                        ViewCompat.replaceAccessibilityAction(coordinatorLayout, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD, null, new a(coordinatorLayout, t16, view, i3));
                        return;
                    }
                    return;
                }
                d(coordinatorLayout, t16, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD, true);
            }
        }

        private void d(CoordinatorLayout coordinatorLayout, T t16, AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat, boolean z16) {
            ViewCompat.replaceAccessibilityAction(coordinatorLayout, accessibilityActionCompat, null, new b());
        }

        private boolean e(CoordinatorLayout coordinatorLayout, T t16, View view) {
            return t16.g() && coordinatorLayout.getHeight() - view.getHeight() <= t16.getHeight();
        }

        private View findFirstScrollingChild(CoordinatorLayout coordinatorLayout) {
            int childCount = coordinatorLayout.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = coordinatorLayout.getChildAt(i3);
                if ((childAt instanceof NestedScrollingChild) || (childAt instanceof ListView) || (childAt instanceof ScrollView)) {
                    return childAt;
                }
            }
            return null;
        }

        private void o(CoordinatorLayout coordinatorLayout, T t16) {
            ViewCompat.removeAccessibilityAction(coordinatorLayout, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD.getId());
            ViewCompat.removeAccessibilityAction(coordinatorLayout, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD.getId());
            View findFirstScrollingChild = findFirstScrollingChild(coordinatorLayout);
            if (findFirstScrollingChild == null || t16.d() == 0 || !(((CoordinatorLayout.LayoutParams) findFirstScrollingChild.getLayoutParams()).getBehavior() instanceof ScrollingViewBehavior)) {
                return;
            }
            c(coordinatorLayout, t16, findFirstScrollingChild);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.tencent.aelight.camera.ae.view.scrollingheader.HeaderBehavior
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public int getMaxDragOffset(T t16) {
            return -t16.b();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.tencent.aelight.camera.ae.view.scrollingheader.HeaderBehavior
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public int getScrollRangeForDragFling(T t16) {
            return t16.d();
        }

        @Override // com.tencent.aelight.camera.ae.view.scrollingheader.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ int getTopAndBottomOffset() {
            return super.getTopAndBottomOffset();
        }

        @Override // com.tencent.aelight.camera.ae.view.scrollingheader.HeaderBehavior
        int getTopBottomOffsetForScrollingSibling() {
            return getTopAndBottomOffset() + this.f65944q;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.tencent.aelight.camera.ae.view.scrollingheader.HeaderBehavior
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public void onFlingFinished(CoordinatorLayout coordinatorLayout, T t16) {
            n(coordinatorLayout, t16);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* renamed from: l, reason: merged with bridge method [inline-methods] */
        public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, T t16, View view, int i3) {
            if (this.f65945r == 0 || i3 == 1) {
                n(coordinatorLayout, t16);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.tencent.aelight.camera.ae.view.scrollingheader.HeaderBehavior
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public int setHeaderTopBottomOffset(CoordinatorLayout coordinatorLayout, T t16, int i3, int i16, int i17) {
            int topBottomOffsetForScrollingSibling = getTopBottomOffsetForScrollingSibling();
            int i18 = 0;
            if (i16 != 0 && topBottomOffsetForScrollingSibling >= i16 && topBottomOffsetForScrollingSibling <= i17) {
                int clamp = MathUtils.clamp(i3, i16, i17);
                if (topBottomOffsetForScrollingSibling != clamp) {
                    boolean topAndBottomOffset = setTopAndBottomOffset(clamp);
                    i18 = topBottomOffsetForScrollingSibling - clamp;
                    this.f65944q = clamp - clamp;
                    if (!topAndBottomOffset && t16.f()) {
                        coordinatorLayout.dispatchDependentViewsChanged(t16);
                    }
                }
            } else {
                this.f65944q = 0;
            }
            o(coordinatorLayout, t16);
            return i18;
        }

        @Override // com.tencent.aelight.camera.ae.view.scrollingheader.HeaderBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            return super.onInterceptTouchEvent(coordinatorLayout, view, motionEvent);
        }

        @Override // com.tencent.aelight.camera.ae.view.scrollingheader.ViewOffsetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onLayoutChild(CoordinatorLayout coordinatorLayout, View view, int i3) {
            return super.onLayoutChild(coordinatorLayout, view, i3);
        }

        @Override // com.tencent.aelight.camera.ae.view.scrollingheader.HeaderBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onTouchEvent(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            return super.onTouchEvent(coordinatorLayout, view, motionEvent);
        }

        @Override // com.tencent.aelight.camera.ae.view.scrollingheader.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ boolean setTopAndBottomOffset(int i3) {
            return super.setTopAndBottomOffset(i3);
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public void onNestedScroll(CoordinatorLayout coordinatorLayout, T t16, View view, int i3, int i16, int i17, int i18, int i19, int[] iArr) {
            if (i18 < 0) {
                iArr[1] = scroll(coordinatorLayout, t16, i18, -t16.b(), 0);
            }
            if (i18 == 0) {
                o(coordinatorLayout, t16);
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, T t16, View view, int i3, int i16, int[] iArr, int i17) {
            int i18;
            int i19;
            if (i16 != 0) {
                if (i16 < 0) {
                    i18 = -t16.d();
                    i19 = t16.a() + i18;
                } else {
                    i18 = -t16.e();
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
        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, T t16, View view, View view2, int i3, int i16) {
            boolean z16 = (i3 & 2) != 0 && e(coordinatorLayout, t16, view);
            this.f65945r = i16;
            return z16;
        }

        private void n(CoordinatorLayout coordinatorLayout, T t16) {
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class Behavior extends BaseBehavior<ScrollingHeaderLayout> {
        public Behavior() {
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class ScrollingViewBehavior extends HeaderScrollingViewBehavior {
        public ScrollingViewBehavior() {
        }

        private void offsetChildAsNeeded(View view, View view2) {
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) view2.getLayoutParams()).getBehavior();
            if (behavior instanceof BaseBehavior) {
                ViewCompat.offsetTopAndBottom(view, (((view2.getBottom() - view.getTop()) + ((BaseBehavior) behavior).f65944q) + getVerticalLayoutGap()) - getOverlapPixelsForOffset(view2));
            }
        }

        @Override // com.tencent.aelight.camera.ae.view.scrollingheader.HeaderScrollingViewBehavior
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ScrollingHeaderLayout findFirstDependency(List<View> list) {
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                View view = list.get(i3);
                if (view instanceof ScrollingHeaderLayout) {
                    return (ScrollingHeaderLayout) view;
                }
            }
            return null;
        }

        @Override // com.tencent.aelight.camera.ae.view.scrollingheader.HeaderScrollingViewBehavior
        float getOverlapRatioForOffset(View view) {
            return 0.0f;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.tencent.aelight.camera.ae.view.scrollingheader.HeaderScrollingViewBehavior
        public int getScrollRange(View view) {
            if (view instanceof ScrollingHeaderLayout) {
                return ((ScrollingHeaderLayout) view).d();
            }
            return super.getScrollRange(view);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return view2 instanceof ScrollingHeaderLayout;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, View view, View view2) {
            offsetChildAsNeeded(view, view2);
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public void onDependentViewRemoved(CoordinatorLayout coordinatorLayout, View view, View view2) {
            if (view2 instanceof ScrollingHeaderLayout) {
                ViewCompat.removeAccessibilityAction(coordinatorLayout, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD.getId());
                ViewCompat.removeAccessibilityAction(coordinatorLayout, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD.getId());
            }
        }

        @Override // com.tencent.aelight.camera.ae.view.scrollingheader.ViewOffsetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onLayoutChild(CoordinatorLayout coordinatorLayout, View view, int i3) {
            return super.onLayoutChild(coordinatorLayout, view, i3);
        }

        @Override // com.tencent.aelight.camera.ae.view.scrollingheader.HeaderScrollingViewBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onMeasureChild(CoordinatorLayout coordinatorLayout, View view, int i3, int i16, int i17, int i18) {
            return super.onMeasureChild(coordinatorLayout, view, i3, i16, i17, i18);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onRequestChildRectangleOnScreen(CoordinatorLayout coordinatorLayout, View view, Rect rect, boolean z16) {
            if (findFirstDependency(coordinatorLayout.getDependencies(view)) != null) {
                rect.offset(view.getLeft(), view.getTop());
                this.f65936j.set(0, 0, coordinatorLayout.getWidth(), coordinatorLayout.getHeight());
            }
            return false;
        }

        public ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class a implements OnApplyWindowInsetsListener {
        a() {
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            return ScrollingHeaderLayout.this.i(windowInsetsCompat);
        }
    }

    public ScrollingHeaderLayout(Context context) {
        this(context, null);
    }

    private boolean j() {
        return false;
    }

    private boolean k() {
        if (getChildCount() <= 0) {
            return false;
        }
        View childAt = getChildAt(0);
        return (childAt.getVisibility() == 8 || ViewCompat.getFitsSystemWindows(childAt)) ? false : true;
    }

    private void l() {
        setWillNotDraw(!j());
    }

    int a() {
        int i3 = this.f65941e;
        if (i3 != -1) {
            return i3;
        }
        int max = Math.max(0, 0);
        this.f65941e = max;
        return max;
    }

    int b() {
        int i3;
        int i16 = this.f65942f;
        if (i16 != -1) {
            return i16;
        }
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
            i3 = ((childAt.getMeasuredHeight() + (layoutParams.topMargin + layoutParams.bottomMargin)) + 0) - ViewCompat.getMinimumHeight(childAt);
        } else {
            i3 = 0;
        }
        int max = Math.max(0, i3);
        this.f65942f = max;
        return max;
    }

    final int c() {
        WindowInsetsCompat windowInsetsCompat = this.f65943h;
        if (windowInsetsCompat != null) {
            return windowInsetsCompat.getSystemWindowInsetTop();
        }
        return 0;
    }

    public final int d() {
        int i3;
        int i16 = this.f65940d;
        if (i16 != -1) {
            return i16;
        }
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
            i3 = (((childAt.getMeasuredHeight() + layoutParams.topMargin) + layoutParams.bottomMargin) + 0) - ViewCompat.getMinimumHeight(childAt);
        } else {
            i3 = 0;
        }
        int max = Math.max(0, i3);
        this.f65940d = max;
        return max;
    }

    int e() {
        return d();
    }

    boolean f() {
        return false;
    }

    boolean g() {
        return d() != 0;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior
    public CoordinatorLayout.Behavior<ScrollingHeaderLayout> getBehavior() {
        return new Behavior();
    }

    WindowInsetsCompat i(WindowInsetsCompat windowInsetsCompat) {
        WindowInsetsCompat windowInsetsCompat2 = ViewCompat.getFitsSystemWindows(this) ? windowInsetsCompat : null;
        if (!ObjectsCompat.equals(this.f65943h, windowInsetsCompat2)) {
            this.f65943h = windowInsetsCompat2;
            l();
            requestLayout();
        }
        return windowInsetsCompat;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
        if (ViewCompat.getFitsSystemWindows(this) && k()) {
            int c16 = c();
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                ViewCompat.offsetTopAndBottom(getChildAt(childCount), c16);
            }
        }
        h();
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
        int mode = View.MeasureSpec.getMode(i16);
        if (mode != 1073741824 && ViewCompat.getFitsSystemWindows(this) && k()) {
            int measuredHeight = getMeasuredHeight();
            if (mode == Integer.MIN_VALUE) {
                measuredHeight = MathUtils.clamp(getMeasuredHeight() + c(), 0, View.MeasureSpec.getSize(i16));
            } else if (mode == 0) {
                measuredHeight += c();
            }
            setMeasuredDimension(getMeasuredWidth(), measuredHeight);
        }
        h();
    }

    public ScrollingHeaderLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void h() {
        this.f65940d = -1;
        this.f65941e = -1;
        this.f65942f = -1;
    }

    public ScrollingHeaderLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f65940d = -1;
        this.f65941e = -1;
        this.f65942f = -1;
        ViewCompat.setOnApplyWindowInsetsListener(this, new a());
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int i3) {
        if (i3 == 1) {
            super.setOrientation(i3);
            return;
        }
        throw new IllegalArgumentException("ScrollingHeaderLayout is always vertical and does not support horizontal orientation");
    }
}
