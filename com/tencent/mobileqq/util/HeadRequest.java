package com.tencent.mobileqq.util;

import AvatarInfo.QQHeadInfo;
import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes20.dex */
public class HeadRequest implements Parcelable {
    public static final Parcelable.Creator<HeadRequest> CREATOR = new a();

    /* renamed from: d, reason: collision with root package name */
    public String f306382d;

    /* renamed from: e, reason: collision with root package name */
    public int f306383e;

    /* renamed from: f, reason: collision with root package name */
    public int f306384f;

    /* renamed from: h, reason: collision with root package name */
    public QQHeadInfo f306385h;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a implements Parcelable.Creator<HeadRequest> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public HeadRequest createFromParcel(Parcel parcel) {
            HeadRequest headRequest = new HeadRequest();
            headRequest.a(parcel);
            return headRequest;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public HeadRequest[] newArray(int i3) {
            return new HeadRequest[i3];
        }
    }

    public void a(Parcel parcel) {
        this.f306382d = parcel.readString();
        this.f306383e = parcel.readInt();
        this.f306384f = parcel.readInt();
        this.f306385h = (QQHeadInfo) parcel.readParcelable(getClass().getClassLoader());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f306382d);
        parcel.writeInt(this.f306383e);
        parcel.writeInt(this.f306384f);
        parcel.writeParcelable(this.f306385h, 0);
    }
}
