package com.tencent.luggage.wxa.qc;

import androidx.arch.core.util.Function;
import androidx.collection.ArrayMap;
import com.tencent.luggage.wxa.pi.a;
import com.tencent.luggage.wxa.qc.d;
import com.tencent.luggage.wxa.tn.w;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class c {

    /* renamed from: e, reason: collision with root package name */
    public static boolean f138606e = false;

    /* renamed from: f, reason: collision with root package name */
    public static long f138607f;

    /* renamed from: g, reason: collision with root package name */
    public static boolean f138608g;

    /* renamed from: h, reason: collision with root package name */
    public static long f138609h;

    /* renamed from: a, reason: collision with root package name */
    public final com.tencent.luggage.wxa.qc.d f138610a;

    /* renamed from: b, reason: collision with root package name */
    public final com.tencent.luggage.wxa.ic.g f138611b;

    /* renamed from: c, reason: collision with root package name */
    public final ArrayMap f138612c = new ArrayMap();

    /* renamed from: d, reason: collision with root package name */
    public final a.b f138613d = new a();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b extends com.tencent.luggage.wxa.qc.d {

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class a implements Function {
            public a() {
            }

            public Void a(d dVar) {
                dVar.e();
                return null;
            }

            @Override // androidx.arch.core.util.Function
            public /* bridge */ /* synthetic */ Object apply(Object obj) {
                com.tencent.luggage.wxa.k0.d.a(obj);
                return a(null);
            }
        }

        public b(com.tencent.luggage.wxa.ic.g gVar) {
            super(gVar);
        }

        @Override // com.tencent.luggage.wxa.qc.d
        public void a(com.tencent.luggage.wxa.qc.b bVar) {
            w.d("Luggage.AppRunningStateController", "onStateChanged(%s) %s", bVar, c.this.f138611b);
            c.this.a(bVar);
        }

        @Override // com.tencent.luggage.wxa.qc.d
        public void u() {
            boolean l16 = c.this.f138611b.l1();
            w.d("Luggage.AppRunningStateController", "onSuspendTimeout, %s, shouldHandle?:%b", c.this.f138611b, Boolean.valueOf(l16));
            if (!l16) {
                return;
            }
            c.this.f138611b.D();
            c.this.a(new a());
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.qc.c$c, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC6640c {
        void a(String str, com.tencent.luggage.wxa.qc.b bVar);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface d extends InterfaceC6640c {
        void e();
    }

    static {
        long millis = TimeUnit.MINUTES.toMillis(10L);
        f138607f = millis;
        f138608g = false;
        f138609h = millis;
    }

    public c(com.tencent.luggage.wxa.ic.g gVar) {
        this.f138611b = gVar;
        this.f138610a = new b(gVar);
    }

    public boolean c() {
        return this.f138610a.s();
    }

    public void d() {
        this.f138610a.t();
    }

    public void e() {
        this.f138610a.a(d.k.ON_CONTAINER_ACTIVITY_STOPPED);
    }

    public void f() {
        this.f138610a.a(d.k.ON_DETACH_FROM_STACK);
    }

    public void g() {
        com.tencent.luggage.wxa.pi.a.f137604c.a(this.f138611b.getAppId(), this.f138613d);
    }

    public void h() {
        this.f138610a.a(d.k.ON_RESET_TO_TOP_OF_STACK);
    }

    public void i() {
        this.f138610a.a(d.k.TO_FOREGROUND, "onRuntimeCreate");
    }

    public void j() {
        this.f138610a.a(d.k.TO_BACKGROUND);
    }

    public void k() {
        this.f138610a.a(d.k.TO_FOREGROUND, "onRuntimeResume");
    }

    public boolean l() {
        return this.f138610a.x();
    }

    public void m() {
        this.f138610a.m();
    }

    public void n() {
        this.f138610a.y();
        com.tencent.luggage.wxa.pi.a.f137604c.b(this.f138611b.getAppId(), this.f138613d);
        synchronized (this.f138612c) {
            this.f138612c.clear();
        }
    }

    public void o() {
        this.f138610a.a(d.k.ON_STOP_BACKGROUND_LOCATION_LISTENING);
    }

    public com.tencent.luggage.wxa.qc.b b() {
        return this.f138610a.p();
    }

    public void b(InterfaceC6640c interfaceC6640c) {
        if (interfaceC6640c == null || com.tencent.luggage.wxa.qc.b.DESTROYED == b()) {
            return;
        }
        synchronized (this.f138612c) {
            this.f138612c.remove(interfaceC6640c);
        }
    }

    public final void a(com.tencent.luggage.wxa.qc.b bVar) {
        InterfaceC6640c[] interfaceC6640cArr;
        synchronized (this.f138612c) {
            interfaceC6640cArr = (InterfaceC6640c[]) this.f138612c.keySet().toArray(new InterfaceC6640c[this.f138612c.size()]);
        }
        for (InterfaceC6640c interfaceC6640c : interfaceC6640cArr) {
            interfaceC6640c.a(this.f138611b.getAppId(), bVar);
        }
    }

    public final void a(Function function) {
        InterfaceC6640c[] interfaceC6640cArr;
        synchronized (this.f138612c) {
            interfaceC6640cArr = (InterfaceC6640c[]) this.f138612c.keySet().toArray(new InterfaceC6640c[this.f138612c.size()]);
        }
        for (InterfaceC6640c interfaceC6640c : interfaceC6640cArr) {
        }
    }

    public void a(boolean z16) {
        this.f138610a.c(z16);
    }

    public void a(InterfaceC6640c interfaceC6640c) {
        if (interfaceC6640c == null || c()) {
            return;
        }
        synchronized (this.f138612c) {
            this.f138612c.put(interfaceC6640c, this);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements a.b {
        public a() {
        }

        @Override // com.tencent.luggage.wxa.pi.a.b
        public void a() {
            c.this.f138610a.a(d.k.ON_BACKGROUND_AUDIO_PREEMPTED);
        }

        @Override // com.tencent.luggage.wxa.pi.a.b
        public void onResume() {
            c.this.f138610a.a(d.k.ON_BACKGROUND_AUDIO_RESUMED);
        }

        @Override // com.tencent.luggage.wxa.pi.a.b
        public void onStop() {
            c.this.f138610a.a(d.k.ON_BACKGROUND_AUDIO_STOPPED);
        }

        @Override // com.tencent.luggage.wxa.pi.a.b
        public void b() {
        }
    }

    public boolean a() {
        return this.f138610a.o();
    }
}
