package com.tencent.luggage.wxa.fd;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes8.dex */
public class g implements Parcelable {
    public static final Parcelable.Creator<g> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public String f125717a;

    /* renamed from: b, reason: collision with root package name */
    public String f125718b;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public g createFromParcel(Parcel parcel) {
            return new g(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public g[] newArray(int i3) {
            return new g[i3];
        }
    }

    public g(Parcel parcel) {
        this.f125717a = parcel.readString();
        this.f125718b = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f125717a);
        parcel.writeString(this.f125718b);
    }
}
