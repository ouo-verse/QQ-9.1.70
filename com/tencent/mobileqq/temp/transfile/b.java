package com.tencent.mobileqq.temp.transfile;

import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.HttpDownloader;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.http.api.IHttpService;
import com.tencent.qqnt.http.api.b;
import com.tencent.qqnt.http.api.m;
import java.io.File;
import java.io.OutputStream;

/* compiled from: P */
/* loaded from: classes18.dex */
public class b extends AbsDownloader {
    static IPatchRedirector $redirector_;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.temp.transfile.AbsDownloader
    public File downloadImage(OutputStream outputStream, DownloadParams downloadParams, URLDrawableHandler uRLDrawableHandler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (File) iPatchRedirector.redirect((short) 2, this, outputStream, downloadParams, uRLDrawableHandler);
        }
        uRLDrawableHandler.onFileDownloadStarted();
        String url = downloadParams.url.toString();
        File file = new File(AbsDownloader.sDiskCache.c(), AbsDownloader.getFileName(url) + ".tmp");
        m syncExecute = ((IHttpService) QRoute.api(IHttpService.class)).syncExecute(new b.a(HttpDownloader.TAG, url, file).R(true).c());
        if (syncExecute.e()) {
            if (QLog.isDevelopLevel()) {
                QLog.d("NTTempHttpDownloader", 4, "downloadImage success, url = ", url);
            }
            uRLDrawableHandler.onFileDownloadSucceed(file.length());
        } else {
            uRLDrawableHandler.onFileDownloadFailed(syncExecute.a());
            QLog.e("NTTempHttpDownloader", 1, "downloadImage failed, url = ", url);
        }
        return file;
    }

    @Override // com.tencent.mobileqq.temp.transfile.AbsDownloader
    public boolean useDiskCache() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return true;
    }
}
