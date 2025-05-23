package com.tencent.luggage.wxa.a1;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.luggage.wxa.x0.f;
import com.tencent.luggage.wxa.x0.h;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a implements Parcelable {
    public static final Parcelable.Creator<a> CREATOR = new C5982a();

    /* renamed from: a, reason: collision with root package name */
    public f f120836a;

    /* renamed from: b, reason: collision with root package name */
    public h f120837b;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.a1.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C5982a implements Parcelable.Creator {
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

    public a() {
    }

    public f a() {
        return this.f120836a;
    }

    public h b() {
        return this.f120837b;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        int ordinal;
        parcel.writeParcelable(this.f120836a, i3);
        h hVar = this.f120837b;
        if (hVar == null) {
            ordinal = -1;
        } else {
            ordinal = hVar.ordinal();
        }
        parcel.writeInt(ordinal);
    }

    public a(Parcel parcel) {
        this.f120836a = (f) parcel.readParcelable(f.class.getClassLoader());
        int readInt = parcel.readInt();
        this.f120837b = readInt == -1 ? null : h.values()[readInt];
    }

    public void a(f fVar) {
        this.f120836a = fVar;
    }

    public void a(h hVar) {
        this.f120837b = hVar;
    }
}
