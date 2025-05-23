package com.tencent.luggage.wxa.uk;

import android.app.Activity;
import android.view.Window;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.luggage.wxa.ic.e;
import java.util.Comparator;
import java.util.Iterator;
import java.util.concurrent.ConcurrentSkipListSet;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class j0 {

    /* renamed from: e, reason: collision with root package name */
    public static final c f142737e = new c(null);

    /* renamed from: a, reason: collision with root package name */
    public final com.tencent.luggage.wxa.ic.g f142738a;

    /* renamed from: b, reason: collision with root package name */
    public final String f142739b;

    /* renamed from: c, reason: collision with root package name */
    public volatile boolean f142740c;

    /* renamed from: d, reason: collision with root package name */
    public final ConcurrentSkipListSet f142741d;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements com.tencent.luggage.wxa.ic.d0 {

        /* renamed from: a, reason: collision with root package name */
        public boolean f142742a;

        public a() {
            com.tencent.luggage.wxa.ic.v e06 = j0.this.f142738a.e0();
            if (e06 != null) {
                a(e06);
            }
        }

        @Override // com.tencent.luggage.wxa.ic.d0
        public void a() {
        }

        @Override // com.tencent.luggage.wxa.ic.d0
        public void a(com.tencent.luggage.wxa.ic.v container) {
            Intrinsics.checkNotNullParameter(container, "container");
            if (this.f142742a) {
                return;
            }
            com.tencent.luggage.wxa.tn.w.d(j0.this.f142739b, "onAttachedToRuntimeContainer, first blood");
            j0.this.e();
            this.f142742a = true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b extends e.c {
        public b() {
        }

        @Override // com.tencent.luggage.wxa.ic.e.c
        public void onDestroy() {
            super.onDestroy();
            com.tencent.luggage.wxa.tn.w.d(j0.this.f142739b, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
            j0.this.e();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c {
        public c() {
        }

        public /* synthetic */ c(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final j0 a(com.tencent.luggage.wxa.ic.d component) {
            Intrinsics.checkNotNullParameter(component, "component");
            com.tencent.luggage.wxa.ic.g runtime = component.getRuntime();
            if (runtime == null) {
                com.tencent.luggage.wxa.tn.w.f("MicroMsg.AppBrand.SafeScreenShotRecordSwitcher", "get, runtime is null");
                return null;
            }
            return runtime.g0();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class d implements Comparator {

        /* renamed from: a, reason: collision with root package name */
        public static final d f142745a = new d();

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final int compare(Function1 function1, Function1 function12) {
            return function1.hashCode() - function12.hashCode();
        }
    }

    public j0(com.tencent.luggage.wxa.ic.g runtime) {
        Intrinsics.checkNotNullParameter(runtime, "runtime");
        this.f142738a = runtime;
        String str = "MicroMsg.AppBrand.SafeScreenShotRecordSwitcher#" + hashCode();
        this.f142739b = str;
        this.f142741d = new ConcurrentSkipListSet(d.f142745a);
        String appId = runtime.getAppId();
        com.tencent.luggage.wxa.tn.w.d(str, "<init>, appId: " + appId);
        runtime.a((com.tencent.luggage.wxa.ic.d0) new a());
        com.tencent.luggage.wxa.ic.e.a(appId, new b());
    }

    public static final j0 a(com.tencent.luggage.wxa.ic.d dVar) {
        return f142737e.a(dVar);
    }

    public final boolean d() {
        Window window;
        Activity L = this.f142738a.L();
        if (L != null) {
            window = L.getWindow();
        } else {
            window = null;
        }
        com.tencent.luggage.wxa.tn.w.d(this.f142739b, "enableSafeScreenShotRecordInner, window: " + window);
        if (window != null) {
            window.addFlags(8192);
            return true;
        }
        return false;
    }

    public final void e() {
        b();
    }

    public final void b(boolean z16) {
        com.tencent.luggage.wxa.tn.w.d(this.f142739b, "runtimeSwitch.set " + this.f142740c + " -> " + z16);
        this.f142740c = z16;
        Iterator it = this.f142741d.iterator();
        while (it.hasNext()) {
            ((Function1) it.next()).invoke(Boolean.valueOf(this.f142740c));
        }
    }

    public final boolean c() {
        if (!d()) {
            return false;
        }
        b(true);
        return true;
    }

    public final boolean a() {
        if (!b()) {
            return false;
        }
        b(false);
        return true;
    }

    public final void a(boolean z16) {
        boolean z17 = this.f142740c;
        com.tencent.luggage.wxa.tn.w.d(this.f142739b, "setHiddenInBackgroundSwitch, runtimeSwitch: " + z17 + ", pageSwitch: " + z16);
        if (z17) {
            d();
        } else if (z16) {
            d();
        } else {
            b();
        }
    }

    public final boolean b() {
        Activity L = this.f142738a.L();
        Window window = L != null ? L.getWindow() : null;
        com.tencent.luggage.wxa.tn.w.d(this.f142739b, "disableSafeScreenShotRecordInner, window: " + window);
        if (window == null) {
            return false;
        }
        window.clearFlags(8192);
        return true;
    }
}
