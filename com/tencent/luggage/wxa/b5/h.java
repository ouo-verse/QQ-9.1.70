package com.tencent.luggage.wxa.b5;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.luggage.wxa.tn.w;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes8.dex */
public class h extends c {

    /* renamed from: e, reason: collision with root package name */
    public final l f121858e;

    /* renamed from: f, reason: collision with root package name */
    public static final a f121857f = new a(null);

    @NotNull
    public static final Parcelable.Creator<h> CREATOR = new b();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final h createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new h(l.CREATOR.createFromParcel(parcel));
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final h[] newArray(int i3) {
            return new h[i3];
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(@NotNull l runtimeInfo) {
        super(runtimeInfo);
        Intrinsics.checkNotNullParameter(runtimeInfo, "runtimeInfo");
        this.f121858e = runtimeInfo;
    }

    public void a(com.tencent.luggage.wxa.z4.g record) {
        Intrinsics.checkNotNullParameter(record, "record");
    }

    @Override // com.tencent.luggage.wxa.wd.d, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.tencent.luggage.wxa.b5.c
    @NotNull
    public l i() {
        return this.f121858e;
    }

    @Override // com.tencent.luggage.wxa.b5.c, com.tencent.luggage.wxa.wd.d, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i3) {
        Intrinsics.checkNotNullParameter(out, "out");
        this.f121858e.writeToParcel(out, i3);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public h(@NotNull com.tencent.luggage.wxa.c5.e rt5) {
        this(d.a(rt5));
        Intrinsics.checkNotNullParameter(rt5, "rt");
    }

    @Override // com.tencent.luggage.wxa.b5.c
    public void a(@NotNull com.tencent.luggage.wxa.z4.e process) {
        Intrinsics.checkNotNullParameter(process, "process");
        com.tencent.luggage.wxa.z4.g a16 = com.tencent.luggage.wxa.z4.e.a(process, i().a(), 0, 2, (Object) null);
        if (a16 == null) {
            a16 = process.a(i().a(), i().e(), i().c(), i().b(), i().f());
        }
        if (i().e() != a16.b()) {
            w.b("Luggage.LuggageRegisterTask", "runInMainProcess appId:" + i().a() + ", instanceId:" + i().c() + ", runtimeInfo.versionType(" + i().e() + ") != record.debugType(" + a16.b() + ')');
            return;
        }
        a16.a(i().f());
        a16.a(i().c());
        a16.a(i().b());
        a(a16);
        a16.a(com.tencent.luggage.wxa.z4.h.RUNNING);
        com.tencent.luggage.wxa.z4.f.f146283b.a().a(process, a16.d(), a16.a());
    }
}
