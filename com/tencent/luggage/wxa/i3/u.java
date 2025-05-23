package com.tencent.luggage.wxa.i3;

import android.text.TextUtils;
import android.util.Log;
import com.tencent.luggage.wxa.bj.a;
import com.tencent.luggage.wxa.fd.n0;
import com.tencent.luggage.wxa.fd.o0;
import com.tencent.luggage.wxa.hn.e9;
import com.tencent.luggage.wxa.hn.h0;
import com.tencent.luggage.wxa.hn.se;
import com.tencent.luggage.wxa.i3.x;
import com.tencent.luggage.wxa.ii.b;
import com.tencent.luggage.wxa.mc.e;
import com.tencent.luggage.wxa.n3.g0;
import com.tencent.luggage.wxa.tn.c0;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.xo.e;
import com.tencent.mobileqq.R;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;

/* compiled from: P */
/* loaded from: classes8.dex */
public class u {

    /* renamed from: a, reason: collision with root package name */
    public final com.tencent.luggage.wxa.ki.a f129359a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f129360b = false;

    /* renamed from: c, reason: collision with root package name */
    public final String f129361c;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements com.tencent.luggage.wxa.uo.b {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f129362b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f129363c;

        public a(String str, long j3) {
            this.f129362b = str;
            this.f129363c = j3;
        }

        @Override // com.tencent.luggage.wxa.uo.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.tencent.luggage.wxa.j4.d call(com.tencent.luggage.wxa.j4.d dVar) {
            int i3 = 0;
            com.tencent.luggage.wxa.tn.w.d("Luggage.Standalone.WxaLaunchPreconditionProcess", "fill mmUserId, hash:%d, config:%s", Integer.valueOf(u.this.hashCode()), dVar);
            com.tencent.luggage.wxa.lk.j.c(this.f129362b, "public:prepare", "WxaAttrSync#InitConfigReady");
            if (dVar != null) {
                com.tencent.luggage.wxa.o3.l lVar = com.tencent.luggage.wxa.o3.l.f136139a;
                if (lVar.c()) {
                    i3 = lVar.a().h();
                }
                dVar.f130798j0 = i3;
                if (dVar.m()) {
                    com.tencent.luggage.wxa.gi.b.a(this.f129362b, com.tencent.luggage.wxa.ik.a.f130623d, "", this.f129363c, w0.c());
                } else {
                    com.tencent.luggage.wxa.gi.b.a(this.f129362b, com.tencent.luggage.wxa.ik.a.f130622c, "", this.f129363c, w0.c());
                }
                com.tencent.luggage.wxa.gi.b.b(this.f129362b, com.tencent.luggage.wxa.ik.a.f130621b);
                return dVar;
            }
            com.tencent.luggage.wxa.gi.b.a(this.f129362b, com.tencent.luggage.wxa.ik.a.f130621b);
            return null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements com.tencent.luggage.wxa.uo.b {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f129365b;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class a implements b.a {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxa.xo.b f129367a;

            public a(com.tencent.luggage.wxa.xo.b bVar) {
                this.f129367a = bVar;
            }

            @Override // com.tencent.luggage.wxa.ii.b.a
            public void a(com.tencent.luggage.wxa.j4.d dVar, com.tencent.luggage.wxa.bk.e eVar, int i3) {
                String str;
                if (dVar != null) {
                    dVar.a(u.this.f129361c);
                    dVar.a(u.this.f129360b);
                    com.tencent.luggage.wxa.tn.w.d("Luggage.Standalone.WxaLaunchPreconditionProcess", "AppBrandPreLaunchProcess.onResult, hash:%d, do wormhole with config:%s", Integer.valueOf(u.this.hashCode()), dVar);
                    this.f129367a.a(dVar);
                    x xVar = x.f129431a;
                    u uVar = u.this;
                    String str2 = uVar.f129361c;
                    x.e eVar2 = x.e.GET_ATTRS;
                    x.d dVar2 = x.d.OK;
                    if (uVar.f129360b) {
                        str = "SYNC";
                    } else {
                        str = "ASYNC";
                    }
                    xVar.a(str2, eVar2, dVar2, str);
                    return;
                }
                com.tencent.luggage.wxa.tn.w.b("Luggage.Standalone.WxaLaunchPreconditionProcess", "AppBrandPreLaunchProcess.onResult, hash:%d, get NULL config, appId:%s, versionType:%d, stack:%s", Integer.valueOf(u.this.hashCode()), u.this.f129359a.f132018b, Integer.valueOf(u.this.f129359a.f132022d), Log.getStackTraceString(new Throwable()));
                if (!u.this.f129360b) {
                    b bVar = b.this;
                    v.a(bVar.f129365b, u.this.f129359a.f132016a, "AppBrandPreLaunchProcess.onResult get NULL config");
                }
                this.f129367a.a((Object) null);
                x.f129431a.a(u.this.f129361c, x.e.GET_ATTRS, x.d.FAIL, null);
            }
        }

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.i3.u$b$b, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC6281b implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxa.ii.b f129369a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxa.xo.b f129370b;

            public RunnableC6281b(com.tencent.luggage.wxa.ii.b bVar, com.tencent.luggage.wxa.xo.b bVar2) {
                this.f129369a = bVar;
                this.f129370b = bVar2;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    this.f129369a.run();
                } catch (com.tencent.luggage.wxa.j3.a e16) {
                    e = e16;
                    this.f129370b.a(e);
                } catch (com.tencent.luggage.wxa.j3.b e17) {
                    e = e17;
                    this.f129370b.a(e);
                } catch (IllegalStateException e18) {
                    if (w0.d(e18.getMessage()).contains("attempt to re-open an already-closed object")) {
                        com.tencent.luggage.wxa.tn.w.a("Luggage.Standalone.WxaLaunchPreconditionProcess", e18, "prepare initConfig with appId[%s]", u.this.f129359a.f132018b);
                        this.f129370b.a(e18);
                        x.f129431a.a(u.this.f129361c, x.e.GET_ATTRS, x.d.FAIL, e18.getMessage());
                    }
                }
            }
        }

