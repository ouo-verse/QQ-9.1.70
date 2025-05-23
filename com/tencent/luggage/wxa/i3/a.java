package com.tencent.luggage.wxa.i3;

import com.tencent.luggage.wxa.hn.x0;
import com.tencent.luggage.wxa.hn.y0;
import com.tencent.luggage.wxa.i3.x;
import com.tencent.luggage.wxa.mc.j0;
import com.tencent.luggage.wxa.xo.e;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class a implements com.tencent.luggage.wxa.uo.b {

    /* renamed from: b, reason: collision with root package name */
    public final String f129198b;

    /* renamed from: c, reason: collision with root package name */
    public final String f129199c;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.i3.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6271a implements e.c {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Object f129201b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xo.b f129202c;

        public C6271a(Object obj, com.tencent.luggage.wxa.xo.b bVar) {
            this.f129201b = obj;
            this.f129202c = bVar;
        }

        @Override // com.tencent.luggage.wxa.xo.e.c
        public final void a(y0 y0Var) {
            com.tencent.luggage.wxa.tn.w.d(a.this.f129199c, "onTerminate ErrCode[" + y0Var.f129051e.f128970d + ']');
            int i3 = y0Var.f129051e.f128970d;
            if (i3 == -13003) {
                a.this.a(this.f129201b, x.e.GET_DEMO_INFO, x.d.FAIL, "MM_ERR_BIZ_USER_NOT_IN_WHITE_LIST");
                this.f129202c.a(new com.tencent.luggage.wxa.j3.b(3, null, 2, null));
                return;
            }
            if (i3 == -13002) {
                a.this.a(this.f129201b, x.e.GET_DEMO_INFO, x.d.FAIL, "MM_ERR_BIZ_DEMO_HAS_BEEN_DELETED");
                this.f129202c.a(new com.tencent.luggage.wxa.j3.b(4, null, 2, null));
                return;
            }
            if (i3 != 0) {
                a.this.a(this.f129201b, x.e.GET_DEMO_INFO, x.d.FAIL, "ERR_NETWORK:UNKNOWN(" + i3 + ')');
                this.f129202c.a(new com.tencent.luggage.wxa.j3.b(1, "UNKNOWN(" + i3 + ')'));
                return;
            }
            if (y0Var.f129052f) {
                String str = y0Var.f129054h;
                if (!(str == null || str.length() == 0)) {
                    String str2 = y0Var.f129053g;
                    if (!(str2 == null || str2.length() == 0)) {
                        j0.a().a(a.this.f129198b, 2, y0Var.f129053g, y0Var.f129054h);
                    }
                }
            }
            String str3 = y0Var.f129058l;
            if (!(str3 == null || str3.length() == 0)) {
                com.tencent.luggage.wxa.ii.h.a().a(a.this.f129198b, 2, y0Var.f129058l);
            }
            a.a(a.this, this.f129201b, x.e.GET_DEMO_INFO, x.d.OK, null, 8, null);
            this.f129202c.a(this.f129201b);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b implements e.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Object f129204b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xo.b f129205c;

        public b(Object obj, com.tencent.luggage.wxa.xo.b bVar) {
            this.f129204b = obj;
            this.f129205c = bVar;
        }

        @Override // com.tencent.luggage.wxa.xo.e.a
        public final void a(Object obj) {
            String str;
            if (obj instanceof Throwable) {
                str = ((Throwable) obj).getMessage();
            } else if (obj != null) {
                str = obj.toString();
            } else {
                str = null;
            }
            com.tencent.luggage.wxa.tn.w.b(a.this.f129199c, "onInterrupt " + str);
            a.this.a(this.f129204b, x.e.GET_DEMO_INFO, x.d.FAIL, str);
            this.f129205c.a(new com.tencent.luggage.wxa.j3.b(1, str));
        }
    }

    public a(String appId) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        this.f129198b = appId;
        this.f129199c = "BonusStepCheckDemoInfo[" + appId + ']';
    }

    @Override // com.tencent.luggage.wxa.uo.b
    public Object call(Object obj) {
        a(this, obj, x.e.GET_DEMO_INFO, x.d.START, null, 8, null);
        if (!com.tencent.luggage.wxa.o3.l.f136139a.c()) {
            com.tencent.luggage.wxa.xo.h.a().a(obj);
        } else {
            com.tencent.luggage.wxa.xo.b b16 = com.tencent.luggage.wxa.xo.h.b();
            com.tencent.luggage.wxa.n3.f fVar = com.tencent.luggage.wxa.n3.f.f135165b;
            String str = this.f129198b;
            x0 x0Var = new x0();
            x0Var.f128983e = this.f129198b;
            Unit unit = Unit.INSTANCE;
            fVar.a(str, x0Var, y0.class).a(new C6271a(obj, b16)).a(new b(obj, b16));
        }
        return obj;
    }

    public static /* synthetic */ void a(a aVar, Object obj, x.e eVar, x.d dVar, String str, int i3, Object obj2) {
        if ((i3 & 8) != 0) {
            str = null;
        }
        aVar.a(obj, eVar, dVar, str);
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
