package com.tencent.mobileqq.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.widget.LinearLayout;
import android.widget.Scroller;

/* compiled from: P */
/* loaded from: classes20.dex */
public class HorizontalScrollLayout extends LinearLayout {
    private int C;
    private int D;

    /* renamed from: d, reason: collision with root package name */
    private Scroller f315714d;

    /* renamed from: e, reason: collision with root package name */
    private VelocityTracker f315715e;

    /* renamed from: f, reason: collision with root package name */
    private int f315716f;

    /* renamed from: h, reason: collision with root package name */
    private int f315717h;

    /* renamed from: i, reason: collision with root package name */
    private float f315718i;

    /* renamed from: m, reason: collision with root package name */
    private float f315719m;

    public HorizontalScrollLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f315716f = 0;
        this.D = 0;
        this.f315714d = new Scroller(context);
        this.f315717h = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.C = a();
    }

    public int a() {
        return getResources().getDisplayMetrics().widthPixels;
    }

    public void b() {
        int scrollX;
        int scrollX2 = getScrollX();
        if (scrollX2 < 0) {
            this.f315714d.startScroll(scrollX2, 0, -scrollX2, 0, Math.abs(scrollX2) * 1);
        } else {
            int i3 = this.D;
            if (i3 < scrollX2) {
                if (i3 <= 0) {
                    scrollX = getScrollX();
                } else {
                    scrollX = getScrollX() - this.D;
                }
                this.f315714d.startScroll(getScrollX(), 0, -scrollX, 0, Math.abs(scrollX) * 1);
            }
        }
        invalidate();
    }

    public void c(boolean z16) {
        int scrollX;
        int i3;
        if (z16) {
            if (this.D <= 0) {
                i3 = -getScrollX();
            } else {
                int scrollX2 = this.C + getScrollX();
                int i16 = this.D;
                if (scrollX2 > i16) {
                    i3 = i16 - getScrollX();
                } else {
                    i3 = this.C;
                }
            }
            int i17 = i3;
            this.f315714d.startScroll(getScrollX(), 0, i17, 0, Math.abs(i17) * 1);
        } else {
            if ((-this.C) + getScrollX() > 0) {
                scrollX = -this.C;
            } else {
                scrollX = getScrollX() * (-1);
            }
            int i18 = scrollX;
            this.f315714d.startScroll(getScrollX(), 0, i18, 0, Math.abs(i18) * 1);
        }
        invalidate();
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.f315714d.computeScrollOffset()) {
            scrollTo(this.f315714d.getCurrX(), this.f315714d.getCurrY());
            postInvalidate();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001d, code lost:
    
        if (r0 != 3) goto L22;
     */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 2 && this.f315716f != 0) {
            return true;
        }
        float x16 = motionEvent.getX();
        float y16 = motionEvent.getY();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    int abs = (int) Math.abs(this.f315718i - x16);
                    int abs2 = (int) Math.abs(this.f315719m - y16);
                    if (abs > this.f315717h && abs > abs2) {
                        this.f315716f = 1;
                        ViewParent parent = getParent();
                        if (parent != null) {
                            parent.requestDisallowInterceptTouchEvent(true);
                        }
                    }
                }
            }
            this.f315716f = 0;
        } else {
            this.f315718i = x16;
            this.f315719m = y16;
            this.f315716f = !this.f315714d.isFinished() ? 1 : 0;
        }
        if (this.f315716f != 0) {
            return true;
        }
        return false;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
        if (1 <= getChildCount()) {
            this.D = getChildAt(getChildCount() - 1).getRight() - this.C;
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f315715e == null) {
            this.f315715e = VelocityTracker.obtain();
        }
        this.f315715e.addMovement(motionEvent);
        int action = motionEvent.getAction();
        float x16 = motionEvent.getX();
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action == 3) {
                        b();
                        this.f315716f = 0;
                    }
                } else {
                    int i3 = (int) (this.f315718i - x16);
                    this.f315718i = x16;
                    scrollBy(i3, 0);
                }
            } else {
                VelocityTracker velocityTracker = this.f315715e;
                velocityTracker.computeCurrentVelocity(1000);
                int xVelocity = (int) velocityTracker.getXVelocity();
                if (xVelocity > 600) {
                    c(false);
                } else if (xVelocity < -600) {
                    c(true);
                } else {
                    b();
                }
                VelocityTracker velocityTracker2 = this.f315715e;
                if (velocityTracker2 != null) {
                    velocityTracker2.recycle();
                    this.f315715e = null;
                }
                this.f315716f = 0;
            }
        } else {
            if (!this.f315714d.isFinished()) {
                this.f315714d.abortAnimation();
            }
            this.f315718i = x16;
        }
        return true;
    }
}
