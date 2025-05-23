package com.tencent.luggage.wxa.x0;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes9.dex */
public class f implements Parcelable {

    /* renamed from: a, reason: collision with root package name */
    public final String f144479a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f144480b;

    /* renamed from: c, reason: collision with root package name */
    public static final f f144478c = new f("Camera", false);
    public static final Parcelable.Creator<f> CREATOR = new a();

    /* compiled from: P */
    /* loaded from: classes9.dex */
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

    public f(String str, boolean z16) {
        this.f144479a = str;
        this.f144480b = z16;
    }

    public String a() {
        return this.f144479a;
    }

    public boolean b() {
        return this.f144480b;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f144479a);
        parcel.writeByte(this.f144480b ? (byte) 1 : (byte) 0);
    }

    public f(Parcel parcel) {
        this.f144479a = parcel.readString();
        this.f144480b = parcel.readByte() != 0;
    }
}
