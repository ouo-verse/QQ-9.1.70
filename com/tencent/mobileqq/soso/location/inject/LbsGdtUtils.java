package com.tencent.mobileqq.soso.location.inject;

import com.tencent.mobileqq.app.soso.LbsGdtProcessorProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes18.dex */
public class LbsGdtUtils {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "SOSO.LbsGdtUtils";

    @ConfigInject(configPath = "Foundation/QQLocation/src/main/resources/Inject_QQLocationLbsGdtUtilsProcessor.yml", version = 1)
    public static ArrayList<Class<? extends ILbsGdtUtilsProcessor>> sILbsGdtUtilsProcessorClassList;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(34877);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        ArrayList<Class<? extends ILbsGdtUtilsProcessor>> arrayList = new ArrayList<>();
        sILbsGdtUtilsProcessorClassList = arrayList;
        arrayList.add(LbsGdtProcessorProxy.class);
    }

    public LbsGdtUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static String getOaid() {
        try {
            ILbsGdtUtilsProcessor newInstance = sILbsGdtUtilsProcessorClassList.get(0).newInstance();
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "lbsGdtUtilsProcessor.getOaid() = " + newInstance.getOaid());
            }
            return newInstance.getOaid();
        } catch (Throwable th5) {
            QLog.e(TAG, 1, th5, new Object[0]);
            return "";
        }
    }
}
