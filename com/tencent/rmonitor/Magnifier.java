package com.tencent.rmonitor;

import com.tencent.bugly.common.thread.ThreadManager;
import com.tencent.rmonitor.base.meta.BaseInfo;
import com.tencent.rmonitor.base.plugin.monitor.QAPMMonitorPlugin;
import com.tencent.rmonitor.common.logger.Logger;
import com.tencent.rmonitor.common.util.g;
import com.tencent.rmonitor.manager.e;
import com.tencent.rmonitor.sla.MetricAndSlaHelper;
import java.util.List;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes25.dex */
public class Magnifier {

    /* renamed from: a, reason: collision with root package name */
    private static volatile boolean f365228a = false;

    /* JADX INFO: Access modifiers changed from: protected */
    public static void a() {
        if (g.a()) {
            c(3, null);
            return;
        }
        Logger.f365497g.e("RMonitor_manager_Magnifier", "abolish fail, app: " + BaseInfo.app + ", userMeta: " + BaseInfo.userMeta);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static QAPMMonitorPlugin b(String str, boolean z16) {
        MetricAndSlaHelper.l().d();
        QAPMMonitorPlugin e16 = e.f365703f.e(str, z16);
        MetricAndSlaHelper.l().k();
        return e16;
    }

    private static void c(final int i3, final List<String> list) {
        ThreadManager.runInMonitorThread(new Runnable() { // from class: com.tencent.rmonitor.Magnifier.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    int i16 = i3;
                    if (i16 == 1) {
                        e eVar = e.f365703f;
                        eVar.j();
                        eVar.i(list);
                    } else if (i16 == 2) {
                        e.f365703f.l(list);
                    } else if (i16 == 3) {
                        e.f365703f.a();
                    } else if (i16 == 4) {
                        e.f365703f.m();
                    }
                } catch (Throwable unused) {
                }
            }
        }, 0L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void d(List<String> list) {
        if (g.a()) {
            if (f365228a && e.f365703f.c(list)) {
                Logger.f365497g.i("RMonitor_manager_Magnifier", "startMonitors, " + list.toString() + " has started yet.");
                return;
            }
            if (!f365228a) {
                f365228a = true;
            }
            c(1, list);
            return;
        }
        Logger.f365497g.e("RMonitor_manager_Magnifier", String.format(Locale.getDefault(), "startMonitors fail, app: %s, userMeta: %s", BaseInfo.app, BaseInfo.userMeta));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void e() {
        if (g.a()) {
            c(4, null);
            return;
        }
        Logger.f365497g.e("RMonitor_manager_Magnifier", "stopDisabledPlugins fail for [app: " + BaseInfo.app + ", userMeta: " + BaseInfo.userMeta + "]");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void f(List<String> list) {
        if (g.a()) {
            if (e.f365703f.d(list)) {
                c(2, list);
                return;
            }
            Logger.f365497g.i("RMonitor_manager_Magnifier", "stopMonitors, no monitor started for " + list.toString());
            return;
        }
        Logger.f365497g.e("RMonitor_manager_Magnifier", "stopMonitors fail app: " + BaseInfo.app + ", userMeta: " + BaseInfo.userMeta);
    }
}
