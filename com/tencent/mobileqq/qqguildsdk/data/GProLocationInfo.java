package com.tencent.mobileqq.qqguildsdk.data;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes17.dex */
public class GProLocationInfo implements Parcelable {
    public static final Parcelable.Creator<GProLocationInfo> CREATOR = new a();
    String C;
    String D;

    /* renamed from: d, reason: collision with root package name */
    int f265597d;

    /* renamed from: e, reason: collision with root package name */
    int f265598e;

    /* renamed from: f, reason: collision with root package name */
    int f265599f;

    /* renamed from: h, reason: collision with root package name */
    int f265600h;

    /* renamed from: i, reason: collision with root package name */
    String f265601i;

    /* renamed from: m, reason: collision with root package name */
    String f265602m;

    /* loaded from: classes17.dex */
    class a implements Parcelable.Creator<GProLocationInfo> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public GProLocationInfo createFromParcel(Parcel parcel) {
            return new GProLocationInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public GProLocationInfo[] newArray(int i3) {
            return new GProLocationInfo[i3];
        }
    }

    public GProLocationInfo() {
    }

    public String a() {
        String str = this.C;
        if (str == null) {
            return "";
        }
        return str;
    }

    public int b() {
        return this.f265599f;
    }

    public String c() {
        String str = this.D;
        if (str == null) {
            return "";
        }
        return str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int e() {
        return this.f265600h;
    }

    public String f() {
        String str = this.f265601i;
        if (str == null) {
            return "";
        }
        return str;
    }

    public int g() {
        return this.f265597d;
    }

    public String j() {
        String str = this.f265602m;
        if (str == null) {
            return "";
        }
        return str;
    }

    public int k() {
        return this.f265598e;
    }

    public boolean l() {
        if (this.f265597d != 49) {
            return true;
        }
        return false;
    }

    public void m(String str) {
        this.C = str;
    }

    public void n(int i3) {
        this.f265599f = i3;
    }

    public void o(String str) {
        this.D = str;
    }

    public void p(int i3) {
        this.f265600h = i3;
    }

    public void q(String str) {
        this.f265601i = str;
    }

    public void r(int i3) {
        this.f265597d = i3;
    }

    public void s(String str) {
        this.f265602m = str;
    }

    public void t(int i3) {
        this.f265598e = i3;
    }

    public String toString() {
        return "GProLocationInfo{mCountryId='" + this.f265597d + "', mProvinceId='" + this.f265598e + "', mCityId='" + this.f265599f + "', mCityZoneId='" + this.f265600h + "', mCountry='" + this.f265601i + "', mProvince='" + this.f265602m + "', mCity='" + this.C + "', mCityZone='" + this.D + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.f265597d);
        parcel.writeInt(this.f265598e);
        parcel.writeInt(this.f265599f);
        parcel.writeInt(this.f265600h);
        parcel.writeString(this.f265601i);
        parcel.writeString(this.f265602m);
        parcel.writeString(this.C);
        parcel.writeString(this.D);
    }

    protected GProLocationInfo(Parcel parcel) {
        this.f265597d = parcel.readInt();
        this.f265598e = parcel.readInt();
        this.f265599f = parcel.readInt();
        this.f265600h = parcel.readInt();
        this.f265601i = parcel.readString();
        this.f265602m = parcel.readString();
        this.C = parcel.readString();
        this.D = parcel.readString();
    }
}
