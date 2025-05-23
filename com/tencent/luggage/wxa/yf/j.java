package com.tencent.luggage.wxa.yf;

import com.tencent.mobileqq.app.face.FaceConstant;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public class j extends com.tencent.luggage.wxa.xd.a {
    public static final int CTRL_INDEX = 14;
    public static final String NAME = "navigateTo";

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.ic.d f145707a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f145708b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f145709c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ JSONObject f145710d;

        public a(com.tencent.luggage.wxa.ic.d dVar, int i3, String str, JSONObject jSONObject) {
            this.f145707a = dVar;
            this.f145708b = i3;
            this.f145709c = str;
            this.f145710d = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i3 = this.f145707a.getRuntime().j0().f125958d;
            if (this.f145707a.getRuntime().Y().getPageCount() >= i3) {
                com.tencent.luggage.wxa.tn.w.b("MicroMsg.JsApiNavigateTo", "page limit exceeded: " + i3);
                this.f145707a.a(this.f145708b, j.this.makeReturnJson("fail:page limit exceeded: " + i3));
                return;
            }
            this.f145707a.getRuntime().Y().a(this.f145709c, this.f145710d);
            this.f145707a.a(this.f145708b, j.this.makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS));
        }
    }

    @Override // com.tencent.luggage.wxa.xd.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void invoke(com.tencent.luggage.wxa.ic.d dVar, JSONObject jSONObject, int i3) {
        String optString = jSONObject.optString("url");
        JSONObject optJSONObject = jSONObject.optJSONObject("singlePageData");
        if (dVar.getRuntime().E().i().a(optString)) {
            dVar.a(i3, makeReturnJson("fail:can not navigate to a tab bar page"));
            return;
        }
        a aVar = new a(dVar, i3, optString, optJSONObject);
        if (!(dVar instanceof com.tencent.luggage.wxa.kj.v) && dVar.getRuntime().m1()) {
            dVar.getRuntime().c(aVar);
        } else {
            aVar.run();
        }
    }

    @Override // com.tencent.luggage.wxa.xd.a
    public boolean dispatchInJsThread() {
        return true;
    }
}
