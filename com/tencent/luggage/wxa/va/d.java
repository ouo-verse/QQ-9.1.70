package com.tencent.luggage.wxa.va;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes8.dex */
public class d implements Parcelable {
    public static final Parcelable.Creator<d> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public String f143315a;

    public d() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            String str = this.f143315a;
            String str2 = ((d) obj).f143315a;
            if (str == str2) {
                return true;
            }
            if (str != null && str.equals(str2)) {
                return true;
            }
            return false;
        }
        if (!(obj instanceof String)) {
            return false;
        }
        return obj.equals(this.f143315a);
    }

    public String toString() {
        return this.f143315a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f143315a);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public d createFromParcel(Parcel parcel) {
            d dVar = new d();
            dVar.f143315a = parcel.readString();
            return dVar;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public d[] newArray(int i3) {
            return new d[i3];
        }
    }

    public d(String str) {
        this.f143315a = str;
    }
}
