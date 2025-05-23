package com.tencent.intervideo.nowproxy;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes7.dex */
public class NowEntryData {
    static IPatchRedirector $redirector_;
    public String networktype;
    public String pluginstatus;
    public String pluginversion;
    public String roomType;
    public String roomid;
    public String source;
    public String uid;

    public NowEntryData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
