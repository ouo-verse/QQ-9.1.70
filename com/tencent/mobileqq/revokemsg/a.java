package com.tencent.mobileqq.revokemsg;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a {
    static IPatchRedirector $redirector_;

    public static boolean a(AppRuntime appRuntime) {
        if (appRuntime == null) {
            return false;
        }
        boolean isFeatureSwitchEnable = ((IFeatureRuntimeService) appRuntime.getRuntimeService(IFeatureRuntimeService.class, "all")).isFeatureSwitchEnable("aio_custom_revoke_msg", true);
        if (QLog.isDevelopLevel()) {
            QLog.d("RevokeMsgUtil", 4, "isFeatureEnable ", Boolean.valueOf(isFeatureSwitchEnable));
        }
        return isFeatureSwitchEnable;
    }
}
