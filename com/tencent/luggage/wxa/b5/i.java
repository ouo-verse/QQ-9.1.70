package com.tencent.luggage.wxa.b5;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class i extends c {

    @NotNull
    public static final Parcelable.Creator<i> CREATOR = new a();

    /* renamed from: e, reason: collision with root package name */
    public final l f121859e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f121860f;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final i createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new i(l.CREATOR.createFromParcel(parcel), parcel.readInt() != 0);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final i[] newArray(int i3) {
            return new i[i3];
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b extends Lambda implements Function1 {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.z4.e f121861a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(com.tencent.luggage.wxa.z4.e eVar) {
            super(1);
            this.f121861a = eVar;
        }

        public final void a(com.tencent.luggage.wxa.z4.g record) {
            Intrinsics.checkNotNullParameter(record, "record");
            this.f121861a.a(record);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((com.tencent.luggage.wxa.z4.g) obj);
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(@NotNull l runtimeInfo, boolean z16) {
        super(runtimeInfo);
        Intrinsics.checkNotNullParameter(runtimeInfo, "runtimeInfo");
        this.f121859e = runtimeInfo;
        this.f121860f = z16;
    }

    @Override // com.tencent.luggage.wxa.b5.c
    public void a(@NotNull com.tencent.luggage.wxa.z4.e process) {
        Intrinsics.checkNotNullParameter(process, "process");
        com.tencent.luggage.wxa.z4.f.f146283b.a().a(i().a(), i().e(), new b(process));
        if (this.f121860f) {
            new f(i()).h();
        }
    }

    @Override // com.tencent.luggage.wxa.wd.d, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.tencent.luggage.wxa.b5.c
    @NotNull
    public l i() {
        return this.f121859e;
    }

    @Override // com.tencent.luggage.wxa.b5.c, com.tencent.luggage.wxa.wd.d, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i3) {
        Intrinsics.checkNotNullParameter(out, "out");
        this.f121859e.writeToParcel(out, i3);
        out.writeInt(this.f121860f ? 1 : 0);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public i(@NotNull com.tencent.luggage.wxa.c5.e rt5, boolean z16) {
        this(d.a(rt5), z16);
        Intrinsics.checkNotNullParameter(rt5, "rt");
    }
}
