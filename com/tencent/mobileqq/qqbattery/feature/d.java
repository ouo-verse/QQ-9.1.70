package com.tencent.mobileqq.qqbattery.feature;

import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import c.e;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqbattery.feature.e;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes16.dex */
public class d extends com.tencent.mobileqq.qqbattery.feature.a implements Handler.Callback {
    static IPatchRedirector $redirector_;
    public float C;
    public int D;
    public int E;
    public long F;
    public boolean G;

    /* renamed from: e, reason: collision with root package name */
    public long f262319e;

    /* renamed from: f, reason: collision with root package name */
    public a f262320f;

    /* renamed from: h, reason: collision with root package name */
    public Handler f262321h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f262322i;

    /* renamed from: m, reason: collision with root package name */
    public final List<Float> f262323m;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static class a extends e.a<a> {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        public int f262324d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f262325e;

        /* renamed from: f, reason: collision with root package name */
        public String f262326f;

        /* renamed from: g, reason: collision with root package name */
        public e.a.b.AbstractC8294b<Long> f262327g;

        /* renamed from: h, reason: collision with root package name */
        public e.a.b.c<c> f262328h;

        /* renamed from: i, reason: collision with root package name */
        public e.a.b.AbstractC8294b<Integer> f262329i;

        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.qqbattery.feature.d$a$a, reason: collision with other inner class name */
        /* loaded from: classes16.dex */
        public class C8290a extends e.a.AbstractC8291a<a> {
            static IPatchRedirector $redirector_;

            public C8290a(a aVar, a aVar2) {
                super(aVar, aVar2);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar, (Object) aVar2);
                }
            }

