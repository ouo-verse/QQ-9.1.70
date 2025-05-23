package com.tencent.luggage.wxa.ih;

import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.luggage.wxa.cp.v;
import com.tencent.luggage.wxa.ic.e;
import com.tencent.luggage.wxa.ih.d;
import com.tencent.luggage.wxa.rc.l;
import com.tencent.luggage.wxa.tk.i;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.qcircle.weseevideo.model.MediaConfig;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class f extends com.tencent.luggage.wxa.ih.b {
    public static final int CTRL_INDEX = 31;
    public static final String NAME = "startRecord";

    /* renamed from: a, reason: collision with root package name */
    public e.c f130398a;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a extends e.c {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f130399a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f130400b;

        public a(d dVar, String str) {
            this.f130399a = dVar;
            this.f130400b = str;
        }

        @Override // com.tencent.luggage.wxa.ic.e.c
        public void onDestroy() {
            w.d("MicroMsg.JsApiStartRecordVoice", MosaicConstants$JsFunction.FUNC_ON_DESTROY);
            com.tencent.luggage.wxa.ic.e.b(this.f130400b, f.this.f130398a);
            f.this.f130398a = null;
            this.f130399a.onDestroy();
        }

        @Override // com.tencent.luggage.wxa.ic.e.c
        public void onPause(e.d dVar) {
            w.d("MicroMsg.JsApiStartRecordVoice", MiniSDKConst.NOTIFY_EVENT_ONPAUSE);
            this.f130399a.onBackground();
        }

        @Override // com.tencent.luggage.wxa.ic.e.c
        public void onResume() {
            w.d("MicroMsg.JsApiStartRecordVoice", "onResume");
            this.f130399a.onForeground();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b extends d.b {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.d f130402a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f130403b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ d f130404c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f130405d;

        public b(com.tencent.luggage.wxa.xd.d dVar, int i3, d dVar2, String str) {
            this.f130402a = dVar;
            this.f130403b = i3;
            this.f130404c = dVar2;
            this.f130405d = str;
        }

        @Override // com.tencent.luggage.wxa.ih.d.b, com.tencent.luggage.wxa.ih.d.c
        public void a(String str, int i3, int i16) {
            i iVar = new i();
            if (this.f130402a.getFileSystem().createTempFileFrom(new v(str), f.this.b(str), true, iVar) == l.OK) {
                HashMap hashMap = new HashMap();
                hashMap.put("state", d.e.STOP.f130397a);
                hashMap.put("tempFilePath", iVar.f141499a);
                hashMap.put("duration", Integer.valueOf(i3));
                hashMap.put("fileSize", Integer.valueOf(i16));
                w.d("MicroMsg.JsApiStartRecordVoice", "startRecord ok:%s", hashMap);
                this.f130402a.a(this.f130403b, f.this.makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, hashMap));
            } else {
                w.b("MicroMsg.JsApiStartRecordVoice", "create file fail");
                this.f130402a.a(this.f130403b, f.this.makeReturnJson("fail:create file fail"));
            }
            this.f130404c.i(this.f130405d);
        }
    }

    @Override // com.tencent.luggage.wxa.ih.b
    public void a(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
        d dVar2 = (d) dVar.b(d.class);
        if (dVar2 == null) {
            w.b("MicroMsg.JsApiStartRecordVoice", "luggageRecorder is null, return");
            dVar.a(i3, makeReturnJson("fail:internal error"));
            return;
        }
        v allocTempFile = dVar.getFileSystem().allocTempFile("voice_" + System.currentTimeMillis() + MediaConfig.AUDIO_PCM_FILE_POSTFIX);
        if (allocTempFile == null) {
            w.b("MicroMsg.JsApiStartRecordVoice", "toTempFilePath, alloc file failed");
            dVar.a(i3, makeReturnJson("fail alloc file failed"));
            return;
        }
        d.C6305d c6305d = new d.C6305d();
        c6305d.f130381a = allocTempFile.g();
        if (jSONObject.has("duration")) {
            int optInt = jSONObject.optInt("duration") * 1000;
            c6305d.f130382b = optInt;
            if (optInt <= 0) {
                w.f("MicroMsg.JsApiStartRecordVoice", "duration is invalid, less than 0");
                c6305d.f130382b = 60000;
            }
            if (c6305d.f130382b > 600000) {
                w.h("MicroMsg.JsApiStartRecordVoice", "duration is invalid, more than %d", 600000);
                c6305d.f130382b = 600000;
            }
        }
        if (this.f130398a == null) {
            String appId = dVar.getAppId();
            a aVar = new a(dVar2, appId);
            this.f130398a = aVar;
            com.tencent.luggage.wxa.ic.e.a(appId, aVar);
        }
        String appId2 = dVar.getAppId();
        d.c c16 = dVar2.c(appId2);
        if (c16 == null) {
            c16 = new b(dVar, i3, dVar2, appId2);
        }
        dVar2.a(appId2, c16);
        com.tencent.luggage.wxa.hh.g a16 = dVar2.a(c6305d);
        w.d("MicroMsg.JsApiStartRecordVoice", "startRecord data:%s result:%s", jSONObject, a16);
        if (a16 == null || !a16.a()) {
            w.b("MicroMsg.JsApiStartRecordVoice", "startRecord fail");
            dVar.a(i3, makeReturnJson("fail:" + a16.f144873b));
            dVar2.i(appId2);
        }
    }
}
