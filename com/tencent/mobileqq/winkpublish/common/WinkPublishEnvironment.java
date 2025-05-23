package com.tencent.mobileqq.winkpublish.common;

import android.content.Context;
import com.tencent.common.app.AppInterface;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* loaded from: classes21.dex */
public class WinkPublishEnvironment {
    private static final String TAG = "QQWinkEnvironment";

    public static AppInterface getAppInterface() {
        return (AppInterface) MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("peak");
    }

    public static AppRuntime getAppRuntime() {
        return MobileQQ.sMobileQQ.waitAppRuntime(null);
    }

    public static Context getBaseContext() {
        return MobileQQ.sMobileQQ;
    }
}
