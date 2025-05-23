package com.tencent.mobileqq.leba.report;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pluginsdk.exception.ExceptionTracker;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.servlet.q;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;

/* compiled from: P */
/* loaded from: classes15.dex */
public class c {
    static IPatchRedirector $redirector_;

    private static String a(b bVar, int i3) {
        if (bVar == null) {
            return null;
        }
        return bVar.a(i3);
    }

    public static void b(String str, AppRuntime appRuntime, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            if (str2.contains("${count_unknown}")) {
                str2 = str2.replace("${count_unknown}", "1");
            }
            NewIntent newIntent = new NewIntent(appRuntime.getApplication(), q.class);
            newIntent.putExtra("sendType", 2);
            newIntent.putExtra("tag", str);
            newIntent.putExtra("content", str2);
            newIntent.setWithouLogin(true);
            appRuntime.startServlet(newIntent);
        }
    }

    private static void c(AppRuntime appRuntime, String str, b bVar) {
        if (bVar == null) {
            ExceptionTracker.trackException("EXReportController", "[EXReport runtime] Tag(" + str + ") report item is null");
            if (QLog.isColorLevel()) {
                QLog.d("EXReportController", 2, "[EXReport runtime] tag = " + str + "  report item is null");
                return;
            }
            return;
        }
        if (!TextUtils.isEmpty(bVar.f240750b) && !TextUtils.isEmpty(bVar.f240752d) && !TextUtils.isEmpty(bVar.f240751c)) {
            bVar.f240749a = NetConnInfoCenter.getServerTime();
            if (QLog.isColorLevel()) {
                QLog.d("EXReportController", 2, "[EXReport runtime] tag = " + str + ", content = " + bVar.toString());
            }
            if (appRuntime == null) {
                String a16 = a(bVar, 1);
                Intent intent = new Intent();
                intent.setClassName(BaseApplication.getContext(), "com.tencent.mobileqq.statistics.ReportReceiver");
                intent.putExtra("reporting_tag", str);
                intent.putExtra("reporting_detail", a16);
                intent.putExtra("reporting_count", bVar.f240755g);
                intent.putExtra("is_runtime", 1);
                BaseApplication.getContext().sendBroadcast(intent);
                return;
            }
            b(str, appRuntime, a(bVar, 1));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("EXReportController", 2, "[EXReport runtime] tag = " + str + " item.sopType must not empty");
        }
    }

    public static void d(AppRuntime appRuntime, a aVar) {
        c(appRuntime, "dc03309", aVar);
    }
}
