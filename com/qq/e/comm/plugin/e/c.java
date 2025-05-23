package com.qq.e.comm.plugin.e;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes3.dex */
public class c implements Parcelable {

    /* renamed from: a, reason: collision with root package name */
    public static final Parcelable.Creator<c> f39351a = new Parcelable.Creator<c>() { // from class: com.qq.e.comm.plugin.e.c.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public c createFromParcel(Parcel parcel) {
            return new c(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public c[] newArray(int i3) {
            return new c[i3];
        }
    };

    /* renamed from: b, reason: collision with root package name */
    private boolean f39352b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f39353c;

    public c() {
        this.f39352b = true;
        this.f39353c = true;
    }

    public boolean a() {
        return this.f39353c;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        if (parcel != null) {
            parcel.writeByte(this.f39352b ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.f39353c ? (byte) 1 : (byte) 0);
        }
    }

    protected c(Parcel parcel) {
        this.f39352b = true;
        this.f39353c = true;
        if (parcel != null) {
            this.f39352b = parcel.readByte() != 0;
            this.f39353c = parcel.readByte() != 0;
        }
    }
}
