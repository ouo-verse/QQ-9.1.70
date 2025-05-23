package com.tencent.comic.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.HorizontalScrollView;

/* compiled from: P */
/* loaded from: classes32.dex */
public class ComicHorizontalCenterScrollView extends HorizontalScrollView {
    private a C;
    private float D;
    private float E;
    private boolean F;
    private VelocityTracker G;
    private int H;
    private int I;
    private int J;

    /* renamed from: d, reason: collision with root package name */
    private int f99407d;

    /* renamed from: e, reason: collision with root package name */
    private int f99408e;

    /* renamed from: f, reason: collision with root package name */
    private int f99409f;

    /* renamed from: h, reason: collision with root package name */
    private int f99410h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f99411i;

    /* renamed from: m, reason: collision with root package name */
    private int f99412m;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface a {
        void a(int i3);
    }

    public ComicHorizontalCenterScrollView(Context context) {
        this(context, null);
    }

    private void a(MotionEvent motionEvent) {
        d();
        this.G.addMovement(motionEvent);
    }

    private int b(float f16, int i3, int i16, int i17) {
        boolean z16 = Math.abs(f16) >= ((float) this.J);
        if (f16 <= 0.0f) {
            if (z16) {
                i17 += this.f99412m;
            }
            int i18 = this.f99409f;
            int i19 = i17 / i18;
            int i26 = this.f99410h;
            int i27 = ((i19 + 1) * i18) + i26;
            return (i27 <= i17 || i27 >= i17 + i3) ? (i19 * i18) + i26 : i27;
        }
        if (z16) {
            i17 -= this.f99412m;
        }
        int i28 = this.f99409f;
        int i29 = ((i16 - i17) - i3) / i28;
        int i36 = this.f99410h;
        int i37 = (i16 - ((i29 + 1) * i28)) - i36;
        return (i37 <= i17 || i37 >= i17 + i3) ? (i16 - (i28 * i29)) - i36 : i37;
    }

    private void c() {
        VelocityTracker velocityTracker = this.G;
        if (velocityTracker == null) {
            this.G = VelocityTracker.obtain();
        } else {
            velocityTracker.clear();
        }
    }

    private void d() {
        if (this.G == null) {
            this.G = VelocityTracker.obtain();
        }
    }

    private int e(int i3, int i16, int i17) {
        Math.max(i16, i3);
        return Math.min(i17, i3);
    }

    private void f() {
        VelocityTracker velocityTracker = this.G;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.G = null;
        }
    }

    private void g(float f16) {
        int measuredWidth;
        int measuredWidth2;
        int scrollX = getScrollX();
        if (f16 == 0.0f) {
            f16 = this.E - ((float) scrollX) > 0.0f ? 1.0f : -1.0f;
        }
        View childAt = getChildAt(0);
        if (childAt != null && (measuredWidth = childAt.getMeasuredWidth()) > (measuredWidth2 = getMeasuredWidth()) && measuredWidth2 < this.f99407d * 2) {
            int b16 = b(f16, measuredWidth2, measuredWidth, scrollX);
            smoothScrollTo(e(b16 - (measuredWidth2 / 2), 0, measuredWidth), 0);
            a aVar = this.C;
            if (aVar != null) {
                aVar.a(b16);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (!this.f99411i) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (motionEvent.getAction() == 0) {
            this.E = getScrollX();
            this.F = false;
            c();
            this.D = motionEvent.getX();
        } else if (motionEvent.getAction() == 2) {
            if (this.F) {
                a(motionEvent);
            } else if (Math.abs(motionEvent.getX() - this.D) >= this.H) {
                this.F = true;
                a(motionEvent);
                this.D = motionEvent.getX();
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        d();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        f();
    }

    @Override // android.view.View
    protected void onScrollChanged(int i3, int i16, int i17, int i18) {
        super.onScrollChanged(i3, i16, i17, i18);
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f99411i && ((motionEvent.getAction() == 1 || motionEvent.getAction() == 3) && this.F)) {
            this.G.computeCurrentVelocity(1000);
            g(this.G.getXVelocity());
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setBaseInfo(int i3, int i16, a aVar) {
        this.C = aVar;
        this.f99407d = i3;
        this.f99408e = i16;
        this.f99409f = i3 + i16;
        this.f99412m = i3 / 3;
        this.f99411i = true;
        this.f99410h = (i3 / 2) + i16;
    }

    public ComicHorizontalCenterScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.view.View
    public void setOverScrollMode(int i3) {
        super.setOverScrollMode(2);
    }

    public ComicHorizontalCenterScrollView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f99411i = false;
        this.f99412m = 0;
        this.C = null;
        this.D = 0.0f;
        this.E = 0.0f;
        this.F = false;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.H = viewConfiguration.getScaledTouchSlop();
        int scaledMinimumFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.I = scaledMinimumFlingVelocity;
        this.J = scaledMinimumFlingVelocity * 2;
    }
}
