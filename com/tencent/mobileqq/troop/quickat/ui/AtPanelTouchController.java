package com.tencent.mobileqq.troop.quickat.ui;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.LinearLayout;
import android.widget.Scroller;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes19.dex */
public class AtPanelTouchController extends LinearLayout {
    static IPatchRedirector $redirector_;
    protected a C;
    protected int D;
    protected boolean E;
    boolean F;
    protected View G;
    protected int H;
    protected float I;
    protected float J;
    private boolean K;
    protected boolean L;
    private boolean M;

    /* renamed from: d, reason: collision with root package name */
    protected float f298219d;

    /* renamed from: e, reason: collision with root package name */
    protected boolean f298220e;

    /* renamed from: f, reason: collision with root package name */
    protected boolean f298221f;

    /* renamed from: h, reason: collision with root package name */
    protected boolean f298222h;

    /* renamed from: i, reason: collision with root package name */
    protected int f298223i;

    /* renamed from: m, reason: collision with root package name */
    protected Scroller f298224m;

    /* loaded from: classes19.dex */
    public interface a {
        void a(boolean z16);

        void b(int i3);

        void scrollToTop();
    }

    /* loaded from: classes19.dex */
    public interface b {
    }

    public AtPanelTouchController(@NonNull Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f298219d = 0.0f;
        this.f298220e = false;
        this.f298221f = true;
        this.f298222h = false;
        this.f298223i = 1;
        this.D = 0;
        this.E = false;
        this.F = false;
        this.G = null;
        this.L = false;
        this.M = false;
        d();
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x002a, code lost:
    
        if (r5 != 3) goto L60;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean b(MotionEvent motionEvent) {
        boolean z16;
        float x16 = motionEvent.getX();
        float y16 = motionEvent.getY();
        float abs = Math.abs(x16 - this.I);
        float abs2 = Math.abs(y16 - this.J);
        float y17 = motionEvent.getY();
        int action = motionEvent.getAction();
        boolean z17 = false;
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    float f16 = -(y17 - this.f298219d);
                    float a16 = a(f16);
                    if (QLog.isColorLevel()) {
                        QLog.d("UUUU", 2, "NKSS=" + a16 + " differ=" + f16);
                    }
                    if (this.f298220e && a16 != 0.0f) {
                        scrollBy(0, (int) a16);
                        this.L = true;
                    } else if (this.K && abs2 > this.H && abs2 > abs) {
                        scrollBy(0, (int) a16);
                        this.L = true;
                    } else if (a16 > 0.0f) {
                        scrollBy(0, (int) a16);
                        this.L = true;
                    } else {
                        this.L = false;
                    }
                    if (Math.abs(f16) > 5.0f) {
                        this.f298222h = true;
                    }
                    a aVar = this.C;
                    if (aVar != null) {
                        if (getScrollY() > 0) {
                            z17 = true;
                        }
                        aVar.a(z17);
                    }
                    this.f298219d = y17;
                    if (this.K && !this.L) {
                        super.dispatchTouchEvent(motionEvent);
                    }
                    return true;
                }
            }
            this.f298220e = false;
            if (!this.f298222h) {
                return super.dispatchTouchEvent(motionEvent);
            }
            if (!this.K) {
                motionEvent.setAction(3);
            }
            super.dispatchTouchEvent(motionEvent);
            if ((-getScrollY()) < c()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                g(0);
            } else if (this.C != null) {
                this.E = true;
                g(-this.D);
            }
            return false;
        }
        this.f298222h = false;
        this.f298219d = motionEvent.getY();
        this.I = x16;
        this.J = y16;
        this.L = false;
        super.dispatchTouchEvent(motionEvent);
        return true;
    }

    private int c() {
        int i3 = 0;
        for (int i16 = 0; i16 < getChildCount(); i16++) {
            View childAt = getChildAt(i16);
            if (childAt.getVisibility() == 0) {
                i3 += childAt.getHeight();
            }
        }
        this.D = i3;
        return i3 / 3;
    }

    private void d() {
        this.f298224m = new Scroller(getContext());
        this.H = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    public static boolean f(View view, MotionEvent motionEvent) {
        if (view == null) {
            return false;
        }
        int rawY = (int) motionEvent.getRawY();
        int rawX = (int) motionEvent.getRawX();
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i3 = iArr[0];
        int i16 = iArr[1];
        int measuredWidth = view.getMeasuredWidth() + i3;
        int measuredHeight = view.getMeasuredHeight() + i16;
        if (rawY < i16 || rawY > measuredHeight || rawX < i3 || rawX > measuredWidth) {
            return false;
        }
        return true;
    }

    public float a(float f16) {
        float f17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Float) iPatchRedirector.redirect((short) 13, this, Float.valueOf(f16))).floatValue();
        }
        if (this.F) {
            f17 = 0.0f;
        } else {
            f17 = 20.0f;
        }
        int f18 = BaseAIOUtils.f(f17, getContext().getResources());
        int scrollY = (int) (getScrollY() + f16);
        if (scrollY < f18) {
            return f16;
        }
        if (scrollY < f18) {
            return 0.0f;
        }
        a aVar = this.C;
        if (aVar != null) {
            aVar.scrollToTop();
        }
        return f18 - getScrollY();
    }

    @Override // android.view.View
    public void computeScroll() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.computeScroll();
        Scroller scroller = this.f298224m;
        if (scroller != null && scroller.computeScrollOffset()) {
            scrollTo(this.f298224m.getCurrX(), this.f298224m.getCurrY());
            invalidate();
        } else if (this.E) {
            this.E = false;
            a aVar = this.C;
            if (aVar != null) {
                aVar.b(this.f298223i);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, (Object) motionEvent)).booleanValue();
        }
        if (this.M) {
            return super.dispatchTouchEvent(motionEvent);
        }
        View view = this.G;
        if (view == null) {
            view = getChildAt(0);
        }
        if (!e(view, motionEvent) && this.f298223i != 1) {
            boolean z16 = this.K;
            return super.dispatchTouchEvent(motionEvent);
        }
        return b(motionEvent);
    }

    protected boolean e(View view, MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
        }
        if (this.f298220e) {
            return true;
        }
        if (this.f298221f && !f(view, motionEvent)) {
            return false;
        }
        this.f298220e = true;
        return true;
    }

    public void g(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, i3);
            return;
        }
        Scroller scroller = this.f298224m;
        if (scroller != null) {
            scroller.startScroll(0, getScrollY(), 0, i3 - getScrollY());
            invalidate();
        } else {
            scrollTo(0, i3);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) motionEvent)).booleanValue();
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setAtPanelTouchListener(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) aVar);
        } else {
            this.C = aVar;
        }
    }

    public void setControlLitTongue(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, z16);
        } else {
            this.f298221f = z16;
        }
    }

    public void setCustomParam(b bVar, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, bVar, Boolean.valueOf(z16));
        } else {
            this.K = z16;
        }
    }

    public void setDisableMinScrollY(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, z16);
        } else {
            this.F = z16;
        }
    }

    public void setHeadView(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) view);
        } else {
            this.G = view;
        }
    }

    public void setMode(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, i3);
        } else {
            this.f298223i = i3;
        }
    }

    public AtPanelTouchController(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f298219d = 0.0f;
        this.f298220e = false;
        this.f298221f = true;
        this.f298222h = false;
        this.f298223i = 1;
        this.D = 0;
        this.E = false;
        this.F = false;
        this.G = null;
        this.L = false;
        this.M = false;
        d();
    }

    public AtPanelTouchController(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.f298219d = 0.0f;
        this.f298220e = false;
        this.f298221f = true;
        this.f298222h = false;
        this.f298223i = 1;
        this.D = 0;
        this.E = false;
        this.F = false;
        this.G = null;
        this.L = false;
        this.M = false;
        d();
    }
}
