package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.text.TextUtils;
import com.tencent.luggage.wxa.mc.a0;
import com.tencent.luggage.wxa.qb.c;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.luggage.wxa.xd.d;
import com.tencent.luggage.wxa.xd.o;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetAudioState;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.mobileqq.tritonaudio.WebAudioPlugin;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public class a extends com.tencent.luggage.wxa.xd.a {
    public static final int CTRL_INDEX = 297;
    public static final String NAME = "operateAudio";

    /* renamed from: a, reason: collision with root package name */
    public JsApiSetAudioState.AudioPlayerEventListenerTask f152056a;

    /* compiled from: P */
    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.audio.a$a, reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static final class C7056a extends com.tencent.luggage.wxa.zd.a {
        public long C;
        public long D;
        public String F;

        /* renamed from: c, reason: collision with root package name */
        public o f152057c;

        /* renamed from: d, reason: collision with root package name */
        public d f152058d;

        /* renamed from: e, reason: collision with root package name */
        public int f152059e;

        /* renamed from: j, reason: collision with root package name */
        public String f152064j;

        /* renamed from: k, reason: collision with root package name */
        public a0.a f152065k;

        /* renamed from: f, reason: collision with root package name */
        public String f152060f = "";

        /* renamed from: g, reason: collision with root package name */
        public String f152061g = "";

        /* renamed from: h, reason: collision with root package name */
        public String f152062h = "";

        /* renamed from: i, reason: collision with root package name */
        public int f152063i = 0;

        /* renamed from: l, reason: collision with root package name */
        public String f152066l = "";

        /* renamed from: m, reason: collision with root package name */
        public String f152067m = "";
        public boolean E = false;

        public C7056a(o oVar, d dVar, int i3) {
            this.f152057c = oVar;
            this.f152058d = dVar;
            this.f152059e = i3;
        }

        @Override // com.tencent.luggage.wxa.zd.f
        public void a() {
            w.d("MicroMsg.Audio.JsApiOperateAudio", "runTask operationType;%s", this.f152062h);
            this.E = false;
            String str = this.f152062h;
            if (str.equalsIgnoreCase("play")) {
                com.tencent.luggage.wxa.qb.b c16 = com.tencent.luggage.wxa.qb.c.c(this.f152061g);
                if (c16 == null) {
                    w.b("MicroMsg.Audio.JsApiOperateAudio", "play operate, playParam is null");
                    c16 = com.tencent.luggage.wxa.oi.b.a(this.f152058d, this.f152060f, this.f152061g, this.f152067m, this.f152064j, this.f152065k, this.f152066l);
                }
                if (c16 != null) {
                    c16.f138583t = this.C;
                    c16.f138584u = this.D;
                }
                if (c.a.a(this.f152061g, c16)) {
                    w.d("MicroMsg.Audio.JsApiOperateAudio", "play audio ok");
                } else if (com.tencent.luggage.wxa.qb.c.e(this.f152061g)) {
                    this.E = true;
                    this.F = "audio is playing, don't play again";
                } else {
                    this.E = true;
                    this.F = "play audio fail";
                }
            } else if (str.equalsIgnoreCase("pause")) {
                if (c.a.a(this.f152061g)) {
                    w.d("MicroMsg.Audio.JsApiOperateAudio", "pause audio ok");
                } else {
                    this.E = true;
                    this.F = "pause audio fail";
                }
            } else if (str.equalsIgnoreCase(InnerAudioPlugin.AUDIO_OPERATE_SEEK)) {
                w.d("MicroMsg.Audio.JsApiOperateAudio", "currentTime:%d", Integer.valueOf(this.f152063i));
                int i3 = this.f152063i;
                if (i3 < 0) {
                    w.b("MicroMsg.Audio.JsApiOperateAudio", "currentTime %d is invalid!", Integer.valueOf(i3));
                    this.E = true;
                    this.F = "currentTime is invalid";
                } else if (c.a.a(this.f152061g, i3)) {
                    w.d("MicroMsg.Audio.JsApiOperateAudio", "seek audio ok");
                } else {
                    this.E = true;
                    this.F = "seek audio fail";
                }
            } else if (str.equalsIgnoreCase("stop")) {
                if (c.a.b(this.f152061g)) {
                    w.d("MicroMsg.Audio.JsApiOperateAudio", "stop audio ok");
                } else {
                    this.E = true;
                    this.F = "stop audio fail";
                }
            } else {
                w.b("MicroMsg.Audio.JsApiOperateAudio", "operationType is invalid");
                this.E = true;
                this.F = "operationType is invalid";
            }
            if (this.E) {
                w.b("MicroMsg.Audio.JsApiOperateAudio", this.F);
            }
            b();
        }

        @Override // com.tencent.luggage.wxa.zd.a
        public void b() {
            super.b();
            d dVar = this.f152058d;
            if (dVar == null) {
                w.b("MicroMsg.Audio.JsApiOperateAudio", "server is null");
                return;
            }
            if (this.E) {
                dVar.a(this.f152059e, this.f152057c.makeReturnJson("fail:" + this.F));
                return;
            }
            dVar.a(this.f152059e, this.f152057c.makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS));
        }
    }

    @Override // com.tencent.luggage.wxa.xd.a
    public void invoke(d dVar, JSONObject jSONObject, int i3) {
        if (!com.tencent.luggage.wxa.oi.a.b(dVar.getAppId())) {
            w.b("MicroMsg.Audio.JsApiOperateAudio", "can't do operateAudio, App is paused or background");
            dVar.a(i3, makeReturnJson("fail:App is paused or background"));
            return;
        }
        if (jSONObject == null) {
            w.b("MicroMsg.Audio.JsApiOperateAudio", "operateAudio data is null");
            dVar.a(i3, makeReturnJson("fail:data is null"));
            return;
        }
        w.d("MicroMsg.Audio.JsApiOperateAudio", "operateAudio appId:%s, data:%s", dVar.getAppId(), jSONObject.toString());
        String optString = jSONObject.optString(WebAudioPlugin.AUDIO_ID);
        int optInt = jSONObject.optInt(InnerAudioPlugin.AUDIO_PROPERTY_CURRENTTIME, 0);
        String optString2 = jSONObject.optString("operationType");
        if (TextUtils.isEmpty(optString)) {
            w.b("MicroMsg.Audio.JsApiOperateAudio", "audioId is empty");
            dVar.a(i3, makeReturnJson("fail:audioId is empty"));
            return;
        }
        if (TextUtils.isEmpty(optString2)) {
            w.b("MicroMsg.Audio.JsApiOperateAudio", "operationType is empty");
            dVar.a(i3, makeReturnJson("fail:operationType is empty"));
            return;
        }
        if (this.f152056a == null) {
            this.f152056a = new JsApiSetAudioState.AudioPlayerEventListenerTask(dVar);
        }
        this.f152056a.f152010d = dVar.getAppId();
        this.f152056a.c();
        C7056a c7056a = new C7056a(this, dVar, i3);
        c7056a.f152060f = dVar.getAppId();
        c7056a.f152061g = optString;
        c7056a.f152063i = optInt;
        c7056a.f152062h = optString2;
        if (optString2.equalsIgnoreCase("play")) {
            long j3 = 0;
            long optLong = jSONObject.optLong("timestamp", 0L);
            long currentTimeMillis = System.currentTimeMillis();
            if (optLong > 0 && optLong < currentTimeMillis) {
                j3 = currentTimeMillis - optLong;
            }
            c7056a.C = j3;
            c7056a.D = currentTimeMillis;
        }
        com.tencent.luggage.wxa.oi.c a16 = com.tencent.luggage.wxa.oi.a.a(optString);
        if (a16 != null) {
            c7056a.f152064j = a16.f136531b;
            c7056a.f152065k = a16.f136530a;
            c7056a.f152067m = a16.f136532c;
        }
        c7056a.f152066l = z.i();
        c7056a.c();
    }
}
