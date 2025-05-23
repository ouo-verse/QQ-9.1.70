package com.tencent.mobileqq.qqbattery.feature;

import android.os.IBinder;
import android.os.SystemClock;
import android.os.WorkSource;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqbattery.feature.e;
import g.b;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes16.dex */
public class WakeLockMonitorFeature extends com.tencent.mobileqq.qqbattery.feature.a {
    static IPatchRedirector $redirector_;
    public final a.a C;

    /* renamed from: e, reason: collision with root package name */
    public final Map<IBinder, b> f262295e;

    /* renamed from: f, reason: collision with root package name */
    public final d f262296f;

    /* renamed from: h, reason: collision with root package name */
    public b.d f262297h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f262298i;

    /* renamed from: m, reason: collision with root package name */
    public long f262299m;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class a implements b.d {
        static IPatchRedirector $redirector_;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) WakeLockMonitorFeature.this);
            }
        }

        /* JADX WARN: Type inference failed for: r2v2, types: [java.util.Map<android.os.IBinder, com.tencent.mobileqq.qqbattery.feature.WakeLockMonitorFeature$b>, java.util.concurrent.ConcurrentHashMap] */
        /* JADX WARN: Type inference failed for: r5v3, types: [java.util.Map<android.os.IBinder, com.tencent.mobileqq.qqbattery.feature.WakeLockMonitorFeature$b>, java.util.concurrent.ConcurrentHashMap] */
        @Override // g.b.d
        public void a(IBinder iBinder, int i3, String str, String str2, WorkSource workSource, String str3) {
            String str4;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, iBinder, Integer.valueOf(i3), str, str2, workSource, str3);
                return;
            }
            if (WakeLockMonitorFeature.this.f262298i) {
                str4 = i.a.a();
            } else {
                str4 = "";
            }
            com.tencent.mobileqq.qqbattery.utils.a.c("QQBattery_WakeLockMonitorFeature", "[onAcquireWakeLock] token=%s flags=%s tag=%s historyTag=%s packageName=%s workSource=%s stack=%s", String.valueOf(iBinder), Integer.valueOf(i3), str, str3, str2, workSource, str4);
            b bVar = (b) WakeLockMonitorFeature.this.f262295e.get(iBinder);
            if (bVar != null) {
                bVar.f262307f = SystemClock.uptimeMillis();
            }
            b bVar2 = new b(str, i3, str2, str4);
            WakeLockMonitorFeature.this.f262295e.put(iBinder, bVar2);
            WakeLockMonitorFeature.this.f262296f.e();
            if (!WakeLockMonitorFeature.this.f262318d.j().a()) {
                com.tencent.mobileqq.qqbattery.utils.a.b("QQBattery_WakeLockMonitorFeature", "acquireWakeLockOnBg", new Object[0]);
                WakeLockMonitorFeature.this.f262318d.g().e(bVar2);
            }
        }

        /* JADX WARN: Type inference failed for: r6v4, types: [java.util.Map<android.os.IBinder, com.tencent.mobileqq.qqbattery.feature.WakeLockMonitorFeature$b>, java.util.concurrent.ConcurrentHashMap] */
        @Override // g.b.d
        public void onReleaseWakeLock(IBinder iBinder, int i3) {
            b bVar;
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) iBinder, i3);
                return;
            }
            com.tencent.mobileqq.qqbattery.utils.a.c("QQBattery_WakeLockMonitorFeature", "[onReleaseWakeLock] token=%s flags=%s", iBinder, Integer.valueOf(i3));
            Iterator it = WakeLockMonitorFeature.this.f262295e.entrySet().iterator();
            while (true) {
                if (it.hasNext()) {
                    Map.Entry entry = (Map.Entry) it.next();
                    if (entry.getKey() == iBinder) {
                        bVar = (b) entry.getValue();
                        it.remove();
                        break;
                    }
                } else {
                    bVar = null;
                    break;
                }
            }
            if (bVar != null) {
                bVar.f262307f = SystemClock.uptimeMillis();
                WakeLockMonitorFeature.this.f262296f.a(bVar);
                WakeLockMonitorFeature.this.f262296f.f();
                String str2 = bVar.f262303b;
                if (WakeLockMonitorFeature.this.f262298i) {
                    str = i.a.a();
                } else {
                    str = "";
                }
                com.tencent.mobileqq.qqbattery.utils.a.c("QQBattery_WakeLockMonitorFeature", "[onReleaseWakeLock] tag = " + str2 + ", stack = " + str, new Object[0]);
                return;
            }
            com.tencent.mobileqq.qqbattery.utils.a.f("QQBattery_WakeLockMonitorFeature", "missing tracking, token = " + iBinder, new Object[0]);
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public final int f262302a;

        /* renamed from: b, reason: collision with root package name */
        public final String f262303b;

        /* renamed from: c, reason: collision with root package name */
        public final String f262304c;

        /* renamed from: d, reason: collision with root package name */
        public final String f262305d;

        /* renamed from: e, reason: collision with root package name */
        public final long f262306e;

        /* renamed from: f, reason: collision with root package name */
        public long f262307f;

        public b(String str, int i3, String str2, String str3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), str2, str3);
                return;
            }
            this.f262307f = 0L;
            this.f262302a = i3;
            this.f262303b = str;
            this.f262304c = str2;
            this.f262305d = str3;
            this.f262306e = SystemClock.uptimeMillis();
        }

        public long a() {
            long uptimeMillis;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Long) iPatchRedirector.redirect((short) 3, (Object) this)).longValue();
            }
            if (b()) {
                uptimeMillis = this.f262307f;
            } else {
                uptimeMillis = SystemClock.uptimeMillis();
            }
            long j3 = uptimeMillis - this.f262306e;
            if (j3 <= 0) {
                return 0L;
            }
            return j3;
        }

        public boolean b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            if (this.f262307f >= this.f262306e) {
                return true;
            }
            return false;
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (String) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            StringBuilder a16 = g.a("WakeLockRecord{flags=");
            a16.append(this.f262302a);
            a16.append(", tag='");
            a16.append(this.f262303b);
            a16.append('\'');
            a16.append(", packageName='");
            a16.append(this.f262304c);
            a16.append('\'');
            a16.append(", stack='");
            a16.append(this.f262305d);
            a16.append('\'');
            a16.append(", timeBgn=");
            a16.append(this.f262306e);
            a16.append(", timeEnd=");
            a16.append(this.f262307f);
            a16.append('}');
            return a16.toString();
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static class c extends e.a<c> {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        public e.a.b.AbstractC8294b<Long> f262308d;

        /* renamed from: e, reason: collision with root package name */
        public e.a.b.AbstractC8294b<Integer> f262309e;

        /* renamed from: f, reason: collision with root package name */
        public e.a.b.c<e.a.b.C8292a<b>> f262310f;

        /* renamed from: g, reason: collision with root package name */
        public e.a.b.AbstractC8294b<Integer> f262311g;

        /* renamed from: h, reason: collision with root package name */
        public e.a.b.AbstractC8294b<Integer> f262312h;

        public c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            StringBuilder a16 = g.a("WakeLockSnapshot{totalWakeLockTime=");
            a16.append(this.f262308d);
            a16.append(", totalWakeLockCount=");
            a16.append(this.f262309e);
            a16.append(", totalWakeLockRecords=");
            a16.append(this.f262310f);
            a16.append(", totalAcquireCount=");
            a16.append(this.f262311g);
            a16.append(", totalReleaseCount=");
            a16.append(this.f262312h);
            a16.append('}');
            return a16.toString();
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static final class d {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public final byte[] f262313a;

        /* renamed from: b, reason: collision with root package name */
        public int f262314b;

        /* renamed from: c, reason: collision with root package name */
        public long f262315c;

        /* renamed from: d, reason: collision with root package name */
        public int f262316d;

        /* renamed from: e, reason: collision with root package name */
        public int f262317e;

        public d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.f262313a = new byte[0];
            }
        }

        public void a(b bVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) bVar);
                return;
            }
            synchronized (this.f262313a) {
                this.f262314b++;
                this.f262315c += bVar.a();
            }
        }

        public c b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (c) iPatchRedirector.redirect((short) 8, (Object) this);
            }
            c cVar = new c();
            cVar.f262308d = e.a.b.AbstractC8294b.c(Long.valueOf(c()));
            cVar.f262309e = e.a.b.AbstractC8294b.c(Integer.valueOf(d()));
            cVar.f262310f = e.a.b.c.d();
            cVar.f262311g = e.a.b.AbstractC8294b.c(Integer.valueOf(this.f262316d));
            cVar.f262312h = e.a.b.AbstractC8294b.c(Integer.valueOf(this.f262317e));
            return cVar;
        }

        public long c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Long) iPatchRedirector.redirect((short) 6, (Object) this)).longValue();
            }
            return this.f262315c;
        }

        public int d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
            }
            return this.f262314b;
        }

        public void e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            synchronized (this.f262313a) {
                this.f262316d++;
                this.f262317e++;
            }
        }

        public void f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
                return;
            }
            synchronized (this.f262313a) {
                this.f262317e--;
            }
        }
    }

    public WakeLockMonitorFeature() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f262295e = new ConcurrentHashMap();
        this.f262296f = new d();
        this.C = new a.a(new Runnable() { // from class: com.tencent.mobileqq.qqbattery.feature.WakeLockMonitorFeature.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) WakeLockMonitorFeature.this);
                }
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [java.util.Map<android.os.IBinder, com.tencent.mobileqq.qqbattery.feature.WakeLockMonitorFeature$b>, java.util.concurrent.ConcurrentHashMap] */
            /* JADX WARN: Type inference failed for: r0v5, types: [java.util.Map<android.os.IBinder, com.tencent.mobileqq.qqbattery.feature.WakeLockMonitorFeature$b>, java.util.concurrent.ConcurrentHashMap] */
            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                if (!WakeLockMonitorFeature.this.f262295e.isEmpty()) {
                    for (b bVar : WakeLockMonitorFeature.this.f262295e.values()) {
                        if (!bVar.b()) {
                            com.tencent.mobileqq.qqbattery.utils.a.b("QQBattery_WakeLockMonitorFeature", "wakeLockNotReleaseOnBg: " + bVar, new Object[0]);
                            WakeLockMonitorFeature.this.f262318d.g().d(bVar);
                        }
                    }
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.qqbattery.feature.a, com.tencent.mobileqq.qqbattery.feature.e
    public void a(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
            return;
        }
        super.a(z16);
        if (z16) {
            this.f262318d.i().removeCallbacks(this.C);
        } else {
            this.f262318d.i().postDelayed(this.C, this.f262299m);
        }
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [java.util.List<g.b$d>, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.util.List<g.b$d>, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.util.List<g.b$d>, java.util.ArrayList] */
    @Override // com.tencent.mobileqq.qqbattery.feature.a, com.tencent.mobileqq.qqbattery.feature.e
    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.b();
        a aVar = new a();
        this.f262297h = aVar;
        synchronized (g.b.class) {
            if (!g.b.f400997a.contains(aVar)) {
                g.b.f400997a.add(aVar);
                if (!g.b.f400998b && !g.b.f400997a.isEmpty()) {
                    com.tencent.mobileqq.qqbattery.utils.a.c("QQBattery_PowerHooker", "checkHook hookRet:%b", Boolean.valueOf(g.b.f401000d.a()));
                    g.b.f400998b = true;
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.qqbattery.feature.e
    public int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return Integer.MIN_VALUE;
    }

    @Override // com.tencent.mobileqq.qqbattery.feature.a, com.tencent.mobileqq.qqbattery.feature.e
    public void d(com.tencent.mobileqq.qqbattery.g gVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) gVar);
            return;
        }
        super.d(gVar);
        this.f262298i = this.f262318d.h().f262240f;
        this.f262299m = this.f262318d.h().f262241g;
    }

    public c f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (c) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.f262296f.b();
    }
}
