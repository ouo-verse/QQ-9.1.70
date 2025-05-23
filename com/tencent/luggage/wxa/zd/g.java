package com.tencent.luggage.wxa.zd;

import android.text.TextUtils;
import com.tencent.luggage.wxa.ic.e;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.xd.v;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.tritonaudio.WebAudioPlugin;
import java.util.HashMap;
import java.util.Vector;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public class g extends v {
    public static final int CTRL_INDEX = 291;
    public static final String NAME = "createAudioInstance";

    /* renamed from: a, reason: collision with root package name */
    public static Vector f146504a = new Vector();

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a extends e.c {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f146505a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.d f146506b;

        public a(String str, com.tencent.luggage.wxa.xd.d dVar) {
            this.f146505a = str;
            this.f146506b = dVar;
        }

        @Override // com.tencent.luggage.wxa.ic.e.c
        public void onCreate() {
            com.tencent.luggage.wxa.oi.a.a(this.f146505a, true);
        }

        @Override // com.tencent.luggage.wxa.ic.e.c
        public void onDestroy() {
            w.d("MicroMsg.Audio.JsApiCreateAudioInstance", "onDestroy, appId:%s", this.f146505a);
            b bVar = new b();
            bVar.f146510f = 2;
            bVar.f146507c = this.f146505a;
            bVar.d();
            com.tencent.luggage.wxa.ic.e.b(this.f146505a, this);
            g.f146504a.remove(this.f146505a);
            c.INSTANCE.a(this.f146506b, this.f146505a);
        }

        @Override // com.tencent.luggage.wxa.ic.e.c
        public void onPause(e.d dVar) {
            w.d("MicroMsg.Audio.JsApiCreateAudioInstance", "onPause, appId:%s", this.f146505a);
            com.tencent.luggage.wxa.oi.a.a(this.f146505a, false);
            b bVar = new b();
            bVar.f146510f = 1;
            bVar.f146507c = this.f146505a;
            bVar.c();
        }

        @Override // com.tencent.luggage.wxa.ic.e.c
        public void onResume() {
            com.tencent.luggage.wxa.oi.a.a(this.f146505a, true);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class b extends com.tencent.luggage.wxa.zd.a {

        /* renamed from: c, reason: collision with root package name */
        public String f146507c = "";

        /* renamed from: d, reason: collision with root package name */
        public String f146508d = "";

        /* renamed from: e, reason: collision with root package name */
        public String f146509e = "";

        /* renamed from: f, reason: collision with root package name */
        public int f146510f = 0;

        @Override // com.tencent.luggage.wxa.zd.f
        public void a() {
            w.d("MicroMsg.Audio.JsApiCreateAudioInstance", "runTask flag:%d", Integer.valueOf(this.f146510f));
            this.f146509e = "";
            int i3 = this.f146510f;
            if (i3 == 0) {
                String a16 = com.tencent.luggage.wxa.qb.c.a(this.f146507c, this.f146508d);
                this.f146508d = a16;
                w.d("MicroMsg.Audio.JsApiCreateAudioInstance", "player audioId:%s", a16);
                if (TextUtils.isEmpty(this.f146508d)) {
                    this.f146509e = "fail to create audio instance";
                }
            } else if (i3 == 1) {
                w.d("MicroMsg.Audio.JsApiCreateAudioInstance", "pauseAllAudioPlayer");
                com.tencent.luggage.wxa.qb.c.h(this.f146507c);
            } else if (i3 == 2) {
                w.d("MicroMsg.Audio.JsApiCreateAudioInstance", "stopAllAudioPlayer");
                com.tencent.luggage.wxa.qb.c.a(this.f146507c);
                com.tencent.luggage.wxa.oi.a.e(this.f146507c);
            }
            b();
        }

        @Override // com.tencent.luggage.wxa.zd.a
        public void b() {
            super.b();
            int i3 = this.f146510f;
            if (i3 == 0) {
                if (!TextUtils.isEmpty(this.f146508d)) {
                    w.d("MicroMsg.Audio.JsApiCreateAudioInstance", "create player ok");
                    return;
                } else {
                    w.b("MicroMsg.Audio.JsApiCreateAudioInstance", "create player failed");
                    return;
                }
            }
            if (i3 != 1) {
                w.b("MicroMsg.Audio.JsApiCreateAudioInstance", "destroy audio instance end");
            }
        }
    }

    public static String b(com.tencent.luggage.wxa.xd.d dVar) {
        String appId = dVar.getAppId();
        String a16 = com.tencent.luggage.wxa.lm.h.a();
        w.d("MicroMsg.Audio.JsApiCreateAudioInstance", "createAudioInstance appId:%s, audioId:%s", appId, a16);
        b bVar = new b();
        bVar.f146508d = a16;
        bVar.f146510f = 0;
        bVar.f146507c = appId;
        bVar.c();
        a aVar = new a(appId, dVar);
        if (!f146504a.contains(appId)) {
            com.tencent.luggage.wxa.ic.e.a(appId, aVar);
            f146504a.add(appId);
        }
        return a16;
    }

    @Override // com.tencent.luggage.wxa.xd.v
    public String a(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        hashMap.put(WebAudioPlugin.AUDIO_ID, b(dVar));
        return makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, hashMap);
    }
}
