package com.tencent.luggage.wxa.rf;

import com.tencent.luggage.wxa.rf.c;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.mobileqq.app.face.FaceConstant;
import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class h extends c {
    public static final int CTRL_INDEX = 353;
    public static final String NAME = "stopHCE";

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements c.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.d f139657a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f139658b;

        public a(com.tencent.luggage.wxa.xd.d dVar, int i3) {
            this.f139657a = dVar;
            this.f139658b = i3;
        }

        @Override // com.tencent.luggage.wxa.rf.c.a
        public void a(int i3, String str) {
            HashMap hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(i3));
            if (i3 == 0) {
                h.this.a(this.f139657a, this.f139658b);
                return;
            }
            h hVar = h.this;
            hVar.a(this.f139657a, this.f139658b, j.a(hVar, i3, "fail: " + str, hashMap));
        }
    }

    @Override // com.tencent.luggage.wxa.xd.a
    public void invoke(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
        a(new a(dVar, i3));
    }

    public final void a(com.tencent.luggage.wxa.xd.d dVar, int i3) {
        b.b(dVar.getAppId());
        b.a(dVar.getAppId(), 13, null);
        HashMap hashMap = new HashMap(2);
        hashMap.put("errCode", 0);
        a(dVar, i3, j.a(this, 0, FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, hashMap));
    }

    public final void a(com.tencent.luggage.wxa.xd.d dVar, int i3, String str) {
        w.d("MicroMsg.JsApiNFCStartHCE", "alvinluo stopHCE callback result: %s", str);
        if (dVar != null) {
            dVar.a(i3, str);
        }
    }
}
