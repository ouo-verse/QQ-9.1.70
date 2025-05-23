package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.thread.monitor.plugin.proxy.BaseScheduledThreadPoolExecutor;
import com.xiaomi.push.gf;
import com.xiaomi.push.gj;
import com.xiaomi.push.he;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes28.dex */
public class MiTinyDataClient {

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class a {

        /* renamed from: f, reason: collision with root package name */
        private static volatile a f387990f;

        /* renamed from: a, reason: collision with root package name */
        private Context f387991a;

        /* renamed from: b, reason: collision with root package name */
        private String f387992b;

        /* renamed from: c, reason: collision with root package name */
        private Boolean f387993c;

        /* renamed from: d, reason: collision with root package name */
        private C10088a f387994d = new C10088a();

        /* renamed from: e, reason: collision with root package name */
        private final ArrayList<gj> f387995e = new ArrayList<>();

        /* compiled from: P */
        /* renamed from: com.xiaomi.mipush.sdk.MiTinyDataClient$a$a, reason: collision with other inner class name */
        /* loaded from: classes28.dex */
        public class C10088a {

            /* renamed from: c, reason: collision with root package name */
            private ScheduledFuture<?> f387998c;

            /* renamed from: a, reason: collision with root package name */
            private ScheduledThreadPoolExecutor f387996a = new BaseScheduledThreadPoolExecutor(1);

            /* renamed from: b, reason: collision with root package name */
            public final ArrayList<gj> f387997b = new ArrayList<>();

            /* renamed from: d, reason: collision with root package name */
            private final Runnable f387999d = new Runnable() { // from class: com.xiaomi.mipush.sdk.MiTinyDataClient.a.a.2
                @Override // java.lang.Runnable
                public void run() {
                    if (C10088a.this.f387997b.size() != 0) {
                        C10088a.this.f();
                    } else if (C10088a.this.f387998c != null) {
                        C10088a.this.f387998c.cancel(false);
                        C10088a.this.f387998c = null;
                    }
                }
            };

            public C10088a() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void c() {
                if (this.f387998c == null) {
                    this.f387998c = this.f387996a.scheduleAtFixedRate(this.f387999d, 1000L, 1000L, TimeUnit.MILLISECONDS);
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void f() {
                gj remove = this.f387997b.remove(0);
                for (he heVar : com.xiaomi.push.service.af.c(Arrays.asList(remove), a.this.f387991a.getPackageName(), s.c(a.this.f387991a).d(), 30720)) {
                    jz4.c.z("MiTinyDataClient Send item by PushServiceClient.sendMessage(XmActionNotification)." + remove.d());
                    ag.h(a.this.f387991a).y(heVar, gf.Notification, true, null);
                }
            }

            public void e(final gj gjVar) {
                this.f387996a.execute(new Runnable() { // from class: com.xiaomi.mipush.sdk.MiTinyDataClient.a.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        C10088a.this.f387997b.add(gjVar);
                        C10088a.this.c();
                    }
                });
            }
        }

        public static a b() {
            if (f387990f == null) {
                synchronized (a.class) {
                    if (f387990f == null) {
                        f387990f = new a();
                    }
                }
            }
            return f387990f;
        }

        private void d(gj gjVar) {
            synchronized (this.f387995e) {
                if (!this.f387995e.contains(gjVar)) {
                    this.f387995e.add(gjVar);
                    if (this.f387995e.size() > 100) {
                        this.f387995e.remove(0);
                    }
                }
            }
        }

        private boolean f(Context context) {
            if (!ag.h(context).J()) {
                return true;
            }
            try {
                PackageInfo packageInfo = InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), "com.xiaomi.xmsf", 4);
                if (packageInfo == null) {
                    return false;
                }
                if (packageInfo.versionCode >= 108) {
                    return true;
                }
                return false;
            } catch (Exception unused) {
                return false;
            }
        }

        private boolean i(Context context) {
            if (s.c(context).d() == null && !f(this.f387991a)) {
                return true;
            }
            return false;
        }

        private boolean j(gj gjVar) {
            if (com.xiaomi.push.service.af.e(gjVar, false)) {
                return false;
            }
            if (this.f387993c.booleanValue()) {
                jz4.c.z("MiTinyDataClient Send item by PushServiceClient.sendTinyData(ClientUploadDataItem)." + gjVar.d());
                ag.h(this.f387991a).t(gjVar);
                return true;
            }
            this.f387994d.e(gjVar);
            return true;
        }

        public void c(Context context) {
            if (context == null) {
                jz4.c.m("context is null, MiTinyDataClientImp.init() failed.");
                return;
            }
            this.f387991a = context;
            this.f387993c = Boolean.valueOf(f(context));
            h("com.xiaomi.xmpushsdk.tinydataPending.init");
        }

        public boolean e() {
            if (this.f387991a != null) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Code restructure failed: missing block: B:45:0x00a4, code lost:
        
            jz4.c.z("MiTinyDataClient Pending " + r6.b() + " reason is com.xiaomi.xmpushsdk.tinydataPending.channel");
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public synchronized boolean g(gj gjVar) {
            boolean z16;
            boolean z17;
            boolean z18 = false;
            if (gjVar == null) {
                return false;
            }
            if (com.xiaomi.push.service.af.e(gjVar, true)) {
                return false;
            }
            if (TextUtils.isEmpty(gjVar.m309a()) && TextUtils.isEmpty(this.f387992b)) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!e()) {
                z17 = true;
            } else {
                z17 = false;
            }
            Context context = this.f387991a;
            if (context == null || i(context)) {
                z18 = true;
            }
            if (!z17 && !z16 && !z18) {
                jz4.c.z("MiTinyDataClient Send item immediately." + gjVar.d());
                if (TextUtils.isEmpty(gjVar.d())) {
                    gjVar.f(com.xiaomi.push.service.m.a());
                }
                if (TextUtils.isEmpty(gjVar.m309a())) {
                    gjVar.a(this.f387992b);
                }
                if (TextUtils.isEmpty(gjVar.c())) {
                    gjVar.e(this.f387991a.getPackageName());
                }
                if (gjVar.a() <= 0) {
                    gjVar.b(System.currentTimeMillis());
                }
                return j(gjVar);
            }
            if (z17) {
                jz4.c.z("MiTinyDataClient Pending " + gjVar.b() + " reason is com.xiaomi.xmpushsdk.tinydataPending.init");
            } else if (z18) {
                jz4.c.z("MiTinyDataClient Pending " + gjVar.b() + " reason is com.xiaomi.xmpushsdk.tinydataPending.appId");
            }
            d(gjVar);
            return true;
        }

        public void h(String str) {
            jz4.c.z("MiTinyDataClient.processPendingList(" + str + ")");
            ArrayList arrayList = new ArrayList();
            synchronized (this.f387995e) {
                arrayList.addAll(this.f387995e);
                this.f387995e.clear();
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                g((gj) it.next());
            }
        }
    }

    public static boolean a(Context context, gj gjVar) {
        jz4.c.z("MiTinyDataClient.upload " + gjVar.d());
        if (!a.b().e()) {
            a.b().c(context);
        }
        return a.b().g(gjVar);
    }
}
