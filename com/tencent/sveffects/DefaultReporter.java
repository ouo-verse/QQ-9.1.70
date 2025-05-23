package com.tencent.sveffects;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes26.dex */
public class DefaultReporter implements Reporter {
    static IPatchRedirector $redirector_;

    public DefaultReporter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.sveffects.Reporter
    public void reportToBeacon(String str, boolean z16, long j3, long j16, HashMap<String, String> hashMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, Boolean.valueOf(z16), Long.valueOf(j3), Long.valueOf(j16), hashMap);
        }
    }

    @Override // com.tencent.sveffects.Reporter
    public void reportToCompass(String str, String str2, String str3, String str4, int i3, int i16, String str5, String str6, String str7, String str8) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, str, str2, str3, str4, Integer.valueOf(i3), Integer.valueOf(i16), str5, str6, str7, str8);
        }
    }
}
