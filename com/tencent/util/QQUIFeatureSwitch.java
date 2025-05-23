package com.tencent.util;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInitMethod;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInject;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes27.dex */
public class QQUIFeatureSwitch {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "QQUIFeatureSwitch";

    @QAutoInject(configPath = "AutoInjectYml/Foundation/QQUI/Inject_FeatureSwitch.yml", version = 1)
    private static com.tencent.mobileqq.inject.h sFeatureSwitch;
    private static ArrayList sFeatureSwitch_AutoGenClazzList_QAutoInjectTransform;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(53787);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        ArrayList arrayList = new ArrayList();
        sFeatureSwitch_AutoGenClazzList_QAutoInjectTransform = arrayList;
        arrayList.add(com.tencent.mobileqq.injector.l.class);
    }

    public QQUIFeatureSwitch() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static void ensureInject() {
        if (sFeatureSwitch == null) {
            initQAutoInject();
        }
    }

    @QAutoInitMethod
    static void initQAutoInject() {
        sFeatureSwitch = (com.tencent.mobileqq.inject.h) com.tencent.mobileqq.qroute.utils.b.a(sFeatureSwitch_AutoGenClazzList_QAutoInjectTransform);
    }

    public static boolean isFeatureSwitchEnable(String str, boolean z16) {
        ensureInject();
        com.tencent.mobileqq.inject.h hVar = sFeatureSwitch;
        if (hVar == null) {
            QLog.w(TAG, 1, "inject failed, call is isFeatureSwitchEnable");
            return z16;
        }
        return hVar.isFeatureSwitchEnable(str, z16);
    }
}
