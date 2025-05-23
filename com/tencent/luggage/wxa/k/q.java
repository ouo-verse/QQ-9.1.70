package com.tencent.luggage.wxa.k;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;

/* compiled from: P */
/* loaded from: classes8.dex */
public class q implements Comparable, Parcelable {
    public static final Parcelable.Creator<q> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public final int f131357a;

    /* renamed from: b, reason: collision with root package name */
    public final int f131358b;

    public q(int i3, int i16) {
        this.f131357a = i3;
        this.f131358b = i16;
    }

    public int a() {
        return this.f131358b;
    }

    public int b() {
        return this.f131357a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof q)) {
            return false;
        }
        q qVar = (q) obj;
        if (this.f131357a != qVar.f131357a || this.f131358b != qVar.f131358b) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i3 = this.f131358b;
        int i16 = this.f131357a;
        return i3 ^ ((i16 >>> 16) | (i16 << 16));
    }

    public String toString() {
        return this.f131357a + HippyTKDListViewAdapter.X + this.f131358b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.f131357a);
        parcel.writeInt(this.f131358b);
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(q qVar) {
        return (this.f131357a * this.f131358b) - (qVar.f131357a * qVar.f131358b);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public q createFromParcel(Parcel parcel) {
            return new q(parcel.readInt(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public q[] newArray(int i3) {
            return new q[i3];
        }
    }
}
