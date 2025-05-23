package com.tencent.component.media.image;

import com.tencent.component.media.ImageManagerEnv;
import com.tencent.component.media.utils.ImageManagerLog;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes5.dex */
public class ImageTracer {
    private static final int LENGTH = 11;
    public static final String TAG = "ImageTracer";
    private static ConcurrentHashMap<String, long[]> mUrl2TimeMap = new ConcurrentHashMap<>(50, 0.75f, 8);

    public static void cancel(String str) {
        mUrl2TimeMap.get(ImageKey.getUrlKey(str, true));
    }

    private static void checkAndPrint(String str, long[] jArr) {
        if (jArr != null && jArr.length == 11) {
            long j3 = jArr[5] - jArr[0];
            long j16 = jArr[1];
            if (j16 != 0) {
                long j17 = jArr[2];
                if (j17 != 0) {
                    if (j3 > 5000) {
                        ImageManagerLog.w(TAG, "total:" + j3 + " download:" + (j17 - j16) + " image length:" + (jArr[6] >> 10) + "K decode:" + (jArr[4] - jArr[3]) + " url:" + str);
                        return;
                    }
                    return;
                }
            }
            if (j3 > 3000) {
                ImageManagerLog.w(TAG, "total:" + j3 + " has local file, decode:" + (jArr[4] - jArr[3]) + " url:" + str);
            }
        }
    }

    public static void decodeFail(String str) {
        long[] jArr = mUrl2TimeMap.get(ImageKey.getUrlKey(str, true));
        if (jArr != null && jArr.length > 4) {
            jArr[4] = System.currentTimeMillis();
            ImageManagerLog.e(TAG, "decode return null, url:" + str);
        }
    }

    public static void downloadFail(String str) {
        long[] jArr = mUrl2TimeMap.get(ImageKey.getUrlKey(str, true));
        if (jArr != null && jArr.length > 5) {
            long currentTimeMillis = System.currentTimeMillis();
            ImageManagerLog.e(TAG, "download fail, total:" + (currentTimeMillis - jArr[0]) + " download:" + (currentTimeMillis - jArr[1]) + " url:" + str);
        }
    }

    public static void end(String str) {
        long[] jArr = mUrl2TimeMap.get(ImageKey.getUrlKey(str, true));
        if (jArr != null && jArr.length > 5) {
            jArr[5] = System.currentTimeMillis();
            checkAndPrint(str, jArr);
        }
    }

    public static void endDecode(String str) {
        long[] jArr = mUrl2TimeMap.get(ImageKey.getUrlKey(str, true));
        if (jArr != null && jArr.length > 4) {
            long currentTimeMillis = System.currentTimeMillis();
            jArr[4] = currentTimeMillis;
            ImageManagerLog.w(TAG, "decode cost=" + (currentTimeMillis - jArr[3]) + " url=" + str);
        }
    }

    public static void endDownlaod(String str) {
        long[] jArr = mUrl2TimeMap.get(ImageKey.getUrlKey(str, true));
        if (jArr != null && jArr.length > 2) {
            jArr[2] = System.currentTimeMillis();
        }
    }

    public static void reportDecodeTime(String str, boolean z16) {
        String str2;
        long[] jArr = mUrl2TimeMap.get(ImageKey.getUrlKey(str, true));
        if (jArr != null && jArr.length > 4 && jArr[3] > 0 && jArr[4] > 0) {
            ImageManagerEnv g16 = ImageManagerEnv.g();
            if (z16) {
                str2 = ImageManagerEnv.MTA_VALUE_DECODE_TIME;
            } else {
                str2 = ImageManagerEnv.MTA_VALUE_DECODE_TIME_NONE_SR;
            }
            g16.reportImageTimeCostMTA(ImageManagerEnv.MTA_EVENT_KEY_IMAGE_DECODE, ImageManagerEnv.MTA_SUB_KEY_IMAGE_TIME_COST, str2, (int) (jArr[4] - jArr[3]));
        }
    }

    public static void reportDownloadTime(String str, boolean z16) {
        String str2;
        long[] jArr = mUrl2TimeMap.get(ImageKey.getUrlKey(str, true));
        if (jArr != null && jArr.length > 2 && jArr[1] > 0 && jArr[2] > 0) {
            ImageManagerEnv g16 = ImageManagerEnv.g();
            if (z16) {
                str2 = ImageManagerEnv.MTA_VALUE_DOWNLOAD_TIME;
            } else {
                str2 = ImageManagerEnv.MTA_VALUE_DOWNLOAD_TIME_NONE_SR;
            }
            g16.reportImageTimeCostMTA(ImageManagerEnv.MTA_EVENT_KEY_IMAGE_DECODE, ImageManagerEnv.MTA_SUB_KEY_IMAGE_TIME_COST, str2, (int) (jArr[2] - jArr[1]));
        }
    }

    public static void setImageLength(String str, long j3) {
        long[] jArr = mUrl2TimeMap.get(ImageKey.getUrlKey(str, true));
        if (jArr != null && jArr.length > 6) {
            jArr[6] = j3;
        }
    }

    public static void start(String str) {
        String urlKey = ImageKey.getUrlKey(str, true);
        long[] jArr = mUrl2TimeMap.get(urlKey);
        if (jArr == null) {
            jArr = new long[11];
            mUrl2TimeMap.put(urlKey, jArr);
        }
        if (jArr.length > 0) {
            jArr[0] = System.currentTimeMillis();
        }
    }

    public static void startDecode(String str) {
        long[] jArr = mUrl2TimeMap.get(ImageKey.getUrlKey(str, true));
        if (jArr != null && jArr.length > 3) {
            jArr[3] = System.currentTimeMillis();
        }
    }

    public static void startDownlaod(String str) {
        long[] jArr = mUrl2TimeMap.get(ImageKey.getUrlKey(str, true));
        if (jArr != null && jArr.length > 1) {
            jArr[1] = System.currentTimeMillis();
        }
    }
}
