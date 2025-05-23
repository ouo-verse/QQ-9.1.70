package com.tencent.luggage.wxa.b5;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes8.dex */
public class j extends c {

    @NotNull
    public static final Parcelable.Creator<j> CREATOR = new a();

    /* renamed from: e, reason: collision with root package name */
    public final l f121862e;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final j createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new j(l.CREATOR.createFromParcel(parcel));
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final j[] newArray(int i3) {
            return new j[i3];
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(@NotNull l runtimeInfo) {
        super(runtimeInfo);
        Intrinsics.checkNotNullParameter(runtimeInfo, "runtimeInfo");
        this.f121862e = runtimeInfo;
    }

    public void a(com.tencent.luggage.wxa.z4.g record) {
        Intrinsics.checkNotNullParameter(record, "record");
    }

    @Override // com.tencent.luggage.wxa.wd.d, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.tencent.luggage.wxa.b5.c, com.tencent.luggage.wxa.wd.d
    public void h() {
        super.h();
        a(com.tencent.luggage.wxa.z4.f.f146283b.a().a(i().a(), i().e(), i().d(), i().c(), i().b()));
    }

    @Override // com.tencent.luggage.wxa.b5.c
    @NotNull
    public l i() {
        return this.f121862e;
    }

    @Override // com.tencent.luggage.wxa.b5.c, com.tencent.luggage.wxa.wd.d, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i3) {
        Intrinsics.checkNotNullParameter(out, "out");
        this.f121862e.writeToParcel(out, i3);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public j(@NotNull com.tencent.luggage.wxa.c5.e rt5) {
        this(d.a(rt5));
        Intrinsics.checkNotNullParameter(rt5, "rt");
    }
}
