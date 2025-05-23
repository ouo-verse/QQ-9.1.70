package com.tencent.now.app.medal.data;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes22.dex */
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
    public long K;
    public String L;

    /* renamed from: d, reason: collision with root package name */
    public int f337988d;

    /* renamed from: e, reason: collision with root package name */
    public int f337989e;

    /* renamed from: f, reason: collision with root package name */
    public String f337990f;

    /* renamed from: h, reason: collision with root package name */
    public String f337991h;

    /* renamed from: i, reason: collision with root package name */
    public String f337992i;

    /* renamed from: m, reason: collision with root package name */
    public int f337993m;

    /* compiled from: P */
    /* loaded from: classes22.dex */
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
        if (medalItem.f337988d != this.f337988d) {
            return false;
        }
        return a(medalItem.f337990f, this.f337990f);
    }

    public String toString() {
        return "\n MedalItem{medalId=" + this.f337988d + ", medalVersion=" + this.f337989e + ", medalName='" + this.f337990f + "', medalType=" + this.f337993m + ", medalDesc='" + this.F + "', subMedalLevel=" + this.J + ", medalAnchorUid=" + this.K + ", anchorName='" + this.L + "', medalSmallUrl='" + this.f337991h + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.f337988d);
        parcel.writeInt(this.f337989e);
        parcel.writeString(this.f337990f);
        parcel.writeString(this.f337991h);
        parcel.writeString(this.f337992i);
        parcel.writeInt(this.f337993m);
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
        this.f337988d = parcel.readInt();
        this.f337989e = parcel.readInt();
        this.f337990f = parcel.readString();
        this.f337991h = parcel.readString();
        this.f337992i = parcel.readString();
        this.f337993m = parcel.readInt();
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
