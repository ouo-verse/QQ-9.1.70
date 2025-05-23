package com.tencent.luggage.wxa.vh;

import com.tencent.luggage.wxa.b8.g;
import com.tencent.luggage.wxa.b8.p;
import com.tencent.luggage.wxa.b8.q;
import com.tencent.luggage.wxa.b8.r;
import com.tencent.luggage.wxa.ic.l;
import com.tencent.luggage.wxa.kj.v;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.xd.k0;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class b implements g {

    /* renamed from: b, reason: collision with root package name */
    public static final a f143486b = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final com.tencent.luggage.wxa.b8.f f143487a;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements g.a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // com.tencent.luggage.wxa.b8.g.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public b a(com.tencent.luggage.wxa.b8.f castContext) {
            Intrinsics.checkNotNullParameter(castContext, "castContext");
            return new b(castContext, null);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.vh.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6849b extends k0 {
        private static final int CTRL_INDEX = 1243;

        @NotNull
        private static final String NAME = "onXWebLivePlayerEnded";

        /* renamed from: a, reason: collision with root package name */
        public static final a f143488a = new a(null);

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.vh.b$b$a */
        /* loaded from: classes8.dex */
        public static final class a {
            public a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c extends k0 {
        private static final int CTRL_INDEX = 1245;

        @NotNull
        private static final String NAME = "onXWebLivePlayerError";

        /* renamed from: a, reason: collision with root package name */
        public static final a f143489a = new a(null);

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a {
            public a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class d extends k0 {
        private static final int CTRL_INDEX = 1242;

        @NotNull
        private static final String NAME = "onXWebLivePlayerPause";

        /* renamed from: a, reason: collision with root package name */
        public static final a f143490a = new a(null);

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a {
            public a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class e extends k0 {
        private static final int CTRL_INDEX = 1241;

        @NotNull
        private static final String NAME = "onXWebLivePlayerPlay";

        /* renamed from: a, reason: collision with root package name */
        public static final a f143491a = new a(null);

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a {
            public a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class f extends k0 {
        private static final int CTRL_INDEX = 1244;

        @NotNull
        private static final String NAME = "onXWebLivePlayerWaiting";

        /* renamed from: a, reason: collision with root package name */
        public static final a f143492a = new a(null);

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a {
            public a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }
    }

    public /* synthetic */ b(com.tencent.luggage.wxa.b8.f fVar, DefaultConstructorMarker defaultConstructorMarker) {
        this(fVar);
    }

    @Override // com.tencent.luggage.wxa.b8.i
    public void a(int i3, int i16) {
    }

    @Override // com.tencent.luggage.wxa.b8.i
    public void b(int i3) {
    }

    @Override // com.tencent.luggage.wxa.b8.i
    public void e() {
        f fVar = new f();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("viewId", this.f143487a.getId());
        jSONObject.put("type", "DLNA");
        Unit unit = Unit.INSTANCE;
        a(fVar, jSONObject);
    }

    @Override // com.tencent.luggage.wxa.b8.i
    public void f() {
        e eVar = new e();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("viewId", this.f143487a.getId());
        jSONObject.put("type", "DLNA");
        Unit unit = Unit.INSTANCE;
        a(eVar, jSONObject);
    }

    @Override // com.tencent.luggage.wxa.b8.i
    public void h() {
        p pVar = new p();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("viewId", this.f143487a.getId());
        Unit unit = Unit.INSTANCE;
        a(pVar, jSONObject);
    }

    @Override // com.tencent.luggage.wxa.b8.i
    public void onPause() {
        d dVar = new d();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("viewId", this.f143487a.getId());
        jSONObject.put("type", "DLNA");
        Unit unit = Unit.INSTANCE;
        a(dVar, jSONObject);
    }

    public b(com.tencent.luggage.wxa.b8.f fVar) {
        this.f143487a = fVar;
    }

    @Override // com.tencent.luggage.wxa.b8.i
    public void a() {
        c cVar = new c();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("viewId", this.f143487a.getId());
        jSONObject.put("type", "DLNA");
        Unit unit = Unit.INSTANCE;
        a(cVar, jSONObject);
    }

    @Override // com.tencent.luggage.wxa.b8.i
    public void b() {
        C6849b c6849b = new C6849b();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("viewId", this.f143487a.getId());
        jSONObject.put("type", "DLNA");
        Unit unit = Unit.INSTANCE;
        a(c6849b, jSONObject);
    }

    @Override // com.tencent.luggage.wxa.b8.i
    public void a(boolean z16) {
        r rVar = new r();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("viewId", this.f143487a.getId());
        jSONObject.put("state", z16 ? "success" : "fail");
        Unit unit = Unit.INSTANCE;
        a(rVar, jSONObject);
    }

    @Override // com.tencent.luggage.wxa.b8.i
    public void b(boolean z16) {
        q qVar = new q();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("viewId", this.f143487a.getId());
        jSONObject.put("type", "DLNA");
        jSONObject.put("state", z16 ? "success" : "fail");
        Unit unit = Unit.INSTANCE;
        a(qVar, jSONObject);
    }

    public final void a(k0 k0Var, JSONObject jSONObject) {
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "data.toString()");
        w.d("MicroMsg.LivePlayerCastEventHandler", "dispatchJsEvent, event: " + k0Var.getName() + ", data: " + jSONObject2);
        com.tencent.luggage.wxa.xd.d e16 = this.f143487a.g().e();
        if (e16 == null) {
            return;
        }
        k0Var.setData(jSONObject2);
        if (e16 instanceof l) {
            e16.a(k0Var, (int[]) null);
            v J = ((l) e16).J();
            if (J != null) {
                J.a(k0Var, (int[]) null);
                return;
            }
            return;
        }
        if (e16 instanceof v) {
            e16.a(k0Var, (int[]) null);
            l y06 = ((v) e16).y0();
            if (y06 != null) {
                y06.a(k0Var, (int[]) null);
                return;
            }
            return;
        }
        e16.a(k0Var, (int[]) null);
    }
}
