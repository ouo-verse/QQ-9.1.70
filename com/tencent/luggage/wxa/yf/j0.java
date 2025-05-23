package com.tencent.luggage.wxa.yf;

import com.tencent.luggage.wxa.xd.o1;
import com.tencent.mobileqq.app.face.FaceConstant;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public class j0 extends com.tencent.luggage.wxa.xd.a {
    public static final int CTRL_INDEX = 9;
    public static final String NAME = "showNavigationBarLoading";

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.ic.d f145712a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f145713b;

        public a(com.tencent.luggage.wxa.ic.d dVar, int i3) {
            this.f145712a = dVar;
            this.f145713b = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.tencent.luggage.wxa.kj.v a16 = o1.a(this.f145712a);
            if (a16 == null) {
                this.f145712a.a(this.f145713b, j0.this.makeReturnJson("fail:page don't exist"));
            } else {
                a16.j(true);
                this.f145712a.a(this.f145713b, j0.this.makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS));
            }
        }
    }

    @Override // com.tencent.luggage.wxa.xd.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void invoke(com.tencent.luggage.wxa.ic.d dVar, JSONObject jSONObject, int i3) {
        a aVar = new a(dVar, i3);
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
