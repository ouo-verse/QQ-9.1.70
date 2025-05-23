package com.tencent.luggage.wxa.rf;

import com.tencent.luggage.wxa.rf.c;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.mobileqq.app.face.FaceConstant;
import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class d extends c {
    public static final int CTRL_INDEX = 358;
    public static final String NAME = "getHCEState";

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements c.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.d f139630a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f139631b;

        public a(com.tencent.luggage.wxa.xd.d dVar, int i3) {
            this.f139630a = dVar;
            this.f139631b = i3;
        }

        @Override // com.tencent.luggage.wxa.rf.c.a
        public void a(int i3, String str) {
            w.d("MicroMsg.JsApiGetHCEState", "alvinluo checkIsSupport onResult errCode: %d, errMsg: %s", Integer.valueOf(i3), str);
            HashMap hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(i3));
            if (i3 == 0) {
                this.f139630a.a(this.f139631b, j.a(d.this, i3, FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, hashMap));
                return;
            }
            this.f139630a.a(this.f139631b, j.a(d.this, i3, "fail " + str, hashMap));
        }
    }

    @Override // com.tencent.luggage.wxa.xd.a
    public void invoke(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
        a((c.a) new a(dVar, i3), true);
    }
}
