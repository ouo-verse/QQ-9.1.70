package com.tencent.luggage.wxa.gf;

import com.tencent.mobileqq.app.face.FaceConstant;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class w extends com.tencent.luggage.wxa.gf.a {
    public static final int CTRL_INDEX = 200;
    public static final String NAME = "moveMapMarkerAlong";

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.d f126706a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ JSONObject f126707b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f126708c;

        public a(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
            this.f126706a = dVar;
            this.f126707b = jSONObject;
            this.f126708c = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            w.this.a(this.f126706a, this.f126707b, this.f126708c);
        }
    }

    public void a(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
        if (jSONObject == null) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.JsApiMoveMapMarkerAlong", "data is invalid, err");
            a(dVar, i3, "fail:invalid data", false);
        } else {
            com.tencent.luggage.wxa.tn.w.d("MicroMsg.JsApiMoveMapMarkerAlong", "data:%s", jSONObject.toString());
            a(dVar, jSONObject);
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.JsApiMoveMapMarkerAlong", "mapView is null, return");
            a(dVar, i3, String.format("fail:internal error %s", "mapview is null"), false);
        }
    }

    @Override // com.tencent.luggage.wxa.gf.a, com.tencent.luggage.wxa.xd.a
    public void invoke(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
        super.invoke(dVar, jSONObject, i3);
        com.tencent.luggage.wxa.tk.l.a().d(new a(dVar, jSONObject, i3));
    }

    public final void a(com.tencent.luggage.wxa.xd.d dVar, int i3, String str, boolean z16) {
        a(dVar, i3, makeReturnJson(str), str.equals(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS), z16);
    }
}
