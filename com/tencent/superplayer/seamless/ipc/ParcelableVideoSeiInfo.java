package com.tencent.superplayer.seamless.ipc;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes26.dex */
public class ParcelableVideoSeiInfo implements Parcelable {
    public static final Parcelable.Creator<ParcelableVideoSeiInfo> CREATOR = new a();

    /* renamed from: d, reason: collision with root package name */
    public int f373958d;

    /* renamed from: e, reason: collision with root package name */
    public int f373959e;

    /* renamed from: f, reason: collision with root package name */
    public int f373960f;

    /* renamed from: h, reason: collision with root package name */
    public byte[] f373961h;

    /* loaded from: classes26.dex */
    class a implements Parcelable.Creator<ParcelableVideoSeiInfo> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ParcelableVideoSeiInfo createFromParcel(Parcel parcel) {
            return new ParcelableVideoSeiInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ParcelableVideoSeiInfo[] newArray(int i3) {
            return new ParcelableVideoSeiInfo[i3];
        }
    }

    public ParcelableVideoSeiInfo() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.f373958d);
        parcel.writeInt(this.f373959e);
        parcel.writeInt(this.f373960f);
        parcel.writeByteArray(this.f373961h);
    }

    protected ParcelableVideoSeiInfo(Parcel parcel) {
        this.f373958d = parcel.readInt();
        this.f373959e = parcel.readInt();
        this.f373960f = parcel.readInt();
        this.f373961h = parcel.createByteArray();
    }
}
