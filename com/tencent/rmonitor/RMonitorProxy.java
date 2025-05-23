package com.tencent.rmonitor;

import android.support.annotation.Nullable;
import com.tencent.bugly.GlobalConfig;
import com.tencent.rmonitor.common.logger.Logger;
import com.tencent.rmonitor.common.util.g;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.rmonitor.sla.MetricAndSlaHelper;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import m14.c;
import m14.e;

/* loaded from: classes25.dex */
public class RMonitorProxy implements RMonitorConstants {

    /* renamed from: s, reason: collision with root package name */
    protected static final HashSet<String> f365249s = new HashSet<>(10);

    protected static void a(String str, int i3, Object obj) {
        String obj2;
        Logger logger = Logger.f365497g;
        String[] strArr = new String[6];
        strArr[0] = "RMonitor_manager_sdk";
        strArr[1] = str;
        strArr[2] = ", invalid property, key = ";
        strArr[3] = String.valueOf(i3);
        strArr[4] = ", value = ";
        if (obj == null) {
            obj2 = "null";
        } else {
            obj2 = obj.toString();
        }
        strArr[5] = obj2;
        logger.w(strArr);
    }

    public static void abolish() {
        if (!isInitOk()) {
            Logger.f365497g.e("RMonitor_manager_sdk", "abolish fail for ", g.c());
        } else {
            Logger.f365497g.i("RMonitor_manager_sdk", "abolish");
            Magnifier.a();
        }
    }

    public static boolean addProperty(int i3, Object obj) {
        boolean z16;
        m14.b c16 = e.a().c(i3);
        if (c16 != null) {
            z16 = c16.a(obj);
        } else {
            a("addProperty", i3, obj);
            z16 = false;
        }
        b("addProperty", i3, obj, z16);
        MetricAndSlaHelper.l().e();
        return z16;
    }

    protected static void b(String str, int i3, Object obj, boolean z16) {
        String obj2;
        Logger logger = Logger.f365497g;
        String[] strArr = new String[8];
        strArr[0] = "RMonitor_manager_sdk";
        strArr[1] = str;
        strArr[2] = ", key = ";
        strArr[3] = String.valueOf(i3);
        strArr[4] = ", value = ";
        if (obj == null) {
            obj2 = "null";
        } else {
            obj2 = obj.toString();
        }
        strArr[5] = obj2;
        strArr[6] = ", ret = ";
        strArr[7] = String.valueOf(z16);
        logger.i(strArr);
    }

    public static void disableAutoStartMetricAndSla() {
        MetricAndSlaHelper.l().j();
    }

    public static void enterScene(String str) {
        com.tencent.rmonitor.common.lifecycle.a.i().c(str);
    }

    public static void exitScene(String str) {
        com.tencent.rmonitor.common.lifecycle.a.i().d(str);
    }

    public static ICustomDataEditor getGlobalCustomDataEditor() {
        return com.tencent.rmonitor.custom.b.a();
    }

    public static String getUserData(String str) {
        return com.tencent.rmonitor.custom.b.a().getUserData(str);
    }

    public static boolean isInitOk() {
        return g.a();
    }

    public static boolean putUserData(String str, String str2) {
        return com.tencent.rmonitor.custom.b.a().putUserData(str, str2);
    }

    public static boolean removeProperty(int i3, Object obj) {
        boolean z16;
        m14.b c16 = e.a().c(i3);
        if (c16 != null) {
            z16 = c16.b(obj);
        } else {
            a("removeProperty", i3, obj);
            z16 = false;
        }
        b("removeProperty", i3, obj, z16);
        return z16;
    }

    public static String removeUserData(String str) {
        return com.tencent.rmonitor.custom.b.a().t(str);
    }

    public static boolean setProperty(int i3, String str) {
        boolean z16;
        c d16 = e.a().d(i3);
        if (d16 != null) {
            z16 = d16.b(str);
        } else {
            a("setProperty", i3, str);
            z16 = false;
        }
        b("setProperty", i3, str, z16);
        MetricAndSlaHelper.l().e();
        return z16;
    }

    public static void startMonitor(String str) {
        startMonitors(Collections.singletonList(str));
    }

    public static void startMonitors(List<String> list) {
        if (GlobalConfig.isInStandaloneMode()) {
            Logger.f365497g.w("RMonitor_manager_sdk", "start monitors fail for app in standalone mode.");
            return;
        }
        if (list != null && !list.isEmpty()) {
            if (!isInitOk()) {
                Logger.f365497g.e("RMonitor_manager_sdk", "start monitor fail for ", g.c());
                return;
            }
            Logger logger = Logger.f365497g;
            logger.i("RMonitor_manager_sdk", "start monitor, " + list.toString());
            if (Logger.debug) {
                logger.d("RMonitor_manager_sdk", "start monitor, need: " + list.toString() + ", current: " + f365249s.toString());
            }
            Magnifier.d(list);
            f365249s.addAll(list);
            return;
        }
        Logger.f365497g.e("RMonitor_manager_sdk", "start monitor fail for list is null or empty.");
    }

    public static void stopMonitor(String str) {
        stopMonitors(Collections.singletonList(str));
    }

    public static void stopMonitors(List<String> list) {
        if (list != null && !list.isEmpty()) {
            if (!isInitOk()) {
                Logger.f365497g.e("RMonitor_manager_sdk", "stop monitor fail for ", g.c());
                return;
            }
            Logger.f365497g.i("RMonitor_manager_sdk", "stop monitor, " + list.toString());
            Magnifier.f(list);
            f365249s.removeAll(list);
            return;
        }
        Logger.f365497g.e("RMonitor_manager_sdk", "stop monitor fail for list is null or empty.");
    }

    public static boolean setProperty(int i3, @Nullable Object obj) {
        boolean z16;
        m14.a b16 = e.a().b(i3);
        if (b16 != null) {
            z16 = b16.a(obj);
        } else {
            a("setProperty", i3, obj);
            z16 = false;
        }
        b("setProperty", i3, obj, z16);
        MetricAndSlaHelper.l().e();
        return z16;
    }
}
