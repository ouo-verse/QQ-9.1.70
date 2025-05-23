package com.tencent.luggage.wxa.q3;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.luggage.wxa.n3.w;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class e implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<e> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public int f137824a;

    /* renamed from: b, reason: collision with root package name */
    public String f137825b;

    /* renamed from: c, reason: collision with root package name */
    public w f137826c;

    /* renamed from: d, reason: collision with root package name */
    public com.tencent.luggage.wxa.fn.b f137827d;

    /* renamed from: e, reason: collision with root package name */
    public String f137828e;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final e createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new e(parcel.readInt(), parcel.readString(), w.valueOf(parcel.readString()), b.f137818a.create(parcel), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final e[] newArray(int i3) {
            return new e[i3];
        }
    }

    public e(int i3, String url, w networkType, com.tencent.luggage.wxa.fn.b bVar, String respClassName) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(networkType, "networkType");
        Intrinsics.checkNotNullParameter(respClassName, "respClassName");
        this.f137824a = i3;
        this.f137825b = url;
        this.f137826c = networkType;
        this.f137827d = bVar;
        this.f137828e = respClassName;
    }

    public final int a() {
        return this.f137824a;
    }

    public final w b() {
        return this.f137826c;
    }

    public final com.tencent.luggage.wxa.fn.b c() {
        return this.f137827d;
    }

    public final String d() {
        return this.f137828e;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final String e() {
        return this.f137825b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        if (this.f137824a == eVar.f137824a && Intrinsics.areEqual(this.f137825b, eVar.f137825b) && this.f137826c == eVar.f137826c && Intrinsics.areEqual(this.f137827d, eVar.f137827d) && Intrinsics.areEqual(this.f137828e, eVar.f137828e)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = ((((this.f137824a * 31) + this.f137825b.hashCode()) * 31) + this.f137826c.hashCode()) * 31;
        com.tencent.luggage.wxa.fn.b bVar = this.f137827d;
        if (bVar == null) {
            hashCode = 0;
        } else {
            hashCode = bVar.hashCode();
        }
        return ((hashCode2 + hashCode) * 31) + this.f137828e.hashCode();
    }

    public String toString() {
        return "TdiRequest(cmdId=" + this.f137824a + ", url=" + this.f137825b + ", networkType=" + this.f137826c + ", req=" + this.f137827d + ", respClassName=" + this.f137828e + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i3) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeInt(this.f137824a);
        out.writeString(this.f137825b);
        out.writeString(this.f137826c.name());
        b.f137818a.write(this.f137827d, out, i3);
        out.writeString(this.f137828e);
    }
}
