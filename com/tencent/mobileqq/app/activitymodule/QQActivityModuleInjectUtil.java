package com.tencent.mobileqq.app.activitymodule;

import com.tencent.mobileqq.app.lifecycle.ActivityModuleCallback;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes11.dex */
public class QQActivityModuleInjectUtil {
    static IPatchRedirector $redirector_;

    @ConfigInject(configPath = "Foundation/QQActivity/src/main/resources/Inject_QQActivityConfig.yml", version = 1)
    public static ArrayList<Class<? extends IModuleCallback>> moduleCallbacks;
    public static IModuleCallback sModuleCallback;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36640);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        ArrayList<Class<? extends IModuleCallback>> arrayList = new ArrayList<>();
        moduleCallbacks = arrayList;
        arrayList.add(ActivityModuleCallback.class);
        try {
            if (moduleCallbacks.size() > 0) {
                sModuleCallback = moduleCallbacks.get(0).newInstance();
            }
        } catch (IllegalAccessException e16) {
            QLog.e("QQActivityModuleInjectUtil", 2, "static statement: ", e16);
        } catch (InstantiationException e17) {
            QLog.e("QQActivityModuleInjectUtil", 2, "static statement: ", e17);
        }
    }

    public QQActivityModuleInjectUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
