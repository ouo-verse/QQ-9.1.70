package com.tencent.luggage.wxa.fe;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.mobileqq.app.face.FaceConstant;
import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class b extends com.tencent.luggage.wxa.xd.a {
    public static final int CTRL_INDEX = 276;
    public static final String NAME = "checkIsSupportSoterAuthentication";

    /* renamed from: a, reason: collision with root package name */
    public a f126078a = null;

    @Override // com.tencent.luggage.wxa.xd.a
    public void invoke(com.tencent.luggage.wxa.xd.d dVar, JSONObject jSONObject, int i3) {
        w.d("MicroMsg.JsApiLuggageCheckIsSupportSoterAuthentication", "hy: subapp start do check is support soter authentication");
        a aVar = new a(dVar, i3, this);
        this.f126078a = aVar;
        aVar.b();
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class a extends com.tencent.luggage.wxa.wd.d {
        public static final Parcelable.Creator<a> CREATOR = new C6215a();

        /* renamed from: c, reason: collision with root package name */
        public com.tencent.luggage.wxa.xd.d f126079c;

        /* renamed from: d, reason: collision with root package name */
        public int f126080d;

        /* renamed from: e, reason: collision with root package name */
        public b f126081e;

        /* renamed from: f, reason: collision with root package name */
        public String f126082f;

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.fe.b$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C6215a implements Parcelable.Creator {
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

        public a(com.tencent.luggage.wxa.xd.d dVar, int i3, b bVar) {
            this.f126082f = "";
            this.f126079c = dVar;
            this.f126080d = i3;
            this.f126081e = bVar;
        }

        @Override // com.tencent.luggage.wxa.wd.d
        public void a(Parcel parcel) {
            super.a(parcel);
            this.f126082f = parcel.readString();
        }

        @Override // com.tencent.luggage.wxa.wd.d, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.tencent.luggage.wxa.wd.d
        public void g() {
            super.g();
            w.a("MicroMsg.GetIsSupportSoterTask", "hy: callback. verifyRemoteStr: %s", this.f126082f);
            HashMap hashMap = new HashMap(2);
            hashMap.put("verifyRemote", this.f126082f);
            hashMap.put("nativeSupport", Boolean.valueOf(com.tencent.luggage.wxa.bn.b.c()));
            w.d("MicroMsg.GetIsSupportSoterTask", "hy: nativeSupport:" + com.tencent.luggage.wxa.bn.b.c());
            this.f126079c.a(this.f126080d, this.f126081e.makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, hashMap));
            f();
        }

        @Override // com.tencent.luggage.wxa.wd.d
        public void h() {
            String b16 = com.tencent.luggage.wxa.bn.b.b();
            this.f126082f = b16;
            w.d("MicroMsg.GetIsSupportSoterTask", "hy: verifyRemoteStr: %s", b16);
            a();
        }

        @Override // com.tencent.luggage.wxa.wd.d, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeString(this.f126082f);
        }

        public a(Parcel parcel) {
            this.f126079c = null;
            this.f126080d = -1;
            this.f126082f = "";
            a(parcel);
        }
    }
}
