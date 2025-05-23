package com.tencent.luggage.wxa.ob;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.luggage.wxa.fd.m;
import com.tencent.luggage.wxa.fd.s;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public String f136265a;

    /* renamed from: b, reason: collision with root package name */
    public String f136266b;

    /* renamed from: c, reason: collision with root package name */
    public String f136267c;

    /* renamed from: d, reason: collision with root package name */
    public s f136268d;

    /* renamed from: e, reason: collision with root package name */
    public int f136269e;

    /* renamed from: f, reason: collision with root package name */
    public m f136270f;

    /* renamed from: g, reason: collision with root package name */
    public String f136271g;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public b createFromParcel(Parcel parcel) {
            return new b(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public b[] newArray(int i3) {
            return new b[i3];
        }
    }

    public /* synthetic */ b(Parcel parcel, a aVar) {
        this(parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f136265a);
        parcel.writeString(this.f136266b);
        parcel.writeParcelable(this.f136268d, i3);
        parcel.writeInt(this.f136269e);
        parcel.writeString(this.f136271g);
        parcel.writeString(this.f136267c);
        parcel.writeParcelable(this.f136270f, i3);
    }

    public b() {
    }

    public b(Parcel parcel) {
        this.f136265a = parcel.readString();
        this.f136266b = parcel.readString();
        this.f136268d = (s) parcel.readParcelable(s.class.getClassLoader());
        this.f136269e = parcel.readInt();
        this.f136271g = parcel.readString();
        this.f136267c = parcel.readString();
        this.f136270f = (m) parcel.readParcelable(s.class.getClassLoader());
    }
}
