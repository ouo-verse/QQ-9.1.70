package com.tencent.sqshow.zootopia.portal.detail.scrollingheader;

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
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes34.dex */
public class ScrollingHeaderLayout extends LinearLayout implements CoordinatorLayout.AttachedBehavior {

    /* renamed from: d, reason: collision with root package name */
    private int f372323d;

    /* renamed from: e, reason: collision with root package name */
    private int f372324e;

    /* renamed from: f, reason: collision with root package name */
    private int f372325f;

    /* renamed from: h, reason: collision with root package name */
    private int f372326h;

    /* renamed from: i, reason: collision with root package name */
    private List<b> f372327i;

    /* renamed from: m, reason: collision with root package name */
    private WindowInsetsCompat f372328m;

    /* compiled from: P */
    /* loaded from: classes34.dex */
    public static class BaseBehavior<T extends ScrollingHeaderLayout> extends HeaderBehavior<T> {

        /* renamed from: q, reason: collision with root package name */
        private int f372329q;

        /* renamed from: r, reason: collision with root package name */
        private int f372330r;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes34.dex */
        public class a implements AccessibilityViewCommand {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ CoordinatorLayout f372331a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ ScrollingHeaderLayout f372332b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ View f372333c;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ int f372334d;

            a(CoordinatorLayout coordinatorLayout, ScrollingHeaderLayout scrollingHeaderLayout, View view, int i3) {
                this.f372331a = coordinatorLayout;
                this.f372332b = scrollingHeaderLayout;
                this.f372333c = view;
                this.f372334d = i3;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // androidx.core.view.accessibility.AccessibilityViewCommand
            public boolean perform(View view, AccessibilityViewCommand.CommandArguments commandArguments) {
                BaseBehavior.this.onNestedPreScroll(this.f372331a, this.f372332b, this.f372333c, 0, this.f372334d, new int[]{0, 0}, 1);
                return true;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes34.dex */
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
            if (getTopBottomOffsetForScrollingSibling() != (-t16.f()) && view.canScrollVertically(1)) {
                d(coordinatorLayout, t16, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD, false);
            }
            if (getTopBottomOffsetForScrollingSibling() != 0) {
                if (view.canScrollVertically(-1)) {
                    int i3 = -t16.c();
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

        private boolean f(CoordinatorLayout coordinatorLayout, T t16, View view) {
            return t16.i() && coordinatorLayout.getHeight() - view.getHeight() <= t16.getHeight();
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

        private void p(CoordinatorLayout coordinatorLayout, T t16) {
            ViewCompat.removeAccessibilityAction(coordinatorLayout, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD.getId());
            ViewCompat.removeAccessibilityAction(coordinatorLayout, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD.getId());
            View findFirstScrollingChild = findFirstScrollingChild(coordinatorLayout);
            if (findFirstScrollingChild == null || t16.f() == 0 || !(((CoordinatorLayout.LayoutParams) findFirstScrollingChild.getLayoutParams()).getBehavior() instanceof ScrollingViewBehavior)) {
                return;
            }
            c(coordinatorLayout, t16, findFirstScrollingChild);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.tencent.sqshow.zootopia.portal.detail.scrollingheader.HeaderBehavior
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public boolean canDragView(T t16) {
            return true;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.tencent.sqshow.zootopia.portal.detail.scrollingheader.HeaderBehavior
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public int getMaxDragOffset(T t16) {
            return -t16.d();
        }

        @Override // com.tencent.sqshow.zootopia.portal.detail.scrollingheader.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ int getTopAndBottomOffset() {
            return super.getTopAndBottomOffset();
        }

        @Override // com.tencent.sqshow.zootopia.portal.detail.scrollingheader.HeaderBehavior
        int getTopBottomOffsetForScrollingSibling() {
            return getTopAndBottomOffset() + this.f372329q;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.tencent.sqshow.zootopia.portal.detail.scrollingheader.HeaderBehavior
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public int getScrollRangeForDragFling(T t16) {
            return t16.f();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.tencent.sqshow.zootopia.portal.detail.scrollingheader.HeaderBehavior
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public void onFlingFinished(CoordinatorLayout coordinatorLayout, T t16) {
            o(coordinatorLayout, t16);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, T t16, View view, int i3) {
            if (this.f372330r == 0 || i3 == 1) {
                o(coordinatorLayout, t16);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.tencent.sqshow.zootopia.portal.detail.scrollingheader.HeaderBehavior
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public int setHeaderTopBottomOffset(CoordinatorLayout coordinatorLayout, T t16, int i3, int i16, int i17) {
            int topBottomOffsetForScrollingSibling = getTopBottomOffsetForScrollingSibling();
            int i18 = 0;
            if (i16 != 0 && topBottomOffsetForScrollingSibling >= i16 && topBottomOffsetForScrollingSibling <= i17) {
                int clamp = MathUtils.clamp(i3, i16, i17);
                if (topBottomOffsetForScrollingSibling != clamp) {
                    boolean topAndBottomOffset = setTopAndBottomOffset(clamp);
                    i18 = topBottomOffsetForScrollingSibling - clamp;
                    this.f372329q = clamp - clamp;
                    if (!topAndBottomOffset && t16.h()) {
                        coordinatorLayout.dispatchDependentViewsChanged(t16);
                    }
                    t16.k(getTopAndBottomOffset());
                }
            } else {
                this.f372329q = 0;
            }
            p(coordinatorLayout, t16);
            return i18;
        }

        @Override // com.tencent.sqshow.zootopia.portal.detail.scrollingheader.HeaderBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            return super.onInterceptTouchEvent(coordinatorLayout, view, motionEvent);
        }

        @Override // com.tencent.sqshow.zootopia.portal.detail.scrollingheader.ViewOffsetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onLayoutChild(CoordinatorLayout coordinatorLayout, View view, int i3) {
            return super.onLayoutChild(coordinatorLayout, view, i3);
        }

        @Override // com.tencent.sqshow.zootopia.portal.detail.scrollingheader.HeaderBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onTouchEvent(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            return super.onTouchEvent(coordinatorLayout, view, motionEvent);
        }

        @Override // com.tencent.sqshow.zootopia.portal.detail.scrollingheader.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ boolean setTopAndBottomOffset(int i3) {
            return super.setTopAndBottomOffset(i3);
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public void onNestedScroll(CoordinatorLayout coordinatorLayout, T t16, View view, int i3, int i16, int i17, int i18, int i19, int[] iArr) {
            if (i18 < 0) {
                iArr[1] = scroll(coordinatorLayout, t16, i18, -t16.d(), 0);
            }
            if (i18 == 0) {
                p(coordinatorLayout, t16);
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, T t16, View view, int i3, int i16, int[] iArr, int i17) {
            int i18;
            int i19;
            if (i16 != 0) {
                if (i16 < 0) {
                    i18 = -t16.f();
                    i19 = t16.c() + i18;
                } else {
                    i18 = -t16.g();
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
        /* renamed from: l, reason: merged with bridge method [inline-methods] */
        public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, T t16, View view, View view2, int i3, int i16) {
            boolean z16 = (i3 & 2) != 0 && f(coordinatorLayout, t16, view);
            this.f372330r = i16;
            return z16;
        }

        private void o(CoordinatorLayout coordinatorLayout, T t16) {
        }
    }

    /* compiled from: P */
    /* loaded from: classes34.dex */
    public static class Behavior extends BaseBehavior<ScrollingHeaderLayout> {
        public Behavior() {
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    /* compiled from: P */
    /* loaded from: classes34.dex */
    public static class ScrollingViewBehavior extends HeaderScrollingViewBehavior {
        public ScrollingViewBehavior() {
        }

        private void offsetChildAsNeeded(View view, View view2) {
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) view2.getLayoutParams()).getBehavior();
            if (behavior instanceof BaseBehavior) {
                ViewCompat.offsetTopAndBottom(view, (((view2.getBottom() - view.getTop()) + ((BaseBehavior) behavior).f372329q) + getVerticalLayoutGap()) - getOverlapPixelsForOffset(view2));
            }
        }

        @Override // com.tencent.sqshow.zootopia.portal.detail.scrollingheader.HeaderScrollingViewBehavior
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

        @Override // com.tencent.sqshow.zootopia.portal.detail.scrollingheader.HeaderScrollingViewBehavior
        float getOverlapRatioForOffset(View view) {
            return 0.0f;
        }

        @Override // com.tencent.sqshow.zootopia.portal.detail.scrollingheader.HeaderScrollingViewBehavior
        int getScrollRange(View view) {
            if (view instanceof ScrollingHeaderLayout) {
                return ((ScrollingHeaderLayout) view).f();
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

        @Override // com.tencent.sqshow.zootopia.portal.detail.scrollingheader.ViewOffsetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onLayoutChild(CoordinatorLayout coordinatorLayout, View view, int i3) {
            return super.onLayoutChild(coordinatorLayout, view, i3);
        }

        @Override // com.tencent.sqshow.zootopia.portal.detail.scrollingheader.HeaderScrollingViewBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onMeasureChild(CoordinatorLayout coordinatorLayout, View view, int i3, int i16, int i17, int i18) {
            return super.onMeasureChild(coordinatorLayout, view, i3, i16, i17, i18);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onRequestChildRectangleOnScreen(CoordinatorLayout coordinatorLayout, View view, Rect rect, boolean z16) {
            if (findFirstDependency(coordinatorLayout.getDependencies(view)) != null) {
                rect.offset(view.getLeft(), view.getTop());
                this.f372319j.set(0, 0, coordinatorLayout.getWidth(), coordinatorLayout.getHeight());
            }
            return false;
        }

        public ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    /* compiled from: P */
    /* loaded from: classes34.dex */
    class a implements OnApplyWindowInsetsListener {
        a() {
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            return ScrollingHeaderLayout.this.l(windowInsetsCompat);
        }
    }

    /* compiled from: P */
    /* loaded from: classes34.dex */
    public interface b<T extends ScrollingHeaderLayout> {
        void a(T t16, int i3);
    }

    /* compiled from: P */
    /* loaded from: classes34.dex */
    public interface c extends b<ScrollingHeaderLayout> {
    }

    public ScrollingHeaderLayout(Context context) {
        this(context, null);
    }

    private boolean m() {
        return false;
    }

    private boolean n() {
        if (getChildCount() <= 0) {
            return false;
        }
        View childAt = getChildAt(0);
        return (childAt.getVisibility() == 8 || ViewCompat.getFitsSystemWindows(childAt)) ? false : true;
    }

    private void o() {
        setWillNotDraw(!m());
    }

    public void a(b bVar) {
        if (this.f372327i == null) {
            this.f372327i = new ArrayList();
        }
        if (bVar == null || this.f372327i.contains(bVar)) {
            return;
        }
        this.f372327i.add(bVar);
    }

    public void b(c cVar) {
        a(cVar);
    }

    int c() {
        int i3 = this.f372325f;
        if (i3 != -1) {
            return i3;
        }
        int max = Math.max(0, 0);
        this.f372325f = max;
        return max;
    }

    int d() {
        int i3;
        int i16 = this.f372326h;
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
        this.f372326h = max;
        return max;
    }

    final int e() {
        WindowInsetsCompat windowInsetsCompat = this.f372328m;
        if (windowInsetsCompat != null) {
            return windowInsetsCompat.getSystemWindowInsetTop();
        }
        return 0;
    }

    public final int f() {
        int i3;
        int i16 = this.f372324e;
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
        this.f372324e = max;
        return max;
    }

    int g() {
        return f();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior
    public CoordinatorLayout.Behavior<ScrollingHeaderLayout> getBehavior() {
        return new Behavior();
    }

    boolean h() {
        return false;
    }

    boolean i() {
        return f() != 0;
    }

    void k(int i3) {
        this.f372323d = i3;
        List<b> list = this.f372327i;
        if (list != null) {
            int size = list.size();
            for (int i16 = 0; i16 < size; i16++) {
                b bVar = this.f372327i.get(i16);
                if (bVar != null) {
                    bVar.a(this, i3);
                }
            }
        }
    }

    WindowInsetsCompat l(WindowInsetsCompat windowInsetsCompat) {
        WindowInsetsCompat windowInsetsCompat2 = ViewCompat.getFitsSystemWindows(this) ? windowInsetsCompat : null;
        if (!ObjectsCompat.equals(this.f372328m, windowInsetsCompat2)) {
            this.f372328m = windowInsetsCompat2;
            o();
            requestLayout();
        }
        return windowInsetsCompat;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
        if (ViewCompat.getFitsSystemWindows(this) && n()) {
            int e16 = e();
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                ViewCompat.offsetTopAndBottom(getChildAt(childCount), e16);
            }
        }
        j();
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
        int mode = View.MeasureSpec.getMode(i16);
        if (mode != 1073741824 && ViewCompat.getFitsSystemWindows(this) && n()) {
            int measuredHeight = getMeasuredHeight();
            if (mode == Integer.MIN_VALUE) {
                measuredHeight = MathUtils.clamp(getMeasuredHeight() + e(), 0, View.MeasureSpec.getSize(i16));
            } else if (mode == 0) {
                measuredHeight += e();
            }
            setMeasuredDimension(getMeasuredWidth(), measuredHeight);
        }
        j();
    }

    public ScrollingHeaderLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void j() {
        this.f372324e = -1;
        this.f372325f = -1;
        this.f372326h = -1;
    }

    public ScrollingHeaderLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f372324e = -1;
        this.f372325f = -1;
        this.f372326h = -1;
        this.f372327i = new ArrayList();
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
