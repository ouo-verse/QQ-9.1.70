package com.tencent.luggage.wxa.yf;

import com.tencent.mobileqq.app.face.FaceConstant;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public class n0 extends com.tencent.luggage.wxa.xd.a {
    public static final int CTRL_INDEX = 150;
    public static final String NAME = "switchTab";

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.ic.d f145727a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f145728b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f145729c;

        public a(com.tencent.luggage.wxa.ic.d dVar, String str, int i3) {
            this.f145727a = dVar;
            this.f145728b = str;
            this.f145729c = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f145727a.getRuntime().Y().n(this.f145728b);
            this.f145727a.a(this.f145729c, n0.this.makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS));
        }
    }

    @Override // com.tencent.luggage.wxa.xd.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void invoke(com.tencent.luggage.wxa.ic.d dVar, JSONObject jSONObject, int i3) {
        String optString = jSONObject.optString("url");
        if (!dVar.getRuntime().E().i().a(optString)) {
            dVar.a(i3, makeReturnJson("fail:can not switch to non-TabBar page"));
            return;
        }
        a aVar = new a(dVar, optString, i3);
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
