package com.tencent.rmonitor.natmem;

import com.tencent.bugly.common.thread.ThreadManager;
import com.tencent.bugly.common.utils.AndroidVersion;
import com.tencent.bugly.common.utils.RMonitorFeatureHelper;
import com.tencent.bugly.library.BuglyMonitorName;
import com.tencent.rmonitor.base.config.ConfigProxy;
import com.tencent.rmonitor.base.config.data.NatMemPluginConfig;
import com.tencent.rmonitor.base.config.data.j;
import com.tencent.rmonitor.base.plugin.monitor.PluginController;
import com.tencent.rmonitor.base.plugin.monitor.QAPMMonitorPlugin;
import com.tencent.rmonitor.common.logger.Logger;
import com.tencent.rmonitor.common.util.CrashProtector;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;
import l14.f;

/* compiled from: P */
/* loaded from: classes25.dex */
public class NatMemMonitor extends QAPMMonitorPlugin {

    /* renamed from: h, reason: collision with root package name */
    private static NatMemMonitor f365786h = null;

    /* renamed from: i, reason: collision with root package name */
    protected static boolean f365787i = false;

    /* renamed from: m, reason: collision with root package name */
    private static boolean f365788m;

    /* renamed from: d, reason: collision with root package name */
    private NatMemHandler f365789d;

    /* renamed from: e, reason: collision with root package name */
    private NatMemPluginConfig f365790e;

    /* renamed from: f, reason: collision with root package name */
    private AtomicBoolean f365791f = new AtomicBoolean(false);

    static {
        try {
            System.loadLibrary("rmonitor_memory");
            f365788m = true;
        } catch (Throwable th5) {
            Logger.f365497g.c("RMonitor_NatMem_Monitor", th5);
            f365788m = false;
        }
    }

    NatMemMonitor() {
        if (f365788m) {
            this.f365790e = (NatMemPluginConfig) ConfigProxy.INSTANCE.getConfig().k(BuglyMonitorName.NATIVE_MEMORY_ANALYZE);
            this.f365789d = new NatMemHandler(ThreadManager.getMonitorThreadLooper());
        }
        f365786h = this;
        this.f365791f.set(false);
    }

    public static NatMemMonitor getInstance() {
        if (f365786h == null) {
            synchronized (NatMemMonitor.class) {
                if (f365786h == null) {
                    f365786h = new NatMemMonitor();
                }
            }
        }
        return f365786h;
    }

    public void d(String str) {
        if (f365788m && f365787i) {
            File parentFile = new File(str).getParentFile();
            if (!parentFile.exists()) {
                parentFile.mkdirs();
            }
            nativeDumpNatMemLeakInfo(str);
            return;
        }
        Logger.f365497g.e("dumpNatMemLeakInfo failed");
    }

    public void e(String str) {
        if (f365788m && f365787i) {
            File parentFile = new File(str).getParentFile();
            if (!parentFile.exists()) {
                parentFile.mkdirs();
            }
            nativeDumpNatMemUsageInfo(str, f.f().i(false));
            return;
        }
        Logger.f365497g.e("dumpNatMemUsageInfo failed");
    }

    public NatMemPluginConfig f() {
        return this.f365790e;
    }

    public void g(String str) {
        nativeSetSceneInfo(str);
    }

    protected int h() {
        if (AndroidVersion.isOverO() && com.tencent.rmonitor.common.util.f.a()) {
            if (CrashProtector.f(BuglyMonitorName.NATIVE_MEMORY_ANALYZE, 30000L)) {
                Logger.f365497g.e("RMonitor_NatMem_Monitor", "start native memory monitor fail, for start failed many times");
                b.c("crash_times");
                return 1;
            }
            if (!PluginController.f365404b.b(BuglyMonitorName.NATIVE_MEMORY_ANALYZE)) {
                Logger.f365497g.i("RMonitor_NatMem_Monitor", "start native memory monitor fail, for can not report again");
                return 3;
            }
            if (k04.a.b().f()) {
                Logger.f365497g.i("RMonitor_NatMem_Monitor", "start native memory monitor fail, couldn't support x86 or x86_64 arch");
                return 5;
            }
            if (k04.a.b().e(BuglyMonitorName.NATIVE_MEMORY_ANALYZE)) {
                Logger.f365497g.i("RMonitor_NatMem_Monitor", "start native memory monitor fail, couldn't open native memory with fd or asan same time.");
                return 4;
            }
            if (!BuglyMonitorName.NATIVE_MEMORY_ANALYZE.equals(k04.a.b().g())) {
                Logger.f365497g.i("RMonitor_NatMem_Monitor", "start native memory monitor failed, local sample failed!");
                return 4;
            }
            Logger.f365497g.i("RMonitor_NatMem_Monitor", "prepare to start native memory monitor, local sample success!");
            return 0;
        }
        Logger.f365497g.d("RMonitor_NatMem_Monitor", "start native memory monitor fail, for android version");
        b.c("android_verison");
        return 2;
    }

    public void i() {
        if (f365788m && !f365787i) {
            this.f365790e = (NatMemPluginConfig) ConfigProxy.INSTANCE.getConfig().k(BuglyMonitorName.NATIVE_MEMORY_ANALYZE);
            this.f365789d.obtainMessage(1).sendToTarget();
            this.f365789d.obtainMessage(2).sendToTarget();
            f365787i = true;
            return;
        }
        Logger.f365497g.e("startMonitor failed,mSoLoadSuccess = " + f365788m);
    }

    native int nativeDumpNatMemLeakInfo(String str);

    /* JADX INFO: Access modifiers changed from: package-private */
    public native int nativeDumpNatMemUsageInfo(String str, long j3);

    /* JADX INFO: Access modifiers changed from: package-private */
    public native int nativeIgnoreLib(String str);

    /* JADX INFO: Access modifiers changed from: package-private */
    public native int nativeInit();

    /* JADX INFO: Access modifiers changed from: package-private */
    public native void nativeInitAppHookParameter(int i3);

    /* JADX INFO: Access modifiers changed from: package-private */
    public native void nativeInitSysHookParameter(int i3, int i16, int i17);

    /* JADX INFO: Access modifiers changed from: package-private */
    public native int nativeRegisterAppLib(String str);

    /* JADX INFO: Access modifiers changed from: package-private */
    public native int nativeRegisterSysLib(String str);

    native void nativeSetSceneInfo(String str);

    native void nativeSetUnwindSwtich(boolean z16);

    /* JADX INFO: Access modifiers changed from: package-private */
    public native int nativeStartHook(long j3);

    @Override // com.tencent.rmonitor.base.plugin.monitor.QAPMMonitorPlugin
    public void start() {
        if (f365788m && !this.f365791f.get()) {
            int h16 = h();
            if (h16 != 0) {
                d.b(h16);
                return;
            }
            i();
            nativeSetUnwindSwtich(true);
            RMonitorFeatureHelper.getInstance().onPluginStarted(j.a(BuglyMonitorName.NATIVE_MEMORY_ANALYZE));
            this.f365791f.set(true);
            Logger.f365497g.d("RMonitor_NatMem_Monitor", "start natmem monitor!!");
        }
    }

    @Override // com.tencent.rmonitor.base.plugin.monitor.QAPMMonitorPlugin
    public void stop() {
        this.f365791f.set(false);
        if (f365788m) {
            nativeSetUnwindSwtich(false);
        }
        RMonitorFeatureHelper.getInstance().onPluginClosed(j.a(BuglyMonitorName.NATIVE_MEMORY_ANALYZE));
    }
}
