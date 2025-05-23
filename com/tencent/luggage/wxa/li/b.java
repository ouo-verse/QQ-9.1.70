package com.tencent.luggage.wxa.li;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class b implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<b> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public final String f133420a;

    /* renamed from: b, reason: collision with root package name */
    public final String f133421b;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final b createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new b(parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final b[] newArray(int i3) {
            return new b[i3];
        }
    }

    public b(String refererInstanceId, String str) {
        Intrinsics.checkNotNullParameter(refererInstanceId, "refererInstanceId");
        this.f133420a = refererInstanceId;
        this.f133421b = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (Intrinsics.areEqual(this.f133420a, bVar.f133420a) && Intrinsics.areEqual(this.f133421b, bVar.f133421b)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = this.f133420a.hashCode() * 31;
        String str = this.f133421b;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        return hashCode2 + hashCode;
    }

    public String toString() {
        return "AppBrandRuntimeReloadReportBundle(refererInstanceId=" + this.f133420a + ", reloadReason=" + this.f133421b + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i3) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeString(this.f133420a);
        out.writeString(this.f133421b);
    }
}
