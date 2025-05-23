package com.tencent.rmonitor.asan;

import android.content.Context;
import com.tencent.bugly.common.utils.ContextUtil;
import com.tencent.bugly.library.BuglyMonitorName;
import com.tencent.bugly.matrix.memguard.MemGuard;
import com.tencent.rmonitor.base.config.ConfigProxy;
import com.tencent.rmonitor.base.config.data.c;
import com.tencent.rmonitor.base.plugin.monitor.RMonitorPlugin;
import com.tencent.rmonitor.common.logger.Logger;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import k04.a;

/* compiled from: P */
/* loaded from: classes25.dex */
public class AddressSanitizer extends RMonitorPlugin {

    /* renamed from: f, reason: collision with root package name */
    private static volatile AddressSanitizer f365251f;

    /* renamed from: h, reason: collision with root package name */
    private static boolean f365252h;

    /* renamed from: d, reason: collision with root package name */
    private final AtomicBoolean f365253d = new AtomicBoolean(false);

    /* renamed from: e, reason: collision with root package name */
    private c f365254e;

    static {
        try {
            System.loadLibrary("rmonitor_base");
            System.loadLibrary("buglybacktrace");
            f365252h = true;
        } catch (Throwable th5) {
            Logger.f365497g.c("Bugly_Asan_Monitor", th5);
            f365252h = false;
        }
    }

    AddressSanitizer() {
    }

    private void e(Context context) {
        MemGuard.Options.Builder isIgnoreOverlappedReading = new MemGuard.Options.Builder(context).setMaxDetectableSize(this.f365254e.f365310m).setMaxDetectableAllocationCount(this.f365254e.C).setMaxSkippedAllocationCount(this.f365254e.D).setPercentageOfLeftSideGuard(this.f365254e.E).setIsPerfectRightSideGuard(this.f365254e.F).setIsIgnoreOverlappedReading(this.f365254e.G);
        List<String> list = this.f365254e.H;
        if (list != null && !list.isEmpty()) {
            if (list.size() == 1) {
                isIgnoreOverlappedReading.setTargetSOPattern(list.get(0), new String[0]);
            } else {
                isIgnoreOverlappedReading.setTargetSOPattern(list.get(0), (String[]) list.subList(1, list.size()).toArray(new String[0]));
            }
        }
        List<String> list2 = this.f365254e.I;
        if (list2 != null && !list2.isEmpty()) {
            if (list2.size() == 1) {
                isIgnoreOverlappedReading.setIgnoredSOPattern(list2.get(0), new String[0]);
            } else {
                isIgnoreOverlappedReading.setIgnoredSOPattern(list2.get(0), (String[]) list2.subList(1, list2.size()).toArray(new String[0]));
            }
        }
        MemGuard.install(isIgnoreOverlappedReading.build(), null);
    }

    private boolean f() {
        if (a.b().f()) {
            Logger.f365497g.i("Bugly_Asan_Monitor", "start addressSanitizer failed, couldn't support x86 or x86_64 arch");
            return false;
        }
        if (a.b().e(BuglyMonitorName.ASAN)) {
            Logger.f365497g.i("Bugly_Asan_Monitor", "start addressSanitizer failed, couldn't open asan with fd or native memory same time.");
            return false;
        }
        if (!BuglyMonitorName.ASAN.equals(a.b().g())) {
            Logger.f365497g.i("Bugly_Asan_Monitor", "start addressSanitizer failed, local sample failed!");
            return false;
        }
        Logger.f365497g.i("Bugly_Asan_Monitor", "prepare to start addressSanitizer, local sample success!");
        return true;
    }

    public static AddressSanitizer getInstance() {
        if (f365251f == null) {
            synchronized (AddressSanitizer.class) {
                if (f365251f == null) {
                    f365251f = new AddressSanitizer();
                }
            }
        }
        return f365251f;
    }

    public c d() {
        return (c) ConfigProxy.INSTANCE.getConfig().i(BuglyMonitorName.ASAN).com.tencent.mobileqq.shortvideo.gesture.DownloadInfo.spKey_Config java.lang.String;
    }

    @Override // com.tencent.rmonitor.base.plugin.monitor.RMonitorPlugin
    public String getPluginName() {
        return BuglyMonitorName.ASAN;
    }

    @Override // com.tencent.rmonitor.base.plugin.monitor.RMonitorPlugin
    public boolean isRunning() {
        return this.f365253d.get();
    }

    @Override // com.tencent.rmonitor.base.plugin.monitor.QAPMMonitorPlugin
    public void start() {
        if (f365252h) {
            if (this.f365253d.get()) {
                Logger.f365497g.d("Bugly_Asan_Monitor", "addressSanitizer has already started!");
                return;
            }
            if (!f()) {
                Logger.f365497g.d("Bugly_Asan_Monitor", "start addressSanitizer failed!");
                return;
            }
            this.f365254e = d();
            e(ContextUtil.getGlobalContext());
            notifyStartResult(0, "");
            Logger.f365497g.d("Bugly_Asan_Monitor", "start addressSanitizer success!");
            this.f365253d.set(true);
            return;
        }
        Logger.f365497g.e("Bugly_Asan_Monitor", "start addressSanitizer failed, so load failed!");
    }

    @Override // com.tencent.rmonitor.base.plugin.monitor.QAPMMonitorPlugin
    public void stop() {
        if (!this.f365253d.get()) {
            return;
        }
        Logger.f365497g.i("Bugly_Asan_Monitor", "stop addressSanitizer, only stop dump issue file.");
        MemGuard.stopDumpIssue();
        notifyStopResult(0, "");
        this.f365253d.set(false);
    }
}
