package com.tencent.luggage.wxa.yj;

import android.content.res.Configuration;
import android.util.DisplayMetrics;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.uk.l0;
import com.tencent.luggage.wxa.wj.c;
import com.tencent.luggage.wxa.wj.e;
import com.tencent.luggage.wxa.xj.d;
import com.tencent.luggage.wxa.zp.h;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class a implements d {

    /* renamed from: b, reason: collision with root package name */
    public static final C6959a f145979b = new C6959a(null);

    /* renamed from: c, reason: collision with root package name */
    public static final e.b[] f145980c = e.b.f144275h;

    /* renamed from: a, reason: collision with root package name */
    public final c f145981a;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.yj.a$a, reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static final class C6959a {
        public C6959a() {
        }

        public /* synthetic */ C6959a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e.b f145982a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a f145983b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ e.a f145984c;

        public b(e.b bVar, a aVar, e.a aVar2) {
            this.f145982a = bVar;
            this.f145983b = aVar;
            this.f145984c = aVar2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            boolean contains;
            boolean contains2;
            e.b bVar = this.f145982a;
            boolean z16 = false;
            if (bVar != e.b.PORTRAIT) {
                e.b[] LANDSCAPE_ENUMS = a.f145980c;
                Intrinsics.checkNotNullExpressionValue(LANDSCAPE_ENUMS, "LANDSCAPE_ENUMS");
                contains = ArraysKt___ArraysKt.contains(LANDSCAPE_ENUMS, bVar);
                if (contains) {
                    this.f145983b.f145981a.setSoftOrientation("landscape");
                    e.a aVar = this.f145984c;
                    if (aVar != null) {
                        e.b a16 = this.f145983b.a();
                        e.b[] LANDSCAPE_ENUMS2 = a.f145980c;
                        Intrinsics.checkNotNullExpressionValue(LANDSCAPE_ENUMS2, "LANDSCAPE_ENUMS");
                        contains2 = ArraysKt___ArraysKt.contains(LANDSCAPE_ENUMS2, this.f145983b.a());
                        aVar.a(a16, contains2);
                        return;
                    }
                    return;
                }
                if (bVar == e.b.UNSPECIFIED) {
                    this.f145983b.f145981a.setSoftOrientation("auto");
                    e.a aVar2 = this.f145984c;
                    if (aVar2 != null) {
                        aVar2.a(this.f145983b.a(), true);
                        return;
                    }
                    return;
                }
                this.f145983b.f145981a.setSoftOrientation("portrait");
                e.a aVar3 = this.f145984c;
                if (aVar3 != null) {
                    e.b a17 = this.f145983b.a();
                    if (this.f145983b.a() == this.f145982a) {
                        z16 = true;
                    }
                    aVar3.a(a17, z16);
                    return;
                }
                return;
            }
            this.f145983b.f145981a.setSoftOrientation("portrait");
            e.a aVar4 = this.f145984c;
            if (aVar4 != null) {
                e.b a18 = this.f145983b.a();
                if (this.f145983b.a() == this.f145982a) {
                    z16 = true;
                }
                aVar4.a(a18, z16);
            }
        }
    }

    public a(c window) {
        Intrinsics.checkNotNullParameter(window, "window");
        this.f145981a = window;
    }

    public final void a(Runnable runnable) {
        if (l0.a()) {
            runnable.run();
        } else {
            h.f146825d.a(runnable);
        }
    }

    @Override // com.tencent.luggage.wxa.wj.e
    public void a(e.b bVar, e.a aVar) {
        if (bVar == null) {
            if (aVar != null) {
                aVar.a(null, false);
                return;
            }
            return;
        }
        w.d("MicroMsg.CenterInsideWindowOrientationHandler", "requestDeviceOrientation: " + bVar.f144277a + ',' + bVar.name());
        a(new b(bVar, this, aVar));
    }

    @Override // com.tencent.luggage.wxa.wj.e
    public e.b a() {
        DisplayMetrics vDisplayMetrics = this.f145981a.getVDisplayMetrics();
        if (vDisplayMetrics.heightPixels >= vDisplayMetrics.widthPixels) {
            w.d("MicroMsg.CenterInsideWindowOrientationHandler", "getCurrentOrientation: portrait");
            return e.b.PORTRAIT;
        }
        w.d("MicroMsg.CenterInsideWindowOrientationHandler", "getCurrentOrientation: landscape");
        return e.b.LANDSCAPE_SENSOR;
    }

    @Override // com.tencent.luggage.wxa.xj.d
    public void onConfigurationChanged(Configuration configuration) {
    }

    @Override // com.tencent.luggage.wxa.xj.d
    public void onPause() {
    }

    @Override // com.tencent.luggage.wxa.xj.d
    public void onResume() {
    }

    @Override // com.tencent.luggage.wxa.xj.d
    public void release() {
    }
}
