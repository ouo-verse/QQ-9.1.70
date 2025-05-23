package com.tencent.luggage.wxa.u7;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class a implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<a> CREATOR = new C6786a();

    /* renamed from: a, reason: collision with root package name */
    public final long f142124a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f142125b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f142126c;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.u7.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6786a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final a createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new a(parcel.readLong(), parcel.readInt() != 0, parcel.readInt() != 0);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final a[] newArray(int i3) {
            return new a[i3];
        }
    }

    public a(long j3, boolean z16, boolean z17) {
        this.f142124a = j3;
        this.f142125b = z16;
        this.f142126c = z17;
    }

    public final long a() {
        return this.f142124a;
    }

    public final boolean b() {
        return this.f142125b;
    }

    public final boolean c() {
        return this.f142126c;
    }

    public final long d() {
        return this.f142124a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (this.f142124a == aVar.f142124a && this.f142125b == aVar.f142125b && this.f142126c == aVar.f142126c) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int a16 = androidx.fragment.app.a.a(this.f142124a) * 31;
        boolean z16 = this.f142125b;
        int i3 = 1;
        int i16 = z16;
        if (z16 != 0) {
            i16 = 1;
        }
        int i17 = (a16 + i16) * 31;
        boolean z17 = this.f142126c;
        if (!z17) {
            i3 = z17 ? 1 : 0;
        }
        return i17 + i3;
    }

    public String toString() {
        return "WxaAppInitReadyMetrics(timestampNs:" + this.f142124a + ", isHitPreload:" + this.f142125b + ", isHitPkgCache:" + this.f142126c + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i3) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeLong(this.f142124a);
        out.writeInt(this.f142125b ? 1 : 0);
        out.writeInt(this.f142126c ? 1 : 0);
    }
}
