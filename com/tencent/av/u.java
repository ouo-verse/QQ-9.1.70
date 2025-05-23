package com.tencent.av;

import android.app.ActivityManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.PowerManager;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.utils.IQzoneVideoHelper;
import cooperation.qzone.LocalMultiProcConfig;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public class u extends com.tencent.av.app.g {

    /* renamed from: a, reason: collision with root package name */
    public static final String f74641a = b.a();

    public static Bitmap a(String str, int i3, int i16) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inDensity = i3;
        if (i16 >= 0) {
            options.inTargetDensity = i16;
        }
        options.inScaled = true;
        Bitmap d16 = com.tencent.mobileqq.util.j.d(str, options);
        if (d16 == null) {
            QLog.w("VideoUtils", 1, "decodeFileWithXhdpi, \u52a0\u8f7d\u5931\u8d25, path[" + str + "]");
        } else if (com.tencent.av.utils.e.j()) {
            QLog.w("VideoUtils", 1, "decodeFileWithXhdpi, bitmap[" + d16.getWidth() + ", " + d16.getHeight() + "], Density[" + d16.getDensity() + "], path[" + str + "], density[" + i3 + "], inTargetDensity[" + i16 + "], outWidth[" + options.outWidth + "], outHeight[" + options.outHeight + "], inDensity[" + options.inDensity + "], inSampleSize[" + options.inSampleSize + "], inScreenDensity[" + options.inScreenDensity + "], inTargetDensity[" + options.inTargetDensity + "], bitmapSize[" + d16.getWidth() + ", " + d16.getHeight() + "]");
        }
        return d16;
    }

    public static Bitmap b(Resources resources, String str) {
        return a(str, 320, resources.getDisplayMetrics().densityDpi);
    }

    public static boolean c() {
        boolean z16 = false;
        try {
            z16 = vu.a.g("qav_debug_sp").getBoolean("qav_invite_preview_camera", false);
            QLog.d("VideoUtils", 1, "getQavInvitePreviewCamera : " + z16);
            return z16;
        } catch (Throwable th5) {
            QLog.e("VideoUtils", 2, "getQavInvitePreviewCamera fail.", th5);
            return z16;
        }
    }

    public static final boolean d() {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        try {
            boolean bool = LocalMultiProcConfig.getBool(IQzoneVideoHelper.IS_QZONE_LIVE_LAUNCH, false);
            QLog.d("VideoUtils", 1, "isQzoneLiveExist, isRunning=" + bool);
            if (!bool || (runningAppProcesses = SystemMethodProxy.getRunningAppProcesses((ActivityManager) BaseApplication.getContext().getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY))) == null) {
                return false;
            }
            int i3 = -2;
            for (int i16 = 0; i16 < runningAppProcesses.size(); i16++) {
                if ("com.tencent.mobileqq:qzonelive".equals(runningAppProcesses.get(i16).processName)) {
                    i3 = runningAppProcesses.get(i16).pid;
                }
            }
            int i17 = LocalMultiProcConfig.getInt(IQzoneVideoHelper.QZONE_LIVE_PROCESS_ID, -1);
            QLog.d("VideoUtils", 1, "isQzoneLiveExist, processId=" + i3 + ", id=" + i17);
            if (i3 == i17) {
                return true;
            }
            return false;
        } catch (Exception e16) {
            QLog.e("VideoUtils", 1, e16, new Object[0]);
            return false;
        }
    }

    public static void e(String str, long j3) {
        try {
            QLog.d("VideoUtils", 1, String.format("requestPartialWakeLock tag=%s timeout=%s", str, Long.valueOf(j3)));
            PowerManager powerManager = (PowerManager) BaseApplication.getContext().getSystemService("power");
            if (powerManager != null) {
                powerManager.newWakeLock(1, str).acquire(j3);
            }
        } catch (Throwable th5) {
            QLog.d(str, 1, "requestPartialWakeLock fail.", th5);
        }
    }

    public static void f(String str, long j3) {
        try {
            QLog.d("VideoUtils", 1, String.format("requestScreenBrightWakeLock tag=%s timeout=%s", str, Long.valueOf(j3)));
            PowerManager powerManager = (PowerManager) BaseApplication.getContext().getSystemService("power");
            if (powerManager != null) {
                powerManager.newWakeLock(805306378, str).acquire(j3);
            }
        } catch (Throwable th5) {
            QLog.d(str, 1, "requestScreenBrightWakeLock fail.", th5);
        }
    }
}