            /* JADX WARN: Type inference failed for: r0v3, types: [com.tencent.mobileqq.qqbattery.feature.e$a, com.tencent.mobileqq.qqbattery.feature.d$a] */
            @Override // com.tencent.mobileqq.qqbattery.feature.e.a.AbstractC8291a
            public final a a() {
                boolean z16;
                boolean z17;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (e.a) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                a aVar = new a();
                a aVar2 = (a) this.f262348b;
                aVar.f262324d = aVar2.f262324d;
                aVar.f262325e = aVar2.f262325e;
                aVar.f262326f = aVar2.f262326f;
                aVar.f262327g = f.b(((a) this.f262347a).f262327g, aVar2.f262327g);
                aVar.f262329i = f.b(((a) this.f262347a).f262329i, ((a) this.f262348b).f262329i);
                aVar.f262328h = e.a.b.c.d();
                if (((a) this.f262348b).f262328h.a().size() > 0) {
                    ArrayList arrayList = new ArrayList();
                    for (c cVar : ((a) this.f262348b).f262328h.a()) {
                        long longValue = ((Long) cVar.f262353b).longValue();
                        Iterator<c> it = ((a) this.f262347a).f262328h.a().iterator();
                        while (true) {
                            if (it.hasNext()) {
                                c next = it.next();
                                if (next.f262331d.equals(cVar.f262331d) && next.f262330c == cVar.f262330c) {
                                    longValue = ((Long) f.b(next, cVar).f262353b).longValue();
                                    z17 = false;
                                    break;
                                }
                            } else {
                                z17 = true;
                                break;
                            }
                        }
                        if (longValue > 0) {
                            c cVar2 = new c(Long.valueOf(longValue));
                            cVar2.f262330c = cVar.f262330c;
                            cVar2.f262331d = cVar.f262331d;
                            cVar2.f262333f = cVar.f262333f;
                            cVar2.f262332e = z17;
                            arrayList.add(cVar2);
                        }
                    }
                    if (arrayList.size() > 0) {
                        Collections.sort(arrayList, new com.tencent.mobileqq.qqbattery.feature.c());
                        aVar.f262328h = e.a.b.c.b(arrayList);
                    }
                }
                if (((a) this.f262347a).f262328h.a().size() > 0) {
                    List emptyList = Collections.emptyList();
                    for (c cVar3 : ((a) this.f262347a).f262328h.a()) {
                        Iterator<c> it5 = aVar.f262328h.a().iterator();
                        while (true) {
                            if (it5.hasNext()) {
                                if (it5.next().f262330c == cVar3.f262330c) {
                                    z16 = false;
                                    break;
                                }
                            } else {
                                z16 = true;
                                break;
                            }
                        }
                        if (z16) {
                            if (emptyList.isEmpty()) {
                                emptyList = new ArrayList();
                            }
                            emptyList.add(cVar3);
                        }
                    }
                    if (!emptyList.isEmpty()) {
                        e.a.b.c.b(emptyList);
                    }
                }
                return aVar;
            }
        }

        /* compiled from: P */
        /* loaded from: classes16.dex */
        public static class b extends e.a.b.AbstractC8294b<Long> {
            static IPatchRedirector $redirector_;

            /* renamed from: c, reason: collision with root package name */
            public int f262330c;

            /* renamed from: d, reason: collision with root package name */
            public String f262331d;

            /* renamed from: e, reason: collision with root package name */
            public boolean f262332e;

            /* renamed from: f, reason: collision with root package name */
            public String f262333f;

            /* renamed from: g, reason: collision with root package name */
            public String f262334g;

            public b(Long l3) {
                super(l3);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) l3);
                }
            }

            @Override // com.tencent.mobileqq.qqbattery.feature.e.a.b.AbstractC8294b
            /* renamed from: d, reason: merged with bridge method [inline-methods] */
            public Long a(Long l3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (Long) iPatchRedirector.redirect((short) 2, (Object) this, (Object) l3);
                }
                return Long.valueOf(((Long) this.f262353b).longValue() - l3.longValue());
            }

            @Override // com.tencent.mobileqq.qqbattery.feature.e.a.b.AbstractC8294b
            public String toString() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    return (String) iPatchRedirector.redirect((short) 3, (Object) this);
                }
                StringBuilder a16 = g.a("ThreadJiffiesEntry{tid=");
                a16.append(this.f262330c);
                a16.append(", name='");
                a16.append(this.f262331d);
                a16.append('\'');
                a16.append(", isNewAdded=");
                a16.append(this.f262332e);
                a16.append(", stat='");
                a16.append(this.f262333f);
                a16.append('\'');
                a16.append(", stack='");
                a16.append(this.f262334g);
                a16.append('\'');
                a16.append('}');
                return a16.toString();
            }
        }

        /* compiled from: P */
        @Deprecated
        /* loaded from: classes16.dex */
        public static class c extends b {
            static IPatchRedirector $redirector_;

            public c(Long l3) {
                super(l3);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) l3);
                }
            }

            public static c e(b.a aVar) {
                try {
                    aVar.b();
                    c cVar = new c(Long.valueOf(aVar.f262343e));
                    cVar.f262331d = aVar.f262341c;
                    cVar.f262333f = aVar.f262342d;
                    cVar.f262330c = aVar.f262340b;
                    cVar.f262332e = true;
                    return cVar;
                } catch (IOException e16) {
                    com.tencent.mobileqq.qqbattery.utils.a.d("QQBattery_JiffiesMonitorFeature", e16, "parseThreadJiffies fail", new Object[0]);
                    return null;
                }
            }
        }

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.f262325e = false;
                e.a.b.c.d();
            }
        }

        public static a c(b bVar, boolean z16) {
            a aVar = new a();
            aVar.f262324d = bVar.f262335a;
            aVar.f262326f = bVar.f262336b;
            int i3 = 0;
            long j3 = 0;
            if (z16) {
                try {
                    bVar.b();
                    j3 = bVar.f262337c;
                } catch (IOException e16) {
                    com.tencent.mobileqq.qqbattery.utils.a.d("QQBattery_JiffiesMonitorFeature", e16, "parseProcJiffies fail", new Object[0]);
                    aVar.b(false);
                    z16 = false;
                }
            }
            List emptyList = Collections.emptyList();
            if (bVar.f262338d.size() > 0) {
                int size = bVar.f262338d.size();
                ArrayList arrayList = new ArrayList(bVar.f262338d.size());
                Iterator<b.a> it = bVar.f262338d.iterator();
                while (it.hasNext()) {
                    c e17 = c.e(it.next());
                    if (e17 != null) {
                        arrayList.add(e17);
                        if (!z16) {
                            j3 += ((Long) e17.f262353b).longValue();
                        }
                    } else {
                        aVar.b(false);
                    }
                }
                i3 = size;
                emptyList = arrayList;
            }
            aVar.f262327g = e.a.b.AbstractC8294b.c(Long.valueOf(j3));
            aVar.f262328h = e.a.b.c.b(emptyList);
            aVar.f262329i = e.a.b.AbstractC8294b.c(Integer.valueOf(i3));
            return aVar;
        }

        public e.a.AbstractC8291a<a> d(a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (e.a.AbstractC8291a) iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
            }
            return new C8290a(aVar, this);
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public int f262335a;

        /* renamed from: b, reason: collision with root package name */
        public String f262336b;

        /* renamed from: c, reason: collision with root package name */
        public long f262337c;

        /* renamed from: d, reason: collision with root package name */
        public List<a> f262338d;

        /* compiled from: P */
        /* loaded from: classes16.dex */
        public static class a {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            public int f262339a;

            /* renamed from: b, reason: collision with root package name */
            public int f262340b;

            /* renamed from: c, reason: collision with root package name */
            public String f262341c;

            /* renamed from: d, reason: collision with root package name */
            public String f262342d;

            /* renamed from: e, reason: collision with root package name */
            public long f262343e;

            public a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            public static List a(int i3) {
                File file = new File("/proc/" + i3 + "/task/");
                try {
                    if (file.isDirectory()) {
                        File[] listFiles = file.listFiles();
                        if (listFiles == null) {
                            return Collections.emptyList();
                        }
                        ArrayList arrayList = new ArrayList(listFiles.length);
                        for (File file2 : listFiles) {
                            if (file2.isDirectory()) {
                                try {
                                    int parseInt = Integer.parseInt(file2.getName());
                                    a aVar = new a();
                                    aVar.f262339a = i3;
                                    aVar.f262340b = parseInt;
                                    arrayList.add(aVar);
                                } catch (Exception e16) {
                                    com.tencent.mobileqq.qqbattery.utils.a.d("QQBattery_JiffiesMonitorFeature", e16, "parse thread error: " + file2.getName(), new Object[0]);
                                }
                            }
                        }
                        return arrayList;
                    }
                } catch (Exception e17) {
                    com.tencent.mobileqq.qqbattery.utils.a.d("QQBattery_JiffiesMonitorFeature", e17, "list thread dir error", new Object[0]);
                }
                return Collections.emptyList();
            }

            public void b() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                int i3 = this.f262339a;
                int i16 = this.f262340b;
                ThreadLocal<byte[]> threadLocal = c.e.f29459a;
                e.c d16 = c.e.d("/proc/" + i3 + "/task/" + i16 + "/stat");
                if (d16 != null && !TextUtils.isEmpty(d16.f29460a)) {
                    this.f262341c = d16.f29460a;
                    this.f262342d = d16.f29461b;
                    this.f262343e = d16.f29462c + d16.f29463d + d16.f29464e + d16.f29465f;
                    return;
                }
                StringBuilder a16 = g.a("parse fail: ");
                StringBuilder a17 = g.a("/proc/");
                a17.append(this.f262339a);
                a17.append("/task/");
                a17.append(this.f262340b);
                a17.append("/stat");
                a16.append(i.d.b(a17.toString()));
                throw new IOException(a16.toString());
            }

            public String toString() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    return (String) iPatchRedirector.redirect((short) 3, (Object) this);
                }
                StringBuilder a16 = g.a("thread:");
                a16.append(this.f262341c);
                a16.append("(");
                a16.append(this.f262340b);
                a16.append(") ");
                a16.append(this.f262343e);
                return a16.toString();
            }
        }

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.f262338d = Collections.emptyList();
            }
        }

        public static b a() {
            String str;
            b bVar = new b();
            bVar.f262335a = Process.myPid();
            if (com.tencent.mobileqq.qqbattery.f.d()) {
                str = i.d.a(com.tencent.mobileqq.qqbattery.f.g().b());
            } else {
                str = "default";
            }
            bVar.f262336b = str;
            bVar.f262338d = a.a(bVar.f262335a);
            SystemClock.uptimeMillis();
            System.currentTimeMillis();
            return bVar;
        }

        public void b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            int i3 = this.f262335a;
            ThreadLocal<byte[]> threadLocal = c.e.f29459a;
            e.c d16 = c.e.d("/proc/" + i3 + "/stat");
            if (d16 != null) {
                this.f262336b = d16.f29460a;
                this.f262337c = d16.f29462c + d16.f29463d + d16.f29464e + d16.f29465f;
                return;
            }
            StringBuilder a16 = g.a("parse fail: ");
            StringBuilder a17 = g.a("/proc/");
            a17.append(this.f262335a);
            a17.append("/stat");
            a16.append(i.d.b(a17.toString()));
            throw new IOException(a16.toString());
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            StringBuilder a16 = g.a("process:");
            a16.append(this.f262336b);
            a16.append("(");
            a16.append(this.f262335a);
            a16.append(") thread size:");
            a16.append(this.f262338d.size());
            return a16.toString();
        }
    }

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f262323m = new ArrayList();
        }
    }

    @Override // com.tencent.mobileqq.qqbattery.feature.a, com.tencent.mobileqq.qqbattery.feature.e
    public void a(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, z16);
            return;
        }
        super.a(z16);
        if (!this.f262322i) {
            return;
        }
        if (!z16) {
            this.f262321h.removeCallbacksAndMessages(null);
            Message obtain = Message.obtain(this.f262321h);
            obtain.what = 1;
            this.f262321h.sendMessageDelayed(obtain, 30000L);
            Message obtain2 = Message.obtain(this.f262321h);
            obtain2.what = 3;
            this.f262321h.sendMessageDelayed(obtain2, 30000L);
            return;
        }
        Message obtain3 = Message.obtain(this.f262321h);
        obtain3.what = 2;
        this.f262321h.sendMessageAtFrontOfQueue(obtain3);
    }

    @Override // com.tencent.mobileqq.qqbattery.feature.a, com.tencent.mobileqq.qqbattery.feature.e
    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            super.b();
        }
    }

    @Override // com.tencent.mobileqq.qqbattery.feature.e
    public int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return Integer.MAX_VALUE;
    }

    @Override // com.tencent.mobileqq.qqbattery.feature.a, com.tencent.mobileqq.qqbattery.feature.e
    public void d(com.tencent.mobileqq.qqbattery.g gVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) gVar);
            return;
        }
        super.d(gVar);
        this.f262321h = new Handler(this.f262318d.l().getLooper(), this);
        this.f262322i = this.f262318d.h().e();
        this.C = this.f262318d.h().f262242h;
        this.D = this.f262318d.h().f262243i;
        this.E = this.f262318d.h().f262244j;
        this.F = this.f262318d.h().c();
        this.G = this.f262318d.h().f();
    }

    @Override // com.tencent.mobileqq.qqbattery.feature.a
    public final String e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return "QQBattery_JiffiesMonitorFeature";
    }

    public final void f(e.a.AbstractC8291a<a> abstractC8291a, long j3, boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, abstractC8291a, Long.valueOf(j3), Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        com.tencent.mobileqq.qqbattery.utils.a.c("QQBattery_JiffiesMonitorFeature", "checkBadThread duringMillis = " + j3, new Object[0]);
        ArrayList arrayList = new ArrayList();
        Map<Thread, StackTraceElement[]> map = null;
        for (int i3 = 0; i3 < Math.min(abstractC8291a.f262349c.f262328h.a().size(), 10); i3++) {
            a.c cVar = abstractC8291a.f262349c.f262328h.a().get(i3);
            StringBuilder a16 = g.a("Print top thread : name = ");
            a16.append(cVar.f262331d);
            a16.append(", stat = ");
            a16.append(cVar.f262333f);
            a16.append(", tid = ");
            a16.append(cVar.f262330c);
            a16.append(", Jiffies = ");
            a16.append(cVar.b());
            com.tencent.mobileqq.qqbattery.utils.a.c("QQBattery_JiffiesMonitorFeature", a16.toString(), new Object[0]);
            if (z16) {
                if (map == null) {
                    map = Thread.getAllStackTraces();
                }
                for (Map.Entry<Thread, StackTraceElement[]> entry : map.entrySet()) {
                    Thread key = entry.getKey();
                    StackTraceElement[] value = entry.getValue();
                    String name = key.getName();
                    if (cVar.f262331d.equalsIgnoreCase(name) || name.contains(cVar.f262331d)) {
                        String b16 = i.a.b(value);
                        com.tencent.mobileqq.qqbattery.utils.a.c("QQBattery_JiffiesMonitorFeature", "Print top thread stack : " + b16, new Object[0]);
                        cVar.f262334g = b16;
                    }
                }
                arrayList.add(cVar);
            }
        }
        if (z17) {
            this.f262318d.g().b(arrayList, j3);
        }
    }

    public a g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (a) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return a.c(b.a(), this.G);
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [java.util.List<java.lang.Float>, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.util.List<java.lang.Float>, java.util.ArrayList] */
    public float h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Float) iPatchRedirector.redirect((short) 8, (Object) this)).floatValue();
        }
        float f16 = 0.0f;
        for (int i3 = 0; i3 < Math.min(10, this.f262323m.size()); i3++) {
            f16 = Math.max(f16, ((Float) this.f262323m.get((r2.size() - 1) - i3)).floatValue());
        }
        return f16;
    }

    /* JADX WARN: Type inference failed for: r0v10, types: [java.util.List<java.lang.Float>, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r0v19, types: [java.util.List<java.lang.Float>, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.util.List<java.lang.Float>, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.util.List<java.lang.Float>, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r0v8, types: [java.util.List<java.lang.Float>, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.util.List<java.lang.Float>, java.util.ArrayList] */
    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i3;
        ?? r06;
        int size;
        int size2;
        int i16;
        int i17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) message)).booleanValue();
        }
        try {
            i3 = message.what;
        } catch (Exception e16) {
            com.tencent.mobileqq.qqbattery.utils.a.d("QQBattery_JiffiesMonitorFeature", e16, "", new Object[0]);
        }
        if (i3 == 1) {
            a g16 = g();
            if (this.f262319e > 0 || this.f262320f != null) {
                long uptimeMillis = SystemClock.uptimeMillis() - this.f262319e;
                if (uptimeMillis <= 0) {
                    com.tencent.mobileqq.qqbattery.utils.a.f("QQBattery_JiffiesMonitorFeature", "skip invalid battery tracing, bgn = " + this.f262319e + ", during = " + uptimeMillis, new Object[0]);
                    return true;
                }
                f(g16.d(this.f262320f), uptimeMillis, false, false);
            }
            this.f262319e = SystemClock.uptimeMillis();
            this.f262320f = g16;
            Message obtain = Message.obtain(this.f262321h);
            obtain.what = 1;
            this.f262321h.sendMessageDelayed(obtain, this.F);
            return true;
        }
        if (i3 == 2) {
            this.f262319e = 0L;
            this.f262320f = null;
            this.f262321h.removeMessages(1);
            return true;
        }
        if (i3 == 3) {
            this.f262323m.add(Float.valueOf(this.f262318d.j().getCpuUsage()));
            if (this.f262323m.size() >= this.E) {
                float f16 = 0.0f;
                int i18 = 0;
                while (true) {
                    i17 = this.E;
                    if (i18 >= i17) {
                        break;
                    }
                    ?? r36 = this.f262323m;
                    f16 += ((Float) r36.get((r36.size() - 1) - i18)).floatValue();
                    i18++;
                }
                if (f16 / i17 >= this.C) {
                    long uptimeMillis2 = SystemClock.uptimeMillis() - this.f262319e;
                    if (uptimeMillis2 <= 0) {
                        com.tencent.mobileqq.qqbattery.utils.a.f("QQBattery_JiffiesMonitorFeature", "skip invalid cpu tracing, bgn = " + this.f262319e + ", during = " + uptimeMillis2, new Object[0]);
                        return true;
                    }
                    if (this.f262320f == null) {
                        return true;
                    }
                    f(g().d(this.f262320f), uptimeMillis2, true, true);
                    this.f262323m.clear();
                    this.f262319e = 0L;
                    this.f262320f = null;
                    this.f262321h.removeMessages(1);
                    Message obtain2 = Message.obtain(this.f262321h);
                    obtain2.what = 1;
                    this.f262321h.sendMessageDelayed(obtain2, this.F);
                }
            }
            Message obtain3 = Message.obtain(this.f262321h);
            obtain3.what = 3;
            this.f262321h.sendMessageDelayed(obtain3, 30000L);
            if (this.f262323m.size() >= this.D && (r06 = this.f262323m) != 0 && (size2 = (size = r06.size()) / 2) < (i16 = size - 1)) {
                r06.subList(size2, i16).clear();
            }
            return true;
        }
        return false;
    }
}
