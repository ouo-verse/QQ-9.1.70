package com.tencent.mobileqq.qwallet.consecutivescroller;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.NestedScrollingChild2;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParent2;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ScrollingView;
import androidx.core.view.ViewCompat;
import androidx.core.widget.EdgeEffectCompat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes16.dex */
public class ConsecutiveScrollerLayout extends ViewGroup implements ScrollingView, NestedScrollingParent2, NestedScrollingChild2 {

    /* renamed from: k0, reason: collision with root package name */
    static final Interpolator f277121k0 = new a();
    private int C;
    private OverScroller D;
    private VelocityTracker E;
    private VelocityTracker F;
    private int G;
    private int H;
    private int I;
    private int J;
    private int K;
    private int L;
    private int M;
    private HashMap<Integer, Float> N;
    private boolean P;
    private int Q;
    private int R;
    private NestedScrollingParentHelper S;
    private NestedScrollingChildHelper T;
    private View U;
    private int V;
    private int W;

    /* renamed from: a0, reason: collision with root package name */
    private int f277122a0;

    /* renamed from: b0, reason: collision with root package name */
    private int f277123b0;

    /* renamed from: c0, reason: collision with root package name */
    private int f277124c0;

    /* renamed from: d, reason: collision with root package name */
    private final int[] f277125d;

    /* renamed from: d0, reason: collision with root package name */
    private EdgeEffect f277126d0;

    /* renamed from: e, reason: collision with root package name */
    private final int[] f277127e;

    /* renamed from: e0, reason: collision with root package name */
    private EdgeEffect f277128e0;

    /* renamed from: f, reason: collision with root package name */
    private final int[] f277129f;

    /* renamed from: f0, reason: collision with root package name */
    private int f277130f0;

    /* renamed from: g0, reason: collision with root package name */
    private int f277131g0;

    /* renamed from: h, reason: collision with root package name */
    private final List<View> f277132h;

    /* renamed from: h0, reason: collision with root package name */
    private int f277133h0;

    /* renamed from: i, reason: collision with root package name */
    protected b f277134i;

    /* renamed from: i0, reason: collision with root package name */
    private int f277135i0;

    /* renamed from: j0, reason: collision with root package name */
    private boolean f277136j0;

    /* renamed from: m, reason: collision with root package name */
    int f277137m;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.qwallet.consecutivescroller.ConsecutiveScrollerLayout$2, reason: invalid class name */
    /* loaded from: classes16.dex */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ ConsecutiveScrollerLayout this$0;

