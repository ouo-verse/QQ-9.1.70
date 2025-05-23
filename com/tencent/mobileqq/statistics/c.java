package com.tencent.mobileqq.statistics;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluginsdk.exception.ExceptionTracker;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;

/* compiled from: P */
/* loaded from: classes18.dex */
public class c {
    static IPatchRedirector $redirector_;

    private static String a(com.tencent.mobileqq.statistics.reportitem.a aVar) {
        if (aVar == null) {
            return null;
        }
        return aVar.a();
    }

    public static void b(String str, QQAppInterface qQAppInterface, String str2) {
        ReportController reportController;
        if (!TextUtils.isEmpty(str2) && qQAppInterface != null && (reportController = qQAppInterface.getReportController()) != null) {
            reportController.b(str, str2, 1);
        }
    }

    public static void c(String str, QQAppInterface qQAppInterface, String str2) {
        if (!TextUtils.isEmpty(str2) && qQAppInterface != null) {
            if (str2.contains("${count_unknown}")) {
                str2 = str2.replace("${count_unknown}", "1");
            }
            NewIntent newIntent = new NewIntent(qQAppInterface.getApplication(), com.tencent.mobileqq.servlet.q.class);
            newIntent.putExtra("sendType", 2);
            newIntent.putExtra("tag", str);
            newIntent.putExtra("content", str2);
            newIntent.setWithouLogin(true);
            qQAppInterface.startServlet(newIntent);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("CaptureReportController", 2, "app or detail invalid. app : " + qQAppInterface + "  detail : " + str2);
        }
    }

    private static void d(String str, QQAppInterface qQAppInterface, com.tencent.mobileqq.statistics.reportitem.a aVar) {
        AppRuntime peekAppRuntime;
        if (aVar == null) {
            ExceptionTracker.trackException("CaptureReportController", "Capture Report not runtime Tag(" + str + ") report item is null");
            QLog.isColorLevel();
            return;
        }
        if (TextUtils.isEmpty(aVar.f290086c)) {
            QLog.isColorLevel();
            return;
        }
        QLog.isColorLevel();
        if (qQAppInterface == null && MobileQQ.sProcessId == 1 && (peekAppRuntime = BaseApplicationImpl.getApplication().peekAppRuntime()) != null && (peekAppRuntime instanceof QQAppInterface)) {
            qQAppInterface = (QQAppInterface) peekAppRuntime;
        }
        if (qQAppInterface == null) {
            String a16 = a(aVar);
            Intent intent = new Intent();
            intent.setClassName(BaseApplicationImpl.sApplication, "com.tencent.mobileqq.statistics.ReportReceiver");
            intent.putExtra("reporting_tag", str);
            intent.putExtra("reporting_detail", a16);
            intent.putExtra("reporting_count", 1);
            intent.putExtra("is_runtime", 0);
            BaseApplicationImpl.getApplication().sendBroadcast(intent);
            return;
        }
        b(str, qQAppInterface, a(aVar));
    }

    public static void e(QQAppInterface qQAppInterface, com.tencent.mobileqq.statistics.reportitem.b bVar) {
        d("dc02181", qQAppInterface, bVar);
    }
}
