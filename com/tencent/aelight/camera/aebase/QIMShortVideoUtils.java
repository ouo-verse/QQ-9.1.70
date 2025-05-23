package com.tencent.aelight.camera.aebase;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import com.tencent.aelight.camera.api.IAEClassManager;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes32.dex */
public class QIMShortVideoUtils {
    public static boolean a(Context context) {
        try {
            Iterator<ActivityManager.RunningAppProcessInfo> it = SystemMethodProxy.getRunningAppProcesses((ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY)).iterator();
            while (it.hasNext()) {
                if ("com.tencent.mobileqq:peak".equals(it.next().processName)) {
                    return true;
                }
            }
            return false;
        } catch (Exception unused) {
            if (!QLog.isColorLevel()) {
                return false;
            }
            QLog.e("QIMShortVideoUtils", 2, "get process info fail.");
            return false;
        }
    }

    public static void c(final Context context, final Runnable runnable, final String str) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.aelight.camera.aebase.QIMShortVideoUtils.1
            /* JADX WARN: Removed duplicated region for block: B:24:0x0098  */
            /* JADX WARN: Removed duplicated region for block: B:47:? A[RETURN, SYNTHETIC] */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                boolean z16;
                SharedPreferences sharedPreferences;
                if (QIMShortVideoUtils.a(context)) {
                    return;
                }
                try {
                    sharedPreferences = MobileQQ.sMobileQQ.getSharedPreferences("CrashControl_com.tencent.mobileqq:peak", 4);
                } catch (Exception e16) {
                    e = e16;
                    z16 = true;
                }
                if (sharedPreferences != null && !sharedPreferences.getBoolean("allowpreload", true)) {
                    long j3 = sharedPreferences.getLong(AEEditorConstants.VIDEO_CLIP_START_TIME, 0L);
                    int i3 = sharedPreferences.getInt("controlwindow", 86400);
                    long currentTimeMillis = System.currentTimeMillis();
                    if (j3 > 0 && i3 > 0 && currentTimeMillis > j3 && currentTimeMillis - j3 > i3 * 1000) {
                        sharedPreferences.edit().putBoolean("allowpreload", true).commit();
                    } else {
                        QLog.d("QIMShortVideoUtils", 1, "preloadPeakProcess is not allowed as crash frequently.");
                        z16 = false;
                        try {
                            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(MobileQQ.sMobileQQ.peekAppRuntime().getAccount(), "actNoPreloadPeak", true, 0L, 0L, null, "");
                        } catch (Exception e17) {
                            e = e17;
                            if (QLog.isColorLevel()) {
                                QLog.d("QIMShortVideoUtils", 2, "preLoadPeakProcess, ", e);
                            }
                            if (z16) {
                            }
                        }
                        if (z16) {
                            if (r05.a.f430452a == null) {
                                String str2 = str;
                                if (str2 == null) {
                                    str2 = "peak_preload";
                                }
                                com.tencent.mobileqq.hitrate.d dVar = new com.tencent.mobileqq.hitrate.d(str2, "com.tencent.mobileqq:peak");
                                r05.a.f430452a = dVar;
                                dVar.a();
                            }
                            Intent intent = new Intent(context, (Class<?>) ((IAEClassManager) QRoute.api(IAEClassManager.class)).getPeakServiceClass());
                            intent.putExtra(AECameraConstants.INTENT_KEY_ACTION, 2);
                            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                            if (peekAppRuntime != null && ((IFeatureRuntimeService) peekAppRuntime.getRuntimeService(IFeatureRuntimeService.class, "all")).isFeatureSwitchEnable("pre_init_album_in_aio_scene")) {
                                intent.putExtra(AECameraConstants.INTENT_KEY_PRE_INIT_RES, true);
                            }
                            try {
                                context.startService(intent);
                            } catch (Throwable th5) {
                                if (QLog.isColorLevel()) {
                                    QLog.d("QIMShortVideoUtils", 2, "preLoadPeakProcess, ", th5);
                                }
                            }
                            if (QLog.isColorLevel()) {
                                QLog.d("QIMShortVideoUtils", 2, "preLoadPeakProcess");
                                return;
                            }
                            return;
                        }
                        return;
                    }
                }
                z16 = true;
                if (z16) {
                }
            }
        }, 64, null, false);
    }

    public static void b(Context context) {
        d(context, null);
    }

    public static void d(Context context, String str) {
        c(context, null, str);
    }
}
