package com.tencent.luggage.wxa.va;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes8.dex */
public class c implements Parcelable {
    public static final Parcelable.Creator<c> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public long f143314a;

    public c() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof c) {
            if (this.f143314a == ((c) obj).f143314a) {
                return true;
            }
            return false;
        }
        if (!(obj instanceof Long)) {
            return false;
        }
        return obj.equals(Long.valueOf(this.f143314a));
    }

    public String toString() {
        return Long.toString(this.f143314a);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeLong(this.f143314a);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public c createFromParcel(Parcel parcel) {
            c cVar = new c();
            cVar.f143314a = parcel.readLong();
            return cVar;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public c[] newArray(int i3) {
            return new c[i3];
        }
    }

    public c(long j3) {
        this.f143314a = j3;
    }
}
