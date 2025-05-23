package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Pair;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.tencent.luggage.wxa.cp.v;
import com.tencent.luggage.wxa.ic.e;
import com.tencent.luggage.wxa.nb.a;
import com.tencent.luggage.wxa.p9.h;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.wd.d;
import com.tencent.luggage.wxa.xd.o;
import com.tencent.mm.plugin.appbrand.jsapi.audio.b;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.data.MessageForQQStory;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public class JsApiSetBackgroundAudioState extends com.tencent.luggage.wxa.xd.a {
    public static final int CTRL_INDEX = 160;
    public static final String NAME = "setBackgroundAudioState";

    /* renamed from: a, reason: collision with root package name */
    public SetBackgroundAudioListenerTask f152027a;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class SetBackgroundAudioListenerTask extends d {
        public static final Parcelable.Creator<SetBackgroundAudioListenerTask> CREATOR = new a();

        /* renamed from: c, reason: collision with root package name */
        public e.c f152030c;

        /* renamed from: d, reason: collision with root package name */
        public o f152031d;

        /* renamed from: e, reason: collision with root package name */
        public com.tencent.luggage.wxa.xd.d f152032e;

        /* renamed from: f, reason: collision with root package name */
        public int f152033f;

        /* renamed from: g, reason: collision with root package name */
        public int f152034g;

        /* renamed from: h, reason: collision with root package name */
        public String f152035h;

        /* renamed from: i, reason: collision with root package name */
        public String f152036i;

        /* renamed from: j, reason: collision with root package name */
        public String f152037j;

        /* renamed from: k, reason: collision with root package name */
        public String f152038k;

        /* renamed from: l, reason: collision with root package name */
        public int f152039l;

        /* renamed from: m, reason: collision with root package name */
        public boolean f152040m = false;
        public int C = 0;
        public boolean D = false;

        /* compiled from: P */
        /* loaded from: classes9.dex */
        public final class MainProcessMusicPlayerEventListener extends IListener<h> {
            public MainProcessMusicPlayerEventListener() {
                super(com.tencent.luggage.wxa.z8.b.f146383a);
            }

            @Override // com.tencent.mm.sdk.event.IListener
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public boolean callback(h hVar) {
                boolean z16;
                String str;
                w.d("MicroMsg.Music.SetBackgroundAudioListenerTask", "musicPlayerListener callback action : %d", Integer.valueOf(hVar.f137468d.f137469a));
                HashMap hashMap = new HashMap();
                h.a aVar = hVar.f137468d;
                String str2 = aVar.f137473e;
                int i3 = aVar.f137469a;
                if (i3 == 10) {
                    String str3 = aVar.f137476h;
                    if (str3.equals(SetBackgroundAudioListenerTask.this.f152037j)) {
                        w.d("MicroMsg.Music.SetBackgroundAudioListenerTask", "appId is same, don't send ON_PREEMPTED event");
                        return false;
                    }
                    w.d("MicroMsg.Music.SetBackgroundAudioListenerTask", "send ON_PREEMPTED event, sender appId:%s,  receive appId:%s", str3, SetBackgroundAudioListenerTask.this.f152037j);
                    hashMap.put("state", str2);
                    SetBackgroundAudioListenerTask.this.f152038k = new JSONObject(hashMap).toString();
                    SetBackgroundAudioListenerTask setBackgroundAudioListenerTask = SetBackgroundAudioListenerTask.this;
                    setBackgroundAudioListenerTask.f152039l = hVar.f137468d.f137469a;
                    setBackgroundAudioListenerTask.a();
                    return true;
                }
                com.tencent.luggage.wxa.rb.d dVar = aVar.f137470b;
                if (dVar == null) {
                    w.b("MicroMsg.Music.SetBackgroundAudioListenerTask", "wrapper is null");
                    return false;
                }
                if (!aVar.f137474f) {
                    w.b("MicroMsg.Music.SetBackgroundAudioListenerTask", "is not from QQMusicPlayer, don't callback!");
                    return false;
                }
                if (i3 == 2 && aVar.f137475g) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    w.b("MicroMsg.Music.SetBackgroundAudioListenerTask", "isSwitchMusicIng, don't callback!");
                    return false;
                }
                String c16 = com.tencent.luggage.wxa.pi.b.b().c();
                if (!SetBackgroundAudioListenerTask.this.f152037j.equals(c16)) {
                    w.d("MicroMsg.Music.SetBackgroundAudioListenerTask", "appId is not equals preAppId, don't send any event, appId:%s, preAppId:%s", SetBackgroundAudioListenerTask.this.f152037j, c16);
                    return false;
                }
                hashMap.put("src", dVar.f139447i);
                hashMap.put("state", str2);
                hashMap.put("errCode", Integer.valueOf(hVar.f137468d.f137477i));
                if (!TextUtils.isEmpty(hVar.f137468d.f137478j)) {
                    str = hVar.f137468d.f137478j;
                } else {
                    str = "";
                }
                hashMap.put("errMsg", str);
                SetBackgroundAudioListenerTask.this.f152038k = new JSONObject(hashMap).toString();
                SetBackgroundAudioListenerTask setBackgroundAudioListenerTask2 = SetBackgroundAudioListenerTask.this;
                setBackgroundAudioListenerTask2.f152039l = hVar.f137468d.f137469a;
                setBackgroundAudioListenerTask2.a();
                return true;
            }
        }

        /* compiled from: P */
        /* loaded from: classes9.dex */
        public class a implements Parcelable.Creator<SetBackgroundAudioListenerTask> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SetBackgroundAudioListenerTask createFromParcel(Parcel parcel) {
                return new SetBackgroundAudioListenerTask(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SetBackgroundAudioListenerTask[] newArray(int i3) {
                return new SetBackgroundAudioListenerTask[i3];
            }
        }

        public SetBackgroundAudioListenerTask(com.tencent.luggage.wxa.xd.a aVar, com.tencent.luggage.wxa.xd.d dVar, int i3) {
            this.f152031d = aVar;
            this.f152032e = dVar;
            this.f152033f = i3;
        }

        public void a(int i3) {
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x002c, code lost:
        
            if (r0 != 4) goto L26;
         */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0056  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x0088  */
        /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:27:0x005d  */
        @Override // com.tencent.luggage.wxa.wd.d
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void g() {
            int i3;
            boolean z16;
            if (this.f152032e == null) {
                w.b("MicroMsg.Music.SetBackgroundAudioListenerTask", "service is null, don't callback");
                return;
            }
            a(this.f152039l);
            int i16 = this.f152039l;
            if (i16 != 7) {
                if (i16 != 13) {
                    if (i16 != 14) {
                        if (i16 != 0 && i16 != 1) {
                            if (i16 != 2) {
                                if (i16 != 3) {
                                }
                            }
                        } else {
                            e.a(this.f152037j, this.f152030c);
                            com.tencent.luggage.wxa.pi.a.f137604c.b(this.f152037j);
                        }
                        i3 = this.f152039l;
                        if (1 != i3) {
                            com.tencent.luggage.wxa.pi.a.f137604c.a(i3);
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        w.d("MicroMsg.Music.SetBackgroundAudioListenerTask", "runInClientProcess callback action:%d, retJson:%s", Integer.valueOf(this.f152039l), this.f152038k);
                        new b.c().setContext(this.f152032e).setData(this.f152038k).dispatch();
                        if (z16) {
                            com.tencent.luggage.wxa.pi.a.f137604c.a(this.f152039l);
                            return;
                        }
                        return;
                    }
                    b.a.b(this.f152032e);
                    return;
                }
                b.C7057b.b(this.f152032e);
                return;
            }
            e.b(this.f152037j, this.f152030c);
            i3 = this.f152039l;
            if (1 != i3) {
            }
            w.d("MicroMsg.Music.SetBackgroundAudioListenerTask", "runInClientProcess callback action:%d, retJson:%s", Integer.valueOf(this.f152039l), this.f152038k);
            new b.c().setContext(this.f152032e).setData(this.f152038k).dispatch();
            if (z16) {
            }
        }

        @Override // com.tencent.luggage.wxa.wd.d
        public void h() {
            w.d("MicroMsg.Music.SetBackgroundAudioListenerTask", "runInMainProcess");
            if (this.D) {
                com.tencent.luggage.wxa.pi.b.b().a(this.f152037j, this.C);
                return;
            }
            if (this.f152040m) {
                w.d("MicroMsg.Music.SetBackgroundAudioListenerTask", "send Preempted Event");
                this.f152040m = false;
                h hVar = new h();
                h.a aVar = hVar.f137468d;
                aVar.f137469a = 10;
                aVar.f137473e = com.tencent.luggage.wxa.sm.d.f140416h;
                aVar.f137476h = this.f152037j;
                aVar.f137474f = true;
                hVar.c();
            }
            String c16 = com.tencent.luggage.wxa.pi.b.b().c();
            if (!w0.c(c16)) {
                w.d("MicroMsg.Music.SetBackgroundAudioListenerTask", "remove listener preAppid is %s, appid is %s", c16, this.f152037j);
                com.tencent.luggage.wxa.pi.b.b().b(c16);
            }
            MainProcessMusicPlayerEventListener mainProcessMusicPlayerEventListener = new MainProcessMusicPlayerEventListener();
            this.C = mainProcessMusicPlayerEventListener.hashCode();
            com.tencent.luggage.wxa.pi.b.b().a(mainProcessMusicPlayerEventListener, this.f152037j);
            com.tencent.luggage.wxa.pi.b.b().a(this.f152037j, this.f152034g, this.f152035h, this.f152036i);
        }

        @Override // com.tencent.luggage.wxa.wd.d, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeString(this.f152037j);
            parcel.writeString(this.f152038k);
            parcel.writeInt(this.f152039l);
            parcel.writeInt(this.f152034g);
            parcel.writeString(this.f152035h);
            parcel.writeString(this.f152036i);
            parcel.writeInt(this.f152040m ? 1 : 0);
            parcel.writeInt(this.C);
            parcel.writeByte(this.D ? (byte) 1 : (byte) 0);
        }

        @Override // com.tencent.luggage.wxa.wd.d
        public void a(Parcel parcel) {
            this.f152037j = parcel.readString();
            this.f152038k = parcel.readString();
            this.f152039l = parcel.readInt();
            this.f152034g = parcel.readInt();
            this.f152035h = parcel.readString();
            this.f152036i = parcel.readString();
            this.f152040m = parcel.readInt() == 1;
            this.C = parcel.readInt();
            this.D = parcel.readByte() == 1;
        }

        public SetBackgroundAudioListenerTask(Parcel parcel) {
            a(parcel);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a extends e.c {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a.c f152042a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.xd.d f152043b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f152044c;

        public a(a.c cVar, com.tencent.luggage.wxa.xd.d dVar, int i3) {
            this.f152042a = cVar;
            this.f152043b = dVar;
            this.f152044c = i3;
        }

        @Override // com.tencent.luggage.wxa.ic.e.c
        public void onDestroy() {
            String a16 = this.f152042a.a("appId", "");
            w.d("MicroMsg.Music.JsApiSetBackgroundAudioState", "onDestroy, appId:%s", a16);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("operationType", "stop");
            } catch (JSONException unused) {
            }
            b bVar = new b(JsApiSetBackgroundAudioState.this, this.f152043b, this.f152044c);
            bVar.f152051h = jSONObject.toString();
            bVar.f152049f = a16;
            bVar.c();
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class b extends d {
        public static final Parcelable.Creator<b> CREATOR = new a();

        /* renamed from: c, reason: collision with root package name */
        public o f152046c;

        /* renamed from: d, reason: collision with root package name */
        public com.tencent.luggage.wxa.xd.d f152047d;

        /* renamed from: e, reason: collision with root package name */
        public int f152048e;

        /* renamed from: f, reason: collision with root package name */
        public String f152049f;

        /* renamed from: g, reason: collision with root package name */
        public String f152050g;

        /* renamed from: h, reason: collision with root package name */
        public String f152051h;

        /* renamed from: i, reason: collision with root package name */
        public boolean f152052i = false;

        /* renamed from: j, reason: collision with root package name */
        public String f152053j = "";

        /* renamed from: k, reason: collision with root package name */
        public String f152054k = null;

        /* renamed from: l, reason: collision with root package name */
        public String f152055l = null;

        /* compiled from: P */
        /* loaded from: classes9.dex */
        public class a implements Parcelable.Creator<b> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public b createFromParcel(Parcel parcel) {
                return new b(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public b[] newArray(int i3) {
                return new b[i3];
            }
        }

        public b(com.tencent.luggage.wxa.xd.a aVar, com.tencent.luggage.wxa.xd.d dVar, int i3) {
            this.f152046c = aVar;
            this.f152047d = dVar;
            this.f152048e = i3;
        }

        public String a(String str) {
            return com.tencent.luggage.wxa.wm.b.a() + "/image/" + str.hashCode();
        }

        @Override // com.tencent.luggage.wxa.wd.d
        public void g() {
            if (this.f152047d == null) {
                w.b("MicroMsg.Music.JsApiSetBackgroundAudioState", "service is null, don't callback");
                return;
            }
            if (!this.f152052i) {
                w.d("MicroMsg.Music.JsApiSetBackgroundAudioState", "setBackgroundAudioState ok");
                this.f152047d.a(this.f152048e, this.f152046c.makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS));
            } else {
                w.b("MicroMsg.Music.JsApiSetBackgroundAudioState", "setBackgroundAudioState fail:%s", this.f152053j);
                this.f152047d.a(this.f152048e, this.f152046c.makeReturnJson("fail:" + this.f152053j));
            }
            f();
        }

        @Override // com.tencent.luggage.wxa.wd.d
        public void h() {
            double d16;
            boolean z16;
            w.d("MicroMsg.Music.JsApiSetBackgroundAudioState", "runInMainProcess");
            try {
                JSONObject jSONObject = new JSONObject(this.f152051h);
                String optString = jSONObject.optString("src");
                String optString2 = jSONObject.optString("title");
                String optString3 = jSONObject.optString("epname");
                String optString4 = jSONObject.optString("singer");
                String optString5 = jSONObject.optString(MessageForQQStory.KEY_COVER_IMG_URL);
                String optString6 = jSONObject.optString("webUrl");
                String optString7 = jSONObject.optString(AudienceReportConst.PROTOCOL);
                double optDouble = jSONObject.optDouble("startTime", 0.0d);
                String optString8 = jSONObject.optString("songLyric");
                String str = optString5;
                double optDouble2 = jSONObject.optDouble("playbackRate", 1.0d);
                double optDouble3 = jSONObject.optDouble(InnerAudioPlugin.AUDIO_PROPERTY_VOLUME, 1.0d);
                String optString9 = jSONObject.optString("operationType");
                if (!TextUtils.isEmpty(optString9)) {
                    w.d("MicroMsg.Music.JsApiSetBackgroundAudioState", "come from onStickyBannerChanged pause or lifeCycleListener onDestroy");
                    String c16 = com.tencent.luggage.wxa.pi.b.b().c();
                    if (!w0.c(c16) && !c16.equals(this.f152049f)) {
                        w.d("MicroMsg.Music.JsApiSetBackgroundAudioState", "appid not match cannot operate, preAppId:%s, appId:%s", c16, this.f152049f);
                        return;
                    }
                    this.f152052i = false;
                    if (optString9.equalsIgnoreCase("pause")) {
                        if (com.tencent.luggage.wxa.rb.b.a()) {
                            w.d("MicroMsg.Music.JsApiSetBackgroundAudioState", "pause music ok");
                            return;
                        } else {
                            this.f152052i = true;
                            this.f152053j = "pause music fail";
                        }
                    } else if (optString9.equalsIgnoreCase("stop")) {
                        if (com.tencent.luggage.wxa.rb.b.c()) {
                            w.d("MicroMsg.Music.JsApiSetBackgroundAudioState", "stop music ok");
                            return;
                        } else {
                            this.f152052i = true;
                            this.f152053j = "stop music fail";
                        }
                    }
                    a();
                    return;
                }
                if (TextUtils.isEmpty(optString)) {
                    w.b("MicroMsg.Music.JsApiSetBackgroundAudioState", "src is null");
                    this.f152052i = true;
                    this.f152053j = "src is null";
                    a();
                    return;
                }
                if (optString8 != null && optString8.length() > 32768) {
                    w.b("MicroMsg.Music.JsApiSetBackgroundAudioState", "songLyric is large than 32KB");
                    this.f152052i = true;
                    this.f152053j = "songLyric is large than 32KB";
                    a();
                    return;
                }
                w.d("MicroMsg.Music.JsApiSetBackgroundAudioState", "src;%s, title:%s, epname:%s, singer:%s, coverImgUrl:%s, protocol:%s, webUrl:%s, startTime:%f, localPath:%s, playbackRate:%f", optString, optString2, optString3, optString4, str, optString7, optString6, Double.valueOf(optDouble), this.f152050g, Double.valueOf(optDouble2));
                if (optDouble2 >= 0.5d && optDouble2 <= 2.0d) {
                    d16 = optDouble2;
                } else {
                    d16 = 1.0d;
                }
                if (str == null) {
                    str = "";
                }
                if (TextUtils.isEmpty(optString8)) {
                    w.b("MicroMsg.Music.JsApiSetBackgroundAudioState", "songLyric is empty");
                } else {
                    w.d("MicroMsg.Music.JsApiSetBackgroundAudioState", "songLyric:%s", optString8);
                }
                StringBuilder sb5 = new StringBuilder();
                sb5.append("");
                sb5.append((this.f152049f + optString + str).hashCode());
                com.tencent.luggage.wxa.rb.d a16 = com.tencent.luggage.wxa.rb.e.a(i(), str, optString2, optString4, optString6, optString, optString, sb5.toString(), com.tencent.luggage.wxa.db.a.e(), a(str), optString3, this.f152049f);
                a16.J = (int) (1000.0d * optDouble);
                a16.L = optString7;
                a16.f139450l = optString8;
                a16.P = d16;
                if (this.f152050g.startsWith("file://")) {
                    a16.D = this.f152050g;
                }
                a16.U = this.f152054k;
                a16.V = this.f152055l;
                a16.Q = (float) optDouble3;
                com.tencent.luggage.wxa.pi.b.b().d(a16.f139441c);
                com.tencent.luggage.wxa.pi.b.b().a(a16);
                if (a16.b(com.tencent.luggage.wxa.rb.a.b()) && com.tencent.luggage.wxa.rb.a.c()) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    w.d("MicroMsg.Music.JsApiSetBackgroundAudioState", "play the music");
                    com.tencent.luggage.wxa.rb.a.a(a16);
                } else {
                    w.d("MicroMsg.Music.JsApiSetBackgroundAudioState", "The same music is playing");
                    com.tencent.luggage.wxa.rb.a.b(a16);
                }
                w.d("MicroMsg.Music.JsApiSetBackgroundAudioState", "runInMainProcess startPlayMusic");
                w.d("MicroMsg.Music.JsApiSetBackgroundAudioState", "setBackgroundAudioState ok");
                this.f152052i = false;
                a();
            } catch (JSONException e16) {
                w.b("MicroMsg.Music.JsApiSetBackgroundAudioState", "new json exists exception, data is invalid");
                this.f152052i = true;
                this.f152053j = "parser data fail, data is invalid";
                w.b("MicroMsg.Music.JsApiSetBackgroundAudioState", "exception:%s" + e16.getMessage());
                a();
            }
        }

        public int i() {
            return 11;
        }

        @Override // com.tencent.luggage.wxa.wd.d, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeString(this.f152049f);
            parcel.writeString(this.f152051h);
            parcel.writeInt(this.f152052i ? 1 : 0);
            parcel.writeString(this.f152053j);
            parcel.writeString(this.f152050g);
            parcel.writeString(this.f152054k);
            parcel.writeString(this.f152055l);
        }

        @Override // com.tencent.luggage.wxa.wd.d
        public void a(Parcel parcel) {
            this.f152049f = parcel.readString();
            this.f152051h = parcel.readString();
            this.f152052i = parcel.readInt() == 1;
            this.f152053j = parcel.readString();
            this.f152050g = parcel.readString();
            this.f152054k = parcel.readString();
            this.f152055l = parcel.readString();
        }

        public b(Parcel parcel) {
            a(parcel);
        }
    }

    public void a(String str, com.tencent.luggage.wxa.xd.d dVar) {
    }

    @Override // com.tencent.luggage.wxa.xd.a
    public void invoke(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
        if (jSONObject == null) {
            dVar.a(i3, makeReturnJson("fail:data is null"));
            w.b("MicroMsg.Music.JsApiSetBackgroundAudioState", "setBackgroundAudioState data is null");
            return;
        }
        String appId = dVar.getAppId();
        w.d("MicroMsg.Music.JsApiSetBackgroundAudioState", "setBackgroundAudioState appId:%s ,data:%s", appId, jSONObject.toString());
        if (this.f152027a == null) {
            this.f152027a = a(this, dVar, i3);
        }
        SetBackgroundAudioListenerTask setBackgroundAudioListenerTask = this.f152027a;
        setBackgroundAudioListenerTask.f152033f = i3;
        setBackgroundAudioListenerTask.f152037j = appId;
        setBackgroundAudioListenerTask.f152040m = true;
        final String b16 = com.tencent.luggage.wxa.nb.a.b("AppBrandService#" + dVar.hashCode());
        final LifecycleOwner lifecycleOwner = dVar.getLifecycleOwner();
        if (lifecycleOwner != null) {
            dVar.a(new Runnable() { // from class: com.tencent.mm.plugin.appbrand.jsapi.audio.c
                @Override // java.lang.Runnable
                public final void run() {
                    JsApiSetBackgroundAudioState.this.a(lifecycleOwner, b16);
                }
            });
        }
        a(b16, dVar);
        a.c a16 = com.tencent.luggage.wxa.nb.a.a().a(b16, true);
        synchronized (a16) {
            if (((e.c) a16.a("AppBrandLifeCycle.Listener", (Object) null)) == null) {
                a aVar = new a(a16, dVar, i3);
                a16.b("AppBrandLifeCycle.Listener", aVar);
                a16.b("appId", (Object) appId);
                this.f152027a.f152030c = aVar;
            }
        }
        this.f152027a.b();
        b b17 = b(this, dVar, i3);
        b17.f152048e = i3;
        b17.f152049f = appId;
        b17.f152051h = jSONObject.toString();
        b17.f152050g = a(jSONObject, dVar);
        Pair a17 = a(dVar, jSONObject);
        b17.f152054k = (String) a17.first;
        b17.f152055l = (String) a17.second;
        b17.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(LifecycleOwner lifecycleOwner, final String str) {
        lifecycleOwner.getLifecycle().addObserver(new LifecycleObserver() { // from class: com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetBackgroundAudioState.1
            @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
            public void onDestroyed() {
                SetBackgroundAudioListenerTask setBackgroundAudioListenerTask = JsApiSetBackgroundAudioState.this.f152027a;
                if (setBackgroundAudioListenerTask != null) {
                    setBackgroundAudioListenerTask.D = true;
                    setBackgroundAudioListenerTask.b();
                    JsApiSetBackgroundAudioState.this.f152027a.f();
                }
                a.c d16 = com.tencent.luggage.wxa.nb.a.a().d(str);
                if (d16 != null) {
                    d16.b();
                }
            }
        });
    }

    public b b(com.tencent.luggage.wxa.xd.a aVar, com.tencent.luggage.wxa.xd.d dVar, int i3) {
        return new b(this, dVar, i3);
    }

    public String a(JSONObject jSONObject, com.tencent.luggage.wxa.xd.d dVar) {
        String optString = jSONObject.optString("src");
        if (optString == null || optString.length() <= 0) {
            return "";
        }
        if (optString.startsWith("http://") || optString.startsWith("https://")) {
            return optString;
        }
        v absoluteFile = dVar.getFileSystem().getAbsoluteFile(optString);
        if (absoluteFile == null || !absoluteFile.e()) {
            return "";
        }
        String g16 = absoluteFile.g();
        if (g16.startsWith("file://")) {
            return g16;
        }
        return "file://" + g16;
    }

    public SetBackgroundAudioListenerTask a(com.tencent.luggage.wxa.xd.a aVar, com.tencent.luggage.wxa.xd.d dVar, int i3) {
        return new SetBackgroundAudioListenerTask(this, dVar, i3);
    }

    public final Pair a(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject) {
        com.tencent.luggage.wxa.cg.a aVar = (com.tencent.luggage.wxa.cg.a) com.tencent.luggage.wxa.h1.e.a(com.tencent.luggage.wxa.cg.a.class);
        String str = null;
        if (aVar == null) {
            w.f("MicroMsg.Music.JsApiSetBackgroundAudioState", "getReferrers, referrerHelper is null");
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
            w.d("MicroMsg.Music.JsApiSetBackgroundAudioState", "getReferrers, referrerPolicyStr: %s, referrer: %s", a16, str);
            return new Pair(a16, str);
        }
        str = "invalidReferrer";
        w.d("MicroMsg.Music.JsApiSetBackgroundAudioState", "getReferrers, referrerPolicyStr: %s, referrer: %s", a16, str);
        return new Pair(a16, str);
    }
}
