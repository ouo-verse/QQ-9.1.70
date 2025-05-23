package com.tencent.luggage.wxa.fe;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.mobileqq.app.face.FaceConstant;
import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a extends com.tencent.luggage.wxa.xd.a {
    public static final int CTRL_INDEX = 344;
    public static final String NAME = "checkIsSoterEnrolledInDevice";

    /* renamed from: b, reason: collision with root package name */
    public static Context f126071b;

    /* renamed from: a, reason: collision with root package name */
    public C6213a f126072a = null;

    @Override // com.tencent.luggage.wxa.xd.a
    public void invoke(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
        f126071b = dVar.getContext();
        w.d("MicroMsg.JsApiLuggageCheckBioEnrollment", "hy: subapp start do check is enrolled");
        C6213a c6213a = new C6213a(dVar, i3, d.a(jSONObject.optString("checkAuthMode")), this);
        this.f126072a = c6213a;
        c6213a.b();
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.fe.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C6213a extends com.tencent.luggage.wxa.wd.d {
        public static final Parcelable.Creator<C6213a> CREATOR = new C6214a();

        /* renamed from: c, reason: collision with root package name */
        public com.tencent.luggage.wxa.xd.d f126073c;

        /* renamed from: d, reason: collision with root package name */
        public int f126074d;

        /* renamed from: e, reason: collision with root package name */
        public a f126075e;

        /* renamed from: f, reason: collision with root package name */
        public int f126076f;

        /* renamed from: g, reason: collision with root package name */
        public int f126077g;

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.fe.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C6214a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public C6213a createFromParcel(Parcel parcel) {
                return new C6213a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public C6213a[] newArray(int i3) {
                return new C6213a[i3];
            }
        }

        public C6213a(com.tencent.luggage.wxa.xd.d dVar, int i3, int i16, a aVar) {
            this.f126077g = -1;
            this.f126073c = dVar;
            this.f126074d = i3;
            this.f126075e = aVar;
            this.f126076f = i16;
        }

        @Override // com.tencent.luggage.wxa.wd.d
        public void a(Parcel parcel) {
            super.a(parcel);
            this.f126077g = parcel.readInt();
            this.f126076f = parcel.readInt();
        }

        @Override // com.tencent.luggage.wxa.wd.d, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.tencent.luggage.wxa.wd.d
        public void g() {
            super.g();
            boolean z16 = false;
            w.a("MicroMsg.GetIsEnrolledTask", "hy: callback. enrollResult: %d", Integer.valueOf(this.f126077g));
            HashMap hashMap = new HashMap(2);
            if (this.f126077g == 1) {
                z16 = true;
            }
            hashMap.put("isEnrolled", Boolean.valueOf(z16));
            int i3 = this.f126077g;
            if (i3 == 0) {
                this.f126073c.a(this.f126074d, this.f126075e.makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, hashMap));
            } else if (i3 == -1) {
                this.f126073c.a(this.f126074d, this.f126075e.makeReturnJson("fail not support", hashMap));
            } else if (i3 == 1) {
                this.f126073c.a(this.f126074d, this.f126075e.makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, hashMap));
            } else {
                this.f126073c.a(this.f126074d, this.f126075e.makeReturnJson("fail unknown error", hashMap));
            }
            f();
        }

        @Override // com.tencent.luggage.wxa.wd.d
        public void h() {
            int a16 = com.tencent.luggage.wxa.bn.b.a(a.f126071b, this.f126076f);
            this.f126077g = a16;
            w.d("MicroMsg.GetIsEnrolledTask", "hy: enrollResult: %d", Integer.valueOf(a16));
            a();
        }

        @Override // com.tencent.luggage.wxa.wd.d, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeInt(this.f126077g);
            parcel.writeInt(this.f126076f);
        }

        public C6213a(Parcel parcel) {
            this.f126073c = null;
            this.f126074d = -1;
            this.f126076f = -1;
            this.f126077g = -1;
            a(parcel);
        }
    }
}
