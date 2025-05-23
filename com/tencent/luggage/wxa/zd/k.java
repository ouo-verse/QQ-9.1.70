package com.tencent.luggage.wxa.zd;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.xd.v;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.data.MessageForQQStory;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public class k extends v {
    public static final int CTRL_INDEX = 159;
    public static final String NAME = "getBackgroundAudioState";

    @Override // com.tencent.luggage.wxa.xd.v
    public String a(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject) {
        boolean z16;
        String appId = dVar.getAppId();
        a aVar = new a();
        aVar.f146532c = appId;
        if (!aVar.c()) {
            w.b("MicroMsg.JsApiGetBackgroundAudioState", "getBackgroundAudioState fail");
            return makeReturnJson("fail");
        }
        HashMap hashMap = new HashMap();
        hashMap.put("duration", Double.valueOf(aVar.f146533d));
        hashMap.put(InnerAudioPlugin.AUDIO_PROPERTY_CURRENTTIME, Double.valueOf(aVar.f146534e));
        if (aVar.f146535f == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        hashMap.put("paused", Boolean.valueOf(z16));
        hashMap.put(InnerAudioPlugin.AUDIO_PROPERTY_BUFFERED, Double.valueOf(aVar.f146536g));
        hashMap.put("src", aVar.f146537h);
        hashMap.put("title", aVar.f146538i);
        hashMap.put("epname", aVar.f146539j);
        hashMap.put("singer", aVar.f146540k);
        hashMap.put(MessageForQQStory.KEY_COVER_IMG_URL, aVar.f146541l);
        hashMap.put("webUrl", aVar.f146542m);
        String str = aVar.C;
        String str2 = "";
        if (str == null) {
            str = "";
        }
        hashMap.put(AudienceReportConst.PROTOCOL, str);
        hashMap.put("startTime", Integer.valueOf(aVar.D / 1000));
        hashMap.put("songLyric", aVar.E);
        hashMap.put("playbackRate", Double.valueOf(aVar.F));
        hashMap.put("referrerPolicy", aVar.G);
        if (!TextUtils.isEmpty(aVar.I)) {
            str2 = aVar.I;
        }
        if (aVar.H) {
            w.b("MicroMsg.JsApiGetBackgroundAudioState", "getBackgroundAudioState fail, err:%s", str2);
            return makeReturnJson("fail:" + str2);
        }
        w.a("MicroMsg.JsApiGetBackgroundAudioState", "getBackgroundAudioState is ok");
        return makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, hashMap);
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class a extends com.tencent.luggage.wxa.wd.d {
        public static final Parcelable.Creator<a> CREATOR = new C6979a();
        public String C;
        public int D;
        public String E;
        public double F;
        public String I;

        /* renamed from: e, reason: collision with root package name */
        public double f146534e;

        /* renamed from: f, reason: collision with root package name */
        public int f146535f;

        /* renamed from: g, reason: collision with root package name */
        public double f146536g;

        /* renamed from: h, reason: collision with root package name */
        public String f146537h;

        /* renamed from: i, reason: collision with root package name */
        public String f146538i;

        /* renamed from: j, reason: collision with root package name */
        public String f146539j;

        /* renamed from: k, reason: collision with root package name */
        public String f146540k;

        /* renamed from: l, reason: collision with root package name */
        public String f146541l;

        /* renamed from: m, reason: collision with root package name */
        public String f146542m;

        /* renamed from: c, reason: collision with root package name */
        public String f146532c = "";

        /* renamed from: d, reason: collision with root package name */
        public double f146533d = 0.0d;
        public String G = null;
        public boolean H = false;

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.zd.k$a$a, reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class C6979a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public a createFromParcel(Parcel parcel) {
                return new a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public a[] newArray(int i3) {
                return new a[i3];
            }
        }

        public a() {
        }

        @Override // com.tencent.luggage.wxa.wd.d
        public void a(Parcel parcel) {
            this.f146532c = parcel.readString();
            this.f146533d = parcel.readDouble();
            this.f146534e = parcel.readDouble();
            this.f146535f = parcel.readInt();
            this.f146536g = parcel.readDouble();
            this.f146537h = parcel.readString();
            this.f146538i = parcel.readString();
            this.f146539j = parcel.readString();
            this.f146540k = parcel.readString();
            this.f146541l = parcel.readString();
            this.f146542m = parcel.readString();
            this.C = parcel.readString();
            this.E = parcel.readString();
            this.D = parcel.readInt();
            this.F = parcel.readDouble();
            this.G = parcel.readString();
        }

        @Override // com.tencent.luggage.wxa.wd.d
        public void h() {
            int i3;
            int i16;
            int i17;
            String c16 = com.tencent.luggage.wxa.pi.b.b().c();
            if (!w0.c(c16) && !c16.equals(this.f146532c)) {
                w.d("MicroMsg.JsApiGetBackgroundAudioState", "appid not match cannot get background audio state, preAppId:%s, appId:%s", c16, this.f146532c);
                this.H = true;
                this.I = "appid not match cannot get background audio state";
                a();
                return;
            }
            com.tencent.luggage.wxa.rb.d b16 = com.tencent.luggage.wxa.rb.a.b();
            if (b16 != null) {
                com.tencent.luggage.wxa.rb.c a16 = com.tencent.luggage.wxa.rb.a.a();
                if (a16 != null) {
                    i3 = a16.b();
                    i16 = a16.c();
                } else {
                    i3 = -1;
                    i16 = -1;
                }
                if (a16 != null && i3 >= 0 && i16 >= 0) {
                    this.f146533d = i3 / 1000.0d;
                    this.f146534e = i16 / 1000.0d;
                    int d16 = a16.d();
                    int a17 = a16.a();
                    double d17 = this.f146533d;
                    double d18 = 0.0d;
                    if (d17 > 0.0d) {
                        d18 = (a17 * d17) / 100.0d;
                    }
                    this.f146536g = d18;
                    if (d16 == 1) {
                        i17 = 0;
                    } else {
                        i17 = 1;
                    }
                    this.f146535f = i17;
                    this.f146537h = b16.f139447i;
                    this.f146538i = b16.f139443e;
                    this.f146539j = b16.f139445g;
                    this.f146540k = b16.f139444f;
                    this.f146541l = b16.f139446h;
                    this.f146542m = b16.f139449k;
                    this.C = b16.L;
                    this.D = b16.J;
                    this.E = b16.f139450l;
                    this.F = b16.P;
                    this.G = b16.U;
                    w.a("MicroMsg.JsApiGetBackgroundAudioState", "duration: %f , currentTime: %f ,paused: %d , buffered: %f , src: %s, startTime:%d, title:%s, singer:%s, webUrl:%s, coverImgUrl:%s, protocol:%s, playbackRate:%f, referrerPolicy: %s", Double.valueOf(d17), Double.valueOf(this.f146534e), Integer.valueOf(this.f146535f), Double.valueOf(this.f146536g), this.f146537h, Integer.valueOf(this.D), this.f146538i, this.f146540k, this.f146542m, this.f146541l, this.C, Double.valueOf(this.F), this.G);
                } else {
                    w.b("MicroMsg.JsApiGetBackgroundAudioState", "return parameter is invalid, duration_t:%d, position:%d", Integer.valueOf(i3), Integer.valueOf(i16));
                    this.H = true;
                    this.I = "return parameter is invalid";
                    a();
                    return;
                }
            } else {
                w.b("MicroMsg.JsApiGetBackgroundAudioState", "currentWrapper is null");
                this.H = true;
                this.I = "currentWrapper is null";
            }
            a();
        }

        @Override // com.tencent.luggage.wxa.wd.d, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeString(this.f146532c);
            parcel.writeDouble(this.f146533d);
            parcel.writeDouble(this.f146534e);
            parcel.writeInt(this.f146535f);
            parcel.writeDouble(this.f146536g);
            parcel.writeString(this.f146537h);
            parcel.writeString(this.f146538i);
            parcel.writeString(this.f146539j);
            parcel.writeString(this.f146540k);
            parcel.writeString(this.f146541l);
            parcel.writeString(this.f146542m);
            parcel.writeString(this.C);
            parcel.writeString(this.E);
            parcel.writeInt(this.D);
            parcel.writeDouble(this.F);
            parcel.writeString(this.G);
        }

        public a(Parcel parcel) {
            a(parcel);
        }
    }
}
