package com.tencent.mobileqq.ar.aidl;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ARScanStarFaceConfigInfo implements Parcelable {
    public static final Parcelable.Creator<ARScanStarFaceConfigInfo> CREATOR = new a();

    /* renamed from: d, reason: collision with root package name */
    public String f197696d;

    /* renamed from: e, reason: collision with root package name */
    public ARScanStarFaceActInfo[] f197697e;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class a implements Parcelable.Creator<ARScanStarFaceConfigInfo> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ARScanStarFaceConfigInfo createFromParcel(Parcel parcel) {
            return new ARScanStarFaceConfigInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ARScanStarFaceConfigInfo[] newArray(int i3) {
            return new ARScanStarFaceConfigInfo[i3];
        }
    }

    public ARScanStarFaceConfigInfo() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f197696d);
        parcel.writeTypedArray(this.f197697e, i3);
    }

    protected ARScanStarFaceConfigInfo(Parcel parcel) {
        this.f197696d = parcel.readString();
        this.f197697e = (ARScanStarFaceActInfo[]) parcel.createTypedArray(ARScanStarFaceActInfo.CREATOR);
    }
}
