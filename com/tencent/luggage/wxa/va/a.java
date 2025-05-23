package com.tencent.luggage.wxa.va;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a implements Parcelable {
    public static final Parcelable.Creator<a> CREATOR = new C6838a();

    /* renamed from: a, reason: collision with root package name */
    public boolean f143312a;

    public a() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof a) {
            if (this.f143312a == ((a) obj).f143312a) {
                return true;
            }
            return false;
        }
        if (!(obj instanceof Boolean)) {
            return false;
        }
        return obj.equals(Boolean.valueOf(this.f143312a));
    }

    public String toString() {
        return Boolean.toString(this.f143312a);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.f143312a ? 1 : 0);
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.va.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C6838a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public a createFromParcel(Parcel parcel) {
            a aVar = new a();
            aVar.f143312a = parcel.readInt() == 1;
            return aVar;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public a[] newArray(int i3) {
            return new a[i3];
        }
    }

    public a(boolean z16) {
        this.f143312a = z16;
    }
}
