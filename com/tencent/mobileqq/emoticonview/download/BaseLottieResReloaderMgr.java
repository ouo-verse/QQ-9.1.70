package com.tencent.mobileqq.emoticonview.download;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes12.dex */
public abstract class BaseLottieResReloaderMgr {
    static IPatchRedirector $redirector_;
    protected EmoLottieResReloader mResReloader;

    public BaseLottieResReloaderMgr() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public void addReloadDrawable(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3, (Object) str);
            return;
        }
        if (this.mResReloader == null) {
            this.mResReloader = createLottieResReloader(i3);
        }
        EmoLottieResReloader emoLottieResReloader = this.mResReloader;
        if (emoLottieResReloader == null) {
            QLog.e("EmoLottieResReloaderMgr", 2, "resReloader is null.");
        } else {
            emoLottieResReloader.addReloadList(str);
        }
    }

    public void clearReloadList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        EmoLottieResReloader emoLottieResReloader = this.mResReloader;
        if (emoLottieResReloader != null) {
            emoLottieResReloader.clearReloadList();
            this.mResReloader = null;
        }
    }

    public abstract EmoLottieResReloader createLottieResReloader(int i3);

    public void nofityReloadList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        EmoLottieResReloader emoLottieResReloader = this.mResReloader;
        if (emoLottieResReloader != null) {
            emoLottieResReloader.nofityReloadList();
        }
    }

    public void resDownloadFinish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            nofityReloadList();
        }
    }
}
