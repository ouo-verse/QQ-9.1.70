package com.tencent.luggage.wxa.x7;

import android.util.Log;
import com.tencent.luggage.wxa.n3.q0;
import com.tencent.luggage.wxa.n3.t;
import com.tencent.luggage.wxa.o3.l;
import com.tencent.luggage.wxa.q7.s;
import com.tencent.luggage.wxa.s3.h;
import com.tencent.luggage.wxa.tn.b0;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.z;
import cooperation.qzone.util.WnsError;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class a extends com.tencent.luggage.wxa.s3.a {

    /* renamed from: f, reason: collision with root package name */
    public static com.tencent.luggage.wxa.s3.h f144604f;

    /* renamed from: g, reason: collision with root package name */
    public static com.tencent.luggage.wxa.s3.g f144605g;

    /* renamed from: h, reason: collision with root package name */
    public static int f144606h;

    /* renamed from: k, reason: collision with root package name */
    public static volatile t f144609k;

    /* renamed from: d, reason: collision with root package name */
    public static final a f144602d = new a();

    /* renamed from: e, reason: collision with root package name */
    public static final b0 f144603e = new b0("DemoILinkActivateDevice");

    /* renamed from: i, reason: collision with root package name */
    public static final c f144607i = new c();

    /* renamed from: j, reason: collision with root package name */
    public static final byte[] f144608j = new byte[0];

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.x7.a$a, reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static final class RunnableC6902a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f144610a;

        public RunnableC6902a(Function1 function1) {
            this.f144610a = function1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            boolean z16;
            h.d F = a.f144602d.F();
            Function1 function1 = this.f144610a;
            if (h.d.SUCCESS == F) {
                z16 = true;
            } else {
                z16 = false;
            }
            function1.invoke(Boolean.valueOf(z16));
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class c implements h.a {
        @Override // com.tencent.luggage.wxa.s3.h.a
        public void onAllResourceNeedRecreate() {
            w.d("DemoILinkActivateDevice", "ilinkServiceCallback.onAllResourceNeedRecreate()");
            com.tencent.luggage.wxa.s3.h hVar = a.f144604f;
            if (hVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("ilinkManager");
                hVar = null;
            }
            hVar.b(this);
            a.f144602d.a0();
        }

        @Override // com.tencent.luggage.wxa.s3.h.a
        public /* synthetic */ void onUploadLogComplete(int i3) {
            b41.a.b(this, i3);
        }
    }

    @Override // com.tencent.luggage.wxa.s3.c
    public boolean B() {
        boolean z16;
        synchronized (this) {
            if (f144606h == 2) {
                z16 = true;
            } else {
                z16 = false;
            }
        }
        return z16;
    }

    @Override // com.tencent.luggage.wxa.s3.c
    public h.d F() {
        int i3;
        com.tencent.luggage.wxa.s3.h i16 = com.tencent.luggage.wxa.s3.h.i();
        Intrinsics.checkNotNullExpressionValue(i16, "getInstance()");
        f144604f = i16;
        com.tencent.luggage.wxa.s3.h hVar = null;
        if (i16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ilinkManager");
            i16 = null;
        }
        h.b bVar = h.b.APP_MODE;
        com.tencent.luggage.wxa.s3.g Y = Y();
        if (Y != null) {
            i3 = Y.c();
        } else {
            i3 = 0;
        }
        i16.a(bVar, i3);
        com.tencent.luggage.wxa.s3.h hVar2 = f144604f;
        if (hVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ilinkManager");
            hVar2 = null;
        }
        c cVar = f144607i;
        hVar2.b(cVar);
        com.tencent.luggage.wxa.s3.h hVar3 = f144604f;
        if (hVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ilinkManager");
            hVar3 = null;
        }
        hVar3.a(cVar);
        synchronized (this) {
            f144606h = 1;
            Unit unit = Unit.INSTANCE;
        }
        com.tencent.luggage.wxa.s3.g Y2 = Y();
        if (Y2 == null) {
            synchronized (this) {
                f144606h = 0;
            }
            w.b("DemoILinkActivateDevice", "loginIlink INVALID_PARAMS");
            return h.d.INVALID_PARAMS;
        }
        com.tencent.luggage.wxa.s3.h hVar4 = f144604f;
        if (hVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ilinkManager");
        } else {
            hVar = hVar4;
        }
        h.d b16 = hVar.b(Y2);
        synchronized (this) {
            if (b16 != h.d.TIME_OUT && b16 != h.d.START_ILINK_PROCESS_FAILED) {
                f144606h = 2;
            }
            f144606h = 0;
        }
        f144602d.k();
        w.d("DemoILinkActivateDevice", "loginIlink ret:" + b16);
        w.c();
        Intrinsics.checkNotNullExpressionValue(b16, "ilinkManager.loginDevice\u2026FlushSync()\n            }");
        return b16;
    }

    public final com.tencent.luggage.wxa.s3.g Y() {
        boolean z16;
        com.tencent.luggage.wxa.s3.g gVar = f144605g;
        if (gVar != null) {
            return gVar;
        }
        f fVar = f.f144620c;
        s.d dVar = s.d.f138074a;
        String a16 = fVar.a(dVar.b());
        if (a16 != null && a16.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            w.b("DemoILinkActivateDevice", "getOrCreateDemoIlinkDeviceInfo return NULL by empty ilinkappid");
            return null;
        }
        f144605g = new com.tencent.luggage.wxa.s3.g(WnsError.WNS_CODE_LOGIN_PTLOGIN_BUSY, 0, l.f136139a.h(), "signature", dVar.b(), a16);
        s d16 = dVar.d();
        if (d16 != null && d16.getDebugApi().getIsDebugIP()) {
            com.tencent.luggage.wxa.s3.g gVar2 = f144605g;
            if (gVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("demoIlinkDeviceInfo");
                gVar2 = null;
            }
            gVar2.a(d16.getDebugApi().getDebugIP());
            com.tencent.luggage.wxa.s3.g gVar3 = f144605g;
            if (gVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("demoIlinkDeviceInfo");
                gVar3 = null;
            }
            gVar3.a(1);
        }
        com.tencent.luggage.wxa.s3.g gVar4 = f144605g;
        if (gVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("demoIlinkDeviceInfo");
            return null;
        }
        return gVar4;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.tencent.luggage.wxa.x7.a$b] */
    public final t Z() {
        t tVar;
        synchronized (f144608j) {
            tVar = (t) new MutablePropertyReference0Impl(f144602d) { // from class: com.tencent.luggage.wxa.x7.a.b
                @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
                public Object get() {
                    return a.f144609k;
                }

                @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
                public void set(Object obj) {
                    a.f144609k = (t) obj;
                }
            }.get();
        }
        return tVar;
    }

    public final void a0() {
        w.d("DemoILinkActivateDevice", "recreateTdiSession stack:" + Log.getStackTraceString(new Throwable()));
        synchronized (this) {
            f144606h = 0;
            com.tencent.luggage.wxa.s3.h hVar = f144604f;
            if (hVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("ilinkManager");
                hVar = null;
            }
            hVar.c();
            synchronized (f144608j) {
                f144609k = null;
                Unit unit = Unit.INSTANCE;
            }
        }
        q0.f135244a.a(true);
    }

    public final void b(boolean z16, boolean z17) {
        t Z = Z();
        if (Z != null) {
            Z.v();
            Z.b();
            l.f136139a.b();
        }
        s.d.f138074a.a(0L);
        if (z16) {
            f.f144620c.clear();
        }
        if (z17) {
            com.tencent.luggage.wxa.s3.h.i().d();
            com.tencent.luggage.wxa.en.a.b(z.c(), "com.tencent.ilink.ServiceProcess");
        }
    }

    @Override // com.tencent.luggage.wxa.s3.c
    public boolean g() {
        return true;
    }

    @Override // com.tencent.luggage.wxa.s3.c
    public void init() {
        com.tencent.luggage.wxa.s3.h.i().m();
    }

    @Override // com.tencent.luggage.wxa.s3.c
    public t k() {
        String str;
        synchronized (f144608j) {
            if (f144609k == null) {
                com.tencent.luggage.wxa.s3.h hVar = null;
                if (!e.f144619a.a()) {
                    w.f("DemoILinkActivateDevice", "getTdiSession WxaDynamicPkgMgr.isLoaded()==false " + Log.getStackTraceString(new Throwable()));
                    return null;
                }
                com.tencent.luggage.wxa.s3.h hVar2 = f144604f;
                if (hVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("ilinkManager");
                    hVar2 = null;
                }
                f144609k = hVar2.j();
                if (f144609k == null) {
                    com.tencent.luggage.wxa.s3.g Y = f144602d.Y();
                    if (Y != null) {
                        str = Y.g();
                    } else {
                        str = null;
                    }
                    if (str == null) {
                        return null;
                    }
                    Intrinsics.checkNotNullExpressionValue(str, "getOrCreateDemoIlinkDevi\u2026ilinkAppId ?: return null");
                    com.tencent.luggage.wxa.s3.h hVar3 = f144604f;
                    if (hVar3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("ilinkManager");
                        hVar3 = null;
                    }
                    if (hVar3.b(str)) {
                        com.tencent.luggage.wxa.s3.h hVar4 = f144604f;
                        if (hVar4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("ilinkManager");
                        } else {
                            hVar = hVar4;
                        }
                        f144609k = hVar.j();
                    }
                }
            }
            return f144609k;
        }
    }

    @Override // com.tencent.luggage.wxa.s3.c
    public com.tencent.luggage.wxa.s3.g p() {
        com.tencent.luggage.wxa.s3.g Y = Y();
        if (Y != null) {
            return Y;
        }
        throw new com.tencent.luggage.wxa.s3.e("WMPFDeviceNotActivatedException");
    }

    public static /* synthetic */ void a(a aVar, boolean z16, boolean z17, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = true;
        }
        if ((i3 & 2) != 0) {
            z17 = false;
        }
        aVar.b(z16, z17);
    }

    public final void a(Function1 onComplete) {
        Intrinsics.checkNotNullParameter(onComplete, "onComplete");
        if (B()) {
            onComplete.invoke(Boolean.TRUE);
        } else {
            f144603e.a((Runnable) new RunnableC6902a(onComplete));
        }
    }
}
