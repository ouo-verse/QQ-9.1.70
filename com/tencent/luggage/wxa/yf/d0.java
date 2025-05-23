package com.tencent.luggage.wxa.yf;

import com.tencent.mobileqq.app.face.FaceConstant;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public class d0 extends com.tencent.luggage.wxa.xd.a {
    private static final int CTRL_INDEX = 197;
    private static final String NAME = "setStatusBarStyle";

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ JSONObject f145648a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.ic.l f145649b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f145650c;

        public a(JSONObject jSONObject, com.tencent.luggage.wxa.ic.l lVar, int i3) {
            this.f145648a = jSONObject;
            this.f145649b = lVar;
            this.f145650c = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            String optString = this.f145648a.optString("color", "");
            com.tencent.luggage.wxa.kj.v pageView = this.f145649b.getRuntime().Y().getPageView();
            if (pageView == null) {
                this.f145649b.a(this.f145650c, d0.this.makeReturnJson("fail:page don't exist"));
                return;
            }
            if (optString.equals("white") || optString.equals("black")) {
                pageView.k(optString);
            }
            this.f145649b.a(this.f145650c, d0.this.makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS));
        }
    }

    @Override // com.tencent.luggage.wxa.xd.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void invoke(com.tencent.luggage.wxa.ic.l lVar, JSONObject jSONObject, int i3) {
        a aVar = new a(jSONObject, lVar, i3);
        if (!lVar.getRuntime().m1()) {
            aVar.run();
        } else {
            lVar.getRuntime().c(aVar);
        }
    }

    @Override // com.tencent.luggage.wxa.xd.a
    public boolean dispatchInJsThread() {
        return true;
    }
}
