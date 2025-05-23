package com.tencent.mobileqq.transfile;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.GifDrawable;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.filemanager.api.IQQFileSelectorUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqfav.d;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import mqq.app.api.ProcessConstant;

/* compiled from: P */
/* loaded from: classes19.dex */
public class FavoriteImageDownloader extends AbstractImageDownloader {
    static IPatchRedirector $redirector_ = null;
    private static final int MAX_BITMAP_SIZE = 20971520;
    private static final String TAG = "qqfav.FavoriteImageDownloader";

    public FavoriteImageDownloader(String str, BaseApplicationImpl baseApplicationImpl) {
        super(str, baseApplicationImpl);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) baseApplicationImpl);
    }

    public static File getFile(URL url) {
        String splitFile = splitFile(url, new String[]{null});
        if (splitFile == null) {
            return null;
        }
        return new File(splitFile);
    }

    private static String splitFile(URL url, String[] strArr) {
        String file = url.getFile();
        if (file.startsWith(ProtocolDownloaderConstants.FILE_PREFIX)) {
            return file.substring(5);
        }
        if (file.startsWith("file://")) {
            return file.substring(7);
        }
        if (file.startsWith("http")) {
            if (file.startsWith(ProtocolDownloaderConstants.HTTP_PREFIX)) {
                file = file.substring(5);
            }
            String[] split = file.split("\\|");
            if (split.length >= 2) {
                strArr[0] = split[0];
                return split[1];
            }
            return file;
        }
        return file;
    }

    @Override // com.tencent.mobileqq.transfile.AbstractImageDownloader, com.tencent.image.ProtocolDownloader.Adapter, com.tencent.image.ProtocolDownloader
    public Object decodeFile(File file, DownloadParams downloadParams, URLDrawableHandler uRLDrawableHandler) throws Exception {
        Bitmap decodeFile;
        Drawable apkIcon;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return iPatchRedirector.redirect((short) 4, this, file, downloadParams, uRLDrawableHandler);
        }
        Bitmap bitmap = null;
        if (file == null) {
            return null;
        }
        if (GifDrawable.isGifFile(file)) {
            return super.decodeFile(file, downloadParams, uRLDrawableHandler);
        }
        if (5 == FileManagerUtil.getFileType(file.getName()) && (apkIcon = ((IQQFileSelectorUtil) QRoute.api(IQQFileSelectorUtil.class)).getApkIcon(this.application, file.getPath())) != null) {
            if (apkIcon instanceof BitmapDrawable) {
                return ((BitmapDrawable) apkIcon).getBitmap();
            }
            Bitmap createBitmap = Bitmap.createBitmap(apkIcon.getIntrinsicWidth(), apkIcon.getIntrinsicHeight(), Bitmap.Config.RGB_565);
            Canvas canvas = new Canvas(createBitmap);
            apkIcon.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            apkIcon.draw(canvas);
            return createBitmap;
        }
        String path = file.getPath();
        if (TextUtils.isEmpty(path)) {
            return null;
        }
        try {
            decodeFile = BitmapFactory.decodeFile(path);
        } catch (Exception e16) {
            e = e16;
        } catch (OutOfMemoryError e17) {
            e = e17;
        }
        try {
            if (decodeFile.getByteCount() > 20971520) {
                return super.decodeFile(file, downloadParams, uRLDrawableHandler);
            }
            return decodeFile;
        } catch (Exception e18) {
            e = e18;
            bitmap = decodeFile;
            e.printStackTrace();
            return bitmap;
        } catch (OutOfMemoryError e19) {
            e = e19;
            bitmap = decodeFile;
            e.printStackTrace();
            return bitmap;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x004b  */
    @Override // com.tencent.mobileqq.transfile.AbsDownloader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public File downloadImage(OutputStream outputStream, DownloadParams downloadParams, URLDrawableHandler uRLDrawableHandler) throws IOException {
        File file;
        FileOutputStream fileOutputStream;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (File) iPatchRedirector.redirect((short) 3, this, outputStream, downloadParams, uRLDrawableHandler);
        }
        String[] strArr = {null};
        String splitFile = splitFile(downloadParams.url, strArr);
        if (strArr[0] != null) {
            boolean z16 = !new File(splitFile).exists();
            if (!z16) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                try {
                    BitmapFactory.decodeFile(splitFile, options);
                } catch (Exception unused) {
                }
                if (options.outHeight + options.outWidth != 0) {
                    z16 = false;
                    if (z16) {
                        new File(splitFile).delete();
                    }
                }
                z16 = true;
                if (z16) {
                }
            }
            if (z16 && NetworkUtil.isNetworkAvailable(this.application.getApplicationContext())) {
                URL url = downloadParams.url;
                String str = downloadParams.urlStr;
                downloadParams.url = new URL(strArr[0]);
                downloadParams.urlStr = strArr[0];
                if (QLog.isDevelopLevel()) {
                    QLog.d(ProcessConstant.QQFAV, 4, "favimage download: " + strArr[0] + " -> " + splitFile);
                }
                String str2 = splitFile + ".tmp";
                File file2 = new File(str2);
                if (file2.exists()) {
                    file2.delete();
                }
                uRLDrawableHandler.publishProgress(0);
                try {
                    fileOutputStream = new FileOutputStream(str2);
                } catch (Exception unused2) {
                    fileOutputStream = null;
                }
                try {
                    new HttpDownloader().downloadImage(fileOutputStream, downloadParams, uRLDrawableHandler);
                    fileOutputStream.close();
                    File file3 = new File(str2);
                    File file4 = new File(splitFile);
                    if (!file3.renameTo(file4)) {
                        FileUtils.copyFile(file3, file4);
                        file3.delete();
                    }
                } catch (Exception unused3) {
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    new File(str2).delete();
                    d.a(this.application.waitAppRuntime(null), false, new File(splitFile).length());
                    downloadParams.url = url;
                    downloadParams.urlStr = str;
                    file = new File(splitFile);
                    if (!file.exists()) {
                    }
                    file.delete();
                    QLog.e(TAG, 1, "downloadImage|file not exist or empty. filepath=" + splitFile);
                    throw new IOException("File not Found. url: " + downloadParams.url);
                }
                d.a(this.application.waitAppRuntime(null), false, new File(splitFile).length());
                downloadParams.url = url;
                downloadParams.urlStr = str;
            }
        }
        file = new File(splitFile);
        if (!file.exists() && file.length() > 0) {
            return file;
        }
        file.delete();
        QLog.e(TAG, 1, "downloadImage|file not exist or empty. filepath=" + splitFile);
        throw new IOException("File not Found. url: " + downloadParams.url);
    }

    @Override // com.tencent.image.ProtocolDownloader.Adapter, com.tencent.image.ProtocolDownloader
    public boolean gifHasDifferentState() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.mobileqq.transfile.AbsDownloader
    public boolean useDiskCache() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return false;
    }

    public FavoriteImageDownloader(BaseApplicationImpl baseApplicationImpl) {
        super(AbsDownloader.PROTOCAL_FAVORITE_IMAGE, baseApplicationImpl);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) baseApplicationImpl);
    }
}
