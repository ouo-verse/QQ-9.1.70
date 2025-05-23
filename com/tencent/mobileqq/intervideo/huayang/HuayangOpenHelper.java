package com.tencent.mobileqq.intervideo.huayang;

import android.app.ActivityManager;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.intervideo.IPluginEnterManager;
import com.tencent.mobileqq.intervideo.IVPluginInfo;
import com.tencent.mobileqq.intervideo.shadow.PluginProcessKiller;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes33.dex */
public class HuayangOpenHelper {

    /* renamed from: a, reason: collision with root package name */
    public static String f238233a;

    public static void c(final QQAppInterface qQAppInterface, String str, String str2, final String str3, String str4, final String str5, String str6, String str7) {
        if (QLog.isColorLevel()) {
            QLog.i("HuayangOpenHelper", 2, String.format("appType = %s,openType = %s, fromId = %s, uri = %s \uff0caction = %s,pkgName = %s", str, str2, str4, str3, str5, str6));
        }
        MonitorConfig.a(qQAppInterface.getApp(), str);
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str6)) {
            return;
        }
        if ("slientDownload".equals(str5)) {
            Monitor.d("2587808");
        } else if ("download".equals(str5)) {
            if (((IHuayangJsPlugin) QRoute.api(IHuayangJsPlugin.class)).isODPkg(str6)) {
                Monitor.d("2691701");
            } else if (((IHuayangJsPlugin) QRoute.api(IHuayangJsPlugin.class)).isHyPkg(str6)) {
                Monitor.d("2597718");
            } else {
                MonitorConfig.c(qQAppInterface.getApp(), str);
            }
        }
        Map<String, IVPluginInfo> b16 = IVPluginInfo.b(str7);
        if (b16.size() == 0) {
            b16 = IVPluginInfo.a();
        }
        final Map<String, IVPluginInfo> map = b16;
        if (TextUtils.isEmpty(str)) {
            str = "hy_sixgod";
        }
        final String str8 = str;
        final IHuayangDowanloadHelper a16 = b.a(qQAppInterface.getApp(), str6, str8);
        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.intervideo.huayang.HuayangOpenHelper.1
            @Override // java.lang.Runnable
            public void run() {
                ((IPluginEnterManager) QRoute.api(IPluginEnterManager.class)).switchBiz(str8, (PluginProcessKiller) a16);
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.intervideo.huayang.HuayangOpenHelper.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        IHuayangDowanloadHelper iHuayangDowanloadHelper = a16;
                        String str9 = str8;
                        String currentUin = qQAppInterface.getCurrentUin();
                        AnonymousClass1 anonymousClass12 = AnonymousClass1.this;
                        iHuayangDowanloadHelper.downloadPlugin(str9, currentUin, str3, str5, map);
                    }
                });
            }
        });
        d(str2, str2);
    }

    private static void e(Context context, String str) {
        boolean z16;
        ActivityManager activityManager = (ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
        do {
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = SystemMethodProxy.getRunningAppProcesses(activityManager);
            if (runningAppProcesses != null && runningAppProcesses.size() != 0) {
                Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z16 = false;
                        break;
                    } else if (str.equals(it.next().processName)) {
                        z16 = true;
                        break;
                    }
                }
            } else {
                return;
            }
        } while (z16);
        if (QLog.isColorLevel()) {
            QLog.d("HuayangOpenHelper", 2, "waitKillProcess done");
        }
    }

    public static void a(Context context, String str) {
        if (str == null || str.equals(f238233a)) {
            return;
        }
        Monitor.d("2490051");
        f238233a = str;
        if (QLog.isColorLevel()) {
            QLog.d("HuayangOpenHelper", 2, "\u8bf7\u6c42\u542f\u52a8\u7684\u7c7b\u578b\u4e0e\u6700\u8fd1\u4e00\u6b21\u542f\u52a8\u7684\u7c7b\u578b\u4e0d\u540c\uff0c\u5148\u6740\u6b7b :troophomework\u8fdb\u7a0b\uff01");
        }
        String packageName = context.getPackageName();
        b(context, packageName + ":troophomework");
        e(context, packageName + ":troophomework");
    }

    private static void d(String str, String str2) {
        if (str == null) {
            str = "HyProxy";
        }
        id0.a.n("huayang", "openHy", 0, 0, str, str2);
    }

    public static void b(Context context, String str) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        if (str == null || (runningAppProcesses = SystemMethodProxy.getRunningAppProcesses((ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY))) == null || runningAppProcesses.size() == 0) {
            return;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (str.equals(runningAppProcessInfo.processName)) {
                if (QLog.isColorLevel()) {
                    QLog.d("HuayangOpenHelper", 2, "\u6740\u6b7b\u8fdb\u7a0b\uff1a" + str);
                }
                SystemMethodProxy.killProcess(runningAppProcessInfo.pid);
                return;
            }
        }
    }
}
