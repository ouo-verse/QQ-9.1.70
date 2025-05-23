package com.tencent.util;

import com.tencent.mobileqq.injector.y;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInitMethod;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInject;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

/* loaded from: classes27.dex */
public class QQUIPerformanceReportUtils {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "QQUIPerformanceReportUtils";

    @QAutoInject(configPath = "AutoInjectYml/Foundation/QQUI/Inject_PerformanceReportUtils.yml", version = 1)
    private static com.tencent.mobileqq.inject.n sPerformanceReportUtils;
    private static ArrayList sPerformanceReportUtils_AutoGenClazzList_QAutoInjectTransform;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(53794);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        ArrayList arrayList = new ArrayList();
        sPerformanceReportUtils_AutoGenClazzList_QAutoInjectTransform = arrayList;
        arrayList.add(y.class);
    }

    public QQUIPerformanceReportUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static void ensureInject() {
        if (sPerformanceReportUtils == null) {
            initQAutoInject();
        }
    }

    @QAutoInitMethod
    static void initQAutoInject() {
        sPerformanceReportUtils = (com.tencent.mobileqq.inject.n) com.tencent.mobileqq.qroute.utils.b.a(sPerformanceReportUtils_AutoGenClazzList_QAutoInjectTransform);
    }

    public static void saveCompleteTime(String str, long j3) {
        ensureInject();
        com.tencent.mobileqq.inject.n nVar = sPerformanceReportUtils;
        if (nVar == null) {
            QLog.w(TAG, 1, "inject failed, call is saveCompleteTime");
        } else {
            nVar.a(str, j3);
        }
    }
}
