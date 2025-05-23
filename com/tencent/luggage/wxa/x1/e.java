package com.tencent.luggage.wxa.x1;

import com.tencent.luggage.wxa.ic.l;
import com.tencent.luggage.wxa.kj.v;
import com.tencent.luggage.wxa.tn.c0;
import com.tencent.mobileqq.app.face.FaceConstant;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public class e extends com.tencent.luggage.wxa.xd.a {
    private static final int CTRL_INDEX = 70;
    private static final String NAME = "hideKeyboard";

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f144490a;

        public a(l lVar) {
            this.f144490a = lVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.tencent.luggage.wxa.f2.a d16;
            v J = this.f144490a.J();
            if (J != null && (d16 = com.tencent.luggage.wxa.f2.a.d(J.getContentView())) != null) {
                d16.j();
            }
        }
    }

    @Override // com.tencent.luggage.wxa.xd.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void invoke(l lVar, JSONObject jSONObject, int i3) {
        c0.a(new a(lVar));
        lVar.a(i3, makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS));
    }
}
