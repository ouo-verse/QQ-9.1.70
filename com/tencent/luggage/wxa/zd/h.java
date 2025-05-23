package com.tencent.luggage.wxa.zd;

import com.tencent.luggage.wxa.tn.w;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.tritonaudio.WebAudioPlugin;
import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public class h extends com.tencent.luggage.wxa.xd.a {
    public static final int CTRL_INDEX = 291;
    public static final String NAME = "createAudioInstanceAsync";

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a extends com.tencent.luggage.wxa.zd.a {

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.d f146511c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.ei.p f146512d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ int f146513e;

        public a(com.tencent.luggage.wxa.xd.d dVar, com.tencent.luggage.wxa.ei.p pVar, int i3) {
            this.f146511c = dVar;
            this.f146512d = pVar;
            this.f146513e = i3;
        }

        @Override // com.tencent.luggage.wxa.zd.f
        public void a() {
            w.d("MicroMsg.JsApiCreateAudioInstanceAsync", "hy: start create audio instance async");
            String b16 = g.b(this.f146511c);
            HashMap hashMap = new HashMap();
            hashMap.put(WebAudioPlugin.AUDIO_ID, b16);
            c.INSTANCE.a(this.f146511c.getAppId()).a(b16, this.f146512d);
            this.f146511c.a(this.f146513e, h.this.makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, hashMap));
        }
    }

    @Override // com.tencent.luggage.wxa.xd.o
    public boolean canHandleVarianceExecutable() {
        return true;
    }

    @Override // com.tencent.luggage.wxa.xd.a
    public void invoke(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
        invoke(dVar, jSONObject, i3, dVar.getJsRuntime());
    }

    @Override // com.tencent.luggage.wxa.xd.a
    public void invoke(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3, com.tencent.luggage.wxa.ei.p pVar) {
        w.d("MicroMsg.JsApiCreateAudioInstanceAsync", "hy: create audio instance async invoke");
        new a(dVar, pVar, i3).d();
    }
}
