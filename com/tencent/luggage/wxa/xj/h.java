package com.tencent.luggage.wxa.xj;

import android.os.Looper;
import com.tencent.luggage.wxa.tn.e0;
import com.tencent.luggage.wxa.tn.w;

/* compiled from: P */
/* loaded from: classes9.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    public int f145109a = 0;

    /* renamed from: b, reason: collision with root package name */
    public c f145110b = null;

    /* renamed from: c, reason: collision with root package name */
    public e0 f145111c;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f145112a;

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.xj.h$a$a, reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class C6917a implements e0.a {
            public C6917a() {
            }

            @Override // com.tencent.luggage.wxa.tn.e0.a
            public boolean a() {
                w.f("MicroMsg.AppBrandDeviceOrientationRetrier", "hy: still not cancelled, trigger retry");
                h.e(h.this);
                if (h.this.f145109a > 3) {
                    if (h.this.f145110b != null) {
                        h.this.f145110b.b();
                        return false;
                    }
                    return false;
                }
                if (h.this.f145110b != null) {
                    h.this.f145110b.a();
                    return true;
                }
                return true;
            }
        }

        public a(c cVar) {
            this.f145112a = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            h.this.b();
            h.this.f145110b = this.f145112a;
            h.this.f145111c = new e0(Looper.getMainLooper(), (e0.a) new C6917a(), true);
            h.this.f145111c.a(500L, 500L);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            w.d("MicroMsg.AppBrandDeviceOrientationRetrier", "cancelTikTok reset");
            h.this.b();
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface c {
        void a();

        void b();
    }

    public static /* synthetic */ int e(h hVar) {
        int i3 = hVar.f145109a;
        hVar.f145109a = i3 + 1;
        return i3;
    }

    public final void b() {
        e0 e0Var = this.f145111c;
        if (e0Var != null) {
            e0Var.f();
        }
        this.f145109a = 0;
        this.f145110b = null;
    }

    public void a(c cVar) {
        com.tencent.luggage.wxa.zp.h.f146825d.a(new a(cVar));
    }

    public void a() {
        w.d("MicroMsg.AppBrandDeviceOrientationRetrier", "cancelTickTok");
        com.tencent.luggage.wxa.zp.h.f146825d.a(new b());
    }
}
