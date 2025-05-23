package com.tencent.mobileqq.sqtable;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.proxy.a;
import com.tencent.mobileqq.statistics.QQBeaconReport;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* loaded from: classes35.dex */
public class QProxyManagerTableInterceptor implements a {
    private static StackTraceElement[] b() {
        try {
            return Thread.currentThread().getStackTrace();
        } catch (Exception e16) {
            QLog.e("QProxyManagerTableInterceptor", 1, "getStackTrace error: ", e16);
            return null;
        }
    }

    private void c(final String str) {
        SettingConfig settingConfig = SettingConfig.f289642a;
        if (settingConfig.d(str)) {
            com.tencent.qqperf.monitor.crash.catchedexception.a.b(new Throwable("prohibited dbTable:" + str));
            if (QLog.isDevelopLevel()) {
                QLog.d("QProxyManagerTableInterceptor", 1, "report bugly: " + str);
            }
        }
        if (settingConfig.e(str)) {
            final StackTraceElement[] b16 = b();
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.sqtable.QProxyManagerTableInterceptor.1
                @Override // java.lang.Runnable
                public void run() {
                    String str2;
                    AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                    if (peekAppRuntime != null) {
                        str2 = peekAppRuntime.getAccount();
                    } else {
                        str2 = "";
                    }
                    HashMap hashMap = new HashMap();
                    StackTraceElement[] stackTraceElementArr = b16;
                    if (stackTraceElementArr != null) {
                        String arrays = Arrays.toString(stackTraceElementArr);
                        hashMap.put("currentTableName", str);
                        hashMap.put("currentStack", arrays);
                    }
                    if (QLog.isDevelopLevel()) {
                        QLog.d("QProxyManagerTableInterceptor", 1, "report key: db_operate_prohibited_table_report params " + hashMap);
                    }
                    QQBeaconReport.report(str2, "db_operate_prohibited_table_report", hashMap);
                }
            }, 16, null, false);
        }
    }

    @Override // com.tencent.mobileqq.app.proxy.a
    public boolean a(String str) {
        SettingConfig settingConfig = SettingConfig.f289642a;
        if (settingConfig.f(str)) {
            c(str);
        }
        return settingConfig.c(str);
    }
}
