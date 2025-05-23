package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.Scroller;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.widget.OverScrollRecyclerView;

/* compiled from: P */
/* loaded from: classes19.dex */
public class SlideAndOverScrollRecyclerView extends OverScrollRecyclerView {
    static IPatchRedirector $redirector_;
    private float C;
    private float D;
    private boolean E;
    private ViewGroup F;
    private int G;
    private int H;

    /* renamed from: e, reason: collision with root package name */
    private VelocityTracker f302423e;

    /* renamed from: f, reason: collision with root package name */
    private int f302424f;

    /* renamed from: h, reason: collision with root package name */
    private Rect f302425h;

    /* renamed from: i, reason: collision with root package name */
    private Scroller f302426i;

    /* renamed from: m, reason: collision with root package name */
    private float f302427m;

    public SlideAndOverScrollRecyclerView(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    private void e(MotionEvent motionEvent) {
        if (this.f302423e == null) {
            this.f302423e = VelocityTracker.obtain();
        }
        this.f302423e.addMovement(motionEvent);
    }

    private void g() {
        VelocityTracker velocityTracker = this.f302423e;
        if (velocityTracker != null) {
            velocityTracker.clear();
            this.f302423e.recycle();
            this.f302423e = null;
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else if (this.f302426i.computeScrollOffset()) {
            this.F.scrollTo(this.f302426i.getCurrX(), this.f302426i.getCurrY());
            invalidate();
        }
    }

    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        ViewGroup viewGroup = this.F;
        if (viewGroup != null && viewGroup.getScrollX() != 0) {
            this.F.scrollTo(0, 0);
        }
    }

    public int f(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Integer.valueOf(i16))).intValue();
        }
        int findFirstVisibleItemPosition = ((LinearLayoutManager) getLayoutManager()).findFirstVisibleItemPosition();
        Rect rect = this.f302425h;
        if (rect == null) {
            rect = new Rect();
            this.f302425h = rect;
        }
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (childAt.getVisibility() == 0) {
                childAt.getHitRect(rect);
                if (rect.contains(i3, i16)) {
                    return findFirstVisibleItemPosition + childCount;
                }
            }
        }
        return -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x007b, code lost:
    
        if (java.lang.Math.abs(r0 - r7.C) > java.lang.Math.abs(r1 - r7.D)) goto L21;
     */
    @Override // android.support.v7.widget.RecyclerView, android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) motionEvent)).booleanValue();
        }
        int x16 = (int) motionEvent.getX();
        int y16 = (int) motionEvent.getY();
        e(motionEvent);
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    this.f302423e.computeCurrentVelocity(1000);
                    float xVelocity = this.f302423e.getXVelocity();
                    float yVelocity = this.f302423e.getYVelocity();
                    if (Math.abs(xVelocity) <= 600.0f || Math.abs(xVelocity) <= Math.abs(yVelocity)) {
                        float f16 = x16;
                        if (Math.abs(f16 - this.C) >= this.f302424f) {
                        }
                    }
                    this.E = true;
                    return true;
                }
            } else {
                g();
            }
        } else {
            if (!this.f302426i.isFinished()) {
                this.f302426i.abortAnimation();
            }
            float f17 = x16;
            this.f302427m = f17;
            this.C = f17;
            this.D = y16;
            int f18 = f(x16, y16);
            this.G = f18;
            if (f18 != -1) {
                ViewGroup viewGroup = this.F;
                ViewGroup viewGroup2 = (ViewGroup) getChildAt(f18 - ((LinearLayoutManager) getLayoutManager()).findFirstVisibleItemPosition());
                this.F = viewGroup2;
                if (viewGroup != null && viewGroup2 != viewGroup && viewGroup.getScrollX() != 0) {
                    viewGroup.scrollTo(0, 0);
                }
                if (this.F.getChildCount() == 2) {
                    this.H = this.F.getChildAt(1).getWidth();
                } else {
                    this.H = -1;
                }
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.support.v7.widget.RecyclerView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) motionEvent)).booleanValue();
        }
        if (this.E && this.G != -1) {
            float x16 = motionEvent.getX();
            e(motionEvent);
            int action = motionEvent.getAction();
            if (action != 1) {
                if (action == 2 && this.H != -1) {
                    float f16 = this.f302427m - x16;
                    if (this.F.getScrollX() + f16 <= this.H && this.F.getScrollX() + f16 > 0.0f) {
                        this.F.scrollBy((int) f16, 0);
                    }
                    this.f302427m = x16;
                }
            } else {
                if (this.H != -1) {
                    int scrollX = this.F.getScrollX();
                    this.f302423e.computeCurrentVelocity(1000);
                    if (this.f302423e.getXVelocity() < -600.0f) {
                        Scroller scroller = this.f302426i;
                        int i3 = this.H;
                        scroller.startScroll(scrollX, 0, i3 - scrollX, 0, Math.abs(i3 - scrollX));
                    } else if (this.f302423e.getXVelocity() >= 600.0f) {
                        this.f302426i.startScroll(scrollX, 0, -scrollX, 0, Math.abs(scrollX));
                    } else {
                        int i16 = this.H;
                        if (scrollX >= i16 / 2) {
                            this.f302426i.startScroll(scrollX, 0, i16 - scrollX, 0, Math.abs(i16 - scrollX));
                        } else {
                            this.f302426i.startScroll(scrollX, 0, -scrollX, 0, Math.abs(scrollX));
                        }
                    }
                    invalidate();
                }
                this.H = -1;
                this.E = false;
                this.G = -1;
                g();
            }
            return true;
        }
        d();
        g();
        return super.onTouchEvent(motionEvent);
    }

    public SlideAndOverScrollRecyclerView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public SlideAndOverScrollRecyclerView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
        } else {
            this.f302424f = ViewConfiguration.get(context).getScaledTouchSlop();
            this.f302426i = new Scroller(context);
        }
    }
}
