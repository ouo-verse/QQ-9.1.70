package com.tencent.mobileqq.Doraemon;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes9.dex */
public class f {
    static IPatchRedirector $redirector_;

    public static e a(Class<? extends e> cls, DoraemonAPIManager doraemonAPIManager) {
        e eVar;
        try {
            eVar = cls.newInstance();
        } catch (Exception e16) {
            QLog.e("DoraemonOpenAPI.moduleFactory", 1, "newInstance error module=" + cls, e16);
            eVar = null;
        }
        if (eVar != null) {
            eVar.a(doraemonAPIManager);
        }
        return eVar;
    }
}
