package hynb.r;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import cooperation.qzone.remote.ServiceConst;
import hynb.p.g;
import hynb.u.d;

/* compiled from: P */
/* loaded from: classes28.dex */
public class b {

    /* renamed from: g, reason: collision with root package name */
    public static b f406802g;

    /* renamed from: b, reason: collision with root package name */
    public String f406804b;

    /* renamed from: c, reason: collision with root package name */
    public long f406805c;

    /* renamed from: e, reason: collision with root package name */
    public volatile boolean f406807e;

    /* renamed from: a, reason: collision with root package name */
    public final hynb.r.c f406803a = new hynb.r.c();

    /* renamed from: d, reason: collision with root package name */
    public Object f406806d = new Object();

    /* renamed from: f, reason: collision with root package name */
    public final Runnable f406808f = new a();

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (b.this.f406807e) {
                    hynb.u.c.a().postDelayed(this, 60000L);
                    b.this.a();
                }
            } catch (Exception unused) {
            }
        }
    }

    /* compiled from: P */
    /* renamed from: hynb.r.b$b, reason: collision with other inner class name */
    /* loaded from: classes28.dex */
    public class RunnableC10488b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ hynb.t.a f406810a;

        public RunnableC10488b(hynb.t.a aVar) {
            this.f406810a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str;
            hynb.t.a aVar = this.f406810a;
            if (g.f406801c.a()) {
                str = "1";
            } else {
                str = "0";
            }
            aVar.a("isactive", str);
            b.this.f406803a.a("startup", null, null, this.f406810a);
            hynb.u.c.a().removeCallbacks(b.this.f406808f);
            b.this.f406807e = true;
            hynb.u.c.a().postDelayed(b.this.f406808f, 0L);
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ hynb.t.a f406812a;

        public c(hynb.t.a aVar) {
            this.f406812a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str;
            hynb.t.a aVar = this.f406812a;
            if (g.f406801c.a()) {
                str = "1";
            } else {
                str = "0";
            }
            aVar.a("isactive", str);
            b.this.f406803a.a("endup", null, null, this.f406812a);
        }
    }

    public static b c() {
        if (f406802g == null) {
            synchronized (b.class) {
                if (f406802g == null) {
                    f406802g = new b();
                }
            }
        }
        return f406802g;
    }

    public final hynb.t.a b() {
        synchronized (this.f406806d) {
            if (this.f406805c <= 0) {
                return null;
            }
            hynb.t.a aVar = new hynb.t.a();
            aVar.a("dur", String.valueOf(SystemClock.uptimeMillis() - this.f406805c));
            d(aVar);
            this.f406803a.b(aVar);
            return aVar;
        }
    }

    public void d() {
        this.f406803a.d();
    }

    public synchronized void a(Context context, hynb.t.b bVar, hynb.t.c cVar) {
        this.f406803a.a(context, bVar, cVar);
    }

    public final void d(hynb.t.a aVar) {
        if (TextUtils.isEmpty(this.f406803a.f406816c)) {
            this.f406803a.f406816c = d.a();
        }
        String str = this.f406803a.f406816c;
        if (this.f406804b == null || str == null) {
            return;
        }
        aVar.a(ServiceConst.PARA_SESSION_ID, str + "/" + this.f406804b);
    }

    public void a(String str, String str2, String str3, String str4, hynb.t.a aVar) {
        hynb.t.a aVar2 = new hynb.t.a();
        if (aVar != null) {
            aVar2.f406848a.putAll(aVar.f406848a);
        }
        aVar2.a("label", str3);
        aVar2.a("prop", str4);
        this.f406803a.a(str, str2, null, aVar2);
    }

    public final hynb.t.a c(hynb.t.a aVar) {
        synchronized (this.f406806d) {
            if (aVar == null) {
                aVar = new hynb.t.a();
            }
            this.f406804b = d.a();
            this.f406805c = SystemClock.uptimeMillis();
            d(aVar);
        }
        return aVar;
    }

    public void a(String str) {
        this.f406803a.f406820g = str;
    }

    public void a(hynb.t.a aVar) {
        hynb.u.c.a(new RunnableC10488b(c(aVar)));
    }

    public void a(long j3, long j16) {
        a(j3, j16, (hynb.t.a) null);
    }

    public final hynb.t.a b(hynb.t.a aVar) {
        synchronized (this.f406806d) {
            if (this.f406805c <= 0) {
                return null;
            }
            if (aVar == null) {
                aVar = new hynb.t.a();
            }
            aVar.a("dur", String.valueOf(SystemClock.uptimeMillis() - this.f406805c));
            d(aVar);
            this.f406804b = null;
            this.f406805c = 0L;
            return aVar;
        }
    }

    public void a(long j3, long j16, hynb.t.a aVar) {
        this.f406807e = false;
        hynb.u.c.a().removeCallbacks(this.f406808f);
        hynb.t.a b16 = b(aVar);
        if (b16 == null) {
            return;
        }
        if (j3 > 0) {
            b16.a("ayyuid", String.valueOf(j3));
        }
        if (j16 > 0) {
            b16.a("game_id", String.valueOf(j16));
        }
        hynb.u.c.a(new c(b16));
    }

    public void a(String str, String str2) {
        this.f406803a.a(str, str2);
    }

    public final void a() {
        hynb.t.a b16 = b();
        if (b16 == null) {
            return;
        }
        b16.a("isactive", g.f406801c.a() ? "1" : "0");
        this.f406803a.a("heartbeat", null, null, b16);
    }
}
