package com.tencent.luggage.wxa.v4;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.os.ResultReceiver;

/* compiled from: P */
/* loaded from: classes8.dex */
public class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public final ResultReceiver f143226a;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public b createFromParcel(Parcel parcel) {
            return new b(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public b[] newArray(int i3) {
            return new b[i3];
        }
    }

    public /* synthetic */ b(Parcel parcel, com.tencent.luggage.wxa.v4.a aVar) {
        this(parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        this.f143226a.writeToParcel(parcel, i3);
    }

    public b(Parcel parcel) {
        this.f143226a = ResultReceiver.CREATOR.createFromParcel(parcel);
    }
}
