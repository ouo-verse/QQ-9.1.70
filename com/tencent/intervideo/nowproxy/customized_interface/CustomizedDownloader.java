package com.tencent.intervideo.nowproxy.customized_interface;

import android.os.Bundle;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes7.dex */
public abstract class CustomizedDownloader {
    static IPatchRedirector $redirector_;

    public CustomizedDownloader() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public void onDownload(boolean z16, String str, String str2, Bundle bundle, DownloadCallback downloadCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), str, str2, bundle, downloadCallback);
        }
    }
}
