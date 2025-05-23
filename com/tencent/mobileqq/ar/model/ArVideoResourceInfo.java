package com.tencent.mobileqq.ar.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.ar.i;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ArVideoResourceInfo implements Parcelable {
    public static final Parcelable.Creator<ArVideoResourceInfo> CREATOR = new a();
    public int C;
    public int D;
    public String E;
    public String F;

    /* renamed from: d, reason: collision with root package name */
    public int f198426d;

    /* renamed from: e, reason: collision with root package name */
    public long f198427e;

    /* renamed from: f, reason: collision with root package name */
    public String f198428f;

    /* renamed from: h, reason: collision with root package name */
    public String f198429h;

    /* renamed from: i, reason: collision with root package name */
    public String f198430i;

    /* renamed from: m, reason: collision with root package name */
    public int f198431m;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class a implements Parcelable.Creator<ArVideoResourceInfo> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ArVideoResourceInfo createFromParcel(Parcel parcel) {
            return new ArVideoResourceInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ArVideoResourceInfo[] newArray(int i3) {
            return new ArVideoResourceInfo[i3];
        }
    }

    public ArVideoResourceInfo() {
    }

    public boolean a() {
        if (this.f198426d == 0) {
            return true;
        }
        return false;
    }

    public boolean b() {
        if (this.f198426d == 2) {
            return true;
        }
        return false;
    }

    public boolean c() {
        if (this.f198426d == 1) {
            return true;
        }
        return false;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.f198426d);
        parcel.writeLong(this.f198427e);
        parcel.writeString(this.f198428f);
        parcel.writeString(this.f198429h);
        parcel.writeString(this.f198430i);
        parcel.writeInt(this.f198431m);
        parcel.writeInt(this.C);
        parcel.writeInt(this.D);
        parcel.writeString(this.E);
        parcel.writeString(this.F);
    }

    protected ArVideoResourceInfo(Parcel parcel) {
        this.f198426d = parcel.readInt();
        this.f198427e = parcel.readLong();
        this.f198428f = parcel.readString();
        this.f198429h = parcel.readString();
        this.f198430i = parcel.readString();
        this.f198431m = parcel.readInt();
        this.C = parcel.readInt();
        this.D = parcel.readInt();
        this.E = parcel.readString();
        this.F = i.d(parcel.readString());
    }
}
