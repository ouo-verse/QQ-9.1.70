package com.tencent.rmonitor.fd;

import android.text.TextUtils;
import com.tencent.bugly.common.thread.ThreadManager;
import com.tencent.bugly.library.BuglyMonitorName;
import com.tencent.rmonitor.base.plugin.listener.IBaseListener;
import com.tencent.rmonitor.base.plugin.monitor.PluginController;
import com.tencent.rmonitor.fd.analysis.data.FdLeakIssueResult;
import com.tencent.rmonitor.fd.cluser.FdCluster;
import com.tencent.rmonitor.fd.dump.FdLeakDumpResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes25.dex */
public class FdLeakTrigger {

    /* renamed from: b, reason: collision with root package name */
    private final z04.a f365558b;

    /* renamed from: c, reason: collision with root package name */
    private b f365559c;

    /* renamed from: a, reason: collision with root package name */
    private final t04.b f365557a = new t04.b();

    /* renamed from: d, reason: collision with root package name */
    private int f365560d = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public class a extends t04.a {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f365564b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f365565c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(t04.c cVar, int i3, int i16) {
            super(cVar);
            this.f365564b = i3;
            this.f365565c = i16;
        }

        @Override // t04.a, t04.c
        public void h(FdLeakIssueResult fdLeakIssueResult) {
            c e16 = FdLeakTrigger.this.e();
            ArrayList<String> arrayList = new ArrayList<>();
            if (e16 != null) {
                arrayList = e16.f(this.f365564b, this.f365565c);
            }
            String g16 = w04.a.g(fdLeakIssueResult.getFdDumpList(), arrayList);
            if (TextUtils.isEmpty(g16)) {
                fdLeakIssueResult.setErrorCode(4);
                a14.c.b("RMonitor_FdLeak_Trigger", "zip dump files failed when analyzed");
            } else {
                FdLeakTrigger.this.f365558b.a(fdLeakIssueResult, g16);
            }
            super.h(fdLeakIssueResult);
        }
    }

    public FdLeakTrigger(z04.a aVar) {
        this.f365558b = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i3, int i16, FdLeakDumpResult fdLeakDumpResult) {
        this.f365557a.c(i3, i16, fdLeakDumpResult, new a(e(), i3, i16));
    }

    private boolean d() {
        w04.a.a();
        final FdLeakDumpResult c16 = w04.a.c(1, e());
        g(c16);
        if (!c16.isSuccess()) {
            return false;
        }
        final v04.a c17 = FdCluster.c((Map) c16.getData());
        a14.c.d("RMonitor_FdLeak_Trigger", "top fd: " + c17);
        if (c17 == null) {
            return false;
        }
        if (!PluginController.g(BuglyMonitorName.FD_ANALYZE, com.tencent.rmonitor.fd.a.d().eventSampleRatio)) {
            a14.c.d("RMonitor_FdLeak_Trigger", "do fd analyze, but not sampled.");
            return false;
        }
        final int i3 = y04.c.i();
        ThreadManager.runInDumpThread(new Runnable() { // from class: com.tencent.rmonitor.fd.FdLeakTrigger.1
            @Override // java.lang.Runnable
            public void run() {
                FdLeakTrigger.this.c(c17.k(), i3, c16);
                if (com.tencent.rmonitor.fd.a.a()) {
                    FdLeakMonitor.nEnableLeakDetectThisTime(true);
                }
            }
        }, 0L);
        return true;
    }

    private void g(FdLeakDumpResult fdLeakDumpResult) {
        if (fdLeakDumpResult.getErrorCode() == 11) {
            this.f365560d++;
        } else {
            this.f365560d = 0;
        }
    }

    public c e() {
        if (this.f365559c == null) {
            ArrayList arrayList = new ArrayList();
            Iterator<IBaseListener> it = i04.a.fdLeakListener.c().iterator();
            while (it.hasNext()) {
                arrayList.add((c) it.next());
            }
            this.f365559c = new b(arrayList);
        }
        return this.f365559c;
    }

    public boolean f() {
        if (this.f365560d >= 3) {
            a14.c.a("RMonitor_FdLeak_Trigger", "fd leak detected, but fd dump empty to many times.");
            return false;
        }
        if (!PluginController.f365404b.b(BuglyMonitorName.FD_ANALYZE)) {
            a14.c.a("RMonitor_FdLeak_Trigger", "fd leak detected, but don't collect.");
            return false;
        }
        return d();
    }
}
