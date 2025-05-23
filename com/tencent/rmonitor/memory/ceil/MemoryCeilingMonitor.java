package com.tencent.rmonitor.memory.ceil;

import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import com.tencent.bugly.common.heapdump.DumpEnableChecker;
import com.tencent.bugly.common.heapdump.ForkJvmHeapDumper;
import com.tencent.bugly.common.thread.ThreadManager;
import com.tencent.bugly.common.utils.AndroidVersion;
import com.tencent.bugly.common.utils.RMonitorFeatureHelper;
import com.tencent.bugly.library.BuglyMonitorName;
import com.tencent.rmonitor.DebugInterfaceProxy;
import com.tencent.rmonitor.base.config.data.j;
import com.tencent.rmonitor.base.meta.DumpResult;
import com.tencent.rmonitor.base.plugin.listener.IMemoryDumpListener;
import com.tencent.rmonitor.base.plugin.monitor.PluginController;
import com.tencent.rmonitor.base.plugin.monitor.RMonitorPlugin;
import com.tencent.rmonitor.common.logger.Logger;
import e14.c;
import f14.a;
import f14.b;

/* compiled from: P */
/* loaded from: classes25.dex */
public class MemoryCeilingMonitor extends RMonitorPlugin implements Handler.Callback {
    public static boolean G = false;
    private static final a H = new a();
    private static volatile MemoryCeilingMonitor I = null;

    /* renamed from: i, reason: collision with root package name */
    private long f365713i;

    /* renamed from: d, reason: collision with root package name */
    private final g04.a f365709d = new g04.a(5000, 5000, 30000);

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    private final StringBuilder f365711f = new StringBuilder(128);

    /* renamed from: h, reason: collision with root package name */
    private final b f365712h = new b(H);

    /* renamed from: m, reason: collision with root package name */
    private int f365714m = 0;
    private int C = 3;
    private int D = 5;
    private boolean E = false;
    private long F = 0;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    private final Handler f365710e = new Handler(ThreadManager.getMonitorThreadLooper(), this);

    MemoryCeilingMonitor() {
    }

    private void d() {
        Logger.f365497g.d("RMonitor_MemoryCeiling", "start detect memory ceiling");
        this.f365710e.removeMessages(1);
        this.f365710e.sendEmptyMessageDelayed(1, this.f365709d.e());
    }

    public static DumpResult dumpHprof(String str, IMemoryDumpListener iMemoryDumpListener) {
        if (PluginController.f365404b.b(BuglyMonitorName.MEMORY_JAVA_CEILING)) {
            return e14.b.b(str, str, true, false, iMemoryDumpListener, false, 0);
        }
        return null;
    }

    private boolean f() {
        this.f365713i = c.a();
        if (((float) this.f365713i) > e14.a.b() * ((float) Runtime.getRuntime().maxMemory())) {
            return true;
        }
        return false;
    }

    private void g() {
        if (!Logger.verbos) {
            return;
        }
        long d16 = com.tencent.rmonitor.common.util.a.d();
        this.f365711f.setLength(0);
        StringBuilder sb5 = this.f365711f;
        sb5.append("PSS=");
        sb5.append(d16 / 1024);
        sb5.append(" KB HeapMax=");
        sb5.append(Runtime.getRuntime().maxMemory() / 1024);
        sb5.append(" KB HeapAlloc=");
        sb5.append(Runtime.getRuntime().totalMemory() / 1024);
        sb5.append(" KB HeapFree=");
        sb5.append(Runtime.getRuntime().freeMemory() / 1024);
        sb5.append(" KB");
        Logger.f365497g.v("RMonitor_MemoryCeiling", this.f365711f.toString());
    }

    public static MemoryCeilingMonitor getInstance() {
        if (I == null) {
            synchronized (MemoryCeilingMonitor.class) {
                if (I == null) {
                    I = new MemoryCeilingMonitor();
                }
            }
        }
        return I;
    }

