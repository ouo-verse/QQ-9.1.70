package com.tencent.luggage.wxa.xj;

import android.app.Activity;
import android.content.Context;
import android.provider.Settings;
import android.util.SparseArray;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.uk.h0;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class i {

    /* renamed from: h, reason: collision with root package name */
    public static final a f145116h = new a(null);

    /* renamed from: i, reason: collision with root package name */
    public static final SparseArray f145117i = new SparseArray();

    /* renamed from: j, reason: collision with root package name */
    public static final AtomicBoolean f145118j = new AtomicBoolean(false);

    /* renamed from: a, reason: collision with root package name */
    public final String f145119a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f145120b;

    /* renamed from: c, reason: collision with root package name */
    public h0.a f145121c;

    /* renamed from: d, reason: collision with root package name */
    public h0.a f145122d;

    /* renamed from: e, reason: collision with root package name */
    public final Object f145123e;

    /* renamed from: f, reason: collision with root package name */
    public h0 f145124f;

    /* renamed from: g, reason: collision with root package name */
    public final List f145125g;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class a {

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.xj.i$a$a, reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public static final class C6918a extends com.tencent.luggage.wxa.tk.a {
            @Override // com.tencent.luggage.wxa.tk.a, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                super.onActivityDestroyed(activity);
                int hashCode = activity.hashCode();
                synchronized (i.f145117i) {
                    i.f145117i.remove(hashCode);
                    Unit unit = Unit.INSTANCE;
                }
            }
        }

        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final i a(Activity activity) {
            i iVar;
            Intrinsics.checkNotNullParameter(activity, "activity");
            if (!i.f145118j.getAndSet(true)) {
                activity.getApplication().registerActivityLifecycleCallbacks(new C6918a());
            }
            int hashCode = activity.hashCode();
            synchronized (i.f145117i) {
                iVar = (i) i.f145117i.get(hashCode);
                if (iVar == null) {
                    iVar = new i(activity);
                    i.f145117i.put(hashCode, iVar);
                }
            }
            return iVar;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class b implements h0.b {
        public b() {
        }

        @Override // com.tencent.luggage.wxa.uk.h0.b
        public final void onFourOrientationsChange(h0.a aVar, h0.a newOrientation) {
            boolean d16 = i.this.d();
            w.a(i.this.f145119a, "onFourOrientationsChange, newOrientation: " + newOrientation + ", isSystemOrientationLocked: " + d16);
            if (!d16 && i.this.f145121c != newOrientation) {
                for (j jVar : i.this.f145125g) {
                    Intrinsics.checkNotNullExpressionValue(newOrientation, "newOrientation");
                    jVar.a(newOrientation);
                }
                i iVar = i.this;
                Intrinsics.checkNotNullExpressionValue(newOrientation, "newOrientation");
                iVar.f145121c = newOrientation;
            }
            i iVar2 = i.this;
            Intrinsics.checkNotNullExpressionValue(newOrientation, "newOrientation");
            iVar2.f145122d = newOrientation;
        }
    }

    public i(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.f145119a = "MicroMsg.AppBrand.AppBrandOrientationObservable#" + hashCode();
        this.f145120b = activity.getApplicationContext();
        h0.a aVar = h0.a.NONE;
        this.f145121c = aVar;
        this.f145122d = aVar;
        this.f145123e = new Object();
        this.f145125g = new CopyOnWriteArrayList();
    }

    public static final i a(Activity activity) {
        return f145116h.a(activity);
    }

    public final h0 e() {
        if (this.f145124f == null) {
            this.f145124f = new h0(this.f145120b, new b());
        }
        h0 h0Var = this.f145124f;
        Intrinsics.checkNotNull(h0Var);
        return h0Var;
    }

    public final h0 c() {
        return this.f145124f;
    }

    public final boolean d() {
        return Settings.System.getInt(this.f145120b.getContentResolver(), "accelerometer_rotation", 0) == 0;
    }

    public final void b(j orientationObserver) {
        Intrinsics.checkNotNullParameter(orientationObserver, "orientationObserver");
        w.a(this.f145119a, "removeOrientationObserver");
        this.f145125g.remove(orientationObserver);
    }

    public final void a(j orientationObserver) {
        Intrinsics.checkNotNullParameter(orientationObserver, "orientationObserver");
        w.a(this.f145119a, "addOrientationObserver");
        a(true);
        this.f145125g.add(orientationObserver);
    }

    public final void a(boolean z16) {
        synchronized (this.f145123e) {
            h0 e16 = z16 ? e() : c();
            if (e16 != null) {
                e16.enable();
                Unit unit = Unit.INSTANCE;
            }
        }
    }
}
