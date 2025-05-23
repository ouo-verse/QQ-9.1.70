package com.tencent.luggage.jsapi.audio;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.luggage.wxa.ic.e;
import com.tencent.luggage.wxa.ic.l;
import com.tencent.luggage.wxa.nb.a;
import com.tencent.luggage.wxa.p9.h;
import com.tencent.luggage.wxa.tn.c0;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.xd.o;
import com.tencent.luggage.wxa.xd.p;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.data.MessageForQQStory;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class JsApiOperateMusicPlayer extends com.tencent.luggage.wxa.xd.a {
    public static final int CTRL_INDEX = 47;
    public static final String NAME = "operateMusicPlayer";

    /* renamed from: a, reason: collision with root package name */
    public OperateMusicPlayer f119969a;

    /* loaded from: classes2.dex */
    public static class OperateMusicPlayer extends com.tencent.luggage.wxa.wd.d {
        public static final Parcelable.Creator<OperateMusicPlayer> CREATOR = new f();

        /* renamed from: c, reason: collision with root package name */
        public a.c f119970c;

        /* renamed from: d, reason: collision with root package name */
        public e.c f119971d;

        /* renamed from: e, reason: collision with root package name */
        public o f119972e;

        /* renamed from: f, reason: collision with root package name */
        public l f119973f;

        /* renamed from: g, reason: collision with root package name */
        public int f119974g;

        /* renamed from: h, reason: collision with root package name */
        public String f119975h;

        /* renamed from: i, reason: collision with root package name */
        public String f119976i;

        /* renamed from: k, reason: collision with root package name */
        public String f119978k;

        /* renamed from: l, reason: collision with root package name */
        public int f119979l;

        /* renamed from: m, reason: collision with root package name */
        public String f119980m;

        /* renamed from: j, reason: collision with root package name */
        public boolean f119977j = false;
        public final IListener C = new IListener<h>(com.tencent.luggage.wxa.z8.b.f146383a) { // from class: com.tencent.luggage.jsapi.audio.JsApiOperateMusicPlayer.OperateMusicPlayer.6
            @Override // com.tencent.mm.sdk.event.IListener
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public boolean callback(h hVar) {
                w.d("MicroMsg.JsApiOperateMusicPlayer", "callback in(action : %s)", Integer.valueOf(hVar.f137468d.f137469a));
                com.tencent.luggage.wxa.rb.d dVar = hVar.f137468d.f137470b;
                if (dVar == null) {
                    return false;
                }
                String str = dVar.f139447i;
                HashMap hashMap = new HashMap();
                hashMap.put("dataUrl", str);
                OperateMusicPlayer.this.f119978k = new JSONObject(hashMap).toString();
                OperateMusicPlayer operateMusicPlayer = OperateMusicPlayer.this;
                operateMusicPlayer.f119979l = hVar.f137468d.f137469a;
                operateMusicPlayer.a();
                return false;
            }
        };

        /* loaded from: classes2.dex */
        public class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f119982a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ String f119983b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ String f119984c;

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ String f119985d;

            /* renamed from: e, reason: collision with root package name */
            public final /* synthetic */ String f119986e;

            /* renamed from: f, reason: collision with root package name */
            public final /* synthetic */ String f119987f;

            /* renamed from: g, reason: collision with root package name */
            public final /* synthetic */ String f119988g;

            public a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
                this.f119982a = str;
                this.f119983b = str2;
                this.f119984c = str3;
                this.f119985d = str4;
                this.f119986e = str5;
                this.f119987f = str6;
                this.f119988g = str7;
            }

            @Override // java.lang.Runnable
            public void run() {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("");
                sb5.append((OperateMusicPlayer.this.f119976i + this.f119982a + this.f119983b).hashCode());
                String sb6 = sb5.toString();
                String str = this.f119983b;
                com.tencent.luggage.wxa.rb.d a16 = com.tencent.luggage.wxa.rb.e.a(7, str, str, this.f119984c, this.f119985d, this.f119986e, this.f119987f, this.f119982a, sb6, com.tencent.luggage.wxa.db.a.e(), OperateMusicPlayer.this.a(this.f119983b), this.f119988g, "");
                a16.H = true;
                com.tencent.luggage.wxa.rb.a.a(a16);
                com.tencent.luggage.wxa.pi.b.b().a(OperateMusicPlayer.this.C, OperateMusicPlayer.this.f119976i);
                com.tencent.luggage.wxa.pi.b.b().c(OperateMusicPlayer.this.f119976i);
                com.tencent.luggage.wxa.pi.b.b().d(a16.f139441c);
                w.d("MicroMsg.JsApiOperateMusicPlayer", "startPlayMusic");
                OperateMusicPlayer operateMusicPlayer = OperateMusicPlayer.this;
                operateMusicPlayer.f119979l = -1;
                operateMusicPlayer.f119980m = "";
                operateMusicPlayer.f119977j = false;
                operateMusicPlayer.a();
            }
        }

        /* loaded from: classes2.dex */
        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                w.d("MicroMsg.JsApiOperateMusicPlayer", "resume ok");
                OperateMusicPlayer operateMusicPlayer = OperateMusicPlayer.this;
                operateMusicPlayer.f119979l = -1;
                operateMusicPlayer.f119980m = "";
                operateMusicPlayer.f119977j = false;
                operateMusicPlayer.a();
            }
        }

        /* loaded from: classes2.dex */
        public class c implements Runnable {
            public c() {
            }

            @Override // java.lang.Runnable
            public void run() {
                w.d("MicroMsg.JsApiOperateMusicPlayer", "pause ok");
                OperateMusicPlayer operateMusicPlayer = OperateMusicPlayer.this;
                operateMusicPlayer.f119979l = -1;
                operateMusicPlayer.f119977j = false;
                operateMusicPlayer.f119980m = "";
                operateMusicPlayer.a();
            }
        }

        /* loaded from: classes2.dex */
        public class d implements Runnable {
            public d() {
            }

            @Override // java.lang.Runnable
            public void run() {
                w.d("MicroMsg.JsApiOperateMusicPlayer", "seek ok");
                OperateMusicPlayer operateMusicPlayer = OperateMusicPlayer.this;
                operateMusicPlayer.f119979l = -1;
                operateMusicPlayer.f119977j = false;
                operateMusicPlayer.f119980m = "";
                operateMusicPlayer.a();
            }
        }

        /* loaded from: classes2.dex */
        public class e implements Runnable {
            public e() {
            }

            @Override // java.lang.Runnable
            public void run() {
                w.d("MicroMsg.JsApiOperateMusicPlayer", "stop ok");
                OperateMusicPlayer operateMusicPlayer = OperateMusicPlayer.this;
                operateMusicPlayer.f119979l = -1;
                operateMusicPlayer.f119977j = false;
                operateMusicPlayer.f119980m = "";
                operateMusicPlayer.a();
            }
        }

        /* loaded from: classes2.dex */
        public class f implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public OperateMusicPlayer createFromParcel(Parcel parcel) {
                return new OperateMusicPlayer(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public OperateMusicPlayer[] newArray(int i3) {
                return new OperateMusicPlayer[i3];
            }
        }

        public OperateMusicPlayer(o oVar, l lVar, int i3) {
            this.f119972e = oVar;
            this.f119973f = lVar;
            this.f119974g = i3;
        }

        @Override // com.tencent.luggage.wxa.wd.d, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeString(this.f119975h);
            parcel.writeString(this.f119976i);
            parcel.writeByte(this.f119977j ? (byte) 1 : (byte) 0);
            parcel.writeString(this.f119978k);
            parcel.writeInt(this.f119979l);
            parcel.writeString(this.f119980m);
        }

        public String a(String str) {
            return com.tencent.luggage.wxa.wm.b.a() + "/image/" + str.hashCode();
        }

        @Override // com.tencent.luggage.wxa.wd.d
        public void g() {
            String str;
            String str2;
            w.d("MicroMsg.JsApiOperateMusicPlayer", "runInClientProcess(action : %s)", Integer.valueOf(this.f119979l));
            l lVar = this.f119973f;
            int i3 = this.f119974g;
            o oVar = this.f119972e;
            if (this.f119977j) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("fail");
                if (TextUtils.isEmpty(this.f119980m)) {
                    str2 = "";
                } else {
                    str2 = ":" + this.f119980m;
                }
                sb5.append(str2);
                str = sb5.toString();
            } else {
                str = FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS;
            }
            lVar.a(i3, oVar.makeReturnJson(str));
            int i16 = this.f119979l;
            a aVar = null;
            if (i16 == 0) {
                w.d("MicroMsg.JsApiOperateMusicPlayer", "onMusicPlay in");
                new e(aVar).setContext(this.f119973f).setData(this.f119978k).e();
                this.f119970c.b("Music#isPlaying", Boolean.TRUE);
                com.tencent.luggage.wxa.ic.e.a(this.f119973f.getAppId(), this.f119971d);
                return;
            }
            if (i16 != 1) {
                if (i16 == 2) {
                    w.d("MicroMsg.JsApiOperateMusicPlayer", "onMusicStop in");
                    new c(aVar).setContext(this.f119973f).setData(this.f119978k).e();
                } else {
                    if (i16 == 3) {
                        w.d("MicroMsg.JsApiOperateMusicPlayer", "onMusicPause in");
                        new d(aVar).setContext(this.f119973f).setData(this.f119978k).e();
                        this.f119970c.b("Music#isPlaying", Boolean.FALSE);
                        com.tencent.luggage.wxa.ic.e.b(this.f119973f.getAppId(), this.f119971d);
                        return;
                    }
                    if (i16 == 4) {
                        w.d("MicroMsg.JsApiOperateMusicPlayer", "onMusicError in");
                        this.f119973f.a("onMusicError", this.f119978k);
                        this.f119970c.b("Music#isPlaying", Boolean.FALSE);
                        com.tencent.luggage.wxa.ic.e.b(this.f119973f.getAppId(), this.f119971d);
                        return;
                    }
                    if (i16 != 7) {
                        return;
                    }
                }
                w.d("MicroMsg.JsApiOperateMusicPlayer", "onMusicEnd in");
                this.f119970c.b("Music#isPlaying", Boolean.FALSE);
                com.tencent.luggage.wxa.ic.e.b(this.f119973f.getAppId(), this.f119971d);
                return;
            }
            w.d("MicroMsg.JsApiOperateMusicPlayer", "onMusicResume in");
            this.f119970c.b("Music#isPlaying", Boolean.TRUE);
            com.tencent.luggage.wxa.ic.e.a(this.f119973f.getAppId(), this.f119971d);
        }

        @Override // com.tencent.luggage.wxa.wd.d
        public void h() {
            try {
                JSONObject jSONObject = new JSONObject(this.f119975h);
                String optString = jSONObject.optString("operationType");
                String optString2 = jSONObject.optString("dataUrl");
                if (w0.c(optString)) {
                    this.f119979l = -1;
                    this.f119977j = true;
                    this.f119980m = "operationType is null or nil";
                    a();
                    return;
                }
                if (!com.tencent.luggage.wxa.pi.b.b().a(this.f119976i, optString)) {
                    w.d("MicroMsg.JsApiOperateMusicPlayer", "appid not match cannot operate");
                    this.f119979l = -1;
                    this.f119977j = true;
                    this.f119980m = "appid not match cannot operate";
                    a();
                    return;
                }
                if (com.tencent.luggage.wxa.rb.a.d() && !com.tencent.luggage.wxa.rb.a.c() && optString.equalsIgnoreCase("play")) {
                    com.tencent.luggage.wxa.rb.d b16 = com.tencent.luggage.wxa.rb.a.b();
                    if (b16 != null && (w0.c(optString2) || optString2.equals(b16.f139447i))) {
                        if (com.tencent.luggage.wxa.pi.b.b().a(this.f119976i, "resume")) {
                            w.d("MicroMsg.JsApiOperateMusicPlayer", "same appid %s, change play to resume", this.f119976i);
                            optString = "resume";
                        } else {
                            w.d("MicroMsg.JsApiOperateMusicPlayer", "not same not same appid ,restart play");
                        }
                    } else {
                        w.d("MicroMsg.JsApiOperateMusicPlayer", "data url has changed ,restart play");
                    }
                }
                if (optString.equalsIgnoreCase("play")) {
                    String optString3 = jSONObject.optString("title");
                    String optString4 = jSONObject.optString("singer");
                    String optString5 = jSONObject.optString("epname");
                    String optString6 = jSONObject.optString(MessageForQQStory.KEY_COVER_IMG_URL);
                    if (w0.c(optString2)) {
                        this.f119979l = -1;
                        this.f119977j = true;
                        this.f119980m = "dataUrl is null or nil";
                        a();
                        return;
                    }
                    w.d("MicroMsg.JsApiOperateMusicPlayer", "title : %s, singer : %s, epName : %s, coverImgUrl : %s, dataUrl : %s, lowbandUrl : %s, webUrl : %s", optString3, optString4, optString5, optString6, optString2, optString2, optString2);
                    com.tencent.luggage.wxa.rb.a.g();
                    String c16 = com.tencent.luggage.wxa.pi.b.b().c();
                    if (!w0.c(c16)) {
                        w.d("MicroMsg.JsApiOperateMusicPlayer", "remove listener preAppid is %s, appid is %s", c16, this.f119976i);
                        com.tencent.luggage.wxa.pi.b.b().b(c16);
                    }
                    c0.a(new a(optString2, optString6, optString3, optString4, optString2, optString2, optString5), 500L);
                    return;
                }
                if (optString.equalsIgnoreCase("resume")) {
                    String c17 = com.tencent.luggage.wxa.pi.b.b().c();
                    if (!w0.c(c17)) {
                        w.d("MicroMsg.JsApiOperateMusicPlayer", "remove listener preAppid is %s, appid is %s", c17, this.f119976i);
                        com.tencent.luggage.wxa.pi.b.b().b(c17);
                    }
                    com.tencent.luggage.wxa.pi.b.b().a(this.C, this.f119976i);
                    com.tencent.luggage.wxa.pi.b.b().c(this.f119976i);
                    com.tencent.luggage.wxa.rb.d b17 = com.tencent.luggage.wxa.rb.a.b();
                    if (b17 != null) {
                        com.tencent.luggage.wxa.pi.b.b().d(b17.f139441c);
                    }
                    if (com.tencent.luggage.wxa.rb.b.b()) {
                        c0.a(new b(), 500L);
                        return;
                    }
                    w.d("MicroMsg.JsApiOperateMusicPlayer", "resume fail");
                    this.f119979l = -1;
                    this.f119977j = true;
                    this.f119980m = "resume play fail";
                    a();
                    return;
                }
                if (optString.equalsIgnoreCase("pause")) {
                    if (com.tencent.luggage.wxa.rb.b.a()) {
                        c0.a(new c(), 500L);
                        return;
                    }
                    w.d("MicroMsg.JsApiOperateMusicPlayer", "pause fail");
                    this.f119979l = -1;
                    this.f119977j = true;
                    this.f119980m = "pause play fail";
                    a();
                    return;
                }
                if (optString.equalsIgnoreCase(InnerAudioPlugin.AUDIO_OPERATE_SEEK)) {
                    if (com.tencent.luggage.wxa.rb.b.a(w0.a(w0.a((Object) jSONObject.optString("position")), -1) * 1000)) {
                        c0.a(new d(), 500L);
                        return;
                    }
                    w.d("MicroMsg.JsApiOperateMusicPlayer", "seek fail");
                    this.f119979l = -1;
                    this.f119977j = true;
                    this.f119980m = "seek fail";
                    a();
                    return;
                }
                if (optString.equalsIgnoreCase("stop")) {
                    if (com.tencent.luggage.wxa.rb.b.c()) {
                        c0.a(new e(), 500L);
                        return;
                    }
                    w.d("MicroMsg.JsApiOperateMusicPlayer", "stop fail");
                    this.f119979l = -1;
                    this.f119977j = false;
                    this.f119980m = "stop play fail";
                    a();
                    return;
                }
                this.f119979l = -1;
                this.f119977j = true;
                a();
            } catch (Exception e16) {
                w.b("MicroMsg.JsApiOperateMusicPlayer", e16.toString());
                this.f119979l = -1;
                this.f119977j = true;
                this.f119980m = "data is null";
                a();
            }
        }

        @Override // com.tencent.luggage.wxa.wd.d
        public void a(Parcel parcel) {
            this.f119975h = parcel.readString();
            this.f119976i = parcel.readString();
            this.f119977j = parcel.readByte() != 0;
            this.f119978k = parcel.readString();
            this.f119979l = parcel.readInt();
            this.f119980m = parcel.readString();
        }

        public OperateMusicPlayer(Parcel parcel) {
            a(parcel);
        }
    }

    /* loaded from: classes2.dex */
    public class a extends e.c {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a.c f119994a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ l f119995b;

        public a(a.c cVar, l lVar) {
            this.f119994a = cVar;
            this.f119995b = lVar;
        }

        @Override // com.tencent.luggage.wxa.ic.e.c
        public void onDestroy() {
            w.a("MicroMsg.JsApiOperateMusicPlayer", MosaicConstants$JsFunction.FUNC_ON_DESTROY);
            String a16 = this.f119994a.a("appId", "");
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("operationType", "stop");
            } catch (JSONException unused) {
            }
            JsApiOperateMusicPlayer jsApiOperateMusicPlayer = JsApiOperateMusicPlayer.this;
            OperateMusicPlayer operateMusicPlayer = new OperateMusicPlayer(jsApiOperateMusicPlayer, this.f119995b, jsApiOperateMusicPlayer.f119969a.f119974g);
            operateMusicPlayer.f119975h = jSONObject.toString();
            operateMusicPlayer.f119976i = a16;
            operateMusicPlayer.f119979l = -1;
            operateMusicPlayer.f119970c = this.f119994a;
            operateMusicPlayer.c();
        }

        @Override // com.tencent.luggage.wxa.ic.e.c
        public void onPause(e.d dVar) {
            String a16 = this.f119994a.a("appId", "");
            this.f119994a.a("pkgType", 0);
            int i3 = b.f119997a[dVar.ordinal()];
            if (i3 == 1 || i3 == 2) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("operationType", "pause");
                } catch (JSONException unused) {
                }
                JsApiOperateMusicPlayer jsApiOperateMusicPlayer = JsApiOperateMusicPlayer.this;
                OperateMusicPlayer operateMusicPlayer = new OperateMusicPlayer(jsApiOperateMusicPlayer, this.f119995b, jsApiOperateMusicPlayer.f119969a.f119974g);
                operateMusicPlayer.f119975h = jSONObject.toString();
                operateMusicPlayer.f119976i = a16;
                operateMusicPlayer.f119970c = this.f119994a;
                operateMusicPlayer.b();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f119997a;

        static {
            int[] iArr = new int[e.d.values().length];
            f119997a = iArr;
            try {
                iArr[e.d.BACK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f119997a[e.d.CLOSE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class c extends p {
        private static final int CTRL_INDEX = 82;
        private static final String NAME = "onMusicEnd";

        public c() {
        }

        public /* synthetic */ c(a aVar) {
            this();
        }
    }

    /* loaded from: classes2.dex */
    public static final class d extends p {
        private static final int CTRL_INDEX = 81;
        private static final String NAME = "onMusicPause";

        public d() {
        }

        public /* synthetic */ d(a aVar) {
            this();
        }
    }

    /* loaded from: classes2.dex */
    public static final class e extends p {
        private static final int CTRL_INDEX = 80;
        private static final String NAME = "onMusicPlay";

        public e() {
        }

        public /* synthetic */ e(a aVar) {
            this();
        }
    }

    @Override // com.tencent.luggage.wxa.xd.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void invoke(l lVar, JSONObject jSONObject, int i3) {
        OperateMusicPlayer operateMusicPlayer;
        this.f119969a = new OperateMusicPlayer(this, lVar, i3);
        a.c a16 = com.tencent.luggage.wxa.nb.a.a().a(com.tencent.luggage.wxa.nb.a.b("AppBrandService#" + lVar.hashCode()), true);
        synchronized (a16) {
            if (((e.c) a16.a("AppBrandLifeCycle.Listener", (Object) null)) == null) {
                a16.b("appId", (Object) lVar.getAppId());
                a aVar = new a(a16, lVar);
                a16.b("AppBrandLifeCycle.Listener", aVar);
                this.f119969a.f119971d = aVar;
            }
            operateMusicPlayer = this.f119969a;
            operateMusicPlayer.f119970c = a16;
        }
        operateMusicPlayer.f119975h = jSONObject.toString();
        this.f119969a.f119976i = lVar.getAppId();
        this.f119969a.b();
    }
}