    private boolean h() {
        boolean f16 = f();
        boolean z16 = true;
        boolean z17 = false;
        if (f16) {
            int i3 = this.f365714m + 1;
            this.f365714m = i3;
            if (i3 > this.C) {
                this.f365714m = 0;
                z17 = true;
            }
        } else {
            this.f365714m = 0;
        }
        if (AndroidVersion.isOverM() && this.f365709d.e() == 5000) {
            long a16 = g14.a.a();
            if (a16 - this.F < this.D || !f16) {
                z16 = z17;
            }
            this.F = a16;
            return z16;
        }
        return z17;
    }

    public static void reportHprofFile(DumpResult dumpResult) {
        if (dumpResult != null && dumpResult.success) {
            H.a(dumpResult, "customDump");
        }
    }

    public boolean e() {
        if (!DumpEnableChecker.isForkDumpVersionPermitted() && !DebugInterfaceProxy.a()) {
            a14.c.b("RMonitor_MemoryCeiling", "cannot start memory ceil monitor due to not support fork dump");
            return false;
        }
        if (!(b14.a.a() instanceof ForkJvmHeapDumper)) {
            a14.c.b("RMonitor_MemoryCeiling", "cannot start memory ceil monitor due to not have valid dumper");
            return false;
        }
        if (!PluginController.f365404b.b(BuglyMonitorName.MEMORY_JAVA_CEILING)) {
            a14.c.b("RMonitor_MemoryCeiling", "report num is exceed today, please try next day");
            return false;
        }
        return true;
    }

    @Override // com.tencent.rmonitor.base.plugin.monitor.RMonitorPlugin
    public String getPluginName() {
        return BuglyMonitorName.MEMORY_JAVA_CEILING;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(@NonNull Message message) {
        if (message.what == 1) {
            Logger logger = Logger.f365497g;
            logger.d("RMonitor_MemoryCeiling", "handle memory detect ceiling message.");
            g();
            if (h()) {
                this.f365712h.b(this.f365713i);
            }
            if (!PluginController.f365404b.b(BuglyMonitorName.MEMORY_JAVA_CEILING)) {
                logger.d("RMonitor_MemoryCeiling", "memory celling report count above, remove MSG_MEMORY_CALCULATE msg,", " max report num: ", String.valueOf(e14.a.a().com.tencent.mobileqq.shortvideo.gesture.DownloadInfo.spKey_Config java.lang.String.dailyReportLimit));
                this.f365710e.removeMessages(1);
            } else {
                this.f365710e.sendEmptyMessageDelayed(1, this.f365709d.e());
            }
        }
        return true;
    }

    @Override // com.tencent.rmonitor.base.plugin.monitor.RMonitorPlugin
    public boolean isRunning() {
        return this.E;
    }

    @Override // com.tencent.rmonitor.base.plugin.monitor.QAPMMonitorPlugin
    public void start() {
        if (this.E) {
            Logger.f365497g.d("RMonitor_MemoryCeiling", "MemoryCeilingMonitor is alreay started");
            return;
        }
        if (e()) {
            Logger.f365497g.d("RMonitor_MemoryCeiling", "Start MemoryCeilingMonitor");
            this.E = true;
            this.f365709d.f();
            d();
            this.C = e14.a.c().C;
            this.D = e14.a.c().D;
            RMonitorFeatureHelper.getInstance().onPluginStarted(j.a(BuglyMonitorName.MEMORY_JAVA_CEILING));
            return;
        }
        Logger.f365497g.i("RMonitor_MemoryCeiling", "has not valid dumper, start failed");
    }

    @Override // com.tencent.rmonitor.base.plugin.monitor.QAPMMonitorPlugin
    public void stop() {
        if (!this.E) {
            Logger.f365497g.d("RMonitor_MemoryCeiling", "MemoryCeilingMonitor is already stop");
        }
        if (b14.a.a() instanceof ForkJvmHeapDumper) {
            this.E = false;
            Logger.f365497g.d("RMonitor_MemoryCeiling", "Stop MemoryCeilingMonitor");
            this.f365709d.stop();
            this.f365710e.removeMessages(1);
            RMonitorFeatureHelper.getInstance().onPluginClosed(j.a(BuglyMonitorName.MEMORY_JAVA_CEILING));
        }
    }
}
