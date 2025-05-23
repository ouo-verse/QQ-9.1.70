package com.tencent.util;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.filter.QImage;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.ttpic.AEBaseConfig;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.baseutils.encrypt.FileEncryptUtils;
import com.tencent.ttpic.baseutils.io.IOUtils;
import com.tencent.ttpic.baseutils.log.LogUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/* compiled from: P */
/* loaded from: classes27.dex */
public class FilterEngineJNILib {
    static IPatchRedirector $redirector_;
    private static long mLastDate;
    private static int mSameSecondCount;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(30258);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            mLastDate = 0L;
            mSameSecondCount = 0;
        }
    }

    public FilterEngineJNILib() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static String generateBundlePath(String str, String str2) {
        String str3;
        if (str2 != null) {
            str3 = str + "." + str2;
        } else {
            str3 = str;
        }
        if (new File(str3).exists()) {
            return str3;
        }
        Context context = AEBaseConfig.getContext();
        if (context == null) {
            return null;
        }
        File dir = context.getDir("filter", 0);
        if (!dir.isDirectory() && !dir.mkdirs()) {
            return null;
        }
        File file = new File(dir, str3);
        if (!file.exists()) {
            file.mkdirs();
            file.delete();
            try {
                InputStream inputStreamByName = BitmapUtils.getInputStreamByName(str3);
                if (inputStreamByName != null) {
                    byte[] bArr = new byte[1024];
                    file.createNewFile();
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    while (true) {
                        int read = inputStreamByName.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    }
                    inputStreamByName.close();
                    fileOutputStream.close();
                } else {
                    LogUtils.d("filter", "generateBundlePath notfound" + str);
                    return null;
                }
            } catch (IOException e16) {
                e16.printStackTrace();
            }
        }
        return file.getAbsolutePath();
    }

    private static synchronized String generateName(long j3) {
        String format;
        synchronized (FilterEngineJNILib.class) {
            format = new SimpleDateFormat("'IMG'_yyyyMMdd_HHmmss").format(new Date(j3));
            if (j3 / 1000 == mLastDate / 1000) {
                mSameSecondCount++;
                format = format + "_" + mSameSecondCount;
            } else {
                mLastDate = j3;
                mSameSecondCount = 0;
            }
        }
        return format;
    }

    public static byte[] getAssetContents(String str) throws IOException {
        if (AEBaseConfig.getContext() == null) {
            return null;
        }
        InputStream open = AEBaseConfig.getContext().getAssets().open(str, 3);
        byte[] bArr = new byte[open.available()];
        open.read(bArr);
        open.close();
        return bArr;
    }

    public static native void nativeCopyImage(Bitmap bitmap, long j3);

    public static byte[] readBundleData(String str) {
        byte[] bArr = null;
        try {
            InputStream inputStreamByName = BitmapUtils.getInputStreamByName(str);
            if (inputStreamByName == null) {
                LogUtils.e("BitmapUtils", "decodeBitmap  getStream " + str + " not exist");
            }
            bArr = FileEncryptUtils.decryptFile(inputStreamByName);
            IOUtils.closeQuietly(inputStreamByName);
            return bArr;
        } catch (Exception e16) {
            LogUtils.e("BitmapUtils", "decodeBitmap  getStream", e16, new Object[0]);
            return bArr;
        }
    }

    public static QImage readBundleImage(String str) {
        Bitmap decodeBitmap = BitmapUtils.decodeBitmap(str);
        if (decodeBitmap != null && !decodeBitmap.isRecycled()) {
            QImage Bitmap2QImage = QImage.Bitmap2QImage(decodeBitmap);
            BitmapUtils.recycle(decodeBitmap);
            return Bitmap2QImage;
        }
        return null;
    }

    public static void recycleImage(Bitmap bitmap) {
        if (bitmap != null && !bitmap.isRecycled()) {
            bitmap.recycle();
        }
        System.gc();
    }

    private static int saveBitmap(Bitmap bitmap, String str) {
        LogUtils.d("filter", "saveBitmap: " + str);
        FileOutputStream fileOutputStream = null;
        try {
            try {
                File file = new File(str);
                File parentFile = file.getParentFile();
                if (!parentFile.exists()) {
                    parentFile.mkdirs();
                }
                if (!file.exists()) {
                    file.createNewFile();
                }
                LogUtils.d("filter", "exists: " + file.exists());
                FileOutputStream fileOutputStream2 = new FileOutputStream(str);
                if (bitmap != null) {
                    try {
                        bitmap.compress(Bitmap.CompressFormat.JPEG, 95, fileOutputStream2);
                        fileOutputStream2.flush();
                    } catch (Exception e16) {
                        e = e16;
                        fileOutputStream = fileOutputStream2;
                        e.printStackTrace();
                        IOUtils.closeQuietly(fileOutputStream);
                        return 0;
                    } catch (OutOfMemoryError e17) {
                        e = e17;
                        fileOutputStream = fileOutputStream2;
                        e.printStackTrace();
                        IOUtils.closeQuietly(fileOutputStream);
                        return 0;
                    } catch (Throwable th5) {
                        th = th5;
                        fileOutputStream = fileOutputStream2;
                        IOUtils.closeQuietly(fileOutputStream);
                        throw th;
                    }
                }
                IOUtils.closeQuietly(fileOutputStream2);
                return 1;
            } catch (Exception e18) {
                e = e18;
            } catch (OutOfMemoryError e19) {
                e = e19;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }
}
