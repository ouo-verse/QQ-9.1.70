package com.tencent.luggage.wxa.xj;

import android.os.Looper;
import android.view.View;
import android.view.ViewTreeObserver;
import com.tencent.luggage.wxa.tn.b0;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class b implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a, reason: collision with root package name */
    public final Function0 f145052a;

    /* renamed from: b, reason: collision with root package name */
    public final Runnable f145053b;

    /* renamed from: c, reason: collision with root package name */
    public int f145054c;

    /* renamed from: d, reason: collision with root package name */
    public final Lazy f145055d;

    /* renamed from: e, reason: collision with root package name */
    public final Lazy f145056e;

    /* renamed from: f, reason: collision with root package name */
    public final AtomicBoolean f145057f;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class a extends Lambda implements Function0 {

        /* renamed from: a, reason: collision with root package name */
        public static final a f145058a = new a();

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final b0 invoke() {
            return new b0(Looper.getMainLooper());
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.xj.b$b, reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static final class C6916b extends Lambda implements Function0 {

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.xj.b$b$a */
        /* loaded from: classes9.dex */
        public static final class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f145060a;

            public a(b bVar) {
                this.f145060a = bVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                if (!this.f145060a.f145057f.getAndSet(true)) {
                    this.f145060a.f145053b.run();
                }
            }
        }

        public C6916b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Runnable invoke() {
            return new a(b.this);
        }
    }

    public b(Function0 decorViewProvider, Runnable viewTreeLayoutCompletedCallback) {
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(decorViewProvider, "decorViewProvider");
        Intrinsics.checkNotNullParameter(viewTreeLayoutCompletedCallback, "viewTreeLayoutCompletedCallback");
        this.f145052a = decorViewProvider;
        this.f145053b = viewTreeLayoutCompletedCallback;
        lazy = LazyKt__LazyJVMKt.lazy(new C6916b());
        this.f145055d = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(a.f145058a);
        this.f145056e = lazy2;
        this.f145057f = new AtomicBoolean(false);
    }

    public final Runnable c() {
        return (Runnable) this.f145055d.getValue();
    }

    public final void d() {
        ViewTreeObserver viewTreeObserver;
        View view = (View) this.f145052a.invoke();
        if (view != null) {
            viewTreeObserver = view.getViewTreeObserver();
        } else {
            viewTreeObserver = null;
        }
        if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
            viewTreeObserver.addOnGlobalLayoutListener(this);
            b().a(c(), 100L);
        } else {
            this.f145053b.run();
        }
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        int i3 = this.f145054c + 1;
        this.f145054c = i3;
        if (i3 >= 2 && !this.f145057f.getAndSet(true)) {
            a();
            this.f145053b.run();
        }
    }

    public final void a() {
        ViewTreeObserver viewTreeObserver;
        View view = (View) this.f145052a.invoke();
        if (view != null && (viewTreeObserver = view.getViewTreeObserver()) != null && viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnGlobalLayoutListener(this);
        }
        b().b(c());
    }

    public final b0 b() {
        return (b0) this.f145056e.getValue();
    }
}
