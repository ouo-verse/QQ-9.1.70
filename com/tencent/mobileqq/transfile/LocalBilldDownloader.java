package com.tencent.mobileqq.transfile;

import android.app.Application;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

/* compiled from: P */
/* loaded from: classes19.dex */
public class LocalBilldDownloader extends AbsDownloader {
    static IPatchRedirector $redirector_ = null;
    public static final String PROTOCOL_BILLD_IMG = "billdimg";
    public static final String PROTOCOL_BILLD_THUMB = "billdthumb";
    private static final String TAG = "LocalBilldDownloader";
    Application application;

    public LocalBilldDownloader(Application application) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) application);
        } else {
            this.application = application;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v6, types: [android.content.res.Resources] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r9v10 */
    /* JADX WARN: Type inference failed for: r9v13, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r9v14, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r9v8, types: [int] */
    @Override // com.tencent.mobileqq.transfile.AbsDownloader
    public File downloadImage(OutputStream outputStream, DownloadParams downloadParams, URLDrawableHandler uRLDrawableHandler) throws Exception {
        Throwable th5;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (File) iPatchRedirector.redirect((short) 2, this, outputStream, downloadParams, uRLDrawableHandler);
        }
        File file = new File(AppConstants.SDCARD_BILLD_URLDRAWABLE);
        if (!file.exists()) {
            file.mkdirs();
        }
        String path = downloadParams.url.getPath();
        File file2 = new File(file + "/" + path);
        if (!file2.exists() || file2.length() == 0) {
            File file3 = new File(file + "/" + path + ".tmp");
            if (file3.exists()) {
                file3.delete();
            }
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "downloadImage isGIF !targetFile.exists(),url=" + downloadParams.urlStr + ",drawableName=" + path + ",targetFile=" + file2.getAbsolutePath());
            }
            ?? r16 = "raw";
            ?? identifier = this.application.getResources().getIdentifier(path, "raw", this.application.getPackageName());
            try {
                try {
                    identifier = this.application.getResources().openRawResource(identifier);
                } catch (Exception e16) {
                    throw e16;
                } catch (Throwable th6) {
                    r16 = 0;
                    th5 = th6;
                    identifier = 0;
                }
                try {
                    byte[] bArr = new byte[4096];
                    FileOutputStream fileOutputStream = new FileOutputStream(file3);
                    while (identifier.read(bArr) != -1) {
                        try {
                            fileOutputStream.write(bArr);
                            fileOutputStream.flush();
                        } catch (Exception e17) {
                            throw e17;
                        }
                    }
                    identifier.close();
                    fileOutputStream.close();
                    file3.renameTo(file2);
                } catch (Exception e18) {
                    throw e18;
                } catch (Throwable th7) {
                    r16 = 0;
                    th5 = th7;
                    if (identifier != 0) {
                        identifier.close();
                    }
                    if (r16 != 0) {
                        r16.close();
                    }
                    throw th5;
                }
            } catch (Throwable th8) {
                th5 = th8;
            }
        }
        return file2;
    }

    @Override // com.tencent.mobileqq.transfile.AbsDownloader
    public boolean useDiskCache() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return false;
    }
}
