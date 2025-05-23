package com.tencent.mobileqq.listentogether.lyrics;

import android.content.Context;
import android.os.Build;
import android.view.MotionEvent;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes33.dex */
public class FloatBaseLayout extends FrameLayout {
    int C;
    float D;
    float E;
    float F;
    float G;
    boolean H;
    float I;
    boolean J;

    /* renamed from: d, reason: collision with root package name */
    a f240986d;

    /* renamed from: e, reason: collision with root package name */
    public int f240987e;

    /* renamed from: f, reason: collision with root package name */
    public int f240988f;

    /* renamed from: h, reason: collision with root package name */
    WindowManager f240989h;

    /* renamed from: i, reason: collision with root package name */
    WindowManager.LayoutParams f240990i;

    /* renamed from: m, reason: collision with root package name */
    boolean f240991m;

    public FloatBaseLayout(Context context) {
        super(context);
        this.f240991m = false;
        this.C = 0;
        this.H = false;
        this.I = 6.0f;
        this.J = false;
        m(context);
    }

    private void c() {
        try {
            this.f240990i.getClass().getField("privateFlags").set(this.f240990i, Integer.valueOf(((Integer) this.f240990i.getClass().getField("privateFlags").get(this.f240990i)).intValue() | 64));
        } catch (Exception unused) {
        }
    }

    public void b() {
        if (this.f240991m) {
            try {
                this.f240989h.updateViewLayout(this, this.f240990i);
            } catch (Throwable th5) {
                QLog.e("FloatBaseLayout", 1, "showOrUpdate updateViewLayout error: " + th5.getMessage());
            }
        }
    }

    public int d() {
        return this.f240990i.x;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        int action = motionEvent.getAction();
        boolean z16 = true;
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    if (Math.abs(rawX - this.F) > this.I && Math.abs(rawY - this.G) > this.I && this.J && !this.H) {
                        this.H = true;
                        o();
                    }
                    a aVar = this.f240986d;
                    if (aVar != null && this.H) {
                        aVar.e((int) (rawX - this.D), (int) (rawY - this.E));
                    }
                    if (!this.H) {
                        z16 = super.dispatchTouchEvent(motionEvent);
                    }
                } else if (action != 3) {
                    z16 = false;
                }
            }
            a aVar2 = this.f240986d;
            if (aVar2 != null && this.H) {
                aVar2.b();
            }
            if (this.H) {
                p();
            } else {
                z16 = super.dispatchTouchEvent(motionEvent);
            }
            this.H = false;
            this.J = false;
        } else {
            this.F = rawX;
            this.G = rawY;
            this.H = false;
            this.J = true;
            z16 = super.dispatchTouchEvent(motionEvent);
        }
        this.D = rawX;
        this.E = rawY;
        return z16;
    }

    public int e() {
        return this.f240990i.y;
    }

    public int f() {
        WindowManager.LayoutParams layoutParams = this.f240990i;
        return layoutParams.x + (layoutParams.width / 2);
    }

    public int g() {
        return this.f240988f;
    }

    public int h() {
        WindowManager.LayoutParams layoutParams = this.f240990i;
        return layoutParams.x + layoutParams.width;
    }

    public int i() {
        return this.f240990i.x;
    }

    public int j() {
        return this.f240987e;
    }

    @Override // android.view.View
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public WindowManager.LayoutParams getLayoutParams() {
        return this.f240990i;
    }

    public boolean l() {
        boolean z16;
        synchronized (this) {
            z16 = true;
            if (this.f240991m) {
                try {
                    this.f240989h.removeView(this);
                    this.f240991m = false;
                } catch (Throwable th5) {
                    QLog.e("FloatBaseLayout", 1, "showOrUpdate addView error: " + th5.getMessage());
                    z16 = false;
                }
            }
            this.C = 0;
        }
        return z16;
    }

    public boolean n() {
        return this.f240991m;
    }

    public boolean q() {
        boolean z16;
        if (QLog.isColorLevel()) {
            QLog.d("FloatBaseLayout", 2, "showOrUpdate mAdded: " + this.f240991m);
        }
        synchronized (this) {
            boolean z17 = this.f240991m;
            z16 = false;
            if (z17) {
                if (z17) {
                    try {
                        this.f240989h.updateViewLayout(this, this.f240990i);
                    } catch (Throwable th5) {
                        QLog.e("FloatBaseLayout", 1, "showOrUpdate updateViewLayout error: " + th5.getMessage());
                    }
                }
                z16 = true;
            } else {
                if (this.C < 4) {
                    try {
                        this.f240989h.addView(this, this.f240990i);
                        this.f240991m = true;
                        this.C = 0;
                    } catch (Throwable th6) {
                        this.C++;
                        QLog.e("FloatBaseLayout", 1, "showOrUpdate addView mExceptionCount:" + this.C + " error:" + th6.getMessage());
                    }
                }
                z16 = true;
            }
        }
        return z16;
    }

    public void r(int i3, int i16) {
        WindowManager.LayoutParams layoutParams = this.f240990i;
        if (i3 == layoutParams.x && i16 == layoutParams.y) {
            return;
        }
        layoutParams.x = i3;
        layoutParams.y = i16;
    }

    public void setFloatLayoutCallback(a aVar) {
        this.f240986d = aVar;
    }

    public void destroy() {
        this.f240986d = null;
    }

    private void m(Context context) {
        this.I = BaseAIOUtils.f(3.0f, getResources());
        this.f240989h = (WindowManager) getContext().getSystemService("window");
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.f240990i = layoutParams;
        layoutParams.format = -3;
        layoutParams.flags = 808;
        if (Build.VERSION.SDK_INT >= 26) {
            layoutParams.type = 2038;
        } else {
            layoutParams.type = 2002;
        }
        layoutParams.systemUiVisibility = 5892;
        layoutParams.gravity = 85;
        layoutParams.setTitle("FloatBaseLayout");
        WindowManager.LayoutParams layoutParams2 = this.f240990i;
        layoutParams2.x = 0;
        layoutParams2.y = 0;
        c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void o() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void p() {
    }
}
