package com.tencent.upload.utils.watcher;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes27.dex */
public class UploadStateWatcher {
    static IPatchRedirector $redirector_;
    private static volatile UploadStateWatcher sInstance;

    public UploadStateWatcher() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public UploadStateWatcher getInstance() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (UploadStateWatcher) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        if (sInstance == null) {
            synchronized (UploadStateWatcher.class) {
                if (sInstance == null) {
                    sInstance = new UploadStateWatcher();
                }
            }
        }
        return sInstance;
    }
}
