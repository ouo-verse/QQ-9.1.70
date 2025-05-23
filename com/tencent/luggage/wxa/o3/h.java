package com.tencent.luggage.wxa.o3;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class h implements com.tencent.luggage.wxa.w4.a {

    @NotNull
    public static final Parcelable.Creator<h> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public final String f136118a;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final h createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new h(parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final h[] newArray(int i3) {
            return new h[i3];
        }
    }

    public h(String deviceId) {
        Intrinsics.checkNotNullParameter(deviceId, "deviceId");
        this.f136118a = deviceId;
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
        if (!Intrinsics.areEqual(h.class, cls)) {
            return false;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.tencent.luggage.login.account.MMDeviceID");
        if (Intrinsics.areEqual(this.f136118a, ((h) obj).f136118a)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.f136118a.hashCode();
    }

    @Override // com.tencent.luggage.wxa.w4.a
    public String toString() {
        return this.f136118a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i3) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeString(this.f136118a);
    }
}
