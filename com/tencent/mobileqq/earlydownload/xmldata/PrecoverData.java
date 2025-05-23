package com.tencent.mobileqq.earlydownload.xmldata;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes5.dex */
public class PrecoverData extends XmlData {
    static IPatchRedirector $redirector_;

    public PrecoverData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.earlydownload.xmldata.XmlData
    public String getSharedPreferencesName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "early_qq.android.early.precover";
    }

    @Override // com.tencent.mobileqq.earlydownload.xmldata.XmlData
    public String getStrResName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "qq.android.early.precover";
    }
}
