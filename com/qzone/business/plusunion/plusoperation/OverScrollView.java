package com.qzone.business.plusunion.plusoperation;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.OvershootInterpolator;
import android.widget.FrameLayout;
import android.widget.Scroller;
import com.qzone.proxy.feedcomponent.util.j;
import com.tencent.mobileqq.utils.ViewUtils;
import java.lang.reflect.Field;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes39.dex */
public class OverScrollView extends FrameLayout implements View.OnTouchListener {
    boolean C;
    int D;
    public boolean E;
    DisplayMetrics F;
    protected View G;
    private Runnable H;
    private boolean I;
    private float J;
    private boolean K;
    private View L;
    private boolean M;
    private VelocityTracker N;
    private boolean P;
    private boolean Q;
    private int R;
    private int S;
    private int T;
    private int U;

    /* renamed from: d, reason: collision with root package name */
    private long f44637d;

    /* renamed from: e, reason: collision with root package name */
    private final Rect f44638e;

    /* renamed from: f, reason: collision with root package name */
    private Scroller f44639f;

    /* renamed from: h, reason: collision with root package name */
    protected Context f44640h;

    /* renamed from: i, reason: collision with root package name */
    Field f44641i;

    /* renamed from: m, reason: collision with root package name */
    Field f44642m;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public interface a {
    }

    public OverScrollView(Context context) {
        this(context, null);
    }

