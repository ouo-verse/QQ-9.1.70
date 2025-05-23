package com.tencent.luggage.wxa.c0;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class b extends h {
    public static final Parcelable.Creator<b> CREATOR = new a();

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f123166b;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public b createFromParcel(Parcel parcel) {
            return new b(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public b[] newArray(int i3) {
            return new b[i3];
        }
    }

    public b(String str, byte[] bArr) {
        super(str);
        this.f123166b = bArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        if (this.f123190a.equals(bVar.f123190a) && Arrays.equals(this.f123166b, bVar.f123166b)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((this.f123190a.hashCode() + 527) * 31) + Arrays.hashCode(this.f123166b);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f123190a);
        parcel.writeByteArray(this.f123166b);
    }

    public b(Parcel parcel) {
        super(parcel.readString());
        this.f123166b = parcel.createByteArray();
    }
}
