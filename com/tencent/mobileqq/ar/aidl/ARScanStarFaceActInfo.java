package com.tencent.mobileqq.ar.aidl;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ARScanStarFaceActInfo implements Parcelable {
    public static final Parcelable.Creator<ARScanStarFaceActInfo> CREATOR = new a();
    public long C;
    public long D;
    public long E;

    /* renamed from: d, reason: collision with root package name */
    public String f197690d;

    /* renamed from: e, reason: collision with root package name */
    public String f197691e;

    /* renamed from: f, reason: collision with root package name */
    public String f197692f;

    /* renamed from: h, reason: collision with root package name */
    public String f197693h;

    /* renamed from: i, reason: collision with root package name */
    public String f197694i;

    /* renamed from: m, reason: collision with root package name */
    public String f197695m;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class a implements Parcelable.Creator<ARScanStarFaceActInfo> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ARScanStarFaceActInfo createFromParcel(Parcel parcel) {
            return new ARScanStarFaceActInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ARScanStarFaceActInfo[] newArray(int i3) {
            return new ARScanStarFaceActInfo[i3];
        }
    }

    public ARScanStarFaceActInfo() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "ARScanStarFaceActInfo{actTitle='" + this.f197692f + "'actDescription='" + this.f197693h + "', starName='" + this.f197690d + "', starUin='" + this.f197691e + "', starWebUrl='" + this.f197694i + "', adImgUrl='" + this.f197695m + "', beginTime=" + this.C + ", endTime=" + this.D + ", actID=" + this.E + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f197690d);
        parcel.writeString(this.f197691e);
        parcel.writeString(this.f197692f);
        parcel.writeString(this.f197693h);
        parcel.writeString(this.f197694i);
        parcel.writeString(this.f197695m);
        parcel.writeLong(this.C);
        parcel.writeLong(this.D);
        parcel.writeLong(this.E);
    }

    protected ARScanStarFaceActInfo(Parcel parcel) {
        this.f197690d = parcel.readString();
        this.f197691e = parcel.readString();
        this.f197692f = parcel.readString();
        this.f197693h = parcel.readString();
        this.f197694i = parcel.readString();
        this.f197695m = parcel.readString();
        this.C = parcel.readLong();
        this.D = parcel.readLong();
        this.E = parcel.readLong();
    }
}
