package com.tencent.luggage.wxa.rf;

import android.os.Bundle;
import com.tencent.luggage.wxa.rf.c;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.qqlive.tvkplayer.event.TVKEventId;
import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class f extends c {
    public static final int CTRL_INDEX = 354;
    public static final String NAME = "sendHCEMessage";

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements c.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.d f139634a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f139635b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ JSONObject f139636c;

        public a(com.tencent.luggage.wxa.xd.d dVar, int i3, JSONObject jSONObject) {
            this.f139634a = dVar;
            this.f139635b = i3;
            this.f139636c = jSONObject;
        }

        @Override // com.tencent.luggage.wxa.rf.c.a
        public void a(int i3, String str) {
            HashMap hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(i3));
            if (i3 == 0) {
                f.this.a(this.f139634a, this.f139635b, this.f139636c);
                return;
            }
            f fVar = f.this;
            fVar.a(this.f139634a, this.f139635b, j.a(fVar, i3, "fail: " + str, hashMap));
        }
    }

    @Override // com.tencent.luggage.wxa.xd.a
    public void invoke(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
        a(new a(dVar, i3, jSONObject));
    }

    public final void a(com.tencent.luggage.wxa.xd.d dVar, int i3, JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        String optString = jSONObject.optString("data");
        if (w0.c(optString)) {
            hashMap.put("errCode", Integer.valueOf(TVKEventId.PLAYER_STATE_HDR_INFO_CHANGED));
            a(dVar, i3, j.a(this, TVKEventId.PLAYER_STATE_HDR_INFO_CHANGED, "fail", hashMap));
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("key_apdu_command", optString);
        b.a(dVar.getAppId(), 32, bundle);
        hashMap.put("errCode", 0);
        dVar.a(i3, j.a(this, 0, FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, hashMap));
    }

    public final void a(com.tencent.luggage.wxa.xd.d dVar, int i3, String str) {
        w.d("MicroMsg.JsApiNFCSendHCEResponseCommand", "alvinluo sendHCEMessage callback json: %s", str);
        if (dVar != null) {
            dVar.a(i3, str);
        }
    }
}
