package com.tencent.hydevteam.pluginframework.pluginmanager;

import com.tencent.hydevteam.common.annotation.API;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Map;

/* compiled from: P */
@API
/* loaded from: classes7.dex */
public class MultiTargetDownloadInfo extends TargetDownloadInfo {
    static IPatchRedirector $redirector_;

    @API
    public Map<String, TargetDownloadInfo> allSubTargets;

    @API
    public final String cgiVersion;

    public MultiTargetDownloadInfo(String str, String str2, String str3, long j3) {
        super(str2, str3, j3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.cgiVersion = str;
        } else {
            iPatchRedirector.redirect((short) 1, this, str, str2, str3, Long.valueOf(j3));
        }
    }

    public MultiTargetDownloadInfo(String str, String str2, String str3, long j3, boolean z16) {
        super(str2, str3, j3, z16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            this.cgiVersion = str;
        } else {
            iPatchRedirector.redirect((short) 2, this, str, str2, str3, Long.valueOf(j3), Boolean.valueOf(z16));
        }
    }
}
