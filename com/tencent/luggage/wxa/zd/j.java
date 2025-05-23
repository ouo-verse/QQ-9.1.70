package com.tencent.luggage.wxa.zd;

import android.text.TextUtils;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.mobileqq.tritonaudio.WebAudioPlugin;
import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public class j extends com.tencent.luggage.wxa.xd.a {
    public static final int CTRL_INDEX = 293;
    public static final String NAME = "getAudioState";

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class a extends com.tencent.luggage.wxa.zd.a {
        public double C;
        public String F;

        /* renamed from: c, reason: collision with root package name */
        public com.tencent.luggage.wxa.xd.o f146521c;

        /* renamed from: d, reason: collision with root package name */
        public com.tencent.luggage.wxa.xd.d f146522d;

        /* renamed from: e, reason: collision with root package name */
        public int f146523e;

        /* renamed from: i, reason: collision with root package name */
        public int f146527i;

        /* renamed from: j, reason: collision with root package name */
        public int f146528j;

        /* renamed from: k, reason: collision with root package name */
        public int f146529k;

        /* renamed from: l, reason: collision with root package name */
        public String f146530l;

        /* renamed from: m, reason: collision with root package name */
        public int f146531m;

        /* renamed from: f, reason: collision with root package name */
        public String f146524f = "";

        /* renamed from: g, reason: collision with root package name */
        public String f146525g = "";

        /* renamed from: h, reason: collision with root package name */
        public int f146526h = 0;
        public String D = null;
        public boolean E = false;

        public a(com.tencent.luggage.wxa.xd.o oVar, com.tencent.luggage.wxa.xd.d dVar, int i3) {
            this.f146521c = oVar;
            this.f146522d = dVar;
            this.f146523e = i3;
        }

        @Override // com.tencent.luggage.wxa.zd.f
        public void a() {
            int i3;
            com.tencent.luggage.wxa.qb.d d16 = com.tencent.luggage.wxa.qb.c.d(this.f146525g);
            if (d16 == null) {
                w.b("MicroMsg.Audio.JsApiGetAudioState", "audioState is null, audioId:%s", this.f146525g);
                this.E = true;
                this.F = "return parameter is invalid";
                b();
                return;
            }
            int i16 = d16.f138590a;
            if (i16 >= 0 && (i3 = d16.f138591b) >= 0) {
                this.f146526h = i16;
                this.f146527i = i3;
                this.f146528j = d16.f138592c ? 1 : 0;
                this.f146530l = d16.f138595f;
                this.f146529k = d16.f138594e;
                this.f146531m = d16.f138596g;
                this.D = d16.f138597h;
                com.tencent.luggage.wxa.qb.b c16 = com.tencent.luggage.wxa.qb.c.c(this.f146525g);
                if (c16 != null) {
                    this.C = c16.f138576m;
                }
                w.a("MicroMsg.Audio.JsApiGetAudioState", "duration: %d , currentTime: %d ,paused: %d , buffered: %d , src: %s, startTime:%d, playbackRate:%f", Integer.valueOf(this.f146526h), Integer.valueOf(this.f146527i), Integer.valueOf(this.f146528j), Integer.valueOf(this.f146529k), this.f146530l, Integer.valueOf(this.f146531m), Double.valueOf(this.C));
                b();
                return;
            }
            w.b("MicroMsg.Audio.JsApiGetAudioState", "return parameter is invalid, duration:%d, currentTime:%d", Integer.valueOf(i16), Integer.valueOf(d16.f138591b));
            this.E = true;
            this.F = "return parameter is invalid";
            b();
        }

        @Override // com.tencent.luggage.wxa.zd.a
        public void b() {
            boolean z16;
            String str;
            if (this.f146522d == null) {
                w.b("MicroMsg.Audio.JsApiGetAudioState", "service is null");
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("duration", Integer.valueOf(this.f146526h));
            hashMap.put(InnerAudioPlugin.AUDIO_PROPERTY_CURRENTTIME, Integer.valueOf(this.f146527i));
            if (this.f146528j == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            hashMap.put("paused", Boolean.valueOf(z16));
            hashMap.put(InnerAudioPlugin.AUDIO_PROPERTY_BUFFERED, Integer.valueOf(this.f146529k));
            hashMap.put("src", this.f146530l);
            hashMap.put("startTime", Integer.valueOf(this.f146531m));
            hashMap.put("playbackRate", Double.valueOf(this.C));
            hashMap.put("referrerPolicy", this.D);
            if (TextUtils.isEmpty(this.F)) {
                str = "";
            } else {
                str = this.F;
            }
            if (this.E) {
                w.b("MicroMsg.Audio.JsApiGetAudioState", "getAudioState fail, err:%s", str);
                this.f146522d.a(this.f146523e, this.f146521c.makeReturnJson("fail:" + str));
                return;
            }
            this.f146522d.a(this.f146523e, this.f146521c.makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, hashMap));
        }
    }

    @Override // com.tencent.luggage.wxa.xd.a
    public void invoke(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
        if (jSONObject == null) {
            w.b("MicroMsg.Audio.JsApiGetAudioState", "getAudioState data is null");
            dVar.a(i3, makeReturnJson("fail:data is null"));
            return;
        }
        String optString = jSONObject.optString(WebAudioPlugin.AUDIO_ID);
        if (TextUtils.isEmpty(optString)) {
            w.b("MicroMsg.Audio.JsApiGetAudioState", "getAudioState audioId is empty");
            dVar.a(i3, makeReturnJson("fail:audioId is empty"));
        } else {
            a aVar = new a(this, dVar, i3);
            aVar.f146524f = dVar.getAppId();
            aVar.f146525g = optString;
            aVar.c();
        }
    }
}
