package com.tencent.luggage.wxa.ic;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class q implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<q> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public final int f129986a;

    /* renamed from: b, reason: collision with root package name */
    public final String f129987b;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final q createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new q(parcel.readInt(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final q[] newArray(int i3) {
            return new q[i3];
        }
    }

    public q(int i3, String str) {
        this.f129986a = i3;
        this.f129987b = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof q)) {
            return false;
        }
        q qVar = (q) obj;
        if (this.f129986a == qVar.f129986a && Intrinsics.areEqual(this.f129987b, qVar.f129987b)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int i3 = this.f129986a * 31;
        String str = this.f129987b;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        return i3 + hashCode;
    }

    public String toString() {
        return "BindRemoteServiceResult(errCode=" + this.f129986a + ", errMsg=" + this.f129987b + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i3) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeInt(this.f129986a);
        out.writeString(this.f129987b);
    }

    public /* synthetic */ q(int i3, String str, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, (i16 & 2) != 0 ? null : str);
    }
}
