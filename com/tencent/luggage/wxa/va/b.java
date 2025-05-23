package com.tencent.luggage.wxa.va;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes8.dex */
public class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public int f143313a;

    public b() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof b) {
            if (this.f143313a == ((b) obj).f143313a) {
                return true;
            }
            return false;
        }
        if (!(obj instanceof Integer)) {
            return false;
        }
        return obj.equals(Integer.valueOf(this.f143313a));
    }

    public String toString() {
        return Integer.toString(this.f143313a);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.f143313a);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public b createFromParcel(Parcel parcel) {
            b bVar = new b();
            bVar.f143313a = parcel.readInt();
            return bVar;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public b[] newArray(int i3) {
            return new b[i3];
        }
    }

    public b(int i3) {
        this.f143313a = i3;
    }
}
