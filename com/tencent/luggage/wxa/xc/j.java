package com.tencent.luggage.wxa.xc;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes9.dex */
public class j extends com.tencent.luggage.wxa.xc.a {
    public static final Parcelable.Creator<j> CREATOR = new a();

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public j createFromParcel(Parcel parcel) {
            return new j(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public j[] newArray(int i3) {
            return new j[i3];
        }
    }

    public j(Parcel parcel) {
        super(parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }
}
