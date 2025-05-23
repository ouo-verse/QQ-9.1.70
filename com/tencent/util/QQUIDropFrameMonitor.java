package com.tencent.util;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInitMethod;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInject;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes27.dex */
public class QQUIDropFrameMonitor {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "QQUIDropFrameMonitor";

    @QAutoInject(configPath = "AutoInjectYml/Foundation/QQUI/Inject_DropFrameMonitor.yml", version = 1)
    private static com.tencent.mobileqq.inject.e sDropFrameMonitor;
    private static ArrayList sDropFrameMonitor_AutoGenClazzList_QAutoInjectTransform;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(53781);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        ArrayList arrayList = new ArrayList();
        sDropFrameMonitor_AutoGenClazzList_QAutoInjectTransform = arrayList;
        arrayList.add(com.tencent.mobileqq.injector.j.class);
    }

    public QQUIDropFrameMonitor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static void ensureInject() {
        if (sDropFrameMonitor == null) {
            initQAutoInject();
        }
    }

    @QAutoInitMethod
    static void initQAutoInject() {
        sDropFrameMonitor = (com.tencent.mobileqq.inject.e) com.tencent.mobileqq.qroute.utils.b.a(sDropFrameMonitor_AutoGenClazzList_QAutoInjectTransform);
    }

    public static void startMonitorScene(String str) {
        ensureInject();
        com.tencent.mobileqq.inject.e eVar = sDropFrameMonitor;
        if (eVar == null) {
            QLog.w(TAG, 1, "inject failed, call is startMonitorScene");
        } else {
            eVar.startMonitorScene(str);
        }
    }

    public static void stopMonitorScene(String str, boolean z16) {
        ensureInject();
        com.tencent.mobileqq.inject.e eVar = sDropFrameMonitor;
        if (eVar == null) {
            QLog.w(TAG, 1, "inject failed, call is stopMonitorScene");
        } else {
            eVar.stopMonitorScene(str, z16);
        }
    }
}
