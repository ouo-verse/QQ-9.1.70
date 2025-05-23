package com.tencent.biz.pubaccount;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes4.dex */
public class EncryptUinInfo implements Parcelable {
    public static final Parcelable.Creator<EncryptUinInfo> CREATOR = new a();

    /* renamed from: d, reason: collision with root package name */
    public long f78808d;

    /* renamed from: e, reason: collision with root package name */
    public int f78809e;

    /* renamed from: f, reason: collision with root package name */
    public String f78810f;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class a implements Parcelable.Creator<EncryptUinInfo> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public EncryptUinInfo createFromParcel(Parcel parcel) {
            return new EncryptUinInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EncryptUinInfo[] newArray(int i3) {
            return new EncryptUinInfo[i3];
        }
    }

    public EncryptUinInfo() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeLong(this.f78808d);
        parcel.writeInt(this.f78809e);
        parcel.writeString(this.f78810f);
    }

    protected EncryptUinInfo(Parcel parcel) {
        this.f78808d = parcel.readLong();
        this.f78809e = parcel.readInt();
        this.f78810f = parcel.readString();
    }
}
