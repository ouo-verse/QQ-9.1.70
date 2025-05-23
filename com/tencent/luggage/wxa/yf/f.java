package com.tencent.luggage.wxa.yf;

import com.tencent.luggage.wxa.xd.o1;
import com.tencent.mobileqq.app.face.FaceConstant;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public class f extends com.tencent.luggage.wxa.xd.a {
    public static final int CTRL_INDEX = 10;
    public static final String NAME = "hideNavigationBarLoading";

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.ic.d f145666a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f145667b;

        public a(com.tencent.luggage.wxa.ic.d dVar, int i3) {
            this.f145666a = dVar;
            this.f145667b = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.tencent.luggage.wxa.kj.v a16 = o1.a(this.f145666a);
            if (a16 == null) {
                this.f145666a.a(this.f145667b, f.this.makeReturnJson("fail:page don't exist"));
            } else {
                a16.j(false);
                this.f145666a.a(this.f145667b, f.this.makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS));
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
