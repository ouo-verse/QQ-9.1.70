package com.tencent.luggage.wxa.yc;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes9.dex */
public class c extends com.tencent.luggage.wxa.xc.a {
    public static final Parcelable.Creator<c> CREATOR = new a();

    /* renamed from: b, reason: collision with root package name */
    public List f145521b;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public c createFromParcel(Parcel parcel) {
            return new c(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public c[] newArray(int i3) {
            return new c[i3];
        }
    }

    public c(Parcel parcel) {
        this(parcel, null);
    }

    @Override // com.tencent.luggage.wxa.xc.a
    public void a(Parcel parcel) {
        super.a(parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.tencent.luggage.wxa.xc.a
    public boolean equals(Object obj) {
        if (!super.equals(obj) || !(obj instanceof c)) {
            return false;
        }
        return this.f145521b.equals(((c) obj).f145521b);
    }

    @Override // com.tencent.luggage.wxa.xc.a, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        super.writeToParcel(parcel, i3);
        parcel.writeList(this.f145521b);
    }

    public c(Parcel parcel, Object obj) {
        super(parcel, obj);
        this.f145521b = new ArrayList();
        this.f145521b = parcel.readArrayList(c.class.getClassLoader());
    }
}
