package com.tencent.mobileqq.qqbattery.feature;

import android.app.AlarmManager;
import android.app.PendingIntent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqbattery.feature.e;
import g.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes16.dex */
public class AlarmMonitorFeature extends com.tencent.mobileqq.qqbattery.feature.a {
    static IPatchRedirector $redirector_;
    public long C;

    /* renamed from: e, reason: collision with root package name */
    public a.d f262255e;

    /* renamed from: f, reason: collision with root package name */
    public final c f262256f;

    /* renamed from: h, reason: collision with root package name */
    public int f262257h;

    /* renamed from: i, reason: collision with root package name */
    public int f262258i;

    /* renamed from: m, reason: collision with root package name */
    public boolean f262259m;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public final int f262263a;

        /* renamed from: b, reason: collision with root package name */
        public final long f262264b;

        /* renamed from: c, reason: collision with root package name */
        public final long f262265c;

        /* renamed from: d, reason: collision with root package name */
        public final long f262266d;

        /* renamed from: e, reason: collision with root package name */
        public final int f262267e;

        /* renamed from: f, reason: collision with root package name */
        public final long f262268f;

        /* renamed from: g, reason: collision with root package name */
        public boolean f262269g;

        /* renamed from: h, reason: collision with root package name */
        public final String f262270h;

