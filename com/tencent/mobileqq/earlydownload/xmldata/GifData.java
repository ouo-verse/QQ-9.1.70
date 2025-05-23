package com.tencent.mobileqq.earlydownload.xmldata;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes5.dex */
public class GifData extends XmlData {
    static IPatchRedirector $redirector_;

    @saveInSP(isServer = false, save = true)
    public boolean gif_so_is_update;
    public String m2_2;
    public String m2_3;
    public String m4_0;
    public String m4_1;
    public String m4_2;
    public String m4_3;
    public String m4_4_2;
    public String m4_4_4;
    public String m5_0;
    public String m5_1;
    public String m5_2;
    public String m5_3;
    public String m5_4;
    public String m6_0;
    public String m6_1;

    @saveInSP(isServer = false, save = true)
    public boolean use_new_gif_so;
    public String v2_2;
    public String v2_3;
    public String v4_0;
    public String v4_1;
    public String v4_2;
    public String v4_3;
    public String v4_4_2;
    public String v4_4_4;
    public String v5_0;
    public String v5_1;
    public String v5_2;
    public String v5_3;
    public String v5_4;
    public String v6_0;
    public String v6_1;

    public GifData() {
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
        return "early_qq.android.native.gif";
    }

    @Override // com.tencent.mobileqq.earlydownload.xmldata.XmlData
    public String getStrResName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "qq.android.native.gif";
    }
}
