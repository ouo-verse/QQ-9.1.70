package com.tencent.mobileqq.winkreport.utils;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import mqq.app.Foreground;

/* compiled from: P */
/* loaded from: classes21.dex */
public class WinkReportUtils {
    public static String getAccountUin() {
        return ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount();
    }

    public static long getLongAccountUin() {
        return Long.parseLong(getAccountUin());
    }

    public static String isInMultiWindowMode(Context context) {
        boolean isInMultiWindowMode;
        boolean z16 = false;
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                if (context != null && (context instanceof Activity)) {
                    isInMultiWindowMode = ((Activity) context).isInMultiWindowMode();
                } else if (Foreground.getTopActivity() != null) {
                    isInMultiWindowMode = Foreground.getTopActivity().isInMultiWindowMode();
                }
                z16 = isInMultiWindowMode;
            }
        } catch (Throwable th5) {
            QLog.i("WinkReportUtils", 1, th5 + "");
        }
        if (z16) {
            return "isMulti";
        }
        return "noMulti";
    }
}
