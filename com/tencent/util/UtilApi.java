package com.tencent.util;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes27.dex */
public class UtilApi {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "UtilApi";

    @ConfigInject(configPath = "Foundation/QQCommon/src/main/resources/Inject_Util.yml", version = 2)
    public static ArrayList<Class<? extends IUtilApi>> iUtilClass;
    public static IUtilApi util;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36613);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        ArrayList<Class<? extends IUtilApi>> arrayList = new ArrayList<>();
        iUtilClass = arrayList;
        arrayList.add(n.class);
        try {
            util = iUtilClass.get(0).newInstance();
        } catch (Exception e16) {
            QLog.e(TAG, 1, e16, new Object[0]);
        }
    }

    public UtilApi() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
