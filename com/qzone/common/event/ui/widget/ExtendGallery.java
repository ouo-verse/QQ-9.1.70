package com.qzone.common.event.ui.widget;

import android.R;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Transformation;
import android.widget.Scroller;
import android.widget.SpinnerAdapter;
import com.qzone.common.event.ui.widget.ExtendAdapterView;

/* compiled from: P */
/* loaded from: classes39.dex */
public class ExtendGallery extends ExtendAbsSpinner implements GestureDetector.OnGestureListener {
    boolean A0;
    int B0;
    int C0;
    private ExtendGallery$OnScrollStateChangedListener$ScrollState D0;
    private int E0;
    private float F0;
    private int G0;
    private int H0;
    private int I0;
    private int J0;
    private int K0;
    private boolean L0;
    private boolean M0;

    /* renamed from: i0, reason: collision with root package name */
    private int f45911i0;

    /* renamed from: j0, reason: collision with root package name */
    private int f45912j0;

    /* renamed from: k0, reason: collision with root package name */
    private float f45913k0;

    /* renamed from: l0, reason: collision with root package name */
    private int f45914l0;

    /* renamed from: m0, reason: collision with root package name */
    private int f45915m0;

    /* renamed from: n0, reason: collision with root package name */
    private int f45916n0;

    /* renamed from: o0, reason: collision with root package name */
    private GestureDetector f45917o0;

    /* renamed from: p0, reason: collision with root package name */
    private int f45918p0;

    /* renamed from: q0, reason: collision with root package name */
    private View f45919q0;

    /* renamed from: r0, reason: collision with root package name */
    private FlingRunnable f45920r0;

    /* renamed from: s0, reason: collision with root package name */
    private Runnable f45921s0;

    /* renamed from: t0, reason: collision with root package name */
    private boolean f45922t0;

    /* renamed from: u0, reason: collision with root package name */
    private View f45923u0;

    /* renamed from: v0, reason: collision with root package name */
    private boolean f45924v0;

    /* renamed from: w0, reason: collision with root package name */
    private boolean f45925w0;

    /* renamed from: x0, reason: collision with root package name */
    private ExtendAdapterView.a f45926x0;

    /* renamed from: y0, reason: collision with root package name */
    private boolean f45927y0;

