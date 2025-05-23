package com.tencent.rmonitor.fd;

import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.os.ParcelFileDescriptor;
import android.support.annotation.NonNull;
import com.tencent.bugly.common.heapdump.DumpEnableChecker;
import com.tencent.bugly.common.heapdump.ForkJvmHeapDumper;
import com.tencent.bugly.common.thread.ThreadManager;
import com.tencent.bugly.common.utils.AndroidVersion;
import com.tencent.bugly.common.utils.RMonitorFeatureHelper;
import com.tencent.bugly.library.BuglyMonitorName;
import com.tencent.bugly.matrix.backtrace.WeChatBacktrace;
import com.tencent.rmonitor.DebugInterfaceProxy;
import com.tencent.rmonitor.base.config.data.j;
import com.tencent.rmonitor.base.meta.BaseInfo;
import com.tencent.rmonitor.base.plugin.monitor.PluginController;
import com.tencent.rmonitor.base.plugin.monitor.QAPMMonitorPlugin;
import com.tencent.rmonitor.common.logger.Logger;
import com.tencent.rmonitor.common.util.CrashProtector;
import com.tencent.rmonitor.fd.hook.FdOpenStackManager;
import java.io.FileDescriptor;

/* compiled from: P */
/* loaded from: classes25.dex */
public class FdLeakMonitor extends QAPMMonitorPlugin implements Handler.Callback {

    /* renamed from: d, reason: collision with root package name */
    private final g04.a f365550d;

    /* renamed from: e, reason: collision with root package name */
    private final Handler f365551e;

    /* renamed from: f, reason: collision with root package name */
    private final z04.a f365552f;

    /* renamed from: h, reason: collision with root package name */
    private final FdLeakTrigger f365553h;

    /* renamed from: i, reason: collision with root package name */
    private ParcelFileDescriptor[] f365554i;

