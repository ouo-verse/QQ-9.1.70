package com.huawei.hms.core.aidl;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes2.dex */
public class DataBuffer implements Parcelable {
    public static final Parcelable.Creator<DataBuffer> CREATOR = new a();
    public String URI;

    /* renamed from: a, reason: collision with root package name */
    private int f36899a;

    /* renamed from: b, reason: collision with root package name */
    private Bundle f36900b;
    public Bundle header;

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
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public DataBuffer[] newArray(int i3) {
            return new DataBuffer[i3];
        }
    }

    /* synthetic */ DataBuffer(Parcel parcel, a aVar) {
        this(parcel);
    }

    private static ClassLoader a(Class cls) {
        return cls.getClassLoader();
    }

    public DataBuffer addBody(Bundle bundle) {
        this.f36900b = bundle;
        return this;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Bundle getBody() {
        return this.f36900b;
    }

    public int getBodySize() {
        if (this.f36900b == null) {
            return 0;
        }
        return 1;
    }

    public int getProtocol() {
        return this.f36899a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.f36899a);
        parcel.writeString(this.URI);
        parcel.writeBundle(this.header);
        parcel.writeBundle(this.f36900b);
    }

    DataBuffer(Parcel parcel) {
        this.header = null;
        this.f36899a = 1;
        this.f36900b = null;
        a(parcel);
    }

    private void a(Parcel parcel) {
        this.f36899a = parcel.readInt();
        this.URI = parcel.readString();
        this.header = parcel.readBundle(a(Bundle.class));
        this.f36900b = parcel.readBundle(a(Bundle.class));
    }

    public DataBuffer() {
        this.header = null;
        this.f36899a = 1;
        this.f36900b = null;
    }

    public DataBuffer(String str) {
        this.header = null;
        this.f36899a = 1;
        this.f36900b = null;
        this.URI = str;
    }

    public DataBuffer(String str, int i3) {
        this.header = null;
        this.f36900b = null;
        this.URI = str;
        this.f36899a = i3;
    }
}
