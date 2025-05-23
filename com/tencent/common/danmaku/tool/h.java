package com.tencent.common.danmaku.tool;

import android.graphics.Point;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class h {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final long f99800a;

    /* renamed from: b, reason: collision with root package name */
    public final Point f99801b;

    /* renamed from: c, reason: collision with root package name */
    public final int f99802c;

    /* renamed from: d, reason: collision with root package name */
    public float f99803d;

    /* renamed from: e, reason: collision with root package name */
    public float f99804e;

    public h(long j3, Point point, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), point, Integer.valueOf(i3));
            return;
        }
        this.f99803d = 0.0f;
        this.f99804e = 0.0f;
        this.f99800a = j3;
        this.f99801b = point;
        this.f99802c = i3;
    }

    public float a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Float) iPatchRedirector.redirect((short) 3, (Object) this)).floatValue();
        }
        return this.f99801b.x - this.f99803d;
    }

    public float b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Float) iPatchRedirector.redirect((short) 4, (Object) this)).floatValue();
        }
        return this.f99801b.y - this.f99804e;
    }

    public void c(float f16, float f17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Float.valueOf(f16), Float.valueOf(f17));
        } else {
            this.f99803d = f16;
            this.f99804e = f17;
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return "TouchPoint{mTime=" + this.f99800a + ", mPoint=" + this.f99801b + ", mDistanceOfError=" + this.f99802c + '}';
    }
}
