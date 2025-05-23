package com.tencent.rmonitor.common.util;

import android.content.SharedPreferences;
import com.tencent.bugly.common.thread.ThreadManager;
import com.tencent.rmonitor.base.meta.BaseInfo;
import com.tencent.rmonitor.common.logger.Logger;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes25.dex */
public class CrashProtector {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f365511a = true;

    /* renamed from: b, reason: collision with root package name */
    private static final LinkedList<String> f365512b = new LinkedList<>();

    public static void b(boolean z16) {
        f365511a = z16;
    }

    @NotNull
    protected static String c(String str) {
        return "disable_forever_" + BaseInfo.userMeta.sdkVersion + "_" + str;
    }

    @NotNull
    protected static String d(String str) {
        return "start_failed_times_" + BaseInfo.userMeta.sdkVersion + "_" + str;
    }

    @NotNull
    protected static String e(String str) {
        return "recovery_" + BaseInfo.userMeta.sdkVersion + "_" + str;
    }

    public static boolean f(final String str, long j3) {
        if (!f365511a) {
            return false;
        }
        LinkedList<String> linkedList = f365512b;
        if (linkedList.contains(str)) {
            Logger.f365497g.d("RMonitor_common_CrashProtector", "plugin " + str + " is in protect list");
            return false;
        }
        linkedList.add(str);
        SharedPreferences sharedPreferences = BaseInfo.sharePreference;
        if (sharedPreferences == null) {
            return true;
        }
        final SharedPreferences.Editor edit = sharedPreferences.edit();
        String e16 = e(str);
        String c16 = c(str);
        String d16 = d(str);
        if (sharedPreferences.getBoolean(e16, false)) {
            Logger.f365497g.d("RMonitor_common_CrashProtector", "recovery plugin " + str + " for config");
            edit.putBoolean(c16, false);
            edit.putInt(d16, 0);
            edit.commit();
            return false;
        }
        if (sharedPreferences.getBoolean(c16, false)) {
            Logger.f365497g.d("RMonitor_common_CrashProtector", "start plugin " + str + " fail due to disabled");
            return true;
        }
        int i3 = sharedPreferences.getInt(d16, 0);
        if (i3 > 3) {
            edit.putBoolean(c16, true);
            edit.commit();
            Logger.f365497g.d("RMonitor_common_CrashProtector", "start plugin " + str + " fail duo to too many failed times");
            return true;
        }
        edit.putInt(d16, i3 + 1);
        edit.commit();
        ThreadManager.runInMonitorThread(new Runnable() { // from class: com.tencent.rmonitor.common.util.CrashProtector.1
            @Override // java.lang.Runnable
            public void run() {
                edit.putInt(CrashProtector.d(str), 0);
                edit.commit();
                CrashProtector.f365512b.remove(str);
            }
        }, j3);
        return false;
    }

    public static void g(List<String> list) {
        SharedPreferences sharedPreferences = BaseInfo.sharePreference;
        if (sharedPreferences == null) {
            return;
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            edit.putBoolean(e(it.next()), true);
        }
        edit.commit();
    }
}
