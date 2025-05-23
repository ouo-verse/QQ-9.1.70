package com.tencent.mobileqq.webview.swift.utils;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.os.SystemClock;
import com.tencent.mobileqq.DebugTrace;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics;
import com.tencent.mobileqq.webview.swift.injector.aa;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.TbsCoreSettings;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.WebAccelerator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes20.dex */
public class m {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final AtomicInteger f314762a;

    /* renamed from: b, reason: collision with root package name */
    private static final CopyOnWriteArrayList<a> f314763b;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface a {
        void a();
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(49500);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f314762a = new AtomicInteger(0);
            f314763b = new CopyOnWriteArrayList<>();
        }
    }

    public m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean d() {
        final boolean z16;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        DebugTrace.Step step = DebugTrace.Step.step_initx5;
        DebugTrace.g(step);
        i();
        if (MobileQQ.sProcessId == 1) {
            z16 = ((com.tencent.mobileqq.webview.swift.injector.c) aa.k(com.tencent.mobileqq.webview.swift.injector.c.class)).v();
        } else {
            z16 = true;
        }
        final int tbsVersionForCrash = QbSdk.getTbsVersionForCrash(MobileQQ.sMobileQQ.getApplicationContext());
        if (z16 && tbsVersionForCrash > 0 && tbsVersionForCrash <= 46521 && ((com.tencent.mobileqq.webview.swift.injector.c) aa.k(com.tencent.mobileqq.webview.swift.injector.c.class)).isSwitchOn("wv_x5core_46521_fallback_syscore", true)) {
            QLog.d("WebLog_TbsAccelerator", 1, "doInit tbsCoreVer: " + tbsVersionForCrash + " should fallback sysCore");
            z16 = false;
        }
        p.a(new Function0() { // from class: com.tencent.mobileqq.webview.swift.utils.j
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit l3;
                l3 = m.l(z16, tbsVersionForCrash);
                return l3;
            }
        });
        AtomicInteger atomicInteger = f314762a;
        atomicInteger.set(2);
        synchronized (atomicInteger) {
            atomicInteger.notifyAll();
        }
        n();
        if ((!((com.tencent.mobileqq.inject.b) aa.k(com.tencent.mobileqq.inject.b.class)).isPublicVersion() || ((com.tencent.mobileqq.inject.b) aa.k(com.tencent.mobileqq.inject.b.class)).isGrayVersion()) && MobileQQ.sProcessId == 1) {
            ((com.tencent.mobileqq.webview.swift.injector.k) aa.k(com.tencent.mobileqq.webview.swift.injector.k.class)).d();
        }
        if (!z16) {
            SwiftBrowserStatistics.O(0, tbsVersionForCrash);
        }
        long elapsedRealtime2 = SystemClock.elapsedRealtime();
        SwiftBrowserStatistics.X0 = elapsedRealtime2;
        long j3 = elapsedRealtime2 - elapsedRealtime;
        SwiftBrowserStatistics.W0 = j3;
        QLog.d("WebLog_TbsAccelerator", 1, String.format("doInit totalCost=%d, isMainThread=%b, useX5Core=%b", Long.valueOf(j3), Boolean.valueOf(k()), Boolean.valueOf(z16)));
        DebugTrace.e(step);
        return true;
    }

    public static boolean e() {
        if (f314762a.get() == 2) {
            return true;
        }
        return false;
    }

    public static boolean f() {
        if (f314762a.get() != 0) {
            return true;
        }
        return false;
    }

    public static boolean g() {
        boolean z16;
        if (QLog.isColorLevel()) {
            QLog.i("WebLog_TbsAccelerator", 2, "init state=" + f314762a.get());
        }
        long currentTimeMillis = System.currentTimeMillis();
        AtomicInteger atomicInteger = f314762a;
        if (atomicInteger.compareAndSet(0, 1)) {
            z16 = d();
        } else {
            z16 = false;
        }
        if (atomicInteger.get() != 2) {
            synchronized (atomicInteger) {
                if (atomicInteger.get() != 2) {
                    try {
                        LockMethodProxy.wait(atomicInteger);
                    } catch (InterruptedException e16) {
                        e16.printStackTrace();
                    }
                }
            }
            QLog.i("WebLog_TbsAccelerator", 1, String.format("waitCost=%d, isMain=%b", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Boolean.valueOf(k())));
        }
        return z16;
    }

    public static void h(a aVar) {
        if (QLog.isColorLevel()) {
            QLog.i("WebLog_TbsAccelerator", 2, "initAsync state=" + f314762a.get());
        }
        if (aVar != null) {
            if (f314762a.get() == 2) {
                aVar.a();
                return;
            }
            f314763b.add(aVar);
        }
        if (f314762a.compareAndSet(0, 1)) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.webview.swift.utils.l
                @Override // java.lang.Runnable
                public final void run() {
                    m.d();
                }
            }, 16, null, false);
        }
    }

    private static void i() {
        HashMap hashMap = new HashMap();
        Boolean bool = Boolean.TRUE;
        hashMap.put(TbsCoreSettings.TBS_SETTINGS_USE_SPEEDY_CLASSLOADER, bool);
        hashMap.put(TbsCoreSettings.TBS_SETTINGS_USE_DEXLOADER_SERVICE, Boolean.FALSE);
        hashMap.put(TbsCoreSettings.TBS_SETTINGS_USE_PRIVATE_CLASSLOADER, bool);
        QbSdk.initTbsSettings(hashMap);
    }

    public static void j() {
        String str;
        Context applicationContext = MobileQQ.sMobileQQ.getApplicationContext();
        Bundle bundle = new Bundle();
        String qimei36 = ((com.tencent.mobileqq.webview.swift.injector.d) aa.k(com.tencent.mobileqq.webview.swift.injector.d.class)).getQimei36();
        if (qimei36 == null) {
            str = "";
        } else {
            str = qimei36;
        }
        bundle.putString("qimei36", str);
        String model = ((com.tencent.mobileqq.webview.swift.injector.d) aa.k(com.tencent.mobileqq.webview.swift.injector.d.class)).getModel();
        if (model == null) {
            model = "";
        }
        bundle.putString("model", model);
        if (qimei36 == null) {
            qimei36 = "";
        }
        bundle.putString(SemanticAttributes.DbCassandraConsistencyLevelValues.SERIAL, qimei36);
        QbSdk.setUserID(applicationContext, bundle);
    }

    private static boolean k() {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit l(boolean z16, int i3) {
        int i16;
        Context applicationContext = MobileQQ.sMobileQQ.getApplicationContext();
        if (z16) {
            i16 = 2;
        } else {
            i16 = 1;
        }
        WebAccelerator.initTbsEnvironment(applicationContext, i16);
        if (!z16) {
            QbSdk.forceSysWebView();
            com.tencent.mobileqq.webview.util.t.j().d("force_syscore_flag", Boolean.TRUE);
            return null;
        }
        if (((Boolean) com.tencent.mobileqq.webview.util.t.j().b("force_syscore_flag", Boolean.FALSE)).booleanValue()) {
            QbSdk.unForceSysWebView();
            com.tencent.mobileqq.webview.util.t.j().l("force_syscore_flag");
            QLog.d("WebLog_TbsAccelerator", 1, "doInit tbsCoreVer: " + i3 + " should restore x5Core");
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void m() {
        CopyOnWriteArrayList<a> copyOnWriteArrayList = f314763b;
        ArrayList arrayList = new ArrayList(copyOnWriteArrayList);
        copyOnWriteArrayList.clear();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((a) it.next()).a();
        }
    }

    private static void n() {
        if (f314763b.size() > 0) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.webview.swift.utils.k
                @Override // java.lang.Runnable
                public final void run() {
                    m.m();
                }
            });
        }
    }
}