        @Override // java.lang.Runnable
        public void run() {
            this.this$0.c(false, true);
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class a implements Interpolator {
        a() {
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f16) {
            float f17 = f16 - 1.0f;
            return (f17 * f17 * f17 * f17 * f17) + 1.0f;
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public interface b {
        void a(View view, int i3, int i16, int i17);
    }

    public ConsecutiveScrollerLayout(Context context) {
        this(context, null);
    }

    private void C(View view, int i3, int i16) {
        if (q(view).height == -2) {
            measureChildWithMargins(view, i3, 0, 0, 0);
        } else {
            measureChildWithMargins(view, i3, 0, i16, 0);
        }
    }

    private int D(int i3, int i16) {
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        if (mode == 1073741824) {
            i16 = size;
        } else if (mode == Integer.MIN_VALUE) {
            i16 = Math.min(i16, size);
        }
        return View.resolveSizeAndState(Math.max(i16, getSuggestedMinimumWidth()), i3, 0);
    }

    private void E(int i3, int i16) {
        int i17 = this.C;
        g(i3);
        int i18 = this.C - i17;
        this.T.dispatchNestedScroll(0, i18, 0, i3 - i18, null, i16);
    }

    private void F() {
        VelocityTracker velocityTracker = this.F;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.F = null;
        }
    }

    private void G() {
        VelocityTracker velocityTracker = this.E;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.E = null;
        }
    }

    private void H() {
        Iterator<View> it = r().iterator();
        while (it.hasNext()) {
            it.next().setTranslationY(0.0f);
        }
    }

    private void I() {
        View j3 = j();
        this.U = j3;
        if (j3 != null) {
            this.V = getScrollY() - this.U.getTop();
        }
    }

    private void J(int i3, int i16) {
        b bVar = this.f277134i;
        if (bVar != null) {
            bVar.a(this, i3, i16, this.f277135i0);
        }
    }

    private void K(View view, int i3) {
        view.scrollBy(0, i3);
    }

    private void N(int i3) {
        int i16;
        int i17;
        View m3;
        int computeVerticalScrollOffset = computeVerticalScrollOffset();
        do {
            int i18 = this.W;
            int i19 = 0;
            if (i18 != -1) {
                i16 = getChildAt(i18).getTop() - this.f277123b0;
                i17 = u(this.W);
                if (this.f277124c0 >= 1000 || getScrollY() + getPaddingTop() + i17 <= i16 || B()) {
                    this.W = -1;
                    this.f277122a0 = 0;
                    this.f277123b0 = 0;
                    this.f277124c0 = 0;
                    Q(0);
                    break;
                }
            } else {
                i16 = 0;
                i17 = 0;
            }
            if (!B()) {
                if (getScrollY() < this.f277137m) {
                    m3 = k();
                } else {
                    m3 = m();
                }
                if (m3 != null) {
                    awakenScrollBars();
                    int j3 = c.j(m3);
                    if (j3 < 0) {
                        i19 = Math.max(i3, j3);
                        if (this.W != -1) {
                            i19 = Math.max(i19, i16 - ((getScrollY() + getPaddingTop()) + i17));
                        }
                        K(m3, i19);
                    } else {
                        int scrollY = getScrollY();
                        int max = Math.max(Math.max(i3, ((m3.getTop() + getPaddingBottom()) - scrollY) - getHeight()), -scrollY);
                        if (this.W != -1) {
                            max = Math.max(max, i16 - ((getScrollY() + getPaddingTop()) + i17));
                        }
                        O(scrollY + max);
                        i19 = max;
                    }
                    this.C += i19;
                    i3 -= i19;
                }
            }
            if (i19 >= 0) {
                break;
            }
        } while (i3 < 0);
        int computeVerticalScrollOffset2 = computeVerticalScrollOffset();
        if (computeVerticalScrollOffset != computeVerticalScrollOffset2) {
            J(computeVerticalScrollOffset2, computeVerticalScrollOffset);
        }
    }

    private void O(int i3) {
        if (i3 < 0) {
            i3 = 0;
        } else {
            int i16 = this.f277137m;
            if (i3 > i16) {
                i3 = i16;
            }
        }
        super.scrollTo(0, i3);
    }

    private void P(int i3) {
        int i16;
        int i17;
        View m3;
        int computeVerticalScrollOffset = computeVerticalScrollOffset();
        do {
            int i18 = this.W;
            int i19 = 0;
            if (i18 != -1) {
                int top = getChildAt(i18).getTop();
                int i26 = this.f277123b0;
                i16 = top - i26;
                if (i26 < 0) {
                    i17 = u(this.W);
                } else {
                    i17 = 0;
                }
                if (this.f277124c0 >= 1000 || getScrollY() + getPaddingTop() + i17 >= i16 || A()) {
                    this.W = -1;
                    this.f277122a0 = 0;
                    this.f277123b0 = 0;
                    this.f277124c0 = 0;
                    Q(0);
                    break;
                }
            } else {
                i16 = 0;
                i17 = 0;
            }
            if (!A()) {
                if (getScrollY() < this.f277137m) {
                    m3 = j();
                } else {
                    m3 = m();
                }
                if (m3 != null) {
                    awakenScrollBars();
                    int i27 = c.i(m3);
                    if (i27 > 0) {
                        i19 = Math.min(i3, i27);
                        if (this.W != -1) {
                            i19 = Math.min(i19, i16 - ((getScrollY() + getPaddingTop()) + i17));
                        }
                        K(m3, i19);
                    } else {
                        i19 = Math.min(i3, (m3.getBottom() - getPaddingTop()) - getScrollY());
                        if (this.W != -1) {
                            i19 = Math.min(i19, i16 - ((getScrollY() + getPaddingTop()) + i17));
                        }
                        O(getScrollY() + i19);
                    }
                    this.C += i19;
                    i3 -= i19;
                }
            }
            if (i19 <= 0) {
                break;
            }
        } while (i3 > 0);
        int computeVerticalScrollOffset2 = computeVerticalScrollOffset();
        if (computeVerticalScrollOffset != computeVerticalScrollOffset2) {
            J(computeVerticalScrollOffset2, computeVerticalScrollOffset);
        }
    }

    private void R() {
        ArrayList arrayList = new ArrayList();
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            arrayList.add(getChildAt(i3));
        }
        this.f277132h.clear();
        this.f277132h.addAll(arrayList);
    }

    private boolean b() {
        if (B() && A()) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z16, boolean z17) {
        int i3 = this.C;
        View view = this.U;
        if (view != null && z16) {
            if (indexOfChild(view) != -1) {
                O(this.U.getTop() + this.V);
            }
        } else {
            O(getScrollY());
        }
        d(true, z17);
        if (i3 != this.C && this.U != j()) {
            scrollTo(0, i3);
        }
        this.U = null;
        this.V = 0;
        H();
    }

