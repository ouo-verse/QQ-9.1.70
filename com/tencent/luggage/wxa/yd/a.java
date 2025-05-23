package com.tencent.luggage.wxa.yd;

import android.content.pm.PackageInfo;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.luggage.wxa.tk.b;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.tn.z;
import com.tencent.luggage.wxa.xd.d;
import com.tencent.luggage.wxa.xd.o;
import com.tencent.mobileqq.app.face.FaceConstant;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public class a extends com.tencent.luggage.wxa.xd.a {
    public static final int CTRL_INDEX = 439;
    public static final String NAME = "getInstallState";

    @Override // com.tencent.luggage.wxa.xd.a
    public void invoke(d dVar, JSONObject jSONObject, int i3) {
        w.a("MicroMsg.JsApiGetInstallState", "invoke");
        new C6950a(this, dVar, i3, jSONObject).b();
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.yd.a$a, reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C6950a extends com.tencent.luggage.wxa.wd.d {
        public static final Parcelable.Creator<C6950a> CREATOR = new C6951a();

        /* renamed from: c, reason: collision with root package name */
        public o f145540c;

        /* renamed from: d, reason: collision with root package name */
        public d f145541d;

        /* renamed from: e, reason: collision with root package name */
        public int f145542e;

        /* renamed from: f, reason: collision with root package name */
        public String f145543f;

        /* renamed from: g, reason: collision with root package name */
        public String f145544g;

        /* renamed from: h, reason: collision with root package name */
        public JSONArray f145545h;

        /* renamed from: i, reason: collision with root package name */
        public boolean f145546i;

        /* renamed from: j, reason: collision with root package name */
        public String f145547j;

        /* renamed from: k, reason: collision with root package name */
        public boolean f145548k;

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.yd.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class C6951a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public C6950a createFromParcel(Parcel parcel) {
                return new C6950a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public C6950a[] newArray(int i3) {
                return new C6950a[i3];
            }
        }

        public C6950a(o oVar, d dVar, int i3, JSONObject jSONObject) {
            this.f145540c = oVar;
            this.f145541d = dVar;
            this.f145542e = i3;
            this.f145543f = jSONObject.optString("packageName");
            JSONArray optJSONArray = jSONObject.optJSONArray("packageNameArray");
            if (optJSONArray != null) {
                this.f145544g = optJSONArray.toString();
            }
            this.f145548k = true;
        }

        @Override // com.tencent.luggage.wxa.wd.d
        public void a(Parcel parcel) {
            boolean z16;
            this.f145543f = parcel.readString();
            this.f145544g = parcel.readString();
            boolean z17 = false;
            if (parcel.readInt() == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.f145548k = z16;
            if (parcel.readInt() == 1) {
                z17 = true;
            }
            this.f145546i = z17;
            this.f145547j = parcel.readString();
            String readString = parcel.readString();
            if (readString != null) {
                try {
                    this.f145545h = new JSONArray(readString);
                } catch (JSONException e16) {
                    w.b("MicroMsg.JsApiGetInstallState", "parseFromParcel: " + e16.getMessage());
                }
            }
        }

        @Override // com.tencent.luggage.wxa.wd.d
        public void g() {
            boolean z16 = true;
            Object[] objArr = new Object[1];
            if (this.f145541d != null) {
                z16 = false;
            }
            objArr[0] = Boolean.valueOf(z16);
            w.a("MicroMsg.JsApiGetInstallState", "callback, service is null: %b", objArr);
            f();
            if (this.f145548k) {
                this.f145541d.a(this.f145542e, this.f145540c.makeReturnJson("fail"));
                return;
            }
            HashMap hashMap = new HashMap();
            JSONArray jSONArray = this.f145545h;
            if (jSONArray != null) {
                hashMap.put("result", jSONArray);
            } else {
                hashMap.put("versionName", this.f145547j);
                hashMap.put("isInstalled", Boolean.valueOf(this.f145546i));
            }
            this.f145541d.a(this.f145542e, this.f145540c.makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, hashMap));
        }

        @Override // com.tencent.luggage.wxa.wd.d
        public void h() {
            j();
            a();
        }

        public final void i() {
            int i3;
            String str;
            boolean z16;
            try {
                JSONArray jSONArray = new JSONArray(this.f145544g);
                this.f145545h = new JSONArray();
                for (int i16 = 0; i16 < jSONArray.length(); i16++) {
                    String optString = jSONArray.optString(i16);
                    PackageInfo a16 = b.a(z.c(), optString);
                    if (a16 == null) {
                        i3 = 0;
                    } else {
                        i3 = a16.versionCode;
                    }
                    if (a16 == null) {
                        str = "null";
                    } else {
                        str = a16.versionName;
                    }
                    w.d("MicroMsg.JsApiGetInstallState", "getInstallState, packageName = " + optString + ", packageInfo = " + a16 + ", version = " + i3 + ", versionName = " + str);
                    if (a16 != null) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("packageName", optString);
                        jSONObject.put("isInstalled", z16);
                        if (z16) {
                            jSONObject.put("versionCode", i3);
                            jSONObject.put("versionName", str);
                        }
                        this.f145545h.mo162put(jSONObject);
                    } catch (JSONException e16) {
                        w.d("MicroMsg.JsApiGetInstallState", e16.getMessage());
                    }
                }
                this.f145548k = false;
            } catch (JSONException e17) {
                w.b("MicroMsg.JsApiGetInstallState", e17.getMessage());
                this.f145548k = true;
            }
        }

        public final void j() {
            int i3;
            String str;
            if (!w0.c(this.f145544g)) {
                i();
                return;
            }
            PackageInfo a16 = b.a(z.c(), this.f145543f);
            if (a16 == null) {
                i3 = 0;
            } else {
                i3 = a16.versionCode;
            }
            if (a16 == null) {
                str = "null";
            } else {
                str = a16.versionName;
            }
            w.d("MicroMsg.JsApiGetInstallState", "doGetInstallState, packageName = " + this.f145543f + ", packageInfo = " + a16 + ", version = " + i3 + ", versionName = " + str);
            if (a16 == null) {
                this.f145546i = false;
            } else {
                this.f145547j = str;
                this.f145546i = true;
            }
            this.f145548k = false;
        }

        @Override // com.tencent.luggage.wxa.wd.d, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            String str;
            parcel.writeString(this.f145543f);
            parcel.writeString(this.f145544g);
            parcel.writeInt(this.f145548k ? 1 : 0);
            parcel.writeInt(this.f145546i ? 1 : 0);
            parcel.writeString(this.f145547j);
            JSONArray jSONArray = this.f145545h;
            if (jSONArray != null) {
                str = jSONArray.toString();
            } else {
                str = null;
            }
            parcel.writeString(str);
        }

        public C6950a(Parcel parcel) {
            a(parcel);
        }
    }
}
