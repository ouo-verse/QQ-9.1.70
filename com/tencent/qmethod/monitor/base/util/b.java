package com.tencent.qmethod.monitor.base.util;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.pm.PackageManager;
import com.tencent.qmethod.pandoraex.core.o;
import com.tencent.qmethod.pandoraex.core.strategy.CacheStrategyFactory;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\b\u0010\u0003\u001a\u00020\u0002H\u0003J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0002J\u0006\u0010\b\u001a\u00020\u0006\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/qmethod/monitor/base/util/b;", "", "", "c", "b", "firstInstallTime", "", "d", "a", "<init>", "()V", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes22.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f343532a = new b();

    b() {
    }

    private final long b() {
        return f.b("rightly_stored_first_install_time");
    }

    @SuppressLint({"Privacy-InstalledApps"})
    private final long c() {
        try {
            Application context = com.tencent.qmethod.monitor.a.f343451h.g().getContext();
            return InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), context.getPackageName(), 0).firstInstallTime;
        } catch (PackageManager.NameNotFoundException unused) {
            return 0L;
        }
    }

    private final void d(long firstInstallTime) {
        if (firstInstallTime > 0) {
            f.f("rightly_stored_first_install_time", firstInstallTime);
        }
    }

    public final void a() {
        try {
            long c16 = c();
            o.a("DeviceCloneHelper", "systemFirstInstallTime=" + c16);
            if (c16 <= 0) {
                return;
            }
            long b16 = b();
            o.a("DeviceCloneHelper", "storedFirstInstallTime=" + b16);
            if (b16 <= 0) {
                d(c16);
                return;
            }
            o.a("DeviceCloneHelper", "systemFirstInstallTime=" + c16 + ", storedFirstInstallTime=" + b16);
            if (b16 != c16) {
                Application context = com.tencent.qmethod.monitor.a.f343451h.g().getContext();
                com.tencent.qmethod.monitor.a.b(context);
                CacheStrategyFactory.a(context).d(context, "version", "2");
                d(c16);
                o.a("DeviceCloneHelper", "success clean, new value=" + c16);
            }
        } catch (Throwable th5) {
            o.b("DeviceCloneHelper", "clearStorageIfNeed", th5);
        }
    }
}
