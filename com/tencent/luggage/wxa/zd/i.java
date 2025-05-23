package com.tencent.luggage.wxa.zd;

import android.text.TextUtils;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.tritonaudio.WebAudioPlugin;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public class i extends com.tencent.luggage.wxa.xd.a {
    public static final int CTRL_INDEX = 290;
    public static final String NAME = "destroyAudioInstance";

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class a extends com.tencent.luggage.wxa.zd.a {

        /* renamed from: c, reason: collision with root package name */
        public com.tencent.luggage.wxa.xd.o f146515c;

        /* renamed from: d, reason: collision with root package name */
        public com.tencent.luggage.wxa.xd.d f146516d;

        /* renamed from: e, reason: collision with root package name */
        public int f146517e;

        /* renamed from: f, reason: collision with root package name */
        public String f146518f = "";

        /* renamed from: g, reason: collision with root package name */
        public String f146519g = "";

        /* renamed from: h, reason: collision with root package name */
        public boolean f146520h = false;

        public a(com.tencent.luggage.wxa.xd.o oVar, com.tencent.luggage.wxa.xd.d dVar, int i3) {
            this.f146515c = oVar;
            this.f146516d = dVar;
            this.f146517e = i3;
        }

        @Override // com.tencent.luggage.wxa.zd.f
        public void a() {
            w.d("MicroMsg.Audio.JsApiDestroyInstanceAudio", "runTask");
            this.f146520h = com.tencent.luggage.wxa.qb.c.b(this.f146519g);
            b();
        }

        @Override // com.tencent.luggage.wxa.zd.a
        public void b() {
            super.b();
            w.d("MicroMsg.Audio.JsApiDestroyInstanceAudio", "callback");
            com.tencent.luggage.wxa.xd.d dVar = this.f146516d;
            if (dVar == null) {
                w.b("MicroMsg.Audio.JsApiDestroyInstanceAudio", "server is null");
            } else if (this.f146520h) {
                dVar.a(this.f146517e, this.f146515c.makeReturnJson("fail"));
            } else {
                dVar.a(this.f146517e, this.f146515c.makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS));
            }
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
        if (jSONObject == null) {
            w.b("MicroMsg.Audio.JsApiDestroyInstanceAudio", "destroyAudioInstance fail, data is null");
            dVar.a(i3, makeReturnJson("fail:data is null"));
            return;
        }
        w.d("MicroMsg.Audio.JsApiDestroyInstanceAudio", "destroyAudioInstance data:%s", jSONObject.toString());
        String optString = jSONObject.optString(WebAudioPlugin.AUDIO_ID);
        if (TextUtils.isEmpty(optString)) {
            w.b("MicroMsg.Audio.JsApiDestroyInstanceAudio", "audioId is empty");
            dVar.a(i3, makeReturnJson("fail:audioId is empty"));
            return;
        }
        a aVar = new a(this, dVar, i3);
        aVar.f146518f = dVar.getAppId();
        aVar.f146519g = optString;
        aVar.c();
        c.INSTANCE.a(dVar.getAppId()).b(optString);
    }
}