    private void d(boolean z16, boolean z17) {
        int computeVerticalScrollOffset;
        if (!z17 && (this.P || !this.D.isFinished() || this.W != -1)) {
            return;
        }
        int computeVerticalScrollOffset2 = computeVerticalScrollOffset();
        View j3 = j();
        if (j3 == null) {
            return;
        }
        int indexOfChild = indexOfChild(j3);
        if (z16) {
            while (true) {
                int i3 = c.i(j3);
                int top = j3.getTop() - getScrollY();
                if (i3 <= 0 || top >= 0) {
                    break;
                }
                int min = Math.min(i3, -top);
                O(getScrollY() - min);
                K(j3, min);
            }
        }
        for (int i16 = 0; i16 < indexOfChild; i16++) {
            View childAt = getChildAt(i16);
            if (childAt.getVisibility() != 8) {
                L(childAt);
            }
        }
        while (true) {
            indexOfChild++;
            if (indexOfChild >= getChildCount()) {
                break;
            }
            View childAt2 = getChildAt(indexOfChild);
            if (childAt2.getVisibility() != 8 && (indexOfChild != getChildCount() - 1 || childAt2.getHeight() >= getHeight() || getScrollY() < this.f277137m)) {
                M(childAt2);
            }
        }
        e();
        if (z16 && computeVerticalScrollOffset2 != (computeVerticalScrollOffset = computeVerticalScrollOffset())) {
            J(computeVerticalScrollOffset, computeVerticalScrollOffset2);
        }
    }

    private void e() {
        this.C = computeVerticalScrollOffset();
    }

    private void f(View view) {
        view.setVerticalScrollBarEnabled(false);
        view.setHorizontalScrollBarEnabled(false);
        view.setOverScrollMode(2);
        ViewCompat.setNestedScrollingEnabled(view, false);
    }

    private void g(int i3) {
        if (i3 > 0) {
            P(i3);
        } else if (i3 < 0) {
            N(i3);
        }
    }

