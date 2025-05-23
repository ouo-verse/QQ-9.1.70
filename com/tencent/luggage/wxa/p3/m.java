package com.tencent.luggage.wxa.p3;

import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.luggage.wxa.bj.a;
import com.tencent.luggage.wxa.hn.t8;
import com.tencent.luggage.wxa.ka.aa;
import com.tencent.luggage.wxa.n3.w;
import com.tencent.luggage.wxa.tn.z;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class m extends l {

    /* renamed from: h, reason: collision with root package name */
    public final String f137208h = "Luggage.TdiCgiServiceNoLoginClient";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JK\u0010\u000e\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\fH\u0016\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0012\u001a\u00020\u00068\u0016X\u0096D\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0010\u001a\u0004\b\u000e\u0010\u0011\u00a8\u0006\u0013"}, d2 = {"com/tencent/luggage/wxa/p3/m$a", "Lcom/tencent/luggage/wxa/q3/d;", "Lcom/tencent/luggage/wxa/hn/t8;", "RESP", "", "cmdId", "", "url", "Lcom/tencent/luggage/wxa/n3/w;", DKEngine.GlobalKey.NET_WORK_TYPE, "Lcom/tencent/luggage/wxa/fn/b;", "req", "Ljava/lang/Class;", "respClazz", "a", "(ILjava/lang/String;Lcom/tencent/luggage/wxa/n3/w;Lcom/tencent/luggage/wxa/fn/b;Ljava/lang/Class;)Lcom/tencent/luggage/wxa/hn/t8;", "Ljava/lang/String;", "()Ljava/lang/String;", "TAG", "luggage-standalone-addon-loginsession_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes8.dex */
    public static final class a extends com.tencent.luggage.wxa.q3.d {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final String TAG = "TdiCgiServiceNoLoginClient$AdapterTaskSync";

        @Override // com.tencent.luggage.wxa.q3.d
        /* renamed from: a, reason: from getter */
        public String getTAG() {
            return this.TAG;
        }

        @Override // com.tencent.luggage.wxa.q3.d
        public t8 a(int cmdId, String url, w networkType, com.tencent.luggage.wxa.fn.b req, Class respClazz) {
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(networkType, "networkType");
            Intrinsics.checkNotNullParameter(respClazz, "respClazz");
            d b16 = k.f137201a.b();
            Intrinsics.checkNotNull(b16);
            return b16.a(cmdId, url, networkType, req, respClazz);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b implements com.tencent.luggage.wxa.uo.b {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f137210b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f137211c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ w f137212d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.fn.b f137213e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ Class f137214f;

        /* renamed from: g, reason: collision with root package name */
        public final /* synthetic */ m f137215g;

        /* compiled from: P */
        @Metadata(d1 = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JJ\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u000e\"\b\b\u0000\u0010\u0003*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\fH\u0016R\u001a\u0010\u0012\u001a\u00020\u00068\u0016X\u0096D\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011\u00a8\u0006\u0013"}, d2 = {"com/tencent/luggage/wxa/p3/m$b$a", "Lcom/tencent/luggage/wxa/q3/c;", "Lcom/tencent/luggage/wxa/hn/t8;", "RESP", "", "cmdId", "", "url", "Lcom/tencent/luggage/wxa/n3/w;", DKEngine.GlobalKey.NET_WORK_TYPE, "Lcom/tencent/luggage/wxa/fn/b;", "req", "Ljava/lang/Class;", "respClazz", "Lcom/tencent/luggage/wxa/xo/d;", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "TAG", "luggage-standalone-addon-loginsession_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes8.dex */
        public static final class a extends com.tencent.luggage.wxa.q3.c {

            /* renamed from: a, reason: collision with root package name and from kotlin metadata */
            public final String TAG = "TdiCgiServiceNoLoginClient$AdapterTaskAsync";

            @Override // com.tencent.luggage.wxa.q3.c
            /* renamed from: a, reason: from getter */
            public String getTAG() {
                return this.TAG;
            }

            @Override // com.tencent.luggage.wxa.q3.c
            public com.tencent.luggage.wxa.xo.d a(int cmdId, String url, w networkType, com.tencent.luggage.wxa.fn.b req, Class respClazz) {
                Intrinsics.checkNotNullParameter(url, "url");
                Intrinsics.checkNotNullParameter(networkType, "networkType");
                Intrinsics.checkNotNullParameter(respClazz, "respClazz");
                d b16 = k.f137201a.b();
                Intrinsics.checkNotNull(b16);
                return b16.b(cmdId, url, networkType, req, respClazz);
            }
        }

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.p3.m$b$b, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class C6572b implements com.tencent.luggage.wxa.ka.j {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ com.tencent.luggage.wxa.xo.b f137217a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ m f137218b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ int f137219c;

            public C6572b(com.tencent.luggage.wxa.xo.b bVar, m mVar, int i3) {
                this.f137217a = bVar;
                this.f137218b = mVar;
                this.f137219c = i3;
            }

            @Override // com.tencent.luggage.wxa.ka.j
            public /* synthetic */ void a() {
                aa.a(this);
            }

            @Override // com.tencent.luggage.wxa.ka.j
            public void b() {
                this.f137217a.a("invokeAsync fail: ipc onBridgeNotFound");
            }

            @Override // com.tencent.luggage.wxa.ka.j
            public /* synthetic */ void a(String str) {
                aa.b(this, str);
            }

            @Override // com.tencent.luggage.wxa.ka.j
            public void a(Exception exc) {
                com.tencent.luggage.wxa.tn.w.b(this.f137218b.i(), "syncPipeline cmdId:" + this.f137219c + ", onCaughtInvokeException:" + exc);
                this.f137217a.a("invokeAsync fail: ipc onCaughtInvokeException");
            }

            @Override // com.tencent.luggage.wxa.ka.i
            public void a(com.tencent.luggage.wxa.q3.f tdiResponse) {
                Intrinsics.checkNotNullParameter(tdiResponse, "tdiResponse");
                if (tdiResponse.d() == null) {
                    String str = "ipc invoker data is null tdiResponse: [" + tdiResponse + ']';
                    if (tdiResponse.c() >= 0) {
                        this.f137217a.a(new com.tencent.luggage.wxa.bj.a(a.EnumC6074a.values()[tdiResponse.c()], tdiResponse.a(), tdiResponse.b()));
                    } else {
                        this.f137217a.a(str);
                    }
                    com.tencent.luggage.wxa.tn.w.b(this.f137218b.i(), "err:" + str);
                    return;
                }
                if (tdiResponse.a() == 0) {
                    com.tencent.luggage.wxa.xo.b bVar = this.f137217a;
                    com.tencent.luggage.wxa.fn.b d16 = tdiResponse.d();
                    Intrinsics.checkNotNull(d16, "null cannot be cast to non-null type RESP of com.tencent.luggage.login.account.tdi.TdiCgiServiceNoLoginClient.syncPipeline");
                    bVar.a((t8) d16);
                    com.tencent.luggage.wxa.tn.w.a(this.f137218b.i(), "tdiResponse: " + tdiResponse.d());
                    return;
                }
                this.f137217a.a("invokeAsync fail: " + tdiResponse.a() + TokenParser.SP + tdiResponse.b());
                com.tencent.luggage.wxa.tn.w.b(this.f137218b.i(), "tdiResponse:true errCode" + Integer.valueOf(tdiResponse.a()) + TokenParser.SP + tdiResponse.b());
            }
        }

        public b(int i3, String str, w wVar, com.tencent.luggage.wxa.fn.b bVar, Class cls, m mVar) {
            this.f137210b = i3;
            this.f137211c = str;
            this.f137212d = wVar;
            this.f137213e = bVar;
            this.f137214f = cls;
            this.f137215g = mVar;
        }

        @Override // com.tencent.luggage.wxa.uo.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final t8 call(Void r95) {
            com.tencent.luggage.wxa.xo.b b16 = com.tencent.luggage.wxa.xo.h.b();
            String g16 = z.g();
            int i3 = this.f137210b;
            String str = this.f137211c;
            w wVar = this.f137212d;
            com.tencent.luggage.wxa.fn.b bVar = this.f137213e;
            String name = this.f137214f.getName();
            Intrinsics.checkNotNullExpressionValue(name, "respClazz.name");
            com.tencent.luggage.wxa.q3.e eVar = new com.tencent.luggage.wxa.q3.e(i3, str, wVar, bVar, name);
            new a();
            com.tencent.luggage.wxa.ka.o.a(g16, eVar, a.class, new C6572b(b16, this.f137215g, this.f137210b));
            return null;
        }
    }

    @Override // com.tencent.luggage.wxa.p3.l, com.tencent.luggage.wxa.p3.i, com.tencent.luggage.wxa.p3.d
    public void a(com.tencent.luggage.wxa.p3.b tdiCgi) {
        Intrinsics.checkNotNullParameter(tdiCgi, "tdiCgi");
    }

    @Override // com.tencent.luggage.wxa.p3.i, com.tencent.luggage.wxa.p3.d
    public com.tencent.luggage.wxa.xo.d b(int i3, String url, w networkType, com.tencent.luggage.wxa.fn.b bVar, Class respClazz) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(networkType, "networkType");
        Intrinsics.checkNotNullParameter(respClazz, "respClazz");
        com.tencent.luggage.wxa.xo.d b16 = com.tencent.luggage.wxa.xo.h.c().b(new b(i3, url, networkType, bVar, respClazz, this));
        Intrinsics.checkNotNullExpressionValue(b16, "override fun <RESP : Res\u2026     null\n        }\n    }");
        return b16;
    }

    @Override // com.tencent.luggage.wxa.p3.l, com.tencent.luggage.wxa.p3.i
    public String i() {
        return this.f137208h;
    }

    @Override // com.tencent.luggage.wxa.p3.i, com.tencent.luggage.wxa.p3.d
    public t8 a(int i3, String url, w networkType, com.tencent.luggage.wxa.fn.b bVar, Class respClazz) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(networkType, "networkType");
        Intrinsics.checkNotNullParameter(respClazz, "respClazz");
        com.tencent.luggage.wxa.tn.w.d(i(), "sync cmdId:" + i3 + " req:" + bVar);
        String g16 = z.g();
        String name = respClazz.getName();
        Intrinsics.checkNotNullExpressionValue(name, "respClazz.name");
        com.tencent.luggage.wxa.q3.e eVar = new com.tencent.luggage.wxa.q3.e(i3, url, networkType, bVar, name);
        new a();
        com.tencent.luggage.wxa.q3.f fVar = (com.tencent.luggage.wxa.q3.f) com.tencent.luggage.wxa.ka.o.a(g16, eVar, a.class);
        if ((fVar != null ? fVar.d() : null) != null && fVar.a() == 0) {
            com.tencent.luggage.wxa.tn.w.a(i(), "sync tdiResponse: " + fVar.d());
            com.tencent.luggage.wxa.fn.b d16 = fVar.d();
            Intrinsics.checkNotNull(d16, "null cannot be cast to non-null type RESP of com.tencent.luggage.login.account.tdi.TdiCgiServiceNoLoginClient.sync");
            return (t8) d16;
        }
        String i16 = i();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("tdiResponse:");
        sb5.append(fVar != null);
        sb5.append(" resp:");
        sb5.append(fVar.d());
        sb5.append("  errCode");
        sb5.append(Integer.valueOf(fVar.a()));
        com.tencent.luggage.wxa.tn.w.b(i16, sb5.toString());
        return null;
    }

    @Override // com.tencent.luggage.wxa.p3.l, com.tencent.luggage.wxa.p3.i, com.tencent.luggage.wxa.p3.d
    public void z() {
    }
}
