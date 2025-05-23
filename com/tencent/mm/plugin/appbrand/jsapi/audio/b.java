package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.xd.k0;
import com.tencent.luggage.wxa.xd.o;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetBackgroundAudioState;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public class b extends com.tencent.luggage.wxa.xd.a {
    public static final int CTRL_INDEX = 161;
    public static final String NAME = "operateBackgroundAudio";

    /* renamed from: a, reason: collision with root package name */
    public JsApiSetBackgroundAudioState.SetBackgroundAudioListenerTask f152068a;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class a extends k0 {
        private static final int CTRL_INDEX = 162;
        private static final String NAME = "onBackgroundAudioNext";

        /* renamed from: a, reason: collision with root package name */
        public static final a f152069a = new a();

        public static synchronized void b(com.tencent.luggage.wxa.xd.d dVar) {
            synchronized (a.class) {
                w.d("MicroMsg.Music.JsApiOperateBackgroundAudio", NAME);
                f152069a.setContext(dVar).dispatch();
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.audio.b$b, reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static final class C7057b extends k0 {
        private static final int CTRL_INDEX = 162;
        private static final String NAME = "onBackgroundAudioPrev";

        /* renamed from: a, reason: collision with root package name */
        public static final C7057b f152070a = new C7057b();

        public static synchronized void b(com.tencent.luggage.wxa.xd.d dVar) {
            synchronized (C7057b.class) {
                w.d("MicroMsg.Music.JsApiOperateBackgroundAudio", NAME);
                f152070a.setContext(dVar).dispatch();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class c extends k0 {
        private static final int CTRL_INDEX = 162;
        private static final String NAME = "onBackgroundAudioStateChange";
    }

    public JsApiSetBackgroundAudioState.SetBackgroundAudioListenerTask a(com.tencent.luggage.wxa.xd.a aVar, com.tencent.luggage.wxa.xd.d dVar, int i3) {
        return new JsApiSetBackgroundAudioState.SetBackgroundAudioListenerTask(this, dVar, i3);
    }

    @Override // com.tencent.luggage.wxa.xd.a
    public void invoke(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
        if (jSONObject == null) {
            dVar.a(i3, makeReturnJson("fail:data is null"));
            w.b("MicroMsg.Music.JsApiOperateBackgroundAudio", "operateBackgroundAudio data is null");
            return;
        }
        String appId = dVar.getAppId();
        w.d("MicroMsg.Music.JsApiOperateBackgroundAudio", "operateBackgroundAudio appId:%s", appId);
        if (this.f152068a == null) {
            this.f152068a = a(this, dVar, i3);
        }
        JsApiSetBackgroundAudioState.SetBackgroundAudioListenerTask setBackgroundAudioListenerTask = this.f152068a;
        setBackgroundAudioListenerTask.f152033f = i3;
        setBackgroundAudioListenerTask.f152037j = appId;
        b(dVar);
        d dVar2 = new d(this, dVar, i3);
        dVar2.f152073e = i3;
        dVar2.f152074f = appId;
        dVar2.f152075g = jSONObject.toString();
        dVar2.b();
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class d extends com.tencent.luggage.wxa.wd.d {
        public static final Parcelable.Creator<d> CREATOR = new a();

        /* renamed from: c, reason: collision with root package name */
        public o f152071c;

        /* renamed from: d, reason: collision with root package name */
        public com.tencent.luggage.wxa.xd.d f152072d;

        /* renamed from: e, reason: collision with root package name */
        public int f152073e;

        /* renamed from: f, reason: collision with root package name */
        public String f152074f;

        /* renamed from: g, reason: collision with root package name */
        public String f152075g;

        /* renamed from: h, reason: collision with root package name */
        public boolean f152076h = false;

        /* renamed from: i, reason: collision with root package name */
        public String f152077i = "";

        /* compiled from: P */
        /* loaded from: classes9.dex */
        public class a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public d createFromParcel(Parcel parcel) {
                return new d(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public d[] newArray(int i3) {
                return new d[i3];
            }
        }

        public d(com.tencent.luggage.wxa.xd.a aVar, com.tencent.luggage.wxa.xd.d dVar, int i3) {
            this.f152071c = aVar;
            this.f152072d = dVar;
            this.f152073e = i3;
        }

        @Override // com.tencent.luggage.wxa.wd.d
        public void a(Parcel parcel) {
            this.f152074f = parcel.readString();
            this.f152075g = parcel.readString();
            boolean z16 = true;
            if (parcel.readInt() != 1) {
                z16 = false;
            }
            this.f152076h = z16;
            this.f152077i = parcel.readString();
        }

        @Override // com.tencent.luggage.wxa.wd.d
        public void g() {
            if (this.f152072d == null) {
                w.b("MicroMsg.Music.JsApiOperateBackgroundAudio", "service is null, don't callback");
                return;
            }
            if (!this.f152076h) {
                w.d("MicroMsg.Music.JsApiOperateBackgroundAudio", "operateBackgroundAudio ok");
                this.f152072d.a(this.f152073e, this.f152071c.makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS));
            } else {
                w.b("MicroMsg.Music.JsApiOperateBackgroundAudio", "operateBackgroundAudio fail:%s", this.f152077i);
                this.f152072d.a(this.f152073e, this.f152071c.makeReturnJson("fail:" + this.f152077i));
            }
            f();
        }

        @Override // com.tencent.luggage.wxa.wd.d
        public void h() {
            w.d("MicroMsg.Music.JsApiOperateBackgroundAudio", "runInMainProcess");
            String c16 = com.tencent.luggage.wxa.pi.b.b().c();
            if (!w0.c(c16) && !c16.equals(this.f152074f)) {
                w.d("MicroMsg.Music.JsApiOperateBackgroundAudio", "appid not match cannot operate, preAppId:%s, appId:%s", c16, this.f152074f);
                this.f152076h = true;
                this.f152077i = "appid not match cannot operate";
                a();
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(this.f152075g);
                String optString = jSONObject.optString("operationType");
                double optDouble = jSONObject.optDouble(InnerAudioPlugin.AUDIO_PROPERTY_CURRENTTIME, -1.0d);
                if (TextUtils.isEmpty(optString)) {
                    w.b("MicroMsg.Music.JsApiOperateBackgroundAudio", "operationType is null");
                    this.f152076h = true;
                    this.f152077i = "operationType is null";
                    a();
                    return;
                }
                w.d("MicroMsg.Music.JsApiOperateBackgroundAudio", "operationType;%s, currentTime:%f", optString, Double.valueOf(optDouble));
                this.f152076h = false;
                if (optString.equalsIgnoreCase("play")) {
                    com.tencent.luggage.wxa.rb.d a16 = com.tencent.luggage.wxa.pi.b.b().a();
                    if (a16 == null) {
                        a16 = com.tencent.luggage.wxa.rb.a.b();
                    }
                    if (a16 != null) {
                        com.tencent.luggage.wxa.pi.b.b().d(a16.f139441c);
                    }
                    if (com.tencent.luggage.wxa.rb.b.b()) {
                        w.d("MicroMsg.Music.JsApiOperateBackgroundAudio", "play music ok");
                    } else if (com.tencent.luggage.wxa.rb.a.c()) {
                        this.f152076h = true;
                        this.f152077i = "music is playing, don't play again";
                    } else if (a16 != null && this.f152074f.equals(a16.E)) {
                        w.d("MicroMsg.Music.JsApiOperateBackgroundAudio", "startPlayMusic play music ok, appId is same!");
                        com.tencent.luggage.wxa.rb.a.a(a16);
                    } else {
                        this.f152076h = true;
                        this.f152077i = "play music fail";
                    }
                } else if (optString.equalsIgnoreCase("pause")) {
                    if (com.tencent.luggage.wxa.rb.b.a()) {
                        w.d("MicroMsg.Music.JsApiOperateBackgroundAudio", "pause music ok");
                    } else {
                        this.f152076h = true;
                        this.f152077i = "pause music fail";
                    }
                } else if (optString.equalsIgnoreCase(InnerAudioPlugin.AUDIO_OPERATE_SEEK)) {
                    if (optDouble < 0.0d) {
                        w.b("MicroMsg.Music.JsApiOperateBackgroundAudio", "currentTime is invalid!");
                        this.f152076h = true;
                        this.f152077i = "currentTime is invalid";
                    } else if (com.tencent.luggage.wxa.rb.b.a((int) (optDouble * 1000.0d))) {
                        w.d("MicroMsg.Music.JsApiOperateBackgroundAudio", "seek music ok");
                    } else {
                        this.f152076h = true;
                        this.f152077i = "seek music fail";
                    }
                } else if (optString.equalsIgnoreCase("stop")) {
                    if (com.tencent.luggage.wxa.rb.b.c()) {
                        w.d("MicroMsg.Music.JsApiOperateBackgroundAudio", "stop music ok");
                    } else {
                        this.f152076h = true;
                        this.f152077i = "stop music fail";
                    }
                } else {
                    w.b("MicroMsg.Music.JsApiOperateBackgroundAudio", "operationType is invalid");
                    this.f152076h = true;
                    this.f152077i = "operationType is invalid";
                }
                if (this.f152076h) {
                    w.b("MicroMsg.Music.JsApiOperateBackgroundAudio", this.f152077i);
                }
                a();
            } catch (JSONException e16) {
                w.b("MicroMsg.Music.JsApiOperateBackgroundAudio", "new json exists exception, data is invalid, jsonStr:%s", this.f152075g);
                this.f152076h = true;
                this.f152077i = "parser data fail, data is invalid";
                w.b("MicroMsg.Music.JsApiOperateBackgroundAudio", "exception:%s" + e16.getMessage());
                a();
            }
        }

        @Override // com.tencent.luggage.wxa.wd.d, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeString(this.f152074f);
            parcel.writeString(this.f152075g);
            parcel.writeInt(this.f152076h ? 1 : 0);
            parcel.writeString(this.f152077i);
        }

        public d(Parcel parcel) {
            a(parcel);
        }
    }

    public void b(com.tencent.luggage.wxa.xd.d dVar) {
    }
}
