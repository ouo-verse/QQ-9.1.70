package com.tencent.luggage.wxa.yf;

import com.tencent.mobileqq.app.face.FaceConstant;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public class q extends com.tencent.luggage.wxa.xd.a {
    public static final int CTRL_INDEX = 13;
    public static final String NAME = "redirectTo";

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.ic.d f145738a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f145739b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ JSONObject f145740c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f145741d;

        public a(com.tencent.luggage.wxa.ic.d dVar, String str, JSONObject jSONObject, int i3) {
            this.f145738a = dVar;
            this.f145739b = str;
            this.f145740c = jSONObject;
            this.f145741d = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f145738a.getRuntime().Y().b(this.f145739b, this.f145740c);
            this.f145738a.a(this.f145741d, q.this.makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS));
        }
    }

    @Override // com.tencent.luggage.wxa.xd.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void invoke(com.tencent.luggage.wxa.ic.d dVar, JSONObject jSONObject, int i3) {
        String optString = jSONObject.optString("url");
        if (dVar.getRuntime().E().i().a(optString)) {
            dVar.a(i3, makeReturnJson("fail:can not redirect to a tab bar page"));
            return;
        }
        a aVar = new a(dVar, optString, jSONObject.optJSONObject("singlePageData"), i3);
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
