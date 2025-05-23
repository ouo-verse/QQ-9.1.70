package com.tencent.util;

import android.view.Window;
import com.tencent.mobileqq.inject.t;
import com.tencent.mobileqq.injector.ah;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInitMethod;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInject;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes27.dex */
public class QQUIThemeNavigationBarUtil {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "ThemeNavigationBarUtilInject";

    @QAutoInject(configPath = "AutoInjectYml/Foundation/QQUI/Inject_ThemeNavigationBarUtil.yml", version = 1)
    private static t sThemeNavigationBarUtil;
    private static ArrayList sThemeNavigationBarUtil_AutoGenClazzList_QAutoInjectTransform;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(53801);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        ArrayList arrayList = new ArrayList();
        sThemeNavigationBarUtil_AutoGenClazzList_QAutoInjectTransform = arrayList;
        arrayList.add(ah.class);
    }

    public QQUIThemeNavigationBarUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static void ensureInject() {
        if (sThemeNavigationBarUtil == null) {
            initQAutoInject();
        }
    }

    @QAutoInitMethod
    static void initQAutoInject() {
        sThemeNavigationBarUtil = (t) com.tencent.mobileqq.qroute.utils.b.a(sThemeNavigationBarUtil_AutoGenClazzList_QAutoInjectTransform);
    }

    public static void setNavigationBarColor(Window window) {
        ensureInject();
        t tVar = sThemeNavigationBarUtil;
        if (tVar == null) {
            QLog.w(TAG, 1, "inject failed, call is setNavigationBarColor");
        } else {
            tVar.a(window);
        }
    }
}
