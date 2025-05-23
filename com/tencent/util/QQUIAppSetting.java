package com.tencent.util;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInitMethod;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInject;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes27.dex */
public class QQUIAppSetting {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "QQUIAppSetting";

    @QAutoInject(configPath = "AutoInjectYml/Foundation/QQUI/Inject_QQUIAppSetting.yml", version = 1)
    private static com.tencent.mobileqq.inject.b sAppSetting;
    private static ArrayList sAppSetting_AutoGenClazzList_QAutoInjectTransform;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(53776);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        ArrayList arrayList = new ArrayList();
        sAppSetting_AutoGenClazzList_QAutoInjectTransform = arrayList;
        arrayList.add(com.tencent.mobileqq.injector.d.class);
    }

    public QQUIAppSetting() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static boolean enableTalkBack() {
        ensureInject();
        com.tencent.mobileqq.inject.b bVar = sAppSetting;
        if (bVar == null) {
            QLog.w(TAG, 1, "inject failed, call enableTalkBack");
            return false;
        }
        return bVar.enableTalkBack();
    }

    private static void ensureInject() {
        if (sAppSetting == null) {
            initQAutoInject();
        }
    }

    @QAutoInitMethod
    static void initQAutoInject() {
        sAppSetting = (com.tencent.mobileqq.inject.b) com.tencent.mobileqq.qroute.utils.b.a(sAppSetting_AutoGenClazzList_QAutoInjectTransform);
    }

    public static boolean isDebugVersion() {
        ensureInject();
        com.tencent.mobileqq.inject.b bVar = sAppSetting;
        if (bVar == null) {
            QLog.w(TAG, 1, "inject failed, call isDebugVersion");
            return false;
        }
        return bVar.isDebugVersion();
    }

    public static boolean isEnableAutoDumpLeak() {
        ensureInject();
        com.tencent.mobileqq.inject.b bVar = sAppSetting;
        if (bVar == null) {
            QLog.w(TAG, 1, "inject failed, call isEnableAutoDumpLeak");
            return false;
        }
        return bVar.j();
    }

    public static boolean isGooglePlayVersion() {
        ensureInject();
        com.tencent.mobileqq.inject.b bVar = sAppSetting;
        if (bVar == null) {
            QLog.w(TAG, 1, "inject failed, call isGooglePlayVersion");
            return false;
        }
        return bVar.isGooglePlayVersion();
    }

    public static boolean isGrayVersion() {
        ensureInject();
        com.tencent.mobileqq.inject.b bVar = sAppSetting;
        if (bVar == null) {
            QLog.w(TAG, 1, "inject failed, call isGrayVersion");
            return false;
        }
        return bVar.isGrayVersion();
    }

    public static boolean isPublicVersion() {
        ensureInject();
        com.tencent.mobileqq.inject.b bVar = sAppSetting;
        if (bVar == null) {
            QLog.w(TAG, 1, "inject failed, call isPublicVersion");
            return false;
        }
        return bVar.isPublicVersion();
    }
}
