package com.tencent.mobileqq.ocr.view.gesture.detector;

import android.content.Context;
import android.view.MotionEvent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes16.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final a f255048a;

    /* renamed from: b, reason: collision with root package name */
    private float f255049b;

    /* renamed from: c, reason: collision with root package name */
    private float f255050c;

    /* renamed from: d, reason: collision with root package name */
    private float f255051d;

    /* renamed from: e, reason: collision with root package name */
    private float f255052e;

    /* renamed from: f, reason: collision with root package name */
    private float f255053f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f255054g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f255055h;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public interface a {
        boolean a(b bVar);

        void b(b bVar);

        boolean c(b bVar);
    }

    public b(Context context, a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) aVar);
        } else {
            this.f255048a = aVar;
        }
    }

    private void a() {
        if (!this.f255054g) {
            return;
        }
        this.f255054g = false;
        if (this.f255055h) {
            this.f255048a.b(this);
            this.f255055h = false;
        }
    }

    private float b(MotionEvent motionEvent) {
        return (float) Math.toDegrees(Math.atan2(motionEvent.getY(1) - motionEvent.getY(0), motionEvent.getX(1) - motionEvent.getX(0)));
    }

    private boolean g() {
        if (this.f255054g && this.f255055h && this.f255048a.a(this)) {
            return true;
        }
        return false;
    }

    private void h() {
        if (!this.f255054g && Math.abs(this.f255051d - this.f255052e) >= 5.0f) {
            this.f255054g = true;
            this.f255055h = this.f255048a.c(this);
        }
    }

    public float c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Float) iPatchRedirector.redirect((short) 4, (Object) this)).floatValue();
        }
        return this.f255049b;
    }

    public float d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Float) iPatchRedirector.redirect((short) 5, (Object) this)).floatValue();
        }
        return this.f255050c;
    }

    public float e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Float) iPatchRedirector.redirect((short) 6, (Object) this)).floatValue();
        }
        return this.f255052e - this.f255053f;
    }

    public boolean f(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) motionEvent)).booleanValue();
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0 && actionMasked != 1) {
            if (actionMasked != 2) {
                if (actionMasked != 3) {
                    if (actionMasked != 5) {
                        if (actionMasked == 6 && motionEvent.getPointerCount() == 2) {
                            a();
                        }
                    } else if (motionEvent.getPointerCount() == 2) {
                        float b16 = b(motionEvent);
                        this.f255052e = b16;
                        this.f255053f = b16;
                        this.f255051d = b16;
                    }
                }
            } else if (motionEvent.getPointerCount() >= 2 && (!this.f255054g || this.f255055h)) {
                this.f255052e = b(motionEvent);
                boolean z16 = false;
                this.f255049b = (motionEvent.getX(1) + motionEvent.getX(0)) * 0.5f;
                this.f255050c = (motionEvent.getY(1) + motionEvent.getY(0)) * 0.5f;
                boolean z17 = this.f255054g;
                h();
                if (!z17 || g()) {
                    z16 = true;
                }
                if (z16) {
                    this.f255053f = this.f255052e;
                }
            }
            return true;
        }
        a();
        return true;
    }
}
