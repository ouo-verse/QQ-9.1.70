package com.tencent.mobileqq.vas.pay.api.impl.helper;

import com.tencent.common.app.AppInterface;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes20.dex */
public class a {
    public static AppInterface a() {
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (MobileQQ.sProcessId == 7 && waitAppRuntime != null) {
            waitAppRuntime = waitAppRuntime.getAppRuntime("modular_web");
        }
        if (!(waitAppRuntime instanceof AppInterface)) {
            return null;
        }
        return (AppInterface) waitAppRuntime;
    }
}
