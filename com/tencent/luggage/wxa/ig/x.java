package com.tencent.luggage.wxa.ig;

import com.tencent.luggage.wxa.tn.w0;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class x extends com.tencent.luggage.wxa.xd.a {
    public static final int CTRL_INDEX = 16;
    public static final String NAME = "setStorage";

    /* renamed from: a, reason: collision with root package name */
    public d f130328a = new a();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements d {
        public a() {
        }

        @Override // com.tencent.luggage.wxa.ig.x.d
        public void a(String str, com.tencent.luggage.wxa.xd.d dVar, int i3) {
            dVar.a(i3, x.this.makeReturnJson(str));
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements com.tencent.luggage.wxa.jq.g {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.d f130330a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f130331b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f130332c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f130333d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f130334e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ String f130335f;

        /* renamed from: g, reason: collision with root package name */
        public final /* synthetic */ d f130336g;

        /* renamed from: h, reason: collision with root package name */
        public final /* synthetic */ int f130337h;

        /* renamed from: i, reason: collision with root package name */
        public final /* synthetic */ long f130338i;

        public b(com.tencent.luggage.wxa.xd.d dVar, String str, int i3, String str2, String str3, String str4, d dVar2, int i16, long j3) {
            this.f130330a = dVar;
            this.f130331b = str;
            this.f130332c = i3;
            this.f130333d = str2;
            this.f130334e = str3;
            this.f130335f = str4;
            this.f130336g = dVar2;
            this.f130337h = i16;
            this.f130338i = j3;
        }

        @Override // com.tencent.luggage.wxa.jq.g, com.tencent.luggage.wxa.jq.f
        public String getKey() {
            return "JsApiSetStorage";
        }

        @Override // java.lang.Runnable
        public void run() {
            com.tencent.luggage.wxa.fd.q qVar = (com.tencent.luggage.wxa.fd.q) this.f130330a.a(com.tencent.luggage.wxa.fd.q.class);
            String b16 = a0.b(((com.tencent.luggage.wxa.k4.a) com.tencent.luggage.wxa.h1.e.a(com.tencent.luggage.wxa.k4.a.class)).a(this.f130331b, qVar.f125967m, qVar.D).a(this.f130332c, this.f130331b, this.f130333d, this.f130334e, this.f130335f));
            d dVar = this.f130336g;
            if (dVar != null) {
                dVar.a(b16, this.f130330a, this.f130337h);
            }
            x.this.a(2, com.tencent.luggage.wxa.rc.v.a(this.f130333d, this.f130334e), this.f130338i, qVar);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f130340a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ z f130341b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.d f130342c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f130343d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f130344e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ String f130345f;

        /* renamed from: g, reason: collision with root package name */
        public final /* synthetic */ long f130346g;

        /* renamed from: h, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.fd.q f130347h;

        public c(d dVar, z zVar, com.tencent.luggage.wxa.xd.d dVar2, int i3, String str, String str2, long j3, com.tencent.luggage.wxa.fd.q qVar) {
            this.f130340a = dVar;
            this.f130341b = zVar;
            this.f130342c = dVar2;
            this.f130343d = i3;
            this.f130344e = str;
            this.f130345f = str2;
            this.f130346g = j3;
            this.f130347h = qVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d dVar = this.f130340a;
            if (dVar != null) {
                dVar.a(this.f130341b.C, this.f130342c, this.f130343d);
            }
            x.this.a(1, com.tencent.luggage.wxa.rc.v.a(this.f130344e, this.f130345f), this.f130346g, this.f130347h);
            this.f130341b.f();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface d {
        void a(String str, com.tencent.luggage.wxa.xd.d dVar, int i3);
    }

    public final void b(com.tencent.luggage.wxa.xd.d dVar, int i3, int i16, String str, String str2, String str3, String str4, d dVar2) {
        dVar.b(new b(dVar, str4, i16, str, str2, str3, dVar2, i3, System.currentTimeMillis()));
    }

    @Override // com.tencent.luggage.wxa.xd.a
    public void invoke(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
        String optString = jSONObject.optString("key");
        String optString2 = jSONObject.optString("data");
        String optString3 = jSONObject.optString("dataType");
        int i16 = 0;
        int optInt = jSONObject.optInt("storageId", 0);
        if (w0.c(optString)) {
            dVar.a(i3, makeReturnJson(com.tencent.luggage.wxa.af.k.f121388d));
            return;
        }
        if (com.tencent.luggage.wxa.rc.v.a(optInt)) {
            dVar.a(i3, makeReturnJson(com.tencent.luggage.wxa.af.k.f121386b));
            return;
        }
        String b16 = b(dVar);
        if (w0.c(b16)) {
            dVar.a(i3, makeReturnJson("fail:appID is empty"));
            return;
        }
        com.tencent.luggage.wxa.fd.q qVar = (com.tencent.luggage.wxa.fd.q) dVar.a(com.tencent.luggage.wxa.fd.q.class);
        if (qVar == null) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.JsApiSetStorage", "invoke with appId[%s] callbackId[%d], NULL sysConfig", dVar.getAppId(), Integer.valueOf(i3));
            dVar.a(i3, makeReturnJson("fail:internal error"));
            return;
        }
        int i17 = ((com.tencent.luggage.wxa.j4.g) qVar).f130831g0.f125737f;
        int length = optString.length();
        if (optString2 != null) {
            i16 = optString2.length();
        }
        if (length + i16 > i17) {
            dVar.a(i3, makeReturnJson("fail:entry size limit reached"));
            return;
        }
        int i18 = qVar.f125967m;
        if (com.tencent.luggage.wxa.fd.q.a(i18)) {
            b(dVar, i3, optInt, optString, optString2, optString3, b16, this.f130328a);
        } else if (i18 == 3) {
            b(dVar, i3, optInt, optString, optString2, optString3, b16, this.f130328a);
            a(dVar, i3, optInt, optString, optString2, optString3, b16, null);
        } else {
            a(dVar, i3, optInt, optString, optString2, optString3, b16, this.f130328a);
        }
    }

    public final void a(com.tencent.luggage.wxa.xd.d dVar, int i3, int i16, String str, String str2, String str3, String str4, d dVar2) {
        com.tencent.luggage.wxa.fd.q qVar = (com.tencent.luggage.wxa.fd.q) dVar.a(com.tencent.luggage.wxa.fd.q.class);
        long currentTimeMillis = System.currentTimeMillis();
        z zVar = new z();
        zVar.f130349c = str4;
        zVar.f130350d = i16;
        zVar.a(str, str2, str3);
        zVar.f130351e = new c(dVar2, zVar, dVar, i3, str, str2, currentTimeMillis, qVar);
        zVar.b();
    }

    public String b(com.tencent.luggage.wxa.xd.d dVar) {
        return dVar.getAppId();
    }

    public final void a(int i3, int i16, long j3, com.tencent.luggage.wxa.fd.q qVar) {
        com.tencent.luggage.wxa.rc.u.a(i3, 1, i16, 1, System.currentTimeMillis() - j3, qVar);
    }
}
