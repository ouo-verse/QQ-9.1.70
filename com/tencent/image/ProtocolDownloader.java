package com.tencent.image;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.File;
import java.net.URL;

/* loaded from: classes7.dex */
public interface ProtocolDownloader {

    /* loaded from: classes7.dex */
    public static abstract class Adapter implements ProtocolDownloader {
        static IPatchRedirector $redirector_;

        public Adapter() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.image.ProtocolDownloader
        public Object decodeFile(File file, DownloadParams downloadParams, URLDrawableHandler uRLDrawableHandler) throws Exception {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return iPatchRedirector.redirect((short) 4, this, file, downloadParams, uRLDrawableHandler);
            }
            return null;
        }

        @Override // com.tencent.image.ProtocolDownloader
        public JobQueue getQueue(URL url) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (JobQueue) iPatchRedirector.redirect((short) 2, (Object) this, (Object) url);
            }
            return null;
        }

        @Override // com.tencent.image.ProtocolDownloader
        public boolean gifHasDifferentState() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
            }
            return false;
        }

        @Override // com.tencent.image.ProtocolDownloader
        public boolean hasDiskFile(DownloadParams downloadParams) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) downloadParams)).booleanValue();
            }
            return false;
        }

        @Override // com.tencent.image.ProtocolDownloader
        public File loadImageFile(DownloadParams downloadParams, URLDrawableHandler uRLDrawableHandler) throws Exception {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (File) iPatchRedirector.redirect((short) 3, (Object) this, (Object) downloadParams, (Object) uRLDrawableHandler);
            }
            return null;
        }
    }

    Object decodeFile(File file, DownloadParams downloadParams, URLDrawableHandler uRLDrawableHandler) throws Exception;

    JobQueue getQueue(URL url);

    boolean gifHasDifferentState();

    boolean hasDiskFile(DownloadParams downloadParams);

    File loadImageFile(DownloadParams downloadParams, URLDrawableHandler uRLDrawableHandler) throws Exception;
}
