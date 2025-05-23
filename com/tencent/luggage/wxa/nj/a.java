package com.tencent.luggage.wxa.nj;

import com.tencent.luggage.wxa.kj.n;
import com.tencent.luggage.wxa.tn.w;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class a extends c {

    /* renamed from: b, reason: collision with root package name */
    public static final C6516a f135846b = new C6516a(null);

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.nj.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6516a {
        public C6516a() {
        }

        public /* synthetic */ C6516a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.tencent.luggage.wxa.nj.c
    public void b(com.tencent.luggage.wxa.c5.e runtime) {
        Intrinsics.checkNotNullParameter(runtime, "runtime");
        super.b((com.tencent.luggage.wxa.ic.g) runtime);
        a(runtime, 3);
    }

    @Override // com.tencent.luggage.wxa.nj.c
    public void c(com.tencent.luggage.wxa.c5.e runtime) {
        Intrinsics.checkNotNullParameter(runtime, "runtime");
        super.c((com.tencent.luggage.wxa.ic.g) runtime);
        a(runtime, 1);
    }

    @Override // com.tencent.luggage.wxa.nj.c
    public boolean a(com.tencent.luggage.wxa.c5.e runtime, String scene) {
        Intrinsics.checkNotNullParameter(runtime, "runtime");
        Intrinsics.checkNotNullParameter(scene, "scene");
        if (runtime.S().I != 7) {
            return true;
        }
        w.d("MicroMsg.AppBrandPageNavigateBackInterceptorWC", "fake native wxa, can't intercept");
        return false;
    }

    @Override // com.tencent.luggage.wxa.nj.c
    public void a(com.tencent.luggage.wxa.c5.e runtime) {
        Intrinsics.checkNotNullParameter(runtime, "runtime");
        super.a((com.tencent.luggage.wxa.ic.g) runtime);
        a(runtime, 2);
    }

    public final void a(com.tencent.luggage.wxa.c5.e eVar, int i3) {
        g a16;
        com.tencent.luggage.wxa.zj.d dVar;
        n currentPage = eVar.Y().getCurrentPage();
        if (currentPage == null || (a16 = currentPage.a(a())) == null || (dVar = (com.tencent.luggage.wxa.zj.d) com.tencent.luggage.wxa.h1.e.c(com.tencent.luggage.wxa.zj.d.class)) == null) {
            return;
        }
        Object[] objArr = new Object[5];
        objArr[0] = eVar.getAppId();
        objArr[1] = Long.valueOf(System.currentTimeMillis());
        n currentPage2 = eVar.Y().getCurrentPage();
        String currentUrl = currentPage2 != null ? currentPage2.getCurrentUrl() : null;
        if (currentUrl == null) {
            currentUrl = "";
        } else {
            Intrinsics.checkNotNullExpressionValue(currentUrl, "runtime.pageContainer.cu\u2026entPage?.currentUrl ?: \"\"");
        }
        objArr[2] = currentUrl;
        objArr[3] = Integer.valueOf(i3);
        objArr[4] = i3 == 1 ? a16.a() : "";
        dVar.a(19169, objArr);
    }
}
