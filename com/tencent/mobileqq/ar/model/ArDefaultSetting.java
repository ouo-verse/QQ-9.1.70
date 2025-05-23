package com.tencent.mobileqq.ar.model;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ArDefaultSetting implements Parcelable {
    public static final Parcelable.Creator<ArDefaultSetting> CREATOR = new a();

    /* renamed from: d, reason: collision with root package name */
    public String f198405d;

    /* renamed from: e, reason: collision with root package name */
    public int f198406e;

    /* renamed from: f, reason: collision with root package name */
    public int f198407f;

    /* renamed from: h, reason: collision with root package name */
    public int f198408h;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class a implements Parcelable.Creator<ArDefaultSetting> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ArDefaultSetting createFromParcel(Parcel parcel) {
            return new ArDefaultSetting(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ArDefaultSetting[] newArray(int i3) {
            return new ArDefaultSetting[i3];
        }
    }

    public ArDefaultSetting() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "ArDefaultSetting{key='" + this.f198405d + "', type=" + this.f198406e + ", modelLevel=" + this.f198407f + ", traceLevel=" + this.f198408h + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f198405d);
        parcel.writeInt(this.f198406e);
        parcel.writeInt(this.f198407f);
        parcel.writeInt(this.f198408h);
    }

    public ArDefaultSetting(Parcel parcel) {
        this.f198405d = parcel.readString();
        this.f198406e = parcel.readInt();
        this.f198407f = parcel.readInt();
        this.f198408h = parcel.readInt();
    }
}
