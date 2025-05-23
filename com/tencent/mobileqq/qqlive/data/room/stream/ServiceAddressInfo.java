package com.tencent.mobileqq.qqlive.data.room.stream;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes17.dex */
public class ServiceAddressInfo {
    static IPatchRedirector $redirector_;
    public int bitrate;
    public String format;
    public String url;

    public ServiceAddressInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.url = "";
        this.bitrate = -1;
        this.format = "";
    }
}
