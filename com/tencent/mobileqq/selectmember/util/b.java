package com.tencent.mobileqq.selectmember.util;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes18.dex */
public class b {
    static IPatchRedirector $redirector_;

    public static boolean a(AppRuntime appRuntime) {
        if (appRuntime == null) {
            return false;
        }
        return ((IFeatureRuntimeService) appRuntime.getRuntimeService(IFeatureRuntimeService.class, "all")).isFeatureSwitchEnable("invite_with_chat_record", false);
    }
}
