package com.tencent.mobileqq.activity.registerGuideLogin;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Scroller;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes10.dex */
public class TouchControllerFrameLayout extends FrameLayout {
    static IPatchRedirector $redirector_;
    private boolean C;
    private Scroller D;
    private a E;
    private int F;
    private View G;

    /* renamed from: d, reason: collision with root package name */
    private float f185719d;

    /* renamed from: e, reason: collision with root package name */
    private float f185720e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f185721f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f185722h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f185723i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f185724m;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public interface a {
        void b();
    }

    public TouchControllerFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f185719d = Float.MIN_VALUE;
        this.f185720e = Float.MIN_VALUE;
        this.f185722h = true;
        this.D = new Scroller(getContext());
    }

    private boolean b(MotionEvent motionEvent) {
        if (this.f185721f) {
            return true;
        }
        View view = this.G;
        if (view == null) {
            view = getChildAt(0);
        }
        if (!c(view, motionEvent)) {
            return false;
        }
        this.f185721f = true;
        return true;
    }

    private void d(int i3) {
        this.D.startScroll(0, getScrollY(), 0, i3 - getScrollY());
        invalidate();
    }

    public float a(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Float) iPatchRedirector.redirect((short) 8, this, Float.valueOf(f16))).floatValue();
        }
        if (QLog.isColorLevel()) {
            QLog.d("TouchControllerFrameLayout", 2, "canScrollDistance getScrollY()=", Integer.valueOf(getScrollY()), ", dist=", Float.valueOf(f16));
        }
        if (((int) (getScrollY() + f16)) >= 0) {
            return -getScrollY();
        }
        return f16;
    }

    public boolean c(View view, MotionEvent motionEvent) {
        boolean z16;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
        }
        if (view == null) {
            return false;
        }
        int rawY = (int) motionEvent.getRawY();
        int rawX = (int) motionEvent.getRawX();
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i3 = iArr[0];
        boolean z18 = true;
        int i16 = iArr[1];
        int measuredWidth = view.getMeasuredWidth() + i3;
        if (rawY <= view.getMeasuredHeight() + i16 && rawX >= i3 && rawX <= measuredWidth) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (rawY >= i16 && z16) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (this.f185722h) {
            return z17;
        }
        if (motionEvent.getAction() == 0) {
            if (z17) {
                return true;
            }
            if (rawY < 0 || !z16) {
                z18 = false;
            }
            this.f185723i = z18;
            return false;
        }
        if (!z17 || !this.f185723i) {
            return false;
        }
        return true;
    }

    @Override // android.view.View
    public void computeScroll() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        super.computeScroll();
        if (this.D.computeScrollOffset()) {
            scrollTo(this.D.getCurrX(), this.D.getCurrY());
            invalidate();
        } else if (this.f185724m) {
            this.f185724m = false;
            a aVar = this.E;
            if (aVar != null) {
                aVar.b();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0037, code lost:
    
        if (r1 != 3) goto L46;
     */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) motionEvent)).booleanValue();
        }
        if (!b(motionEvent)) {
            return super.dispatchTouchEvent(motionEvent);
        }
        float y16 = motionEvent.getY();
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    if (this.f185719d == Float.MIN_VALUE) {
                        this.f185719d = y16;
                        this.f185720e = y16;
                        return super.dispatchTouchEvent(motionEvent);
                    }
                    if (!this.C && Math.abs(y16 - this.f185720e) < 5.0f) {
                        this.f185719d = y16;
                        return true;
                    }
                    this.C = true;
                    float a16 = a(-(y16 - this.f185719d));
                    if (a16 != 0.0f) {
                        scrollBy(0, (int) a16);
                    }
                    this.f185719d = y16;
                    return true;
                }
            }
            this.f185721f = false;
            this.f185719d = Float.MIN_VALUE;
            this.f185720e = Float.MIN_VALUE;
            Object[] objArr = new Object[4];
            objArr[0] = "dispatchTouchEvent ACTION_UP -getScrollY()=";
            objArr[1] = Integer.valueOf(-getScrollY());
            objArr[2] = ", toUp=";
            if ((-getScrollY()) < this.F) {
                z16 = true;
            } else {
                z16 = false;
            }
            objArr[3] = Boolean.valueOf(z16);
            QLog.d("TouchControllerFrameLayout", 1, objArr);
            if (this.C) {
                motionEvent.setAction(3);
                super.dispatchTouchEvent(motionEvent);
                if ((-getScrollY()) < this.F) {
                    d(0);
                } else if (this.E != null) {
                    this.f185724m = true;
                    d(-getHeight());
                }
                return false;
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        this.C = false;
        this.f185719d = y16;
        this.f185720e = y16;
        QLog.d("TouchControllerFrameLayout", 1, "dispatchTouchEvent ACTION_DOWN mPreY=", Float.valueOf(y16));
        super.dispatchTouchEvent(motionEvent);
        return true;
    }

    public void setCustomTouchListener(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) aVar);
        } else {
            this.E = aVar;
        }
    }

    public void setHeadView(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
        } else {
            this.G = view;
        }
    }

    public void setIsInterceptContentEvent(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
        } else {
            this.f185722h = z16;
        }
    }

    public void setMaxScrollHeight(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
        } else {
            QLog.d("TouchControllerFrameLayout", 1, "maxScrollHeight=", Integer.valueOf(i3));
            this.F = i3;
        }
    }
}
