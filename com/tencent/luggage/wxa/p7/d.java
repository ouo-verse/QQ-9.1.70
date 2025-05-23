package com.tencent.luggage.wxa.p7;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class d implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<d> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public final String f137380a;

    /* renamed from: b, reason: collision with root package name */
    public final int f137381b;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final d createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new d(parcel.readString(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final d[] newArray(int i3) {
            return new d[i3];
        }
    }

    public d(String str, int i3) {
        this.f137380a = str;
        this.f137381b = i3;
    }

    public final String a() {
        return this.f137380a;
    }

    public final int b() {
        return this.f137381b;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        if (Intrinsics.areEqual(this.f137380a, dVar.f137380a) && this.f137381b == dVar.f137381b) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        String str = this.f137380a;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        return (hashCode * 31) + this.f137381b;
    }

    public String toString() {
        return "ModCollectionParcel(username=" + this.f137380a + ", versionType=" + this.f137381b + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i3) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeString(this.f137380a);
        out.writeInt(this.f137381b);
    }
}
