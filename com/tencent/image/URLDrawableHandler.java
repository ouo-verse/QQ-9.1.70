package com.tencent.image;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes7.dex */
public interface URLDrawableHandler {

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static class Adapter implements URLDrawableHandler {
        static IPatchRedirector $redirector_;

        public Adapter() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.image.URLDrawableHandler
        public void doCancel() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
            }
        }

        @Override // com.tencent.image.URLDrawableHandler
        public boolean isCancelled() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            return false;
        }

        @Override // com.tencent.image.URLDrawableHandler
        public void onFileDownloadFailed(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, i3);
            }
        }

        @Override // com.tencent.image.URLDrawableHandler
        public void onFileDownloadStarted() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this);
            }
        }

        @Override // com.tencent.image.URLDrawableHandler
        public void onFileDownloadSucceed(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, j3);
            }
        }

        @Override // com.tencent.image.URLDrawableHandler
        public void publishProgress(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3);
            }
        }
    }

    void doCancel();

    boolean isCancelled();

    void onFileDownloadFailed(int i3);

    void onFileDownloadStarted();

    void onFileDownloadSucceed(long j3);

    void publishProgress(int i3);
}
