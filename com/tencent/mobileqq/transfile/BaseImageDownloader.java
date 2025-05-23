package com.tencent.mobileqq.transfile;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.image.DownloadParams;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.image.SliceBitmap;
import com.tencent.image.URLDrawableHandler;
import com.tencent.image.Utils;
import com.tencent.mobileqq.haoliyou.JefsClass;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;

/* compiled from: P */
/* loaded from: classes19.dex */
public abstract class BaseImageDownloader extends AbsDownloader {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "BaseImageDownloader";

    public BaseImageDownloader() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void copyFromFile(OutputStream outputStream, File file, URLDrawableHandler uRLDrawableHandler) throws IOException {
        long length = file.length();
        FileInputStream fileInputStream = null;
        try {
            try {
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    byte[] bArr = new byte[8192];
                    long j3 = 0;
                    while (true) {
                        int read = fileInputStream2.read(bArr);
                        if (read != -1) {
                            outputStream.write(bArr, 0, read);
                            outputStream.flush();
                            j3 += read;
                            uRLDrawableHandler.publishProgress((int) ((((float) j3) / ((float) length)) * 8500.0f));
                        } else {
                            fileInputStream2.close();
                            return;
                        }
                    }
                } catch (IOException e16) {
                } catch (Throwable th5) {
                    th = th5;
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (IOException e17) {
            throw e17;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Object decodeImage(URL url, File file, DownloadParams downloadParams, BitmapFactory.Options options) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return iPatchRedirector.redirect((short) 2, this, url, file, downloadParams, options);
        }
        String str = downloadParams.urlStr;
        options.inSampleSize = Utils.calculateInSampleSize(options, downloadParams.reqWidth, downloadParams.reqHeight);
        options.inJustDecodeBounds = false;
        int tryTime = getTryTime(url);
        Object obj = null;
        int i3 = 1;
        Bitmap bitmap = null;
        while (true) {
            if (i3 > tryTime) {
                break;
            }
            try {
                bitmap = SafeBitmapFactory.decodeFile(file.getAbsolutePath(), options);
                if (bitmap == null) {
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "DecodeFile Failed,bitmap == null, url:" + str + " ,retry count: " + i3 + ",path:" + file.getAbsolutePath());
                    }
                    throw new OutOfMemoryError("DecodeFile Failed,bitmap == null, url:" + str + " ,retry count: " + i3 + ",path:" + file.getAbsolutePath());
                }
                if (SliceBitmap.needSlice(bitmap)) {
                    try {
                        SliceBitmap sliceBitmap = new SliceBitmap(bitmap);
                        bitmap.recycle();
                        obj = sliceBitmap;
                        break;
                    } catch (Exception unused) {
                        throw new OutOfMemoryError("new SliceBitmap() error");
                    }
                }
                obj = bitmap;
                break;
            } catch (OutOfMemoryError e16) {
                if (bitmap != null) {
                    bitmap.recycle();
                }
                String message = e16.getMessage();
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "DecodeFile ERROR,oom retryCount=" + i3 + ",options.inSampleSize=" + options.inSampleSize + ",cacheFile=" + file.getAbsolutePath() + JefsClass.INDEX_URL + str + ",oom.msg:" + message);
                }
                i3++;
                options.inSampleSize *= 2;
            }
        }
        if (obj == null) {
            if (QLog.isColorLevel() && bitmap == null && i3 > tryTime) {
                QLog.d(TAG, 2, "BitmapFactory.decodeFile() failed, file is ", file.getAbsolutePath());
            }
            throw new IOException("decode image failed");
        }
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getTryTime(URL url) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this, (Object) url)).intValue();
        }
        return 1;
    }
}
