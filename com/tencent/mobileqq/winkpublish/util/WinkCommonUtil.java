package com.tencent.mobileqq.winkpublish.util;

import android.app.Activity;
import android.text.TextUtils;
import android.view.Window;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.PlatformInfor;

/* compiled from: P */
/* loaded from: classes21.dex */
public class WinkCommonUtil {
    private static final String TAG = "QCircleHostUtil";

    public static String getCurrentAccount() {
        return ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount();
    }

    public static long getCurrentAccountLong() {
        String account = ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount();
        if (!TextUtils.isEmpty(account)) {
            try {
                return Long.parseLong(account);
            } catch (Exception e16) {
                QLog.w(TAG, 1, e16.getMessage());
                return 0L;
            }
        }
        return 0L;
    }

    public static String getDeviceName() {
        return PlatformInfor.getDeviceName();
    }

    public static boolean isOwner(String str) {
        return getCurrentAccount().equals(str);
    }

    public static void setStatusBarColor(Activity activity, int i3) {
        if (activity == null) {
            return;
        }
        Window window = activity.getWindow();
        window.clearFlags(67108864);
        window.getDecorView().setSystemUiVisibility(1280);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(i3);
        window.setNavigationBarColor(i3);
    }
}
