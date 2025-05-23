package com.tencent.mobileqq.transfile;

import android.text.TextUtils;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.g;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.cache.CacheManager;
import java.io.File;
import java.io.OutputStream;

/* compiled from: P */
/* loaded from: classes19.dex */
public class QZoneCoverDownloader extends AbsDownloader {
    static IPatchRedirector $redirector_ = null;
    protected static final String TAG = "Q.qzonecover.";

    public QZoneCoverDownloader() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    protected String dealUrl(String str) {
        String str2;
        int indexOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        }
        if (!TextUtils.isEmpty(str) && (indexOf = str.indexOf("http", 0)) > 0 && indexOf < str.length()) {
            str2 = str.substring(indexOf);
        } else {
            str2 = str;
        }
        if (QLog.isColorLevel()) {
            QLog.i("Q.qzonecover.", 2, "dealUrl|in: " + str + ", out: " + str2);
        }
        return str2;
    }

    @Override // com.tencent.image.ProtocolDownloader.Adapter, com.tencent.image.ProtocolDownloader
    public Object decodeFile(File file, DownloadParams downloadParams, URLDrawableHandler uRLDrawableHandler) throws Exception {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return iPatchRedirector.redirect((short) 3, this, file, downloadParams, uRLDrawableHandler);
        }
        if (QLog.isColorLevel()) {
            QLog.i("Q.qzonecover.", 2, "decodeFile() url = " + downloadParams.url + ", path = " + file.getAbsolutePath());
        }
        try {
            return super.decodeFile(file, downloadParams, uRLDrawableHandler);
        } catch (Exception e16) {
            QLog.i("Q.qzonecover.", 2, "decodeFile() exception: " + e16.toString());
            e16.printStackTrace();
            throw e16;
        }
    }

    @Override // com.tencent.mobileqq.transfile.AbsDownloader
    public File downloadImage(OutputStream outputStream, DownloadParams downloadParams, URLDrawableHandler uRLDrawableHandler) throws Exception {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (File) iPatchRedirector.redirect((short) 2, this, outputStream, downloadParams, uRLDrawableHandler);
        }
        if (QLog.isColorLevel()) {
            QLog.i("Q.qzonecover.", 2, "downloadImage|config.urlStr = " + downloadParams.urlStr);
        }
        String file = downloadParams.url.getFile();
        String host = downloadParams.url.getHost();
        if (QLog.isColorLevel()) {
            QLog.i("Q.qzonecover.", 2, "downloadImage|host = " + host + ", url = " + file);
        }
        String dealUrl = dealUrl(file);
        if (!TextUtils.isEmpty(dealUrl)) {
            String imageFilePath = CacheManager.getImageFilePath(BaseApplication.getContext(), dealUrl);
            if (QLog.isColorLevel()) {
                QLog.i("Q.qzonecover.", 2, "downloadImage|path = " + imageFilePath);
                if (FileUtils.fileExistsAndNotEmpty(imageFilePath)) {
                    QLog.i("Q.qzonecover.", 2, "downloadImage|file exist and not empty");
                } else {
                    QLog.i("Q.qzonecover.", 2, "downloadImage|file not exist or empty!!");
                }
            }
            if (imageFilePath != null) {
                File file2 = new File(imageFilePath);
                if (!file2.exists()) {
                    if ((dealUrl.startsWith("http://") || dealUrl.startsWith("https://")) && DownloaderFactory.o(new g(dealUrl, file2), null) == 0 && file2.exists()) {
                        return file2;
                    }
                    throw new RuntimeException("downloadImage|file not exist, path = " + imageFilePath);
                }
                return file2;
            }
            throw new RuntimeException("downloadImage|file not exist, path = " + imageFilePath);
        }
        throw new RuntimeException("downloadImage|url is null");
    }

    @Override // com.tencent.mobileqq.transfile.AbsDownloader
    public boolean useDiskCache() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return false;
    }
}
