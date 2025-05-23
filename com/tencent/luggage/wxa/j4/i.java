package com.tencent.luggage.wxa.j4;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class i implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<i> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public com.tencent.luggage.wxa.rj.b f130840a;

    /* renamed from: b, reason: collision with root package name */
    public Parcelable f130841b;

    /* renamed from: c, reason: collision with root package name */
    public String f130842c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f130843d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f130844e;

    /* renamed from: f, reason: collision with root package name */
    public j f130845f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f130846g;

    /* renamed from: h, reason: collision with root package name */
    public String f130847h;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final i createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new i((com.tencent.luggage.wxa.rj.b) parcel.readParcelable(i.class.getClassLoader()), parcel.readParcelable(i.class.getClassLoader()), parcel.readString(), parcel.readInt() != 0, parcel.readInt() != 0, parcel.readInt() == 0 ? null : j.CREATOR.createFromParcel(parcel), parcel.readInt() != 0, parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final i[] newArray(int i3) {
            return new i[i3];
        }
    }

    public i(com.tencent.luggage.wxa.rj.b bVar, Parcelable parcelable, String str, boolean z16, boolean z17, j jVar, boolean z18, String str2) {
        this.f130840a = bVar;
        this.f130841b = parcelable;
        this.f130842c = str;
        this.f130843d = z16;
        this.f130844e = z17;
        this.f130845f = jVar;
        this.f130846g = z18;
        this.f130847h = str2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i3) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeParcelable(this.f130840a, i3);
        out.writeParcelable(this.f130841b, i3);
        out.writeString(this.f130842c);
        out.writeInt(this.f130843d ? 1 : 0);
        out.writeInt(this.f130844e ? 1 : 0);
        j jVar = this.f130845f;
        if (jVar == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            jVar.writeToParcel(out, i3);
        }
        out.writeInt(this.f130846g ? 1 : 0);
        out.writeString(this.f130847h);
    }
}
