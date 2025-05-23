package com.tencent.mobileqq.activity;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import mqq.os.MqqHandler;

/* compiled from: P */
/* loaded from: classes9.dex */
public class AutoFitScrollView extends FrameLayout {
    static IPatchRedirector $redirector_;
    private h C;
    private VelocityTracker D;
    private float E;
    private boolean F;
    private long G;
    private MqqHandler H;
    private boolean I;
    private int J;

    /* renamed from: d, reason: collision with root package name */
    private int f174997d;

    /* renamed from: e, reason: collision with root package name */
    public int f174998e;

    /* renamed from: f, reason: collision with root package name */
    private int f174999f;

    /* renamed from: h, reason: collision with root package name */
    private float f175000h;

    /* renamed from: i, reason: collision with root package name */
    private float f175001i;

    /* renamed from: m, reason: collision with root package name */
    private int f175002m;

    public AutoFitScrollView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.f174999f = 0;
        this.I = false;
        a(context);
    }

    private void a(Context context) {
        this.C = new h(getContext());
        this.f175002m = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        setFitWidth(context.getResources().getDisplayMetrics().widthPixels, 10);
    }

    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        } else {
            this.I = false;
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        if (this.C.c()) {
            scrollTo(this.C.f(), this.C.g());
            postInvalidate();
        } else if (this.F) {
            if (this.H != null) {
                if (getScrollX() <= this.f174998e - getWidth()) {
                    getScrollX();
                }
            }
            this.F = false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0036, code lost:
    
        if (r0 != 3) goto L27;
     */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) motionEvent)).booleanValue();
        }
        int action = motionEvent.getAction() & 255;
        if (action == 2 && this.f174999f != 0) {
            return true;
        }
        float x16 = motionEvent.getX();
        float y16 = motionEvent.getY();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    int i3 = (int) (x16 - this.f175000h);
                    if (Math.abs((int) (y16 - this.f175001i)) < Math.abs(i3) && Math.abs(i3) > this.f175002m) {
                        this.f174999f = 1;
                    }
                }
            }
            this.f174999f = 0;
        } else {
            this.f175000h = x16;
            this.f175001i = y16;
            this.f174999f = !this.C.h() ? 1 : 0;
        }
        if (this.f174999f != 0) {
            return true;
        }
        return false;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
        } else if (getChildCount() > 0) {
            getChildAt(0).layout(0, 0, this.f174998e, i18 - i16);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0047, code lost:
    
        if (r1 != 3) goto L57;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) motionEvent)).booleanValue();
        }
        super.onTouchEvent(motionEvent);
        if (this.I) {
            return true;
        }
        if (this.D == null) {
            this.D = VelocityTracker.obtain();
        }
        this.D.addMovement(motionEvent);
        float x16 = motionEvent.getX();
        motionEvent.getY();
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    scrollBy((int) (this.E - x16), 0);
                    this.E = x16;
                    this.F = false;
                    long currentTimeMillis = System.currentTimeMillis();
                    if (this.H != null && currentTimeMillis - this.G > 50) {
                        this.G = currentTimeMillis;
                        if (getScrollX() <= this.f174998e - getWidth()) {
                            getScrollX();
                        }
                    }
                }
            }
            VelocityTracker velocityTracker = this.D;
            velocityTracker.computeCurrentVelocity(1000);
            int xVelocity = (int) velocityTracker.getXVelocity();
            if (getChildCount() > 0) {
                if (Math.abs(xVelocity) > 1000) {
                    int b16 = this.C.b(xVelocity);
                    if (xVelocity > 0) {
                        b16 = -b16;
                    }
                    int round = Math.round((b16 + getScrollX()) / this.f174997d) * this.f174997d;
                    h hVar = this.C;
                    if (xVelocity < 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    int d16 = hVar.d(z16, Math.abs(round - getScrollX()));
                    if (d16 < 0) {
                        this.C.e(getScrollX(), getScrollY(), -d16, 0, 0, this.f174998e - getWidth(), 0, 0);
                    } else {
                        this.C.e(getScrollX(), getScrollY(), -d16, 0, 0, this.C.f(), 0, 0);
                    }
                    postInvalidate();
                } else {
                    int scrollX = getScrollX();
                    this.C.i(scrollX, getScrollY(), Math.max(Math.min(Math.round((scrollX + 0.1f) / this.f174997d) * this.f174997d, this.f174998e - getWidth()), 0) - scrollX, 0);
                    postInvalidate();
                }
            }
            VelocityTracker velocityTracker2 = this.D;
            if (velocityTracker2 != null) {
                velocityTracker2.recycle();
                this.D = null;
            }
            this.f174999f = 0;
            this.F = true;
        } else {
            h hVar2 = this.C;
            if (hVar2 != null && !hVar2.h()) {
                this.C.a();
            }
            this.E = x16;
            this.F = false;
            this.J = getScrollX();
        }
        return true;
    }

    public void setCallback(MqqHandler mqqHandler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) mqqHandler);
        } else {
            this.H = mqqHandler;
        }
    }

    public void setFitWidth(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            this.f174997d = i16;
            this.f174998e = i3;
        }
    }

    public AutoFitScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f174999f = 0;
        this.I = false;
        a(context);
    }

    public AutoFitScrollView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
            return;
        }
        this.f174999f = 0;
        this.I = false;
        a(context);
    }
}
