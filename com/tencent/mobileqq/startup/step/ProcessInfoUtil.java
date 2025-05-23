package com.tencent.mobileqq.startup.step;

import android.app.ActivityManager;
import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

/* loaded from: classes18.dex */
public class ProcessInfoUtil {
    static IPatchRedirector $redirector_;

    static /* bridge */ /* synthetic */ SharedPreferences a() {
        return c();
    }

    public static int b(String str) {
        SharedPreferences c16 = c();
        if (c16 == null) {
            return -1;
        }
        return c16.getInt("pid" + str, -1);
    }

    private static SharedPreferences c() {
        BaseApplicationImpl application = BaseApplicationImpl.getApplication();
        if (application != null) {
            return application.getSharedPreferences("process_info_pref", 4);
        }
        return null;
    }

    public static int d(Context context, String str) {
        ActivityManager activityManager;
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        if (context != null && (activityManager = (ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY)) != null && (runningAppProcesses = SystemMethodProxy.getRunningAppProcesses(activityManager)) != null) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (str.compareTo(runningAppProcessInfo.processName) == 0) {
                    return runningAppProcessInfo.pid;
                }
            }
            return -1;
        }
        return -1;
    }

    public static long e(String str) {
        int b16;
        int d16 = d(BaseApplication.getContext(), str);
        if (d16 != -1 && (b16 = b(str)) != -1 && d16 == b16) {
            long f16 = f(str);
            if (f16 != -1) {
                long currentTimeMillis = System.currentTimeMillis() - f16;
                if (QLog.isColorLevel()) {
                    QLog.d("ProcessUtils", 2, "getProcessRunningTime - " + str + ":" + currentTimeMillis);
                }
                return currentTimeMillis;
            }
        }
        return 0L;
    }

    public static long f(String str) {
        SharedPreferences c16 = c();
        if (c16 == null) {
            return -1L;
        }
        return c16.getLong("start_time" + str, -1L);
    }

    public static void g(String str) {
        ThreadManagerV2.post(new Runnable(str) { // from class: com.tencent.mobileqq.startup.step.ProcessInfoUtil.1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f289737d;

            {
                this.f289737d = str;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                int d16;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                SharedPreferences a16 = ProcessInfoUtil.a();
                if (a16 == null || (d16 = ProcessInfoUtil.d(BaseApplication.getContext(), this.f289737d)) == -1) {
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                a16.edit().putInt("pid" + this.f289737d, d16);
                a16.edit().putLong("start_time" + this.f289737d, currentTimeMillis).apply();
                if (QLog.isColorLevel()) {
                    QLog.d("ProcessUtils", 2, "recordProcessStart - " + this.f289737d + ":" + d16 + "|" + currentTimeMillis);
                }
            }
        }, 5, null, true);
    }
}
