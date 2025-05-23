package com.tencent.mobileqq.fe;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes12.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static IFEKitLog f205821a;

    /* renamed from: b, reason: collision with root package name */
    private static IFEKitLog f205822b;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    static class a extends IFEKitLog {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.fe.IFEKitLog
        public void d(String str, int i3, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, str, Integer.valueOf(i3), str2);
            } else {
                QLog.d(str, i3, str2);
            }
        }

        @Override // com.tencent.mobileqq.fe.IFEKitLog
        public void e(String str, int i3, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, str, Integer.valueOf(i3), str2);
            } else {
                QLog.e(str, i3, str2);
            }
        }

        @Override // com.tencent.mobileqq.fe.IFEKitLog
        public void i(String str, int i3, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, str, Integer.valueOf(i3), str2);
            } else {
                QLog.i(str, i3, str2);
            }
        }

        @Override // com.tencent.mobileqq.fe.IFEKitLog
        public void v(String str, int i3, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, this, str, Integer.valueOf(i3), str2);
            } else {
                QLog.i(str, i3, str2);
            }
        }

        @Override // com.tencent.mobileqq.fe.IFEKitLog
        public void w(String str, int i3, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, str, Integer.valueOf(i3), str2);
            } else {
                QLog.w(str, i3, str2);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13082);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f205822b = new a();
        }
    }

    public static void a(String str, int i3, String str2) {
        b().e(str, i3, str2);
    }

    public static IFEKitLog b() {
        IFEKitLog iFEKitLog = f205821a;
        if (iFEKitLog == null) {
            return f205822b;
        }
        return iFEKitLog;
    }

    public static void c(String str, int i3, String str2) {
        b().i(str, i3, str2);
    }

    public static void d(IFEKitLog iFEKitLog) {
        f205821a = iFEKitLog;
    }
}
