package com.tencent.rmonitor.common.util;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.bugly.common.meta.UserMeta;
import com.tencent.bugly.common.thread.ThreadManager;
import com.tencent.rmonitor.base.meta.BaseInfo;

/* compiled from: P */
/* loaded from: classes25.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f365538a = true;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f365539b = false;

    public static boolean a() {
        if (BaseInfo.app == null) {
            return false;
        }
        UserMeta userMeta = BaseInfo.userMeta;
        if (TextUtils.isEmpty(userMeta.appVersion)) {
            userMeta.appVersion = b.f365535j.b(BaseInfo.app.getApplicationContext());
        }
        if (TextUtils.isEmpty(userMeta.buildNumber)) {
            userMeta.buildNumber = b.f365535j.c(BaseInfo.app.getApplicationContext());
        }
        if (TextUtils.isEmpty(userMeta.appId) || TextUtils.isEmpty(userMeta.appKey) || TextUtils.isEmpty(userMeta.appVersion)) {
            return false;
        }
        return true;
    }

    public static long b() {
        return SystemClock.uptimeMillis() * 1000;
    }

    public static String c() {
        String str;
        if (BaseInfo.app == null) {
            str = "you should set PROPERTY_KEY_APP_INSTANCE. ";
        } else {
            str = "";
        }
        UserMeta userMeta = BaseInfo.userMeta;
        if (TextUtils.isEmpty(userMeta.appId) || TextUtils.isEmpty(userMeta.appKey)) {
            str = str + "you should set PROPERTY_KEY_APP_ID. ";
        }
        if (TextUtils.isEmpty(userMeta.appVersion)) {
            return str + "we can not get your app version, you should set PROPERTY_KEY_APP_VERSION ";
        }
        return str;
    }

    public static void d(Runnable runnable) {
        if (f365538a) {
            ThreadManager.runInMonitorThread(runnable, 0L);
        } else {
            runnable.run();
        }
    }

    public static boolean e(boolean z16) {
        f365539b = z16;
        return z16;
    }
}
