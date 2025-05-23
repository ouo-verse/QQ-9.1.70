package com.tencent.qqcamerakit.capture;

import android.app.Activity;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import androidx.annotation.RequiresApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes22.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    private static Context f344806b;

    /* renamed from: a, reason: collision with root package name */
    private com.tencent.qqcamerakit.capture.a f344807a;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public interface a {
        void onAutoFocusCallback(boolean z16);
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public interface b {
        void a(String str);
    }

    public c(Context context, Handler handler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) handler);
        } else {
            f344806b = context.getApplicationContext();
            this.f344807a = new com.tencent.qqcamerakit.capture.a(handler, true);
        }
    }

    public static Context d() {
        return f344806b;
    }

    public void a(d dVar, boolean z16, String str, int i3, b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, this, dVar, Boolean.valueOf(z16), str, Integer.valueOf(i3), bVar);
        } else {
            this.f344807a.i(dVar, z16, str, i3, bVar);
        }
    }

    public void b(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, z16);
        } else {
            this.f344807a.e(z16);
        }
    }

    public Object c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return iPatchRedirector.redirect((short) 33, (Object) this);
        }
        return this.f344807a.j();
    }

    public long e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Long) iPatchRedirector.redirect((short) 22, (Object) this)).longValue();
        }
        return this.f344807a.l();
    }

    public int f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Integer) iPatchRedirector.redirect((short) 21, (Object) this)).intValue();
        }
        return this.f344807a.m();
    }

    public boolean g(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, i3)).booleanValue();
        }
        return this.f344807a.n(i3);
    }

    public void h(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
        } else {
            this.f344807a.d(i3, false);
        }
    }

    public void i(int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Boolean.valueOf(z16));
        } else {
            this.f344807a.d(i3, z16);
        }
    }

    public void j(com.tencent.qqcamerakit.common.d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) dVar);
        } else {
            this.f344807a.p(dVar);
        }
    }

    public void k(Matrix matrix, a aVar, int i3, int i16, int i17, float f16, float f17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, matrix, aVar, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Float.valueOf(f16), Float.valueOf(f17));
        } else {
            this.f344807a.r(matrix, aVar, i3, i16, i17, f16, f17);
        }
    }

    public void l(int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, Integer.valueOf(i3), Long.valueOf(j3));
        } else {
            this.f344807a.t(i3, j3);
        }
    }

    public void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this);
        } else {
            this.f344807a.v();
        }
    }

    public void n(Activity activity, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, activity, Boolean.valueOf(z16));
        } else {
            this.f344807a.w(activity, z16);
        }
    }

    @RequiresApi(api = 21)
    public void o(d dVar, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) dVar, i3);
        } else {
            this.f344807a.x(dVar, dVar, dVar, i3, "continuous-picture", 4, 0);
        }
    }

    public void p(d dVar, d dVar2, d dVar3, int i3, String str, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, dVar, dVar2, dVar3, Integer.valueOf(i3), str, Integer.valueOf(i16), Integer.valueOf(i17));
        } else {
            this.f344807a.x(dVar, dVar2, dVar3, i3, str, i16, i17);
        }
    }

    public void q(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, this, Float.valueOf(f16));
        } else {
            this.f344807a.A(f16);
        }
    }

    public void r(SurfaceTexture surfaceTexture, com.tencent.qqcamerakit.capture.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) surfaceTexture, (Object) bVar);
        } else {
            this.f344807a.f(surfaceTexture, bVar);
        }
    }

    public void s(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, z16);
        } else {
            this.f344807a.g(z16);
        }
    }

    public void t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this);
        } else {
            this.f344807a.D();
        }
    }

    public void u(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, z16);
        } else {
            this.f344807a.E(z16);
        }
    }

    public void v(com.tencent.qqcamerakit.common.d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) dVar);
        } else {
            this.f344807a.F(dVar);
        }
    }

    public c(Context context, Handler handler, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, handler, Boolean.valueOf(z16));
        } else {
            f344806b = context.getApplicationContext();
            this.f344807a = new com.tencent.qqcamerakit.capture.a(handler, z16);
        }
    }
}
