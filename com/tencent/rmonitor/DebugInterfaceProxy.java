package com.tencent.rmonitor;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Looper;
import android.widget.Toast;
import com.tencent.bugly.common.thread.ThreadManager;
import com.tencent.bugly.common.utils.DebugConfig;
import com.tencent.rmonitor.base.config.c;
import com.tencent.rmonitor.base.config.g;
import com.tencent.rmonitor.common.logger.Logger;

/* loaded from: classes25.dex */
public class DebugInterfaceProxy implements DebugInterface {

    /* renamed from: b, reason: collision with root package name */
    private static boolean f365225b = false;

    /* renamed from: a, reason: collision with root package name */
    private final com.tencent.rmonitor.base.config.b f365226a = new c();

    public static boolean a() {
        return f365225b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean b(Activity activity) {
        if (activity == null) {
            return false;
        }
        try {
            c(activity);
            return true;
        } catch (Throwable th5) {
            Logger.f365497g.b("RMonitor_debug", "showDebugTip fail", th5);
            return false;
        }
    }

    @SuppressLint({"NewApi"})
    private static void c(final Activity activity) {
        Runnable runnable = new Runnable() { // from class: com.tencent.rmonitor.DebugInterfaceProxy.1
            @Override // java.lang.Runnable
            public void run() {
                Toast.makeText(activity, "\u6b63\u5728\u8c03\u7528Bugly\u7684\u6d4b\u8bd5\u63a5\u53e3\uff0c\u4e0a\u7ebf\u524d\u8bf7\u52a1\u5fc5\u79fb\u9664!!!", 1).show();
            }
        };
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            runnable.run();
        } else {
            ThreadManager.runInMainThread(runnable, 0L);
        }
    }

    @Override // com.tencent.rmonitor.DebugInterface
    public void addConfigUpdaterForDebug(Activity activity, g gVar) {
        if (b(activity) && f365225b) {
            this.f365226a.a(gVar);
        }
    }

    @Override // com.tencent.rmonitor.DebugInterface
    public void refreshConfigForDebug(Activity activity) {
        if (b(activity) && f365225b) {
            this.f365226a.b();
        }
    }

    @Override // com.tencent.rmonitor.DebugInterface
    public void removeConfigUpdaterForDebug(Activity activity, g gVar) {
        if (b(activity) && f365225b) {
            this.f365226a.c(gVar);
        }
    }

    @Override // com.tencent.rmonitor.DebugInterface
    public void setDebugMode(Activity activity, boolean z16) {
        if (b(activity)) {
            f365225b = z16;
            this.f365226a.setDebugMode(z16);
            DebugConfig.INSTANCE.setDebugMode(z16);
        }
    }
}
