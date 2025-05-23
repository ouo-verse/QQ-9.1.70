package com.tencent.hydevteam.pluginframework.pluginmanager;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes7.dex */
class SimpleTargetDownloadInfo extends TargetDownloadInfo {
    static IPatchRedirector $redirector_;

    public SimpleTargetDownloadInfo(String str, String str2, long j3) {
        super(str, str2, j3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, str2, Long.valueOf(j3));
        }
    }
}
