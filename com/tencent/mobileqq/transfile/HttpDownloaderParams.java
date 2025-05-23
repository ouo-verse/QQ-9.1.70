package com.tencent.mobileqq.transfile;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes19.dex */
public class HttpDownloaderParams {
    static IPatchRedirector $redirector_;
    public int businessType;
    public boolean isPreDownload;
    public int param1;
    public int param2;
    public String param3;
    public Object param4;

    public HttpDownloaderParams() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