        public b(String str) {
            this.f129365b = str;
        }

        @Override // com.tencent.luggage.wxa.uo.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.tencent.luggage.wxa.j4.d call(Boolean bool) {
            com.tencent.luggage.wxa.lk.j.c(this.f129365b, "public:prepare", "WxaAttrSync");
            com.tencent.luggage.wxa.xo.b b16 = com.tencent.luggage.wxa.xo.h.b();
            u uVar = u.this;
            com.tencent.luggage.wxa.zp.h.f146825d.execute(new RunnableC6281b(new d(uVar.f129359a, new a(b16)), b16));
            return null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements com.tencent.luggage.wxa.uo.b {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f129372b;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class a implements e.a {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxa.xo.b f129374a;

            public a(com.tencent.luggage.wxa.xo.b bVar) {
                this.f129374a = bVar;
            }

            @Override // com.tencent.luggage.wxa.xo.e.a
            public void a(Object obj) {
                String obj2;
                if (obj instanceof Exception) {
                    this.f129374a.a(obj);
                    return;
                }
                if (obj == null) {
                    obj2 = null;
                } else {
                    obj2 = obj.toString();
                }
                this.f129374a.a(new com.tencent.luggage.wxa.bj.a(a.EnumC6074a.TRANSFER, -1, obj2));
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class b implements e.c {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxa.xo.b f129376a;

            public b(com.tencent.luggage.wxa.xo.b bVar) {
                this.f129376a = bVar;
            }

            @Override // com.tencent.luggage.wxa.xo.e.c
            public void a(se seVar) {
                h0 h0Var;
                if (seVar != null && (h0Var = seVar.f128743d) != null) {
                    if (h0Var.f127731d == 0) {
                        u.this.f129360b = true;
                        o0.a().b(c.this.f129372b, seVar);
                        this.f129376a.a(Boolean.TRUE);
                        return;
                    }
                    a.EnumC6074a enumC6074a = a.EnumC6074a.RECV;
                    h0 h0Var2 = seVar.f128743d;
                    com.tencent.luggage.wxa.bj.a aVar = new com.tencent.luggage.wxa.bj.a(enumC6074a, h0Var2.f127731d, u.b(h0Var2.f127732e));
                    this.f129376a.a(aVar);
                    x.f129431a.a(u.this.f129361c, x.e.GET_ATTRS, x.d.FAIL, aVar);
                    com.tencent.luggage.wxa.gi.b.a(c.this.f129372b, com.tencent.luggage.wxa.ik.a.f130623d);
                    com.tencent.luggage.wxa.gi.b.a(c.this.f129372b, com.tencent.luggage.wxa.ik.a.f130621b);
                    return;
                }
                this.f129376a.a(new com.tencent.luggage.wxa.bj.a(a.EnumC6074a.RECV, -1, "Response is NULL"));
            }
        }

        public c(String str) {
            this.f129372b = str;
        }

        @Override // com.tencent.luggage.wxa.uo.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean call(Void r56) {
            try {
                if (!o0.a().a(u.this.f129359a.f132018b)) {
                    com.tencent.luggage.wxa.xo.b b16 = com.tencent.luggage.wxa.xo.h.b();
                    g0.b(this.f129372b).a(new b(b16)).a(new a(b16));
                    return Boolean.FALSE;
                }
                return Boolean.TRUE;
            } catch (Exception e16) {
                com.tencent.luggage.wxa.xo.h.a().a(e16);
                x.f129431a.a(u.this.f129361c, x.e.GET_ATTRS, x.d.FAIL, e16.getMessage());
                return Boolean.FALSE;
            }
        }
    }

    public u(com.tencent.luggage.wxa.ki.a aVar, String str) {
        this.f129359a = aVar;
        if (!TextUtils.isEmpty(str)) {
            this.f129361c = str;
        } else {
            this.f129361c = s.a(aVar);
        }
        x xVar = x.f129431a;
        String str2 = this.f129361c;
        Objects.requireNonNull(str2);
        xVar.a(str2, aVar);
    }

    public static String b(e9 e9Var) {
        if (e9Var == null) {
            return null;
        }
        return e9Var.toString();
    }

    public com.tencent.luggage.wxa.xo.d a() {
        com.tencent.luggage.wxa.tn.w.d("Luggage.Standalone.WxaLaunchPreconditionProcess", "start() %d, %s", Integer.valueOf(hashCode()), this.f129359a);
        x.f129431a.a(this.f129361c, x.e.GET_ATTRS, x.d.START);
        String str = this.f129359a.f132018b;
        com.tencent.luggage.wxa.gi.b.c(str, com.tencent.luggage.wxa.ik.a.f130621b);
        return com.tencent.luggage.wxa.xo.h.c().c(new c(str)).c(new b(str)).c(new a(str, w0.c()));
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class d extends com.tencent.luggage.wxa.ii.b {

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class a implements e.a {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxa.tk.i f129379a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ CountDownLatch f129380b;

            public a(com.tencent.luggage.wxa.tk.i iVar, CountDownLatch countDownLatch) {
                this.f129379a = iVar;
                this.f129380b = countDownLatch;
            }

            @Override // com.tencent.luggage.wxa.xo.e.a
            public void a(Object obj) {
                this.f129379a.f141499a = obj;
                this.f129380b.countDown();
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class b implements e.c {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxa.tk.i f129382a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ CountDownLatch f129383b;

            public b(com.tencent.luggage.wxa.tk.i iVar, CountDownLatch countDownLatch) {
                this.f129382a = iVar;
                this.f129383b = countDownLatch;
            }

            @Override // com.tencent.luggage.wxa.xo.e.c
            public void a(s sVar) {
                this.f129382a.f141499a = sVar;
                this.f129383b.countDown();
            }
        }

        public d(com.tencent.luggage.wxa.ki.a aVar, b.a aVar2) {
            super(aVar, aVar2);
        }

        public final boolean a(com.tencent.luggage.wxa.uo.b bVar) {
            CountDownLatch countDownLatch = new CountDownLatch(1);
            com.tencent.luggage.wxa.tk.i iVar = new com.tencent.luggage.wxa.tk.i();
            com.tencent.luggage.wxa.xo.d c16 = com.tencent.luggage.wxa.xo.h.a(new s(u.this.f129361c)).c(bVar);
            com.tencent.luggage.wxa.yo.g gVar = com.tencent.luggage.wxa.yo.d.f146045b;
            c16.a(gVar, new b(iVar, countDownLatch)).a(gVar, new a(iVar, countDownLatch));
            try {
                countDownLatch.await();
                if (!(iVar.f141499a instanceof com.tencent.luggage.wxa.j3.a)) {
                    if (!(iVar.f141499a instanceof com.tencent.luggage.wxa.j3.b)) {
                        return !(iVar.f141499a instanceof s);
                    }
                    throw ((com.tencent.luggage.wxa.j3.b) iVar.f141499a);
                }
                throw ((com.tencent.luggage.wxa.j3.a) iVar.f141499a);
            } catch (InterruptedException e16) {
                com.tencent.luggage.wxa.tn.w.b("Luggage.Standalone.WxaLaunchPreconditionProcess", "checkBanDemoPermission with appId[%s] await failed e=%s", this.f130428e, e16);
                return true;
            }
        }

        public final boolean c() {
            int i3 = this.f130426c;
            if (i3 == 2) {
                return a(new com.tencent.luggage.wxa.i3.a(this.f130428e));
            }
            if (i3 != 1) {
                return false;
            }
            if (u.this.f129359a.f132032i != null && u.this.f129359a.f132032i.f122984c == 1011) {
                return false;
            }
            return a(new com.tencent.luggage.wxa.i3.b(this.f130428e));
        }

        @Override // com.tencent.luggage.wxa.ii.b
        public boolean a(n0 n0Var, boolean z16) {
            if (e.a.b(this.f130426c) && 1 == n0Var.h().f125922c) {
                c0.a(new Runnable() { // from class: com.tencent.luggage.wxa.i3.z
                    @Override // java.lang.Runnable
                    public final void run() {
                        com.tencent.luggage.wxa.y9.a.makeText(com.tencent.luggage.wxa.tn.z.c(), R.string.yzh, 1).show();
                    }
                });
                if (!z16) {
                    v.a(this.f130428e, this.f130429f, "OffShelf");
                }
                return true;
            }
            return c();
        }
    }
}
