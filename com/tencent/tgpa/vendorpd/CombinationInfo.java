package com.tencent.tgpa.vendorpd;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes26.dex */
public class CombinationInfo {
    static IPatchRedirector $redirector_;
    public String cdnMD5;
    public String cdnUrl;
    public String gamePackageName;
    public String predownFileMD5;
    public String predownFilePath;

    public CombinationInfo(String str, String str2, String str3, String str4, String str5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, str2, str3, str4, str5);
            return;
        }
        this.cdnUrl = str;
        this.cdnMD5 = str2;
        this.predownFilePath = str3;
        this.predownFileMD5 = str4;
        this.gamePackageName = str5;
    }
}
