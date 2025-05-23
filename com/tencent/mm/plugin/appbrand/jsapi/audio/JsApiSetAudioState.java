package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.text.TextUtils;
import android.util.Pair;
import com.tencent.luggage.wxa.cp.v;
import com.tencent.luggage.wxa.h1.e;
import com.tencent.luggage.wxa.mc.a0;
import com.tencent.luggage.wxa.oi.g;
import com.tencent.luggage.wxa.p9.c;
import com.tencent.luggage.wxa.qb.f;
import com.tencent.luggage.wxa.rc.l;
import com.tencent.luggage.wxa.tk.i;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.luggage.wxa.xd.d;
import com.tencent.luggage.wxa.xd.k0;
import com.tencent.luggage.wxa.xd.o;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.mobileqq.tritonaudio.WebAudioPlugin;
import java.nio.ByteBuffer;
import java.util.HashMap;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public class JsApiSetAudioState extends com.tencent.luggage.wxa.xd.a {
    public static final int CTRL_INDEX = 292;
    public static final String NAME = "setAudioState";

    /* renamed from: a, reason: collision with root package name */
    public AudioPlayerEventListenerTask f152008a;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class AudioPlayerEventListenerTask extends com.tencent.luggage.wxa.zd.a {

        /* renamed from: c, reason: collision with root package name */
        public d f152009c;

        /* renamed from: e, reason: collision with root package name */
        public String f152011e;

        /* renamed from: f, reason: collision with root package name */
        public int f152012f;

        /* renamed from: g, reason: collision with root package name */
        public String f152013g;

        /* renamed from: d, reason: collision with root package name */
        public String f152010d = "";

        /* renamed from: h, reason: collision with root package name */
        public IListener f152014h = new IListener<com.tencent.luggage.wxa.p9.c>(com.tencent.luggage.wxa.z8.b.f146383a) { // from class: com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetAudioState.AudioPlayerEventListenerTask.1
            @Override // com.tencent.mm.sdk.event.IListener
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public boolean callback(com.tencent.luggage.wxa.p9.c cVar) {
                String str = cVar.f137441d.f137446e;
                if (!AudioPlayerEventListenerTask.this.f152010d.equals(str)) {
                    w.d("MicroMsg.Audio.JsApiSetAudioState", "appId is not equals preAppId, don't send any event, appId:%s, eventAppId:%s, action:%d", AudioPlayerEventListenerTask.this.f152010d, str, Integer.valueOf(cVar.f137441d.f137442a));
                    return false;
                }
                HashMap hashMap = new HashMap();
                c.a aVar = cVar.f137441d;
                String str2 = aVar.f137445d;
                AudioPlayerEventListenerTask.this.f152013g = aVar.f137444c;
                w.a("MicroMsg.Audio.JsApiSetAudioState", "mAudioListener callback action:%d\uff0c audioId:%s, state:%s", Integer.valueOf(cVar.f137441d.f137442a), AudioPlayerEventListenerTask.this.f152013g, str2);
                hashMap.put("state", str2);
                hashMap.put(WebAudioPlugin.AUDIO_ID, AudioPlayerEventListenerTask.this.f152013g);
                AudioPlayerEventListenerTask audioPlayerEventListenerTask = AudioPlayerEventListenerTask.this;
                c.a aVar2 = cVar.f137441d;
                int i3 = aVar2.f137442a;
                audioPlayerEventListenerTask.f152012f = i3;
                if (i3 == 4) {
                    hashMap.put("errMsg", aVar2.f137448g);
                    hashMap.put("errCode", Integer.valueOf(cVar.f137441d.f137447f));
                } else if (i3 == 11) {
                    hashMap.put("timestamp", Long.valueOf(System.currentTimeMillis()));
                }
                AudioPlayerEventListenerTask.this.f152011e = new JSONObject(hashMap).toString();
                AudioPlayerEventListenerTask.this.b();
                return true;
            }
        };

        public AudioPlayerEventListenerTask(d dVar) {
            this.f152009c = dVar;
        }

        @Override // com.tencent.luggage.wxa.zd.a
        public void b() {
            if (this.f152009c == null) {
                w.b("MicroMsg.Audio.JsApiSetAudioState", "server is null");
                return;
            }
            w.d("MicroMsg.Audio.JsApiSetAudioState", "AudioListenerTask action:%d, retJson:%s", Integer.valueOf(this.f152012f), this.f152011e);
            if (w0.c(this.f152011e)) {
                w.b("MicroMsg.Audio.JsApiSetAudioState", "jsonResult is null, err");
                return;
            }
            a aVar = new a();
            com.tencent.luggage.wxa.ee.a a16 = com.tencent.luggage.wxa.zd.c.INSTANCE.a(this.f152010d);
            if (a16 != null && a16.a(this.f152013g) != null) {
                aVar.setContext(this.f152009c).setData(this.f152011e).dispatch(a16.a(this.f152013g));
            } else {
                aVar.setContext(this.f152009c).setData(this.f152011e).dispatch();
            }
        }

        @Override // com.tencent.luggage.wxa.zd.f
        public void a() {
            w.a("MicroMsg.Audio.JsApiSetAudioState", "AudioListenerTask, runTask");
            com.tencent.luggage.wxa.oi.a.e(this.f152010d);
            com.tencent.luggage.wxa.oi.a.a(this.f152010d, this.f152014h);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class a extends k0 {
        private static final int CTRL_INDEX = -2;
        private static final String NAME = "onAudioStateChange";
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class b extends com.tencent.luggage.wxa.zd.a {
        public double C;
        public double D;
        public long E;
        public long F;
        public String J;

        /* renamed from: c, reason: collision with root package name */
        public o f152016c;

        /* renamed from: d, reason: collision with root package name */
        public d f152017d;

        /* renamed from: e, reason: collision with root package name */
        public int f152018e;

        /* renamed from: l, reason: collision with root package name */
        public a0.a f152025l;

        /* renamed from: f, reason: collision with root package name */
        public String f152019f = "";

        /* renamed from: g, reason: collision with root package name */
        public String f152020g = "";

        /* renamed from: h, reason: collision with root package name */
        public String f152021h = "";

        /* renamed from: i, reason: collision with root package name */
        public int f152022i = 0;

        /* renamed from: j, reason: collision with root package name */
        public boolean f152023j = false;

        /* renamed from: k, reason: collision with root package name */
        public boolean f152024k = false;

        /* renamed from: m, reason: collision with root package name */
        public String f152026m = "";
        public String G = null;
        public String H = null;
        public boolean I = false;

        public b(o oVar, d dVar, int i3) {
            this.f152016c = oVar;
            this.f152017d = dVar;
            this.f152018e = i3;
        }

        @Override // com.tencent.luggage.wxa.zd.f
        public void a() {
            w.d("MicroMsg.Audio.JsApiSetAudioState", "SetAudioTask runTask");
            this.I = false;
            this.J = "";
            com.tencent.luggage.wxa.qb.b c16 = com.tencent.luggage.wxa.qb.c.c(this.f152020g);
            com.tencent.luggage.wxa.qb.b bVar = new com.tencent.luggage.wxa.qb.b();
            bVar.f138564a = this.f152020g;
            String str = this.f152021h;
            bVar.f138565b = str;
            int i3 = this.f152022i;
            bVar.f138567d = i3;
            bVar.f138568e = i3;
            bVar.f138570g = this.f152023j;
            bVar.f138571h = this.f152024k;
            bVar.f138574k = this.f152026m;
            bVar.f138575l = this.C;
            bVar.f138577n = this.f152019f;
            bVar.f138572i = 0;
            bVar.f138576m = this.D;
            bVar.f138581r = this.E;
            bVar.f138582s = this.F;
            bVar.f138585v = this.G;
            bVar.f138586w = this.H;
            if (c16 != null && str.equalsIgnoreCase(c16.f138565b) && com.tencent.luggage.wxa.qb.c.e(this.f152020g)) {
                w.d("MicroMsg.Audio.JsApiSetAudioState", "same src is playing audio, not to start again, but setAudioParam to update");
                if (!com.tencent.luggage.wxa.qb.c.a(bVar)) {
                    this.I = true;
                    this.J = "not to set audio param, the audioId is err";
                    w.b("MicroMsg.Audio.JsApiSetAudioState", "not to set audio param, the audioId is err");
                }
                b();
                return;
            }
            w.d("MicroMsg.Audio.JsApiSetAudioState", "appId:%s, audioId:%s, src:%s, startTime:%d", this.f152019f, this.f152020g, this.f152021h, Integer.valueOf(this.f152022i));
            if (this.f152021h.startsWith("file://")) {
                String substring = this.f152021h.substring(7);
                bVar.f138566c = substring;
                w.d("MicroMsg.Audio.JsApiSetAudioState", "filePath:%s", substring);
            } else if (this.f152021h.contains("base64") && this.f152021h.startsWith("data:audio")) {
                String str2 = this.f152021h;
                String a16 = g.a(str2.substring(str2.indexOf("base64,") + 7).trim());
                bVar.f138566c = a16;
                w.d("MicroMsg.Audio.JsApiSetAudioState", "base64 decode filePath:%s", a16);
            } else if (this.f152021h.startsWith("wxblob://")) {
                com.tencent.luggage.wxa.zd.c cVar = com.tencent.luggage.wxa.zd.c.INSTANCE;
                if (!cVar.b(this.f152019f)) {
                    cVar.a(this.f152017d, this.f152019f, com.tencent.luggage.wxa.qb.c.b());
                }
                i iVar = new i();
                if (this.f152017d.getFileSystem().readFile(this.f152021h, iVar) == l.OK) {
                    bVar.C = (ByteBuffer) iVar.f141499a;
                    bVar.f138566c = this.f152021h;
                    com.tencent.luggage.wxa.qb.c.b().a(this.f152021h);
                    w.d("MicroMsg.Audio.JsApiSetAudioState", "wxblob read ok");
                } else {
                    w.b("MicroMsg.Audio.JsApiSetAudioState", "wxblob read fail");
                    v privateAbsoluteFile = this.f152017d.getFileSystem().getPrivateAbsoluteFile(this.f152021h);
                    if (privateAbsoluteFile != null && privateAbsoluteFile.e()) {
                        bVar.f138566c = privateAbsoluteFile.g();
                    } else {
                        w.b("MicroMsg.Audio.JsApiSetAudioState", "wxblob localFile is null");
                        this.I = true;
                        this.J = "wxblob localFile is null";
                    }
                }
            } else if (!this.f152021h.startsWith("http://") && !this.f152021h.startsWith("https://")) {
                f a17 = com.tencent.luggage.wxa.oi.f.a(this.f152025l);
                if (a17 != null && a17.isOpen()) {
                    if (c16 != null && this.f152021h.equalsIgnoreCase(c16.f138565b) && !TextUtils.isEmpty(c16.f138566c)) {
                        bVar.f138566c = c16.f138566c;
                    } else {
                        bVar.f138566c = g.a(this.f152017d, this.f152021h);
                    }
                    bVar.f138588y = a17;
                } else {
                    IOUtils.closeQuietly(a17);
                    this.I = true;
                    this.J = "the file not exist for src";
                    w.b("MicroMsg.Audio.JsApiSetAudioState", "the wxa audioDataSource not found for src %s", this.f152021h);
                    b();
                    return;
                }
            }
            if (!this.I) {
                com.tencent.luggage.wxa.qb.c.b(bVar);
            }
            b();
        }

        @Override // com.tencent.luggage.wxa.zd.a
        public void b() {
            super.b();
            d dVar = this.f152017d;
            if (dVar == null) {
                w.b("MicroMsg.Audio.JsApiSetAudioState", "server is null");
                return;
            }
            if (this.I) {
                dVar.a(this.f152018e, this.f152016c.makeReturnJson("fail:" + this.J));
                return;
            }
            dVar.a(this.f152018e, this.f152016c.makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS));
        }
    }

    public a0.a a(d dVar, String str) {
        return null;
    }

    @Override // com.tencent.luggage.wxa.xd.a
    public void invoke(d dVar, JSONObject jSONObject, int i3) {
        if (!com.tencent.luggage.wxa.oi.a.b(dVar.getAppId())) {
            w.b("MicroMsg.Audio.JsApiSetAudioState", "can't do operateAudio, App is paused or background");
            dVar.a(i3, makeReturnJson("fail:App is paused or background"));
            return;
        }
        if (jSONObject == null) {
            w.b("MicroMsg.Audio.JsApiSetAudioState", "setAudioState data is null");
            dVar.a(i3, makeReturnJson("fail:data is null"));
            return;
        }
        w.d("MicroMsg.Audio.JsApiSetAudioState", "setAudioState data:%s", jSONObject.toString());
        String optString = jSONObject.optString(WebAudioPlugin.AUDIO_ID);
        int optInt = jSONObject.optInt("startTime", 0);
        String b16 = g.b(dVar, jSONObject.optString("src"));
        boolean optBoolean = jSONObject.optBoolean("autoplay", false);
        boolean optBoolean2 = jSONObject.optBoolean("loop", false);
        double d16 = 1.0d;
        double optDouble = jSONObject.optDouble(InnerAudioPlugin.AUDIO_PROPERTY_VOLUME, 1.0d);
        double optDouble2 = jSONObject.optDouble("playbackRate", 1.0d);
        if (optDouble2 >= 0.5d && optDouble2 <= 2.0d) {
            d16 = optDouble2;
        }
        double d17 = d16;
        Long valueOf = Long.valueOf(jSONObject.optLong("timestamp", 0L));
        Long l3 = 0L;
        Long valueOf2 = Long.valueOf(System.currentTimeMillis());
        if (optBoolean) {
            if (valueOf.longValue() > 0 && valueOf.longValue() <= valueOf2.longValue()) {
                l3 = Long.valueOf(valueOf2.longValue() - valueOf.longValue());
            }
        } else {
            valueOf2 = 0L;
        }
        if (TextUtils.isEmpty(optString)) {
            w.b("MicroMsg.Audio.JsApiSetAudioState", "audioId is empty");
            dVar.a(i3, makeReturnJson("fail:audioId is empty"));
            return;
        }
        if (TextUtils.isEmpty(b16)) {
            w.b("MicroMsg.Audio.JsApiSetAudioState", "src is empty");
            dVar.a(i3, makeReturnJson("fail:src is empty"));
            return;
        }
        if (this.f152008a == null) {
            this.f152008a = new AudioPlayerEventListenerTask(dVar);
        }
        this.f152008a.f152010d = dVar.getAppId();
        this.f152008a.c();
        b bVar = new b(this, dVar, i3);
        bVar.f152019f = dVar.getAppId();
        bVar.f152020g = optString;
        bVar.f152021h = b16;
        bVar.f152022i = optInt;
        bVar.f152023j = optBoolean;
        bVar.f152024k = optBoolean2;
        bVar.f152025l = a(dVar, b16);
        bVar.C = optDouble;
        bVar.D = d17;
        bVar.f152026m = z.i();
        bVar.E = l3.longValue();
        bVar.F = valueOf2.longValue();
        Pair a16 = a(dVar, jSONObject);
        bVar.G = (String) a16.first;
        bVar.H = (String) a16.second;
        bVar.c();
        com.tencent.luggage.wxa.oi.c cVar = new com.tencent.luggage.wxa.oi.c();
        cVar.f136530a = bVar.f152025l;
        cVar.f136531b = jSONObject.toString();
        cVar.f136532c = b16;
        com.tencent.luggage.wxa.oi.a.a(optString, cVar);
    }

    public final Pair a(d dVar, JSONObject jSONObject) {
        com.tencent.luggage.wxa.cg.a aVar = (com.tencent.luggage.wxa.cg.a) e.a(com.tencent.luggage.wxa.cg.a.class);
        String str = null;
        if (aVar == null) {
            return new Pair(null, "invalidReferrer");
        }
        String a16 = aVar.a(jSONObject);
        if (a16 != null) {
            com.tencent.luggage.wxa.cg.c e16 = aVar.e(a16);
            if (e16 == null) {
                e16 = aVar.b(dVar);
            }
            if (com.tencent.luggage.wxa.cg.c.NO_REFERRER != e16) {
                if (com.tencent.luggage.wxa.cg.c.ORIGIN == e16) {
                    str = aVar.c(dVar);
                }
            }
            return new Pair(a16, str);
        }
        str = "invalidReferrer";
        return new Pair(a16, str);
    }
}
