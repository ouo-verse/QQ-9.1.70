package com.tencent.luggage.wxa.b5;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.luggage.wxa.tn.w;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes8.dex */
public class c extends com.tencent.luggage.wxa.wd.d {

    /* renamed from: c, reason: collision with root package name */
    public final l f121853c;

    /* renamed from: d, reason: collision with root package name */
    public static final a f121852d = new a(null);

    @NotNull
    public static final Parcelable.Creator<c> CREATOR = new b();

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
        public final c createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new c(l.CREATOR.createFromParcel(parcel));
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final c[] newArray(int i3) {
            return new c[i3];
        }
    }

    public c(@NotNull l runtimeInfo) {
        Intrinsics.checkNotNullParameter(runtimeInfo, "runtimeInfo");
        this.f121853c = runtimeInfo;
    }

    public void a(@NotNull com.tencent.luggage.wxa.z4.e process) {
        Intrinsics.checkNotNullParameter(process, "process");
    }

    @Override // com.tencent.luggage.wxa.wd.d
    public void h() {
        com.tencent.luggage.wxa.z4.e eVar;
        try {
            eVar = com.tencent.luggage.wxa.z4.f.f146283b.a().a(i().d());
        } catch (Exception unused) {
            w.f("Luggage.LuggageMainProcessTaskExt", "Main process index list has been changed and give up registering task.The consequence is we can't do clearDuplicatedApp() because runtime record is lost. processIndex:" + i().d() + ", appId:" + i().a());
            eVar = null;
        }
        if (eVar == null) {
            return;
        }
        w.d("Luggage.LuggageMainProcessTaskExt", "runInMainProcess: [" + i().a() + "] run [" + getClass().getSimpleName() + "] by process [" + i().d() + "][" + eVar.e() + ']');
        try {
            a(eVar);
        } catch (Throwable th5) {
            w.b("Luggage.LuggageMainProcessTaskExt", "invoke[%s]: fatal error[%s][%s]\ndump processes[%s]\ndump origin invoke info[%s]", getClass().getCanonicalName(), th5.getMessage(), th5.getStackTrace(), com.tencent.luggage.wxa.z4.f.f146283b.a().f(), i());
            throw th5;
        }
    }

    @NotNull
    public l i() {
        return this.f121853c;
    }

    @Override // com.tencent.luggage.wxa.wd.d, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i3) {
        Intrinsics.checkNotNullParameter(out, "out");
        this.f121853c.writeToParcel(out, i3);
    }
}
