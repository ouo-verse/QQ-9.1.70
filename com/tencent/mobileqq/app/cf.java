package com.tencent.mobileqq.app;

import android.app.Activity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import mqq.app.Foreground;

/* compiled from: P */
/* loaded from: classes11.dex */
public class cf {
    static IPatchRedirector $redirector_;

    public static String a() {
        Activity topActivity = Foreground.getTopActivity();
        if (topActivity != null) {
            String name = topActivity.getClass().getName();
            if (topActivity instanceof SplashActivity) {
                if (SplashActivity.currentFragment == 1) {
                    return name + "_" + ((SplashActivity) topActivity).getCurrentTab();
                }
                return name + "_ChatFragment";
            }
            return name;
        }
        return "Null";
    }
}
