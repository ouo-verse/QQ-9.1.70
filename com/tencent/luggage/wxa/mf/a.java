package com.tencent.luggage.wxa.mf;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.luggage.wxa.fd.i;
import com.tencent.luggage.wxa.fd.i0;
import com.tencent.luggage.wxa.ic.d;
import com.tencent.luggage.wxa.ic.g;
import com.tencent.luggage.wxa.qc.c;
import com.tencent.luggage.wxa.tn.c0;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.v4.e;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class a extends com.tencent.luggage.wxa.xd.a {

    @Deprecated
    public static final int CTRL_INDEX = 646;

    @Deprecated
    @NotNull
    public static final String NAME = "navigateBackNative";

    /* renamed from: a, reason: collision with root package name */
    public static final C6471a f134465a = new C6471a(null);

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.mf.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6471a {
        public C6471a() {
        }

        public /* synthetic */ C6471a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b implements c.InterfaceC6640c {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f134466a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f134467b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ JSONObject f134468c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ e f134469d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Object f134470e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ a f134471f;

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.mf.a$b$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class RunnableC6472a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ d f134472a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ int f134473b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ JSONObject f134474c;

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ e f134475d;

            /* renamed from: e, reason: collision with root package name */
            public final /* synthetic */ Object f134476e;

            /* renamed from: f, reason: collision with root package name */
            public final /* synthetic */ a f134477f;

            public RunnableC6472a(d dVar, int i3, JSONObject jSONObject, e eVar, Object obj, a aVar) {
                this.f134472a = dVar;
                this.f134473b = i3;
                this.f134474c = jSONObject;
                this.f134475d = eVar;
                this.f134476e = obj;
                this.f134477f = aVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                String str;
                try {
                    w.d("MicroMsg.AppBrand.JsApiNavigateBackNative", "invoke onWXAppResult, appId:" + this.f134472a.getAppId() + ", callbackId:" + this.f134473b + " data:" + this.f134474c);
                    e eVar = this.f134475d;
                    if (eVar != null) {
                        Object obj = this.f134476e;
                        if (obj != null) {
                            str = obj.toString();
                        } else {
                            str = null;
                        }
                        if (str == null) {
                            str = "";
                        }
                        eVar.a(new com.tencent.luggage.wxa.va.d(str));
                    }
                    this.f134472a.a(this.f134473b, this.f134477f.makeReturnJson(com.tencent.luggage.wxa.af.e.f121305a));
                } catch (Exception e16) {
                    this.f134472a.a(this.f134473b, this.f134477f.makeReturnJson("fail " + e16.getMessage(), com.tencent.luggage.wxa.af.e.f121309e));
                }
            }
        }

        public b(d dVar, int i3, JSONObject jSONObject, e eVar, Object obj, a aVar) {
            this.f134466a = dVar;
            this.f134467b = i3;
            this.f134468c = jSONObject;
            this.f134469d = eVar;
            this.f134470e = obj;
            this.f134471f = aVar;
        }

        @Override // com.tencent.luggage.wxa.qc.c.InterfaceC6640c
        public void a(String appId, com.tencent.luggage.wxa.qc.b state) {
            Intrinsics.checkNotNullParameter(appId, "appId");
            Intrinsics.checkNotNullParameter(state, "state");
            if (com.tencent.luggage.wxa.qc.b.BACKGROUND == state) {
                this.f134466a.getRuntime().c0().b(this);
                c0.a(new RunnableC6472a(this.f134466a, this.f134467b, this.f134468c, this.f134469d, this.f134470e, this.f134471f));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g f134478a;

        public c(g gVar) {
            this.f134478a = gVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.tencent.luggage.wxa.j4.d S = ((com.tencent.luggage.wxa.c5.e) this.f134478a).S();
            com.tencent.luggage.wxa.j4.e eVar = ((com.tencent.luggage.wxa.c5.e) this.f134478a).S().f130803o0;
            if (eVar == null) {
                eVar = new com.tencent.luggage.wxa.j4.e(false, 0, null, null, false, null, null, 127, null);
            }
            eVar.a(i0.DISABLED);
            S.f130803o0 = eVar;
        }
    }

    public a() {
        com.tencent.luggage.wxa.rj.a.a(NAME);
    }

    @Override // com.tencent.luggage.wxa.xd.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void invoke(d dVar, JSONObject jSONObject, int i3) {
        JSONObject jSONObject2;
        com.tencent.luggage.wxa.j4.d dVar2;
        e eVar;
        e eVar2;
        if (dVar == null || dVar.getRuntime() == null || jSONObject == null) {
            return;
        }
        Object opt = jSONObject.opt(WadlProxyConsts.EXTRA_DATA);
        boolean z16 = false;
        if (opt instanceof JSONObject) {
            z16 = ((JSONObject) opt).optBoolean("forbidAnimation", false);
        } else if (opt instanceof String) {
            try {
                jSONObject2 = new JSONObject((String) opt);
            } catch (JSONException unused) {
                jSONObject2 = null;
            }
            if (jSONObject2 != null) {
                z16 = jSONObject2.optBoolean("forbidAnimation", false);
            }
        }
        boolean z17 = z16;
        i S = dVar.getRuntime().S();
        if (S instanceof com.tencent.luggage.wxa.j4.d) {
            dVar2 = (com.tencent.luggage.wxa.j4.d) S;
        } else {
            dVar2 = null;
        }
        if (dVar2 != null) {
            eVar = dVar2.f130799k0;
        } else {
            eVar = null;
        }
        if (eVar instanceof e) {
            eVar2 = eVar;
        } else {
            eVar2 = null;
        }
        dVar.getRuntime().c0().a(new b(dVar, i3, jSONObject, eVar2, opt, this));
        g runtime = dVar.getRuntime();
        if ((runtime instanceof com.tencent.luggage.wxa.c5.e) && z17) {
            runtime.e(new c(runtime));
        }
        dVar.getRuntime().o();
    }
}
