package com.tencent.ams.xsad.rewarded.utils;

import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes3.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final d f71859a;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class a implements d {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.ams.xsad.rewarded.utils.d
        public void d(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) str2);
            } else {
                Log.d(str, str2);
            }
        }

        @Override // com.tencent.ams.xsad.rewarded.utils.d
        public void e(String str, String str2, Throwable th5) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, this, str, str2, th5);
            } else {
                Log.e(str, str2, th5);
            }
        }

        @Override // com.tencent.ams.xsad.rewarded.utils.d
        public void i(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, (Object) str2);
            } else {
                Log.i(str, str2);
            }
        }

        @Override // com.tencent.ams.xsad.rewarded.utils.d
        public void w(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) str, (Object) str2);
            } else {
                Log.w(str, str2);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14868);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f71859a = new a();
        }
    }

    public static void a(String str, String str2) {
        d().d("REWARDED_AD_" + str, str2);
    }

    public static void b(String str, String str2, Throwable th5) {
        d().e("REWARDED_AD_" + str, str2, th5);
    }

    public static void c(String str, String str2) {
        d().i("REWARDED_AD_" + str, str2);
    }

    private static d d() {
        d g16 = com.tencent.ams.xsad.rewarded.c.f().g();
        if (g16 == null) {
            return f71859a;
        }
        return g16;
    }

    public static void e(String str, String str2) {
        d().w("REWARDED_AD_" + str, str2);
    }
}
