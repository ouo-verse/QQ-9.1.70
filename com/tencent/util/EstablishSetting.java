package com.tencent.util;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInitMethod;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInject;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes27.dex */
public class EstablishSetting {
    static IPatchRedirector $redirector_;

    @QAutoInject(configPath = "AutoInjectYml/Foundation/Establish/Inject_AppSetting.yml", version = 1)
    private static com.tencent.mobileqq.inject.b sAppSetting;
    private static ArrayList sAppSetting_AutoGenClazzList_QAutoInjectTransform;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42884);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        ArrayList arrayList = new ArrayList();
        sAppSetting_AutoGenClazzList_QAutoInjectTransform = arrayList;
        arrayList.add(com.tencent.mobileqq.injector.d.class);
    }

    public EstablishSetting() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static void ensureInject() {
        if (sAppSetting == null) {
            initQAutoInject();
        }
    }

    public static int getTargetSdkVersion() {
        ensureInject();
        com.tencent.mobileqq.inject.b bVar = sAppSetting;
        if (bVar == null) {
            QLog.w("EstablishSetting", 1, "inject failed, call getTargetSdkVersion");
            return 0;
        }
        return bVar.a();
    }

    @QAutoInitMethod
    static void initQAutoInject() {
        sAppSetting = (com.tencent.mobileqq.inject.b) com.tencent.mobileqq.qroute.utils.b.a(sAppSetting_AutoGenClazzList_QAutoInjectTransform);
    }

    public static boolean isAllowLandscape(Context context) {
        ensureInject();
        com.tencent.mobileqq.inject.b bVar = sAppSetting;
        if (bVar == null) {
            QLog.w("EstablishSetting", 1, "inject failed, call isAllowLandscape");
            return false;
        }
        return bVar.isAllowLandscape(context);
    }

    public static boolean isCpu64Bit() {
        ensureInject();
        com.tencent.mobileqq.inject.b bVar = sAppSetting;
        if (bVar == null) {
            QLog.w("EstablishSetting", 1, "inject failed, call isCpu64Bit");
            return false;
        }
        return bVar.c();
    }

    public static boolean isDebugVersion() {
        ensureInject();
        com.tencent.mobileqq.inject.b bVar = sAppSetting;
        if (bVar == null) {
            QLog.w("EstablishSetting", 1, "inject failed, call isDebugVersion");
            return false;
        }
        return bVar.isDebugVersion();
    }

    public static boolean isPublicVersion() {
        ensureInject();
        com.tencent.mobileqq.inject.b bVar = sAppSetting;
        if (bVar == null) {
            QLog.w("EstablishSetting", 1, "inject failed, call isPublicVersion");
            return false;
        }
        return bVar.isPublicVersion();
    }

    public static boolean isSplitViewMode(Context context) {
        ensureInject();
        com.tencent.mobileqq.inject.b bVar = sAppSetting;
        if (bVar == null) {
            QLog.w("EstablishSetting", 1, "inject failed, call isSplitViewMode");
            return false;
        }
        return bVar.isSplitViewMode(context);
    }
}
