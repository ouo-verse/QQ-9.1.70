package com.tencent.mvp;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes21.dex */
public class e {
    static IPatchRedirector $redirector_;

    public static void a(c cVar, String str) {
        b(cVar, str, null);
    }

    public static void b(c cVar, String str, Object obj) {
        if (cVar != null) {
            b presenter = cVar.getPresenter();
            if (presenter != null && (presenter instanceof d)) {
                ((d) presenter).c(str, cVar, obj);
                return;
            }
            QLog.e("SimpleMVPUtils", 2, cVar.getClass().toString() + " notifyPresentAction can not find presenter");
            return;
        }
        throw new NullPointerException("notifyPresentAction on view null");
    }
}
