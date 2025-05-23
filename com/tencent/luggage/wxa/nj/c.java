package com.tencent.luggage.wxa.nj;

import android.content.DialogInterface;
import com.tencent.luggage.wxa.kj.n;
import com.tencent.luggage.wxa.ml.r;
import com.tencent.luggage.wxa.nj.e;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.mobileqq.R;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class c implements e {

    /* renamed from: a, reason: collision with root package name */
    public static final a f135847a = new a(null);

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
    public static final class b implements DialogInterface.OnClickListener {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Runnable f135849b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.ic.g f135850c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.ml.b f135851d;

        public b(Runnable runnable, com.tencent.luggage.wxa.ic.g gVar, com.tencent.luggage.wxa.ml.b bVar) {
            this.f135849b = runnable;
            this.f135850c = gVar;
            this.f135851d = bVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int i3) {
            c cVar = c.this;
            Runnable runnable = this.f135849b;
            com.tencent.luggage.wxa.ic.g gVar = this.f135850c;
            com.tencent.luggage.wxa.ml.b bVar = this.f135851d;
            if (runnable != null) {
                runnable.run();
            }
            w.d("MicroMsg.BaseAppBrandPageNavigateBackInterceptor", "dialog confirm to navigate back");
            cVar.a(gVar);
            bVar.dismiss();
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.nj.c$c, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class DialogInterfaceOnClickListenerC6517c implements DialogInterface.OnClickListener {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.ic.g f135853b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.ml.b f135854c;

        public DialogInterfaceOnClickListenerC6517c(com.tencent.luggage.wxa.ic.g gVar, com.tencent.luggage.wxa.ml.b bVar) {
            this.f135853b = gVar;
            this.f135854c = bVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int i3) {
            c cVar = c.this;
            com.tencent.luggage.wxa.ic.g gVar = this.f135853b;
            com.tencent.luggage.wxa.ml.b bVar = this.f135854c;
            w.d("MicroMsg.BaseAppBrandPageNavigateBackInterceptor", "keep staying current page");
            cVar.b(gVar);
            bVar.dismiss();
        }
    }

    public void a(com.tencent.luggage.wxa.ic.g runtime) {
        Intrinsics.checkNotNullParameter(runtime, "runtime");
    }

    public abstract boolean a(com.tencent.luggage.wxa.ic.g gVar, String str);

    public void b(com.tencent.luggage.wxa.ic.g runtime) {
        Intrinsics.checkNotNullParameter(runtime, "runtime");
    }

    public void c(com.tencent.luggage.wxa.ic.g runtime) {
        Intrinsics.checkNotNullParameter(runtime, "runtime");
    }

    @Override // com.tencent.luggage.wxa.nj.e
    public boolean a(com.tencent.luggage.wxa.ic.g runtime, String scene, Runnable runnable) {
        Intrinsics.checkNotNullParameter(runtime, "runtime");
        Intrinsics.checkNotNullParameter(scene, "scene");
        n currentPage = runtime.Y().getCurrentPage();
        g a16 = currentPage != null ? currentPage.a(a()) : null;
        if (a16 == null) {
            w.d("MicroMsg.BaseAppBrandPageNavigateBackInterceptor", "navigateBackInterceptionInfo is null");
            return false;
        }
        if (!a16.a(scene)) {
            w.d("MicroMsg.BaseAppBrandPageNavigateBackInterceptor", "scene:[" + scene + "] disable");
            return false;
        }
        if (runtime.Y().getPageCount() <= 1) {
            w.d("MicroMsg.BaseAppBrandPageNavigateBackInterceptor", "leave current wxa, can't intercept");
            return false;
        }
        if (!a(runtime, scene)) {
            w.d("MicroMsg.BaseAppBrandPageNavigateBackInterceptor", "custom intercept return false");
            return false;
        }
        w.d("MicroMsg.BaseAppBrandPageNavigateBackInterceptor", "show navigate back interception dialog");
        com.tencent.luggage.wxa.ml.b bVar = new com.tencent.luggage.wxa.ml.b(runtime.L());
        bVar.setMessage(w0.c(a16.a()) ? "" : a16.a());
        bVar.setCanceledOnTouchOutside(false);
        bVar.setCancelable(false);
        bVar.setPositiveButton(R.string.z3r, new b(runnable, runtime, bVar));
        bVar.setNegativeButton(R.string.z3s, new DialogInterfaceOnClickListenerC6517c(runtime, bVar));
        r N = runtime.N();
        if (N != null) {
            N.a(bVar);
        }
        c(runtime);
        return true;
    }

    @Override // com.tencent.luggage.wxa.nj.e
    public e.a b() {
        return e.a.b.f135858b;
    }

    @Override // com.tencent.luggage.wxa.nj.e
    public i a() {
        return i.WITH_CONFIRM_DIALOG;
    }
}
