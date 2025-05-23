package com.tencent.luggage.wxa.l3;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class f extends com.tencent.luggage.wxa.a5.d implements com.tencent.luggage.wxa.a5.a {

    /* renamed from: b, reason: collision with root package name */
    public final String f132989b;

    /* renamed from: c, reason: collision with root package name */
    public final String f132990c;

    /* renamed from: d, reason: collision with root package name */
    public final String f132991d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f132992e;

    /* renamed from: f, reason: collision with root package name */
    public final int f132993f;

    /* renamed from: g, reason: collision with root package name */
    public static final a f132988g = new a(null);

    @NotNull
    public static final Parcelable.Creator<f> CREATOR = new b();

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
        public final f createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new f(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final f[] newArray(int i3) {
            return new f[i3];
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CountDownLatch f132994a;

        public c(CountDownLatch countDownLatch) {
            this.f132994a = countDownLatch;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f132994a.countDown();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class d extends Lambda implements Function0 {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.c5.b f132995a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(com.tencent.luggage.wxa.c5.b bVar) {
            super(0);
            this.f132995a = bVar;
        }

        public final void a() {
            this.f132995a.close();
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    public /* synthetic */ f(String str, String str2, String str3, boolean z16, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i16 & 4) != 0 ? null : str3, (i16 & 8) != 0 ? false : z16, (i16 & 16) != 0 ? 1 : i3);
    }

    @Override // com.tencent.luggage.wxa.a5.b
    public String b() {
        return this.f132989b;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "WxaFinishMessage(appId='" + b() + "', killTypeName=" + this.f132991d + ", isSync=" + this.f132992e + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i3) {
        Intrinsics.checkNotNullParameter(out, "out");
        out.writeString(this.f132989b);
        out.writeString(this.f132990c);
        out.writeString(this.f132991d);
        out.writeInt(this.f132992e ? 1 : 0);
        out.writeInt(this.f132993f);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(String appId, String str, String str2, boolean z16, int i3) {
        super(appId);
        Intrinsics.checkNotNullParameter(appId, "appId");
        this.f132989b = appId;
        this.f132990c = str;
        this.f132991d = str2;
        this.f132992e = z16;
        this.f132993f = i3;
    }

    @Override // com.tencent.luggage.wxa.a5.a
    public String a() {
        return this.f132990c;
    }

    @Override // com.tencent.luggage.wxa.a5.b
    public void a(com.tencent.luggage.wxa.p5.f runtime) {
        Intrinsics.checkNotNullParameter(runtime, "runtime");
        String str = this.f132991d;
        if ((str != null ? com.tencent.luggage.wxa.z4.c.valueOf(str) : null) == com.tencent.luggage.wxa.z4.c.KILL_PROCESS_DIRECTLY) {
            try {
                SystemMethodProxy.killProcess(Process.myPid());
                return;
            } catch (Throwable th5) {
                w.f("Luggage.task.WxaFinishMessage", "runInLuggageProcess: handled throwable [" + th5 + ']');
                a(runtime, this.f132992e, this.f132993f);
                return;
            }
        }
        a(runtime, this.f132992e, this.f132993f);
    }

    public final void a(com.tencent.luggage.wxa.p5.f fVar, boolean z16, int i3) {
        if (!z16) {
            fVar.b(i3);
            return;
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        fVar.b((Runnable) new c(countDownLatch));
        fVar.b(i3);
        if (countDownLatch.getCount() <= 0) {
            return;
        }
        try {
            countDownLatch.await(5000L, TimeUnit.MILLISECONDS);
        } catch (Exception unused) {
        }
    }

    @Override // com.tencent.luggage.wxa.a5.d
    public void a(com.tencent.luggage.wxa.c5.b runtime) {
        Intrinsics.checkNotNullParameter(runtime, "runtime");
        String str = this.f132991d;
        com.tencent.luggage.wxa.z4.c valueOf = str != null ? com.tencent.luggage.wxa.z4.c.valueOf(str) : null;
        d dVar = new d(runtime);
        if (valueOf == com.tencent.luggage.wxa.z4.c.KILL_PROCESS_DIRECTLY) {
            try {
                SystemMethodProxy.killProcess(Process.myPid());
                return;
            } catch (Throwable th5) {
                w.f("Luggage.task.WxaFinishMessage", "runInLuggageProcess: handled throwable [" + th5 + ']');
                dVar.invoke();
                return;
            }
        }
        dVar.invoke();
    }
}
