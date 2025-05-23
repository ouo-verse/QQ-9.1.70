package com.tencent.mapsdk.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class fy implements Parcelable {
    public static final Parcelable.Creator<fy> CREATOR = new Parcelable.Creator<fy>() { // from class: com.tencent.mapsdk.internal.fy.1
        private static fy a(Parcel parcel) {
            return new fy(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ fy createFromParcel(Parcel parcel) {
            return new fy(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ fy[] newArray(int i3) {
            return new fy[i3];
        }

        private static fy[] a(int i3) {
            return new fy[i3];
        }
    };

    /* renamed from: a, reason: collision with root package name */
    public int f148389a;

    /* renamed from: b, reason: collision with root package name */
    public String f148390b;

    /* renamed from: c, reason: collision with root package name */
    public int f148391c;

    /* renamed from: d, reason: collision with root package name */
    public int f148392d;

    /* renamed from: e, reason: collision with root package name */
    public float f148393e;

    /* renamed from: f, reason: collision with root package name */
    public float f148394f;

    /* renamed from: g, reason: collision with root package name */
    public float f148395g;

    /* renamed from: h, reason: collision with root package name */
    public String f148396h;

    /* renamed from: i, reason: collision with root package name */
    public int f148397i;

    /* renamed from: j, reason: collision with root package name */
    public int f148398j;

    /* renamed from: k, reason: collision with root package name */
    public String f148399k;

    /* renamed from: l, reason: collision with root package name */
    public float f148400l;

    /* renamed from: m, reason: collision with root package name */
    public float f148401m;

    /* renamed from: n, reason: collision with root package name */
    public int f148402n;

    /* renamed from: o, reason: collision with root package name */
    public int f148403o;

    /* renamed from: p, reason: collision with root package name */
    public int f148404p;

    /* renamed from: q, reason: collision with root package name */
    public int f148405q;

    /* renamed from: r, reason: collision with root package name */
    public int f148406r;

    /* renamed from: s, reason: collision with root package name */
    public int f148407s;

    /* renamed from: t, reason: collision with root package name */
    public int f148408t;

    /* renamed from: u, reason: collision with root package name */
    public LatLng f148409u;

    public fy() {
        this.f148393e = 0.5f;
        this.f148394f = 0.5f;
        this.f148395g = 1.0f;
        this.f148402n = 0;
        this.f148403o = 3;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.f148389a);
        parcel.writeString(this.f148390b);
        parcel.writeInt(this.f148391c);
        parcel.writeInt(this.f148392d);
        parcel.writeFloat(this.f148393e);
        parcel.writeFloat(this.f148394f);
        parcel.writeFloat(this.f148395g);
        parcel.writeString(this.f148396h);
        parcel.writeInt(this.f148397i);
        parcel.writeInt(this.f148398j);
        parcel.writeString(this.f148399k);
        parcel.writeFloat(this.f148400l);
        parcel.writeFloat(this.f148401m);
        parcel.writeInt(this.f148402n);
        parcel.writeInt(this.f148403o);
        parcel.writeInt(this.f148404p);
        parcel.writeInt(this.f148405q);
        parcel.writeInt(this.f148406r);
        parcel.writeParcelable(this.f148409u, i3);
    }

    protected fy(Parcel parcel) {
        this.f148393e = 0.5f;
        this.f148394f = 0.5f;
        this.f148395g = 1.0f;
        this.f148402n = 0;
        this.f148403o = 3;
        this.f148389a = parcel.readInt();
        this.f148390b = parcel.readString();
        this.f148391c = parcel.readInt();
        this.f148392d = parcel.readInt();
        this.f148393e = parcel.readFloat();
        this.f148394f = parcel.readFloat();
        this.f148395g = parcel.readFloat();
        this.f148396h = parcel.readString();
        this.f148397i = parcel.readInt();
        this.f148398j = parcel.readInt();
        this.f148399k = parcel.readString();
        this.f148400l = parcel.readFloat();
        this.f148401m = parcel.readFloat();
        this.f148402n = parcel.readInt();
        this.f148403o = parcel.readInt();
        this.f148404p = parcel.readInt();
        this.f148405q = parcel.readInt();
        this.f148406r = parcel.readInt();
        this.f148409u = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
    }
}
