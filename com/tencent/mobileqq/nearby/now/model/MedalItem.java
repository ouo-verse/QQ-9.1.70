package com.tencent.mobileqq.nearby.now.model;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes15.dex */
public class MedalItem implements Parcelable {
    public static final Parcelable.Creator<MedalItem> CREATOR = new a();
    public long C;
    public long D;
    public int E;
    public String F;
    public String G;
    public int H;
    public int I;
    public int J;

    /* renamed from: d, reason: collision with root package name */
    public int f252683d;

    /* renamed from: e, reason: collision with root package name */
    public int f252684e;

    /* renamed from: f, reason: collision with root package name */
    public String f252685f;

    /* renamed from: h, reason: collision with root package name */
    public String f252686h;

    /* renamed from: i, reason: collision with root package name */
    public String f252687i;

    /* renamed from: m, reason: collision with root package name */
    public int f252688m;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a implements Parcelable.Creator<MedalItem> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public MedalItem createFromParcel(Parcel parcel) {
            return new MedalItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public MedalItem[] newArray(int i3) {
            return new MedalItem[i3];
        }
    }

    public MedalItem() {
    }

    public boolean a(String str, String str2) {
        if (str == null && str2 != null) {
            return false;
        }
        if (str != null && str2 == null) {
            return false;
        }
        if (str != null && !str.equals(str2)) {
            return false;
        }
        return true;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof MedalItem)) {
            return false;
        }
        MedalItem medalItem = (MedalItem) obj;
        if (medalItem.f252683d != this.f252683d) {
            return false;
        }
        return a(medalItem.f252685f, this.f252685f);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.f252683d);
        parcel.writeInt(this.f252684e);
        parcel.writeString(this.f252685f);
        parcel.writeString(this.f252686h);
        parcel.writeString(this.f252687i);
        parcel.writeInt(this.f252688m);
        parcel.writeLong(this.C);
        parcel.writeLong(this.D);
        parcel.writeInt(this.E);
        parcel.writeString(this.F);
        parcel.writeString(this.G);
        parcel.writeInt(this.H);
        parcel.writeInt(this.I);
        parcel.writeInt(this.J);
    }

    protected MedalItem(Parcel parcel) {
        this.f252683d = parcel.readInt();
        this.f252684e = parcel.readInt();
        this.f252685f = parcel.readString();
        this.f252686h = parcel.readString();
        this.f252687i = parcel.readString();
        this.f252688m = parcel.readInt();
        this.C = parcel.readLong();
        this.D = parcel.readLong();
        this.E = parcel.readInt();
        this.F = parcel.readString();
        this.G = parcel.readString();
        this.H = parcel.readInt();
        this.I = parcel.readInt();
        this.J = parcel.readInt();
    }
}
