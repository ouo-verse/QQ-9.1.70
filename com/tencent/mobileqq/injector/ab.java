package com.tencent.mobileqq.injector;

import com.tencent.mobileqq.app.parse.JumpParseConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes15.dex */
public class ab implements com.tencent.mobileqq.inject.q {
    static IPatchRedirector $redirector_;

    public ab() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.inject.q
    public String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return com.tencent.mobileqq.utils.ah.C();
    }

    @Override // com.tencent.mobileqq.inject.q
    public void b(HashMap<String, String> hashMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) hashMap);
        } else {
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", JumpParseConstants.KEY_JUMP_PARSER_UTIL, true, 0L, 0L, hashMap, "", false);
        }
    }

    @Override // com.tencent.mobileqq.inject.q
    public void c(HashMap<String, String> hashMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) hashMap);
        } else {
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", JumpParseConstants.KEY_JUMP_PARSER_UTIL, true, 0L, 0L, hashMap, "", false);
        }
    }

    @Override // com.tencent.mobileqq.inject.q
    public String getDeviceModel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return com.tencent.mobileqq.utils.ah.s();
    }
}
