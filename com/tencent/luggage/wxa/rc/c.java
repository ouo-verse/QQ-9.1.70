package com.tencent.luggage.wxa.rc;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.luggage.wxa.rc.r;

/* compiled from: P */
@Deprecated
/* loaded from: classes8.dex */
public class c implements Parcelable, r.a {
    public static final Parcelable.Creator<c> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public String f139471a;

    /* renamed from: b, reason: collision with root package name */
    public String f139472b;

    /* renamed from: c, reason: collision with root package name */
    public String f139473c;

    /* renamed from: d, reason: collision with root package name */
    public String f139474d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f139475e;

    /* renamed from: f, reason: collision with root package name */
    public long f139476f;

    /* renamed from: g, reason: collision with root package name */
    public long f139477g;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public c createFromParcel(Parcel parcel) {
            return new c(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public c[] newArray(int i3) {
            return new c[i3];
        }
    }

    public c() {
    }

    @Override // com.tencent.luggage.wxa.rc.r.a
    public String a() {
        return this.f139471a;
    }

    @Override // com.tencent.luggage.wxa.rc.r.a
    public long b() {
        return this.f139476f;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.tencent.luggage.wxa.rc.r.a
    public long lastModified() {
        return this.f139477g;
    }

    public String toString() {
        return "AppBrandLocalMediaObject{localId='" + this.f139471a + "', fileFullPath='" + this.f139472b + "', mimeType='" + this.f139473c + "', fileExt='" + this.f139474d + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f139471a);
        parcel.writeString(this.f139472b);
        parcel.writeString(this.f139473c);
        parcel.writeString(this.f139474d);
        parcel.writeByte(this.f139475e ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.f139476f);
        parcel.writeLong(this.f139477g);
    }

    public c(Parcel parcel) {
        this.f139471a = parcel.readString();
        this.f139472b = parcel.readString();
        this.f139473c = parcel.readString();
        this.f139474d = parcel.readString();
        this.f139475e = parcel.readByte() != 0;
        this.f139476f = parcel.readLong();
        this.f139477g = parcel.readLong();
    }
}
