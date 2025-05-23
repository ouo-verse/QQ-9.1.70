package com.tencent.qqnt.aio.utils;

import android.util.DisplayMetrics;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes23.dex */
public class h {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static DisplayMetrics f352299a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(48282);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f352299a = null;
            a(1);
        }
    }

    private static void a(int i3) {
        DisplayMetrics displayMetrics = BaseApplication.getContext().getResources().getDisplayMetrics();
        int min = Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels);
        if (f352299a == null) {
            f352299a = displayMetrics;
        }
        QLog.d("ArkApp.GuildArkAppCenterUtil", 1, "ArkFold.checkArkSize model=", DeviceInfoMonitor.getModel(), ",screenWidth=", Integer.valueOf(min), ",scene=", Integer.valueOf(i3));
    }

    public static float b() {
        DisplayMetrics displayMetrics = f352299a;
        if (displayMetrics != null) {
            return displayMetrics.density;
        }
        return BaseApplication.getContext().getResources().getDisplayMetrics().density;
    }
}
