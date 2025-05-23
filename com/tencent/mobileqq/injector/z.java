package com.tencent.mobileqq.injector;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.QQBeaconReport;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes15.dex */
public class z implements com.tencent.mobileqq.inject.o {
    static IPatchRedirector $redirector_;

    public z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.inject.o
    public void a(String str, String str2, Map<String, String> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, str2, map);
        } else {
            QQBeaconReport.report(str, str2, map);
        }
    }
}
