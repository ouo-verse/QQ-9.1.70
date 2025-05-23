package com.tencent.luggage.wxa.uc;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes8.dex */
public class f implements Parcelable {
    public static final Parcelable.Creator<f> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public String f142282a;

    /* renamed from: b, reason: collision with root package name */
    public int f142283b;

    /* renamed from: c, reason: collision with root package name */
    public int f142284c;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public f createFromParcel(Parcel parcel) {
            return new f(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public f[] newArray(int i3) {
            return new f[i3];
        }
    }

    public f(Parcel parcel) {
        this.f142282a = parcel.readString();
        this.f142283b = parcel.readInt();
        this.f142284c = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "operation{appId='" + this.f142282a + "', usage=" + this.f142283b + ", operation=" + this.f142284c + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f142282a);
        parcel.writeInt(this.f142283b);
        parcel.writeInt(this.f142284c);
    }
}
