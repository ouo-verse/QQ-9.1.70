package com.tencent.biz.pubaccount.ecshopassit;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes4.dex */
public class RecentShopParcel implements Parcelable {
    public static final Parcelable.Creator<RecentShopParcel> CREATOR = new a();
    public int C;
    public int D;
    public String E;
    public long F;
    public long G;

    /* renamed from: d, reason: collision with root package name */
    public String f79609d;

    /* renamed from: e, reason: collision with root package name */
    public String f79610e;

    /* renamed from: f, reason: collision with root package name */
    public String f79611f;

    /* renamed from: h, reason: collision with root package name */
    public String f79612h;

    /* renamed from: i, reason: collision with root package name */
    public String f79613i;

    /* renamed from: m, reason: collision with root package name */
    public int f79614m;

    /* loaded from: classes4.dex */
    class a implements Parcelable.Creator<RecentShopParcel> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public RecentShopParcel createFromParcel(Parcel parcel) {
            return new RecentShopParcel(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public RecentShopParcel[] newArray(int i3) {
            return new RecentShopParcel[i3];
        }
    }

    public RecentShopParcel() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f79609d);
        parcel.writeString(this.f79610e);
        parcel.writeString(this.f79611f);
        parcel.writeString(this.f79612h);
        parcel.writeString(this.f79613i);
        parcel.writeString(this.E);
        parcel.writeInt(this.f79614m);
        parcel.writeInt(this.C);
        parcel.writeInt(this.D);
        parcel.writeLong(this.F);
        parcel.writeLong(this.G);
    }

    protected RecentShopParcel(Parcel parcel) {
        this.f79609d = parcel.readString();
        this.f79610e = parcel.readString();
        this.f79611f = parcel.readString();
        this.f79612h = parcel.readString();
        this.f79613i = parcel.readString();
        this.E = parcel.readString();
        this.f79614m = parcel.readInt();
        this.C = parcel.readInt();
        this.D = parcel.readInt();
        this.F = parcel.readLong();
        this.G = parcel.readLong();
    }
}
