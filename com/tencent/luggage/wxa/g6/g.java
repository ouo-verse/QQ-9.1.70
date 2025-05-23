package com.tencent.luggage.wxa.g6;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import com.tencent.luggage.util.LuggageActivityHelper;
import com.tencent.mm.ui.widget.dialog.WeUIProgresssDialog;
import com.tencent.mobileqq.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.SetsKt___SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joor.Reflect;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class g extends FrameLayout implements v, p, LifecycleOwner {

    /* renamed from: a, reason: collision with root package name */
    public final LifecycleRegistry f126497a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f126498b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f126499c;

    /* renamed from: d, reason: collision with root package name */
    public final com.tencent.luggage.wxa.ml.g f126500d;

    /* renamed from: e, reason: collision with root package name */
    public final Set f126501e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f126502f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f126503g;

    /* renamed from: h, reason: collision with root package name */
    public final int f126504h;

    /* renamed from: i, reason: collision with root package name */
    public final int f126505i;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a extends com.tencent.luggage.wxa.ml.b {

        /* renamed from: g0, reason: collision with root package name */
        public final /* synthetic */ g f126506g0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Context context, g gVar) {
            super(context);
            this.f126506g0 = gVar;
        }

        @Override // com.tencent.luggage.wxa.ml.b, com.tencent.mm.ui.widget.dialog.MMAlertDialog, android.app.Dialog
        public void show() {
            this.f126506g0.f126500d.a(this);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b implements l {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef f126507a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ g f126508b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef f126509c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef f126510d;

        public b(Ref.ObjectRef objectRef, g gVar, Ref.ObjectRef objectRef2, Ref.ObjectRef objectRef3) {
            this.f126507a = objectRef;
            this.f126508b = gVar;
            this.f126509c = objectRef2;
            this.f126510d = objectRef3;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.luggage.wxa.g6.l
        public void dismiss() {
            Object lastOrNull;
            View view;
            com.tencent.luggage.wxa.ml.g gVar = this.f126508b.f126500d;
            T t16 = this.f126510d.element;
            Intrinsics.checkNotNull(t16);
            gVar.b((com.tencent.luggage.wxa.ml.m) t16);
            T t17 = this.f126507a.element;
            lastOrNull = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) this.f126508b.f126498b);
            if (Intrinsics.areEqual(t17, lastOrNull) && (view = (View) this.f126509c.element) != null) {
                view.requestFocus();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v2, types: [T, java.lang.Object] */
        @Override // com.tencent.luggage.wxa.g6.l
        public void show() {
            ?? lastOrNull;
            T t16;
            Window window;
            Ref.ObjectRef objectRef = this.f126507a;
            lastOrNull = CollectionsKt___CollectionsKt.lastOrNull((List<? extends ??>) this.f126508b.f126498b);
            objectRef.element = lastOrNull;
            Ref.ObjectRef objectRef2 = this.f126509c;
            u uVar = (u) this.f126507a.element;
            if (uVar != null && (window = uVar.getWindow()) != null) {
                t16 = window.getCurrentFocus();
            } else {
                t16 = 0;
            }
            objectRef2.element = t16;
            com.tencent.luggage.wxa.ml.g gVar = this.f126508b.f126500d;
            T t17 = this.f126510d.element;
            Intrinsics.checkNotNull(t17);
            gVar.a((com.tencent.luggage.wxa.ml.m) t17);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c extends com.tencent.luggage.wxa.ml.i {
        public final /* synthetic */ g C;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Context context, g gVar) {
            super(context);
            this.C = gVar;
        }

        @Override // com.tencent.luggage.wxa.ml.i, com.tencent.mm.ui.widget.dialog.WeUIProgresssDialog, android.app.Dialog
        public void show() {
            this.C.f126500d.a(this);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ u f126511a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ g f126512b;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ u f126513a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ g f126514b;

            public a(u uVar, g gVar) {
                this.f126513a = uVar;
                this.f126514b = gVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f126513a.onStop();
                this.f126514b.removeView(this.f126513a.getWindow().getDecorView());
                this.f126513a.onDestroy();
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class b implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ g f126515a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ u f126516b;

            public b(g gVar, u uVar) {
                this.f126515a = gVar;
                this.f126516b = uVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                if (this.f126515a.f126497a.getCurrentState().isAtLeast(Lifecycle.State.RESUMED)) {
                    this.f126516b.onResume();
                }
            }
        }

        public d(u uVar, g gVar) {
            this.f126511a = uVar;
            this.f126512b = gVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Object lastOrNull;
            r rVar;
            if (this.f126511a.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.CREATED) && this.f126512b.f126498b.remove(this.f126511a)) {
                lastOrNull = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) this.f126512b.f126498b);
                u uVar = (u) lastOrNull;
                if (this.f126511a.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.RESUMED)) {
                    this.f126511a.onPause();
                }
                boolean z16 = this.f126512b.f126502f;
                boolean z17 = this.f126512b.f126503g;
                this.f126512b.f126502f = true;
                this.f126512b.f126503g = true;
                Lifecycle.State currentState = this.f126511a.getLifecycle().getCurrentState();
                Lifecycle.State state = Lifecycle.State.STARTED;
                if (currentState.isAtLeast(state) && uVar != null) {
                    g gVar = this.f126512b;
                    u uVar2 = this.f126511a;
                    gVar.b(uVar2, z17, new a(uVar2, gVar));
                } else {
                    this.f126512b.removeView(this.f126511a.getWindow().getDecorView());
                    this.f126511a.onDestroy();
                }
                g gVar2 = this.f126512b;
                r page = this.f126511a.getPage();
                Intrinsics.checkNotNullExpressionValue(page, "page.page");
                if (uVar != null) {
                    rVar = uVar.getPage();
                } else {
                    rVar = null;
                }
                gVar2.a(page, rVar);
                if (uVar != null) {
                    if (this.f126512b.f126497a.getCurrentState().isAtLeast(state)) {
                        uVar.onStart();
                    }
                    g gVar3 = this.f126512b;
                    gVar3.a(uVar, z16, new b(gVar3, uVar));
                }
                if (uVar == null) {
                    this.f126512b.r();
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class e implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Class f126518b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ LuggageActivityHelper.d f126519c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Intent f126520d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Context f126521e;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a extends Lambda implements Function0 {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ g f126522a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Ref.ObjectRef f126523b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(g gVar, Ref.ObjectRef objectRef) {
                super(0);
                this.f126522a = gVar;
                this.f126523b = objectRef;
            }

            public final void a() {
                this.f126522a.addView(((u) this.f126523b.element).getWindow().getDecorView(), new FrameLayout.LayoutParams(-1, -1));
                g gVar = this.f126522a;
                gVar.bringChildToFront(gVar.f126500d);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                a();
                return Unit.INSTANCE;
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class b implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ g f126524a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Ref.ObjectRef f126525b;

            public b(g gVar, Ref.ObjectRef objectRef) {
                this.f126524a = gVar;
                this.f126525b = objectRef;
            }

            @Override // java.lang.Runnable
            public final void run() {
                if (this.f126524a.f126497a.getCurrentState().isAtLeast(Lifecycle.State.RESUMED)) {
                    ((u) this.f126525b.element).onResume();
                }
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class c implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ g f126526a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ u f126527b;

            public c(g gVar, u uVar) {
                this.f126526a = gVar;
                this.f126527b = uVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                if (this.f126526a.f126497a.getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
                    this.f126527b.onStop();
                }
            }
        }

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class d extends Lambda implements Function0 {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Ref.BooleanRef f126528a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ u f126529b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public d(Ref.BooleanRef booleanRef, u uVar) {
                super(0);
                this.f126528a = booleanRef;
                this.f126529b = uVar;
            }

            public final void a() {
                if (this.f126528a.element) {
                    u uVar = this.f126529b;
                    Intrinsics.checkNotNull(uVar);
                    uVar.onPause();
                    this.f126528a.element = false;
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                a();
                return Unit.INSTANCE;
            }
        }

        public e(Class cls, LuggageActivityHelper.d dVar, Intent intent, Context context) {
            this.f126518b = cls;
            this.f126519c = dVar;
            this.f126520d = intent;
            this.f126521e = context;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v20, types: [T, com.tencent.luggage.wxa.g6.u] */
        /* JADX WARN: Type inference failed for: r9v3 */
        /* JADX WARN: Type inference failed for: r9v5, types: [java.lang.Object] */
        @Override // java.lang.Runnable
        public final void run() {
            Object lastOrNull;
            a aVar;
            Class cls;
            T t16;
            Object lastOrNull2;
            g gVar = g.this;
            Class pageClass = this.f126518b;
            Intrinsics.checkNotNullExpressionValue(pageClass, "pageClass");
            boolean a16 = gVar.a(pageClass);
            lastOrNull = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) g.this.f126498b);
            u uVar = (u) lastOrNull;
            Ref.BooleanRef booleanRef = new Ref.BooleanRef();
            if (uVar != null && g.this.f126497a.getCurrentState().isAtLeast(Lifecycle.State.RESUMED)) {
                booleanRef.element = true;
            }
            d dVar = new d(booleanRef, uVar);
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            int i3 = 0;
            r rVar = null;
            if (a16) {
                ArrayList arrayList = g.this.f126498b;
                Class cls2 = this.f126518b;
                Iterator it = arrayList.iterator();
                while (true) {
                    if (it.hasNext()) {
                        t16 = it.next();
                        if (Intrinsics.areEqual(((u) t16).getPage().getClass(), cls2)) {
                            break;
                        }
                    } else {
                        t16 = 0;
                        break;
                    }
                }
                objectRef.element = t16;
                if (t16 != 0) {
                    if (Intrinsics.areEqual(t16, uVar)) {
                        booleanRef.element = false;
                    }
                    dVar.invoke();
                    g.this.b((u) objectRef.element);
                    T t17 = objectRef.element;
                    lastOrNull2 = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) g.this.f126498b);
                    com.tencent.luggage.wxa.er.a.a(t17, lastOrNull2);
                    g.this.bringChildToFront(((u) objectRef.element).getWindow().getDecorView());
                    g gVar2 = g.this;
                    gVar2.bringChildToFront(gVar2.f126500d);
                    r page = ((u) objectRef.element).getPage();
                    LuggageActivityHelper.d dVar2 = this.f126519c;
                    if (dVar2 != null) {
                        ((u) objectRef.element).a(dVar2);
                    }
                    page.a(this.f126520d);
                    page.setIntent(this.f126520d);
                    ((u) objectRef.element).getWindow().getDecorView().setTranslationX(0.0f);
                    Lifecycle.State currentState = g.this.f126497a.getCurrentState();
                    Lifecycle.State state = Lifecycle.State.STARTED;
                    if (currentState.isAtLeast(state) && !((u) objectRef.element).getLifecycle().getCurrentState().isAtLeast(state)) {
                        ((u) objectRef.element).onStart();
                    }
                    Lifecycle.State currentState2 = g.this.f126497a.getCurrentState();
                    Lifecycle.State state2 = Lifecycle.State.RESUMED;
                    if (currentState2.isAtLeast(state2) && !((u) objectRef.element).getLifecycle().getCurrentState().isAtLeast(state2)) {
                        ((u) objectRef.element).onResume();
                        return;
                    }
                    return;
                }
            }
            if (objectRef.element == 0) {
                objectRef.element = g.this.f();
                Object obj = Reflect.on((Class<?>) this.f126518b).create(objectRef.element).get();
                Intrinsics.checkNotNull(obj);
                r rVar2 = (r) obj;
                ((u) objectRef.element).a(rVar2);
                ((u) objectRef.element).a(g.this.i());
                Class cls3 = this.f126518b;
                Context context = this.f126521e;
                try {
                    Object obj2 = Reflect.on((Class<?>) cls3).get("ACTIVITY_CLASS");
                    Intrinsics.checkNotNull(obj2);
                    cls = (Class) obj2;
                } catch (Exception unused) {
                    cls = null;
                }
                if (cls != null) {
                    PackageManager packageManager = context.getPackageManager();
                    Intrinsics.checkNotNull(packageManager);
                    int i16 = Build.VERSION.SDK_INT;
                    if (i16 >= 29) {
                        i3 = 269221888;
                    } else if (i16 >= 24) {
                        i3 = 786432;
                    }
                    ActivityInfo activityInfo = packageManager.getActivityInfo(new ComponentName(context, (Class<?>) cls), i3);
                    Intrinsics.checkNotNullExpressionValue(activityInfo, "pm.getActivityInfo(Compo\u2026t, activityClass), flags)");
                    int i17 = activityInfo.theme;
                    if (i17 != 0) {
                        ((u) objectRef.element).setTheme(i17);
                    }
                }
                g.this.f126498b.add(objectRef.element);
                aVar = new a(g.this, objectRef);
                rVar2.setIntent(this.f126520d);
                LuggageActivityHelper.d dVar3 = this.f126519c;
                if (dVar3 != null) {
                    ((u) objectRef.element).a(dVar3);
                }
                ((u) objectRef.element).b();
                ((u) objectRef.element).n();
            } else {
                aVar = null;
            }
            dVar.invoke();
            Intrinsics.checkNotNull(aVar);
            aVar.invoke();
            g gVar3 = g.this;
            if (uVar != null) {
                rVar = uVar.getPage();
            }
            r page2 = ((u) objectRef.element).getPage();
            Intrinsics.checkNotNullExpressionValue(page2, "controller.page");
            gVar3.b(rVar, page2);
            if (g.this.f126497a.getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
                ((u) objectRef.element).onStart();
            }
            if (uVar != null) {
                boolean z16 = g.this.f126502f;
                boolean z17 = g.this.f126503g;
                g.this.f126502f = true;
                g.this.f126503g = true;
                g gVar4 = g.this;
                gVar4.c((u) objectRef.element, z16, new b(gVar4, objectRef));
                g gVar5 = g.this;
                gVar5.d(uVar, z17, new c(gVar5, uVar));
                return;
            }
            if (g.this.f126497a.getCurrentState().isAtLeast(Lifecycle.State.RESUMED)) {
                ((u) objectRef.element).onResume();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class f implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ u f126531b;

        public f(u uVar) {
            this.f126531b = uVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Object lastOrNull;
            int indexOf = g.this.f126498b.indexOf(this.f126531b);
            if (indexOf == -1) {
                return;
            }
            if (g.this.a(this.f126531b.getPage().getClass())) {
                g.this.b(this.f126531b);
            }
            u f16 = g.this.f();
            f16.setIntent(this.f126531b.getIntent());
            g.this.removeView(this.f126531b.getWindow().getDecorView());
            g.this.f126498b.set(indexOf, f16);
            Lifecycle.State currentState = this.f126531b.getLifecycle().getCurrentState();
            Intrinsics.checkNotNullExpressionValue(currentState, "page.lifecycle.currentState");
            Lifecycle.State state = Lifecycle.State.RESUMED;
            if (currentState.isAtLeast(state)) {
                this.f126531b.onPause();
            }
            Lifecycle.State state2 = Lifecycle.State.STARTED;
            if (currentState.isAtLeast(state2)) {
                this.f126531b.onStop();
            }
            this.f126531b.onDestroy();
            Object obj = Reflect.on(this.f126531b.getPage().getClass()).create(f16).get();
            Intrinsics.checkNotNull(obj);
            f16.a((r) obj);
            f16.a(g.this.i());
            f16.b();
            g.this.addView(f16.getWindow().getDecorView(), indexOf);
            if (f16.isFinishing()) {
                return;
            }
            f16.n();
            if (!f16.isFinishing()) {
                lastOrNull = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) g.this.f126498b);
                if (Intrinsics.areEqual(lastOrNull, f16)) {
                    currentState = g.this.f126497a.getCurrentState();
                    Intrinsics.checkNotNullExpressionValue(currentState, "lifecycle.currentState");
                }
                if (currentState.isAtLeast(state2)) {
                    f16.onStart();
                }
                if (currentState.isAtLeast(state)) {
                    f16.onResume();
                }
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.g6.g$g, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6232g extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ u f126532a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ g f126533b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Object f126534c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Runnable f126535d;

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.g6.g$g$a */
        /* loaded from: classes8.dex */
        public static final class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ g f126536a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Runnable f126537b;

            public a(g gVar, Runnable runnable) {
                this.f126536a = gVar;
                this.f126537b = runnable;
            }

            @Override // java.lang.Runnable
            public final void run() {
                if (!this.f126536a.f126499c) {
                    this.f126537b.run();
                }
            }
        }

        public C6232g(u uVar, g gVar, Object obj, Runnable runnable) {
            this.f126532a = uVar;
            this.f126533b = gVar;
            this.f126534c = obj;
            this.f126535d = runnable;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            if (Intrinsics.areEqual(this.f126532a.getWindow().getDecorView().getTag(this.f126533b.f126505i), this.f126534c)) {
                this.f126532a.getWindow().getDecorView().setTag(this.f126533b.f126505i, null);
                Runnable runnable = this.f126535d;
                if (runnable != null) {
                    this.f126533b.removeCallbacks(runnable);
                    if (!this.f126533b.f126499c) {
                        this.f126535d.run();
                    }
                }
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            if (Intrinsics.areEqual(this.f126532a.getWindow().getDecorView().getTag(this.f126533b.f126505i), this.f126534c)) {
                this.f126532a.getWindow().getDecorView().setTag(this.f126533b.f126505i, null);
                this.f126533b.f126501e.remove(this.f126534c);
                Runnable runnable = this.f126535d;
                if (runnable != null) {
                    g gVar = this.f126533b;
                    gVar.post(new a(gVar, runnable));
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class h implements Animation.AnimationListener {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Object f126539b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Runnable f126540c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ u f126541d;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ g f126542a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Runnable f126543b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ u f126544c;

            public a(g gVar, Runnable runnable, u uVar) {
                this.f126542a = gVar;
                this.f126543b = runnable;
                this.f126544c = uVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                if (!this.f126542a.f126499c) {
                    this.f126543b.run();
                }
                this.f126544c.getWindow().getDecorView().setTag(this.f126542a.f126505i, null);
            }
        }

        public h(Object obj, Runnable runnable, u uVar) {
            this.f126539b = obj;
            this.f126540c = runnable;
            this.f126541d = uVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            g.this.f126501e.remove(this.f126539b);
            Runnable runnable = this.f126540c;
            if (runnable != null) {
                a aVar = new a(g.this, runnable, this.f126541d);
                if (animation.getStartTime() == Long.MIN_VALUE) {
                    aVar.run();
                    return;
                } else {
                    if (!g.this.f126499c) {
                        g.this.post(aVar);
                        return;
                    }
                    return;
                }
            }
            this.f126541d.getWindow().getDecorView().setTag(g.this.f126505i, null);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }
    }

    public /* synthetic */ g(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }

    public abstract u f();

    @NotNull
    public final Collection<Window> getAllWindows() {
        Set emptySet;
        int collectionSizeOrDefault;
        Set plus;
        Window window;
        k currentDialog = getCurrentDialog();
        if (currentDialog == null || (window = currentDialog.getWindow()) == null || (emptySet = Collections.singleton(window)) == null) {
            emptySet = Collections.emptySet();
        }
        Intrinsics.checkNotNullExpressionValue(emptySet, "currentDialog?.window?.l\u2026?: Collections.emptySet()");
        ArrayList arrayList = this.f126498b;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((u) it.next()).getWindow());
        }
        plus = SetsKt___SetsKt.plus(emptySet, (Iterable) arrayList2);
        return plus;
    }

    @Nullable
    public final k getCurrentDialog() {
        com.tencent.luggage.wxa.ml.m currentDialog = this.f126500d.getCurrentDialog();
        if (currentDialog instanceof k) {
            return (k) currentDialog;
        }
        return null;
    }

    @Nullable
    public final u getCurrentPage() {
        Object lastOrNull;
        lastOrNull = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) this.f126498b);
        return (u) lastOrNull;
    }

    @Override // androidx.lifecycle.LifecycleOwner
    @NotNull
    public Lifecycle getLifecycle() {
        return this.f126497a;
    }

    public int getRequestedOrientation() {
        return 0;
    }

    public Window i() {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        return new w(context);
    }

    public final void o() {
        this.f126499c = true;
        Iterator it = this.f126498b.iterator();
        while (it.hasNext()) {
            ((u) it.next()).onDestroy();
        }
    }

    public final void onPause() {
        boolean z16;
        Object lastOrNull;
        Lifecycle.State currentState = this.f126497a.getCurrentState();
        Lifecycle.State state = Lifecycle.State.RESUMED;
        if (currentState == state) {
            z16 = true;
        } else {
            z16 = false;
        }
        com.tencent.luggage.wxa.er.a.b(z16);
        this.f126497a.setCurrentState(Lifecycle.State.STARTED);
        lastOrNull = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) this.f126498b);
        u uVar = (u) lastOrNull;
        if (uVar != null && uVar.getLifecycle().getCurrentState() == state) {
            uVar.onPause();
        }
    }

    public final void onResume() {
        boolean z16;
        Object lastOrNull;
        Lifecycle.State currentState = this.f126497a.getCurrentState();
        Lifecycle.State state = Lifecycle.State.STARTED;
        if (currentState == state) {
            z16 = true;
        } else {
            z16 = false;
        }
        com.tencent.luggage.wxa.er.a.b(z16);
        this.f126497a.setCurrentState(Lifecycle.State.RESUMED);
        lastOrNull = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) this.f126498b);
        u uVar = (u) lastOrNull;
        if (uVar != null && uVar.getLifecycle().getCurrentState() == state) {
            uVar.onResume();
        }
    }

    public final void onStart() {
        boolean z16;
        Object lastOrNull;
        if (this.f126497a.getCurrentState() == Lifecycle.State.INITIALIZED) {
            this.f126497a.setCurrentState(Lifecycle.State.CREATED);
        }
        Lifecycle.State currentState = this.f126497a.getCurrentState();
        Lifecycle.State state = Lifecycle.State.CREATED;
        if (currentState == state) {
            z16 = true;
        } else {
            z16 = false;
        }
        com.tencent.luggage.wxa.er.a.b(z16);
        this.f126497a.setCurrentState(Lifecycle.State.STARTED);
        lastOrNull = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) this.f126498b);
        u uVar = (u) lastOrNull;
        if (uVar != null && uVar.getLifecycle().getCurrentState() == state) {
            uVar.onStart();
        }
    }

    public final void onStop() {
        boolean z16;
        Object lastOrNull;
        Lifecycle.State currentState = this.f126497a.getCurrentState();
        Lifecycle.State state = Lifecycle.State.STARTED;
        if (currentState == state) {
            z16 = true;
        } else {
            z16 = false;
        }
        com.tencent.luggage.wxa.er.a.b(z16);
        this.f126497a.setCurrentState(Lifecycle.State.CREATED);
        e();
        lastOrNull = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) this.f126498b);
        u uVar = (u) lastOrNull;
        if (uVar != null && uVar.getLifecycle().getCurrentState() == state) {
            uVar.onStop();
        }
    }

    public final void overridePendingTransition(int i3, int i16) {
        if (i3 == 0) {
            this.f126502f = false;
        }
        if (i16 == 0) {
            this.f126503g = false;
        }
    }

    public void u() {
        this.f126500d.e();
        u currentPage = getCurrentPage();
        if (currentPage != null) {
            setRequestedOrientation(currentPage.getRequestedOrientation());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f126497a = new LifecycleRegistry(this);
        this.f126498b = new ArrayList();
        com.tencent.luggage.wxa.ml.g gVar = new com.tencent.luggage.wxa.ml.g(context);
        this.f126500d = gVar;
        addView(gVar, new FrameLayout.LayoutParams(-1, -1));
        this.f126501e = new LinkedHashSet();
        this.f126502f = true;
        this.f126503g = true;
        this.f126504h = 250;
        this.f126505i = R.id.srf;
    }

    @Override // com.tencent.luggage.wxa.g6.p
    public com.tencent.luggage.wxa.g6.d e(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new com.tencent.luggage.wxa.g6.d(new a(context, this));
    }

    public final void h(u page) {
        Intrinsics.checkNotNullParameter(page, "page");
        if (this.f126498b.indexOf(page) == -1) {
            return;
        }
        com.tencent.luggage.wxa.zp.h.f146825d.a(new f(page));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [T, com.tencent.luggage.wxa.g6.h] */
    @Override // com.tencent.luggage.wxa.g6.p
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public com.tencent.luggage.wxa.g6.h g(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = new com.tencent.luggage.wxa.g6.h(context, new b(new Ref.ObjectRef(), this, new Ref.ObjectRef(), objectRef));
        Window i3 = i();
        i3.getDecorView().setSystemUiVisibility(0);
        ((com.tencent.luggage.wxa.g6.h) objectRef.element).a(i3);
        return (com.tencent.luggage.wxa.g6.h) objectRef.element;
    }

    @Override // com.tencent.luggage.wxa.g6.p
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public WeUIProgresssDialog f(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new c(context, this);
    }

    public final Object e(u uVar) {
        ObjectAnimator anim = ObjectAnimator.ofFloat(uVar.getWindow().getDecorView(), "translationX", 0.0f, getWidth());
        anim.setDuration(this.f126504h);
        Intrinsics.checkNotNullExpressionValue(anim, "anim");
        return anim;
    }

    public final Object f(u uVar) {
        ObjectAnimator anim = ObjectAnimator.ofFloat(uVar.getWindow().getDecorView(), "translationX", getWidth(), 0.0f);
        anim.setDuration(this.f126504h);
        Intrinsics.checkNotNullExpressionValue(anim, "anim");
        return anim;
    }

    public final Object g(u uVar) {
        ObjectAnimator anim = ObjectAnimator.ofFloat(uVar.getWindow().getDecorView(), "translationX", 0.0f, -(getWidth() * 0.25f));
        anim.setDuration(this.f126504h);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(uVar.getWindow().getDecorView(), "translationX", 0.0f);
        ofFloat.setDuration(0L);
        new AnimatorSet().playSequentially(anim, ofFloat);
        Intrinsics.checkNotNullExpressionValue(anim, "anim");
        return anim;
    }

    public final void b(Context context, Intent intent, LuggageActivityHelper.d dVar) {
        ComponentName component = intent.getComponent();
        Intrinsics.checkNotNull(component);
        String className = component.getClassName();
        Intrinsics.checkNotNullExpressionValue(className, "intent.component!!.className");
        Class<?> cls = Class.forName(className);
        if (r.class.isAssignableFrom(cls)) {
            com.tencent.luggage.wxa.zp.h.f146825d.a(new e(cls, dVar, intent, context));
            return;
        }
        throw new IllegalArgumentException("intent component class is not UIPage");
    }

    public final Object d(u uVar) {
        ObjectAnimator anim = ObjectAnimator.ofFloat(uVar.getWindow().getDecorView(), "translationX", -(getWidth() * 0.25f), 0.0f);
        anim.setDuration(this.f126504h);
        Intrinsics.checkNotNullExpressionValue(anim, "anim");
        return anim;
    }

    @Override // com.tencent.luggage.wxa.g6.p
    public void a(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        b(context, intent, (LuggageActivityHelper.d) null);
    }

    @Override // com.tencent.luggage.wxa.g6.p
    public void a(Context context, Intent intent, LuggageActivityHelper.d resultCallback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        Intrinsics.checkNotNullParameter(resultCallback, "resultCallback");
        b(context, intent, resultCallback);
    }

    public final boolean a(Class cls) {
        try {
            Object obj = Reflect.on((Class<?>) cls).get("SINGLE_TASK");
            Intrinsics.checkNotNullExpressionValue(obj, "{\n            Reflect.on\u2026(\"SINGLE_TASK\")\n        }");
            return ((Boolean) obj).booleanValue();
        } catch (Exception unused) {
            return false;
        }
    }

    public final void e() {
        for (Object obj : new HashSet(this.f126501e)) {
            if (obj instanceof Animator) {
                ((Animator) obj).end();
            } else if (obj instanceof Animation) {
                ((Animation) obj).cancel();
            }
        }
    }

    public final void b(u uVar) {
        Object lastOrNull;
        int indexOf = this.f126498b.indexOf(uVar);
        while (this.f126498b.size() > indexOf + 1) {
            lastOrNull = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) this.f126498b);
            Intrinsics.checkNotNull(lastOrNull);
            u uVar2 = (u) lastOrNull;
            Lifecycle.State currentState = uVar2.getLifecycle().getCurrentState();
            Intrinsics.checkNotNullExpressionValue(currentState, "removingPage.lifecycle.currentState");
            if (currentState.isAtLeast(Lifecycle.State.RESUMED)) {
                uVar2.onPause();
            }
            if (currentState.isAtLeast(Lifecycle.State.STARTED)) {
                uVar2.onStop();
            }
            removeView(uVar2.getWindow().getDecorView());
            uVar2.onDestroy();
            this.f126498b.remove(uVar2);
        }
    }

    public final void d(u uVar, boolean z16, Runnable runnable) {
        a(uVar, g(uVar), z16, runnable);
    }

    @Override // com.tencent.luggage.wxa.g6.p
    public com.tencent.luggage.wxa.g6.f a(Context context, int i3, boolean z16) {
        Intrinsics.checkNotNullParameter(context, "context");
        throw new UnsupportedOperationException();
    }

    public void a(r oldPage, r rVar) {
        Intrinsics.checkNotNullParameter(oldPage, "oldPage");
        u();
    }

    public final void a(u uVar) {
        uVar.getWindow().getDecorView().clearAnimation();
        Object tag = uVar.getWindow().getDecorView().getTag(this.f126505i);
        if (tag instanceof Animator) {
            Animator animator = (Animator) tag;
            animator.cancel();
            animator.removeAllListeners();
        } else if (tag instanceof Animation) {
            Animation animation = (Animation) tag;
            animation.setAnimationListener(null);
            animation.cancel();
        }
    }

    public final void c(u page) {
        Intrinsics.checkNotNullParameter(page, "page");
        com.tencent.luggage.wxa.zp.h.f146825d.a(new d(page, this));
    }

    public final void c(u uVar, boolean z16, Runnable runnable) {
        a(uVar, f(uVar), z16, runnable);
    }

    public final Object a(u uVar, Object obj, boolean z16, Runnable runnable) {
        if (obj instanceof Animator) {
            a(uVar);
            uVar.getWindow().getDecorView().setTag(this.f126505i, obj);
            Animator animator = (Animator) obj;
            animator.addListener(new C6232g(uVar, this, obj, runnable));
            if (z16) {
                animator.start();
                this.f126501e.add(obj);
            } else {
                animator.end();
            }
        } else if (obj instanceof Animation) {
            Animation animation = (Animation) obj;
            animation.setAnimationListener(new h(obj, runnable, uVar));
            this.f126501e.add(obj);
            a(uVar);
            uVar.getWindow().getDecorView().setTag(this.f126505i, obj);
            uVar.getWindow().getDecorView().startAnimation(animation);
        } else {
            if (obj != null) {
                throw new IllegalArgumentException("Page animation should be Animator or Animation");
            }
            if (runnable != null) {
                runnable.run();
            }
        }
        return obj;
    }

    public void b(r rVar, r newPage) {
        Intrinsics.checkNotNullParameter(newPage, "newPage");
        u();
    }

    public final void b(u uVar, boolean z16, Runnable runnable) {
        a(uVar, e(uVar), z16, runnable);
    }

    public void r() {
    }

    public void setRequestedOrientation(int i3) {
    }

    public final void a(u uVar, boolean z16, Runnable runnable) {
        a(uVar, d(uVar), z16, runnable);
    }
}
