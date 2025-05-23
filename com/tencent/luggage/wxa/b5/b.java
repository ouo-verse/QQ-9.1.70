package com.tencent.luggage.wxa.b5;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.luggage.wxa.tn.w;
import java.util.Iterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class b extends com.tencent.luggage.wxa.wd.d {

    @NotNull
    public static final Parcelable.Creator<b> CREATOR = new a();

    /* renamed from: c, reason: collision with root package name */
    public final String f121850c;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final b createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new b(parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final b[] newArray(int i3) {
            return new b[i3];
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.b5.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6031b extends Lambda implements Function1 {
        public C6031b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(com.tencent.luggage.wxa.z4.e it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return Boolean.valueOf(Intrinsics.areEqual(it.e(), b.this.f121850c));
        }
    }

    public b(@NotNull String processName) {
        Intrinsics.checkNotNullParameter(processName, "processName");
        this.f121850c = processName;
    }

    @Override // com.tencent.luggage.wxa.wd.d
    public void h() {
        w.d("LuggageInitTask", "runInMainProcess for " + this.f121850c);
        Iterator it = com.tencent.luggage.wxa.z4.f.f146283b.a().a(new C6031b()).iterator();
        while (it.hasNext()) {
            ((com.tencent.luggage.wxa.z4.e) it.next()).m();
        }
    }

    @Override // com.tencent.luggage.wxa.wd.d, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i3) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeString(this.f121850c);
    }
}
