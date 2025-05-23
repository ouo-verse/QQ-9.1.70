package com.tencent.mobileqq.transfile;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.photo.k;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

/* loaded from: classes19.dex */
public class PicFileGalleryOrigDecoder extends k {
    static IPatchRedirector $redirector_;

    public PicFileGalleryOrigDecoder(BaseApplicationImpl baseApplicationImpl) {
        super(baseApplicationImpl);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) baseApplicationImpl);
        }
    }

    @Override // com.tencent.image.LocaleFileDownloader
    public File getFile(DownloadParams downloadParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (File) iPatchRedirector.redirect((short) 2, (Object) this, (Object) downloadParams);
        }
        URL url = downloadParams.url;
        try {
            try {
                String file = url.getFile();
                if (!FileUtils.fileExists(file)) {
                    file = url.toURI().getPath();
                }
                return new File(file);
            } catch (NullPointerException e16) {
                e16.printStackTrace();
                return null;
            } catch (URISyntaxException unused) {
                return new File(url.toString().replaceFirst("filegalleryorigimage:", ""));
            }
        } catch (Exception e17) {
            if (!QLog.isColorLevel()) {
                return null;
            }
            QLog.e(URLDrawable.TAG, 2, "LocaleFileDownloader getFile error url:" + url, e17);
            return null;
        }
    }
}
