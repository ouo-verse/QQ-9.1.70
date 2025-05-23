package com.tencent.mobileqq.wink;

import android.content.Context;
import androidx.annotation.Nullable;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qcircle.api.IQCircleService;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes21.dex */
public class b {
    @Deprecated
    public static AppInterface a() {
        return (AppInterface) MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("peak");
    }

    @Deprecated
    public static AppRuntime b() {
        return MobileQQ.sMobileQQ.waitAppRuntime(null);
    }

    public static Context c() {
        return MobileQQ.sMobileQQ;
    }

    public static IQCircleService d() {
        return (IQCircleService) b().getRuntimeService(IQCircleService.class, "peak");
    }

    @Nullable
    public static AppInterface e() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            AppRuntime appRuntime = peekAppRuntime.getAppRuntime("peak");
            if (appRuntime instanceof AppInterface) {
                return (AppInterface) appRuntime;
            }
            return null;
        }
        return null;
    }

    public static AppRuntime f() {
        return MobileQQ.sMobileQQ.peekAppRuntime();
    }
}
