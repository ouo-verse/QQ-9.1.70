package com.huawei.hms.aaid.init;

import android.content.Context;
import android.content.pm.PackageManager;
import com.huawei.hms.opendevice.f;
import com.huawei.hms.opendevice.i;
import com.huawei.hms.support.log.HMSLog;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;

/* compiled from: P */
/* loaded from: classes2.dex */
public class AutoInitHelper {
    public static void doAutoInit(Context context) {
        try {
            if (isAutoInitEnabled(context)) {
                HMSLog.i("AutoInit", "Push init start");
                new BaseThread(new f(context)).start();
            }
        } catch (Exception e16) {
            HMSLog.e("AutoInit", "Push init failed", e16);
        }
    }

    public static boolean isAutoInitEnabled(Context context) {
        i a16 = i.a(context);
        if (a16.containsKey("push_kit_auto_init_enabled")) {
            return a16.getBoolean("push_kit_auto_init_enabled");
        }
        try {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getBoolean("push_kit_auto_init_enabled");
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public static void setAutoInitEnabled(Context context, boolean z16) {
        i a16 = i.a(context);
        boolean z17 = a16.getBoolean("push_kit_auto_init_enabled");
        a16.saveBoolean("push_kit_auto_init_enabled", z16);
        if (z16 && !z17) {
            doAutoInit(context);
        }
    }
}
