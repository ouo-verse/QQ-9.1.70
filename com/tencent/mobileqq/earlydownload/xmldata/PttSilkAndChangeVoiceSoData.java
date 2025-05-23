package com.tencent.mobileqq.earlydownload.xmldata;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes5.dex */
public class PttSilkAndChangeVoiceSoData extends XmlData {
    static IPatchRedirector $redirector_;

    @saveInSP(isServer = true, save = true)
    public boolean amrV5So;

    @saveInSP(isServer = true, save = true)
    public boolean amrV7So;

    @saveInSP(isServer = true, save = true)
    public boolean amrV8So;

    @saveInSP(isServer = true, save = true)
    public boolean mipsSo;

    @saveInSP(isServer = true, save = true)
    public String version;

    @saveInSP(isServer = true, save = true)
    public boolean x86So;

    public PttSilkAndChangeVoiceSoData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.x86So = false;
        this.mipsSo = false;
        this.amrV5So = false;
        this.amrV7So = false;
        this.amrV8So = false;
        this.version = "";
    }

    @Override // com.tencent.mobileqq.earlydownload.xmldata.XmlData
    public String getSharedPreferencesName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "early_qq.android.ptt.so.658";
    }

    @Override // com.tencent.mobileqq.earlydownload.xmldata.XmlData
    public String getStrResName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "qq.android.ptt.so.658";
    }
}
