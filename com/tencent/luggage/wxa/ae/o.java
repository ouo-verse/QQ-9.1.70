package com.tencent.luggage.wxa.ae;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.tencent.luggage.wxa.ae.h;
import com.tencent.luggage.wxa.d5.a;
import com.tencent.luggage.wxa.hn.c5;
import com.tencent.luggage.wxa.hn.gf;
import com.tencent.luggage.wxa.hn.mb;
import com.tencent.luggage.wxa.hn.nb;
import com.tencent.luggage.wxa.hn.w5;
import com.tencent.luggage.wxa.hn.x5;
import com.tencent.luggage.wxa.tj.d;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.xd.f1;
import com.tencent.luggage.wxa.xo.e;
import com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader;
import com.tencent.mm.plugin.appbrand.platform.window.activity.WindowAndroidActivityImpl;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.mini.app.AuthorizeCenter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class o extends k implements h {

    @Deprecated
    public static final int CTRL_INDEX = 79;

    @Deprecated
    @NotNull
    public static final String NAME = "operateWXData";

    /* renamed from: a, reason: collision with root package name */
    public static final e f121178a = new e(null);

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements com.tencent.luggage.wxa.uo.b {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.ic.d f121179b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ o f121180c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f121181d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f121182e;

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.ae.o$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class RunnableC6002a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxa.ic.d f121183a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxa.xo.b f121184b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ o f121185c;

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ int f121186d;

            /* renamed from: e, reason: collision with root package name */
            public final /* synthetic */ String f121187e;

            /* renamed from: f, reason: collision with root package name */
            public final /* synthetic */ x5 f121188f;

            /* compiled from: P */
            /* renamed from: com.tencent.luggage.wxa.ae.o$a$a$a, reason: collision with other inner class name */
            /* loaded from: classes8.dex */
            public static final class C6003a implements a.b {

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ o f121189a;

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ com.tencent.luggage.wxa.ic.d f121190b;

                /* renamed from: c, reason: collision with root package name */
                public final /* synthetic */ com.tencent.luggage.wxa.d5.a f121191c;

                /* renamed from: d, reason: collision with root package name */
                public final /* synthetic */ com.tencent.luggage.wxa.ml.d f121192d;

                public C6003a(o oVar, com.tencent.luggage.wxa.ic.d dVar, com.tencent.luggage.wxa.d5.a aVar, com.tencent.luggage.wxa.ml.d dVar2) {
                    this.f121189a = oVar;
                    this.f121190b = dVar;
                    this.f121191c = aVar;
                    this.f121192d = dVar2;
                }

                @Override // com.tencent.luggage.wxa.d5.a.b
                public final void a(Bitmap bitmap) {
                    o oVar = this.f121189a;
                    oVar.a(oVar.a(this.f121190b), bitmap, this.f121191c.T(), AuthorizeCenter.SCOPE_USER_INFO, this.f121192d);
                }
            }

            /* compiled from: P */
            /* renamed from: com.tencent.luggage.wxa.ae.o$a$a$b */
            /* loaded from: classes8.dex */
            public static final class b implements com.tencent.luggage.wxa.d5.a {

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ x5 f121193a;

                /* compiled from: P */
                /* renamed from: com.tencent.luggage.wxa.ae.o$a$a$b$a, reason: collision with other inner class name */
                /* loaded from: classes8.dex */
                public static final class C6004a implements AppBrandSimpleImageLoader.m {

                    /* renamed from: a, reason: collision with root package name */
                    public final /* synthetic */ a.b f121194a;

                    public C6004a(a.b bVar) {
                        this.f121194a = bVar;
                    }

                    @Override // com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader.m
                    public void a() {
                    }

                    @Override // com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader.m, com.tencent.luggage.wxa.pb.a
                    public String b() {
                        return "JsApiOperateWXData";
                    }

                    @Override // com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader.m
                    public void a(Bitmap bitmap) {
                        a.b bVar = this.f121194a;
                        if (bVar != null) {
                            bVar.a(bitmap);
                        }
                    }

                    @Override // com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader.m
                    public void c() {
                    }
                }

                public b(x5 x5Var) {
                    this.f121193a = x5Var;
                }

                @Override // com.tencent.luggage.wxa.d5.a
                public Drawable H() {
                    return null;
                }

                @Override // com.tencent.luggage.wxa.d5.a
                public String T() {
                    LinkedList linkedList;
                    nb nbVar;
                    mb mbVar = this.f121193a.f129017o;
                    if (mbVar != null && (linkedList = mbVar.f128194d) != null && (nbVar = (nb) linkedList.peekFirst()) != null) {
                        return nbVar.f128291e;
                    }
                    return null;
                }

                @Override // com.tencent.luggage.wxa.d5.a
                public void a(a.b callback) {
                    String str;
                    boolean z16;
                    LinkedList linkedList;
                    nb nbVar;
                    Intrinsics.checkNotNullParameter(callback, "callback");
                    mb mbVar = this.f121193a.f129017o;
                    if (mbVar != null && (linkedList = mbVar.f128194d) != null && (nbVar = (nb) linkedList.peekFirst()) != null) {
                        str = nbVar.f128292f;
                    } else {
                        str = null;
                    }
                    if (str != null && str.length() != 0) {
                        z16 = false;
                    } else {
                        z16 = true;
                    }
                    if (!z16) {
                        AppBrandSimpleImageLoader.instance().load(new C6004a(callback), str, (AppBrandSimpleImageLoader.j) null);
                    } else {
                        callback.a(null);
                    }
                }
            }

            /* compiled from: P */
            /* renamed from: com.tencent.luggage.wxa.ae.o$a$a$c */
            /* loaded from: classes8.dex */
            public static final class c implements d.c {

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ int f121195a;

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ com.tencent.luggage.wxa.xo.b f121196b;

                /* renamed from: c, reason: collision with root package name */
                public final /* synthetic */ com.tencent.luggage.wxa.ic.d f121197c;

                /* renamed from: d, reason: collision with root package name */
                public final /* synthetic */ o f121198d;

                /* renamed from: e, reason: collision with root package name */
                public final /* synthetic */ String f121199e;

                public c(int i3, com.tencent.luggage.wxa.xo.b bVar, com.tencent.luggage.wxa.ic.d dVar, o oVar, String str) {
                    this.f121195a = i3;
                    this.f121196b = bVar;
                    this.f121197c = dVar;
                    this.f121198d = oVar;
                    this.f121199e = str;
                }

                @Override // com.tencent.luggage.wxa.tj.d.c
                public void a(int i3, ArrayList resultData, int i16, boolean z16) {
                    Object firstOrNull;
                    Intrinsics.checkNotNullParameter(resultData, "resultData");
                    w.d("Luggage.WXA.JsApiOperateWXDataLU", "dialog onMsg, resultCode[" + i3 + "], callbackId[" + this.f121195a + ']');
                    if (i3 == 1) {
                        w5 a16 = o.a(this.f121197c, this.f121198d, this.f121199e);
                        o oVar = this.f121198d;
                        com.tencent.luggage.wxa.xo.b m3 = this.f121196b;
                        com.tencent.luggage.wxa.ic.d dVar = this.f121197c;
                        a16.f128945h = 1;
                        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) resultData);
                        a16.f128944g = (String) firstOrNull;
                        Intrinsics.checkNotNullExpressionValue(m3, "m");
                        oVar.a(m3, h.f121074n.a(dVar, "/cgi-bin/mmbiz-bin/js-operatewxdata", a16, x5.class));
                        return;
                    }
                    if (i3 != 2) {
                        this.f121196b.a(new h.a("fail:auth canceled"));
                        return;
                    }
                    this.f121196b.a(new h.a("fail:auth denied"));
                    w5 a17 = o.a(this.f121197c, this.f121198d, this.f121199e);
                    com.tencent.luggage.wxa.ic.d dVar2 = this.f121197c;
                    a17.f128945h = 2;
                    h.f121074n.a(dVar2, "/cgi-bin/mmbiz-bin/js-operatewxdata", a17, x5.class);
                }
            }

            public RunnableC6002a(com.tencent.luggage.wxa.ic.d dVar, com.tencent.luggage.wxa.xo.b bVar, o oVar, int i3, String str, x5 x5Var) {
                this.f121183a = dVar;
                this.f121184b = bVar;
                this.f121185c = oVar;
                this.f121186d = i3;
                this.f121187e = str;
                this.f121188f = x5Var;
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.tencent.luggage.wxa.wj.c windowAndroidActivityImpl;
                boolean z16;
                if (!this.f121183a.isRunning()) {
                    this.f121184b.a(h.c.f121076a);
                    return;
                }
                c cVar = new c(this.f121186d, this.f121184b, this.f121183a, this.f121185c, this.f121187e);
                Context a16 = this.f121185c.a(this.f121183a);
                com.tencent.luggage.wxa.ic.g runtime = this.f121183a.getRuntime();
                if (runtime == null || (windowAndroidActivityImpl = runtime.n0()) == null) {
                    windowAndroidActivityImpl = new WindowAndroidActivityImpl();
                }
                com.tencent.luggage.wxa.ml.d dVar = new com.tencent.luggage.wxa.ml.d(a16, windowAndroidActivityImpl, cVar);
                x5 x5Var = this.f121188f;
                com.tencent.luggage.wxa.ic.d dVar2 = this.f121183a;
                o oVar = this.f121185c;
                dVar.b(x5Var.f129010h);
                dVar.h(x5Var.f129009g.f128169e);
                dVar.k(x5Var.f129016n);
                dVar.l(x5Var.f129014l);
                dVar.j(x5Var.f129015m);
                dVar.a(x5Var.f129011i);
                dVar.m("");
                com.tencent.luggage.wxa.wj.c D = dVar2.D();
                boolean z17 = false;
                if (D != null && D.isLargeScreenWindow()) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    dVar.d(1);
                }
                String sub_desc = x5Var.f129009g.f128173i;
                if (sub_desc != null) {
                    Intrinsics.checkNotNullExpressionValue(sub_desc, "sub_desc");
                    if (sub_desc.length() > 0) {
                        z17 = true;
                    }
                    if (z17) {
                        dVar.g(sub_desc);
                    }
                }
                if (Intrinsics.areEqual(AuthorizeCenter.SCOPE_USER_INFO, x5Var.f129009g.f128168d)) {
                    com.tencent.luggage.wxa.d5.a aVar = (com.tencent.luggage.wxa.d5.a) com.tencent.luggage.wxa.eo.g.a(com.tencent.luggage.wxa.d5.a.class);
                    if (aVar == null) {
                        aVar = new b(x5Var);
                    }
                    oVar.a(oVar.a(dVar2), (Bitmap) null, aVar.T(), AuthorizeCenter.SCOPE_USER_INFO, dVar);
                    aVar.a(new C6003a(oVar, dVar2, aVar, dVar));
                } else {
                    String str = x5Var.f129009g.f128168d;
                    Intrinsics.checkNotNullExpressionValue(str, "response.Scope.Scope");
                    dVar.i(str);
                }
                oVar.a(dVar2, dVar);
            }
        }

        public a(com.tencent.luggage.wxa.ic.d dVar, o oVar, int i3, String str) {
            this.f121179b = dVar;
            this.f121180c = oVar;
            this.f121181d = i3;
            this.f121182e = str;
        }

        @Override // com.tencent.luggage.wxa.uo.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final x5 call(x5 x5Var) {
            Integer num;
            c5 c5Var;
            if (x5Var != null && (c5Var = x5Var.f129007e) != null) {
                num = Integer.valueOf(c5Var.f127384d);
            } else {
                num = null;
            }
            if (num != null && num.intValue() == -12000) {
                com.tencent.luggage.wxa.zp.h.f146825d.a(new RunnableC6002a(this.f121179b, com.tencent.luggage.wxa.xo.h.b(), this.f121180c, this.f121181d, this.f121182e, x5Var));
                return null;
            }
            return x5Var;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c implements e.c {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g f121203a;

        public c(g gVar) {
            this.f121203a = gVar;
        }

        @Override // com.tencent.luggage.wxa.xo.e.c
        public final void a(Object obj) {
            g gVar = this.f121203a;
            if (gVar != null) {
                gVar.b();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class d implements e.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.ic.d f121204a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f121205b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ o f121206c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ JSONObject f121207d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ JSONObject f121208e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ g f121209f;

        public d(com.tencent.luggage.wxa.ic.d dVar, int i3, o oVar, JSONObject jSONObject, JSONObject jSONObject2, g gVar) {
            this.f121204a = dVar;
            this.f121205b = i3;
            this.f121206c = oVar;
            this.f121207d = jSONObject;
            this.f121208e = jSONObject2;
            this.f121209f = gVar;
        }

        @Override // com.tencent.luggage.wxa.xo.e.a
        public final void a(Object obj) {
            String str;
            g gVar;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("onInterrupt, appId[");
            sb5.append(this.f121204a.getAppId());
            sb5.append("], callbackId[");
            sb5.append(this.f121205b);
            sb5.append("], e[");
            if (obj != null) {
                str = obj.toString();
            } else {
                str = null;
            }
            sb5.append(str);
            sb5.append(']');
            w.d("Luggage.WXA.JsApiOperateWXDataLU", sb5.toString());
            try {
                if (obj instanceof h.c) {
                    if (gVar != null) {
                        return;
                    } else {
                        return;
                    }
                }
                if (obj instanceof h.a) {
                    this.f121204a.a(this.f121205b, this.f121206c.makeReturnJson("fail " + ((h.a) obj).getMessage()));
                } else if (obj instanceof Throwable) {
                    if (this.f121206c.a(this.f121204a, this.f121207d, this.f121208e, this.f121205b, this.f121209f, obj)) {
                        return;
                    }
                    this.f121204a.a(this.f121205b, this.f121206c.makeReturnJson("fail " + ((Throwable) obj).getMessage()));
                } else if (obj == null) {
                    this.f121204a.a(this.f121205b, this.f121206c.makeReturnJson("fail:internal error"));
                } else {
                    this.f121204a.a(this.f121205b, this.f121206c.makeReturnJson("fail " + obj));
                }
                g gVar2 = this.f121209f;
                if (gVar2 != null) {
                    gVar2.b();
                }
            } finally {
                gVar = this.f121209f;
                if (gVar != null) {
                    gVar.b();
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class e {
        public e() {
        }

        public /* synthetic */ e(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.tencent.luggage.wxa.ae.h
    public /* synthetic */ Context a(com.tencent.luggage.wxa.xd.d dVar) {
        return h.CC.a(this, dVar);
    }

    @Override // com.tencent.luggage.wxa.ae.h
    public /* synthetic */ com.tencent.luggage.wxa.fn.c a(String str) {
        return h.CC.b(this, str);
    }

    @Override // com.tencent.luggage.wxa.ae.h
    public /* synthetic */ gf a(gf gfVar, com.tencent.luggage.wxa.xd.d dVar) {
        return h.CC.c(this, gfVar, dVar);
    }

    @Override // com.tencent.luggage.wxa.ae.h
    public /* synthetic */ void a(Context context, Bitmap bitmap, String str, String str2, com.tencent.luggage.wxa.tj.d dVar) {
        h.CC.d(this, context, bitmap, str, str2, dVar);
    }

    @Override // com.tencent.luggage.wxa.ae.h
    public /* synthetic */ void a(com.tencent.luggage.wxa.xd.i iVar, com.tencent.luggage.wxa.ml.m mVar) {
        h.CC.e(this, iVar, mVar);
    }

    @Override // com.tencent.luggage.wxa.ae.h
    public /* synthetic */ void a(com.tencent.luggage.wxa.xo.b bVar, com.tencent.luggage.wxa.xo.d dVar) {
        h.CC.f(this, bVar, dVar);
    }

    public boolean a(com.tencent.luggage.wxa.ic.d dVar, JSONObject jSONObject, JSONObject jSONObject2, int i3, g gVar, Object obj) {
        return false;
    }

    @Override // com.tencent.luggage.wxa.ae.k
    public void a(f1 invokeContext, g gVar) {
        Intrinsics.checkNotNullParameter(invokeContext, "invokeContext");
        com.tencent.luggage.wxa.ic.d dVar = (com.tencent.luggage.wxa.ic.d) invokeContext.f();
        JSONObject e16 = invokeContext.e();
        JSONObject g16 = invokeContext.g();
        int d16 = invokeContext.d();
        String optString = e16.optString("data", null);
        if (optString == null) {
            dVar.a(d16, makeReturnJson("fail:invalid data"));
        } else {
            h.f121074n.a(dVar, "/cgi-bin/mmbiz-bin/js-operatewxdata", a(dVar, this, optString), x5.class).c(new a(dVar, this, d16, optString)).a(new b(dVar, d16, this)).a(new c(gVar)).a(com.tencent.luggage.wxa.yo.d.f146044a, new d(dVar, d16, this, e16, g16, gVar));
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b implements com.tencent.luggage.wxa.uo.b {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.ic.d f121200b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f121201c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ o f121202d;

        public b(com.tencent.luggage.wxa.ic.d dVar, int i3, o oVar) {
            this.f121200b = dVar;
            this.f121201c = i3;
            this.f121202d = oVar;
        }

        public final void a(x5 x5Var) {
            String d16;
            c5 c5Var;
            Unit unit = null;
            Integer valueOf = (x5Var == null || (c5Var = x5Var.f129007e) == null) ? null : Integer.valueOf(c5Var.f127384d);
            if (valueOf == null || valueOf.intValue() != 0) {
                if (valueOf == null) {
                    this.f121200b.a(this.f121201c, this.f121202d.makeReturnJson("fail invalid response"));
                    return;
                }
                this.f121200b.a(this.f121201c, this.f121202d.makeReturnJson("fail response errcode=" + valueOf + " errmsg=" + x5Var.f129007e.f127385e));
                return;
            }
            com.tencent.luggage.wxa.fn.c cVar = x5Var.f129008f;
            if (cVar != null && (d16 = cVar.d()) != null) {
                com.tencent.luggage.wxa.ic.d dVar = this.f121200b;
                int i3 = this.f121201c;
                o oVar = this.f121202d;
                HashMap hashMap = new HashMap();
                hashMap.put("data", d16);
                Unit unit2 = Unit.INSTANCE;
                dVar.a(i3, oVar.makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, hashMap));
                unit = Unit.INSTANCE;
            }
            if (unit == null) {
                a(this.f121200b, this.f121201c, this.f121202d);
            }
        }

        @Override // com.tencent.luggage.wxa.uo.b
        public /* bridge */ /* synthetic */ Object call(Object obj) {
            a((x5) obj);
            return Unit.INSTANCE;
        }

        public static final void a(com.tencent.luggage.wxa.ic.d dVar, int i3, o oVar) {
            w.b("Luggage.WXA.JsApiOperateWXDataLU", "response ok but data is NULL, appId[" + dVar.getAppId() + "], callbackId[" + i3 + ']');
            dVar.a(i3, oVar.makeReturnJson("fail invalid response"));
        }
    }

    public static final w5 a(com.tencent.luggage.wxa.ic.d dVar, o oVar, String cgiRequestData) {
        w5 w5Var = new w5();
        w5Var.f128942e = dVar.getAppId();
        Intrinsics.checkNotNullExpressionValue(cgiRequestData, "cgiRequestData");
        w5Var.f128943f = oVar.a(cgiRequestData);
        w5Var.f128946i = dVar.getRuntime().l0();
        w5Var.f128947j = oVar.a(new gf(), dVar);
        return w5Var;
    }
}
