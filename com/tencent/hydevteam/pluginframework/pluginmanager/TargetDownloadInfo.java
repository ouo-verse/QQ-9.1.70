package com.tencent.hydevteam.pluginframework.pluginmanager;

import com.tencent.hydevteam.common.annotation.API;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
@API
/* loaded from: classes7.dex */
public class TargetDownloadInfo {
    static IPatchRedirector $redirector_;

    @API
    public boolean forceUpdate;

    @API
    public final String hash;

    @API
    public final long size;

    @API
    public final String url;

    public TargetDownloadInfo(String str, String str2, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, str2, Long.valueOf(j3));
            return;
        }
        this.url = str;
        this.hash = str2;
        this.size = j3;
    }

    public TargetDownloadInfo(String str, String str2, long j3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, str2, Long.valueOf(j3), Boolean.valueOf(z16));
            return;
        }
        this.url = str;
        this.hash = str2;
        this.size = j3;
        this.forceUpdate = z16;
    }
}
