package com.tencent.luggage.wxa.gf;

import com.tencent.mobileqq.app.face.FaceConstant;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class l0 extends com.tencent.luggage.wxa.gf.a {
    public static final int CTRL_INDEX = 200;
    public static final String NAME = "translateMapMarker";

    /* renamed from: a, reason: collision with root package name */
    public List f126700a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    public AtomicBoolean f126701b = new AtomicBoolean(false);

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.d f126702a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ JSONObject f126703b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f126704c;

        public a(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
            this.f126702a = dVar;
            this.f126703b = jSONObject;
            this.f126704c = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            l0.this.a(this.f126702a, this.f126703b, this.f126704c);
        }
    }

    public void a(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
        this.f126701b.set(true);
        if (jSONObject == null) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.JsApiTranslateMapMarker", "data is invalid, err");
            a(dVar, i3, "fail:invalid data", false);
        } else {
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.JsApiTranslateMapMarker", "data:%s", jSONObject.toString());
            a(dVar, jSONObject);
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.JsApiTranslateMapMarker", "mapView is null, return");
            a(dVar, i3, String.format("fail:internal error %s", "mapview is null"), false);
        }
    }

    public final synchronized void e() {
        if (this.f126701b.get()) {
            return;
        }
        if (this.f126700a.size() == 0) {
            return;
        }
        Runnable runnable = (Runnable) this.f126700a.remove(0);
        if (runnable != null) {
            com.tencent.luggage.wxa.tk.l.a().d(runnable);
        }
    }

    @Override // com.tencent.luggage.wxa.gf.a, com.tencent.luggage.wxa.xd.a
    public void invoke(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
        super.invoke(dVar, jSONObject, i3);
        this.f126700a.add(new a(dVar, jSONObject, i3));
        e();
    }

    public final void a(com.tencent.luggage.wxa.xd.d dVar, int i3, String str, boolean z16) {
        a(dVar, i3, makeReturnJson(str), str.equals(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS), z16);
        this.f126701b.set(false);
        e();
    }
}
