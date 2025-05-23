package com.tencent.mobileqq.perf.thread;

import android.os.HandlerThread;
import com.tencent.mobileqq.perf.thread.block.ThreadWatcher;
import com.tencent.mobileqq.perf.thread.config.c;
import com.tencent.mobileqq.perf.thread.config.d;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.AppSetting;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes16.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static c f258082a;

    /* renamed from: b, reason: collision with root package name */
    private static com.tencent.mobileqq.perf.thread.block.b f258083b;

    /* renamed from: c, reason: collision with root package name */
    private static final AtomicBoolean f258084c;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(47585);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f258084c = new AtomicBoolean(false);
        }
    }

    public static void a() {
        if (QLog.isColorLevel()) {
            QLog.d("[TM]ThreadMonitorManager", 2, "init");
        }
        if (4 == MobileQQ.sProcessId) {
            return;
        }
        AtomicBoolean atomicBoolean = f258084c;
        if (atomicBoolean.compareAndSet(false, true)) {
            c c16 = c();
            f258082a = c16;
            if (c16 == null) {
                if (QLog.isColorLevel()) {
                    QLog.e("[TM]ThreadMonitorManager", 2, "sThreadConfig is null.");
                }
                atomicBoolean.set(false);
                return;
            }
            com.tencent.mobileqq.perf.thread.config.b bVar = c16.f258135a;
            if (bVar != null) {
                new com.tencent.mobileqq.perf.thread.block.b(bVar, new ThreadWatcher(bVar)).l();
                return;
            }
            QLog.d("[TM]ThreadMonitorManager", 1, "init, threadBlockConfig is null");
            if (!AppSetting.isPublicVersion() && !AppSetting.isDebugVersion()) {
                com.tencent.mobileqq.perf.thread.config.b a16 = com.tencent.mobileqq.perf.thread.config.b.a();
                new com.tencent.mobileqq.perf.thread.block.b(a16, new ThreadWatcher(a16)).l();
                QLog.d("[TM]ThreadMonitorManager", 1, "init, use local default config");
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("[TM]ThreadMonitorManager", 2, "has initialized.");
        }
    }

    public static void b(int i3, HandlerThread handlerThread) {
        if (4 != MobileQQ.sProcessId) {
            QLog.d("[TM]ThreadMonitorManager", 1, "not in msf process. init failed");
            return;
        }
        if (f258084c.compareAndSet(false, true)) {
            f258082a = c();
        }
        c cVar = f258082a;
        if (cVar == null) {
            QLog.d("[TM]ThreadMonitorManager", 1, "threadConfig is null.init failed");
            return;
        }
        com.tencent.mobileqq.perf.thread.config.b bVar = cVar.f258135a;
        if (bVar == null) {
            if (!AppSetting.isPublicVersion() && !AppSetting.isDebugVersion()) {
                bVar = com.tencent.mobileqq.perf.thread.config.b.a();
                QLog.d("[TM]ThreadMonitorManager", 1, "init, use local default config");
            } else {
                QLog.d("[TM]ThreadMonitorManager", 1, "init failed, threadBlockConfig is null");
                return;
            }
        }
        if (f258083b == null) {
            f258083b = new com.tencent.mobileqq.perf.thread.block.b(bVar, new ThreadWatcher(bVar));
        }
        f258083b.c(i3, handlerThread);
        QLog.d("[TM]ThreadMonitorManager", 1, "initMSFThreadMonitor");
    }

    private static c c() {
        d dVar;
        try {
            dVar = (d) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("102905");
        } catch (Throwable th5) {
            QLog.e("[TM]ThreadMonitorManager", 1, th5, new Object[0]);
            dVar = null;
        }
        if (dVar == null) {
            if (QLog.isColorLevel()) {
                QLog.e("[TM]ThreadMonitorManager", 2, "loadConfig, cfgBean is null ! ");
            }
            return null;
        }
        if (AppSetting.isGrayVersion()) {
            if (QLog.isColorLevel()) {
                QLog.d("[TM]ThreadMonitorManager", 2, "loadConfig,  set gray cfg. ");
            }
            return dVar.f258138f;
        }
        if (AppSetting.isPublicVersion()) {
            if (QLog.isColorLevel()) {
                QLog.d("[TM]ThreadMonitorManager", 2, "loadConfig,  set official cfg. ");
            }
            return dVar.f258137e;
        }
        if (QLog.isColorLevel()) {
            QLog.d("[TM]ThreadMonitorManager", 2, "loadConfig,  set develop cfg. ");
        }
        return dVar.f258139h;
    }
}
