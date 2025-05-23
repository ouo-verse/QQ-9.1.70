package com.tencent.mobileqq.vas.pendant.drawable;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Looper;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.QLog;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/* loaded from: classes20.dex */
public class PendantUtils {
    private static final String TAG = "PendantUtils";

    @SuppressLint({"ObsoleteSdkInt"})
    @TargetApi(19)
    public static boolean canUseForInBitmap(Bitmap bitmap, int i3, int i16) {
        if (i3 * i16 * getBytesPerPixel(bitmap.getConfig()) <= bitmap.getAllocationByteCount()) {
            return true;
        }
        return false;
    }

    public static void closeIO(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e16) {
                QLog.i(TAG, 1, "closeIO failed!", e16);
            }
        }
    }

    public static void deleteFile(File file) {
        if (file != null && file.exists() && !file.delete()) {
            QLog.i(TAG, 1, "deleteFile failed! file:" + file.getAbsolutePath());
        }
    }

    static int getBytesPerPixel(Bitmap.Config config) {
        if (config == Bitmap.Config.ARGB_8888) {
            return 4;
        }
        if (config == Bitmap.Config.RGB_565 || config == Bitmap.Config.ARGB_4444) {
            return 2;
        }
        Bitmap.Config config2 = Bitmap.Config.ALPHA_8;
        return 1;
    }

    public static StringBuilder obtainStringBuilder() {
        return new StringBuilder();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [int] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v6, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v7, types: [java.io.FileInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r8v0, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* JADX WARN: Type inference failed for: r8v9, types: [java.lang.String] */
    public static void unzipError(File file, File file2) {
        Closeable closeable;
        Exception e16;
        InputStreamReader inputStreamReader;
        Closeable closeable2;
        if (Looper.getMainLooper() != Looper.myLooper()) {
            long length = file.length();
            String encodeFileHexStr = MD5Utils.encodeFileHexStr(file.getAbsolutePath());
            long j3 = 400;
            ?? r56 = (length > 400L ? 1 : (length == 400L ? 0 : -1));
            if (r56 <= 0) {
                j3 = length;
            }
            char[] cArr = new char[(int) j3];
            Closeable closeable3 = null;
            try {
                try {
                    r56 = new FileInputStream((File) file);
                    try {
                        inputStreamReader = new InputStreamReader((InputStream) r56, StandardCharsets.UTF_8);
                    } catch (Exception e17) {
                        e16 = e17;
                        inputStreamReader = null;
                    } catch (Throwable th5) {
                        th = th5;
                        file = 0;
                        closeable3 = r56;
                        closeable = file;
                        closeIO(closeable3);
                        closeIO(closeable);
                        throw th;
                    }
                } catch (Exception e18) {
                    r56 = 0;
                    e16 = e18;
                    inputStreamReader = null;
                } catch (Throwable th6) {
                    th = th6;
                    closeable = null;
                    closeIO(closeable3);
                    closeIO(closeable);
                    throw th;
                }
                try {
                    inputStreamReader.read(cArr);
                    closeable2 = r56;
                } catch (Exception e19) {
                    e16 = e19;
                    e16.printStackTrace();
                    closeable2 = r56;
                    closeIO(closeable2);
                    closeIO(inputStreamReader);
                    file = TAG;
                    StringBuilder sb5 = new StringBuilder();
                    r56 = "unzipResource|unzip resource fail targetDir=";
                    sb5.append("unzipResource|unzip resource fail targetDir=");
                    sb5.append(file2.getAbsolutePath());
                    sb5.append(" len: ");
                    sb5.append(length);
                    sb5.append(" md5: ");
                    sb5.append(encodeFileHexStr);
                    sb5.append(" content: ");
                    sb5.append(String.valueOf(cArr));
                    QLog.d((String) file, 2, sb5.toString());
                }
                closeIO(closeable2);
                closeIO(inputStreamReader);
                file = TAG;
                StringBuilder sb52 = new StringBuilder();
                r56 = "unzipResource|unzip resource fail targetDir=";
                sb52.append("unzipResource|unzip resource fail targetDir=");
                sb52.append(file2.getAbsolutePath());
                sb52.append(" len: ");
                sb52.append(length);
                sb52.append(" md5: ");
                sb52.append(encodeFileHexStr);
                sb52.append(" content: ");
                sb52.append(String.valueOf(cArr));
                QLog.d((String) file, 2, sb52.toString());
            } catch (Throwable th7) {
                th = th7;
            }
        }
    }

    public static synchronized boolean unzipResource(File file, File file2) {
        synchronized (PendantUtils.class) {
            boolean z16 = false;
            if (file != null) {
                if (file.exists()) {
                    long currentTimeMillis = System.currentTimeMillis();
                    try {
                        if (file2.exists()) {
                            File[] listFiles = file2.listFiles();
                            if (listFiles != null) {
                                for (File file3 : listFiles) {
                                    if (file3.isDirectory()) {
                                        File[] listFiles2 = file3.listFiles();
                                        if (listFiles2 != null) {
                                            for (File file4 : listFiles2) {
                                                deleteFile(file4);
                                            }
                                            deleteFile(file3);
                                        }
                                    } else {
                                        deleteFile(file3);
                                    }
                                }
                            }
                        } else if (!file2.mkdirs()) {
                            QLog.d(TAG, 2, "unzipResource mkdirs failed!, file:" + file2.getAbsolutePath());
                        }
                        ZipUtils.unZipFile(file, file2.getAbsolutePath() + File.separatorChar);
                        zipFileDelete(file, file2);
                        z16 = true;
                    } catch (Exception e16) {
                        QLog.d(TAG, 2, "unzipResource|unzip resource fail targetDir=" + file2.getAbsolutePath() + e16.getMessage());
                        unzipError(file, file2);
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "unzipResource|use time " + (System.currentTimeMillis() - currentTimeMillis) + " targetDir=" + file2.getAbsolutePath());
                    }
                    return z16;
                }
            }
            return false;
        }
    }

    public static void zipFileDelete(File file, File file2) {
        deleteFile(file);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "unzipResource|unzip resource succ targetDir=" + file2.getAbsolutePath());
        }
    }
}
