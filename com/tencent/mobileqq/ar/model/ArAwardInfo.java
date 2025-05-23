package com.tencent.mobileqq.ar.model;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ArAwardInfo implements Parcelable {
    public static final Parcelable.Creator<ArAwardInfo> CREATOR = new a();
    public String C;
    public String D;

    /* renamed from: d, reason: collision with root package name */
    public int f198399d;

    /* renamed from: e, reason: collision with root package name */
    public String f198400e;

    /* renamed from: f, reason: collision with root package name */
    public String f198401f;

    /* renamed from: h, reason: collision with root package name */
    public String f198402h;

    /* renamed from: i, reason: collision with root package name */
    public String f198403i;

    /* renamed from: m, reason: collision with root package name */
    public int f198404m;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class a implements Parcelable.Creator<ArAwardInfo> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ArAwardInfo createFromParcel(Parcel parcel) {
            return new ArAwardInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ArAwardInfo[] newArray(int i3) {
            return new ArAwardInfo[i3];
        }
    }

    public ArAwardInfo() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.f198399d);
        parcel.writeString(this.f198400e);
        parcel.writeString(this.f198401f);
        parcel.writeString(this.f198402h);
        parcel.writeString(this.f198403i);
        parcel.writeInt(this.f198404m);
        parcel.writeString(this.C);
        parcel.writeString(this.D);
    }

    protected ArAwardInfo(Parcel parcel) {
        this.f198399d = parcel.readInt();
        this.f198400e = parcel.readString();
        this.f198401f = parcel.readString();
        this.f198402h = parcel.readString();
        this.f198403i = parcel.readString();
        this.f198404m = parcel.readInt();
        this.C = parcel.readString();
        this.D = parcel.readString();
    }
}
