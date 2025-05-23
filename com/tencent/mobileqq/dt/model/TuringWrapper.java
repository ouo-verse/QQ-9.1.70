package com.tencent.mobileqq.dt.model;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.dt.web.O3BusinessHandler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes5.dex */
public class TuringWrapper {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final AtomicBoolean f203815a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a extends com.tencent.mobileqq.dt.web.a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.dt.web.a
        public void b(int i3, byte[] bArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) bArr);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(26692);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f203815a = new AtomicBoolean(false);
        }
    }

    public static void c() {
        com.tencent.mobileqq.turingfd.c.a().e();
        String d16 = com.tencent.mobileqq.turingfd.c.f303441b.d(false);
        if (!TextUtils.isEmpty(d16)) {
            com.tencent.mobileqq.fe.f.a().f("DeviceToken-TuringCache-V001", d16);
        }
        String g16 = com.tencent.mobileqq.turingfd.c.f303441b.g(true);
        if (!TextUtils.isEmpty(g16)) {
            com.tencent.mobileqq.fe.f.a().f("TuringRiskID-TuringCache-20230511", g16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            ((O3BusinessHandler) ((AppInterface) peekAppRuntime).getBusinessHandler(O3BusinessHandler.class.getName())).D2("requestToken", "", new a());
        } else {
            QLog.e("FEKitMainTuringWrapper", 1, "fekit notify foreground but runtime is null");
        }
    }

    public static void e() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.dt.model.TuringWrapper.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                try {
                    if (com.tencent.mobileqq.dt.app.a.c().d().e()) {
                        com.tencent.mobileqq.turingfd.c.a().e();
                        if (!TuringWrapper.f203815a.compareAndSet(false, true)) {
                            return;
                        }
                        String g16 = com.tencent.mobileqq.turingfd.c.f303441b.g(true);
                        if (!TextUtils.isEmpty(g16)) {
                            com.tencent.mobileqq.fe.f.a().f("TuringRiskID-TuringCache-20230511", g16);
                        }
                        TuringWrapper.d();
                        return;
                    }
                    QLog.e("FEKitMainTuringWrapper", 1, "turing disable! ");
                } catch (Throwable unused) {
                }
            }
        }, 16, null, false);
    }
}
