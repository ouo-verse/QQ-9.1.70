package com.tencent.mobileqq.transfile;

import com.tencent.image.DownloadParams;
import com.tencent.image.ProtocolDownloader;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes19.dex */
public class LocalFileDownloader extends ProtocolDownloader.Adapter {
    static IPatchRedirector $redirector_;

    public LocalFileDownloader() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.image.ProtocolDownloader.Adapter, com.tencent.image.ProtocolDownloader
    public boolean hasDiskFile(DownloadParams downloadParams) {
        File file;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) downloadParams)).booleanValue();
        }
        try {
            file = new File(downloadParams.url.toURI().getPath());
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e(URLDrawable.TAG, 2, "[hasDiskFile]", e16);
            }
            file = null;
        }
        if (file != null && file.exists()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.image.ProtocolDownloader.Adapter, com.tencent.image.ProtocolDownloader
    public File loadImageFile(DownloadParams downloadParams, URLDrawableHandler uRLDrawableHandler) throws Exception {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (File) iPatchRedirector.redirect((short) 2, (Object) this, (Object) downloadParams, (Object) uRLDrawableHandler);
        }
        uRLDrawableHandler.onFileDownloadStarted();
        File file = new File(downloadParams.url.toURI().getPath());
        if (file.exists()) {
            uRLDrawableHandler.onFileDownloadSucceed(0L);
            return file;
        }
        uRLDrawableHandler.onFileDownloadFailed(0);
        throw new IOException("File not Found. url: " + downloadParams.url);
    }
}
