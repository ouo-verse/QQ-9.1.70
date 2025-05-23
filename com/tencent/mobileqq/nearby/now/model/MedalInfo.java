package com.tencent.mobileqq.nearby.now.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes15.dex */
public class MedalInfo implements Parcelable {
    public static final Parcelable.Creator<MedalInfo> CREATOR = new a();

    /* renamed from: d, reason: collision with root package name */
    public int f252679d;

    /* renamed from: e, reason: collision with root package name */
    public int f252680e;

    /* renamed from: f, reason: collision with root package name */
    public int f252681f;

    /* renamed from: h, reason: collision with root package name */
    public List<MedalItem> f252682h = new ArrayList();

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a implements Parcelable.Creator<MedalInfo> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public MedalInfo createFromParcel(Parcel parcel) {
            return new MedalInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public MedalInfo[] newArray(int i3) {
            return new MedalInfo[i3];
        }
    }

    public MedalInfo() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        boolean z16 = obj instanceof MedalInfo;
        return false;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.f252679d);
        parcel.writeInt(this.f252680e);
        parcel.writeInt(this.f252681f);
        List<MedalItem> list = this.f252682h;
        if (list != null) {
            parcel.writeTypedList(list);
        }
    }

    protected MedalInfo(Parcel parcel) {
        this.f252679d = parcel.readInt();
        this.f252680e = parcel.readInt();
        this.f252681f = parcel.readInt();
        parcel.readTypedList(this.f252682h, MedalItem.CREATOR);
    }
}
