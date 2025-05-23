package com.tencent.mobileqq.qqbattery.utils;

import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes16.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static b f262369a;

    /* renamed from: b, reason: collision with root package name */
    public static InterfaceC8297a f262370b;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.qqbattery.utils.a$a, reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    public interface InterfaceC8297a {
        void d(String str, String str2, Object... objArr);

        void e(String str, String str2, Object... objArr);

        void i(String str, String str2, Object... objArr);

        void printErrStackTrace(String str, Throwable th5, String str2, Object... objArr);

        void w(String str, String str2, Object... objArr);
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class b implements InterfaceC8297a {
        static IPatchRedirector $redirector_;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.qqbattery.utils.a.InterfaceC8297a
        public final void d(String str, String str2, Object... objArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, str, str2, objArr);
                return;
            }
            if (objArr != null && objArr.length != 0) {
                str2 = String.format(str2, objArr);
            }
            Log.d(str, str2);
        }

        @Override // com.tencent.mobileqq.qqbattery.utils.a.InterfaceC8297a
        public final void e(String str, String str2, Object... objArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, this, str, str2, objArr);
                return;
            }
            if (objArr != null && objArr.length != 0) {
                str2 = String.format(str2, objArr);
            }
            Log.e(str, str2);
        }

        @Override // com.tencent.mobileqq.qqbattery.utils.a.InterfaceC8297a
        public final void i(String str, String str2, Object... objArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, str, str2, objArr);
                return;
            }
            if (objArr != null && objArr.length != 0) {
                str2 = String.format(str2, objArr);
            }
            Log.i(str, str2);
        }

        @Override // com.tencent.mobileqq.qqbattery.utils.a.InterfaceC8297a
        public final void printErrStackTrace(String str, Throwable th5, String str2, Object... objArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, this, str, th5, str2, objArr);
                return;
            }
            if (objArr != null && objArr.length != 0) {
                str2 = String.format(str2, objArr);
            }
            if (str2 == null) {
                str2 = "";
            }
            Log.e(str, str2 + "  " + Log.getStackTraceString(th5));
        }

        @Override // com.tencent.mobileqq.qqbattery.utils.a.InterfaceC8297a
        public final void w(String str, String str2, Object... objArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, str, str2, objArr);
                return;
            }
            if (objArr != null && objArr.length != 0) {
                str2 = String.format(str2, objArr);
            }
            Log.w(str, str2);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(15751);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        b bVar = new b();
        f262369a = bVar;
        f262370b = bVar;
    }

    public static void a(String str, String str2, Object... objArr) {
        InterfaceC8297a interfaceC8297a = f262370b;
        if (interfaceC8297a != null) {
            interfaceC8297a.d(str, str2, objArr);
        }
    }

    public static void b(String str, String str2, Object... objArr) {
        InterfaceC8297a interfaceC8297a = f262370b;
        if (interfaceC8297a != null) {
            interfaceC8297a.e(str, str2, objArr);
        }
    }

    public static void c(String str, String str2, Object... objArr) {
        InterfaceC8297a interfaceC8297a = f262370b;
        if (interfaceC8297a != null) {
            interfaceC8297a.i(str, str2, objArr);
        }
    }

    public static void d(String str, Throwable th5, String str2, Object... objArr) {
        InterfaceC8297a interfaceC8297a = f262370b;
        if (interfaceC8297a != null) {
            interfaceC8297a.printErrStackTrace(str, th5, str2, objArr);
        }
    }

    public static void e(InterfaceC8297a interfaceC8297a) {
        f262370b = interfaceC8297a;
    }

    public static void f(String str, String str2, Object... objArr) {
        InterfaceC8297a interfaceC8297a = f262370b;
        if (interfaceC8297a != null) {
            interfaceC8297a.w(str, str2, objArr);
        }
    }
}