    private void A(MotionEvent motionEvent) {
        int action = (motionEvent.getAction() & 65280) >> 8;
        if (motionEvent.getPointerId(action) == this.U) {
            int i3 = action == 0 ? 1 : 0;
            this.J = motionEvent.getY(i3);
            this.U = motionEvent.getPointerId(i3);
            VelocityTracker velocityTracker = this.N;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    private boolean B() {
        int z16;
        int height = getHeight();
        int paddingTop = this.G.getPaddingTop();
        int height2 = this.G.getHeight() - this.G.getPaddingBottom();
        int scrollY = getScrollY();
        if (scrollY < paddingTop) {
            z(scrollY);
            z16 = paddingTop - scrollY;
        } else if (scrollY + height > height2) {
            int i3 = (this.G.getHeight() - this.G.getPaddingTop()) - this.G.getPaddingBottom() < height ? paddingTop - scrollY : (height2 - height) - scrollY;
            if (i3 >= (-ViewUtils.dip2px(70.0f))) {
                z16 = i3 + z(scrollY);
            } else {
                throw null;
            }
        } else {
            this.E = true;
            return false;
        }
        this.f44639f.startScroll(0, scrollY, 0, z16, 500);
        post(this.H);
        this.D = scrollY;
        return true;
    }

    private boolean D(int i3, int i16, int i17) {
        int height = getHeight();
        int scrollY = getScrollY();
        int i18 = height + scrollY;
        boolean z16 = true;
        boolean z17 = i3 == 33;
        View l3 = l(z17, i16, i17);
        if (l3 == null) {
            l3 = this;
        }
        if (i16 < scrollY || i17 > i18) {
            j(z17 ? i16 - scrollY : i17 - i18);
        } else {
            z16 = false;
        }
        if (l3 != findFocus() && l3.requestFocus(i3)) {
            this.I = false;
        }
        return z16;
    }

    private void E(View view) {
        view.getDrawingRect(this.f44638e);
        offsetDescendantRectToMyCoords(view, this.f44638e);
        int i3 = i(this.f44638e);
        if (i3 != 0) {
            scrollBy(0, i3);
        }
    }

    private boolean F(Rect rect, boolean z16) {
        int i3 = i(rect);
        boolean z17 = i3 != 0;
        if (z17) {
            if (z16) {
                scrollBy(0, i3);
            } else {
                G(0, i3);
            }
        }
        return z17;
    }

    private void d(int i3) {
        Field field = this.f44642m;
        if (field != null) {
            try {
                field.setInt(this, i3);
            } catch (Exception unused) {
            }
        }
    }

    private void e(int i3) {
        Field field = this.f44641i;
        if (field != null) {
            try {
                field.setInt(this, i3);
            } catch (Exception unused) {
            }
        }
    }

    private int h(int i3, int i16, int i17) {
        if (i16 < i17 && i3 >= 0) {
            if (i16 + i3 > i17) {
                return i17 - i16;
            }
            return i3;
        }
        return 0;
    }

    private View m(boolean z16, int i3, View view) {
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength() / 2;
        int i16 = i3 + verticalFadingEdgeLength;
        int height = (i3 + getHeight()) - verticalFadingEdgeLength;
        return (view == null || view.getTop() >= height || view.getBottom() <= i16) ? l(z16, i16, height) : view;
    }

    private void r() {
        this.F = this.f44640h.getResources().getDisplayMetrics();
        this.f44639f = new Scroller(getContext(), new OvershootInterpolator(0.75f));
        this.H = new Runnable() { // from class: com.qzone.business.plusunion.plusoperation.OverScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                OverScrollView.this.f44639f.computeScrollOffset();
                OverScrollView overScrollView = OverScrollView.this;
                overScrollView.scrollTo(0, overScrollView.f44639f.getCurrY());
                if (OverScrollView.this.f44639f.isFinished()) {
                    return;
                }
                OverScrollView.this.post(this);
            }
        };
        this.D = getPaddingTop();
        try {
            this.f44642m = View.class.getDeclaredField("mScrollX");
            this.f44641i = View.class.getDeclaredField("mScrollY");
        } catch (Exception unused) {
            this.C = true;
        }
    }

    private void t() {
        this.f44639f = new Scroller(getContext());
        setFocusable(true);
        setDescendantFocusability(262144);
        setWillNotDraw(false);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(this.f44640h);
        this.R = viewConfiguration.getScaledTouchSlop();
        this.S = viewConfiguration.getScaledMinimumFlingVelocity();
        this.T = viewConfiguration.getScaledMaximumFlingVelocity();
        setOnTouchListener(this);
        post(new Runnable() { // from class: com.qzone.business.plusunion.plusoperation.b
            @Override // java.lang.Runnable
            public final void run() {
                OverScrollView.this.x();
            }
        });
    }

    private boolean w(View view, int i3, int i16) {
        view.getDrawingRect(this.f44638e);
        offsetDescendantRectToMyCoords(view, this.f44638e);
        return this.f44638e.bottom + i3 >= getScrollY() && this.f44638e.top - i3 <= getScrollY() + i16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x() {
        scrollTo(0, this.G.getPaddingTop());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y() {
        scrollTo(0, this.G.getPaddingTop());
    }

    public final void G(int i3, int i16) {
        if (getChildCount() == 0) {
            return;
        }
        if (AnimationUtils.currentAnimationTimeMillis() - this.f44637d > 250) {
            int max = Math.max(0, getChildAt(0).getHeight() - ((getHeight() - getPaddingBottom()) - getPaddingTop()));
            int scrollY = getScrollY();
            this.f44639f.startScroll(getScrollX(), scrollY, 0, Math.max(0, Math.min(i16 + scrollY, max)) - scrollY);
            invalidate();
        } else {
            if (!this.f44639f.isFinished()) {
                this.f44639f.abortAnimation();
            }
            scrollBy(i3, i16);
        }
        this.f44637d = AnimationUtils.currentAnimationTimeMillis();
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        if (getChildCount() <= 0) {
            super.addView(view);
            s();
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.C) {
            super.computeScroll();
            return;
        }
        if (this.f44639f.computeScrollOffset()) {
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.f44639f.getCurrX();
            int currY = this.f44639f.getCurrY();
            if (getChildCount() > 0) {
                View childAt = getChildAt(0);
                int h16 = h(currX, (getWidth() - getPaddingRight()) - getPaddingLeft(), childAt.getWidth());
                int h17 = h(currY, (getHeight() - getPaddingBottom()) - getPaddingTop(), childAt.getHeight());
                if (h16 != scrollX || h17 != scrollY) {
                    d(h16);
                    e(h17);
                    onScrollChanged(h16, h17, scrollX, scrollY);
                }
            }
            awakenScrollBars();
            postInvalidate();
        }
    }

    @Override // android.view.View
    protected int computeVerticalScrollRange() {
        return getChildCount() == 0 ? (getHeight() - getPaddingBottom()) - getPaddingTop() : getChildAt(0).getBottom();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || k(keyEvent);
    }

    public boolean f(int i3) {
        int bottom;
        View findFocus = findFocus();
        if (findFocus == this) {
            findFocus = null;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, i3);
        int p16 = p();
        if (findNextFocus != null && w(findNextFocus, p16, getHeight())) {
            findNextFocus.getDrawingRect(this.f44638e);
            offsetDescendantRectToMyCoords(findNextFocus, this.f44638e);
            j(i(this.f44638e));
            findNextFocus.requestFocus(i3);
        } else {
            if (i3 == 33 && getScrollY() < p16) {
                p16 = getScrollY();
            } else if (i3 == 130 && getChildCount() > 0 && (bottom = getChildAt(0).getBottom() - (getScrollY() + getHeight())) < p16) {
                p16 = bottom;
            }
            if (p16 == 0) {
                return false;
            }
            if (i3 != 130) {
                p16 = -p16;
            }
            j(p16);
        }
        if (findFocus == null || !findFocus.isFocused() || !u(findFocus)) {
            return true;
        }
        int descendantFocusability = getDescendantFocusability();
        setDescendantFocusability(131072);
        requestFocus();
        setDescendantFocusability(descendantFocusability);
        return true;
    }

    @Override // android.view.View
    protected float getBottomFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int bottom = (getChildAt(0).getBottom() - getScrollY()) - (getHeight() - getPaddingBottom());
        if (bottom < verticalFadingEdgeLength) {
            return bottom / verticalFadingEdgeLength;
        }
        return 1.0f;
    }

    @Override // android.view.View
    protected float getTopFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        if (getScrollY() < verticalFadingEdgeLength) {
            return getScrollY() / verticalFadingEdgeLength;
        }
        return 1.0f;
    }

    protected int i(Rect rect) {
        int i3;
        int i16;
        if (getChildCount() == 0) {
            return 0;
        }
        int height = getHeight();
        int scrollY = getScrollY();
        int i17 = scrollY + height;
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        if (rect.top > 0) {
            scrollY += verticalFadingEdgeLength;
        }
        if (rect.bottom < getChildAt(0).getHeight()) {
            i17 -= verticalFadingEdgeLength;
        }
        int i18 = rect.bottom;
        if (i18 > i17 && rect.top > scrollY) {
            if (rect.height() > height) {
                i16 = rect.top - scrollY;
            } else {
                i16 = rect.bottom - i17;
            }
            return Math.min(i16 + 0, getChildAt(0).getBottom() - i17);
        }
        if (rect.top >= scrollY || i18 >= i17) {
            return 0;
        }
        if (rect.height() > height) {
            i3 = 0 - (i17 - rect.bottom);
        } else {
            i3 = 0 - (scrollY - rect.top);
        }
        return Math.max(i3, -getScrollY());
    }

    public boolean k(KeyEvent keyEvent) {
        this.f44638e.setEmpty();
        if (!g()) {
            if (!isFocused() || keyEvent.getKeyCode() == 4) {
                return false;
            }
            View findFocus = findFocus();
            if (findFocus == this) {
                findFocus = null;
            }
            View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, 130);
            return (findNextFocus == null || findNextFocus == this || !findNextFocus.requestFocus(130)) ? false : true;
        }
        if (keyEvent.getAction() != 0) {
            return false;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 19) {
            if (!keyEvent.isAltPressed()) {
                return f(33);
            }
            return o(33);
        }
        if (keyCode == 20) {
            if (!keyEvent.isAltPressed()) {
                return f(130);
            }
            return o(130);
        }
        if (keyCode != 62) {
            return false;
        }
        C(keyEvent.isShiftPressed() ? 33 : 130);
        return false;
    }

