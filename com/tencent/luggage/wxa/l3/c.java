package com.tencent.luggage.wxa.l3;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.luggage.wxa.fd.n;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class c implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<c> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public final String f132978a;

    /* renamed from: b, reason: collision with root package name */
    public final String f132979b;

    /* renamed from: c, reason: collision with root package name */
    public final int f132980c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f132981d;

    /* renamed from: e, reason: collision with root package name */
    public final int f132982e;

    /* renamed from: f, reason: collision with root package name */
    public final com.tencent.luggage.wxa.bk.e f132983f;

    /* renamed from: g, reason: collision with root package name */
    public final n f132984g;

    /* renamed from: h, reason: collision with root package name */
    public final com.tencent.luggage.wxa.j4.d f132985h;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final c createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new c(parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt() != 0, parcel.readInt(), (com.tencent.luggage.wxa.bk.e) parcel.readParcelable(c.class.getClassLoader()), (n) parcel.readParcelable(c.class.getClassLoader()), (com.tencent.luggage.wxa.j4.d) parcel.readParcelable(c.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final c[] newArray(int i3) {
            return new c[i3];
        }
    }

    public c(String appId, String processName, int i3, boolean z16, int i16, com.tencent.luggage.wxa.bk.e eVar, n nVar, com.tencent.luggage.wxa.j4.d initConfig) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(processName, "processName");
        Intrinsics.checkNotNullParameter(initConfig, "initConfig");
        this.f132978a = appId;
        this.f132979b = processName;
        this.f132980c = i3;
        this.f132981d = z16;
        this.f132982e = i16;
        this.f132983f = eVar;
        this.f132984g = nVar;
        this.f132985h = initConfig;
    }

    public final String a() {
        return this.f132978a;
    }

    public final com.tencent.luggage.wxa.j4.d b() {
        return this.f132985h;
    }

    public final int c() {
        return this.f132980c;
    }

    public final com.tencent.luggage.wxa.bk.e d() {
        return this.f132983f;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final int e() {
        return this.f132982e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        if (Intrinsics.areEqual(this.f132978a, cVar.f132978a) && Intrinsics.areEqual(this.f132979b, cVar.f132979b) && this.f132980c == cVar.f132980c && this.f132981d == cVar.f132981d && this.f132982e == cVar.f132982e && Intrinsics.areEqual(this.f132983f, cVar.f132983f) && Intrinsics.areEqual(this.f132984g, cVar.f132984g) && Intrinsics.areEqual(this.f132985h, cVar.f132985h)) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        int hashCode2 = ((((this.f132978a.hashCode() * 31) + this.f132979b.hashCode()) * 31) + this.f132980c) * 31;
        boolean z16 = this.f132981d;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        int i16 = (((hashCode2 + i3) * 31) + this.f132982e) * 31;
        com.tencent.luggage.wxa.bk.e eVar = this.f132983f;
        int i17 = 0;
        if (eVar == null) {
            hashCode = 0;
        } else {
            hashCode = eVar.hashCode();
        }
        int i18 = (i16 + hashCode) * 31;
        n nVar = this.f132984g;
        if (nVar != null) {
            i17 = nVar.hashCode();
        }
        return ((i18 + i17) * 31) + this.f132985h.hashCode();
    }

    public String toString() {
        return "{appId:" + this.f132978a + " processName:" + this.f132979b + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i3) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeString(this.f132978a);
        out.writeString(this.f132979b);
        out.writeInt(this.f132980c);
        out.writeInt(this.f132981d ? 1 : 0);
        out.writeInt(this.f132982e);
        out.writeParcelable(this.f132983f, i3);
        out.writeParcelable(this.f132984g, i3);
        out.writeParcelable(this.f132985h, i3);
    }
}
