package com.tencent.image;

import com.tencent.image.ProtocolDownloader;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mtt.hippy.bridge.HippyBridge;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

/* compiled from: P */
/* loaded from: classes7.dex */
public class LocaleFileDownloader extends ProtocolDownloader.Adapter {
    static IPatchRedirector $redirector_;

    public LocaleFileDownloader() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public File getFile(DownloadParams downloadParams) {
        File file;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (File) iPatchRedirector.redirect((short) 4, (Object) this, (Object) downloadParams);
        }
        URL url = downloadParams.url;
        try {
            try {
                file = new File(url.toURI().getPath());
            } catch (NullPointerException e16) {
                e16.printStackTrace();
                return null;
            } catch (URISyntaxException unused) {
                file = new File(url.toString().replaceFirst(HippyBridge.URI_SCHEME_FILE, ""));
            }
            return file;
        } catch (Exception e17) {
            if (!URLDrawable.depImp.mLog.isColorLevel()) {
                return null;
            }
            URLDrawable.depImp.mLog.e(URLDrawable.TAG, 2, "LocaleFileDownloader getFile error url:" + url, e17);
            return null;
        }
    }

    @Override // com.tencent.image.ProtocolDownloader.Adapter, com.tencent.image.ProtocolDownloader
    public boolean hasDiskFile(DownloadParams downloadParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) downloadParams)).booleanValue();
        }
        File file = getFile(downloadParams);
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
        File file = getFile(downloadParams);
        if (file != null && file.exists()) {
            return file;
        }
        throw new IOException("File not Found. url: " + downloadParams.url);
    }
}