    @Override // android.view.ViewGroup
    protected void measureChild(View view, int i3, int i16) {
        view.measure(ViewGroup.getChildMeasureSpec(i3, getPaddingLeft() + getPaddingRight(), view.getLayoutParams().width), View.MeasureSpec.makeMeasureSpec(0, 0));
    }

    @Override // android.view.ViewGroup
    protected void measureChildWithMargins(View view, int i3, int i16, int i17, int i18) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(ViewGroup.getChildMeasureSpec(i3, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i16, marginLayoutParams.width), View.MeasureSpec.makeMeasureSpec(marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, 0));
    }

    public void n(int i3) {
        if (getChildCount() > 0) {
            this.f44639f.fling(getScrollX(), getScrollY(), 0, i3, 0, 0, 0, Math.max(0, getChildAt(0).getHeight() - ((getHeight() - getPaddingBottom()) - getPaddingTop())));
            boolean z16 = i3 > 0;
            View m3 = m(z16, this.f44639f.getFinalY(), findFocus());
            if (m3 == null) {
                m3 = this;
            }
            if (m3 != findFocus()) {
                if (m3.requestFocus(z16 ? 130 : 33)) {
                    this.I = false;
                }
            }
            invalidate();
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 2 && this.M) {
            return true;
        }
        int i3 = action & 255;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    int i16 = this.U;
                    if (i16 != -1) {
                        float y16 = motionEvent.getY(motionEvent.findPointerIndex(i16));
                        if (((int) Math.abs(y16 - this.J)) > this.R) {
                            this.M = true;
                            this.J = y16;
                        }
                    }
                } else if (i3 != 3) {
                    if (i3 == 6) {
                        A(motionEvent);
                    }
                }
            }
            this.M = false;
            this.U = -1;
        } else {
            float y17 = motionEvent.getY();
            if (!q((int) motionEvent.getX(), (int) y17)) {
                this.M = false;
            } else {
                this.J = y17;
                this.U = motionEvent.getPointerId(0);
                this.M = !this.f44639f.isFinished();
            }
        }
        return this.M;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
        this.K = false;
        this.L = null;
        post(new Runnable() { // from class: com.qzone.business.plusunion.plusoperation.a
            @Override // java.lang.Runnable
            public final void run() {
                OverScrollView.this.y();
            }
        });
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
        if (this.P && View.MeasureSpec.getMode(i16) != 0 && getChildCount() > 0) {
            View childAt = getChildAt(0);
            int measuredHeight = getMeasuredHeight();
            if (childAt.getMeasuredHeight() < measuredHeight) {
                childAt.measure(ViewGroup.getChildMeasureSpec(i3, getPaddingLeft() + getPaddingRight(), ((FrameLayout.LayoutParams) childAt.getLayoutParams()).width), View.MeasureSpec.makeMeasureSpec((measuredHeight - getPaddingTop()) - getPaddingBottom(), 1073741824));
            }
        }
    }

    @Override // android.view.View
    protected void onScrollChanged(int i3, int i16, int i17, int i18) {
        int height = getHeight();
        int paddingTop = this.G.getPaddingTop();
        int height2 = this.G.getHeight() - this.G.getPaddingBottom();
        if (this.E && (i16 < paddingTop || i16 > height2 - height)) {
            if (i16 < paddingTop) {
                this.f44639f.startScroll(0, i16, 0, paddingTop - i16, 1000);
            } else {
                int i19 = height2 - height;
                if (i16 > i19) {
                    this.f44639f.startScroll(0, i16, 0, i19 - i16, 1000);
                }
            }
            post(this.H);
            this.E = false;
            return;
        }
        super.onScrollChanged(i3, i16, i17, i18);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        super.onSizeChanged(i3, i16, i17, i18);
        View findFocus = findFocus();
        if (findFocus == null || this == findFocus || !w(findFocus, 0, i18)) {
            return;
        }
        findFocus.getDrawingRect(this.f44638e);
        offsetDescendantRectToMyCoords(findFocus, this.f44638e);
        j(i(this.f44638e));
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        this.f44639f.forceFinished(true);
        removeCallbacks(this.H);
        if (motionEvent.getAction() == 1) {
            return B();
        }
        if (motionEvent.getAction() == 3) {
            return B();
        }
        return false;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) {
            return false;
        }
        if (this.N == null) {
            this.N = VelocityTracker.obtain();
        }
        this.N.addMovement(motionEvent);
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            float y16 = motionEvent.getY();
            boolean q16 = q((int) motionEvent.getX(), (int) y16);
            this.M = q16;
            if (!q16) {
                return false;
            }
            if (!this.f44639f.isFinished()) {
                this.f44639f.abortAnimation();
            }
            this.J = y16;
            this.U = motionEvent.getPointerId(0);
        } else if (action != 1) {
            if (action != 2) {
                if (action != 3) {
                    if (action == 6) {
                        A(motionEvent);
                    }
                } else if (this.M && getChildCount() > 0) {
                    this.U = -1;
                    this.M = false;
                    VelocityTracker velocityTracker = this.N;
                    if (velocityTracker != null) {
                        velocityTracker.recycle();
                        this.N = null;
                    }
                }
            } else if (this.M) {
                try {
                    float y17 = motionEvent.getY(motionEvent.findPointerIndex(this.U));
                    int i3 = (int) (this.J - y17);
                    this.J = y17;
                    if (v()) {
                        scrollBy(0, i3 / 2);
                    } else {
                        scrollBy(0, i3);
                    }
                } catch (IllegalArgumentException e16) {
                    j.d("OverScrollView", "error: ", e16);
                }
            }
        } else if (this.M) {
            VelocityTracker velocityTracker2 = this.N;
            velocityTracker2.computeCurrentVelocity(1000, this.T);
            int yVelocity = (int) velocityTracker2.getYVelocity(this.U);
            if (getChildCount() > 0 && Math.abs(yVelocity) > this.S) {
                n(-yVelocity);
            }
            this.U = -1;
            this.M = false;
            VelocityTracker velocityTracker3 = this.N;
            if (velocityTracker3 != null) {
                velocityTracker3.recycle();
                this.N = null;
            }
        }
        return true;
    }

    public int p() {
        return (int) ((getBottom() - getTop()) * 0.5f);
    }

    public boolean q(int i3, int i16) {
        if (getChildCount() <= 0) {
            return false;
        }
        int scrollY = getScrollY();
        View childAt = getChildAt(0);
        return i16 >= childAt.getTop() - scrollY && i16 < childAt.getBottom() - scrollY && i3 >= childAt.getLeft() && i3 < childAt.getRight();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (!this.I) {
            if (!this.K) {
                E(view2);
            } else {
                this.L = view2;
            }
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z16) {
        rect.offset(view.getLeft() - view.getScrollX(), view.getTop() - view.getScrollY());
        return F(rect, z16);
    }

    @Override // android.view.View
    public void scrollTo(int i3, int i16) {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            int h16 = h(i3, (getWidth() - getPaddingRight()) - getPaddingLeft(), childAt.getWidth());
            int h17 = h(i16, (getHeight() - getPaddingBottom()) - getPaddingTop(), childAt.getHeight());
            if (h16 == getScrollX() && h17 == getScrollY()) {
                return;
            }
            super.scrollTo(h16, h17);
        }
    }

    public void setFillViewport(boolean z16) {
        if (z16 != this.P) {
            this.P = z16;
            requestLayout();
        }
    }

    public boolean v() {
        return getScrollY() < this.G.getPaddingTop() || getScrollY() > (this.G.getBottom() - this.G.getPaddingBottom()) - getHeight();
    }

    protected int z(int i3) {
        return 0;
    }

    public OverScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private boolean g() {
        View childAt = getChildAt(0);
        if (childAt != null) {
            return getHeight() < (childAt.getHeight() + getPaddingTop()) + getPaddingBottom();
        }
        return false;
    }

    private View l(boolean z16, int i3, int i16) {
        ArrayList<View> focusables = getFocusables(2);
        int size = focusables.size();
        View view = null;
        boolean z17 = false;
        for (int i17 = 0; i17 < size; i17++) {
            View view2 = focusables.get(i17);
            int top = view2.getTop();
            int bottom = view2.getBottom();
            if (i3 < bottom && top < i16) {
                boolean z18 = i3 < top && bottom < i16;
                if (view == null) {
                    view = view2;
                    z17 = z18;
                } else {
                    boolean z19 = (z16 && top < view.getTop()) || (!z16 && bottom > view.getBottom());
                    if (z17) {
                        if (z18) {
                            if (!z19) {
                            }
                            view = view2;
                        }
                    } else if (z18) {
                        view = view2;
                        z17 = true;
                    } else {
                        if (!z19) {
                        }
                        view = view2;
                    }
                }
            }
        }
        return view;
    }

    private boolean u(View view) {
        return !w(view, 0, getHeight());
    }

    @Override // android.view.View
    protected int computeVerticalScrollOffset() {
        return Math.max(0, super.computeVerticalScrollOffset());
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        this.K = true;
        super.requestLayout();
    }

    public void s() {
        View childAt = getChildAt(0);
        this.G = childAt;
        childAt.setPadding(0, 1500, 0, 1500);
    }

    public OverScrollView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f44638e = new Rect();
        this.E = false;
        this.K = true;
        this.L = null;
        this.M = false;
        this.Q = true;
        this.U = -1;
        this.f44640h = context;
        t();
        setFillViewport(true);
        r();
    }

    private void j(int i3) {
        if (i3 != 0) {
            if (this.Q) {
                G(0, i3);
            } else {
                scrollBy(0, i3);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i3) {
        if (getChildCount() <= 0) {
            super.addView(view, i3);
            s();
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, layoutParams);
            s();
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    public boolean C(int i3) {
        boolean z16 = i3 == 130;
        int height = getHeight();
        if (z16) {
            this.f44638e.top = getScrollY() + height;
            int childCount = getChildCount();
            if (childCount > 0) {
                View childAt = getChildAt(childCount - 1);
                if (this.f44638e.top + height > childAt.getBottom()) {
                    this.f44638e.top = childAt.getBottom() - height;
                }
            }
        } else {
            this.f44638e.top = getScrollY() - height;
            Rect rect = this.f44638e;
            if (rect.top < 0) {
                rect.top = 0;
            }
        }
        Rect rect2 = this.f44638e;
        int i16 = rect2.top;
        int i17 = height + i16;
        rect2.bottom = i17;
        return D(i3, i16, i17);
    }

    public boolean o(int i3) {
        int childCount;
        boolean z16 = i3 == 130;
        int height = getHeight();
        Rect rect = this.f44638e;
        rect.top = 0;
        rect.bottom = height;
        if (z16 && (childCount = getChildCount()) > 0) {
            this.f44638e.bottom = getChildAt(childCount - 1).getBottom();
            Rect rect2 = this.f44638e;
            rect2.top = rect2.bottom - height;
        }
        Rect rect3 = this.f44638e;
        return D(i3, rect3.top, rect3.bottom);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i3, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, i3, layoutParams);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    @Override // android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int i3, Rect rect) {
        View findNextFocusFromRect;
        if (i3 == 2) {
            i3 = 130;
        } else if (i3 == 1) {
            i3 = 33;
        }
        if (rect == null) {
            findNextFocusFromRect = FocusFinder.getInstance().findNextFocus(this, null, i3);
        } else {
            findNextFocusFromRect = FocusFinder.getInstance().findNextFocusFromRect(this, rect, i3);
        }
        if (findNextFocusFromRect == null || u(findNextFocusFromRect)) {
            return false;
        }
        return findNextFocusFromRect.requestFocus(i3, rect);
    }

    public void setScrollListener(a aVar) {
    }
}
