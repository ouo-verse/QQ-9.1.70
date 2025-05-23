package com.tencent.mobileqq.app.automator;

import com.tencent.mobileqq.persistence.CommonFunctionPublishConfigProcessor;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes11.dex */
class g {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a() {
        String str;
        String str2;
        boolean b16 = b();
        if (b16) {
            str = "[";
        } else {
            str = "{";
        }
        if (b16) {
            str2 = "]";
        } else {
            str2 = "}";
        }
        QLog.d("QQInitHandler", 1, "isParall:", Boolean.valueOf(b16), ", prefix: ", str, ", postfix:", str2);
        return str + "4,3,5" + str2;
    }

    boolean b() {
        return CommonFunctionPublishConfigProcessor.a().f258285e;
    }
}
