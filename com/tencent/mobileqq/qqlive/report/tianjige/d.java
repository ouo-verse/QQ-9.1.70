package com.tencent.mobileqq.qqlive.report.tianjige;

import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.report.tianjige.c;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes17.dex */
public class d {
    static IPatchRedirector $redirector_;

    public static c a(String str, a aVar) {
        boolean isEnable;
        boolean a16;
        boolean b16;
        double c16;
        if (aVar != null) {
            try {
                isEnable = aVar.isEnable();
                a16 = aVar.a();
                b16 = aVar.b();
                c16 = aVar.c();
            } catch (Exception e16) {
                QLog.e("OpenTelemetryConfigManager", 1, 1, e16.toString());
                return null;
            }
        } else {
            c16 = 0.0d;
            isEnable = false;
            a16 = false;
            b16 = false;
        }
        if (isEnable) {
            String str2 = AppSetting.f99551k;
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            String str3 = "";
            if (peekAppRuntime != null) {
                str3 = peekAppRuntime.getCurrentUin();
            }
            return new c.a().m(str).l(c16).n(str3).i(str2).j(b16).k(a16).h();
        }
        return null;
    }
}
