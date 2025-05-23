package com.qq.im.poi;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes3.dex */
public class PoiInfo implements Parcelable {
    public static final Parcelable.Creator<PoiInfo> CREATOR = new a();

    /* renamed from: d, reason: collision with root package name */
    public long f40894d;

    /* renamed from: e, reason: collision with root package name */
    public int f40895e;

    /* renamed from: f, reason: collision with root package name */
    public int f40896f;

    /* renamed from: h, reason: collision with root package name */
    public String f40897h;

    /* renamed from: i, reason: collision with root package name */
    public String f40898i;

    /* loaded from: classes3.dex */
    class a implements Parcelable.Creator<PoiInfo> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PoiInfo createFromParcel(Parcel parcel) {
            return new PoiInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public PoiInfo[] newArray(int i3) {
            return new PoiInfo[i3];
        }
    }

    public PoiInfo() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "id:" + this.f40894d + ", latitude:" + this.f40895e + ", longitude:" + this.f40896f + ", name:" + this.f40897h + ", address" + this.f40898i;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeLong(this.f40894d);
        parcel.writeInt(this.f40895e);
        parcel.writeInt(this.f40896f);
        parcel.writeString(this.f40897h);
        parcel.writeString(this.f40898i);
    }

    PoiInfo(Parcel parcel) {
        this.f40894d = parcel.readLong();
        this.f40895e = parcel.readInt();
        this.f40896f = parcel.readInt();
        this.f40897h = parcel.readString();
        this.f40898i = parcel.readString();
    }
}
