package com.tencent.luggage.wxa.ic;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.luggage.wxa.tn.w0;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class c0 implements Parcelable {

    /* renamed from: a, reason: collision with root package name */
    public transient g f129714a;

    /* renamed from: b, reason: collision with root package name */
    public JSONObject f129715b;

    /* renamed from: c, reason: collision with root package name */
    public JSONObject f129716c;

    /* renamed from: d, reason: collision with root package name */
    public static final c0 f129713d = new c0();
    public static final Parcelable.Creator<c0> CREATOR = new a();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public c0 createFromParcel(Parcel parcel) {
            return new c0(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public c0[] newArray(int i3) {
            return new c0[i3];
        }
    }

    public /* synthetic */ c0(Parcel parcel, a aVar) {
        this(parcel);
    }

    public static Object a(Object obj, Object obj2) {
        return obj == null ? obj2 : obj;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "MiniProgramNavigationBackResult{extraData=" + this.f129715b + ", privateData=" + this.f129716c + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        String jSONObject;
        JSONObject jSONObject2 = this.f129715b;
        String str = null;
        if (jSONObject2 == null) {
            jSONObject = null;
        } else {
            jSONObject = jSONObject2.toString();
        }
        parcel.writeString(jSONObject);
        JSONObject jSONObject3 = this.f129716c;
        if (jSONObject3 != null) {
            str = jSONObject3.toString();
        }
        parcel.writeString(str);
    }

    public c0() {
    }

    public static c0 a(g gVar, JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null && jSONObject2 == null) {
            return null;
        }
        c0 c0Var = new c0();
        c0Var.f129714a = gVar;
        c0Var.f129715b = (JSONObject) a(jSONObject, new JSONObject());
        c0Var.f129716c = (JSONObject) a(jSONObject2, new JSONObject());
        return c0Var;
    }

    public c0(Parcel parcel) {
        a(parcel);
    }

    public final void a(Parcel parcel) {
        try {
            this.f129715b = new JSONObject(w0.b(parcel.readString(), "{}"));
            this.f129716c = new JSONObject(w0.b(parcel.readString(), "{}"));
        } catch (JSONException e16) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrand.MiniProgramNavigationBackResult", "readFromParcel, ex = %s", e16);
        }
    }
}
