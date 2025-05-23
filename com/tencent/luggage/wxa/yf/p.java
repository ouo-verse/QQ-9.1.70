package com.tencent.luggage.wxa.yf;

import com.tencent.mobileqq.app.face.FaceConstant;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class p extends com.tencent.luggage.wxa.xd.a {
    private static final int CTRL_INDEX = 170;
    private static final String NAME = "reLaunch";

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.ic.d f145733a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f145734b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f145735c;

        public a(com.tencent.luggage.wxa.ic.d dVar, String str, int i3) {
            this.f145733a = dVar;
            this.f145734b = str;
            this.f145735c = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f145733a.getRuntime().Y().m(this.f145734b);
            this.f145733a.a(this.f145735c, p.this.makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS));
        }
    }

    @Override // com.tencent.luggage.wxa.xd.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void invoke(com.tencent.luggage.wxa.ic.d dVar, JSONObject jSONObject, int i3) {
        a aVar = new a(dVar, jSONObject.optString("url"), i3);
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
