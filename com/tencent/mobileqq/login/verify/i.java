package com.tencent.mobileqq.login.verify;

import android.content.Context;
import android.os.Build;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import com.tencent.bugly.common.utils.DeviceInfoUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes15.dex */
public class i {
    static IPatchRedirector $redirector_;

    protected static int a(Context context) {
        if (context == null) {
            return -1;
        }
        if (!d(context)) {
            return 0;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            return c(context);
        }
        return b(context);
    }

    @RequiresApi(api = 22)
    private static int b(Context context) {
        try {
            SubscriptionManager subscriptionManager = (SubscriptionManager) context.getSystemService("telephony_subscription_service");
            if (ContextCompat.checkSelfPermission(context, DeviceInfoUtil.PERMISSION_READ_PHONE) != 0) {
                QLog.e("GatewayReportUtil", 1, "getSimCardNumV22 no permission");
                return -1;
            }
            return subscriptionManager.getActiveSubscriptionInfoCount();
        } catch (Exception e16) {
            QLog.e("GatewayReportUtil", 1, "getSimCardNumV22 error : ", e16.getMessage());
            return -1;
        }
    }

    @RequiresApi(api = 26)
    private static int c(Context context) {
        int simState;
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            int i3 = 0;
            for (int i16 = 0; i16 < 2; i16++) {
                simState = telephonyManager.getSimState(i16);
                if (simState == 5) {
                    i3++;
                }
            }
            return i3;
        } catch (Exception e16) {
            QLog.d("GatewayReportUtil", 1, "getSimCardNumV26 error : ", e16.getMessage());
            return -1;
        }
    }

    private static boolean d(Context context) {
        boolean z16;
        int simState = ((TelephonyManager) context.getSystemService("phone")).getSimState();
        if (simState != 0 && simState != 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        QLog.d("GatewayReportUtil", 1, "hasSimCard result : ", Boolean.valueOf(z16));
        return z16;
    }

    public static void e(Context context, AppRuntime appRuntime) {
        String str;
        if (context == null) {
            QLog.e("GatewayReportUtil", 1, "reportLoginSimCardNum but context is null");
            return;
        }
        int a16 = a(context);
        QLog.d("GatewayReportUtil", 1, "sim card num is ", Integer.valueOf(a16));
        if (a16 == 0) {
            str = "0X800B0A9";
        } else if (a16 == 1) {
            str = "0X800B0AB";
        } else if (a16 == 2) {
            str = "0X800B0A1";
        } else {
            str = null;
        }
        String str2 = str;
        if (str2 != null) {
            ReportController.r(appRuntime, "dc00898", "", "", str2, str2, 0, 0, "", "", "", "");
        }
    }

    public static void f(Context context, AppRuntime appRuntime, int i3, String str) {
        String str2;
        if (context == null) {
            QLog.e("GatewayReportUtil", 1, "reportSimCardNum but context is null");
            return;
        }
        int a16 = a(context);
        QLog.d("GatewayReportUtil", 1, "sim card num is ", Integer.valueOf(a16));
        if (a16 == 0) {
            str2 = "0X800B0AA";
        } else if (a16 == 1) {
            str2 = "0X800B0AC";
        } else if (a16 == 2) {
            str2 = "0X800B0A3";
        } else {
            str2 = null;
        }
        String str3 = str2;
        if (str3 != null) {
            ReportController.r(appRuntime, "dc00898", "", str, str3, str3, i3, 0, "", "", "", "");
        }
    }
}