    /* renamed from: z0, reason: collision with root package name */
    private boolean f45928z0;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class LayoutParams extends ViewGroup.LayoutParams {
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(int i3, int i16) {
            super(i3, i16);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public ExtendGallery(Context context) {
        this(context, null);
    }

    private void C0() {
        View view = this.f45923u0;
        View childAt = getChildAt(this.J - this.f45900d);
        this.f45923u0 = childAt;
        if (childAt == null) {
            return;
        }
        childAt.setSelected(true);
        childAt.setFocusable(true);
        if (hasFocus()) {
            childAt.requestFocus();
        }
        if (view == null || view == childAt) {
            return;
        }
        view.setSelected(false);
        view.setFocusable(false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0035, code lost:
    
        if (r10.f45928z0 == false) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x006d, code lost:
    
        r2 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x006a, code lost:
    
        if (r10.f45928z0 != false) goto L31;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void Q(boolean z16) {
        int i3;
        int i16;
        int childCount = getChildCount();
        int i17 = this.f45900d;
        int i18 = 0;
        if (z16) {
            int paddingLeft = getPaddingLeft();
            int i19 = 0;
            i3 = 0;
            i16 = 0;
            while (i19 < childCount) {
                int i26 = this.f45928z0 ? (childCount - 1) - i19 : i19;
                View childAt = getChildAt(i26);
                if (childAt.getRight() >= paddingLeft) {
                    break;
                }
                i3++;
                this.f45893f0.c(i17 + i26, childAt);
                i19++;
                i16 = i26;
            }
        } else {
            int width = getWidth() - getPaddingRight();
            int i27 = childCount - 1;
            int i28 = i27;
            i3 = 0;
            i16 = 0;
            while (i28 >= 0) {
                int i29 = this.f45928z0 ? i27 - i28 : i28;
                View childAt2 = getChildAt(i29);
                if (childAt2.getLeft() <= width) {
                    break;
                }
                i3++;
                this.f45893f0.c(i17 + i29, childAt2);
                i28--;
                i16 = i29;
            }
        }
        detachViewsFromParent(i18, i3);
        if (z16 != this.f45928z0) {
            this.f45900d += i3;
        }
    }

    private boolean R(View view, int i3, long j3) {
        this.f45926x0 = new ExtendAdapterView.a(view, i3, j3);
        boolean showContextMenuForChild = super.showContextMenuForChild(this);
        if (showContextMenuForChild) {
            performHapticFeedback(0);
        }
        return showContextMenuForChild;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T() {
        int childCount = getChildCount();
        while (true) {
            childCount--;
            if (childCount >= 0) {
                getChildAt(childCount).setPressed(false);
            } else {
                setPressed(false);
                return;
            }
        }
    }

    private void U() {
        if (this.f45920r0.f45929d.isFinished()) {
            w0(false);
        }
    }

    private void V() {
        if (this.f45928z0) {
            X();
        } else {
            W();
        }
    }

    private void W() {
        int right;
        int i3;
        int i16 = this.f45911i0;
        int paddingLeft = getPaddingLeft();
        View childAt = getChildAt(0);
        if (childAt != null) {
            i3 = this.f45900d - 1;
            right = childAt.getLeft() - i16;
        } else {
            right = (getRight() - getLeft()) - getPaddingRight();
            this.f45922t0 = true;
            i3 = 0;
        }
        while (right > paddingLeft && i3 >= 0) {
            View p06 = p0(i3, i3 - this.J, right, false);
            this.f45900d = i3;
            right = p06.getLeft() - i16;
            i3--;
        }
    }

    private void X() {
        int i3;
        int right;
        int i16 = this.f45911i0;
        int paddingLeft = getPaddingLeft();
        int childCount = getChildCount();
        View childAt = getChildAt(childCount - 1);
        if (childAt != null) {
            i3 = this.f45900d + childCount;
            right = childAt.getLeft() - i16;
        } else {
            i3 = this.M - 1;
            this.f45900d = i3;
            right = (getRight() - getLeft()) - getPaddingRight();
            this.f45922t0 = true;
        }
        while (right > paddingLeft && i3 < this.M) {
            right = p0(i3, i3 - this.J, right, false).getLeft() - i16;
            i3++;
        }
    }

    private void Y() {
        if (this.f45928z0) {
            a0();
        } else {
            Z();
        }
    }

    private void Z() {
        int i3;
        int paddingLeft;
        int i16 = this.f45911i0;
        int right = (getRight() - getLeft()) - getPaddingRight();
        int childCount = getChildCount();
        int i17 = this.M;
        View childAt = getChildAt(childCount - 1);
        if (childAt != null) {
            i3 = this.f45900d + childCount;
            paddingLeft = childAt.getRight() + i16;
        } else {
            i3 = this.M - 1;
            this.f45900d = i3;
            paddingLeft = getPaddingLeft();
            this.f45922t0 = true;
        }
        while (paddingLeft < right && i3 < i17) {
            paddingLeft = p0(i3, i3 - this.J, paddingLeft, true).getRight() + i16;
            i3++;
        }
    }

    private void a0() {
        int paddingLeft;
        int i3 = this.f45911i0;
        int right = (getRight() - getLeft()) - getPaddingRight();
        int i16 = 0;
        View childAt = getChildAt(0);
        if (childAt != null) {
            i16 = this.f45900d - 1;
            paddingLeft = childAt.getRight() + i3;
        } else {
            paddingLeft = getPaddingLeft();
            this.f45922t0 = true;
        }
        while (paddingLeft < right && i16 >= 0) {
            View p06 = p0(i16, i16 - this.J, paddingLeft, true);
            this.f45900d = i16;
            paddingLeft = p06.getRight() + i3;
            i16--;
        }
    }

    private int b0() {
        return (((getWidth() - getPaddingLeft()) - getPaddingRight()) / 2) + getPaddingLeft();
    }

    private static int c0(View view) {
        return view.getLeft() + (view.getWidth() / 2);
    }

    private int d0(View view, boolean z16) {
        int i3 = this.f45911i0 / 2;
        if (z16) {
            return getPaddingLeft() + (view.getWidth() / 2) + i3;
        }
        return ((getWidth() - getPaddingRight()) - (view.getWidth() / 2)) - i3;
    }

    private int e0() {
        return getPaddingLeft();
    }

    private int g0() {
        return ((getWidth() - getPaddingLeft()) - getPaddingRight()) - 1;
    }

    private int h0() {
        if (this.G0 == 0) {
            float f16 = this.F0;
            if (f16 > 0.0f) {
                int i3 = 0;
                if (f16 >= 0.0f) {
                    if (getChildCount() > 0) {
                        int i16 = 0;
                        for (int i17 = 0; i17 < getChildCount(); i17++) {
                            View childAt = getChildAt(i17);
                            i16 += childAt == null ? 0 : childAt.getWidth();
                        }
                        i3 = i16 / getChildCount();
                    }
                    int g06 = g0();
                    i3 = (int) (f16 * i3);
                    if (i3 > g06) {
                        i3 = g06;
                    }
                }
                this.G0 = i3;
            }
        }
        return this.G0;
    }

    private int i0() {
        return getWidth() - getPaddingRight();
    }

    private boolean j0(View view) {
        int e06 = e0();
        return view.getLeft() < e06 && view.getRight() > e06;
    }

    private boolean k0(View view) {
        int i06 = i0();
        return view.getLeft() < i06 && view.getRight() > i06;
    }

    private boolean l0() {
        View childAt = getChildAt(0 - this.f45900d);
        return childAt != null && childAt.getLeft() - (this.f45911i0 / 2) > e0();
    }

    private boolean m0() {
        if (getChildCount() == 0) {
            return true;
        }
        View childAt = getChildAt(0 - this.f45900d);
        View childAt2 = getChildAt((this.M - 1) - this.f45900d);
        if (childAt == null || childAt2 == null) {
            return false;
        }
        return childAt2.getRight() - childAt.getLeft() < ((getWidth() - getPaddingLeft()) - getPaddingRight()) - this.f45911i0;
    }

    private boolean n0() {
        return l0() || o0();
    }

    private boolean o0() {
        View childAt = getChildAt((this.M - 1) - this.f45900d);
        return childAt != null && childAt.getRight() + (this.f45911i0 / 2) < i0();
    }

    private View p0(int i3, int i16, int i17, boolean z16) {
        View b16;
        if (!this.G && (b16 = this.f45893f0.b(i3)) != null) {
            int left = b16.getLeft();
            this.f45915m0 = Math.max(this.f45915m0, b16.getMeasuredWidth() + left);
            this.f45914l0 = Math.min(this.f45914l0, left);
            z0(b16, i16, i17, z16);
            return b16;
        }
        SpinnerAdapter spinnerAdapter = this.T;
        if (spinnerAdapter != null) {
            View view = spinnerAdapter.getView(i3, null, this);
            z0(view, i16, i17, z16);
            return view;
        }
        return new View(getContext());
    }

    private void s0(int i3) {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            getChildAt(childCount).offsetLeftAndRight(i3);
        }
    }

    private void u0() {
        if (this.f45924v0) {
            this.f45924v0 = false;
            super.s();
        }
        invalidate();
        ExtendGallery$OnScrollStateChangedListener$ScrollState extendGallery$OnScrollStateChangedListener$ScrollState = this.D0;
        ExtendGallery$OnScrollStateChangedListener$ScrollState extendGallery$OnScrollStateChangedListener$ScrollState2 = ExtendGallery$OnScrollStateChangedListener$ScrollState.SCROLL_STATE_IDLE;
        if (extendGallery$OnScrollStateChangedListener$ScrollState != extendGallery$OnScrollStateChangedListener$ScrollState2) {
            this.D0 = extendGallery$OnScrollStateChangedListener$ScrollState2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0093  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void w0(boolean z16) {
        int i3;
        int d06;
        int i16;
        if (getChildCount() == 0) {
            return;
        }
        View view = this.f45923u0;
        int c06 = view == null ? 0 : c0(view);
        int i17 = this.E0;
        if (i17 != 1) {
            if (i17 == 2) {
                if (z16) {
                    View view2 = this.f45923u0;
                    if (view2 == null) {
                        return;
                    }
                    if (j0(view2)) {
                        d06 = d0(this.f45923u0, true);
                    } else if (k0(this.f45923u0)) {
                        d06 = d0(this.f45923u0, false);
                    }
                } else if (n0()) {
                    boolean l06 = l0();
                    if (!l06 && m0()) {
                        View childAt = getChildAt(0);
                        if (childAt != null) {
                            c06 = c0(childAt);
                            d06 = d0(childAt, true);
                        } else {
                            d06 = c06;
                        }
                    } else {
                        View childAt2 = getChildAt(l06 ? 0 : getChildCount() - 1);
                        if (childAt2 != null) {
                            c06 = c0(childAt2);
                            d06 = d0(childAt2, l06);
                        }
                    }
                }
                i16 = c06 - i3;
                if (i16 != 0) {
                    this.f45920r0.e(z16);
                    this.f45920r0.g(i16);
                    return;
                } else {
                    u0();
                    return;
                }
            }
            i3 = c06;
            i16 = c06 - i3;
            if (i16 != 0) {
            }
        } else if (this.f45923u0 == null) {
            return;
        } else {
            d06 = b0();
        }
        int i18 = d06;
        i3 = c06;
        c06 = i18;
        i16 = c06 - i3;
        if (i16 != 0) {
        }
    }

    private boolean x0(int i3) {
        int childCount;
        View childAt = getChildAt(i3);
        if (childAt == null) {
            return false;
        }
        if (this.E0 == 2) {
            int i16 = this.f45900d + i3;
            if (i16 != this.J) {
                u(i16);
                t(i16);
                d();
            }
            if (i3 > 0) {
                if (m0()) {
                    childCount = getChildCount();
                } else {
                    childCount = getChildCount() - 1;
                }
                if (i3 < childCount) {
                    return true;
                }
            }
            int d06 = d0(childAt, i3 <= 0) - c0(childAt);
            this.f45920r0.e(true);
            this.f45920r0.g(d06);
            return true;
        }
        this.f45920r0.g(b0() - c0(childAt));
        return true;
    }

    private void y0() {
        View view = this.f45923u0;
        if (view == null) {
            return;
        }
        int b06 = b0();
        if (view.getLeft() > b06 || view.getRight() < b06) {
            int childCount = getChildCount() - 1;
            int i3 = Integer.MAX_VALUE;
            int i16 = 0;
            while (true) {
                if (childCount < 0) {
                    childCount = i16;
                    break;
                }
                View childAt = getChildAt(childCount);
                if (childAt.getLeft() <= b06 && childAt.getRight() >= b06) {
                    break;
                }
                int min = Math.min(Math.abs(childAt.getLeft() - b06), Math.abs(childAt.getRight() - b06));
                if (min < i3) {
                    i16 = childCount;
                    i3 = min;
                }
                childCount--;
            }
            int i17 = this.f45900d + childCount;
            if (i17 != this.J) {
                u(i17);
                t(i17);
                d();
            }
        }
    }

    private void z0(View view, int i3, int i16, boolean z16) {
        LayoutParams layoutParams;
        int i17;
        try {
            layoutParams = (LayoutParams) view.getLayoutParams();
        } catch (ClassCastException unused) {
            layoutParams = null;
        }
        if (layoutParams == null) {
            layoutParams = (LayoutParams) generateDefaultLayoutParams();
        }
        addViewInLayout(view, z16 != this.f45928z0 ? -1 : 0, layoutParams);
        view.setSelected(i3 == 0);
        int i18 = this.U;
        Rect rect = this.f45892e0;
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i18, rect.top + rect.bottom, ((ViewGroup.LayoutParams) layoutParams).height);
        int i19 = this.V;
        Rect rect2 = this.f45892e0;
        view.measure(ViewGroup.getChildMeasureSpec(i19, rect2.left + rect2.right, ((ViewGroup.LayoutParams) layoutParams).width), childMeasureSpec);
        int P = P(view, true);
        int measuredHeight = view.getMeasuredHeight() + P;
        int measuredWidth = view.getMeasuredWidth();
        if (z16) {
            i17 = measuredWidth + i16;
        } else {
            int i26 = i16 - measuredWidth;
            i17 = i16;
            i16 = i26;
        }
        view.layout(i16, P, i17, measuredHeight);
    }

    void A0(int i3) {
        int i16;
        int i17;
        if (getChildCount() == 0) {
            return;
        }
        boolean z16 = i3 < 0;
        int f06 = f0(z16, i3);
        if (f06 != i3) {
            this.f45920r0.d(false);
            u0();
        }
        s0(f06);
        Q(z16);
        if (z16) {
            Y();
        } else {
            V();
        }
        this.f45893f0.a();
        int i18 = this.E0;
        if (i18 == 1) {
            y0();
        } else if (i18 == 2 && (i16 = this.J) >= (i17 = this.f45900d) && i16 <= (i17 + getChildCount()) - 1) {
            C0();
        }
        ExtendGallery$OnScrollStateChangedListener$ScrollState extendGallery$OnScrollStateChangedListener$ScrollState = ExtendGallery$OnScrollStateChangedListener$ScrollState.SCROLL_STATE_FLING;
        if (extendGallery$OnScrollStateChangedListener$ScrollState != this.D0) {
            this.D0 = extendGallery$OnScrollStateChangedListener$ScrollState;
        }
        onScrollChanged(0, 0, 0, 0);
        invalidate();
    }

    @Override // com.qzone.common.event.ui.widget.ExtendAbsSpinner
    void B(int i3, boolean z16) {
        int i16;
        int i17;
        this.f45928z0 = o();
        int i18 = this.f45892e0.left;
        int right = getRight() - getLeft();
        Rect rect = this.f45892e0;
        int i19 = (right - rect.left) - rect.right;
        if (this.G) {
            m();
        }
        if (this.M == 0) {
            E();
            return;
        }
        int h16 = this.G ? -1 : h();
        int i26 = this.H;
        if (i26 >= 0) {
            u(i26);
        }
        D();
        detachAllViewsFromParent();
        this.f45915m0 = 0;
        this.f45914l0 = 0;
        if (this.E0 == 2) {
            int i27 = this.f45911i0 / 2;
            int e06 = e0();
            int i06 = i0();
            int i28 = e06 + i27;
            if (i3 != 0) {
                int i29 = this.J;
                if (i29 < this.f45900d || i29 > h16) {
                    this.f45900d = i29;
                    i17 = i29;
                } else {
                    i17 = 0;
                }
                View p06 = p0(i17, i17 - i29, 0, true);
                if (this.J > h16) {
                    i28 = (i06 - p06.getWidth()) - i27;
                }
                p06.offsetLeftAndRight(i28);
            } else {
                int i36 = this.J0;
                if (i36 >= i06 || this.K0 <= e06) {
                    i16 = 0;
                } else {
                    i16 = this.f45900d;
                    i28 = i36;
                }
                p0(i16, i16 - this.J, 0, true).offsetLeftAndRight(i28);
            }
        } else {
            int i37 = this.J;
            this.f45900d = i37;
            View p07 = p0(i37, 0, 0, true);
            p07.offsetLeftAndRight((i18 + (i19 / 2)) - (p07.getWidth() / 2));
        }
        Y();
        V();
        this.f45893f0.a();
        invalidate();
        d();
        this.G = false;
        this.f45905m = false;
        t(this.J);
        C0();
        B0();
        if (this.E0 == 2) {
            U();
        }
    }

    public void O() {
        if (this.A0) {
            View childAt = getChildAt(this.B0 - this.f45900d);
            if (childAt != null) {
                x0(this.B0 - this.f45900d);
                int i3 = this.B0;
                q(childAt, i3, this.T.getItemId(i3), null);
            }
            this.A0 = false;
        }
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // android.view.View
    protected int computeHorizontalScrollExtent() {
        return 1;
    }

    @Override // android.view.View
    protected int computeHorizontalScrollOffset() {
        return this.J;
    }

    @Override // android.view.View
    protected int computeHorizontalScrollRange() {
        return this.M;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return keyEvent.dispatch(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z16) {
        View view = this.f45923u0;
        if (view != null) {
            view.setPressed(z16);
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        View view = this.f45923u0;
        if (view != null) {
            this.H0 = view.getLeft();
            this.I0 = this.f45923u0.getRight();
        }
        B0();
    }

    int f0(boolean z16, int i3) {
        View childAt = getChildAt((z16 != this.f45928z0 ? this.M - 1 : 0) - this.f45900d);
        if (childAt == null) {
            return i3;
        }
        if (this.E0 == 2) {
            int h06 = h0();
            int i16 = this.f45911i0 / 2;
            if (z16) {
                if (m0()) {
                    View childAt2 = getChildAt(0);
                    int left = childAt2 != null ? (childAt2.getLeft() - i16) - e0() : 0;
                    return Math.max(left > 0 ? -left : 0, i3);
                }
                if (childAt.getRight() + i16 <= i0() - h06) {
                    return 0;
                }
            } else if (childAt.getLeft() - i16 >= e0() + h06) {
                return 0;
            }
            int d06 = d0(childAt, !z16) - c0(childAt);
            if (z16) {
                return Math.max(d06 - h06, i3);
            }
            return Math.min(d06 + h06, i3);
        }
        int c06 = c0(childAt);
        int b06 = b0();
        if (z16) {
            if (c06 <= b06) {
                return 0;
            }
        } else if (c06 >= b06) {
            return 0;
        }
        int i17 = b06 - c06;
        if (z16) {
            return Math.max(i17, i3);
        }
        return Math.min(i17, i3);
    }

    @Override // com.qzone.common.event.ui.widget.ExtendAbsSpinner, android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i3, int i16) {
        int i17 = this.J - this.f45900d;
        return (i17 >= 0 && i17 < i3) ? i16 == i3 + (-1) ? i17 : i16 >= i17 ? i16 + 1 : i16 : i16;
    }

    @Override // android.view.ViewGroup
    protected boolean getChildStaticTransformation(View view, Transformation transformation) {
        transformation.clear();
        transformation.setAlpha(view == this.f45923u0 ? 1.0f : this.f45913k0);
        return true;
    }

    @Override // android.view.View
    protected ContextMenu.ContextMenuInfo getContextMenuInfo() {
        return this.f45926x0;
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.H0 = 0;
        this.I0 = 0;
        this.J0 = 0;
        this.K0 = 0;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        this.f45920r0.i(false);
        int C = C((int) motionEvent.getX(), (int) motionEvent.getY());
        this.f45918p0 = C;
        if (C >= 0) {
            View childAt = getChildAt(C - this.f45900d);
            this.f45919q0 = childAt;
            childAt.setPressed(true);
        }
        this.f45927y0 = true;
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
        this.f45920r0.e(false);
        this.f45920r0.h((int) (-f16));
        return true;
    }

    @Override // android.view.View
    protected void onFocusChanged(boolean z16, int i3, Rect rect) {
        View view;
        super.onFocusChanged(z16, i3, rect);
        if (!z16 || (view = this.f45923u0) == null) {
            return;
        }
        view.requestFocus(i3);
        this.f45923u0.setSelected(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.common.event.ui.widget.ExtendAdapterView, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
        this.E = true;
        B(0, false);
        this.E = false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        int i3;
        if (this.f45918p0 < 0) {
            return;
        }
        performHapticFeedback(0);
        long g16 = g(this.f45918p0);
        if (this.L0 && (i3 = this.f45918p0) >= 0) {
            x0(i3 - this.f45900d);
        }
        R(this.f45919q0, this.f45918p0, g16);
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
        getParent().requestDisallowInterceptTouchEvent(true);
        if (this.f45924v0) {
            this.f45924v0 = false;
        }
        A0(((int) f16) * (-1));
        this.f45927y0 = false;
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        int i3 = this.f45918p0;
        if (i3 < 0) {
            return false;
        }
        if (this.M0) {
            x0(i3 - this.f45900d);
        }
        View view = this.f45919q0;
        int i16 = this.f45918p0;
        q(view, i16, this.T.getItemId(i16), motionEvent);
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = this.f45917o0.onTouchEvent(motionEvent);
        int action = motionEvent.getAction();
        if (action == 1) {
            v0();
        } else if (action == 3) {
            t0();
        }
        return onTouchEvent;
    }

    boolean q0() {
        int i3;
        int i16 = this.M;
        if (i16 <= 0 || (i3 = this.J) >= i16 - 1) {
            return false;
        }
        x0((i3 - this.f45900d) + 1);
        return true;
    }

    boolean r0() {
        int i3;
        if (this.M <= 0 || (i3 = this.J) <= 0) {
            return false;
        }
        x0((i3 - this.f45900d) - 1);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.qzone.common.event.ui.widget.ExtendAdapterView
    public void s() {
        if (this.f45924v0) {
            return;
        }
        super.s();
    }

    public void setAnimationDuration(int i3) {
        this.f45912j0 = i3;
    }

    public void setGalleryMode(int i3) {
        this.E0 = i3;
    }

    public void setGravity(int i3) {
        if (this.f45916n0 != i3) {
            this.f45916n0 = i3;
            requestLayout();
        }
    }

    public void setOverScrollRatio(float f16) {
        if (this.F0 == f16) {
            return;
        }
        if (f16 < 0.0f) {
            f16 = 0.0f;
        }
        this.F0 = f16;
        this.G0 = 0;
    }

    public void setSpacing(int i3) {
        this.f45911i0 = i3;
    }

    public void setUnselectedAlpha(float f16) {
        this.f45913k0 = f16;
    }

    @Override // android.view.View
    public boolean showContextMenu() {
        int i3;
        if (!isPressed() || (i3 = this.J) < 0) {
            return false;
        }
        return R(getChildAt(i3 - this.f45900d), this.J, this.K);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean showContextMenuForChild(View view) {
        int i3 = i(view);
        if (i3 < 0) {
            return false;
        }
        return R(view, i3, this.T.getItemId(i3));
    }

    void t0() {
        v0();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.qzone.common.event.ui.widget.ExtendAdapterView
    public void u(int i3) {
        super.u(i3);
        C0();
    }

    void v0() {
        if (this.f45920r0.f45929d.isFinished()) {
            w0(false);
        }
        T();
    }

    @Override // com.qzone.common.event.ui.widget.ExtendAbsSpinner
    int y(View view) {
        return view.getMeasuredHeight();
    }

    public ExtendGallery(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.galleryStyle);
    }

    private void B0() {
        View childAt = getChildAt(0);
        if (childAt != null) {
            this.J0 = childAt.getLeft();
            this.K0 = childAt.getRight();
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class FlingRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private Scroller f45929d;

        /* renamed from: e, reason: collision with root package name */
        private int f45930e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f45931f = false;

        public FlingRunnable() {
            this.f45929d = new Scroller(ExtendGallery.this.getContext());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d(boolean z16) {
            this.f45929d.forceFinished(true);
            if (z16) {
                ExtendGallery.this.w0(this.f45931f);
            }
            this.f45931f = false;
            ExtendGallery.this.O();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void e(boolean z16) {
            this.f45931f = z16;
        }

        private void f() {
            ExtendGallery.this.removeCallbacks(this);
        }

        public void i(boolean z16) {
            ExtendGallery.this.removeCallbacks(this);
            d(z16);
        }

        @Override // java.lang.Runnable
        public void run() {
            int childCount;
            int max;
            int i3;
            ExtendGallery extendGallery = ExtendGallery.this;
            if (extendGallery.M != 0) {
                extendGallery.f45922t0 = false;
                Scroller scroller = this.f45929d;
                boolean computeScrollOffset = scroller.computeScrollOffset();
                int currX = scroller.getCurrX();
                int i16 = this.f45930e - currX;
                if (i16 > 0) {
                    ExtendGallery extendGallery2 = ExtendGallery.this;
                    if (extendGallery2.f45928z0) {
                        ExtendGallery extendGallery3 = ExtendGallery.this;
                        i3 = (extendGallery3.f45900d + extendGallery3.getChildCount()) - 1;
                    } else {
                        i3 = ExtendGallery.this.f45900d;
                    }
                    extendGallery2.f45918p0 = i3;
                    max = Math.min(((ExtendGallery.this.getWidth() - ExtendGallery.this.getPaddingLeft()) - ExtendGallery.this.getPaddingRight()) - 1, i16);
                } else {
                    ExtendGallery.this.getChildCount();
                    ExtendGallery extendGallery4 = ExtendGallery.this;
                    if (extendGallery4.f45928z0) {
                        childCount = ExtendGallery.this.f45900d;
                    } else {
                        ExtendGallery extendGallery5 = ExtendGallery.this;
                        childCount = (extendGallery5.f45900d + extendGallery5.getChildCount()) - 1;
                    }
                    extendGallery4.f45918p0 = childCount;
                    max = Math.max(-(((ExtendGallery.this.getWidth() - ExtendGallery.this.getPaddingRight()) - ExtendGallery.this.getPaddingLeft()) - 1), i16);
                }
                ExtendGallery.this.A0(max);
                if (computeScrollOffset && !ExtendGallery.this.f45922t0) {
                    this.f45930e = currX;
                    ExtendGallery.this.post(this);
                    return;
                } else {
                    d(true);
                    return;
                }
            }
            d(true);
        }

        public void g(int i3) {
            if (i3 == 0) {
                return;
            }
            f();
            this.f45930e = 0;
            this.f45929d.startScroll(0, 0, -i3, 0, ExtendGallery.this.f45912j0);
            ExtendGallery.this.post(this);
        }

        public void h(int i3) {
            if (i3 == 0) {
                return;
            }
            f();
            int i16 = i3 < 0 ? Integer.MAX_VALUE : 0;
            this.f45930e = i16;
            this.f45929d.fling(i16, 0, i3, 0, 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE);
            ExtendGallery.this.post(this);
        }
    }

    public ExtendGallery(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f45911i0 = 0;
        this.f45912j0 = 400;
        this.f45920r0 = new FlingRunnable();
        this.f45921s0 = new Runnable() { // from class: com.qzone.common.event.ui.widget.ExtendGallery.1
            @Override // java.lang.Runnable
            public void run() {
                ExtendGallery.this.f45924v0 = false;
                ExtendGallery.this.s();
            }
        };
        this.f45928z0 = true;
        this.A0 = false;
        this.B0 = 0;
        this.C0 = 0;
        this.D0 = ExtendGallery$OnScrollStateChangedListener$ScrollState.SCROLL_STATE_IDLE;
        this.E0 = 1;
        this.F0 = 0.0f;
        this.G0 = 0;
        this.H0 = 0;
        this.I0 = 0;
        this.J0 = 0;
        this.K0 = 0;
        this.L0 = false;
        this.M0 = true;
        GestureDetector gestureDetector = new GestureDetector(context, this);
        this.f45917o0 = gestureDetector;
        gestureDetector.setIsLongpressEnabled(true);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.tencent.mobileqq.R.styleable.ExtendGallery, i3, 0);
        int i16 = obtainStyledAttributes.getInt(1, -1);
        if (i16 >= 0) {
            setGravity(i16);
        }
        int i17 = obtainStyledAttributes.getInt(0, -1);
        if (i17 > 0) {
            setAnimationDuration(i17);
        }
        setSpacing(obtainStyledAttributes.getDimensionPixelOffset(2, 0));
        setUnselectedAlpha(obtainStyledAttributes.getFloat(3, 0.5f));
        obtainStyledAttributes.recycle();
        setChildrenDrawingOrderEnabled(true);
        setStaticTransformationsEnabled(true);
    }

    private int P(View view, boolean z16) {
        int height;
        int height2;
        if (z16) {
            height = getMeasuredHeight();
        } else {
            height = getHeight();
        }
        if (z16) {
            height2 = view.getMeasuredHeight();
        } else {
            height2 = view.getHeight();
        }
        int i3 = this.f45916n0;
        if (i3 == 16) {
            Rect rect = this.f45892e0;
            int i16 = height - rect.bottom;
            int i17 = rect.top;
            return i17 + (((i16 - i17) - height2) / 2);
        }
        if (i3 == 48) {
            return this.f45892e0.top;
        }
        if (i3 != 80) {
            return 0;
        }
        return (height - this.f45892e0.bottom) - height2;
    }

    private void S(View view) {
        if (view != null) {
            view.setPressed(true);
        }
        setPressed(true);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i3, KeyEvent keyEvent) {
        if (i3 != 23 && i3 != 66) {
            return super.onKeyUp(i3, keyEvent);
        }
        if (this.f45925w0 && this.M > 0) {
            S(this.f45923u0);
            postDelayed(new Runnable() { // from class: com.qzone.common.event.ui.widget.ExtendGallery.2
                @Override // java.lang.Runnable
                public void run() {
                    ExtendGallery.this.T();
                }
            }, ViewConfiguration.getPressedStateDuration());
            View childAt = getChildAt(this.J - this.f45900d);
            int i16 = this.J;
            q(childAt, i16, this.T.getItemId(i16), null);
        }
        this.f45925w0 = false;
        return true;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i3, KeyEvent keyEvent) {
        if (i3 != 66) {
            switch (i3) {
                case 21:
                    if (r0()) {
                        playSoundEffect(1);
                    }
                    return true;
                case 22:
                    if (q0()) {
                        playSoundEffect(3);
                    }
                    return true;
            }
            return super.onKeyDown(i3, keyEvent);
        }
        this.f45925w0 = true;
        return super.onKeyDown(i3, keyEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchSetSelected(boolean z16) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }
}
