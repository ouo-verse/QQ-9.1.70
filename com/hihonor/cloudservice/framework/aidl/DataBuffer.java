package com.hihonor.cloudservice.framework.aidl;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes2.dex */
public class DataBuffer implements Parcelable {
    public static final Parcelable.Creator<DataBuffer> CREATOR = new a();

    /* renamed from: d, reason: collision with root package name */
    public final int f36215d;

    /* renamed from: e, reason: collision with root package name */
    public final String f36216e;

    /* renamed from: f, reason: collision with root package name */
    public Bundle f36217f;

    /* renamed from: h, reason: collision with root package name */
    public Bundle f36218h;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class a implements Parcelable.Creator<DataBuffer> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public DataBuffer createFromParcel(Parcel parcel) {
            return new DataBuffer(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public DataBuffer[] newArray(int i3) {
            return new DataBuffer[i3];
        }
    }

    /* synthetic */ DataBuffer(Parcel parcel, a aVar) {
        this(parcel);
    }

    private static ClassLoader b(Class<?> cls) {
        if (cls == null) {
            return ClassLoader.getSystemClassLoader();
        }
        return cls.getClassLoader();
    }

    public DataBuffer a(Bundle bundle) {
        this.f36218h = bundle;
        return this;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.f36215d);
        parcel.writeString(this.f36216e);
        parcel.writeBundle(this.f36217f);
        parcel.writeBundle(this.f36218h);
    }

    DataBuffer(Parcel parcel) {
        this.f36217f = null;
        this.f36218h = null;
        this.f36215d = parcel.readInt();
        this.f36216e = parcel.readString();
        this.f36217f = parcel.readBundle(b(Bundle.class));
        this.f36218h = parcel.readBundle(b(Bundle.class));
    }

    public DataBuffer(String str, int i3) {
        this.f36217f = null;
        this.f36218h = null;
        this.f36216e = str;
        this.f36215d = i3;
    }
}
