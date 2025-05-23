package com.tencent.mobileqq.statistics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes18.dex */
public class ReportReceiver extends BroadcastReceiver {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    static class ReportRunner implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private Intent f289930d;

        public ReportRunner(Intent intent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) intent);
            } else {
                this.f289930d = intent;
            }
        }

        private void e() {
            AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
            if (waitAppRuntime != null && MobileQQ.PACKAGE_NAME.equals(MobileQQ.sMobileQQ.getQQProcessName())) {
                int intExtra = this.f289930d.getIntExtra("is_runtime", -1);
                String stringExtra = this.f289930d.getStringExtra("reporting_tag");
                if (f(intExtra, stringExtra)) {
                    String stringExtra2 = this.f289930d.getStringExtra("reporting_detail");
                    int intExtra2 = this.f289930d.getIntExtra("reporting_count", 1);
                    if (intExtra == 0) {
                        ReportController.m(waitAppRuntime, stringExtra, stringExtra2, intExtra2);
                        return;
                    } else {
                        if (intExtra == 1) {
                            ReportController.p(waitAppRuntime, stringExtra, stringExtra2, intExtra2);
                            return;
                        }
                        return;
                    }
                }
                z91.c c16 = com.tencent.mobileqq.bridge.a.c();
                if (c16 != null) {
                    c16.a(this.f289930d, waitAppRuntime);
                }
            }
        }

        private boolean f(int i3, String str) {
            if (i3 == 1001 || "dc02528".equals(str) || "dc02181".equals(str) || "dc_qqgame".equals(str)) {
                return false;
            }
            return true;
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            try {
                e();
            } catch (Throwable th5) {
                QLog.e("ReportReceiver", 1, th5, new Object[0]);
            }
        }
    }

    public ReportReceiver() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
        } else {
            if (!"Success".equals(MobileQQ.sInjectResult)) {
                return;
            }
            ThreadManager.getSubThreadHandler().post(new ReportRunner(intent));
        }
    }
}
