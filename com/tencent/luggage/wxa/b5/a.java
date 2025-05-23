package com.tencent.luggage.wxa.b5;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class a extends c {

    @NotNull
    public static final Parcelable.Creator<a> CREATOR = new C6030a();

    /* renamed from: e, reason: collision with root package name */
    public l f121849e;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.b5.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6030a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final a createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new a(l.CREATOR.createFromParcel(parcel));
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final a[] newArray(int i3) {
            return new a[i3];
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NotNull l runtimeInfo) {
        super(runtimeInfo);
        Intrinsics.checkNotNullParameter(runtimeInfo, "runtimeInfo");
        this.f121849e = runtimeInfo;
    }

    public void a(@NotNull l lVar) {
        Intrinsics.checkNotNullParameter(lVar, "<set-?>");
        this.f121849e = lVar;
    }

    @Override // com.tencent.luggage.wxa.wd.d, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.tencent.luggage.wxa.b5.c, com.tencent.luggage.wxa.wd.d
    public void h() {
        super.h();
        com.tencent.luggage.wxa.z4.f.f146283b.a().a(i().c(), i().a());
    }

    @Override // com.tencent.luggage.wxa.b5.c
    @NotNull
    public l i() {
        return this.f121849e;
    }

    @Override // com.tencent.luggage.wxa.b5.c, com.tencent.luggage.wxa.wd.d, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i3) {
        Intrinsics.checkNotNullParameter(out, "out");
        this.f121849e.writeToParcel(out, i3);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(@NotNull com.tencent.luggage.wxa.c5.e rt5) {
        this(d.a(rt5));
        Intrinsics.checkNotNullParameter(rt5, "rt");
    }
}
