package com.tencent.luggage.wxa.nj;

import com.tencent.luggage.wxa.kj.n;
import com.tencent.luggage.wxa.nj.e;
import com.tencent.luggage.wxa.tn.w;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class d implements e {

    /* renamed from: a, reason: collision with root package name */
    public static final a f135855a = new a(null);

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public void a(com.tencent.luggage.wxa.ic.g runtime, String scene) {
        Intrinsics.checkNotNullParameter(runtime, "runtime");
        Intrinsics.checkNotNullParameter(scene, "scene");
    }

    @Override // com.tencent.luggage.wxa.nj.e
    public e.a b() {
        return e.a.C6518a.f135857b;
    }

    @Override // com.tencent.luggage.wxa.nj.e
    public boolean a(com.tencent.luggage.wxa.ic.g runtime, String scene, Runnable runnable) {
        Intrinsics.checkNotNullParameter(runtime, "runtime");
        Intrinsics.checkNotNullParameter(scene, "scene");
        n currentPage = runtime.Y().getCurrentPage();
        g a16 = currentPage != null ? currentPage.a(a()) : null;
        if (a16 == null) {
            w.d("MicroMsg.AppBrandPageNavigateBackSilentInterceptor", "navigateBackInterceptionInfo is null");
            return false;
        }
        if (!a16.a(scene)) {
            return false;
        }
        w.d("MicroMsg.AppBrandPageNavigateBackSilentInterceptor", "scene:[" + scene + "] intercept!!");
        a(runtime, scene);
        return true;
    }

    @Override // com.tencent.luggage.wxa.nj.e
    public i a() {
        return i.SILENT;
    }
}
