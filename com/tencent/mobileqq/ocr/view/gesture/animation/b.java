package com.tencent.mobileqq.ocr.view.gesture.animation;

import android.os.SystemClock;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes16.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final Interpolator f255012a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f255013b;

    /* renamed from: c, reason: collision with root package name */
    private float f255014c;

    /* renamed from: d, reason: collision with root package name */
    private float f255015d;

    /* renamed from: e, reason: collision with root package name */
    private float f255016e;

    /* renamed from: f, reason: collision with root package name */
    private long f255017f;

    /* renamed from: g, reason: collision with root package name */
    private long f255018g;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f255013b = true;
        this.f255018g = 250L;
        this.f255012a = new AccelerateDecelerateInterpolator();
    }

    private static float d(float f16, float f17, float f18) {
        return f16 + ((f17 - f16) * f18);
    }

    public boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        if (this.f255013b) {
            return false;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.f255017f;
        long j3 = this.f255018g;
        if (elapsedRealtime >= j3) {
            this.f255013b = true;
            this.f255016e = this.f255015d;
            return false;
        }
        this.f255016e = d(this.f255014c, this.f255015d, this.f255012a.getInterpolation(((float) elapsedRealtime) / ((float) j3)));
        return true;
    }

    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            this.f255013b = true;
        }
    }

    public float c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Float) iPatchRedirector.redirect((short) 8, (Object) this)).floatValue();
        }
        return this.f255016e;
    }

    public boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return this.f255013b;
    }

    public void f(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, j3);
        } else {
            this.f255018g = j3;
        }
    }

    public void g(float f16, float f17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Float.valueOf(f16), Float.valueOf(f17));
            return;
        }
        this.f255013b = false;
        this.f255017f = SystemClock.elapsedRealtime();
        this.f255014c = f16;
        this.f255015d = f17;
        this.f255016e = f16;
    }
}
