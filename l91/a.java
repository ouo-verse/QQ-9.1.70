package l91;

import com.tencent.mobileqq.ark.api.IArkEnvDelegate;
import com.tencent.mobileqq.ark.api.IArkEnvironment;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes11.dex */
public class a {
    public static void a() {
        b(false);
    }

    public static void b(boolean z16) {
        QLog.i("ArkApp.ArkMultiProcUtil", 1, "initArkEnv, iisDelayInitJsc = " + z16);
        ((IArkEnvironment) QRoute.api(IArkEnvironment.class)).initMultiProcEnv((IArkEnvDelegate) QRoute.api(IArkEnvDelegate.class), z16);
    }

    @Deprecated
    public static void c(boolean z16) {
    }
}
