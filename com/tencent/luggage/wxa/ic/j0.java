package com.tencent.luggage.wxa.ic;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class j0 implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<j0> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public final String f129894a;

    /* renamed from: b, reason: collision with root package name */
    public final int f129895b;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final j0 createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new j0(parcel.readString(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final j0[] newArray(int i3) {
            return new j0[i3];
        }
    }

    public j0(String appID, int i3) {
        Intrinsics.checkNotNullParameter(appID, "appID");
        this.f129894a = appID;
        this.f129895b = i3;
    }

    public final String a() {
        return this.f129894a;
    }

    public final int b() {
        return this.f129895b;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j0)) {
            return false;
        }
        j0 j0Var = (j0) obj;
        if (Intrinsics.areEqual(this.f129894a, j0Var.f129894a) && this.f129895b == j0Var.f129895b) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.f129894a.hashCode() * 31) + this.f129895b;
    }

    public String toString() {
        return "RemoveDataClass(appID=" + this.f129894a + ", processIndex=" + this.f129895b + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i3) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeString(this.f129894a);
        out.writeInt(this.f129895b);
    }
}
