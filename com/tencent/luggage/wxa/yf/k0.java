package com.tencent.luggage.wxa.yf;

import com.tencent.mobileqq.app.face.FaceConstant;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public class k0 extends com.tencent.luggage.wxa.xd.a {
    public static final int CTRL_INDEX = -2;
    public static final String NAME = "showTabBar";

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.ic.l f145720a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f145721b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ JSONObject f145722c;

        public a(com.tencent.luggage.wxa.ic.l lVar, int i3, JSONObject jSONObject) {
            this.f145720a = lVar;
            this.f145721b = i3;
            this.f145722c = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.tencent.luggage.wxa.kj.n currentPage = this.f145720a.getRuntime().Y().getCurrentPage();
            if (!(currentPage instanceof com.tencent.luggage.wxa.kj.g)) {
                this.f145720a.a(this.f145721b, k0.this.makeReturnJson("fail:not TabBar page"));
            } else {
                ((com.tencent.luggage.wxa.kj.g) currentPage).getTabBar().b(this.f145722c.optBoolean("animation", true));
                this.f145720a.a(this.f145721b, k0.this.makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS));
            }
        }
    }

    @Override // com.tencent.luggage.wxa.xd.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void invoke(com.tencent.luggage.wxa.ic.l lVar, JSONObject jSONObject, int i3) {
        a aVar = new a(lVar, i3, jSONObject);
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
