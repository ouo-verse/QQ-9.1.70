package com.tencent.mobileqq.statistics;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicLong;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes18.dex */
public class DcReportUtil {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static AtomicLong f289898a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36051);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f289898a = new AtomicLong(0L);
        }
    }

    private static void a(AppRuntime appRuntime, String str, String str2, int i3) {
        z91.b b16;
        ReportController reportController;
        if (str2 == null || (b16 = com.tencent.mobileqq.bridge.a.b()) == null || (reportController = (ReportController) b16.b(appRuntime)) == null) {
            return;
        }
        if (str2.contains("${uin_unknown}")) {
            str2 = str2.replace("${uin_unknown}", appRuntime.getAccount());
        }
        reportController.b(str, str2, i3);
    }

    public static void b(AppRuntime appRuntime, String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (appRuntime == null) {
                ThreadManagerV2.post(new Runnable(str, str2) { // from class: com.tencent.mobileqq.statistics.DcReportUtil.2
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ String f289901d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ String f289902e;

                    {
                        this.f289901d = str;
                        this.f289902e = str2;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) str2);
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
                            Intent intent = new Intent();
                            intent.setClassName(BaseApplication.context, "com.tencent.mobileqq.statistics.ReportReceiver");
                            intent.putExtra("reporting_tag", this.f289901d);
                            intent.putExtra("reporting_detail", this.f289902e);
                            intent.putExtra("reporting_count", 1);
                            intent.putExtra("is_runtime", 0);
                            MobileQQ.sMobileQQ.sendBroadcast(intent);
                        } catch (Exception e16) {
                            QLog.e("DcReportUtil", 1, "reportDCEvent e:" + e16);
                        }
                    }
                }, 5, null, true);
                return;
            } else {
                a(appRuntime, str, str2, 1);
                return;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("DcReportUtil", 2, "reportDCEvent tag or detail is null: " + str + ", " + str2);
        }
    }

    public static void c(AppRuntime appRuntime, String str, String str2, boolean z16) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String str3 = "${count_unknown}|" + str2;
            if (!z16) {
                str3 = "${report_seq_prefix}" + f289898a.incrementAndGet() + "|" + str3;
            }
            if (appRuntime == null) {
                ThreadManagerV2.post(new Runnable(str, str3) { // from class: com.tencent.mobileqq.statistics.DcReportUtil.1
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ String f289899d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ String f289900e;

                    {
                        this.f289899d = str;
                        this.f289900e = str3;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) str3);
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
                            Intent intent = new Intent();
                            intent.setClassName(BaseApplication.context, "com.tencent.mobileqq.statistics.ReportReceiver");
                            intent.putExtra("reporting_tag", this.f289899d);
                            intent.putExtra("reporting_detail", this.f289900e);
                            intent.putExtra("reporting_count", 1);
                            intent.putExtra("is_runtime", 0);
                            MobileQQ.sMobileQQ.sendBroadcast(intent);
                        } catch (Exception e16) {
                            QLog.e("DcReportUtil", 1, "reportDCEvent e:" + e16);
                        }
                    }
                }, 5, null, true);
            } else {
                a(appRuntime, str, str3, 1);
            }
        }
    }
}
