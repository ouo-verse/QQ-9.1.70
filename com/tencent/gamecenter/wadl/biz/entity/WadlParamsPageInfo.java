package com.tencent.gamecenter.wadl.biz.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class WadlParamsPageInfo implements Parcelable {
    public static final Parcelable.Creator<WadlParamsPageInfo> CREATOR = new a();
    public String C;
    public String D;
    public String E;

    /* renamed from: d, reason: collision with root package name */
    public String f106739d;

    /* renamed from: e, reason: collision with root package name */
    public String f106740e;

    /* renamed from: f, reason: collision with root package name */
    public String f106741f;

    /* renamed from: h, reason: collision with root package name */
    public String f106742h;

    /* renamed from: i, reason: collision with root package name */
    public String f106743i;

    /* renamed from: m, reason: collision with root package name */
    public String f106744m;

    /* loaded from: classes6.dex */
    class a implements Parcelable.Creator<WadlParamsPageInfo> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public WadlParamsPageInfo createFromParcel(Parcel parcel) {
            WadlParamsPageInfo wadlParamsPageInfo = new WadlParamsPageInfo();
            wadlParamsPageInfo.c(parcel);
            return wadlParamsPageInfo;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public WadlParamsPageInfo[] newArray(int i3) {
            return new WadlParamsPageInfo[i3];
        }
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f106739d = jSONObject.optString("page_id", "");
        this.f106740e = jSONObject.optString("page_name", "");
        this.f106741f = jSONObject.optString("module_id", "");
        this.f106742h = jSONObject.optString("module_name", "");
        this.f106743i = jSONObject.optString("sub_module_id", "");
        this.f106744m = jSONObject.optString("sub_module_name", "");
        this.C = jSONObject.optString("element_name", "");
        this.D = jSONObject.optString("element_level", "");
        this.E = jSONObject.optString("pre_page_name", "");
    }

    public void b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("attaPageParams");
        if (TextUtils.isEmpty(optString)) {
            return;
        }
        try {
            JSONObject jSONObject2 = new JSONObject(optString);
            this.f106739d = jSONObject2.optString("page_id", "");
            this.f106740e = jSONObject2.optString("page_name", "");
            this.f106741f = jSONObject2.optString("module_id", "");
            this.f106742h = jSONObject2.optString("module_name", "");
            this.f106743i = jSONObject2.optString("sub_module_id", "");
            this.f106744m = jSONObject2.optString("sub_module_name", "");
            this.C = jSONObject2.optString("element_name", "");
            this.D = jSONObject2.optString("element_level", "");
            this.E = jSONObject2.optString("pre_page_name", "");
        } catch (JSONException e16) {
            QLog.e("WadlParamsPageInfo", 1, "parseFromJson exception", e16);
        }
    }

    public void c(Parcel parcel) {
        if (parcel != null) {
            this.f106739d = parcel.readString();
            this.f106740e = parcel.readString();
            this.f106741f = parcel.readString();
            this.f106742h = parcel.readString();
            this.f106743i = parcel.readString();
            this.f106744m = parcel.readString();
            this.C = parcel.readString();
            this.D = parcel.readString();
            this.E = parcel.readString();
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        if (parcel != null) {
            parcel.writeString(this.f106739d);
            parcel.writeString(this.f106740e);
            parcel.writeString(this.f106741f);
            parcel.writeString(this.f106742h);
            parcel.writeString(this.f106743i);
            parcel.writeString(this.f106744m);
            parcel.writeString(this.C);
            parcel.writeString(this.D);
            parcel.writeString(this.E);
        }
    }
}
