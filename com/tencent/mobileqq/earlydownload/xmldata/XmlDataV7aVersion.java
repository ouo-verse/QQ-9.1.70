package com.tencent.mobileqq.earlydownload.xmldata;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes5.dex */
public abstract class XmlDataV7aVersion extends XmlData {
    static IPatchRedirector $redirector_;

    @saveInSP(isServer = true, save = true)
    public int VideoVersion;

    @saveInSP(isServer = true, save = true)
    public String v7a_MD5;

    public XmlDataV7aVersion() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