        public a(int i3, long j3, long j16, long j17, int i16, boolean z16, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17), Integer.valueOf(i16), Boolean.valueOf(z16), str);
                return;
            }
            this.f262263a = i3;
            this.f262264b = j3;
            this.f262265c = j16;
            this.f262266d = j17;
            this.f262267e = i16;
            this.f262268f = System.currentTimeMillis();
            this.f262269g = z16;
            this.f262270h = str;
        }

        public boolean equals(Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, obj)).booleanValue();
            }
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass() && hashCode() == ((a) obj).hashCode()) {
                return true;
            }
            return false;
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            StringBuilder a16 = g.a("AlarmRecord{type=");
            a16.append(this.f262263a);
            a16.append(", triggerAtMillis=");
            a16.append(this.f262264b);
            a16.append(", windowMillis=");
            a16.append(this.f262265c);
            a16.append(", intervalMillis=");
            a16.append(this.f262266d);
            a16.append(", flag=");
            a16.append(this.f262267e);
            a16.append(", timeBgn=");
            a16.append(this.f262268f);
            a16.append(", isForeground=");
            a16.append(this.f262269g);
            a16.append(", stack='");
            a16.append(this.f262270h);
            a16.append('\'');
            a16.append('}');
            return a16.toString();
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static class b extends e.a<b> {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        public e.a.b.AbstractC8294b<Integer> f262271d;

        /* renamed from: e, reason: collision with root package name */
        public e.a.b.AbstractC8294b<Integer> f262272e;

        /* renamed from: f, reason: collision with root package name */
        public e.a.b.AbstractC8294b<Integer> f262273f;

        /* renamed from: g, reason: collision with root package name */
        public e.a.b.c<e.a.b.C8292a<a>> f262274g;

        public b() {
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
            StringBuilder a16 = g.a("AlarmSnapshot{totalCount=");
            a16.append(this.f262271d);
            a16.append(", fgTracingCount=");
            a16.append(this.f262272e);
            a16.append(", bgTracingCount=");
            a16.append(this.f262273f);
            a16.append(", records=");
            a16.append(this.f262274g);
            a16.append('}');
            return a16.toString();
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static final class c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public final byte[] f262275a;

        /* renamed from: b, reason: collision with root package name */
        public int f262276b;

        /* renamed from: c, reason: collision with root package name */
        public int f262277c;

        /* renamed from: d, reason: collision with root package name */
        public int f262278d;

        /* renamed from: e, reason: collision with root package name */
        public final Map<Integer, a> f262279e;

        public c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.f262275a = new byte[0];
                this.f262279e = new HashMap();
            }
        }

        /* JADX WARN: Type inference failed for: r3v0, types: [java.util.Map<java.lang.Integer, com.tencent.mobileqq.qqbattery.feature.AlarmMonitorFeature$a>, java.util.HashMap] */
        public b a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (b) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            b bVar = new b();
            synchronized (this.f262275a) {
                bVar.f262271d = e.a.b.AbstractC8294b.c(Integer.valueOf(this.f262276b));
                bVar.f262272e = e.a.b.AbstractC8294b.c(Integer.valueOf(this.f262277c));
                bVar.f262273f = e.a.b.AbstractC8294b.c(Integer.valueOf(this.f262278d));
                bVar.f262274g = e.a.b.c.c(new ArrayList(this.f262279e.values()));
            }
            return bVar;
        }

        /* JADX WARN: Type inference failed for: r1v2, types: [java.util.Map<java.lang.Integer, com.tencent.mobileqq.qqbattery.feature.AlarmMonitorFeature$a>, java.util.HashMap] */
        public void b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this);
                return;
            }
            synchronized (this.f262275a) {
                this.f262276b = 0;
                this.f262278d = 0;
                this.f262277c = 0;
                this.f262279e.clear();
            }
        }

        /* JADX WARN: Type inference failed for: r5v4, types: [java.util.Map<java.lang.Integer, com.tencent.mobileqq.qqbattery.feature.AlarmMonitorFeature$a>, java.util.HashMap] */
        public void c(int i3, a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, i3, (Object) aVar);
                return;
            }
            synchronized (this.f262275a) {
                if (aVar.f262269g) {
                    this.f262277c--;
                } else {
                    this.f262278d--;
                }
                this.f262279e.remove(Integer.valueOf(i3));
            }
        }

        /* JADX WARN: Type inference failed for: r1v5, types: [java.util.Map<java.lang.Integer, com.tencent.mobileqq.qqbattery.feature.AlarmMonitorFeature$a>, java.util.HashMap] */
        public void d(int i3, a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) aVar);
                return;
            }
            synchronized (this.f262275a) {
                this.f262276b++;
                if (aVar.f262269g) {
                    this.f262277c++;
                } else {
                    this.f262278d++;
                }
                this.f262279e.put(Integer.valueOf(i3), aVar);
            }
        }

        /* JADX WARN: Type inference failed for: r1v0, types: [java.util.Map<java.lang.Integer, com.tencent.mobileqq.qqbattery.feature.AlarmMonitorFeature$a>, java.util.HashMap] */
        public void e(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, j3);
                return;
            }
            synchronized (this.f262275a) {
                for (Map.Entry entry : this.f262279e.entrySet()) {
                    if (Math.abs(((a) entry.getValue()).f262268f - System.currentTimeMillis()) >= j3) {
                        c(((Integer) entry.getKey()).intValue(), (a) entry.getValue());
                    }
                }
            }
        }
    }

    public AlarmMonitorFeature() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f262256f = new c();
        }
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [java.util.List<g.a$d>, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.util.List<g.a$d>, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.util.List<g.a$d>, java.util.ArrayList] */
    @Override // com.tencent.mobileqq.qqbattery.feature.a, com.tencent.mobileqq.qqbattery.feature.e
    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.b();
        a.d dVar = new a.d() { // from class: com.tencent.mobileqq.qqbattery.feature.AlarmMonitorFeature.1
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            public long f262260a;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AlarmMonitorFeature.this);
                } else {
                    this.f262260a = 0L;
                }
            }

            @Override // g.a.d
            public void a(int i3, long j3, long j16, long j17, int i16, PendingIntent pendingIntent, AlarmManager.OnAlarmListener onAlarmListener) {
                String str;
                int hashCode;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, Integer.valueOf(i3), Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17), Integer.valueOf(i16), pendingIntent, onAlarmListener);
                    return;
                }
                if (AlarmMonitorFeature.this.f262259m) {
                    str = i.a.a();
                } else {
                    str = "";
                }
                a aVar = new a(i3, j3, j16, j17, i16, AlarmMonitorFeature.this.f262318d.j().a(), str);
                com.tencent.mobileqq.qqbattery.utils.a.c("QQBattery_AlarmMonitorFeature", "#onAlarmSet, operation = " + pendingIntent + ", onAlarmListener = " + onAlarmListener + ", target = " + aVar, new Object[0]);
                if (pendingIntent != null || onAlarmListener != null) {
                    if (pendingIntent != null) {
                        hashCode = pendingIntent.hashCode();
                    } else {
                        hashCode = onAlarmListener.hashCode();
                    }
                    AlarmMonitorFeature.this.f262256f.d(hashCode, aVar);
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (Math.abs(currentTimeMillis - this.f262260a) < 10000) {
                    return;
                }
                this.f262260a = currentTimeMillis;
                AlarmMonitorFeature.this.f262318d.i().post(new a.a(new Runnable() { // from class: com.tencent.mobileqq.qqbattery.feature.AlarmMonitorFeature.1.1
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                            iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                            iPatchRedirector3.redirect((short) 2, (Object) this);
                            return;
                        }
                        AlarmMonitorFeature alarmMonitorFeature = AlarmMonitorFeature.this;
                        alarmMonitorFeature.f262256f.e(alarmMonitorFeature.C);
                        AlarmMonitorFeature alarmMonitorFeature2 = AlarmMonitorFeature.this;
                        c cVar = alarmMonitorFeature2.f262256f;
                        if (cVar.f262277c > alarmMonitorFeature2.f262257h || cVar.f262278d > alarmMonitorFeature2.f262258i) {
                            b a16 = cVar.a();
                            com.tencent.mobileqq.qqbattery.utils.a.b("QQBattery_AlarmMonitorFeature", "alarmCallWarn " + a16, new Object[0]);
                            AlarmMonitorFeature.this.f262318d.g().c(a16);
                            AlarmMonitorFeature.this.f262256f.b();
                        }
                    }
                }));
            }

            /* JADX WARN: Type inference failed for: r5v3, types: [java.util.Map<java.lang.Integer, com.tencent.mobileqq.qqbattery.feature.AlarmMonitorFeature$a>, java.util.HashMap] */
            @Override // g.a.d
            public void onAlarmRemove(PendingIntent pendingIntent, AlarmManager.OnAlarmListener onAlarmListener) {
                int hashCode;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    iPatchRedirector2.redirect((short) 3, (Object) this, (Object) pendingIntent, (Object) onAlarmListener);
                    return;
                }
                if (pendingIntent != null || onAlarmListener != null) {
                    com.tencent.mobileqq.qqbattery.utils.a.c("QQBattery_AlarmMonitorFeature", "#onAlarmRemove, operation = " + pendingIntent + ", onAlarmListener = " + onAlarmListener, new Object[0]);
                    if (pendingIntent != null) {
                        hashCode = pendingIntent.hashCode();
                    } else {
                        hashCode = onAlarmListener.hashCode();
                    }
                    a aVar = (a) AlarmMonitorFeature.this.f262256f.f262279e.get(Integer.valueOf(hashCode));
                    if (aVar != null) {
                        AlarmMonitorFeature.this.f262256f.c(hashCode, aVar);
                    }
                }
            }
        };
        this.f262255e = dVar;
        synchronized (g.a.class) {
            if (!g.a.f400989d.contains(dVar)) {
                g.a.f400989d.add(dVar);
                if (!g.a.f400986a && !g.a.f400989d.isEmpty()) {
                    com.tencent.mobileqq.qqbattery.utils.a.c("QQBattery_AlarmHooker", "checkHook hookRet:%b", Boolean.valueOf(g.a.f400988c.a()));
                    g.a.f400986a = true;
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
        this.f262257h = this.f262318d.h().f262236b;
        this.f262258i = this.f262318d.h().f262237c;
        this.f262259m = this.f262318d.h().f262238d;
        this.C = this.f262318d.h().f262239e;
    }

    public b f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (b) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.f262256f.a();
    }
}
