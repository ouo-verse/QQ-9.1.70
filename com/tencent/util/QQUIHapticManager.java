package com.tencent.util;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInitMethod;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInject;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes27.dex */
public class QQUIHapticManager {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "HapticManagerInject";

    @QAutoInject(configPath = "AutoInjectYml/Foundation/QQUI/Inject_HapticManager.yml", version = 1)
    private static com.tencent.mobileqq.inject.i sHapticManager;
    private static ArrayList sHapticManager_AutoGenClazzList_QAutoInjectTransform;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(53789);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        ArrayList arrayList = new ArrayList();
        sHapticManager_AutoGenClazzList_QAutoInjectTransform = arrayList;
        arrayList.add(com.tencent.mobileqq.injector.n.class);
    }

    public QQUIHapticManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static void ensureInject() {
        if (sHapticManager == null) {
            initQAutoInject();
        }
    }

    @QAutoInitMethod
    static void initQAutoInject() {
        sHapticManager = (com.tencent.mobileqq.inject.i) com.tencent.mobileqq.qroute.utils.b.a(sHapticManager_AutoGenClazzList_QAutoInjectTransform);
    }

    public static int playEffect(String str, int i3) {
        ensureInject();
        com.tencent.mobileqq.inject.i iVar = sHapticManager;
        if (iVar == null) {
            QLog.w(TAG, 1, "inject failed, call is playEffect");
            return -1;
        }
        return iVar.playEffect(str, i3);
    }
}
