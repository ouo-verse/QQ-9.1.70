package com.tencent.mobileqq.profilecommon.utils;

import com.tencent.mobileqq.profilecommon.api.IProfileCommonService;
import com.tencent.mobileqq.profilecommon.processor.AbsProfileCommonProcessor;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes16.dex */
public class a {
    static IPatchRedirector $redirector_;

    public static <T extends AbsProfileCommonProcessor> T a(Class<? extends AbsProfileCommonProcessor> cls, AppRuntime appRuntime) {
        if (appRuntime != null) {
            return (T) ((IProfileCommonService) appRuntime.getRuntimeService(IProfileCommonService.class, "all")).getProcessor(cls);
        }
        return null;
    }

    public static void b(AppRuntime appRuntime) {
        if (appRuntime != null) {
            ((IProfileCommonService) appRuntime.getRuntimeService(IProfileCommonService.class, "all")).getProfileDetailForLogin();
        }
    }
}
