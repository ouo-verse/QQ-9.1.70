package com.tencent.mobileqq.perf.thread.handlerthread;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes16.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static volatile com.tencent.qqperf.monitor.crash.safemode.a f258148a;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class a implements com.tencent.qqperf.monitor.crash.safemode.a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.qqperf.monitor.crash.safemode.a
        public void a(Context context) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
            } else {
                ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).removeLocal("light_msg_queue");
                QLog.w("LightMsgQ.helper", 1, "ISafeModeStartUpRunner run");
            }
        }

        @Override // com.tencent.qqperf.monitor.crash.safemode.a
        public String b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return "LightMessageQueue";
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(47720);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f258148a = null;
        }
    }

    public static com.tencent.qqperf.monitor.crash.safemode.a a() {
        if (f258148a == null) {
            f258148a = new a();
        }
        return f258148a;
    }
}
