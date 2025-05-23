package com.tencent.luggage.wxa.bq;

import android.content.Context;
import android.os.SystemClock;
import com.tencent.luggage.wxa.jq.g;
import com.tencent.luggage.wxa.jq.h;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a implements com.tencent.luggage.wxa.bq.c {

    /* renamed from: a, reason: collision with root package name */
    public com.tencent.luggage.wxa.zp.a f123094a;

    /* renamed from: d, reason: collision with root package name */
    public final d f123097d;

    /* renamed from: b, reason: collision with root package name */
    public ConcurrentHashMap f123095b = null;

    /* renamed from: c, reason: collision with root package name */
    public AtomicLong f123096c = new AtomicLong(0);

    /* renamed from: e, reason: collision with root package name */
    public volatile long f123098e = 0;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.bq.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C6085a implements g {
        public C6085a() {
        }

        @Override // com.tencent.luggage.wxa.jq.g, com.tencent.luggage.wxa.jq.f
        public String getKey() {
            return "Experience#persistCache";
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = a.this;
            aVar.a(aVar.b());
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public String f123100a;

        /* renamed from: b, reason: collision with root package name */
        public float f123101b;

        /* renamed from: c, reason: collision with root package name */
        public float f123102c;

        /* renamed from: d, reason: collision with root package name */
        public long f123103d;

        /* renamed from: e, reason: collision with root package name */
        public long f123104e;

        /* renamed from: f, reason: collision with root package name */
        public float f123105f;

        /* renamed from: g, reason: collision with root package name */
        public float f123106g;

        /* renamed from: h, reason: collision with root package name */
        public float f123107h;

        /* renamed from: i, reason: collision with root package name */
        public float f123108i;

        /* renamed from: j, reason: collision with root package name */
        public ConcurrentLinkedQueue f123109j;

        public b(String str) {
            this.f123101b = 0.0f;
            this.f123102c = 0.0f;
            this.f123103d = 0L;
            this.f123104e = 0L;
            this.f123105f = 0.0f;
            this.f123106g = 0.0f;
            this.f123107h = 1.0f;
            this.f123108i = 0.0f;
            this.f123109j = new ConcurrentLinkedQueue();
            this.f123100a = str;
        }

        public String a() {
            return this.f123100a;
        }

        public final int b() {
            return this.f123109j.size();
        }

        public boolean c() {
            if (this.f123103d < 5000 && this.f123102c < 0.5f) {
                return false;
            }
            return true;
        }

        public String toString() {
            return this.f123100a + " " + this.f123102c + " " + c() + " " + b();
        }

        public void a(c cVar) {
            boolean z16;
            this.f123109j.add(cVar);
            this.f123105f += (float) cVar.f123111b;
            this.f123106g += (float) cVar.f123112c;
            int b16 = b();
            float f16 = this.f123107h;
            float f17 = cVar.f123115f;
            if (f16 > f17) {
                z16 = b16 <= 5000;
                if (!z16) {
                    this.f123101b += f16;
                }
                this.f123107h = f17;
            } else {
                z16 = true;
            }
            float f18 = this.f123108i;
            if (f18 < f17) {
                boolean z17 = b16 <= 5000;
                if (!z17) {
                    this.f123101b += f18;
                }
                this.f123108i = f17;
                z16 = z17;
            }
            if (z16) {
                this.f123101b += f17;
            }
            this.f123102c = this.f123101b / (b16 - (b16 > 5000 ? 2 : 0));
            float f19 = b16;
            this.f123103d = (this.f123105f * 1.0f) / f19;
            this.f123104e = (this.f123106g * 1.0f) / f19;
        }

        public b(String str, float f16, long j3) {
            this.f123101b = 0.0f;
            this.f123102c = 0.0f;
            this.f123103d = 0L;
            this.f123104e = 0L;
            this.f123105f = 0.0f;
            this.f123106g = 0.0f;
            this.f123107h = 1.0f;
            this.f123108i = 0.0f;
            this.f123109j = new ConcurrentLinkedQueue();
            this.f123100a = str;
            this.f123102c = f16;
            this.f123103d = j3;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public String f123110a;

        /* renamed from: b, reason: collision with root package name */
        public long f123111b;

        /* renamed from: c, reason: collision with root package name */
        public long f123112c;

        /* renamed from: d, reason: collision with root package name */
        public String f123113d;

        /* renamed from: e, reason: collision with root package name */
        public long f123114e;

        /* renamed from: f, reason: collision with root package name */
        public float f123115f;

        public c(String str, long j3, long j16, String str2) {
            this.f123110a = str;
            this.f123111b = j3;
            this.f123112c = j16;
            this.f123113d = str2;
            this.f123115f = j16 > 1 ? (((float) j3) * 1.0f) / ((float) j16) : 1.0f;
            this.f123114e = System.currentTimeMillis();
        }

        public boolean equals(Object obj) {
            return this.f123110a.equals(obj);
        }

        public int hashCode() {
            return this.f123110a.hashCode();
        }

        public String toString() {
            return this.f123110a + " " + this.f123111b + " " + this.f123112c;
        }
    }

    public a(Context context, com.tencent.luggage.wxa.zp.a aVar) {
        d dVar = aVar.f146784g;
        this.f123097d = dVar == null ? new com.tencent.luggage.wxa.bq.b(context) : dVar;
        this.f123094a = aVar;
        a();
    }

    @Override // com.tencent.luggage.wxa.fq.a
    public void b(h hVar) {
        hVar.g().d(hVar.e());
    }

    @Override // com.tencent.luggage.wxa.fq.a
    public void c(h hVar) {
        hVar.g().d(hVar.e());
    }

    @Override // com.tencent.luggage.wxa.fq.a
    public void e(h hVar) {
        hVar.g().a(hVar.e());
    }

    @Override // com.tencent.luggage.wxa.fq.a
    public void f(h hVar) {
        hVar.g().d(hVar.e());
    }

    public final ConcurrentHashMap b() {
        if (this.f123095b == null) {
            synchronized (this) {
                if (this.f123095b == null) {
                    this.f123095b = new ConcurrentHashMap();
                }
            }
        }
        return this.f123095b;
    }

    @Override // com.tencent.luggage.wxa.fq.a
    public void a(h hVar, long j3, long j16) {
        hVar.g().d(hVar.e());
        long[] h16 = hVar.h();
        c cVar = new c(hVar.getKey(), h16[0], h16[1], hVar.f().getName());
        b bVar = (b) b().get(cVar.f123110a);
        if (bVar == null) {
            bVar = new b(cVar.f123110a);
            b().put(cVar.f123110a, bVar);
        }
        bVar.a(cVar);
        if (this.f123096c.incrementAndGet() < 5000 || System.currentTimeMillis() - this.f123098e < 600000) {
            return;
        }
        this.f123096c.set(0L);
        this.f123098e = System.currentTimeMillis();
        com.tencent.luggage.wxa.zp.h.f146825d.d(new C6085a());
    }

    @Override // com.tencent.luggage.wxa.fq.a
    public void a(h hVar) {
        hVar.g().b(hVar.e());
    }

    @Override // com.tencent.luggage.wxa.jq.a
    public boolean a(String str) {
        b bVar;
        if (str == null || (bVar = (b) b().get(str)) == null) {
            return true;
        }
        return !bVar.c();
    }

    public final void a() {
        long uptimeMillis = SystemClock.uptimeMillis();
        this.f123097d.a(this.f123094a.f146781d);
        StringBuilder sb5 = new StringBuilder("[buildCache] successfully! ");
        sb5.append('\n');
        StringBuilder sb6 = new StringBuilder();
        int i3 = 0;
        for (Map.Entry entry : this.f123097d.a().entrySet()) {
            String str = (String) entry.getKey();
            b bVar = (b) entry.getValue();
            sb6.append("# ");
            sb6.append(str);
            sb6.append('-');
            sb6.append(bVar.c());
            sb6.append('\n');
            b().put(str, bVar);
            i3++;
        }
        sb5.append("# ");
        sb5.append("size:");
        sb5.append(i3);
        sb5.append(" cost:");
        sb5.append(SystemClock.uptimeMillis() - uptimeMillis);
        sb5.append("ms");
        sb5.append('\n');
        sb5.append((CharSequence) sb6);
        com.tencent.luggage.wxa.zp.d.f146814c.i("Experience", sb5.toString(), new Object[0]);
    }

    public final synchronized void a(ConcurrentHashMap concurrentHashMap) {
        if (concurrentHashMap.size() <= 0) {
            return;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        try {
            this.f123097d.a(concurrentHashMap.values());
            com.tencent.luggage.wxa.zp.d.f146814c.i("Experience", "[persistCache] successfully! size=" + concurrentHashMap.size() + " cost:" + (SystemClock.uptimeMillis() - uptimeMillis), new Object[0]);
            concurrentHashMap.clear();
        } catch (Exception e16) {
            com.tencent.luggage.wxa.zp.d.f146814c.e("Experience", "%s", e16.toString());
        }
    }

    @Override // com.tencent.luggage.wxa.fq.a
    public void d(h hVar) {
    }
}
