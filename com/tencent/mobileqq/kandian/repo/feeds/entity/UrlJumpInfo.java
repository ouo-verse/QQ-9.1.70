package com.tencent.mobileqq.kandian.repo.feeds.entity;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes15.dex */
public class UrlJumpInfo implements Parcelable {
    public static final Parcelable.Creator<UrlJumpInfo> CREATOR = new a();

    /* renamed from: d, reason: collision with root package name */
    public int f240068d;

    /* renamed from: e, reason: collision with root package name */
    public String f240069e;

    /* renamed from: f, reason: collision with root package name */
    public String f240070f;

    /* renamed from: h, reason: collision with root package name */
    public String f240071h;

    /* renamed from: i, reason: collision with root package name */
    public String f240072i;

    /* renamed from: m, reason: collision with root package name */
    public String f240073m;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a implements Parcelable.Creator<UrlJumpInfo> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public UrlJumpInfo createFromParcel(Parcel parcel) {
            return new UrlJumpInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public UrlJumpInfo[] newArray(int i3) {
            return new UrlJumpInfo[i3];
        }
    }

    public UrlJumpInfo() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "UrlJumpInfo{jumpType=" + this.f240068d + ", jumpUrl='" + this.f240069e + "', jumpBundle='" + this.f240070f + "', jumpSchema='" + this.f240071h + "', clipboardInfo='" + this.f240072i + "', commonData='" + this.f240073m + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.f240068d);
        parcel.writeString(this.f240069e);
        parcel.writeString(this.f240070f);
        parcel.writeString(this.f240071h);
        parcel.writeString(this.f240072i);
        parcel.writeString(this.f240073m);
    }

    protected UrlJumpInfo(Parcel parcel) {
        this.f240068d = parcel.readInt();
        this.f240069e = parcel.readString();
        this.f240070f = parcel.readString();
        this.f240071h = parcel.readString();
        this.f240072i = parcel.readString();
        this.f240073m = parcel.readString();
    }
}
