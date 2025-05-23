package com.tencent.luggage.wxa.ef;

import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.xk.a;

/* compiled from: P */
/* loaded from: classes8.dex */
public class o extends com.tencent.luggage.wxa.wn.c implements com.tencent.luggage.wxa.xd.m {
    public final com.tencent.luggage.wxa.wn.b C;
    public final com.tencent.luggage.wxa.wn.b D;

    /* renamed from: d, reason: collision with root package name */
    public final com.tencent.luggage.wxa.ef.b f124716d;

    /* renamed from: e, reason: collision with root package name */
    public final com.tencent.luggage.wxa.ef.c f124717e;

    /* renamed from: f, reason: collision with root package name */
    public final a.b f124718f;

    /* renamed from: g, reason: collision with root package name */
    public Bundle f124719g;

    /* renamed from: h, reason: collision with root package name */
    public String f124720h;

    /* renamed from: i, reason: collision with root package name */
    public volatile boolean f124721i;

    /* renamed from: j, reason: collision with root package name */
    public volatile boolean f124722j;

    /* renamed from: k, reason: collision with root package name */
    public volatile boolean f124723k;

    /* renamed from: l, reason: collision with root package name */
    public e f124724l;

    /* renamed from: m, reason: collision with root package name */
    public final com.tencent.luggage.wxa.wn.b f124725m;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements a.b {
        public a() {
        }

        @Override // com.tencent.luggage.wxa.xk.a.b
        public void a(int i3, String str, a.C6919a c6919a) {
            if (i3 == 0) {
                o.this.f124716d.a(i3, str, c6919a);
            } else {
                o.this.f124717e.a(i3, str);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface e {
        void a(String str);
    }

    public o(com.tencent.luggage.wxa.xd.d dVar) {
        super("RuntimeLocationUpdateStateManager[" + dVar.getAppId() + "]", Looper.getMainLooper());
        this.f124718f = new a();
        this.f124721i = false;
        this.f124722j = false;
        this.f124723k = false;
        b bVar = new b();
        this.f124725m = bVar;
        c cVar = new c();
        this.C = cVar;
        d dVar2 = new d();
        this.D = dVar2;
        this.f124716d = new com.tencent.luggage.wxa.ef.b(dVar);
        this.f124717e = new com.tencent.luggage.wxa.ef.c(dVar);
        a((com.tencent.luggage.wxa.wn.b) bVar);
        a((com.tencent.luggage.wxa.wn.b) cVar);
        a((com.tencent.luggage.wxa.wn.b) dVar2);
        b(bVar);
    }

    public void n(String str) {
        e eVar = this.f124724l;
        if (eVar != null) {
            eVar.a(str);
        }
    }

    public void o(String str) {
        this.f124720h = str;
    }

    public boolean p() {
        return this.f124723k;
    }

    public boolean q() {
        return this.f124722j;
    }

    public void r() {
        if (!this.f124721i) {
            c(4);
        } else {
            this.f124721i = false;
        }
    }

    public void s() {
        this.f124721i = false;
        c(1);
    }

    public void t() {
        this.f124721i = false;
        c(2);
    }

    public void u() {
        this.f124721i = false;
        c(3);
    }

    public void v() {
        k();
    }

    public void o() {
        m();
    }

    public void b(boolean z16) {
        this.f124723k = z16;
    }

    public void n() {
        this.f124721i = true;
        c(2);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b extends com.tencent.luggage.wxa.wn.b {
        public b() {
        }

        @Override // com.tencent.luggage.wxa.wn.b
        public boolean a(Message message) {
            int i3 = message.what;
            if (1 == i3) {
                o oVar = o.this;
                oVar.a((com.tencent.luggage.wxa.wn.a) oVar.C);
                return true;
            }
            if (4 == i3) {
                o oVar2 = o.this;
                oVar2.a((com.tencent.luggage.wxa.wn.a) oVar2.C);
                return true;
            }
            return super.a(message);
        }

        @Override // com.tencent.luggage.wxa.wn.b, com.tencent.luggage.wxa.wn.a
        public String getName() {
            return o.this.h() + "$StateListening";
        }

        @Override // com.tencent.luggage.wxa.wn.b
        public void a() {
            super.a();
            w.d("MicroMsg.RuntimeLocationUpdateStateManager", "enter stateNotListening");
            ((com.tencent.luggage.wxa.xk.a) com.tencent.luggage.wxa.h1.e.a(com.tencent.luggage.wxa.xk.a.class)).unregisterLocation(o.this.f124720h, o.this.f124718f, o.this.f124719g);
            o.this.f124722j = false;
            o.this.n("StateNotListening");
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class d extends com.tencent.luggage.wxa.wn.b {
        public d() {
        }

        @Override // com.tencent.luggage.wxa.wn.b
        public boolean a(Message message) {
            int i3 = message.what;
            if (2 == i3) {
                o oVar = o.this;
                oVar.a((com.tencent.luggage.wxa.wn.a) oVar.f124725m);
                return true;
            }
            if (4 == i3) {
                o oVar2 = o.this;
                oVar2.a((com.tencent.luggage.wxa.wn.a) oVar2.C);
                return true;
            }
            return super.a(message);
        }

        @Override // com.tencent.luggage.wxa.wn.b, com.tencent.luggage.wxa.wn.a
        public String getName() {
            return o.this.h() + "$StateSuspend";
        }

        @Override // com.tencent.luggage.wxa.wn.b
        public void a() {
            super.a();
            w.d("MicroMsg.RuntimeLocationUpdateStateManager", "enter stateSuspend");
            o.this.n("StateSuspend");
        }
    }

    public void a(e eVar) {
        this.f124724l = eVar;
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c extends com.tencent.luggage.wxa.wn.b {
        public c() {
        }

        @Override // com.tencent.luggage.wxa.wn.b
        public void a() {
            super.a();
            w.d("MicroMsg.RuntimeLocationUpdateStateManager", "enter stateListening");
            ((com.tencent.luggage.wxa.xk.a) com.tencent.luggage.wxa.h1.e.a(com.tencent.luggage.wxa.xk.a.class)).registerLocation(o.this.f124720h, o.this.f124718f, o.this.f124719g);
            o.this.f124722j = true;
            o.this.n("StateListening");
        }

        @Override // com.tencent.luggage.wxa.wn.b
        public void b() {
            super.b();
            ((com.tencent.luggage.wxa.xk.a) com.tencent.luggage.wxa.h1.e.a(com.tencent.luggage.wxa.xk.a.class)).unregisterLocation(o.this.f124720h, o.this.f124718f, o.this.f124719g);
            o.this.f124722j = false;
            o.this.n("StateNotListening");
        }

        @Override // com.tencent.luggage.wxa.wn.b, com.tencent.luggage.wxa.wn.a
        public String getName() {
            return o.this.h() + "$StateNotListening";
        }

        @Override // com.tencent.luggage.wxa.wn.b
        public boolean a(Message message) {
            int i3 = message.what;
            if (2 == i3) {
                o oVar = o.this;
                oVar.a((com.tencent.luggage.wxa.wn.a) oVar.f124725m);
                return true;
            }
            if (3 == i3) {
                o oVar2 = o.this;
                oVar2.a((com.tencent.luggage.wxa.wn.a) oVar2.D);
                return true;
            }
            return super.a(message);
        }
    }

    public void a(Bundle bundle) {
        this.f124719g = bundle;
    }
}
