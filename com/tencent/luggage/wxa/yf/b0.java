package com.tencent.luggage.wxa.yf;

import com.tencent.luggage.wxa.xd.o1;
import com.tencent.mobileqq.app.face.FaceConstant;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public class b0 extends com.tencent.luggage.wxa.xd.a {
    public static final int CTRL_INDEX = 8;
    public static final String NAME = "setNavigationBarTitle";

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.ic.d f145638a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f145639b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f145640c;

        public a(com.tencent.luggage.wxa.ic.d dVar, int i3, String str) {
            this.f145638a = dVar;
            this.f145639b = i3;
            this.f145640c = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.tencent.luggage.wxa.kj.v a16 = o1.a(this.f145638a);
            if (a16 == null) {
                this.f145638a.a(this.f145639b, b0.this.makeReturnJson("fail"));
            } else {
                a16.j(this.f145640c);
                this.f145638a.a(this.f145639b, b0.this.makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS));
            }
        }
    }

    @Override // com.tencent.luggage.wxa.xd.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void invoke(com.tencent.luggage.wxa.ic.d dVar, JSONObject jSONObject, int i3) {
        if (!jSONObject.has("title")) {
            dVar.a(i3, makeReturnJson("fail:invalid data"));
            return;
        }
        a aVar = new a(dVar, i3, jSONObject.optString("title"));
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
