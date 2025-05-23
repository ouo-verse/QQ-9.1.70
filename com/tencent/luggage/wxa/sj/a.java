package com.tencent.luggage.wxa.sj;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.luggage.wxa.xd.l;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a implements Parcelable, l {
    public static final Parcelable.Creator<a> CREATOR = new C6720a();

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f140382a;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.sj.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C6720a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public a createFromParcel(Parcel parcel) {
            return new a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public a[] newArray(int i3) {
            return new a[i3];
        }
    }

    public a(Parcel parcel) {
        this.f140382a = parcel.createByteArray();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeByteArray(this.f140382a);
    }
}
