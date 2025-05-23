package com.tencent.mobileqq.rainbow.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.rainbow.RainbowBusinessHandler;
import com.tencent.mobileqq.rainbow.api.IRainbowApi;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes16.dex */
public class RainbowApiImpl implements IRainbowApi {
    static IPatchRedirector $redirector_;

    public RainbowApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.rainbow.api.IRainbowApi
    public void getCmdRainbowData(String str, String str2, String str3, String str4, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            ((RainbowBusinessHandler) ((AppInterface) MobileQQ.sMobileQQ.peekAppRuntime()).getBusinessHandler(RainbowBusinessHandler.f280191d)).D2(str, str2, str3, str4, i3);
        } else {
            iPatchRedirector.redirect((short) 2, this, str, str2, str3, str4, Integer.valueOf(i3));
        }
    }

    @Override // com.tencent.mobileqq.rainbow.api.IRainbowApi
    public void getCmdRainbowData(String str, String str2, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            getCmdRainbowData("imqq", "mobileqq.android", str, str2, i3);
        } else {
            iPatchRedirector.redirect((short) 3, this, str, str2, Integer.valueOf(i3));
        }
    }
}
