package com.tencent.luggage.wxa.ig;

import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class g extends com.tencent.luggage.wxa.xd.a {
    public static final int CTRL_INDEX = 18;
    public static final String NAME = "clearStorage";

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.d f130269a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f130270b;

        public a(com.tencent.luggage.wxa.xd.d dVar, int i3) {
            this.f130269a = dVar;
            this.f130270b = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.tencent.luggage.wxa.fd.q qVar = (com.tencent.luggage.wxa.fd.q) this.f130269a.a(com.tencent.luggage.wxa.fd.q.class);
            ((com.tencent.luggage.wxa.k4.a) com.tencent.luggage.wxa.h1.e.a(com.tencent.luggage.wxa.k4.a.class)).a(this.f130269a.getAppId(), qVar.f125967m, qVar.D).b(this.f130270b, this.f130269a.getAppId());
        }
    }

    public final void a(com.tencent.luggage.wxa.xd.d dVar, int i3) {
        i iVar = new i();
        iVar.f130272c = dVar.getAppId();
        iVar.f130273d = i3;
        iVar.b();
    }

    public final void b(com.tencent.luggage.wxa.xd.d dVar, int i3) {
        com.tencent.luggage.wxa.co.a.a(new a(dVar, i3), "JsApiClearStorage");
    }

    @Override // com.tencent.luggage.wxa.xd.a
    public void invoke(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
        int i16 = ((com.tencent.luggage.wxa.fd.q) dVar.a(com.tencent.luggage.wxa.fd.q.class)).f125967m;
        int optInt = jSONObject.optInt("storageId", 0);
        if (com.tencent.luggage.wxa.rc.v.a(optInt)) {
            dVar.a(i3, makeReturnJson(com.tencent.luggage.wxa.af.k.f121386b));
            return;
        }
        if (com.tencent.luggage.wxa.fd.q.a(i16)) {
            b(dVar, optInt);
        } else if (i16 == 3) {
            b(dVar, optInt);
            a(dVar, optInt);
        } else {
            a(dVar, optInt);
        }
        dVar.a(i3, makeReturnJson(com.tencent.luggage.wxa.af.e.f121305a));
    }
}
