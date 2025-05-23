package com.tencent.mobileqq.emoticon;

import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes12.dex */
public abstract class EmoticonPackageDownloadListener {
    static IPatchRedirector $redirector_;

    public EmoticonPackageDownloadListener() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public void onCoverComplete(EmoticonPackage emoticonPackage, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, emoticonPackage, Integer.valueOf(i3), Integer.valueOf(i16));
        }
    }

    public void onJsonComplete(EmoticonPackage emoticonPackage, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) emoticonPackage, i3);
        }
    }

    public void onPackageEnd(EmoticonPackage emoticonPackage, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) emoticonPackage, i3);
        }
    }

    public void onPackageProgress(EmoticonPackage emoticonPackage, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, emoticonPackage, Integer.valueOf(i3), Integer.valueOf(i16));
        }
    }

    public void onPackageStart(EmoticonPackage emoticonPackage) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) emoticonPackage);
        }
    }
}
