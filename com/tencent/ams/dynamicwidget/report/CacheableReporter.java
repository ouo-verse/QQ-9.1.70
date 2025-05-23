package com.tencent.ams.dynamicwidget.report;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.ams.dynamicwidget.utils.b;
import com.tencent.ams.dynamicwidget.utils.d;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: P */
/* loaded from: classes3.dex */
public class CacheableReporter {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name */
    protected static ScheduledExecutorService f70207c;

    /* renamed from: a, reason: collision with root package name */
    protected Context f70208a;

    /* renamed from: b, reason: collision with root package name */
    private Map<String, SharedPreferences> f70209b;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    private class AdCoreEventReportWorker implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private a f70210d;
        final /* synthetic */ CacheableReporter this$0;

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                b.f70218a.a("CacheableReporter", "AdCoreEventReportWorker run.");
                this.this$0.b(this.f70210d);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    private class AdCoreRecoverReportWorker implements Runnable {
        static IPatchRedirector $redirector_;
        final /* synthetic */ CacheableReporter this$0;

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                b.f70218a.a("CacheableReporter", "AdCoreRecoverReportWorker run.");
                this.this$0.c();
            }
        }
    }

    private synchronized void a(a aVar, String str) {
        b bVar = b.f70218a;
        bVar.a("CacheableReporter", "addEventToPingEventSp, pingEvent: " + aVar);
        if (aVar == null) {
            return;
        }
        SharedPreferences f16 = f(str);
        if (f16 == null) {
            return;
        }
        String b16 = aVar.b();
        if (!f16.contains(b16)) {
            SharedPreferences.Editor edit = f16.edit();
            if (edit != null) {
                edit.putInt(b16, aVar.f70213c).apply();
            }
            bVar.a("CacheableReporter", "addEventToPingEventSp, success, spName: " + str + ", content: " + b16 + ", failedCount: " + aVar.f70213c);
        } else {
            bVar.a("CacheableReporter", "addEventToPingEventSp, failed, already contains.");
        }
    }

    private synchronized void g(String str) {
        Context context = this.f70208a;
        if (context != null) {
            this.f70209b.put(str, context.getSharedPreferences(str, 0));
        }
    }

    protected synchronized void b(a aVar) {
        boolean a16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) aVar);
            return;
        }
        b bVar = b.f70218a;
        bVar.a("CacheableReporter", "doPingEventReport, AdCoreReportEvent: " + aVar);
        if (aVar == null) {
            return;
        }
        if (!d.f70220a.d(this.f70208a)) {
            aVar.f70213c++;
            a(aVar, "CACHE_FAILED_PING_EVENT_SP");
            return;
        }
        if (!TextUtils.isEmpty(aVar.f70212b)) {
            a16 = com.tencent.ams.dynamicwidget.report.utils.a.b(aVar.f70211a, "POST", aVar.f70212b, aVar.f70214d);
        } else {
            a16 = com.tencent.ams.dynamicwidget.report.utils.a.a(aVar.f70211a);
        }
        bVar.a("CacheableReporter", "doPingEventReport, isSuc: " + a16);
        if (!a16) {
            int i3 = aVar.f70213c + 1;
            aVar.f70213c = i3;
            if (i3 < e()) {
                a(aVar, "CACHE_FAILED_PING_EVENT_SP");
            }
        }
    }

    protected synchronized void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        boolean d16 = d.f70220a.d(this.f70208a);
        b.f70218a.a("CacheableReporter", "doEventReportFromSp, isNetworkAvaiable: " + d16);
        if (!d16) {
            return;
        }
        Map<String, Integer> d17 = d("CACHE_FAILED_PING_EVENT_SP");
        if (d17 == null) {
            return;
        }
        for (Map.Entry<String, Integer> entry : d17.entrySet()) {
            String key = entry.getKey();
            b.f70218a.a("CacheableReporter", "doEventReportFromSp: " + key);
            a a16 = a.a(key);
            if (a16 != null) {
                a16.f70213c = entry.getValue().intValue();
                b(a16);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected synchronized Map<String, Integer> d(String str) {
        Map map;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Map) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        }
        SharedPreferences f16 = f(str);
        if (f16 == null) {
            return null;
        }
        try {
            map = f16.getAll();
        } catch (Throwable unused) {
            map = null;
        }
        if (d.f70220a.c(map)) {
            return null;
        }
        SharedPreferences.Editor edit = f16.edit();
        edit.clear();
        edit.apply();
        return map;
    }

    protected int e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            return 5;
        }
        return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
    }

    protected synchronized SharedPreferences f(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (SharedPreferences) iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
        }
        Map<String, SharedPreferences> map = this.f70209b;
        if (map == null) {
            this.f70209b = new HashMap();
            g(str);
        } else if (!map.containsKey(str)) {
            g(str);
        }
        return this.f70209b.get(str);
    }
}
