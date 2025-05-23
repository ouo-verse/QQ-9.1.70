package com.tencent.qqcamerakit.common;

import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes22.dex */
public class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static int f344918a;

    /* renamed from: b, reason: collision with root package name */
    private static com.tencent.qqcamerakit.common.b f344919b;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    private static class b implements com.tencent.qqcamerakit.common.b {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        @Override // com.tencent.qqcamerakit.common.b
        public void d(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) str, (Object) str2);
            } else {
                Log.d(str, str2);
            }
        }

        @Override // com.tencent.qqcamerakit.common.b
        public void e(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                Log.e(str, str2);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) str2);
            }
        }

        @Override // com.tencent.qqcamerakit.common.b
        public void i(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) str, (Object) str2);
            } else {
                Log.i(str, str2);
            }
        }

        @Override // com.tencent.qqcamerakit.common.b
        public void w(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, (Object) str2);
            } else {
                Log.w(str, str2);
            }
        }

        /* synthetic */ b(a aVar) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
                return;
            }
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) aVar);
        }

        @Override // com.tencent.qqcamerakit.common.b
        public void e(String str, String str2, Throwable th5) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                Log.e(str, str2, th5);
            } else {
                iPatchRedirector.redirect((short) 3, this, str, str2, th5);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11574);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f344918a = 2;
            f344919b = new b(null);
        }
    }

    public static void a(String str, int i3, Object... objArr) {
        if (f344918a >= i3) {
            StringBuilder sb5 = new StringBuilder(objArr.length * 30);
            for (Object obj : objArr) {
                if (obj != null) {
                    sb5.append(obj);
                }
            }
            f344919b.d(str, sb5.toString());
        }
    }

    public static void b(String str, int i3, String str2, Throwable th5) {
        if (f344918a >= i3) {
            if (str2 == null) {
                str2 = "";
            }
            if (th5 == null) {
                f344919b.e(str, str2);
            } else {
                f344919b.e(str, str2, th5);
            }
        }
    }

    public static void c(String str, int i3, Throwable th5, Object... objArr) {
        int i16;
        int length = objArr.length * 30;
        if (th5 == null) {
            i16 = 0;
        } else {
            i16 = 128;
        }
        StringBuilder sb5 = new StringBuilder(length + i16);
        for (Object obj : objArr) {
            if (obj != null) {
                sb5.append(obj);
            }
        }
        b(str, i3, sb5.toString(), th5);
    }

    public static void d(String str, int i3, Object... objArr) {
        c(str, i3, null, objArr);
    }

    public static void e(String str, int i3, Object... objArr) {
        if (f344918a >= i3) {
            StringBuilder sb5 = new StringBuilder(objArr.length * 30);
            for (Object obj : objArr) {
                if (obj != null) {
                    sb5.append(obj);
                }
            }
            f344919b.i(str, sb5.toString());
        }
    }

    public static boolean f() {
        if (f344918a > 1) {
            return true;
        }
        return false;
    }

    public static void g(int i3) {
        int i16 = 2;
        if (i3 < 2) {
            i16 = 1;
        }
        f344918a = i16;
    }

    public static void h(String str, int i3, Object... objArr) {
        if (f344918a >= i3) {
            StringBuilder sb5 = new StringBuilder(objArr.length * 30);
            for (Object obj : objArr) {
                if (obj != null) {
                    sb5.append(obj);
                }
            }
            f344919b.w(str, sb5.toString());
        }
    }
}
