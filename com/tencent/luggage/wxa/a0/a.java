package com.tencent.luggage.wxa.a0;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.List;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class a implements Parcelable {
    public static final Parcelable.Creator<a> CREATOR = new C5981a();

    /* renamed from: a, reason: collision with root package name */
    public final b[] f120835a;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.a0.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C5981a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public a[] newArray(int i3) {
            return new a[0];
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public a createFromParcel(Parcel parcel) {
            return new a(parcel);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface b extends Parcelable {
    }

    public a(List list) {
        if (list != null) {
            b[] bVarArr = new b[list.size()];
            this.f120835a = bVarArr;
            list.toArray(bVarArr);
            return;
        }
        this.f120835a = new b[0];
    }

    public int a() {
        return this.f120835a.length;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && a.class == obj.getClass()) {
            return Arrays.equals(this.f120835a, ((a) obj).f120835a);
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(this.f120835a);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.f120835a.length);
        for (b bVar : this.f120835a) {
            parcel.writeParcelable(bVar, 0);
        }
    }

    public b a(int i3) {
        return this.f120835a[i3];
    }

    public a(Parcel parcel) {
        this.f120835a = new b[parcel.readInt()];
        int i3 = 0;
        while (true) {
            b[] bVarArr = this.f120835a;
            if (i3 >= bVarArr.length) {
                return;
            }
            bVarArr[i3] = (b) parcel.readParcelable(b.class.getClassLoader());
            i3++;
        }
    }
}
