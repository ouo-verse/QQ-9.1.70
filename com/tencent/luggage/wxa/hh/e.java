package com.tencent.luggage.wxa.hh;

import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.luggage.wxa.cp.v;
import com.tencent.luggage.wxa.hh.c;
import com.tencent.luggage.wxa.ic.e;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class e extends com.tencent.luggage.wxa.hh.a {
    public static final int CTRL_INDEX = 33;
    public static final String NAME = "playVoice";

    /* renamed from: a, reason: collision with root package name */
    public e.c f127186a;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a extends e.c {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f127187a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f127188b;

        public a(c cVar, String str) {
            this.f127187a = cVar;
            this.f127188b = str;
        }

        @Override // com.tencent.luggage.wxa.ic.e.c
        public void onDestroy() {
            w.d("MicroMsg.JsApiStartPlayVoice", MosaicConstants$JsFunction.FUNC_ON_DESTROY);
            com.tencent.luggage.wxa.ic.e.b(this.f127188b, e.this.f127186a);
            e.this.f127186a = null;
            this.f127187a.onDestroy();
        }

        @Override // com.tencent.luggage.wxa.ic.e.c
        public void onPause(e.d dVar) {
            w.d("MicroMsg.JsApiStartPlayVoice", MiniSDKConst.NOTIFY_EVENT_ONPAUSE);
            this.f127187a.onBackground();
        }

        @Override // com.tencent.luggage.wxa.ic.e.c
        public void onResume() {
            w.d("MicroMsg.JsApiStartPlayVoice", "onResume");
            this.f127187a.onForeground();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b extends c.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.d f127190a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f127191b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ c f127192c;

        public b(com.tencent.luggage.wxa.xd.d dVar, int i3, c cVar) {
            this.f127190a = dVar;
            this.f127191b = i3;
            this.f127192c = cVar;
        }

        @Override // com.tencent.luggage.wxa.hh.c.b
        public void b() {
            w.d("MicroMsg.JsApiStartPlayVoice", "onCompletion");
            this.f127190a.a(this.f127191b, e.this.makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS));
            this.f127192c.a(this);
        }
    }

    @Override // com.tencent.luggage.wxa.hh.a
    public void a(c cVar, com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
        if (jSONObject == null) {
            w.b("MicroMsg.JsApiStartPlayVoice", "playVoice invalid data");
            dVar.a(i3, makeReturnJson("fail:invalid data"));
            return;
        }
        String optString = jSONObject.optString("filePath", "");
        if (w0.c(optString)) {
            w.b("MicroMsg.JsApiStartPlayVoice", "filePath is null", getName());
            dVar.a(i3, makeReturnJson("fail:invalid data"));
            return;
        }
        v absoluteFile = dVar.getFileSystem().getAbsoluteFile(optString);
        if (absoluteFile != null && absoluteFile.e()) {
            if (this.f127186a == null) {
                String appId = dVar.getAppId();
                a aVar = new a(cVar, appId);
                this.f127186a = aVar;
                com.tencent.luggage.wxa.ic.e.a(appId, aVar);
            }
            b bVar = new b(dVar, i3, cVar);
            cVar.b(bVar);
            g b16 = cVar.b(absoluteFile.g());
            w.d("MicroMsg.JsApiStartPlayVoice", "play:%s", b16);
            if (b16.a()) {
                return;
            }
            w.b("MicroMsg.JsApiStartPlayVoice", "play fail %s", b16);
            dVar.a(i3, "fail:" + b16.f144873b);
            cVar.a(bVar);
            return;
        }
        w.b("MicroMsg.JsApiStartPlayVoice", "file is null, return");
        dVar.a(i3, makeReturnJson("file is not exist"));
    }
}
