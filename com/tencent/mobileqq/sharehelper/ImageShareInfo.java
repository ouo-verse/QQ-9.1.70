package com.tencent.mobileqq.sharehelper;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes18.dex */
public class ImageShareInfo {
    static IPatchRedirector $redirector_;
    String mBroadCastKey;
    String mImageFilePath;

    public ImageShareInfo(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) str2);
        } else {
            this.mImageFilePath = str;
            this.mBroadCastKey = str2;
        }
    }

    public String getBroadCastKey() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.mBroadCastKey;
    }

    public String getImageFilePath() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mImageFilePath;
    }
}
