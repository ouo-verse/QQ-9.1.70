package com.tencent.apkupdate;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes3.dex */
public class ApkUpdateParam {
    static IPatchRedirector $redirector_;
    public int actionFlag;
    public String packageName;
    public int targetGrayVersionCode;
    public int targetVersionCode;

    public ApkUpdateParam(String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        this.packageName = str;
        this.actionFlag = i3;
        this.targetVersionCode = i16;
    }
}
