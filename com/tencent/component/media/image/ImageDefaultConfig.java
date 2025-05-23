package com.tencent.component.media.image;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.component.media.ImageManagerEnv;
import com.tencent.component.media.image.PoolParams;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public class ImageDefaultConfig {
    private static final String TAG = "ImageDefaultConfig";
    private static String sProcessName;
    public static final int[][] BYTE_ARRAY = {new int[]{6, 25000}, new int[]{6, 200000}};
    public static final int[][] BYTE_ARRAY_LOCAL = {new int[]{6, 25000}, new int[]{6, 200000}, new int[]{6, 1000000}, new int[]{8, 6000000}};
    private static int screenWidth = -1;
    private static boolean smallScreem = false;
    static int[] bmpCount4Qzone = {2, 1, 1};
    static final int[] PIC_WEIGHT = {1, 2, 2};
    static int[] bmpSize4Qzone = {1000, 16000, 32000};
    static int[] bmpCount4Picture = {40, 2};
    static int[] bmpSize4Picture = {30000, 30000};
    private static int screenHeight = -1;

    public static PoolParams.BucketParams getArtBitmapBucketParams(Context context, int i3) {
        int screenWidth2 = getScreenWidth(context);
        getScreenHeight(context);
        if (isQzone(context)) {
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 == 2) {
                        return new PoolParams.BucketParams(bmpSize4Qzone[2], bmpCount4Qzone[2]);
                    }
                } else {
                    return new PoolParams.BucketParams(bmpSize4Qzone[1], bmpCount4Qzone[1]);
                }
            } else {
                return new PoolParams.BucketParams(bmpSize4Qzone[0], bmpCount4Qzone[0]);
            }
        } else if (isPicture(context)) {
            if (i3 != 0) {
                if (i3 == 1) {
                    return new PoolParams.BucketParams(bmpSize4Picture[1], bmpCount4Picture[1]);
                }
            } else {
                return new PoolParams.BucketParams(bmpSize4Picture[0], bmpCount4Picture[0]);
            }
        } else if (i3 != 0) {
            if (i3 == 1) {
                int i16 = ((screenWidth2 * screenWidth2) * 4) / 9;
                int i17 = 1048576 / i16;
                if (i17 < 3) {
                    i17++;
                }
                return new PoolParams.BucketParams(i16 + 1000, i17);
            }
        } else {
            return new PoolParams.BucketParams(16000, 1);
        }
        return new PoolParams.BucketParams(1, 1);
    }

    public static int getArtBitmapPoolSize(Context context) {
        if (isPicture(context) || !isQzone(context)) {
            return 2;
        }
        return 3;
    }

    private static synchronized String getProcessName(Context context) {
        synchronized (ImageDefaultConfig.class) {
            if (TextUtils.isEmpty(sProcessName)) {
                int myPid = Process.myPid();
                List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = SystemMethodProxy.getRunningAppProcesses((ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY));
                if (runningAppProcesses == null) {
                    return "unknown";
                }
                Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    ActivityManager.RunningAppProcessInfo next = it.next();
                    if (next.pid == myPid) {
                        sProcessName = next.processName;
                        break;
                    }
                }
            }
            return sProcessName;
        }
    }

    public static int getScreenHeight(Context context) {
        if (screenHeight <= 0) {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            int i3 = displayMetrics.widthPixels;
            int i16 = displayMetrics.heightPixels;
            if (i3 <= i16) {
                i3 = i16;
            }
            screenHeight = i3;
        }
        return screenHeight;
    }

    public static int getScreenWidth(Context context) {
        if (screenWidth <= 0) {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            int i3 = displayMetrics.widthPixels;
            int i16 = displayMetrics.heightPixels;
            if (i3 > i16) {
                i3 = i16;
            }
            screenWidth = i3;
        }
        return screenWidth;
    }

    public static void initBmpCount4Picture(Context context, int i3) {
        ImageManagerEnv.getLogger().d(TAG, "---------ImageLoader----maxBitMapPool---" + i3);
        ImageManagerEnv.getLogger().d(TAG, "---------ImageLoader--before--counts:---" + bmpCount4Picture[0]);
        int screenWidth2 = getScreenWidth(context);
        int screenHeight2 = getScreenHeight(context);
        int[] iArr = bmpSize4Picture;
        int i16 = (int) (screenHeight2 * screenWidth2 * 4 * 0.6d);
        iArr[1] = i16;
        int i17 = ((screenWidth2 * screenWidth2) / 36) * 4;
        iArr[0] = i17;
        int[] iArr2 = bmpCount4Picture;
        int i18 = i3 - ((i17 * iArr2[0]) + (i16 * iArr2[1]));
        while (i18 < 0) {
            int[] iArr3 = bmpSize4Picture;
            int i19 = (int) (iArr3[1] * 0.8f);
            iArr3[1] = i19;
            int[] iArr4 = bmpCount4Picture;
            int i26 = (int) (iArr4[0] * 0.8f);
            iArr4[0] = i26;
            i18 = i3 - ((iArr3[0] * i26) + (i19 * iArr4[1]));
            ImageManagerEnv.getLogger().d(TAG, "---------ImageLoader---reduce bmp size(0.8),new size:" + bmpSize4Picture[0]);
        }
        ImageManagerEnv.getLogger().d(TAG, "---------ImageLoader---size:" + bmpSize4Picture[0]);
        while (true) {
            int[] iArr5 = bmpSize4Picture;
            if (i18 > iArr5[0]) {
                int[] iArr6 = bmpCount4Picture;
                iArr6[0] = iArr6[0] + 1;
                i18 -= iArr5[0];
            } else {
                ImageManagerEnv.getLogger().d(TAG, "---------ImageLoader--after--counts:-bmpCount4Picture[0]--" + bmpCount4Picture[0] + "-bmpCount4Picture[1]" + bmpCount4Picture[1] + ",bmpSize4Picture[1] == " + bmpSize4Picture[1]);
                return;
            }
        }
    }

    public static void initBmpCount4Qzone(Context context, int i3) {
        ImageManagerEnv.getLogger().d(TAG, "---------ImageLoader----maxBitMapPool---" + i3);
        ImageManagerEnv.getLogger().d(TAG, "---------ImageLoader--before--counts:---" + bmpCount4Qzone[0] + "," + bmpCount4Qzone[1] + "," + bmpCount4Qzone[2]);
        int screenWidth2 = getScreenWidth(context);
        getScreenHeight(context);
        int[] iArr = bmpSize4Qzone;
        float f16 = (float) (screenWidth2 * screenWidth2 * 4);
        int i16 = ((int) (0.09876543f * f16)) + 1000;
        iArr[0] = i16;
        int i17 = ((int) (0.19753087f * f16)) + 1000;
        iArr[1] = i17;
        int i18 = ((int) (f16 * 0.3125f)) + 1000;
        iArr[2] = i18;
        int[] iArr2 = bmpCount4Qzone;
        int i19 = i3 - (((i16 * iArr2[0]) + (i17 * iArr2[1])) + (i18 * iArr2[2]));
        while (i19 < 0) {
            int[] iArr3 = bmpSize4Qzone;
            int i26 = (int) (iArr3[0] * 0.8f);
            iArr3[0] = i26;
            int i27 = (int) (iArr3[1] * 0.8f);
            iArr3[1] = i27;
            int i28 = (int) (iArr3[2] * 0.8f);
            iArr3[2] = i28;
            int[] iArr4 = bmpCount4Qzone;
            i19 = i3 - (((i26 * iArr4[0]) + (i27 * iArr4[1])) + (i28 * iArr4[2]));
            ImageManagerEnv.getLogger().d(TAG, "---------ImageLoader---reduce bmp size(0.8),new size:" + bmpSize4Qzone[0] + "," + bmpSize4Qzone[1] + "," + bmpSize4Qzone[2]);
        }
        ImageManagerEnv.getLogger().d(TAG, "---------ImageLoader---size:" + bmpSize4Qzone[0] + ",size1:" + bmpSize4Qzone[1] + ",size2:" + bmpSize4Qzone[2]);
        while (i19 > bmpSize4Qzone[0]) {
            boolean z16 = true;
            for (int i29 = 0; i29 < PIC_WEIGHT[2]; i29++) {
                int[] iArr5 = bmpSize4Qzone;
                if (i19 > iArr5[2]) {
                    int[] iArr6 = bmpCount4Qzone;
                    iArr6[2] = iArr6[2] + 1;
                    i19 -= iArr5[2];
                    z16 = false;
                }
            }
            for (int i36 = 0; i36 < PIC_WEIGHT[1]; i36++) {
                int[] iArr7 = bmpSize4Qzone;
                if (i19 > iArr7[1]) {
                    int[] iArr8 = bmpCount4Qzone;
                    iArr8[1] = iArr8[1] + 1;
                    i19 -= iArr7[1];
                    z16 = false;
                }
            }
            for (int i37 = 0; i37 < PIC_WEIGHT[0]; i37++) {
                int[] iArr9 = bmpSize4Qzone;
                int i38 = iArr9[0];
                if (i38 < 6 && i19 > i38) {
                    int[] iArr10 = bmpCount4Qzone;
                    iArr10[0] = iArr10[0] + 1;
                    i19 -= iArr9[0];
                    z16 = false;
                }
            }
            if (z16) {
                break;
            }
        }
        ImageManagerEnv.getLogger().d(TAG, "---------ImageLoader--after--counts:---" + bmpCount4Qzone[0] + "," + bmpCount4Qzone[1] + "," + bmpCount4Qzone[2]);
    }

    public static boolean isMobileQQ(Context context) {
        String processName = getProcessName(context);
        if (TextUtils.isEmpty(processName) || !"com.tencent.mobileqq".equals(processName)) {
            return false;
        }
        return true;
    }

    public static boolean isPicture(Context context) {
        String processName = getProcessName(context);
        if (!TextUtils.isEmpty(processName) && "com.tencent.mobileqq:picture".equals(processName)) {
            return true;
        }
        return false;
    }

    public static boolean isQzone(Context context) {
        String processName = getProcessName(context);
        if (TextUtils.isEmpty(processName)) {
            return false;
        }
        if ("com.tencent.mobileqq:qzone".equals(processName)) {
            return true;
        }
        String[] split = processName.split("/");
        if (split.length < 2 || !"com.tencent.mobileqq".equals(split[0]) || TextUtils.isEmpty(split[1])) {
            return false;
        }
        String[] split2 = split[1].toLowerCase().split("\\.");
        if (split2.length <= 0 || !split2[split2.length - 1].startsWith("qzone") || !split2[split2.length - 1].endsWith("proxyactivity")) {
            return false;
        }
        return true;
    }
}
