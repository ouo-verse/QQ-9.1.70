package com.tencent.mobileqq.earlydownload.xmldata;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QQDingdongSoundData extends XmlData {
    static IPatchRedirector $redirector_;

    @saveInSP(isServer = false, save = true)
    public boolean autoDownload;

    public QQDingdongSoundData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.autoDownload = false;
        }
    }

    @Override // com.tencent.mobileqq.earlydownload.xmldata.XmlData
    public String getSharedPreferencesName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "early_qq.android.dingdong.ring";
    }

    @Override // com.tencent.mobileqq.earlydownload.xmldata.XmlData
    public String getStrResName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "qq.android.dingdong.ring";
    }
}
