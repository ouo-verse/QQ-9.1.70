package com.tencent.qqperf.crashdefend;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Looper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.core.net.utils.MsfCmdConfig;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.crashdefend.report.StartStepCrashReportHelper;
import com.tencent.qqperf.monitor.crash.safemode.SafeModeUtil;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.tencent.trpcprotocol.group_pro.configdistribution.config_distribution_svr.configDistributionSvr;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes25.dex */
public class HotFixOnStartStepHelper {

    /* renamed from: b, reason: collision with root package name */
    private BroadcastReceiver f363080b;

    /* renamed from: a, reason: collision with root package name */
    private ConcurrentHashMap<Integer, f> f363079a = new ConcurrentHashMap<>();

    /* renamed from: c, reason: collision with root package name */
    private volatile HotFixTimeOutRunner f363081c = new HotFixTimeOutRunner();

    /* renamed from: d, reason: collision with root package name */
    private volatile Runnable f363082d = null;

    /* renamed from: e, reason: collision with root package name */
    private AtomicBoolean f363083e = new AtomicBoolean(false);

    /* renamed from: f, reason: collision with root package name */
    private AtomicBoolean f363084f = new AtomicBoolean(false);

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public class HotFixTimeOutRunner implements Runnable {
        HotFixTimeOutRunner() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (CrashDefendManager.i().d()) {
                wy3.b.a("HotFixOnStartStepHelper", "HotFixTimeOutRunner existQQ");
                HotFixOnStartStepHelper.this.g(3);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes25.dex */
    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            action.hashCode();
            if (!action.equals(com.tencent.mobileqq.msf.core.net.utils.b.f249493k)) {
                QLog.e("HotFixOnStartStepHelper", 1, "hotFixBroadcastReceiver receive a error action:" + action);
                return;
            }
            int intExtra = intent.getIntExtra(com.tencent.mobileqq.msf.core.net.utils.b.f249494l, -1);
            boolean booleanExtra = intent.getBooleanExtra(com.tencent.mobileqq.msf.core.net.utils.b.f249495m, false);
            int intExtra2 = intent.getIntExtra(com.tencent.mobileqq.msf.core.net.utils.b.f249496n, -1);
            wy3.b.a("HotFixOnStartStepHelper", "hotFixBroadcastReceiver receive HOT_FIX_STEP_NOTIFICATION_ACTION: " + intExtra + "|" + intExtra2 + "|" + booleanExtra);
            if (intExtra >= 0) {
                if (intExtra2 == 0) {
                    HotFixOnStartStepHelper.this.m(intExtra, booleanExtra);
                    HotFixOnStartStepHelper.this.l(intExtra, booleanExtra);
                } else if (intExtra2 == 1) {
                    HotFixOnStartStepHelper.this.l(intExtra, booleanExtra);
                } else if (intExtra2 == 2) {
                    HotFixOnStartStepHelper.this.m(intExtra, booleanExtra);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public HotFixOnStartStepHelper() {
        this.f363079a.put(1, new f());
        this.f363079a.put(2, new f());
    }

    private void d() {
        if (this.f363083e.compareAndSet(false, true)) {
            wy3.b.a("HotFixOnStartStepHelper", "beginHotFixTimeOutRunner");
            this.f363082d = ThreadManagerV2.executeDelay(this.f363081c, 16, null, false, 10000L);
        }
    }

    private void f() {
        boolean z16;
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f363079a.values());
        Iterator it = arrayList.iterator();
        boolean z17 = true;
        while (it.hasNext()) {
            if (((f) it.next()).c() == 1000) {
                z16 = true;
            } else {
                z16 = false;
            }
            z17 &= z16;
        }
        wy3.b.a("HotFixOnStartStepHelper", "doOnFixEnd invoke isAllEnd is " + z17);
        if (z17) {
            q();
            boolean d16 = CrashDefendManager.i().d();
            boolean c16 = CrashDefendManager.i().c();
            wy3.b.a("HotFixOnStartStepHelper", "doOnFixEnd isDefenderEnable is " + c16 + "| ishasCrash is " + d16);
            if (d16 && c16) {
                g(1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void i() {
        configDistributionSvr.RespConfig a16 = com.tencent.qqperf.crashdefend.a.a();
        if (a16 != null) {
            try {
            } catch (Throwable th5) {
                QLog.e("HotFixOnStartStepHelper", 1, th5, new Object[0]);
                d.e().h(1, false);
            }
            if (a16.has() && a16.contents.has() && a16.contents.get(0).content.has()) {
                String str = new String(a16.contents.get(0).content.get().toByteArray());
                QLog.d("HotFixOnStartStepHelper", 1, "execute cmd: " + str);
                MsfCmdConfig.executeFreesiaSafeModeCmd(a16.new_version.get(), str);
                SafeModeUtil.c();
            }
        }
        d.e().h(1, false);
        SafeModeUtil.c();
    }

    private void j(int i3) {
        f fVar = this.f363079a.get(Integer.valueOf(i3));
        if (fVar != null) {
            fVar.d();
            f();
        }
    }

    private void k(int i3, int i16) {
        f fVar = this.f363079a.get(Integer.valueOf(i3));
        if (fVar != null) {
            fVar.f(i16);
            if (i16 == 1000) {
                fVar.e();
                StartStepCrashReportHelper.c(i3);
                f();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        String cls;
        BaseApplicationImpl application = BaseApplicationImpl.getApplication();
        if (application == null) {
            wy3.b.a("HotFixOnStartStepHelper", "pushHotFixRequest baseApplication is null!");
            return;
        }
        application.doInit(true);
        AppRuntime runtime = application.getRuntime();
        if (runtime instanceof QQAppInterface) {
            String currentAccountUin = ((QQAppInterface) runtime).getCurrentAccountUin();
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqperf.crashdefend.e
                @Override // java.lang.Runnable
                public final void run() {
                    HotFixOnStartStepHelper.i();
                }
            }, 128, null, false);
            if (com.tencent.mobileqq.rfix.a.f()) {
                com.tencent.mobileqq.rfix.a.e().requestConfig();
            } else {
                QLog.e("HotFixOnStartStepHelper", 1, "crash in a early stage, can't fix by hot patch");
            }
            d();
            wy3.b.a("HotFixOnStartStepHelper", "pushHotFixRequest curUin is :" + currentAccountUin);
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("pushHotFixRequest jump appRuntime is :");
        if (runtime == null) {
            cls = "null";
        } else {
            cls = runtime.getClass().toString();
        }
        sb5.append(cls);
        wy3.b.a("HotFixOnStartStepHelper", sb5.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(int i3) {
        try {
            StartStepCrashReportHelper.b(i3);
        } finally {
            try {
            } finally {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean e() {
        ArrayList<f> arrayList = new ArrayList();
        arrayList.addAll(this.f363079a.values());
        for (f fVar : arrayList) {
            boolean a16 = fVar.a();
            wy3.b.a("HotFixOnStartStepHelper", "checkHasAvailableFix check is " + fVar.c() + "|" + fVar.b() + "|" + a16);
            if (a16) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(final int i3) {
        if (this.f363084f.compareAndSet(false, true)) {
            wy3.b.b("HotFixOnStartStepHelper", "ready to exist", new Throwable());
            if (Looper.myLooper() == Looper.getMainLooper()) {
                new BaseThread(new Runnable() { // from class: com.tencent.qqperf.crashdefend.HotFixOnStartStepHelper.2
                    @Override // java.lang.Runnable
                    public void run() {
                        HotFixOnStartStepHelper.this.p(i3);
                    }
                }, "CrashDefendReport").start();
            } else {
                p(i3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h(Context context) {
        if (MobileQQ.sProcessId == 1 && this.f363080b == null) {
            this.f363080b = new a();
            if (context != null) {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction(com.tencent.mobileqq.msf.core.net.utils.b.f249493k);
                context.registerReceiver(this.f363080b, intentFilter);
                wy3.b.a("HotFixOnStartStepHelper", "hotFixBroadcastReceiver register success");
                return;
            }
            wy3.b.a("HotFixOnStartStepHelper", "hotFixBroadcastReceiver register failed, context is null");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void l(int i3, boolean z16) {
        if (!CrashDefendManager.i().c()) {
            return;
        }
        wy3.b.a("HotFixOnStartStepHelper", "onPatchFixCallBack invoke info is " + i3 + "|" + z16);
        if (!z16) {
            j(1);
        } else {
            k(1, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void m(int i3, boolean z16) {
        if (!CrashDefendManager.i().c()) {
            return;
        }
        wy3.b.a("HotFixOnStartStepHelper", "onSafeModeConfigFixCallBack invoke info is " + i3 + "|" + z16);
        if (!z16) {
            j(2);
        } else {
            k(2, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void n(boolean z16) {
        if (MobileQQ.sProcessId == 1) {
            if (Looper.getMainLooper() == Looper.myLooper()) {
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqperf.crashdefend.HotFixOnStartStepHelper.3
                    @Override // java.lang.Runnable
                    public void run() {
                        wy3.b.a("HotFixOnStartStepHelper", "pushHotFixRequest at ThreadManager.excute processID:" + MobileQQ.sProcessId);
                        HotFixOnStartStepHelper.this.o();
                    }
                }, 240, null, false);
                return;
            }
            wy3.b.a("HotFixOnStartStepHelper", "pushHotFixRequest at not mainlooper processID:" + MobileQQ.sProcessId);
            o();
            return;
        }
        wy3.b.a("HotFixOnStartStepHelper", "pushHotFixRequest is jump processID:" + MobileQQ.sProcessId);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void q() {
        if (this.f363083e.compareAndSet(true, false) && this.f363082d != null) {
            wy3.b.a("HotFixOnStartStepHelper", "removeHotFixTimeOutRunner");
            ThreadManagerV2.removeJob(this.f363082d, 16);
            this.f363082d = null;
        }
    }
}
