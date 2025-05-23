package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.support.annotation.FloatRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ScrollView;

/* compiled from: P */
/* loaded from: classes20.dex */
public class FixedBounceScrollView extends ScrollView {
    private View C;
    private float D;
    private int E;
    private int F;
    private Rect G;
    private TranslateAnimation H;
    private float I;
    private float J;
    private float K;
    private float L;
    boolean M;
    private int N;

    /* renamed from: d, reason: collision with root package name */
    private boolean f315634d;

    /* renamed from: e, reason: collision with root package name */
    private float f315635e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f315636f;

    /* renamed from: h, reason: collision with root package name */
    private long f315637h;

    /* renamed from: i, reason: collision with root package name */
    private int f315638i;

    /* renamed from: m, reason: collision with root package name */
    private Interpolator f315639m;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    private static class a implements Interpolator {
        a() {
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f16) {
            return (float) (1.0d - Math.pow(1.0f - f16, 4.0d));
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface b {
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface c {
    }

    public FixedBounceScrollView(@NonNull Context context) {
        this(context, null);
    }

    private float a() {
        float abs;
        int measuredHeight;
        if (this.f315634d) {
            abs = Math.abs(this.C.getLeft()) * 1.0f;
            measuredHeight = this.C.getMeasuredWidth();
        } else {
            abs = Math.abs(this.C.getTop()) * 1.0f;
            measuredHeight = this.C.getMeasuredHeight();
        }
        float f16 = (float) ((abs / measuredHeight) + 0.2d);
        if (this.f315636f) {
            return this.f315635e / (1.0f - ((float) Math.pow(f16, 2.0d)));
        }
        return this.f315635e;
    }

    private boolean b(int i3) {
        if (i3 != 0 && i3 < 0) {
            return d();
        }
        return c();
    }

    private boolean c() {
        if (this.f315634d) {
            int measuredWidth = this.C.getMeasuredWidth() - getWidth();
            if (measuredWidth < 0) {
                measuredWidth = 0;
            }
            if (getScrollX() == measuredWidth) {
                return true;
            }
            return false;
        }
        int measuredHeight = this.C.getMeasuredHeight() - getHeight();
        if (measuredHeight < 0) {
            measuredHeight = 0;
        }
        if (getScrollY() == measuredHeight) {
            return true;
        }
        return false;
    }

    private boolean d() {
        if (this.f315634d) {
            if (getScrollX() == 0) {
                return true;
            }
        } else if (getScrollY() == 0) {
            return true;
        }
        return false;
    }

    private void e() {
        int paddingStart;
        ViewGroup.LayoutParams layoutParams = this.C.getLayoutParams();
        int i3 = 0;
        if (this.f315634d) {
            if (ViewCompat.getLayoutDirection(this) == 1) {
                paddingStart = ViewCompat.getPaddingEnd(this);
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    i3 = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                }
            } else {
                paddingStart = ViewCompat.getPaddingStart(this);
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    i3 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
                }
            }
            this.H = new TranslateAnimation((this.C.getLeft() - paddingStart) - i3, (this.G.left - paddingStart) - i3, 0.0f, 0.0f);
        } else {
            int paddingTop = getPaddingTop();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                i3 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
            }
            this.H = new TranslateAnimation(0.0f, 0.0f, (this.C.getTop() - paddingTop) - i3, (this.G.top - paddingTop) - i3);
        }
        this.H.setInterpolator(this.f315639m);
        this.H.setDuration(this.f315637h);
        this.C.startAnimation(this.H);
        View view = this.C;
        Rect rect = this.G;
        view.layout(rect.left, rect.top, rect.right, rect.bottom);
        this.G.setEmpty();
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i3) {
        return this.f315634d;
    }

    @Override // android.view.View
    public boolean canScrollVertically(int i3) {
        return !this.f315634d;
    }

