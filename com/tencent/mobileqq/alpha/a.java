package com.tencent.mobileqq.alpha;

import android.app.Application;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.api.IBuildConfig;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes11.dex */
public class a {
    static IPatchRedirector $redirector_;

    public static void a() {
        QLog.i("DCL_MODULE", 1, "Initializer.auth");
        if (!d()) {
            return;
        }
        try {
            QLog.i("DCL_MODULE", 1, "Initializer.auth start");
            Class.forName("com.tencent.module_dcl.Initializer").getMethod(WinkDaTongReportConstant.ElementParamValue.XSJ_OPERATION_TYPE_AUTH, new Class[0]).invoke(null, new Object[0]);
        } catch (Exception e16) {
            QLog.e("DCL_MODULE", 1, "Initializer.auth failed: " + e16);
        }
    }

    public static void b(BaseApplicationImpl baseApplicationImpl) {
        QLog.i("DCL_MODULE", 1, "Initializer.init");
        if (!d()) {
            return;
        }
        try {
            QLog.i("DCL_MODULE", 1, "Initializer.init start");
            Class.forName("com.tencent.module_dcl.Initializer").getMethod("init", Application.class, String.class, Integer.TYPE).invoke(null, baseApplicationImpl, ((IBuildConfig) QRoute.api(IBuildConfig.class)).getAlphaBuildNo(), Integer.valueOf(((IBuildConfig) QRoute.api(IBuildConfig.class)).getDCLType()));
        } catch (Exception e16) {
            QLog.e("DCL_MODULE", 1, "Initializer.init failed: " + e16);
        }
    }

    public static void c() {
        QLog.i("DCL_MODULE", 1, "Initializer.jumpToZhnogce");
        if (!d()) {
            return;
        }
        try {
            QLog.i("DCL_MODULE", 1, "Initializer.init start");
            Class.forName("com.tencent.module_dcl.Initializer").getMethod("jumpToZhnogce", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception e16) {
            QLog.e("DCL_MODULE", 1, "Initializer.jumpToZhnogce failed: " + e16);
        }
    }

    public static boolean d() {
        QLog.i("DCL_MODULE", 1, "Initializer.supportAlpha DCL_TYPE:" + ((IBuildConfig) QRoute.api(IBuildConfig.class)).getDCLType());
        if (((IBuildConfig) QRoute.api(IBuildConfig.class)).getDCLType() > 0) {
            return true;
        }
        return false;
    }

    public static boolean e() {
        if (((IBuildConfig) QRoute.api(IBuildConfig.class)).getDCLType() == 2) {
            return true;
        }
        return false;
    }
}
