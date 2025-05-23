package com.qq.e.comm.plugin.base.ad.model;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes3.dex */
public class m implements Parcelable {

    /* renamed from: a, reason: collision with root package name */
    public static final Parcelable.Creator<m> f39068a = new Parcelable.Creator<m>() { // from class: com.qq.e.comm.plugin.base.ad.model.m.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public m createFromParcel(Parcel parcel) {
            return new m(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public m[] newArray(int i3) {
            return new m[i3];
        }
    };

    /* renamed from: b, reason: collision with root package name */
    private int f39069b;

    /* renamed from: c, reason: collision with root package name */
    private int f39070c;

    public m() {
    }

    public void a(int i3) {
        this.f39069b = i3;
    }

    public void b(int i3) {
        this.f39070c = i3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        if (parcel != null) {
            parcel.writeInt(this.f39069b);
            parcel.writeInt(this.f39070c);
        }
    }

    protected m(Parcel parcel) {
        this.f39069b = parcel.readInt();
        this.f39070c = parcel.readInt();
    }
}
