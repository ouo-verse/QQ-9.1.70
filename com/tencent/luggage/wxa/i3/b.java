package com.tencent.luggage.wxa.i3;

import com.tencent.luggage.wxa.i3.x;
import com.tencent.luggage.wxa.xo.e;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class b implements com.tencent.luggage.wxa.uo.b {

    /* renamed from: b, reason: collision with root package name */
    public final String f129206b;

    /* renamed from: c, reason: collision with root package name */
    public final String f129207c;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements e.c {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Object f129209b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xo.b f129210c;

        public a(Object obj, com.tencent.luggage.wxa.xo.b bVar) {
            this.f129209b = obj;
            this.f129210c = bVar;
        }

        @Override // com.tencent.luggage.wxa.xo.e.c
        public final void a(Boolean bool) {
            com.tencent.luggage.wxa.tn.w.d(b.this.f129207c, "onTerminate appId:" + b.this.f129206b);
            b.a(b.this, this.f129209b, x.e.GET_WXA_DEBUG_INFO, x.d.OK, null, 8, null);
            this.f129210c.a(this.f129209b);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.i3.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6272b implements e.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xo.b f129211a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Object f129212b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ b f129213c;

        public C6272b(com.tencent.luggage.wxa.xo.b bVar, Object obj, b bVar2) {
            this.f129211a = bVar;
            this.f129212b = obj;
            this.f129213c = bVar2;
        }

        @Override // com.tencent.luggage.wxa.xo.e.a
        public final void a(Object obj) {
            String str;
            if (obj instanceof com.tencent.luggage.wxa.j3.a) {
                com.tencent.luggage.wxa.j3.a aVar = (com.tencent.luggage.wxa.j3.a) obj;
                int a16 = aVar.a();
                if (a16 != 2) {
                    if (a16 == 3) {
                        this.f129213c.a(this.f129212b, x.e.GET_WXA_DEBUG_INFO, x.d.FAIL, "ERR_INVALID_APPID");
                    } else if (a16 == 4) {
                        this.f129213c.a(this.f129212b, x.e.GET_WXA_DEBUG_INFO, x.d.FAIL, "ERR_NO_PERMISSION");
                    } else if (a16 == 5) {
                        this.f129213c.a(this.f129212b, x.e.GET_WXA_DEBUG_INFO, x.d.FAIL, "ERR_NO_DEVCODE");
                    } else if (a16 != 6) {
                        this.f129213c.a(this.f129212b, x.e.GET_WXA_DEBUG_INFO, x.d.FAIL, aVar.getMessage());
                    } else {
                        this.f129213c.a(this.f129212b, x.e.GET_WXA_DEBUG_INFO, x.d.FAIL, "ERR_MISS_DATA");
                    }
                } else {
                    this.f129211a.a(this.f129212b);
                }
                this.f129211a.a(obj);
                return;
            }
            if (obj instanceof Throwable) {
                str = ((Throwable) obj).getMessage();
            } else if (obj != null) {
                str = obj.toString();
            } else {
                str = null;
            }
            com.tencent.luggage.wxa.tn.w.b(this.f129213c.f129207c, "onInterrupt " + str);
            this.f129213c.a(this.f129212b, x.e.GET_WXA_DEBUG_INFO, x.d.FAIL, str);
            this.f129211a.a(new com.tencent.luggage.wxa.j3.a(1, str));
        }
    }

    public b(String appId) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        this.f129206b = appId;
        this.f129207c = "BonusStepCheckWxaDebugInfo[" + appId + ']';
    }

    @Override // com.tencent.luggage.wxa.uo.b
    public Object call(Object obj) {
        a(this, obj, x.e.GET_WXA_DEBUG_INFO, x.d.START, null, 8, null);
        com.tencent.luggage.wxa.xo.b b16 = com.tencent.luggage.wxa.xo.h.b();
        com.tencent.luggage.wxa.n3.k.b(this.f129206b, 1).a(new a(obj, b16)).a(new C6272b(b16, obj, this));
        return obj;
    }

    public static /* synthetic */ void a(b bVar, Object obj, x.e eVar, x.d dVar, String str, int i3, Object obj2) {
        if ((i3 & 8) != 0) {
            str = null;
        }
        bVar.a(obj, eVar, dVar, str);
    }

    public final void a(Object obj, x.e eVar, x.d dVar, String str) {
        if (obj instanceof com.tencent.luggage.wxa.j4.d) {
            x xVar = x.f129431a;
            String k3 = ((com.tencent.luggage.wxa.j4.d) obj).k();
            Intrinsics.checkNotNullExpressionValue(k3, "o.wxaLaunchInstanceId");
            xVar.a(k3, eVar, dVar, str);
            return;
        }
        if (obj instanceof s) {
            x.f129431a.a(((s) obj).a(), eVar, dVar, str);
        }
    }
}
