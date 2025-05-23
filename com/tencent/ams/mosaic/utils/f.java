package com.tencent.ams.mosaic.utils;

import android.util.Log;
import com.tencent.ams.mosaic.f;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes3.dex */
public class f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final a f71564a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class a implements f.e {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.ams.mosaic.f.e
        public void d(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) str2);
            } else {
                Log.d(str, str2);
            }
        }

        @Override // com.tencent.ams.mosaic.f.e
        public void e(String str, String str2, Throwable th5) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, this, str, str2, th5);
            } else {
                Log.e(str, str2, th5);
            }
        }

        @Override // com.tencent.ams.mosaic.f.e
        public void i(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, (Object) str2);
            } else {
                Log.i(str, str2);
            }
        }

        @Override // com.tencent.ams.mosaic.f.e
        public void v(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) str2);
            } else {
                Log.v(str, str2);
            }
        }

        @Override // com.tencent.ams.mosaic.f.e
        public void w(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                Log.w(str, str2);
            } else {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) str, (Object) str2);
            }
        }

        @Override // com.tencent.ams.mosaic.f.e
        public void w(String str, String str2, Throwable th5) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
                Log.w(str, str2, th5);
            } else {
                iPatchRedirector.redirect((short) 6, this, str, str2, th5);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59199);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f71564a = new a();
        }
    }

    public static void a(String str, String str2) {
        f().d("Mosaic_" + str, str2);
    }

    public static void b(String str, String str2) {
        f().e("Mosaic_" + str, str2, null);
    }

    public static void c(String str, String str2, Throwable th5) {
        f().e("Mosaic_" + str, str2, th5);
    }

    public static void d(String str, Throwable th5) {
        b("Mosaic_" + str, Log.getStackTraceString(th5));
    }

    public static void e(String str, String str2) {
        f().i("Mosaic_" + str, str2);
    }

    private static f.e f() {
        f.e m3 = com.tencent.ams.mosaic.f.k().m();
        if (m3 != null) {
            return m3;
        }
        return f71564a;
    }

    public static void g(String str, String str2) {
        f().v("Mosaic_" + str, str2);
    }

    public static void h(String str, String str2) {
        f().w("Mosaic_" + str, str2);
    }

    public static void i(String str, String str2, Throwable th5) {
        f().w("Mosaic_" + str, str2, th5);
    }
}
