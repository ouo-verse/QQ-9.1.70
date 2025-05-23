package com.tencent.luggage.wxa.n3;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class v implements com.tencent.luggage.wxa.w4.a {

    @NotNull
    public static final Parcelable.Creator<v> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public final int f135266a;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final v createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new v(parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final v[] newArray(int i3) {
            return new v[i3];
        }
    }

    public v(int i3) {
        this.f135266a = i3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        Class<?> cls;
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            cls = obj.getClass();
        } else {
            cls = null;
        }
        if (!Intrinsics.areEqual(v.class, cls)) {
            return false;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.tencent.luggage.login.MMUIN");
        if (this.f135266a == ((v) obj).f135266a) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.f135266a;
    }

    @Override // com.tencent.luggage.wxa.w4.a
    public String toString() {
        return String.valueOf(new com.tencent.luggage.wxa.y8.h(this.f135266a).longValue());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i3) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeInt(this.f135266a);
    }
}
