package com.tencent.luggage.wxa.zd;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.mobileqq.app.face.FaceConstant;
import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public class l extends com.tencent.luggage.wxa.xd.a {
    public static final int CTRL_INDEX = 46;
    public static final String NAME = "getMusicPlayerState";

    /* renamed from: a, reason: collision with root package name */
    public a f146543a;

    @Override // com.tencent.luggage.wxa.xd.a
    public void invoke(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
        a aVar = new a(this, dVar, i3);
        this.f146543a = aVar;
        aVar.f146547f = dVar.getAppId();
        this.f146543a.b();
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class a extends com.tencent.luggage.wxa.wd.d {
        public static final Parcelable.Creator<a> CREATOR = new C6980a();

        /* renamed from: c, reason: collision with root package name */
        public com.tencent.luggage.wxa.xd.o f146544c;

        /* renamed from: d, reason: collision with root package name */
        public com.tencent.luggage.wxa.xd.d f146545d;

        /* renamed from: e, reason: collision with root package name */
        public int f146546e;

        /* renamed from: f, reason: collision with root package name */
        public String f146547f;

        /* renamed from: g, reason: collision with root package name */
        public boolean f146548g = false;

        /* renamed from: h, reason: collision with root package name */
        public int f146549h;

        /* renamed from: i, reason: collision with root package name */
        public int f146550i;

        /* renamed from: j, reason: collision with root package name */
        public int f146551j;

        /* renamed from: k, reason: collision with root package name */
        public int f146552k;

        /* renamed from: l, reason: collision with root package name */
        public String f146553l;

        /* renamed from: m, reason: collision with root package name */
        public String f146554m;

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.zd.l$a$a, reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class C6980a implements Parcelable.Creator {
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

        public a(com.tencent.luggage.wxa.xd.o oVar, com.tencent.luggage.wxa.xd.d dVar, int i3) {
            this.f146544c = oVar;
            this.f146545d = dVar;
            this.f146546e = i3;
        }

        @Override // com.tencent.luggage.wxa.wd.d
        public void a(Parcel parcel) {
            boolean z16;
            this.f146547f = parcel.readString();
            if (parcel.readByte() != 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.f146548g = z16;
            this.f146549h = parcel.readInt();
            this.f146550i = parcel.readInt();
            this.f146551j = parcel.readInt();
            this.f146552k = parcel.readInt();
            this.f146553l = parcel.readString();
            this.f146554m = parcel.readString();
        }

        @Override // com.tencent.luggage.wxa.wd.d
        public void g() {
            String str;
            String str2;
            HashMap hashMap = new HashMap();
            hashMap.put("duration", Integer.valueOf(this.f146549h));
            hashMap.put("currentPosition", Integer.valueOf(this.f146550i));
            hashMap.put("status", Integer.valueOf(this.f146551j));
            hashMap.put("downloadPercent", Integer.valueOf(this.f146552k));
            hashMap.put("dataUrl", this.f146553l);
            com.tencent.luggage.wxa.xd.d dVar = this.f146545d;
            int i3 = this.f146546e;
            com.tencent.luggage.wxa.xd.o oVar = this.f146544c;
            if (this.f146548g) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("fail");
                if (TextUtils.isEmpty(this.f146554m)) {
                    str2 = "";
                } else {
                    str2 = ":" + this.f146554m;
                }
                sb5.append(str2);
                str = sb5.toString();
            } else {
                str = FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS;
            }
            dVar.a(i3, oVar.makeReturnJson(str, hashMap));
        }

        @Override // com.tencent.luggage.wxa.wd.d
        public void h() {
            int i3;
            int i16;
            String c16 = com.tencent.luggage.wxa.pi.b.b().c();
            if (!w0.c(c16) && !c16.equals(this.f146547f)) {
                w.d("MicroMsg.JsApiGetMusicPlayerState", "appid not match cannot operate");
                this.f146548g = true;
                this.f146554m = "appid not match cannot operate";
                a();
                return;
            }
            com.tencent.luggage.wxa.rb.d b16 = com.tencent.luggage.wxa.rb.a.b();
            if (b16 != null) {
                com.tencent.luggage.wxa.rb.c a16 = com.tencent.luggage.wxa.rb.a.a();
                if (a16 != null) {
                    i3 = a16.b();
                    i16 = a16.c();
                    this.f146551j = a16.d();
                    this.f146552k = a16.a();
                } else {
                    i3 = -1;
                    i16 = -1;
                }
                this.f146549h = i3 / 1000;
                this.f146550i = i16 / 1000;
                this.f146553l = b16.f139447i;
                this.f146554m = "";
                this.f146548g = false;
            } else {
                this.f146551j = 2;
                this.f146554m = "";
                this.f146548g = false;
            }
            w.d("MicroMsg.JsApiGetMusicPlayerState", "duration %d , position %d ,status %s , downloadpercent %d , dataurl %s", Integer.valueOf(this.f146549h), Integer.valueOf(this.f146550i), Integer.valueOf(this.f146551j), Integer.valueOf(this.f146552k), this.f146553l);
            a();
        }

        @Override // com.tencent.luggage.wxa.wd.d, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeString(this.f146547f);
            parcel.writeByte(this.f146548g ? (byte) 1 : (byte) 0);
            parcel.writeInt(this.f146549h);
            parcel.writeInt(this.f146550i);
            parcel.writeInt(this.f146551j);
            parcel.writeInt(this.f146552k);
            parcel.writeString(this.f146553l);
            parcel.writeString(this.f146554m);
        }

        public a(Parcel parcel) {
            a(parcel);
        }
    }
}
