package com.tencent.luggage.wxa.se;

import android.view.KeyEvent;
import android.view.View;
import com.tencent.luggage.wxa.dd.b;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.mobileqq.app.face.FaceConstant;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class f extends com.tencent.luggage.wxa.ee.d {
    public static final int CTRL_INDEX = 69;
    public static final String NAME = "drawCanvas";

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements b.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.ee.j f140298a;

        public a(com.tencent.luggage.wxa.ee.j jVar) {
            this.f140298a = jVar;
        }

        @Override // com.tencent.luggage.wxa.dd.b.a
        public void a(com.tencent.luggage.wxa.dd.c cVar) {
            this.f140298a.a(f.this.makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS));
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements b.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.ee.j f140300a;

        public b(com.tencent.luggage.wxa.ee.j jVar) {
            this.f140300a = jVar;
        }

        @Override // com.tencent.luggage.wxa.dd.b.a
        public void a(com.tencent.luggage.wxa.dd.c cVar) {
            this.f140300a.a(f.this.makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS));
        }
    }

    @Override // com.tencent.luggage.wxa.ee.d
    public boolean a(com.tencent.luggage.wxa.xd.f fVar, int i3, View view, JSONObject jSONObject, com.tencent.luggage.wxa.ee.j jVar) {
        if (!(view instanceof com.tencent.luggage.wxa.ye.b)) {
            w.d("MicroMsg.JsApiDrawCanvas", "drawCanvas failed, view is not a instance of CoverViewContainer.(%s)", Integer.valueOf(i3));
            return false;
        }
        KeyEvent.Callback callback = (View) ((com.tencent.luggage.wxa.ye.b) view).a(View.class);
        w.a("MicroMsg.JsApiDrawCanvas", "drawCanvas(id : %s)", Integer.valueOf(i3));
        if (!(callback instanceof com.tencent.luggage.wxa.dd.b)) {
            w.d("MicroMsg.JsApiDrawCanvas", "drawCanvas failed, view is not a instance of AppBrandDrawableView.(%s)", Integer.valueOf(i3));
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        JSONArray optJSONArray = jSONObject.optJSONArray("actions");
        com.tencent.luggage.wxa.dd.b bVar = (com.tencent.luggage.wxa.dd.b) callback;
        if (jSONObject.optBoolean("reserve")) {
            bVar.a(optJSONArray, new a(jVar));
        } else {
            bVar.b(optJSONArray, new b(jVar));
        }
        bVar.a();
        w.g("MicroMsg.JsApiDrawCanvas", "post drawCanvas cost : %sms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        return super.a(fVar, i3, view, jSONObject, jVar);
    }

    @Override // com.tencent.luggage.wxa.ee.e
    public int getViewId(JSONObject jSONObject) {
        return jSONObject.getInt("canvasId");
    }

    @Override // com.tencent.luggage.wxa.ee.d
    public boolean isAsyncCallback() {
        return true;
    }
}
