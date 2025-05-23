package com.tencent.util;

import com.tencent.mobileqq.injector.s;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInitMethod;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInject;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes27.dex */
public class QQUILocaleManager {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "QQUILocaleManager";

    @QAutoInject(configPath = "AutoInjectYml/Foundation/QQUI/Inject_QQUILocaleManager.yml", version = 1)
    private static com.tencent.mobileqq.inject.k sLocaleManager;
    private static ArrayList sLocaleManager_AutoGenClazzList_QAutoInjectTransform;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(53791);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        ArrayList arrayList = new ArrayList();
        sLocaleManager_AutoGenClazzList_QAutoInjectTransform = arrayList;
        arrayList.add(s.class);
    }

    public QQUILocaleManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static void ensureInject() {
        if (sLocaleManager == null) {
            initQAutoInject();
        }
    }

    @QAutoInitMethod
    static void initQAutoInject() {
        sLocaleManager = (com.tencent.mobileqq.inject.k) com.tencent.mobileqq.qroute.utils.b.a(sLocaleManager_AutoGenClazzList_QAutoInjectTransform);
    }

    public static boolean isLocaleCN() {
        ensureInject();
        com.tencent.mobileqq.inject.k kVar = sLocaleManager;
        if (kVar == null) {
            QLog.w(TAG, 1, "inject failed, call is isLocaleCN");
            return true;
        }
        return kVar.isLocaleCN();
    }
}
