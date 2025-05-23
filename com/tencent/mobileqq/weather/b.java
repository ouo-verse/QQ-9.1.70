package com.tencent.mobileqq.weather;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.DcReportUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes20.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static b f313263a;

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static b a() {
        if (f313263a == null) {
            synchronized (b.class) {
                if (f313263a == null) {
                    f313263a = new b();
                }
            }
        }
        return f313263a;
    }

    public void b(AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) appInterface);
        } else {
            a().e(appInterface, "new_folder_click_adrequest");
        }
    }

    public void c(AppInterface appInterface, int i3, String str) {
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, appInterface, Integer.valueOf(i3), str);
            return;
        }
        if (i3 == 0) {
            str2 = "new_folder_click_adreturn";
        } else {
            str2 = "new_folder_click_adrequest_fail";
        }
        b a16 = a();
        if (i3 != 0) {
            str = "\u6210\u529f";
        }
        a16.f(appInterface, str2, str);
    }

    public void d(AppRuntime appRuntime, String str, String... strArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, appRuntime, str, strArr);
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(System.currentTimeMillis());
        sb5.append("|");
        sb5.append("QQWeather");
        sb5.append("|");
        sb5.append("QQWeather_native");
        sb5.append("|");
        sb5.append(str);
        for (String str2 : strArr) {
            sb5.append("|");
            sb5.append(str2);
        }
        String sb6 = sb5.toString();
        DcReportUtil.b(appRuntime, "dc04698", sb6);
        if (QLog.isColorLevel()) {
            QLog.d("WeatherDCReportHelper", 2, "reportWeather : " + sb6);
        }
    }

    public void e(AppRuntime appRuntime, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime, (Object) str);
        } else {
            f(appRuntime, str, null);
        }
    }

    public void f(AppRuntime appRuntime, String str, Object obj) {
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, appRuntime, str, obj);
            return;
        }
        if (obj != null && !TextUtils.isEmpty(String.valueOf(obj))) {
            str2 = "|" + obj;
        } else {
            str2 = "";
        }
        String str3 = System.currentTimeMillis() + "|QQWeather|QQWeather_native|" + str + "|android" + str2;
        DcReportUtil.b(appRuntime, "dc04698", str3);
        if (QLog.isColorLevel()) {
            QLog.d("WeatherDCReportHelper", 2, "reportWeather : " + str3);
        }
    }
}
