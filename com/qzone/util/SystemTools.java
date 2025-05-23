package com.qzone.util;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.upload.image.ImageProcessService;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import java.util.List;

/* compiled from: P */
/* loaded from: classes37.dex */
public class SystemTools {
    public static boolean a(Context context, String str) {
        PackageInfo packageInfo;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            packageInfo = InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), str, 0);
        } catch (PackageManager.NameNotFoundException e16) {
            QZLog.w(e16);
            packageInfo = null;
        }
        return packageInfo != null;
    }

    public static boolean b() {
        ActivityManager activityManager = (ActivityManager) BaseApplicationImpl.getApplication().getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
        if (activityManager == null) {
            return false;
        }
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = SystemMethodProxy.getRunningAppProcesses(activityManager);
        if (runningAppProcesses != null) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo != null && (runningAppProcessInfo.processName.endsWith(":picture") || runningAppProcessInfo.processName.endsWith(":peak") || runningAppProcessInfo.processName.endsWith(":qzonevideo") || runningAppProcessInfo.processName.endsWith(":tool"))) {
                    if (runningAppProcessInfo.importance == 100) {
                        if (QZLog.isColorLevel()) {
                            QZLog.i("SystemTools", 2, "isQzoneExtraProcessForground >> " + runningAppProcessInfo.processName + "[ " + runningAppProcessInfo.importance + " ]");
                        }
                        return true;
                    }
                }
            }
        } else {
            QZLog.i("SystemTools", 1, "isQzoneExtraProcessForground: RunningAppProcess null");
        }
        return false;
    }

    public static void c() {
        if (com.qzone.reborn.configx.g.f53821a.j().l()) {
            return;
        }
        QZLog.d("SystemTools", 1, "killImageService...");
        try {
            BaseApplication.getContext().stopService(new Intent(BaseApplication.getContext(), (Class<?>) ImageProcessService.class));
            QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).postDelayed(new Runnable() { // from class: com.qzone.util.SystemTools.3
                @Override // java.lang.Runnable
                public void run() {
                    String packageName = BaseApplication.getContext().getPackageName();
                    km.a.f412646a.e(BaseApplication.getContext(), packageName + ":imageservice");
                }
            }, 900L);
        } catch (Exception e16) {
            QZLog.w(e16);
        }
    }

    public static void e() {
        try {
            BaseApplication.getContext().stopService(com.qzone.common.activities.base.ak.e(BaseApplication.getContext()));
        } catch (Exception e16) {
            QZLog.e("SystemTools", "exception:", e16);
        }
        d();
        c();
    }

    public static void f() {
        try {
            QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).postDelayed(new Runnable() { // from class: com.qzone.util.SystemTools.1
                @Override // java.lang.Runnable
                public void run() {
                    String packageName = BaseApplication.getContext().getPackageName();
                    km.a.f412646a.e(BaseApplication.getContext(), packageName + ":qzonevideo");
                }
            }, 900L);
        } catch (Exception e16) {
            QZLog.w(e16);
        }
    }

    public static void d() {
        QZLog.d("SystemTools", 1, "killPictureProcess...");
        try {
            BaseApplication.getContext().stopService(com.qzone.common.activities.base.ak.z(BaseApplication.getContext()));
            QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).postDelayed(new Runnable() { // from class: com.qzone.util.SystemTools.2
                @Override // java.lang.Runnable
                public void run() {
                    String packageName = BaseApplication.getContext().getPackageName();
                    km.a.f412646a.e(BaseApplication.getContext(), packageName + ":picture");
                }
            }, 900L);
        } catch (Exception e16) {
            QZLog.w(e16);
        }
    }
}