    private void h() {
        EdgeEffect edgeEffect = this.f277126d0;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            this.f277128e0.onRelease();
        }
    }

    private void i() {
        if (getOverScrollMode() != 2) {
            if (this.f277126d0 == null) {
                Context context = getContext();
                this.f277126d0 = new EdgeEffect(context);
                this.f277128e0 = new EdgeEffect(context);
                return;
            }
            return;
        }
        this.f277126d0 = null;
        this.f277128e0 = null;
    }

    private void l(int i3) {
        boolean z16;
        if (Math.abs(i3) > this.I) {
            float f16 = i3;
            if (!dispatchNestedPreFling(0.0f, f16)) {
                if ((i3 < 0 && !B()) || (i3 > 0 && !A())) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                dispatchNestedFling(0.0f, f16, z16);
                this.D.fling(0, this.C, 1, i3, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
                startNestedScroll(2, 1);
                Q(2);
                this.f277130f0 = this.C;
                invalidate();
            }
        }
    }

    private View m() {
        List<View> p16 = p();
        if (!p16.isEmpty()) {
            return p16.get(p16.size() - 1);
        }
        return null;
    }

    private int n(View view, int i3) {
        return i3 + ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).leftMargin;
    }

    private int o(View view) {
        int measuredWidth = view.getMeasuredWidth();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return measuredWidth + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
    }

    private List<View> p() {
        ArrayList arrayList = new ArrayList();
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8 && childAt.getHeight() > 0) {
                arrayList.add(childAt);
            }
        }
        return arrayList;
    }

    private ViewGroup.LayoutParams q(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            return new ViewGroup.LayoutParams(-2, -1);
        }
        return layoutParams;
    }

    private List<View> r() {
        ArrayList arrayList = new ArrayList();
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                arrayList.add(childAt);
            }
        }
        return arrayList;
    }

    private int s() {
        if (getChildCount() <= 0) {
            return 0;
        }
        return Math.max(0, computeVerticalScrollRange() - ((getHeight() - getPaddingTop()) - getPaddingBottom()));
    }

    private View t(int i3, int i16) {
        for (View view : r()) {
            if (c.n(view, i3, i16)) {
                return view;
            }
        }
        return null;
    }

    private int u(int i3) {
        int childCount = getChildCount();
        int i16 = 0;
        while (i3 < childCount) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                i16 += c.e(childAt);
            }
            i3++;
        }
        return i16;
    }

    private void v() {
        if (this.F == null) {
            this.F = VelocityTracker.obtain();
        }
    }

    private void w() {
        VelocityTracker velocityTracker = this.F;
        if (velocityTracker == null) {
            this.F = VelocityTracker.obtain();
        } else {
            velocityTracker.clear();
        }
    }

    private void x() {
        VelocityTracker velocityTracker = this.E;
        if (velocityTracker == null) {
            this.E = VelocityTracker.obtain();
        } else {
            velocityTracker.clear();
        }
    }

    private boolean y(int i3, int i16) {
        if (t(i3, i16) != null) {
            return true;
        }
        return false;
    }

    private boolean z(MotionEvent motionEvent) {
        int findPointerIndex = motionEvent.findPointerIndex(this.R);
        if (findPointerIndex >= 0 && findPointerIndex < motionEvent.getPointerCount()) {
            return y(c.g(this, motionEvent, findPointerIndex), c.h(this, motionEvent, findPointerIndex));
        }
        return true;
    }

    public boolean A() {
        boolean z16;
        List<View> p16 = p();
        int size = p16.size();
        if (size <= 0) {
            return true;
        }
        View view = p16.get(p16.size() - 1);
        if (getScrollY() >= this.f277137m && !c.c(view, 1)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            for (int i3 = size - 1; i3 >= 0; i3--) {
                if (c.c(p16.get(i3), 1)) {
                    return false;
                }
            }
        }
        return z16;
    }

    public boolean B() {
        boolean z16;
        List<View> p16 = p();
        int size = p16.size();
        if (size <= 0) {
            return true;
        }
        View view = p16.get(0);
        if (getScrollY() <= 0 && !c.c(view, -1)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            for (int i3 = size - 1; i3 >= 0; i3--) {
                if (c.c(p16.get(i3), -1)) {
                    return false;
                }
            }
        }
        return z16;
    }

    void L(View view) {
        int i3;
        do {
            int i16 = c.i(view);
            if (i16 > 0) {
                int e16 = c.e(view);
                K(view, i16);
                i3 = e16 - c.e(view);
            } else {
                i3 = 0;
            }
        } while (i3 != 0);
    }

    void M(View view) {
        int i3;
        do {
            int j3 = c.j(view);
            if (j3 < 0) {
                int e16 = c.e(view);
                K(view, j3);
                i3 = e16 - c.e(view);
            } else {
                i3 = 0;
            }
        } while (i3 != 0);
    }

    void Q(int i3) {
        if (i3 == this.f277135i0) {
            return;
        }
        this.f277135i0 = i3;
        int computeVerticalScrollOffset = computeVerticalScrollOffset();
        J(computeVerticalScrollOffset, computeVerticalScrollOffset);
    }

    public void S() {
        if (!this.D.isFinished()) {
            this.D.abortAnimation();
            stopNestedScroll(1);
            if (this.W == -1) {
                Q(0);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i3, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i3, layoutParams);
        f(view);
        if (view instanceof ViewGroup) {
            ((ViewGroup) view).setClipToPadding(false);
        }
    }

    @Override // android.view.View
    public boolean canScrollVertically(int i3) {
        if (i3 > 0) {
            return !A();
        }
        return !B();
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeHorizontalScrollExtent() {
        return super.computeHorizontalScrollExtent();
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeHorizontalScrollOffset() {
        return super.computeHorizontalScrollOffset();
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeHorizontalScrollRange() {
        return super.computeHorizontalScrollRange();
    }

    @Override // android.view.View
    public void computeScroll() {
        boolean z16;
        int i3;
        if (this.W != -1 && (i3 = this.f277122a0) != 0) {
            if (i3 > 0 && i3 < 200) {
                this.f277122a0 = i3 + 5;
            }
            int i16 = this.f277122a0;
            if (i16 < 0 && i16 > -200) {
                this.f277122a0 = i16 - 5;
            }
            g(this.f277122a0);
            this.f277124c0++;
            invalidate();
            return;
        }
        if (this.D.computeScrollOffset()) {
            int currY = this.D.getCurrY();
            int i17 = currY - this.f277130f0;
            this.f277130f0 = currY;
            int[] iArr = this.f277129f;
            iArr[1] = 0;
            dispatchNestedPreScroll(0, i17, iArr, null, 1);
            int i18 = i17 - this.f277129f[1];
            int i19 = this.C;
            g(i18);
            int i26 = this.C - i19;
            int i27 = i18 - i26;
            if ((i27 < 0 && B()) || (i27 > 0 && A())) {
                dispatchNestedScroll(0, i26, 0, i27, this.f277127e, 1);
                i27 += this.f277127e[1];
            }
            if ((i27 < 0 && B()) || (i27 > 0 && A())) {
                int overScrollMode = getOverScrollMode();
                if (overScrollMode != 0 && (overScrollMode != 1 || s() <= 0)) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (z16) {
                    i();
                    if (i27 < 0) {
                        if (this.f277126d0.isFinished()) {
                            this.f277126d0.onAbsorb((int) this.D.getCurrVelocity());
                        }
                    } else if (this.f277128e0.isFinished()) {
                        this.f277128e0.onAbsorb((int) this.D.getCurrVelocity());
                    }
                }
                S();
            }
            invalidate();
        }
        if (this.f277135i0 == 2 && this.D.isFinished()) {
            stopNestedScroll(1);
            d(false, false);
            Q(0);
        }
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeVerticalScrollExtent() {
        return (getHeight() - getPaddingTop()) - getPaddingBottom();
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeVerticalScrollOffset() {
        int scrollY = getScrollY();
        List<View> r16 = r();
        int size = r16.size();
        for (int i3 = 0; i3 < size; i3++) {
            scrollY += c.e(r16.get(i3));
        }
        return scrollY;
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeVerticalScrollRange() {
        List<View> r16 = r();
        int size = r16.size();
        int i3 = 0;
        for (int i16 = 0; i16 < size; i16++) {
            View view = r16.get(i16);
            if (c.b(view)) {
                i3 += c.f(view) + view.getPaddingTop() + view.getPaddingBottom();
            } else {
                i3 += view.getHeight();
            }
        }
        return i3;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedFling(float f16, float f17, boolean z16) {
        return this.T.dispatchNestedFling(f16, f17, z16);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float f16, float f17) {
        return this.T.dispatchNestedPreFling(f16, f17);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int i3, int i16, int[] iArr, int[] iArr2) {
        return dispatchNestedPreScroll(i3, i16, iArr, iArr2, 0);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int i3, int i16, int i17, int i18, int[] iArr) {
        return this.T.dispatchNestedScroll(i3, i16, i17, i18, iArr);
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x0146, code lost:
    
        if (y(r10[0], r10[1]) != false) goto L47;
     */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z16;
        int findPointerIndex;
        int i3;
        int i16;
        int actionIndex = motionEvent.getActionIndex();
        if (this.Q == 2 && (i16 = this.R) != -1 && this.N.get(Integer.valueOf(i16)) != null) {
            int findPointerIndex2 = motionEvent.findPointerIndex(this.R);
            if (findPointerIndex2 < 0 || findPointerIndex2 >= motionEvent.getPointerCount()) {
                return false;
            }
            motionEvent.offsetLocation(0.0f, this.N.get(Integer.valueOf(this.R)).floatValue() - motionEvent.getY(findPointerIndex2));
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        if (obtain.getActionMasked() == 0) {
            this.f277133h0 = 0;
        }
        obtain.offsetLocation(0.0f, this.f277133h0);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                    if (actionMasked != 3) {
                        if (actionMasked != 5) {
                            if (actionMasked == 6) {
                                this.N.remove(Integer.valueOf(motionEvent.getPointerId(actionIndex)));
                                if (this.R == motionEvent.getPointerId(actionIndex)) {
                                    if (actionIndex == 0) {
                                        i3 = 1;
                                    } else {
                                        i3 = 0;
                                    }
                                    int pointerId = motionEvent.getPointerId(i3);
                                    this.R = pointerId;
                                    this.N.put(Integer.valueOf(pointerId), Float.valueOf(motionEvent.getY(i3)));
                                    this.M = (int) motionEvent.getY(i3);
                                    this.L = (int) motionEvent.getX(i3);
                                    this.f277125d[0] = c.g(this, motionEvent, i3);
                                    this.f277125d[1] = c.h(this, motionEvent, i3);
                                }
                                v();
                                this.F.addMovement(obtain);
                            }
                        } else {
                            int pointerId2 = motionEvent.getPointerId(actionIndex);
                            this.R = pointerId2;
                            this.N.put(Integer.valueOf(pointerId2), Float.valueOf(motionEvent.getY(actionIndex)));
                            this.M = (int) motionEvent.getY(actionIndex);
                            this.L = (int) motionEvent.getX(actionIndex);
                            requestDisallowInterceptTouchEvent(false);
                            this.f277125d[0] = c.g(this, motionEvent, actionIndex);
                            this.f277125d[1] = c.h(this, motionEvent, actionIndex);
                            v();
                            this.F.addMovement(obtain);
                        }
                    }
                } else {
                    int findPointerIndex3 = motionEvent.findPointerIndex(this.R);
                    if (findPointerIndex3 < 0 || findPointerIndex3 >= motionEvent.getPointerCount()) {
                        return false;
                    }
                    v();
                    this.F.addMovement(obtain);
                    int y16 = ((int) motionEvent.getY(findPointerIndex3)) - this.M;
                    int x16 = ((int) motionEvent.getX(findPointerIndex3)) - this.L;
                    if (this.Q == 0) {
                        if (!z(motionEvent)) {
                            int[] iArr = this.f277125d;
                        }
                        if (Math.abs(x16) > Math.abs(y16)) {
                            if (Math.abs(x16) >= this.J) {
                                this.Q = 2;
                                int i17 = this.R;
                                if (i17 != -1 && this.N.get(Integer.valueOf(i17)) != null && (findPointerIndex = motionEvent.findPointerIndex(this.R)) >= 0 && findPointerIndex3 < motionEvent.getPointerCount()) {
                                    motionEvent.offsetLocation(0.0f, this.N.get(Integer.valueOf(this.R)).floatValue() - motionEvent.getY(findPointerIndex));
                                }
                            }
                        } else if (Math.abs(y16) >= this.J) {
                            this.Q = 1;
                        }
                        if (this.Q == 0) {
                            return true;
                        }
                    }
                    this.M = (int) motionEvent.getY(findPointerIndex3);
                    this.L = (int) motionEvent.getX(findPointerIndex3);
                }
            }
            VelocityTracker velocityTracker = this.F;
            if (velocityTracker != null) {
                velocityTracker.addMovement(obtain);
                this.F.computeCurrentVelocity(1000, this.H);
                int yVelocity = (int) this.F.getYVelocity();
                int i18 = this.H;
                this.G = Math.max(-i18, Math.min(yVelocity, i18));
                F();
                int g16 = c.g(this, motionEvent, actionIndex);
                int h16 = c.h(this, motionEvent, actionIndex);
                boolean b16 = c.b(t(g16, h16));
                boolean m3 = c.m(this, g16, h16);
                if (this.Q != 1 && b16 && Math.abs(yVelocity) >= this.I && !m3) {
                    motionEvent.setAction(3);
                }
                if (this.Q != 1 && !c.l(this) && z(motionEvent) && Math.abs(yVelocity) >= this.I && (this.Q == 0 || !m3)) {
                    l(-this.G);
                }
            }
            this.M = 0;
            this.L = 0;
            this.P = false;
            int[] iArr2 = this.f277125d;
            iArr2[0] = 0;
            iArr2[1] = 0;
        } else {
            if (this.f277135i0 == 2) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.f277136j0 = z16;
            S();
            d(false, false);
            this.P = true;
            this.Q = 0;
            int pointerId3 = motionEvent.getPointerId(actionIndex);
            this.R = pointerId3;
            this.N.put(Integer.valueOf(pointerId3), Float.valueOf(motionEvent.getY(actionIndex)));
            this.M = (int) motionEvent.getY(actionIndex);
            this.L = (int) motionEvent.getX(actionIndex);
            w();
            this.F.addMovement(obtain);
            startNestedScroll(2, 0);
            this.f277125d[0] = c.g(this, motionEvent, actionIndex);
            this.f277125d[1] = c.h(this, motionEvent, actionIndex);
        }
        obtain.recycle();
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        int actionMasked2 = motionEvent.getActionMasked();
        if (actionMasked2 == 1 || actionMasked2 == 3) {
            this.Q = 0;
            this.G = 0;
            this.N.clear();
            this.R = -1;
            if (this.D.isFinished()) {
                Q(0);
            }
        }
        return dispatchTouchEvent;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        int i3;
        int i16;
        super.draw(canvas);
        if (this.f277131g0 != getScrollY()) {
            this.f277131g0 = getScrollY();
        }
        if (this.f277126d0 != null) {
            int scrollY = getScrollY();
            int i17 = 0;
            if (!this.f277126d0.isFinished()) {
                int save = canvas.save();
                int width = getWidth();
                int height = getHeight();
                if (getClipToPadding()) {
                    width -= getPaddingLeft() + getPaddingRight();
                    i3 = getPaddingLeft() + 0;
                } else {
                    i3 = 0;
                }
                if (getClipToPadding()) {
                    height -= getPaddingTop() + getPaddingBottom();
                    i16 = getPaddingTop() + scrollY;
                } else {
                    i16 = scrollY;
                }
                canvas.translate(i3, i16);
                this.f277126d0.setSize(width, height);
                if (this.f277126d0.draw(canvas)) {
                    ViewCompat.postInvalidateOnAnimation(this);
                }
                canvas.restoreToCount(save);
            }
            if (!this.f277128e0.isFinished()) {
                int save2 = canvas.save();
                int width2 = getWidth();
                int height2 = getHeight();
                int i18 = scrollY + height2;
                if (getClipToPadding()) {
                    width2 -= getPaddingLeft() + getPaddingRight();
                    i17 = 0 + getPaddingLeft();
                }
                if (getClipToPadding()) {
                    height2 -= getPaddingTop() + getPaddingBottom();
                    i18 -= getPaddingBottom();
                }
                canvas.translate(i17 - width2, i18);
                canvas.rotate(180.0f, width2, 0.0f);
                this.f277128e0.setSize(width2, height2);
                if (this.f277128e0.draw(canvas)) {
                    ViewCompat.postInvalidateOnAnimation(this);
                }
                canvas.restoreToCount(save2);
            }
        }
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new ViewGroup.MarginLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i3, int i16) {
        int indexOfChild;
        if (this.f277132h.size() > i16 && (indexOfChild = indexOfChild(this.f277132h.get(i16))) != -1) {
            return indexOfChild;
        }
        return super.getChildDrawingOrder(i3, i16);
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return this.S.getNestedScrollAxes();
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean hasNestedScrollingParent(int i3) {
        return this.T.hasNestedScrollingParent(i3);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        return this.T.isNestedScrollingEnabled();
    }

    public View j() {
        int scrollY = getScrollY() + getPaddingTop();
        List<View> p16 = p();
        int size = p16.size();
        for (int i3 = 0; i3 < size; i3++) {
            View view = p16.get(i3);
            if (view.getTop() <= scrollY && view.getBottom() > scrollY) {
                return view;
            }
        }
        return null;
    }

    public View k() {
        int height = (getHeight() - getPaddingBottom()) + getScrollY();
        List<View> p16 = p();
        int size = p16.size();
        for (int i3 = 0; i3 < size; i3++) {
            View view = p16.get(i3);
            if (view.getTop() < height && view.getBottom() >= height) {
                return view;
            }
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0025, code lost:
    
        if (y(r0[0], r0[1]) != false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x000e, code lost:
    
        if (r0 != 3) goto L24;
     */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    if (this.Q != 2) {
                        if (!z(motionEvent)) {
                            int[] iArr = this.f277125d;
                        }
                        return true;
                    }
                }
            }
            stopNestedScroll(0);
            if (this.f277136j0 && this.Q == 0) {
                return true;
            }
        } else {
            x();
            this.E.addMovement(motionEvent);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        this.f277137m = 0;
        int paddingTop = getPaddingTop();
        int paddingLeft = getPaddingLeft();
        List<View> r16 = r();
        int size = r16.size();
        int i19 = 0;
        while (i19 < size) {
            View view = r16.get(i19);
            int measuredHeight = view.getMeasuredHeight() + paddingTop;
            int n3 = n(view, paddingLeft);
            view.layout(n3, paddingTop, view.getMeasuredWidth() + n3, measuredHeight);
            this.f277137m += view.getHeight();
            i19++;
            paddingTop = measuredHeight;
        }
        int measuredHeight2 = this.f277137m - ((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        this.f277137m = measuredHeight2;
        if (measuredHeight2 < 0) {
            this.f277137m = 0;
        }
        c(z16, false);
        R();
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        I();
        List<View> r16 = r();
        int size = r16.size();
        int i17 = 0;
        int i18 = 0;
        for (int i19 = 0; i19 < size; i19++) {
            View view = r16.get(i19);
            C(view, i3, i16);
            i17 = Math.max(i17, o(view));
            i18 += view.getMeasuredHeight();
        }
        setMeasuredDimension(D(i3, i17 + getPaddingLeft() + getPaddingRight()), D(i16, i18 + getPaddingTop() + getPaddingBottom()));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(@NonNull View view, float f16, float f17, boolean z16) {
        if (!z16) {
            dispatchNestedFling(0.0f, f17, true);
            l((int) f17);
            return true;
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(@NonNull View view, float f16, float f17) {
        return dispatchNestedPreFling(f16, f17);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedPreScroll(View view, int i3, int i16, int[] iArr) {
        onNestedPreScroll(view, i3, i16, iArr, 0);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScroll(@NonNull View view, int i3, int i16, int i17, int i18, int i19) {
        E(i18, i19);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScrollAccepted(@NonNull View view, @NonNull View view2, int i3, int i16) {
        this.S.onNestedScrollAccepted(view, view2, i3, i16);
        d(false, false);
        startNestedScroll(2, i16);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public boolean onStartNestedScroll(@NonNull View view, @NonNull View view2, int i3, int i16) {
        return (view.getLayoutParams() != null) && (i3 & 2) != 0;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onStopNestedScroll(@NonNull View view, int i3) {
        this.S.onStopNestedScroll(view, i3);
        stopNestedScroll(i3);
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0046, code lost:
    
        if (r0 != 6) goto L82;
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x01b7  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        VelocityTracker velocityTracker;
        int i3;
        boolean z16;
        if (c.l(this)) {
            return super.onTouchEvent(motionEvent);
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        boolean z17 = false;
        if (motionEvent.getActionMasked() == 0) {
            this.f277133h0 = 0;
        }
        obtain.offsetLocation(0.0f, this.f277133h0);
        int findPointerIndex = motionEvent.findPointerIndex(this.R);
        if (findPointerIndex < 0 || findPointerIndex >= motionEvent.getPointerCount()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                    if (actionMasked != 3) {
                        if (actionMasked != 5) {
                        }
                    } else {
                        h();
                        this.K = 0;
                        G();
                        Q(0);
                    }
                } else {
                    if (this.K == 0) {
                        this.K = (int) motionEvent.getY(findPointerIndex);
                        return true;
                    }
                    this.f277129f[1] = 0;
                    int y16 = (int) motionEvent.getY(findPointerIndex);
                    int i16 = this.K - y16;
                    this.K = y16;
                    if (dispatchNestedPreScroll(0, i16, this.f277129f, this.f277127e, 0)) {
                        i16 -= this.f277129f[1];
                        motionEvent.offsetLocation(0.0f, this.f277127e[1]);
                        int i17 = this.f277133h0;
                        int i18 = this.f277127e[1];
                        this.f277133h0 = i17 + i18;
                        this.K -= i18;
                        getParent().requestDisallowInterceptTouchEvent(true);
                    }
                    int i19 = this.C;
                    if (this.f277135i0 != 1) {
                        if (b() && Math.abs(i16) > 0) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        if (z16) {
                            Q(1);
                        }
                    }
                    if (this.f277135i0 == 1) {
                        g(i16);
                    }
                    int i26 = this.C - i19;
                    if (i26 != 0) {
                        getParent().requestDisallowInterceptTouchEvent(true);
                    }
                    int i27 = i16 - i26;
                    if (dispatchNestedScroll(0, i26, 0, i27, this.f277127e, 0)) {
                        int i28 = this.f277127e[1];
                        i27 += i28;
                        this.K -= i28;
                        this.f277133h0 += i28;
                        motionEvent.offsetLocation(0.0f, i28);
                        getParent().requestDisallowInterceptTouchEvent(true);
                    }
                    int s16 = s();
                    int overScrollMode = getOverScrollMode();
                    if (overScrollMode == 0 || (overScrollMode == 1 && s16 > 0)) {
                        z17 = true;
                    }
                    if (z17) {
                        i();
                        int i29 = i19 + i27;
                        if (i29 < 0) {
                            EdgeEffectCompat.onPull(this.f277126d0, i27 / getHeight(), motionEvent.getX(findPointerIndex) / getWidth());
                            if (!this.f277128e0.isFinished()) {
                                this.f277128e0.onRelease();
                            }
                        } else if (i29 > s16) {
                            EdgeEffectCompat.onPull(this.f277128e0, i27 / getHeight(), 1.0f - (motionEvent.getX(findPointerIndex) / getWidth()));
                            if (!this.f277126d0.isFinished()) {
                                this.f277126d0.onRelease();
                            }
                        }
                        if (!this.f277126d0.isFinished() || !this.f277128e0.isFinished()) {
                            ViewCompat.postInvalidateOnAnimation(this);
                        }
                    }
                }
            } else {
                h();
                this.K = 0;
                VelocityTracker velocityTracker2 = this.E;
                if (velocityTracker2 != null) {
                    velocityTracker2.addMovement(obtain);
                    this.E.computeCurrentVelocity(1000, this.H);
                    int yVelocity = (int) this.E.getYVelocity();
                    int i36 = this.H;
                    int max = Math.max(-i36, Math.min(yVelocity, i36));
                    if (max == 0 && (i3 = this.G) != 0) {
                        max = i3;
                    }
                    l(-max);
                    G();
                }
            }
            velocityTracker = this.E;
            if (velocityTracker != null) {
                velocityTracker.addMovement(obtain);
            }
            obtain.recycle();
            return true;
        }
        startNestedScroll(2, 0);
        this.K = (int) motionEvent.getY(findPointerIndex);
        velocityTracker = this.E;
        if (velocityTracker != null) {
        }
        obtain.recycle();
        return true;
    }

    @Override // android.view.View
    public void scrollBy(int i3, int i16) {
        scrollTo(0, this.C + i16);
    }

    @Override // android.view.View
    public void scrollTo(int i3, int i16) {
        g(i16 - this.C);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean z16) {
        this.T.setNestedScrollingEnabled(z16);
    }

    public void setOnVerticalScrollChangeListener(b bVar) {
        this.f277134i = bVar;
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean startNestedScroll(int i3, int i16) {
        return this.T.startNestedScroll(i3, i16);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public void stopNestedScroll(int i3) {
        this.T.stopNestedScroll(i3);
    }

    public ConsecutiveScrollerLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean dispatchNestedPreScroll(int i3, int i16, @Nullable int[] iArr, @Nullable int[] iArr2, int i17) {
        return this.T.dispatchNestedPreScroll(i3, i16, iArr, iArr2, i17);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean dispatchNestedScroll(int i3, int i16, int i17, int i18, @Nullable int[] iArr, int i19) {
        return this.T.dispatchNestedScroll(i3, i16, i17, i18, iArr, i19);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedPreScroll(@NonNull View view, int i3, int i16, @NonNull int[] iArr, int i17) {
        dispatchNestedPreScroll(i3, i16, iArr, null, i17);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScroll(View view, int i3, int i16, int i17, int i18) {
        E(i18, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onStartNestedScroll(View view, View view2, int i3) {
        return onStartNestedScroll(view, view2, i3, 0);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void stopNestedScroll() {
        stopNestedScroll(0);
    }

    public ConsecutiveScrollerLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f277125d = new int[2];
        this.f277127e = new int[2];
        this.f277129f = new int[2];
        this.f277132h = new ArrayList();
        this.N = new HashMap<>();
        this.P = false;
        this.Q = 0;
        this.R = -1;
        this.W = -1;
        this.f277122a0 = 0;
        this.f277123b0 = 0;
        this.f277124c0 = 0;
        this.f277131g0 = 0;
        this.f277133h0 = 0;
        this.f277135i0 = 0;
        this.f277136j0 = false;
        this.D = new OverScroller(getContext(), f277121k0);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.H = viewConfiguration.getScaledMaximumFlingVelocity();
        this.I = viewConfiguration.getScaledMinimumFlingVelocity();
        this.J = ViewConfiguration.getTouchSlop();
        setWillNotDraw(false);
        setVerticalScrollBarEnabled(true);
        this.S = new NestedScrollingParentHelper(this);
        this.T = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
        setChildrenDrawingOrderEnabled(true);
        setMotionEventSplittingEnabled(false);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onStopNestedScroll(View view) {
        onStopNestedScroll(view, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScrollAccepted(View view, View view2, int i3) {
        onNestedScrollAccepted(view, view2, i3, 0);
    }

    @Override // android.view.View
    @Deprecated
    public void setOnScrollChangeListener(View.OnScrollChangeListener onScrollChangeListener) {
    }
}
