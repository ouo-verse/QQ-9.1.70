package com.tencent.mobileqq.shortvideo.util;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Environment;
import android.os.StatFs;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.ttpic.baseutils.device.DeviceInstance;
import java.io.File;

/* compiled from: P */
/* loaded from: classes18.dex */
public class Utils {
    private static long[] CRCTable = new long[256];
    private static final long INITIALCRC = -1;
    private static final long POLY64REV = -7661587058870466123L;
    public static final String TAG = "URLDrawable.Utils";
    private static boolean init = false;

    Utils() {
    }

    public static final long Crc64Long(String str) {
        if (str != null && str.length() != 0) {
            if (!init) {
                for (int i3 = 0; i3 < 256; i3++) {
                    long j3 = i3;
                    for (int i16 = 0; i16 < 8; i16++) {
                        if ((((int) j3) & 1) != 0) {
                            j3 = (j3 >> 1) ^ POLY64REV;
                        } else {
                            j3 >>= 1;
                        }
                    }
                    CRCTable[i3] = j3;
                }
                init = true;
            }
            int length = str.length();
            long j16 = -1;
            for (int i17 = 0; i17 < length; i17++) {
                j16 = (j16 >> 8) ^ CRCTable[(str.charAt(i17) ^ ((int) j16)) & 255];
            }
            return j16;
        }
        return 0L;
    }

    public static final String Crc64String(String str) {
        return Long.toString(Crc64Long(str), 16);
    }

    public static void disableConnectionReuseIfNecessary() {
        if (hasHttpConnectionBug()) {
            System.setProperty("http.keepAlive", "false");
        }
    }

    @SuppressLint({"NewApi"})
    public static int getBitmapSize(Bitmap bitmap) {
        if (bitmap == null) {
            return 0;
        }
        if (DeviceInstance.getSDKVersion() >= 12) {
            return bitmap.getByteCount();
        }
        return bitmap.getRowBytes() * bitmap.getHeight();
    }

    @SuppressLint({"NewApi"})
    public static File getExternalCacheDir(Context context) {
        if (hasExternalCacheDir()) {
            return context.getExternalCacheDir();
        }
        return new File(Environment.getExternalStorageDirectory().getPath() + ("/Android/data/" + context.getPackageName() + "/imagecache/"));
    }

    public static int getMemoryClass(Context context) {
        return ((ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY)).getMemoryClass();
    }

    @SuppressLint({"NewApi"})
    public static long getUsableSpace(File file) {
        if (DeviceInstance.getSDKVersion() >= 9) {
            return file.getUsableSpace();
        }
        StatFs statFs = new StatFs(file.getPath());
        return statFs.getBlockSize() * statFs.getAvailableBlocks();
    }

    public static boolean hasExternalCacheDir() {
        if (DeviceInstance.getSDKVersion() >= 8) {
            return true;
        }
        return false;
    }

    public static boolean hasHttpConnectionBug() {
        if (DeviceInstance.getSDKVersion() < 8) {
            return true;
        }
        return false;
    }

    @SuppressLint({"NewApi"})
    public static boolean isExternalStorageRemovable() {
        if (DeviceInstance.getSDKVersion() >= 9) {
            return Environment.isExternalStorageRemovable();
        }
        return true;
    }
}
