package com.tencent.mobileqq.earlydownload.xmldata;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes5.dex */
public class PttTransitonAnimData extends XmlData {
    static IPatchRedirector $redirector_;

    @saveInSP(isServer = false, save = true)
    public boolean autoDownload;
    public boolean isUserClick;

    public PttTransitonAnimData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.autoDownload = false;
            this.isUserClick = true;
        }
    }

    @Override // com.tencent.mobileqq.earlydownload.xmldata.XmlData
    public String getSharedPreferencesName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "early_ptt.transition.anim.res.v8820.zip";
    }

    @Override // com.tencent.mobileqq.earlydownload.xmldata.XmlData
    public String getStrResName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "ptt.transition.anim.res.v8820.zip";
    }
}
