package com.tencent.luggage.wxa.xd;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.app.face.FaceConstant;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public class d1 extends com.tencent.luggage.wxa.xd.a {
    public static final int CTRL_INDEX = 445;
    public static final String NAME = "writeCommData";

    @Override // com.tencent.luggage.wxa.xd.a
    public void invoke(d dVar, JSONObject jSONObject, int i3) {
        new a(this, dVar, i3, jSONObject).b();
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class a extends com.tencent.luggage.wxa.wd.d {
        public static final Parcelable.Creator<a> CREATOR = new C6904a();

        /* renamed from: c, reason: collision with root package name */
        public o f144748c;

        /* renamed from: d, reason: collision with root package name */
        public d f144749d;

        /* renamed from: e, reason: collision with root package name */
        public int f144750e;

        /* renamed from: f, reason: collision with root package name */
        public String f144751f;

        /* renamed from: g, reason: collision with root package name */
        public String f144752g;

        /* renamed from: h, reason: collision with root package name */
        public boolean f144753h;

        /* renamed from: i, reason: collision with root package name */
        public String f144754i;

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.xd.d1$a$a, reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class C6904a implements Parcelable.Creator {
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

        public a(o oVar, d dVar, int i3, JSONObject jSONObject) {
            this.f144748c = oVar;
            this.f144749d = dVar;
            this.f144750e = i3;
            this.f144751f = jSONObject.optString("packageName");
            this.f144752g = jSONObject.optString("data");
            this.f144753h = true;
        }

        @Override // com.tencent.luggage.wxa.wd.d
        public void a(Parcel parcel) {
            this.f144751f = parcel.readString();
            this.f144752g = parcel.readString();
            boolean z16 = true;
            if (parcel.readInt() != 1) {
                z16 = false;
            }
            this.f144753h = z16;
            this.f144754i = parcel.readString();
        }

        @Override // com.tencent.luggage.wxa.wd.d
        public void g() {
            String format;
            if (this.f144753h) {
                if (com.tencent.luggage.wxa.tn.w0.c(this.f144754i)) {
                    format = "fail";
                } else {
                    format = String.format("fail:%s", this.f144754i);
                }
                this.f144749d.a(this.f144750e, this.f144748c.makeReturnJson(format));
                return;
            }
            this.f144749d.a(this.f144750e, this.f144748c.makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS));
        }

        @Override // com.tencent.luggage.wxa.wd.d
        public void h() {
            i();
            a();
        }

        public final void i() {
            if (com.tencent.luggage.wxa.tn.w0.c(this.f144751f)) {
                com.tencent.luggage.wxa.tn.w.b("MicroMsg.JsApiWriteCommData", "packageName nil");
                return;
            }
            Context c16 = com.tencent.luggage.wxa.tn.z.c();
            this.f144753h = !c16.getSharedPreferences(com.tencent.luggage.wxa.tn.z.h() + "_comm_preferences", 0).edit().putString(this.f144751f, this.f144752g).commit();
        }

        @Override // com.tencent.luggage.wxa.wd.d, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeString(this.f144751f);
            parcel.writeString(this.f144752g);
            parcel.writeInt(this.f144753h ? 1 : 0);
            parcel.writeString(this.f144754i);
        }

        public a(Parcel parcel) {
            a(parcel);
        }
    }
}
