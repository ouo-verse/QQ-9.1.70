package com.tencent.luggage.wxa.ic;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class p implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<p> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public final com.tencent.luggage.wxa.r5.a f129979a;

    /* renamed from: b, reason: collision with root package name */
    public final com.tencent.luggage.wxa.bk.e f129980b;

    /* renamed from: c, reason: collision with root package name */
    public final int f129981c;

    /* renamed from: d, reason: collision with root package name */
    public final com.tencent.luggage.wxa.ic.a f129982d;

    /* renamed from: e, reason: collision with root package name */
    public final com.tencent.luggage.wxa.v4.i f129983e;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final p createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new p((com.tencent.luggage.wxa.r5.a) parcel.readParcelable(p.class.getClassLoader()), (com.tencent.luggage.wxa.bk.e) parcel.readParcelable(p.class.getClassLoader()), parcel.readInt(), (com.tencent.luggage.wxa.ic.a) parcel.readParcelable(p.class.getClassLoader()), com.tencent.luggage.wxa.v4.i.valueOf(parcel.readString()));
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final p[] newArray(int i3) {
            return new p[i3];
        }
    }

    public p(com.tencent.luggage.wxa.r5.a config, com.tencent.luggage.wxa.bk.e stat, int i3, com.tencent.luggage.wxa.ic.a actionParcelable, com.tencent.luggage.wxa.v4.i wxaColdStartMode) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(stat, "stat");
        Intrinsics.checkNotNullParameter(actionParcelable, "actionParcelable");
        Intrinsics.checkNotNullParameter(wxaColdStartMode, "wxaColdStartMode");
        this.f129979a = config;
        this.f129980b = stat;
        this.f129981c = i3;
        this.f129982d = actionParcelable;
        this.f129983e = wxaColdStartMode;
    }

    public final com.tencent.luggage.wxa.ic.a a() {
        return this.f129982d;
    }

    public final com.tencent.luggage.wxa.r5.a b() {
        return this.f129979a;
    }

    public final int c() {
        return this.f129981c;
    }

    public final com.tencent.luggage.wxa.bk.e d() {
        return this.f129980b;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final com.tencent.luggage.wxa.v4.i e() {
        return this.f129983e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof p)) {
            return false;
        }
        p pVar = (p) obj;
        if (Intrinsics.areEqual(this.f129979a, pVar.f129979a) && Intrinsics.areEqual(this.f129980b, pVar.f129980b) && this.f129981c == pVar.f129981c && Intrinsics.areEqual(this.f129982d, pVar.f129982d) && this.f129983e == pVar.f129983e) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((((this.f129979a.hashCode() * 31) + this.f129980b.hashCode()) * 31) + this.f129981c) * 31) + this.f129982d.hashCode()) * 31) + this.f129983e.hashCode();
    }

    public String toString() {
        return "BindRemoteServiceData(config=" + this.f129979a + ", stat=" + this.f129980b + ", loaderId=" + this.f129981c + ", actionParcelable=" + this.f129982d + ", wxaColdStartMode=" + this.f129983e + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i3) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeParcelable(this.f129979a, i3);
        out.writeParcelable(this.f129980b, i3);
        out.writeInt(this.f129981c);
        out.writeParcelable(this.f129982d, i3);
        out.writeString(this.f129983e.name());
    }
}
