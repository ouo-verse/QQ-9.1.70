package com.tencent.mobileqq.transfile;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.text.TextUtils;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import mqq.app.AppRuntime;

/* loaded from: classes19.dex */
public class QZoneRecentPhotoDownloader extends AbsDownloader {
    static IPatchRedirector $redirector_ = null;
    public static final String PROTOCOL_TROOP_PHOTO_QZONE = "troop_photo_qzone";
    public static final String TAG = "Q.QZoneRecentPhotoDownloader";

    public QZoneRecentPhotoDownloader() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private String dealHost(String str) {
        int i3;
        int length = str.length();
        int indexOf = str.indexOf(91);
        if (indexOf == 0) {
            i3 = indexOf + 1;
        } else {
            i3 = 0;
        }
        int lastIndexOf = str.lastIndexOf(93);
        if (lastIndexOf == str.length() - 1) {
            length = lastIndexOf;
        }
        String substring = str.substring(i3, length);
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "dealHost|host = " + substring);
        }
        return substring;
    }

    private static Bitmap imageCrop(Bitmap bitmap) {
        int i3;
        int i16;
        int i17;
        if (bitmap != null) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            if (width > height) {
                i3 = height;
            } else {
                i3 = width;
            }
            if (width > height) {
                i16 = (width - height) / 2;
            } else {
                i16 = 0;
            }
            if (width > height) {
                i17 = 0;
            } else {
                i17 = (height - width) / 2;
            }
            return Bitmap.createBitmap(bitmap, i16, i17, i3, i3, (Matrix) null, false);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x007a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void realDownload(String str, String str2) {
        Bitmap bitmap;
        Bitmap imageCrop;
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "downloadPhoto|filePath = " + str + ", url = " + str2);
        }
        String str3 = str + "_temp";
        File file = new File(str3);
        if (file.exists()) {
            file.delete();
        }
        File parentFile = file.getParentFile();
        if (parentFile != null && !parentFile.exists()) {
            parentFile.mkdirs();
        }
        FileOutputStream fileOutputStream = null;
        if (HttpDownloadUtil.download((AppRuntime) null, MsfSdkUtils.insertMtype("qzone", str2), file)) {
            try {
                bitmap = BitmapFactory.decodeFile(str3);
            } catch (Exception e16) {
                e16.printStackTrace();
                bitmap = null;
                imageCrop = imageCrop(bitmap);
                if (imageCrop != null) {
                }
                file.delete();
            } catch (OutOfMemoryError e17) {
                e17.printStackTrace();
                bitmap = null;
                imageCrop = imageCrop(bitmap);
                if (imageCrop != null) {
                }
                file.delete();
            }
            imageCrop = imageCrop(bitmap);
            if (imageCrop != null) {
                File file2 = new File(str);
                if (file2.exists()) {
                    file2.delete();
                }
                File parentFile2 = file2.getParentFile();
                if (parentFile2 != null && !parentFile2.exists()) {
                    parentFile2.mkdirs();
                }
                try {
                    fileOutputStream = new FileOutputStream(file2);
                } catch (FileNotFoundException e18) {
                    e18.printStackTrace();
                }
                if (fileOutputStream != null) {
                    imageCrop.compress(Bitmap.CompressFormat.JPEG, 70, fileOutputStream);
                    try {
                        fileOutputStream.flush();
                        fileOutputStream.close();
                    } catch (IOException e19) {
                        e19.printStackTrace();
                    }
                }
            }
            file.delete();
        }
    }

    @Override // com.tencent.image.ProtocolDownloader.Adapter, com.tencent.image.ProtocolDownloader
    public Object decodeFile(File file, DownloadParams downloadParams, URLDrawableHandler uRLDrawableHandler) throws Exception {
        String path;
        URL url;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return iPatchRedirector.redirect((short) 3, this, file, downloadParams, uRLDrawableHandler);
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "decodeFile| f = " + file);
        }
        if (file == null) {
            path = null;
        } else {
            path = file.getPath();
        }
        if (TextUtils.isEmpty(path) && downloadParams != null && (url = downloadParams.url) != null) {
            path = url.getPath();
        }
        if (TextUtils.isEmpty(path)) {
            return null;
        }
        try {
            return BitmapFactory.decodeFile(path);
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        } catch (OutOfMemoryError e17) {
            e17.printStackTrace();
            return null;
        }
    }

    @Override // com.tencent.mobileqq.transfile.AbsDownloader
    public File downloadImage(OutputStream outputStream, DownloadParams downloadParams, URLDrawableHandler uRLDrawableHandler) throws Exception {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (File) iPatchRedirector.redirect((short) 2, this, outputStream, downloadParams, uRLDrawableHandler);
        }
        URL url = downloadParams.url;
        if (url != null && Utils.p(url.getProtocol(), PROTOCOL_TROOP_PHOTO_QZONE)) {
            String file = url.getFile();
            File file2 = new File(file);
            String host = url.getHost();
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "downloadImage| path = " + file + ", host = " + host);
            }
            if ((!file2.exists() || file2.length() <= 0) && host != null) {
                realDownload(file, dealHost(host));
                return file2;
            }
            return file2;
        }
        return null;
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
