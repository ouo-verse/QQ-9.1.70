package com.tencent.mobileqq.kandian.biz.video.discovery;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes33.dex */
public class DiscoveryBannerInfo implements Parcelable {
    public static final Parcelable.Creator<DiscoveryBannerInfo> CREATOR = new a();

    /* renamed from: d, reason: collision with root package name */
    public long f239614d;

    /* renamed from: e, reason: collision with root package name */
    public String f239615e;

    /* renamed from: f, reason: collision with root package name */
    public String f239616f;

    /* renamed from: h, reason: collision with root package name */
    public int f239617h;

    /* renamed from: i, reason: collision with root package name */
    public String f239618i;

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class a implements Parcelable.Creator<DiscoveryBannerInfo> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public DiscoveryBannerInfo createFromParcel(Parcel parcel) {
            return new DiscoveryBannerInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public DiscoveryBannerInfo[] newArray(int i3) {
            return new DiscoveryBannerInfo[i3];
        }
    }

    public DiscoveryBannerInfo() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "DiscoveryBannerInfo{bannerId=" + this.f239614d + ", coverUrl='" + this.f239615e + "', coverTitle='" + this.f239616f + "', jumpType=" + this.f239617h + ", jumpDataJson='" + this.f239618i + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeLong(this.f239614d);
        parcel.writeString(this.f239615e);
        parcel.writeString(this.f239616f);
        parcel.writeInt(this.f239617h);
        parcel.writeString(this.f239618i);
    }

    protected DiscoveryBannerInfo(Parcel parcel) {
        this.f239614d = parcel.readLong();
        this.f239615e = parcel.readString();
        this.f239616f = parcel.readString();
        this.f239617h = parcel.readInt();
        this.f239618i = parcel.readString();
    }
}
