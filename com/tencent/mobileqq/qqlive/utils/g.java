package com.tencent.mobileqq.qqlive.utils;

import androidx.annotation.Nullable;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes17.dex */
public class g {
    static IPatchRedirector $redirector_;

    @Nullable
    public static AppInterface a() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        int i3 = MobileQQ.sProcessId;
        if (i3 == 1) {
            return e(peekAppRuntime);
        }
        if (i3 == 7) {
            return c(peekAppRuntime);
        }
        if (i3 == 2) {
            return b(peekAppRuntime);
        }
        if (i3 == 9) {
            return c(peekAppRuntime);
        }
        QLog.i("QQLiveCaptureContext", 1, "get AppInterface in " + MobileQQ.processName);
        return null;
    }

    private static AppInterface b(AppRuntime appRuntime) {
        AppRuntime appRuntime2 = appRuntime.getAppRuntime("qq_live_qzone");
        if (appRuntime2 instanceof AppInterface) {
            if (QLog.isColorLevel()) {
                QLog.d("QQLiveCaptureContext", 2, "getAppInterface in qzone process");
            }
            return (AppInterface) appRuntime2;
        }
        return null;
    }

    private static AppInterface c(AppRuntime appRuntime) {
        AppRuntime appRuntime2 = appRuntime.getAppRuntime("qq_live_tool");
        if (appRuntime2 instanceof AppInterface) {
            if (QLog.isColorLevel()) {
                QLog.d("QQLiveCaptureContext", 2, "getAppInterface in tool process");
            }
            return (AppInterface) appRuntime2;
        }
        return null;
    }

    @Nullable
    public static String d() {
        int i3 = MobileQQ.sProcessId;
        if (i3 == 7) {
            return "qq_live_tool";
        }
        if (i3 == 2) {
            return "qq_live_qzone";
        }
        return null;
    }

    private static AppInterface e(AppRuntime appRuntime) {
        if (appRuntime instanceof AppInterface) {
            if (QLog.isColorLevel()) {
                QLog.d("QQLiveCaptureContext", 2, "getAppInterface in main process");
            }
            return (AppInterface) appRuntime;
        }
        return null;
    }
}
