package com.tencent.luggage.wxa.wj;

import com.tencent.luggage.wxa.ic.v;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.uk.g0;
import com.tencent.luggage.wxa.uk.t;
import com.tencent.luggage.wxa.wj.e;
import com.tencent.luggage.wxa.xd.i;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class g implements t {

    /* renamed from: b, reason: collision with root package name */
    public static final a f144278b = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final e f144279a;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements t.a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // com.tencent.luggage.wxa.uk.t.a
        public t a(com.tencent.luggage.wxa.xd.f fVar) {
            v e06;
            c h16;
            e orientationHandler;
            if (fVar instanceof i) {
                com.tencent.luggage.wxa.ic.g runtime = ((i) fVar).getRuntime();
                if (runtime != null && (e06 = runtime.e0()) != null && (h16 = e06.h()) != null && (orientationHandler = h16.getOrientationHandler()) != null) {
                    return new g(orientationHandler);
                }
                com.tencent.luggage.wxa.uk.e a16 = com.tencent.luggage.wxa.uk.e.f142670b.a(fVar);
                w.f("MicroMsg.AppBrand.WxaOrientationGetter", "create, something null, use AndroidOrientationGetter as fallback");
                return a16;
            }
            w.f("MicroMsg.AppBrand.WxaOrientationGetter", "create, componentView is not AppBrandComponentWithExtra, use AndroidOrientationGetter as fallback");
            return com.tencent.luggage.wxa.uk.e.f142670b.a(fVar);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f144280a;

        static {
            int[] iArr = new int[e.b.values().length];
            iArr[e.b.PORTRAIT.ordinal()] = 1;
            iArr[e.b.LANDSCAPE_SENSOR.ordinal()] = 2;
            iArr[e.b.LANDSCAPE_LOCKED.ordinal()] = 3;
            iArr[e.b.LANDSCAPE_LEFT.ordinal()] = 4;
            iArr[e.b.LANDSCAPE_RIGHT.ordinal()] = 5;
            iArr[e.b.UNSPECIFIED.ordinal()] = 6;
            f144280a = iArr;
        }
    }

    public g(e orientationHandler) {
        Intrinsics.checkNotNullParameter(orientationHandler, "orientationHandler");
        this.f144279a = orientationHandler;
    }

    @Override // com.tencent.luggage.wxa.uk.t
    public g0 a() {
        e.b a16 = this.f144279a.a();
        Intrinsics.checkNotNullExpressionValue(a16, "orientationHandler.currentOrientation");
        return a(a16);
    }

    @Override // com.tencent.luggage.wxa.uk.t
    public String getName() {
        return "WxaOrientationGetter";
    }

    public final g0 a(e.b bVar) {
        switch (b.f144280a[bVar.ordinal()]) {
            case 1:
                return g0.PORTRAIT;
            case 2:
            case 3:
            case 4:
            case 5:
                return g0.LANDSCAPE;
            case 6:
                return g0.UNSPECIFIED;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
