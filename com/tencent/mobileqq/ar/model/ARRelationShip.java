package com.tencent.mobileqq.ar.model;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ARRelationShip implements Parcelable {
    public static final Parcelable.Creator<ARRelationShip> CREATOR = new a();
    public String C;
    public long D;
    public String E;
    public String F;
    public String G;
    public String H;
    public String I;
    public String J;
    public String K;

    /* renamed from: d, reason: collision with root package name */
    public String f198393d;

    /* renamed from: e, reason: collision with root package name */
    public String f198394e;

    /* renamed from: f, reason: collision with root package name */
    public String f198395f;

    /* renamed from: h, reason: collision with root package name */
    public String f198396h;

    /* renamed from: i, reason: collision with root package name */
    public String f198397i;

    /* renamed from: m, reason: collision with root package name */
    public String f198398m;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class a implements Parcelable.Creator<ARRelationShip> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ARRelationShip createFromParcel(Parcel parcel) {
            return new ARRelationShip(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ARRelationShip[] newArray(int i3) {
            return new ARRelationShip[i3];
        }
    }

    public ARRelationShip() {
        this.J = "";
        this.K = "";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f198393d);
        parcel.writeString(this.f198394e);
        parcel.writeString(this.f198395f);
        parcel.writeString(this.f198396h);
        parcel.writeString(this.f198397i);
        parcel.writeString(this.f198398m);
        parcel.writeString(this.C);
        parcel.writeLong(this.D);
        parcel.writeString(this.E);
        parcel.writeString(this.F);
        parcel.writeString(this.G);
        parcel.writeString(this.H);
        parcel.writeString(this.I);
        parcel.writeString(this.J);
        parcel.writeString(this.K);
    }

    protected ARRelationShip(Parcel parcel) {
        this.J = "";
        this.K = "";
        this.f198393d = parcel.readString();
        this.f198394e = parcel.readString();
        this.f198395f = parcel.readString();
        this.f198396h = parcel.readString();
        this.f198397i = parcel.readString();
        this.f198398m = parcel.readString();
        this.C = parcel.readString();
        this.D = parcel.readLong();
        this.E = parcel.readString();
        this.F = parcel.readString();
        this.G = parcel.readString();
        this.H = parcel.readString();
        this.I = parcel.readString();
        this.J = parcel.readString();
        this.K = parcel.readString();
    }
}
