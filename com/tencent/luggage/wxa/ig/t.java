package com.tencent.luggage.wxa.ig;

import com.tencent.luggage.wxa.tn.w0;
import com.tencent.mobileqq.app.face.FaceConstant;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class t extends com.tencent.luggage.wxa.xd.a {
    public static final int CTRL_INDEX = 98;
    public static final String NAME = "removeStorage";

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.d f130321a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f130322b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f130323c;

        public a(com.tencent.luggage.wxa.xd.d dVar, int i3, String str) {
            this.f130321a = dVar;
            this.f130322b = i3;
            this.f130323c = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.tencent.luggage.wxa.fd.q qVar = (com.tencent.luggage.wxa.fd.q) this.f130321a.a(com.tencent.luggage.wxa.fd.q.class);
            ((com.tencent.luggage.wxa.k4.a) com.tencent.luggage.wxa.h1.e.a(com.tencent.luggage.wxa.k4.a.class)).a(t.this.b(this.f130321a), qVar.f125967m, qVar.D).b(this.f130322b, t.this.b(this.f130321a), this.f130323c);
        }
    }

    public final void a(com.tencent.luggage.wxa.xd.d dVar, String str, int i3) {
        v vVar = new v();
        vVar.f130325c = b(dVar);
        vVar.f130326d = i3;
        vVar.f130327e = str;
        vVar.b();
    }

    public final void b(com.tencent.luggage.wxa.xd.d dVar, String str, int i3) {
        com.tencent.luggage.wxa.zp.h.f146825d.b(new a(dVar, i3, str), "JsApiRemoveStorage");
    }

    @Override // com.tencent.luggage.wxa.xd.a
    public void invoke(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
        String optString = jSONObject.optString("key");
        int optInt = jSONObject.optInt("storageId", 0);
        if (w0.c(optString)) {
            dVar.a(i3, makeReturnJson(com.tencent.luggage.wxa.af.k.f121388d));
            return;
        }
        if (com.tencent.luggage.wxa.rc.v.a(optInt)) {
            dVar.a(i3, makeReturnJson(com.tencent.luggage.wxa.af.k.f121386b));
            return;
        }
        com.tencent.luggage.wxa.fd.q qVar = (com.tencent.luggage.wxa.fd.q) dVar.a(com.tencent.luggage.wxa.fd.q.class);
        if (qVar == null) {
            dVar.a(i3, makeReturnJson("fail:internal error"));
            return;
        }
        int i16 = qVar.f125967m;
        if (com.tencent.luggage.wxa.fd.q.a(i16)) {
            b(dVar, optString, optInt);
        } else if (i16 == 3) {
            a(dVar, optString, optInt);
            b(dVar, optString, optInt);
        } else {
            a(dVar, optString, optInt);
        }
        dVar.a(i3, makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS));
    }

    public String b(com.tencent.luggage.wxa.xd.d dVar) {
        return dVar.getAppId();
    }
}
