package com.tencent.gamecenter.wadl.api;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes6.dex */
public class WadlRequest implements Parcelable {
    public static final Parcelable.Creator<WadlRequest> CREATOR = new a();

    /* renamed from: d, reason: collision with root package name */
    public int f106593d;

    /* renamed from: e, reason: collision with root package name */
    public String f106594e;

    /* renamed from: f, reason: collision with root package name */
    public int f106595f;

    /* renamed from: h, reason: collision with root package name */
    public Bundle f106596h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f106597i;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    class a implements Parcelable.Creator<WadlRequest> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public WadlRequest createFromParcel(Parcel parcel) {
            WadlRequest wadlRequest = new WadlRequest(0, "");
            wadlRequest.f106593d = parcel.readInt();
            wadlRequest.f106594e = parcel.readString();
            wadlRequest.f106595f = parcel.readInt();
            wadlRequest.f106596h = (Bundle) parcel.readParcelable(Bundle.class.getClassLoader());
            return wadlRequest;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public WadlRequest[] newArray(int i3) {
            return new WadlRequest[i3];
        }
    }

    public WadlRequest(int i3, String str) {
        this.f106593d = i3;
        this.f106594e = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "WadlRequest{businessId=" + this.f106593d + ", cmdId='" + this.f106594e + "', flags=" + this.f106595f + ", params=" + this.f106596h + ", isWrite=" + this.f106597i + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        if (this.f106597i) {
            return;
        }
        this.f106597i = true;
        parcel.writeInt(this.f106593d);
        parcel.writeString(this.f106594e);
        parcel.writeInt(this.f106595f);
        parcel.writeParcelable(this.f106596h, i3);
    }

    public WadlRequest(int i3, String str, Bundle bundle) {
        this.f106593d = i3;
        this.f106594e = str;
        this.f106596h = bundle;
    }
}
