package com.tencent.luggage.wxa.q3;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class f implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<f> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public int f137829a;

    /* renamed from: b, reason: collision with root package name */
    public int f137830b;

    /* renamed from: c, reason: collision with root package name */
    public String f137831c;

    /* renamed from: d, reason: collision with root package name */
    public com.tencent.luggage.wxa.fn.b f137832d;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final f createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new f(parcel.readInt(), parcel.readInt(), parcel.readString(), b.f137818a.create(parcel));
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final f[] newArray(int i3) {
            return new f[i3];
        }
    }

    public f(int i3, int i16, String str, com.tencent.luggage.wxa.fn.b bVar) {
        this.f137829a = i3;
        this.f137830b = i16;
        this.f137831c = str;
        this.f137832d = bVar;
    }

    public final int a() {
        return this.f137830b;
    }

    public final void b(int i3) {
        this.f137829a = i3;
    }

    public final int c() {
        return this.f137829a;
    }

    public final com.tencent.luggage.wxa.fn.b d() {
        return this.f137832d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        if (this.f137829a == fVar.f137829a && this.f137830b == fVar.f137830b && Intrinsics.areEqual(this.f137831c, fVar.f137831c) && Intrinsics.areEqual(this.f137832d, fVar.f137832d)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int i3 = ((this.f137829a * 31) + this.f137830b) * 31;
        String str = this.f137831c;
        int i16 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i17 = (i3 + hashCode) * 31;
        com.tencent.luggage.wxa.fn.b bVar = this.f137832d;
        if (bVar != null) {
            i16 = bVar.hashCode();
        }
        return i17 + i16;
    }

    public String toString() {
        return "TdiResponse(errType=" + this.f137829a + ", errCode=" + this.f137830b + ", errMsg=" + this.f137831c + ", resp=" + this.f137832d + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i3) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeInt(this.f137829a);
        out.writeInt(this.f137830b);
        out.writeString(this.f137831c);
        b.f137818a.write(this.f137832d, out, i3);
    }

    public final void a(int i3) {
        this.f137830b = i3;
    }

    public final String b() {
        return this.f137831c;
    }

    public final void a(String str) {
        this.f137831c = str;
    }

    public final void a(com.tencent.luggage.wxa.fn.b bVar) {
        this.f137832d = bVar;
    }

    public /* synthetic */ f(int i3, int i16, String str, com.tencent.luggage.wxa.fn.b bVar, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this((i17 & 1) != 0 ? -1 : i3, (i17 & 2) != 0 ? -1 : i16, (i17 & 4) != 0 ? null : str, (i17 & 8) != 0 ? null : bVar);
    }
}
