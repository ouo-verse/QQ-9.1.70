package com.tencent.mobileqq.qqgift.utils;

import androidx.annotation.Nullable;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes16.dex */
public class a {
    static IPatchRedirector $redirector_;

    public static AppInterface a() {
        AppRuntime waitAppRuntime;
        try {
            waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        } catch (Exception e16) {
            QLog.e("QQLiveCaptureContext", 1, "getAppInterface fail, ", e16);
        }
        if (waitAppRuntime instanceof AppInterface) {
            if (QLog.isColorLevel()) {
                QLog.d("QQLiveCaptureContext", 2, "getAppInterface in main process");
            }
            return (AppInterface) waitAppRuntime;
        }
        AppRuntime appRuntime = waitAppRuntime.getAppRuntime("qq_live_tool");
        if (appRuntime instanceof AppInterface) {
            if (QLog.isColorLevel()) {
                QLog.d("QQLiveCaptureContext", 2, "getAppInterface in tool process");
            }
            return (AppInterface) appRuntime;
        }
        return null;
    }

    @Nullable
    public static String b() {
        if (MobileQQ.sProcessId != 1) {
            return "qq_gift_tool";
        }
        return null;
    }
}
