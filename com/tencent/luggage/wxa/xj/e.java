package com.tencent.luggage.wxa.xj;

import android.app.Activity;
import android.app.PictureInPictureParams;
import android.content.res.Configuration;
import android.os.Build;
import android.util.Rational;
import android.view.Display;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.uk.o;
import com.tencent.luggage.wxa.wj.e;
import com.tencent.mm.plugin.appbrand.platform.window.activity.WindowAndroidActivityImpl;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class e implements com.tencent.luggage.wxa.xj.d {

    /* renamed from: d, reason: collision with root package name */
    public static final a f145068d = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final WindowAndroidActivityImpl f145069a;

    /* renamed from: b, reason: collision with root package name */
    public final Lazy f145070b;

    /* renamed from: c, reason: collision with root package name */
    public final Activity f145071c;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f145072a;

        static {
            int[] iArr = new int[e.b.values().length];
            iArr[e.b.PORTRAIT.ordinal()] = 1;
            f145072a = iArr;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class c extends Lambda implements Function0 {
        public c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final com.tencent.luggage.wxa.xj.d invoke() {
            if (e.this.b() != null) {
                return g.a(e.this.b());
            }
            return (com.tencent.luggage.wxa.xj.d) o.a("Luggage.WXA.ActivityWindowOrientationHandlerProxyImpl.Dummy", com.tencent.luggage.wxa.xj.d.class);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class d implements e.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AtomicBoolean f145074a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f145075b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ e.a f145076c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ e f145077d;

        /* compiled from: P */
        /* loaded from: classes9.dex */
        public static final class a extends Lambda implements Function0 {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ c f145078a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(c cVar) {
                super(0);
                this.f145078a = cVar;
            }

            public final void a() {
                this.f145078a.a("globalLayout x2");
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                a();
                return Unit.INSTANCE;
            }
        }

        /* compiled from: P */
        /* loaded from: classes9.dex */
        public static final class b implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ c f145079a;

            public b(c cVar) {
                this.f145079a = cVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f145079a.a("timeout");
            }
        }

        /* compiled from: P */
        /* loaded from: classes9.dex */
        public static final class c implements Function1 {

            /* renamed from: a, reason: collision with root package name */
            public final AtomicBoolean f145080a = new AtomicBoolean(true);

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ e.b f145081b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ boolean f145082c;

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ e.a f145083d;

            /* renamed from: e, reason: collision with root package name */
            public final /* synthetic */ e f145084e;

            public c(e.b bVar, boolean z16, e.a aVar, e eVar) {
                this.f145081b = bVar;
                this.f145082c = z16;
                this.f145083d = aVar;
                this.f145084e = eVar;
            }

            public void a(String reason) {
                String str;
                Intrinsics.checkNotNullParameter(reason, "reason");
                if (this.f145080a.getAndSet(false)) {
                    w.d("Luggage.WXA.ActivityWindowOrientationHandlerProxyImpl", "requestDeviceOrientation, will invoke outer listener reason:[" + reason + "], orientation:" + this.f145081b + " success:" + this.f145082c);
                    e.a aVar = this.f145083d;
                    if (aVar != null) {
                        aVar.a(this.f145081b, this.f145082c);
                    }
                    WindowAndroidActivityImpl windowAndroidActivityImpl = this.f145084e.f145069a;
                    e.b bVar = this.f145081b;
                    if (bVar != null) {
                        str = bVar.name();
                    } else {
                        str = null;
                    }
                    windowAndroidActivityImpl.setSoftOrientation(str);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((String) obj);
                return Unit.INSTANCE;
            }
        }

        public d(AtomicBoolean atomicBoolean, View view, e.a aVar, e eVar) {
            this.f145074a = atomicBoolean;
            this.f145075b = view;
            this.f145076c = aVar;
            this.f145077d = eVar;
        }

        @Override // com.tencent.luggage.wxa.wj.e.a
        public final void a(e.b bVar, boolean z16) {
            w.d("Luggage.WXA.ActivityWindowOrientationHandlerProxyImpl", "requestDeviceOrientation, callback from AppBrandDeviceOrientationHandler, orientation:" + bVar + ", success:" + z16);
            c cVar = new c(bVar, z16, this.f145076c, this.f145077d);
            if (z16 && !this.f145074a.get()) {
                f.b(this.f145075b, 2, new a(cVar));
                this.f145075b.postDelayed(new b(cVar), 100L);
            } else {
                cVar.a("syncReturn");
            }
        }
    }

    public e(WindowAndroidActivityImpl windowActivity) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(windowActivity, "windowActivity");
        this.f145069a = windowActivity;
        lazy = LazyKt__LazyJVMKt.lazy(new c());
        this.f145070b = lazy;
        this.f145071c = windowActivity.j();
    }

    public final Activity b() {
        return this.f145071c;
    }

    public final com.tencent.luggage.wxa.xj.d c() {
        Object value = this.f145070b.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-handler>(...)");
        return (com.tencent.luggage.wxa.xj.d) value;
    }

    @Override // com.tencent.luggage.wxa.xj.d
    public void onConfigurationChanged(Configuration configuration) {
        c().onConfigurationChanged(configuration);
    }

    @Override // com.tencent.luggage.wxa.xj.d
    public void onPause() {
        c().onPause();
    }

    @Override // com.tencent.luggage.wxa.xj.d
    public void onResume() {
        c().onResume();
    }

    @Override // com.tencent.luggage.wxa.xj.d
    public void release() {
        Activity activity = this.f145071c;
        if (activity == null || activity.isDestroyed() || this.f145071c.isFinishing()) {
            c().release();
        }
        if (Intrinsics.areEqual(this.f145069a.f152255c, this)) {
            this.f145069a.f152255c = null;
        }
    }

    @Override // com.tencent.luggage.wxa.wj.e
    public void a(e.b bVar, e.a aVar) {
        boolean isInPictureInPictureMode;
        PictureInPictureParams.Builder aspectRatio;
        PictureInPictureParams build;
        PictureInPictureParams.Builder aspectRatio2;
        PictureInPictureParams build2;
        Activity activity = this.f145071c;
        if (activity == null) {
            if (aVar != null) {
                aVar.a(a(), false);
                return;
            }
            return;
        }
        if (!activity.isFinishing() && !this.f145071c.isDestroyed()) {
            if (Build.VERSION.SDK_INT >= 26) {
                isInPictureInPictureMode = this.f145071c.isInPictureInPictureMode();
                if (isInPictureInPictureMode) {
                    this.f145069a.setSoftOrientation(bVar != null ? bVar.name() : null);
                    int i3 = bVar == null ? -1 : b.f145072a[bVar.ordinal()];
                    if (i3 == -1) {
                        if (aVar != null) {
                            aVar.a(c().a(), false);
                            Unit unit = Unit.INSTANCE;
                            return;
                        }
                        return;
                    }
                    if (i3 != 1) {
                        Activity activity2 = this.f145071c;
                        aspectRatio2 = new PictureInPictureParams.Builder().setAspectRatio(new Rational(16, 9));
                        build2 = aspectRatio2.build();
                        activity2.enterPictureInPictureMode(build2);
                        if (aVar != null) {
                            aVar.a(bVar, true);
                            Unit unit2 = Unit.INSTANCE;
                            return;
                        }
                        return;
                    }
                    Activity activity3 = this.f145071c;
                    aspectRatio = new PictureInPictureParams.Builder().setAspectRatio(new Rational(9, 16));
                    build = aspectRatio.build();
                    activity3.enterPictureInPictureMode(build);
                    if (aVar != null) {
                        aVar.a(bVar, true);
                        Unit unit3 = Unit.INSTANCE;
                        return;
                    }
                    return;
                }
            }
            Window window = this.f145071c.getWindow();
            View decorView = window != null ? window.getDecorView() : null;
            if (decorView != null) {
                ViewTreeObserver viewTreeObserver = decorView.getViewTreeObserver();
                if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                    AtomicBoolean atomicBoolean = new AtomicBoolean(true);
                    this.f145069a.setSoftOrientation(bVar != null ? bVar.name() : null);
                    c().a(bVar, new d(atomicBoolean, decorView, aVar, this));
                    atomicBoolean.set(false);
                    return;
                }
            }
            c().a(bVar, aVar);
            return;
        }
        w.b("Luggage.WXA.ActivityWindowOrientationHandlerProxyImpl", "requestDeviceOrientation but activity(" + this.f145071c + ") destroyed");
        if (aVar != null) {
            aVar.a(c().a(), false);
        }
    }

    @Override // com.tencent.luggage.wxa.wj.e
    public e.b a() {
        Display defaultDisplay;
        if (this.f145071c != null) {
            return c().a();
        }
        WindowManager l3 = this.f145069a.l();
        Integer valueOf = (l3 == null || (defaultDisplay = l3.getDefaultDisplay()) == null) ? null : Integer.valueOf(defaultDisplay.getRotation());
        if ((valueOf != null && valueOf.intValue() == 0) || (valueOf != null && valueOf.intValue() == 2)) {
            return e.b.PORTRAIT;
        }
        if (valueOf != null && valueOf.intValue() == 1) {
            return e.b.LANDSCAPE_LEFT;
        }
        if (valueOf != null && valueOf.intValue() == 3) {
            return e.b.LANDSCAPE_RIGHT;
        }
        return null;
    }
}
