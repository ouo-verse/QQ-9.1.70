package com.tencent.rmonitor.looper;

import android.os.Looper;
import com.tencent.bugly.common.utils.GcInfoStatHelper;
import com.tencent.bugly.library.BuglyMonitorName;
import com.tencent.rmonitor.base.config.ConfigProxy;
import com.tencent.rmonitor.base.config.data.g;
import com.tencent.rmonitor.base.config.data.m;
import com.tencent.rmonitor.base.plugin.monitor.RMonitorPlugin;
import com.tencent.rmonitor.common.logger.Logger;
import com.tencent.rmonitor.looper.provider.QuickStackProvider;
import com.tencent.rmonitor.looper.provider.StackQueueProvider;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u0000 \u00072\u00020\u0001:\u0001\u0018B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\bH\u0016J\b\u0010\r\u001a\u00020\bH\u0016J\b\u0010\u000e\u001a\u00020\bH\u0016J\n\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0011\u001a\u00020\nH\u0016R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0012R\u0016\u0010\u0015\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0014\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/rmonitor/looper/LooperMonitor;", "Lcom/tencent/rmonitor/base/plugin/monitor/RMonitorPlugin;", "Lcom/tencent/rmonitor/looper/LagObserver;", "d", "Lcom/tencent/rmonitor/looper/provider/b;", "e", "Lcom/tencent/rmonitor/looper/provider/c;", "f", "", "start", "", "isResume", "pause", "resume", "stop", "", "getPluginName", "isRunning", "Lcom/tencent/rmonitor/looper/LagObserver;", "lagObserver", "Z", "isStart", "<init>", "()V", "a", "rmonitor-looper_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class LooperMonitor extends RMonitorPlugin {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private LagObserver lagObserver;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean isStart;

    private final LagObserver d() {
        LagObserver bVar;
        com.tencent.rmonitor.looper.provider.b e16 = e();
        if (Intrinsics.areEqual(e16.f365688f, "vsync")) {
            bVar = new d(e16);
        } else {
            Looper mainLooper = Looper.getMainLooper();
            Intrinsics.checkExpressionValueIsNotNull(mainLooper, "Looper.getMainLooper()");
            bVar = new b(mainLooper, e16);
        }
        bVar.j(f());
        return bVar;
    }

    private final com.tencent.rmonitor.looper.provider.b e() {
        com.tencent.rmonitor.looper.provider.b bVar = new com.tencent.rmonitor.looper.provider.b();
        m a16 = a.f365658a.a(BuglyMonitorName.LOOPER_STACK);
        if (!(a16 instanceof g)) {
            a16 = null;
        }
        g gVar = (g) a16;
        if (gVar != null) {
            bVar.f365683a = gVar.eventSampleRatio;
            bVar.f365684b = gVar.threshold;
            bVar.f365686d = gVar.j();
            bVar.f365687e = gVar.i();
            bVar.f365688f = gVar.L;
        } else {
            bVar.f365683a = 0.1f;
            bVar.f365684b = 200L;
            bVar.f365686d = 52L;
            bVar.f365687e = true;
            bVar.f365688f = "msg";
        }
        Logger.f365497g.d("RMonitor_lag", "createLagParam lagParam: " + bVar);
        return bVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0029, code lost:
    
        if (r1 != false) goto L10;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final com.tencent.rmonitor.looper.provider.c f() {
        StackQueueProvider stackQueueProvider;
        if ((ConfigProxy.INSTANCE.getConfig().k(BuglyMonitorName.LOOPER_STACK) instanceof g) && Math.random() < ((g) r0).h()) {
            QuickStackProvider quickStackProvider = new QuickStackProvider();
            boolean r16 = quickStackProvider.r();
            stackQueueProvider = quickStackProvider;
        }
        stackQueueProvider = null;
        if (stackQueueProvider == null) {
            stackQueueProvider = new StackQueueProvider();
        }
        Logger.f365497g.d("RMonitor_lag", "createLooperStackProvider, stackProvider: " + stackQueueProvider);
        return stackQueueProvider;
    }

    @Override // com.tencent.rmonitor.base.plugin.monitor.RMonitorPlugin
    @Nullable
    public String getPluginName() {
        return BuglyMonitorName.LOOPER_STACK;
    }

    @Override // com.tencent.rmonitor.base.plugin.monitor.RMonitorPlugin
    public boolean isResume() {
        LagObserver lagObserver = this.lagObserver;
        if (lagObserver != null) {
            return lagObserver.g();
        }
        return false;
    }

    @Override // com.tencent.rmonitor.base.plugin.monitor.RMonitorPlugin
    /* renamed from: isRunning, reason: from getter */
    public boolean getIsStart() {
        return this.isStart;
    }

    @Override // com.tencent.rmonitor.base.plugin.monitor.RMonitorPlugin
    public void pause() {
        LagObserver lagObserver;
        if (this.isStart && (lagObserver = this.lagObserver) != null) {
            lagObserver.h();
        }
    }

    @Override // com.tencent.rmonitor.base.plugin.monitor.RMonitorPlugin
    public void resume() {
        LagObserver lagObserver;
        if (this.isStart && (lagObserver = this.lagObserver) != null) {
            lagObserver.i();
        }
    }

    @Override // com.tencent.rmonitor.base.plugin.monitor.QAPMMonitorPlugin
    public void start() {
        LagObserver d16;
        if (!a.f365658a.b(BuglyMonitorName.LOOPER_STACK)) {
            Logger.f365497g.i("RMonitor_lag", "start Lag Monitor fail for can't collect.");
            this.isStart = false;
            notifyStartResult(1, "can not collect");
            return;
        }
        if (this.isStart) {
            return;
        }
        synchronized (this) {
            if (!this.isStart && (d16 = d()) != null) {
                d16.k();
                this.lagObserver = d16;
                this.isStart = true;
            }
            Unit unit = Unit.INSTANCE;
        }
        if (this.isStart) {
            notifyStartResult(0, null);
        } else {
            notifyStartResult(2, "Lag Observer is null");
        }
        GcInfoStatHelper.getInstance().startGCStat(BuglyMonitorName.LOOPER_STACK);
        resume();
        Logger.f365497g.i("RMonitor_lag", "start Lag Monitors.");
    }

    @Override // com.tencent.rmonitor.base.plugin.monitor.QAPMMonitorPlugin
    public void stop() {
        if (!this.isStart) {
            return;
        }
        pause();
        synchronized (this) {
            if (this.isStart) {
                LagObserver lagObserver = this.lagObserver;
                if (lagObserver != null) {
                    lagObserver.l();
                }
                this.lagObserver = null;
                this.isStart = false;
            }
            Unit unit = Unit.INSTANCE;
        }
        notifyStopResult(0, null);
        Logger.f365497g.i("RMonitor_lag", "stop Lag Monitor.");
    }
}