    /* renamed from: m, reason: collision with root package name */
    private long f365555m;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private static final FdLeakMonitor f365556a = new FdLeakMonitor();
    }

    private void d(FileDescriptor fileDescriptor) {
        try {
            ThreadManager.getMonitorThreadLooper().getQueue().addOnFileDescriptorEventListener(fileDescriptor, 1, new d());
        } catch (Throwable th5) {
            nEnableLeakDetectThisTime(false);
            Logger.f365497g.c("RMonitor_FdLeak_Monitor", th5);
        }
    }

    public static FdLeakMonitor getInstance() {
        return b.f365556a;
    }

    private void h() {
        try {
            if (!AndroidVersion.isOverM()) {
                return;
            }
            ParcelFileDescriptor[] createPipe = ParcelFileDescriptor.createPipe();
            this.f365554i = createPipe;
            if (createPipe != null && createPipe.length == 2) {
                nInitLeakDetectInNative(com.tencent.rmonitor.fd.a.e(), this.f365554i[1].getFd());
                d(this.f365554i[0].getFileDescriptor());
                nEnableLeakDetectThisTime(true);
            }
        } catch (Throwable th5) {
            Logger.f365497g.c("RMonitor_FdLeak_Monitor", th5);
        }
    }

    private boolean j(c cVar) {
        if (f(cVar) && g(cVar) && e(cVar)) {
            return true;
        }
        return false;
    }

    private boolean k() {
        SharedPreferences sharedPreferences = BaseInfo.sharePreference;
        if (sharedPreferences == null || sharedPreferences.getInt("fd_dump_exception_count", 0) < 5) {
            return false;
        }
        return true;
    }

    private boolean l() {
        if (y04.c.i() > com.tencent.rmonitor.fd.a.e()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native boolean nEnableLeakDetectThisTime(boolean z16);

    static native void nInitLeakDetectInNative(int i3, int i16);

    public boolean e(c cVar) {
        if (k()) {
            a14.c.b("RMonitor_FdLeak_Monitor", "dump heap exception too many times.");
            if (cVar != null) {
                cVar.b(3);
            }
            return false;
        }
        if (com.tencent.rmonitor.fd.a.f() && CrashProtector.f(BuglyMonitorName.FD_ANALYZE, 30000L)) {
            a14.c.b("RMonitor_FdLeak_Monitor", "cannot start fd leak monitor due to too many crashes");
            if (cVar != null) {
                cVar.b(4);
            }
            return false;
        }
        return true;
    }

    public boolean f(c cVar) {
        if (!DumpEnableChecker.isForkDumpVersionPermitted() && !DebugInterfaceProxy.a()) {
            a14.c.b("RMonitor_FdLeak_Monitor", "cannot start fd leak monitor due to not support fork dump");
            if (cVar != null) {
                cVar.b(1);
            }
            return false;
        }
        if (b14.a.a() instanceof ForkJvmHeapDumper) {
            return true;
        }
        a14.c.b("RMonitor_FdLeak_Monitor", "cannot start fd leak monitor due to not have valid dumper");
        if (cVar != null) {
            cVar.b(5);
        }
        return false;
    }

    public boolean g(c cVar) {
        if (k04.a.b().f()) {
            Logger.f365497g.i("RMonitor_FdLeak_Monitor", "start fd leak monitor fail, couldn't support x86 or x86_64 arch");
            return false;
        }
        if (k04.a.b().e(BuglyMonitorName.FD_ANALYZE)) {
            Logger.f365497g.i("RMonitor_FdLeak_Monitor", "start fd monitor fail, couldn't open fd with native memory or asan same time.");
            if (cVar != null) {
                cVar.b(6);
            }
            return false;
        }
        if (!BuglyMonitorName.FD_ANALYZE.equals(k04.a.b().g())) {
            Logger.f365497g.i("RMonitor_FdLeak_Monitor", "start fd monitor failed, local sample failed!");
            if (cVar != null) {
                cVar.b(6);
            }
            return false;
        }
        Logger.f365497g.i("RMonitor_FdLeak_Monitor", "prepare to start fd monitor, local sample success!");
        return true;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(@NonNull Message message) {
        if (message.what == 1) {
            i(false);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i(boolean z16) {
        String str;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("current fd: ");
        sb5.append(y04.c.i());
        sb5.append(", from native: ");
        if (z16) {
            str = "true";
        } else {
            str = "false";
        }
        sb5.append(str);
        a14.c.d("RMonitor_FdLeak_Monitor", sb5.toString());
        if (l()) {
            if (this.f365553h.f()) {
                this.f365555m = 90000L;
            }
        } else {
            this.f365555m = this.f365550d.e();
            if (com.tencent.rmonitor.fd.a.a()) {
                nEnableLeakDetectThisTime(true);
            }
        }
        this.f365551e.removeMessages(1);
        if (PluginController.f365404b.b(BuglyMonitorName.FD_ANALYZE)) {
            this.f365551e.sendEmptyMessageDelayed(1, this.f365555m);
        } else {
            a14.c.e("RMonitor_FdLeak_Monitor", "fd leak can't collect, stop detect.");
            stop();
        }
    }

    @Override // com.tencent.rmonitor.base.plugin.monitor.QAPMMonitorPlugin
    public void start() {
        a14.c.d("RMonitor_FdLeak_Monitor", "fdLeakConfig: " + com.tencent.rmonitor.fd.a.d());
        c e16 = this.f365553h.e();
        if (j(e16)) {
            this.f365550d.f();
            RMonitorFeatureHelper.getInstance().onPluginStarted(j.a(BuglyMonitorName.FD_ANALYZE));
            this.f365551e.removeMessages(1);
            this.f365551e.sendEmptyMessageDelayed(1, this.f365555m);
            if (com.tencent.rmonitor.fd.a.f()) {
                FdOpenStackManager.c();
                if (com.tencent.rmonitor.fd.a.a()) {
                    h();
                }
            }
            a14.c.d("RMonitor_FdLeak_Monitor", "fd leak monitor started.");
            if (e16 != null) {
                e16.b(0);
            }
            WeChatBacktrace.initQuickBacktrace();
        }
    }

    @Override // com.tencent.rmonitor.base.plugin.monitor.QAPMMonitorPlugin
    public void stop() {
        this.f365550d.stop();
        RMonitorFeatureHelper.getInstance().onPluginClosed(j.a(BuglyMonitorName.FD_ANALYZE));
        this.f365551e.removeMessages(1);
        if (com.tencent.rmonitor.fd.a.a()) {
            nEnableLeakDetectThisTime(false);
        }
        if (com.tencent.rmonitor.fd.a.f()) {
            FdOpenStackManager.d();
        }
    }

    FdLeakMonitor() {
        this.f365550d = new g04.a(10000L, 10000L, 30000L);
        z04.a aVar = new z04.a();
        this.f365552f = aVar;
        this.f365553h = new FdLeakTrigger(aVar);
        this.f365554i = null;
        this.f365555m = 10000L;
        this.f365551e = new Handler(ThreadManager.getMonitorThreadLooper(), this);
    }
}
