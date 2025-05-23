package com.tencent.relation.common.utils;

import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import mqq.app.AppActivity;

/* compiled from: P */
/* loaded from: classes25.dex */
public class a {
    static IPatchRedirector $redirector_;

    public static void a(AppActivity appActivity, int i3, int i16) {
        if (AppSetting.o(appActivity)) {
            appActivity.setRequestedOrientation(-1);
        } else {
            appActivity.setRequestedOrientation(1);
        }
    }
}