    @Override // android.widget.ScrollView, android.view.View
    protected float getBottomFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        float f16 = this.J;
        if (f16 != -1.0f) {
            return f16;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int bottom = (getChildAt(0).getBottom() - getScrollY()) - (getHeight() - getPaddingBottom());
        if (bottom < verticalFadingEdgeLength) {
            return bottom / verticalFadingEdgeLength;
        }
        return 1.0f;
    }

    @Override // android.view.View
    protected float getLeftFadingEdgeStrength() {
        float f16 = this.K;
        if (f16 != -1.0f) {
            return f16;
        }
        if (computeHorizontalScrollOffset() > 0) {
            return 1.0f;
        }
        return 0.0f;
    }

    @Override // android.view.View
    protected float getRightFadingEdgeStrength() {
        float f16 = this.L;
        if (f16 != -1.0f) {
            return f16;
        }
        if (computeHorizontalScrollOffset() + computeHorizontalScrollExtent() < computeHorizontalScrollRange()) {
            return 1.0f;
        }
        return 0.0f;
    }

    @Override // android.widget.ScrollView, android.view.View
    protected float getTopFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        float f16 = this.I;
        if (f16 != -1.0f) {
            return f16;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        if (getScrollY() < verticalFadingEdgeLength) {
            return getScrollY() / verticalFadingEdgeLength;
        }
        return 1.0f;
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        TranslateAnimation translateAnimation = this.H;
        if (translateAnimation != null && !translateAnimation.hasEnded()) {
            this.H.cancel();
        }
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        if (getChildCount() > 0) {
            this.C = getChildAt(0);
        }
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        float y16;
        if (this.M) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 2) {
                if (this.f315634d) {
                    if (Math.abs(motionEvent.getX() - this.D) >= this.f315638i) {
                        return true;
                    }
                    return false;
                }
                if (Math.abs(motionEvent.getY() - this.D) >= this.f315638i) {
                    return true;
                }
                return false;
            }
        } else {
            if (this.f315634d) {
                y16 = motionEvent.getX();
            } else {
                y16 = motionEvent.getY();
            }
            this.D = y16;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        View childAt;
        int measuredHeight;
        int i17;
        int i18 = this.N;
        if (i18 > 0) {
            i16 = View.MeasureSpec.makeMeasureSpec(i18, Integer.MIN_VALUE);
        }
        super.onMeasure(i3, i16);
        if (getChildCount() <= 0 || (measuredHeight = (childAt = getChildAt(0)).getMeasuredHeight()) <= 0) {
            return;
        }
        int measuredWidth = childAt.getMeasuredWidth();
        ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            int i19 = layoutParams2.leftMargin;
            int i26 = layoutParams2.topMargin;
            int i27 = layoutParams2.rightMargin;
            int i28 = layoutParams2.bottomMargin;
            if (i19 != 0 || i26 != 0 || i27 != 0 || i28 != 0) {
                if (measuredHeight <= getMeasuredHeight()) {
                    measuredWidth -= i19 + i27;
                    i17 = measuredHeight - (i26 + i28);
                } else {
                    i17 = measuredHeight + i26 + i28;
                }
                childAt.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(i17, 1073741824));
            }
        }
    }

    @Override // android.view.View
    protected void onScrollChanged(int i3, int i16, int i17, int i18) {
        super.onScrollChanged(i3, i16, i17, i18);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0015, code lost:
    
        if (r0 != 3) goto L40;
     */
    @Override // android.widget.ScrollView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        float y16;
        if (this.C == null) {
            return super.onTouchEvent(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        boolean z16 = true;
        if (actionMasked != 1) {
            if (actionMasked == 2) {
                if (this.f315634d) {
                    y16 = motionEvent.getX();
                } else {
                    y16 = motionEvent.getY();
                }
                int a16 = (int) ((this.D - y16) / a());
                this.D = y16;
                setmCustomTopFadingEdgeScale(1.0f);
                setmCustomBottomFadingEdgeScale(1.0f);
                int i3 = this.E;
                if ((i3 <= 0 && a16 > 0) || (i3 >= 0 && a16 < 0)) {
                    z16 = false;
                }
                this.E = a16;
                if (z16 && b(a16)) {
                    if (this.G.isEmpty()) {
                        this.G.set(this.C.getLeft(), this.C.getTop(), this.C.getRight(), this.C.getBottom());
                    }
                    if (this.f315634d) {
                        View view = this.C;
                        view.layout(view.getLeft() - a16, this.C.getTop(), this.C.getRight() - a16, this.C.getBottom());
                    } else {
                        View view2 = this.C;
                        view2.layout(view2.getLeft(), (this.C.getTop() - a16) + 2, this.C.getRight(), (this.C.getBottom() - a16) + 2);
                    }
                }
            }
            return super.onTouchEvent(motionEvent);
        }
        setmCustomTopFadingEdgeScale(0.0f);
        setmCustomBottomFadingEdgeScale(0.0f);
        postInvalidate();
        performClick();
        if (!this.G.isEmpty()) {
            e();
        }
        this.E = 0;
        this.F = 0;
        return super.onTouchEvent(motionEvent);
    }

    public void setBounceDelay(long j3) {
        if (j3 >= 0) {
            this.f315637h = j3;
        }
    }

    public void setBounceInterpolator(@NonNull Interpolator interpolator) {
        this.f315639m = interpolator;
    }

    public void setChildView(View view) {
        this.C = view;
    }

    public void setDamping(@FloatRange(from = 0.0d, to = 100.0d) float f16) {
        if (this.f315635e > 0.0f) {
            this.f315635e = f16;
        }
    }

    public void setIncrementalDamping(boolean z16) {
        this.f315636f = z16;
    }

    public void setMaxHeight(int i3) {
        this.N = i3;
    }

    public void setNeedDisallowIntercept(boolean z16) {
        this.M = z16;
    }

    public void setScrollHorizontally(boolean z16) {
        this.f315634d = z16;
    }

    public void setTriggerOverScrollThreshold(int i3) {
        if (i3 >= 0) {
            this.f315638i = i3;
        }
    }

    public void setmCustomBottomFadingEdgeScale(@FloatRange(from = 0.0d, to = 1.0d) float f16) {
        this.J = f16;
    }

    public void setmCustomLeftFadingEdgeScale(@FloatRange(from = 0.0d, to = 1.0d) float f16) {
        this.K = f16;
    }

    public void setmCustomRightFadingEdgeScale(@FloatRange(from = 0.0d, to = 1.0d) float f16) {
        this.L = f16;
    }

    public void setmCustomTopFadingEdgeScale(@FloatRange(from = 0.0d, to = 1.0d) float f16) {
        this.I = f16;
    }

    public FixedBounceScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FixedBounceScrollView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.G = new Rect();
        this.I = -1.0f;
        this.J = -1.0f;
        this.K = -1.0f;
        this.L = -1.0f;
        this.M = false;
        this.N = 0;
        setOverScrollMode(2);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        setFillViewport(true);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, jj2.b.K1, 0, 0);
        this.f315635e = obtainStyledAttributes.getFloat(jj2.b.M1, 4.0f);
        this.f315634d = obtainStyledAttributes.getInt(jj2.b.O1, 0) == 1;
        this.f315636f = obtainStyledAttributes.getBoolean(jj2.b.N1, true);
        this.f315637h = obtainStyledAttributes.getInt(jj2.b.L1, 400);
        this.f315638i = obtainStyledAttributes.getInt(jj2.b.P1, 20);
        obtainStyledAttributes.recycle();
        if (this.f315636f) {
            this.f315639m = new a();
        }
        setmCustomBottomFadingEdgeScale(0.0f);
        setmCustomTopFadingEdgeScale(0.0f);
    }

    public void setOnOverScrollListener(b bVar) {
    }

    public void setOnScrollListener(c cVar) {
    }
}
