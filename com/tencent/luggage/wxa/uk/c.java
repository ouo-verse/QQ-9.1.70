package com.tencent.luggage.wxa.uk;

import android.content.Context;
import android.view.accessibility.AccessibilityManager;
import com.tencent.mm.sdk.observer.MvvmObserverOwner;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class c implements q {

    /* renamed from: a, reason: collision with root package name */
    public static final c f142656a = new c();

    /* renamed from: b, reason: collision with root package name */
    public static final Lazy f142657b;

    /* renamed from: c, reason: collision with root package name */
    public static final Lazy f142658c;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a extends Lambda implements Function0 {

        /* renamed from: a, reason: collision with root package name */
        public static final a f142659a = new a();

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final AccessibilityManager invoke() {
            Object obj;
            Context c16 = com.tencent.luggage.wxa.tn.z.c();
            if (c16 != null) {
                obj = c16.getSystemService("accessibility");
            } else {
                obj = null;
            }
            if (!(obj instanceof AccessibilityManager)) {
                return null;
            }
            return (AccessibilityManager) obj;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b extends Lambda implements Function0 {

        /* renamed from: a, reason: collision with root package name */
        public static final b f142660a = new b();

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a extends MvvmObserverOwner {
            @Override // com.tencent.mm.sdk.observer.MvvmObserverOwner
            public String a() {
                return "MicroMsg.Luggage.AccessibilityDefaultImpl";
            }
        }

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.uk.c$b$b, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class AccessibilityManagerTouchExplorationStateChangeListenerC6805b implements AccessibilityManager.TouchExplorationStateChangeListener {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f142661a;

            public AccessibilityManagerTouchExplorationStateChangeListenerC6805b(a aVar) {
                this.f142661a = aVar;
            }

            @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
            public final void onTouchExplorationStateChanged(boolean z16) {
                this.f142661a.a(Boolean.valueOf(z16));
            }
        }

        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final a invoke() {
            a aVar = new a();
            AccessibilityManager a16 = c.f142656a.a();
            if (a16 != null) {
                a16.addTouchExplorationStateChangeListener(new AccessibilityManagerTouchExplorationStateChangeListenerC6805b(aVar));
            }
            return aVar;
        }
    }

    static {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(a.f142659a);
        f142657b = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(b.f142660a);
        f142658c = lazy2;
    }

    @Override // com.tencent.luggage.wxa.uk.q
    public MvvmObserverOwner S() {
        return (MvvmObserverOwner) f142658c.getValue();
    }

    @Override // com.tencent.luggage.wxa.uk.q
    public boolean isEnable() {
        AccessibilityManager a16 = a();
        if (a16 != null) {
            return a16.isTouchExplorationEnabled();
        }
        return false;
    }

    public final AccessibilityManager a() {
        return (AccessibilityManager) f142657b.getValue();
    }
}
