package com.tencent.luggage.wxa.ae;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.luggage.wxa.ae.h;
import com.tencent.luggage.wxa.d5.a;
import com.tencent.luggage.wxa.hn.c5;
import com.tencent.luggage.wxa.hn.gf;
import com.tencent.luggage.wxa.hn.m9;
import com.tencent.luggage.wxa.hn.o5;
import com.tencent.luggage.wxa.hn.p5;
import com.tencent.luggage.wxa.hn.q5;
import com.tencent.luggage.wxa.hn.r5;
import com.tencent.luggage.wxa.rj.p;
import com.tencent.luggage.wxa.tj.d;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.xd.f1;
import com.tencent.luggage.wxa.xo.e;
import com.tencent.mm.plugin.appbrand.platform.window.activity.WindowAndroidActivityImpl;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.mini.app.AuthorizeCenter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class m extends k implements h {

    @Deprecated
    public static final int CTRL_INDEX = 54;

    @Deprecated
    @NotNull
    public static final String NAME = "authorize";

    /* renamed from: a, reason: collision with root package name */
    public static final e f121128a = new e(null);

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b implements com.tencent.luggage.wxa.uo.b {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.ic.d f121146b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f121147c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ m f121148d;

        public b(com.tencent.luggage.wxa.ic.d dVar, int i3, m mVar) {
            this.f121146b = dVar;
            this.f121147c = i3;
            this.f121148d = mVar;
        }

        public final void a(Pair pair) {
            Integer num;
            c5 c5Var = (c5) pair.component1();
            String str = (String) pair.component2();
            if (c5Var != null) {
                num = Integer.valueOf(c5Var.f127384d);
            } else {
                num = null;
            }
            if (num != null && num.intValue() == 0) {
                this.f121146b.a(this.f121147c, this.f121148d.makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS));
                return;
            }
            if (num != null && num.intValue() == -12006) {
                this.f121146b.a(this.f121147c, this.f121148d.makeReturnJson("fail:auth denied"));
                return;
            }
            if (num == null) {
                this.f121146b.a(this.f121147c, this.f121148d.makeReturnJson("fail invalid " + this.f121148d.b(str) + " response"));
                return;
            }
            this.f121146b.a(this.f121147c, this.f121148d.makeReturnJson("fail " + this.f121148d.b(str) + " response errcode=" + num + " errmsg=" + c5Var.f127385e));
        }

        @Override // com.tencent.luggage.wxa.uo.b
        public /* bridge */ /* synthetic */ Object call(Object obj) {
            a((Pair) obj);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c implements e.c {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g f121149a;

        public c(g gVar) {
            this.f121149a = gVar;
        }

        @Override // com.tencent.luggage.wxa.xo.e.c
        public final void a(Object obj) {
            g gVar = this.f121149a;
            if (gVar != null) {
                gVar.b();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class d implements e.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.ic.d f121150a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f121151b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ m f121152c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ JSONObject f121153d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ JSONObject f121154e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ g f121155f;

        public d(com.tencent.luggage.wxa.ic.d dVar, int i3, m mVar, JSONObject jSONObject, JSONObject jSONObject2, g gVar) {
            this.f121150a = dVar;
            this.f121151b = i3;
            this.f121152c = mVar;
            this.f121153d = jSONObject;
            this.f121154e = jSONObject2;
            this.f121155f = gVar;
        }

        @Override // com.tencent.luggage.wxa.xo.e.a
        public final void a(Object obj) {
            String str;
            g gVar;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("onInterrupt, appId[");
            sb5.append(this.f121150a.getAppId());
            sb5.append("], callbackId[");
            sb5.append(this.f121151b);
            sb5.append("], e[");
            if (obj != null) {
                str = obj.toString();
            } else {
                str = null;
            }
            sb5.append(str);
            sb5.append(']');
            w.d("Luggage.WXA.JsApiAuthorizeLU", sb5.toString());
            try {
                if (obj instanceof h.c) {
                    if (gVar != null) {
                        return;
                    } else {
                        return;
                    }
                }
                if (obj instanceof h.a) {
                    this.f121150a.a(this.f121151b, this.f121152c.makeReturnJson("fail " + ((h.a) obj).getMessage()));
                } else if (obj instanceof Throwable) {
                    if (this.f121152c.a(this.f121150a, this.f121153d, this.f121154e, this.f121151b, this.f121155f, obj)) {
                        return;
                    }
                    this.f121150a.a(this.f121151b, this.f121152c.makeReturnJson("fail " + ((Throwable) obj).getMessage()));
                } else if (obj == null) {
                    this.f121150a.a(this.f121151b, this.f121152c.makeReturnJson("fail:internal error"));
                } else {
                    this.f121150a.a(this.f121151b, this.f121152c.makeReturnJson("fail " + obj));
                }
                g gVar2 = this.f121155f;
                if (gVar2 != null) {
                    gVar2.b();
                }
            } finally {
                gVar = this.f121155f;
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

    public final String b(String str) {
        if (Intrinsics.areEqual(str, "/cgi-bin/mmbiz-bin/js-authorize")) {
            return "js-authorize";
        }
        if (Intrinsics.areEqual(str, "/cgi-bin/mmbiz-bin/js-authorize-confirm")) {
            return "js-authorize-confirm";
        }
        return str;
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

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements com.tencent.luggage.wxa.uo.b {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.ic.d f121129b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f121130c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ m f121131d;

        public a(com.tencent.luggage.wxa.ic.d dVar, int i3, m mVar) {
            this.f121129b = dVar;
            this.f121130c = i3;
            this.f121131d = mVar;
        }

        @Override // com.tencent.luggage.wxa.uo.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Pair call(r5 r5Var) {
            Integer num;
            boolean z16;
            c5 c5Var;
            c5 c5Var2 = null;
            if (r5Var != null && (c5Var = r5Var.f128575e) != null) {
                num = Integer.valueOf(c5Var.f127384d);
            } else {
                num = null;
            }
            if (num != null && num.intValue() == -12000) {
                com.tencent.luggage.wxa.xo.b b16 = com.tencent.luggage.wxa.xo.h.b();
                LinkedList linkedList = r5Var.f128576f;
                if (linkedList != null && !linkedList.isEmpty()) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (z16) {
                    this.f121129b.a(this.f121130c, this.f121131d.makeReturnJson("fail:internal error scope empty"));
                } else {
                    com.tencent.luggage.wxa.zp.h.f146825d.a(new RunnableC5996a(this.f121129b, b16, r5Var, this.f121131d, this.f121130c));
                }
                return null;
            }
            if (r5Var != null) {
                c5Var2 = r5Var.f128575e;
            }
            return new Pair(c5Var2, "/cgi-bin/mmbiz-bin/js-authorize");
        }

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.ae.m$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class RunnableC5996a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxa.ic.d f121132a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxa.xo.b f121133b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ r5 f121134c;

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ m f121135d;

            /* renamed from: e, reason: collision with root package name */
            public final /* synthetic */ int f121136e;

            /* compiled from: P */
            /* renamed from: com.tencent.luggage.wxa.ae.m$a$a$a, reason: collision with other inner class name */
            /* loaded from: classes8.dex */
            public static final class C5997a implements a.b {

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ m f121137a;

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ com.tencent.luggage.wxa.ic.d f121138b;

                /* renamed from: c, reason: collision with root package name */
                public final /* synthetic */ com.tencent.luggage.wxa.d5.a f121139c;

                /* renamed from: d, reason: collision with root package name */
                public final /* synthetic */ com.tencent.luggage.wxa.ml.d f121140d;

                public C5997a(m mVar, com.tencent.luggage.wxa.ic.d dVar, com.tencent.luggage.wxa.d5.a aVar, com.tencent.luggage.wxa.ml.d dVar2) {
                    this.f121137a = mVar;
                    this.f121138b = dVar;
                    this.f121139c = aVar;
                    this.f121140d = dVar2;
                }

                @Override // com.tencent.luggage.wxa.d5.a.b
                public final void a(Bitmap bitmap) {
                    m mVar = this.f121137a;
                    mVar.a(mVar.a(this.f121138b), bitmap, this.f121139c.T(), AuthorizeCenter.SCOPE_USER_INFO, this.f121140d);
                }
            }

            public RunnableC5996a(com.tencent.luggage.wxa.ic.d dVar, com.tencent.luggage.wxa.xo.b bVar, r5 r5Var, m mVar, int i3) {
                this.f121132a = dVar;
                this.f121133b = bVar;
                this.f121134c = r5Var;
                this.f121135d = mVar;
                this.f121136e = i3;
            }

            @Override // java.lang.Runnable
            public final void run() {
                boolean z16;
                com.tencent.luggage.wxa.wj.c windowAndroidActivityImpl;
                boolean z17;
                if (!this.f121132a.isRunning()) {
                    this.f121133b.a(h.c.f121076a);
                    return;
                }
                b bVar = new b(this.f121136e, this.f121135d, this.f121133b, this.f121132a);
                m9 m9Var = (m9) this.f121134c.f128576f.getFirst();
                String str = m9Var.f128173i;
                boolean a16 = p.a(m9Var.f128168d, this.f121132a.getRuntime().j0());
                boolean z18 = false;
                if (str != null && str.length() != 0) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (z16 && a16 && TextUtils.isEmpty(p.a(m9Var.f128168d, this.f121132a.getRuntime()))) {
                    this.f121133b.a(new h.a("fail:require permission desc"));
                    return;
                }
                Context a17 = this.f121135d.a(this.f121132a);
                com.tencent.luggage.wxa.ic.g runtime = this.f121132a.getRuntime();
                if (runtime == null || (windowAndroidActivityImpl = runtime.n0()) == null) {
                    windowAndroidActivityImpl = new WindowAndroidActivityImpl();
                }
                com.tencent.luggage.wxa.ml.d dVar = new com.tencent.luggage.wxa.ml.d(a17, windowAndroidActivityImpl, bVar);
                r5 r5Var = this.f121134c;
                com.tencent.luggage.wxa.ic.d dVar2 = this.f121132a;
                m mVar = this.f121135d;
                dVar.b(r5Var.f128577g);
                dVar.h(m9Var.f128169e);
                dVar.k(r5Var.f128581k);
                dVar.l(r5Var.f128579i);
                dVar.j(r5Var.f128580j);
                dVar.a(r5Var.f128578h);
                com.tencent.luggage.wxa.wj.c D = dVar2.D();
                if (D != null && D.isLargeScreenWindow()) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    dVar.d(1);
                }
                if (Intrinsics.areEqual(AuthorizeCenter.SCOPE_USER_INFO, m9Var.f128168d)) {
                    com.tencent.luggage.wxa.d5.a a18 = a.C6131a.a();
                    Intrinsics.checkNotNullExpressionValue(a18, "notNullProvider()");
                    mVar.a(mVar.a(dVar2), (Bitmap) null, a18.T(), AuthorizeCenter.SCOPE_USER_INFO, dVar);
                    a18.a(new C5997a(mVar, dVar2, a18, dVar));
                } else {
                    String str2 = m9Var.f128168d;
                    Intrinsics.checkNotNullExpressionValue(str2, "scopeInfo.Scope");
                    dVar.i(str2);
                }
                if (str == null || str.length() == 0) {
                    z18 = true;
                }
                if (!z18) {
                    dVar.g(str);
                } else if (a16) {
                    dVar.g(p.a(m9Var.f128168d, dVar2.getRuntime()));
                }
                mVar.a(dVar2, dVar);
            }

            /* compiled from: P */
            /* renamed from: com.tencent.luggage.wxa.ae.m$a$a$b */
            /* loaded from: classes8.dex */
            public static final class b implements d.c {

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ int f121141a;

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ m f121142b;

                /* renamed from: c, reason: collision with root package name */
                public final /* synthetic */ com.tencent.luggage.wxa.xo.b f121143c;

                /* renamed from: d, reason: collision with root package name */
                public final /* synthetic */ com.tencent.luggage.wxa.ic.d f121144d;

                /* compiled from: P */
                /* renamed from: com.tencent.luggage.wxa.ae.m$a$a$b$a, reason: collision with other inner class name */
                /* loaded from: classes8.dex */
                public static final class C5998a implements com.tencent.luggage.wxa.uo.b {

                    /* renamed from: b, reason: collision with root package name */
                    public static final C5998a f121145b = new C5998a();

                    @Override // com.tencent.luggage.wxa.uo.b
                    /* renamed from: a, reason: merged with bridge method [inline-methods] */
                    public final Pair call(p5 p5Var) {
                        c5 c5Var;
                        if (p5Var != null) {
                            c5Var = p5Var.f128399e;
                        } else {
                            c5Var = null;
                        }
                        return new Pair(c5Var, "/cgi-bin/mmbiz-bin/js-authorize-confirm");
                    }
                }

                public b(int i3, m mVar, com.tencent.luggage.wxa.xo.b bVar, com.tencent.luggage.wxa.ic.d dVar) {
                    this.f121141a = i3;
                    this.f121142b = mVar;
                    this.f121143c = bVar;
                    this.f121144d = dVar;
                }

                @Override // com.tencent.luggage.wxa.tj.d.c
                public void a(int i3, ArrayList resultData, int i16, boolean z16) {
                    Intrinsics.checkNotNullParameter(resultData, "resultData");
                    w.d("Luggage.WXA.JsApiAuthorizeLU", "dialog onMsg, resultCode[" + i3 + "], callbackId[" + this.f121141a + ']');
                    if (i3 != 1) {
                        if (i3 != 2) {
                            this.f121143c.a(new h.a("fail:auth canceled"));
                            return;
                        }
                        this.f121143c.a(new h.a("fail:auth denied"));
                        h.b bVar = h.f121074n;
                        com.tencent.luggage.wxa.ic.d dVar = this.f121144d;
                        bVar.a(dVar, "/cgi-bin/mmbiz-bin/js-authorize-confirm", a(dVar, resultData, i3, this.f121142b), p5.class);
                        return;
                    }
                    m mVar = this.f121142b;
                    com.tencent.luggage.wxa.xo.b m3 = this.f121143c;
                    Intrinsics.checkNotNullExpressionValue(m3, "m");
                    h.b bVar2 = h.f121074n;
                    com.tencent.luggage.wxa.ic.d dVar2 = this.f121144d;
                    com.tencent.luggage.wxa.xo.d c16 = bVar2.a(dVar2, "/cgi-bin/mmbiz-bin/js-authorize-confirm", a(dVar2, resultData, i3, this.f121142b), p5.class).c(C5998a.f121145b);
                    Intrinsics.checkNotNullExpressionValue(c16, "service.runCgi(CONFIRM_U\u2026                        }");
                    mVar.a(m3, c16);
                }

                public static final o5 a(com.tencent.luggage.wxa.ic.d dVar, ArrayList arrayList, int i3, m mVar) {
                    Object firstOrNull;
                    o5 o5Var = new o5();
                    o5Var.f128322e = dVar.getAppId();
                    LinkedList linkedList = o5Var.f128323f;
                    firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) arrayList);
                    linkedList.add(firstOrNull);
                    o5Var.f128324g = i3;
                    o5Var.f128325h = dVar.getRuntime().l0();
                    o5Var.f128326i = mVar.a(new gf(), dVar);
                    return o5Var;
                }
            }
        }
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
        JSONArray optJSONArray = e16.optJSONArray("scope");
        if (optJSONArray == null) {
            dVar.a(d16, makeReturnJson("fail:invalid data"));
            return;
        }
        LinkedList linkedList = new LinkedList();
        int length = optJSONArray.length();
        if (length >= 0) {
            int i3 = 0;
            while (true) {
                String optString = optJSONArray.optString(i3, null);
                if (!(optString == null || optString.length() == 0)) {
                    linkedList.add(optString);
                }
                if (i3 == length) {
                    break;
                } else {
                    i3++;
                }
            }
        }
        h.b bVar = h.f121074n;
        q5 q5Var = new q5();
        q5Var.f128498e = dVar.getAppId();
        q5Var.f128499f.addAll(linkedList);
        q5Var.f128500g = dVar.getRuntime().l0();
        q5Var.f128501h = a(new gf(), dVar);
        Unit unit = Unit.INSTANCE;
        bVar.a(dVar, "/cgi-bin/mmbiz-bin/js-authorize", q5Var, r5.class).c(new a(dVar, d16, this)).a(new b(dVar, d16, this)).a(new c(gVar)).a(new d(dVar, d16, this, e16, g16, gVar));
    }
}
