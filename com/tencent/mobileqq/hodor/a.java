package com.tencent.mobileqq.hodor;

import android.content.Context;
import android.util.Log;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.Date;

/* compiled from: P */
/* loaded from: classes9.dex */
public class a {
    static IPatchRedirector $redirector_;

    private static String a(Context context) {
        if (context == null) {
            context = BaseApplication.getContext();
        }
        if (context == null) {
            return AppSetting.f99551k + "." + AppSetting.f99542b;
        }
        return AppSetting.j(context);
    }

    public static void b(Context context, String str, String str2, long j3, String str3) {
        try {
            if ("CheckIn".equals(AppSetting.g())) {
                Log.e("HodorTest", "crashType:" + str + " crashTime:" + c(j3) + " processName:" + str3 + " appVersion:" + a(context) + " \ncrashStack:\n" + str2);
            }
        } catch (Throwable th5) {
            QLog.e("HodorCrashReporter", 1, th5, new Object[0]);
        }
    }

    private static String c(long j3) {
        return new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss").format(new Date(j3));
    }
}
