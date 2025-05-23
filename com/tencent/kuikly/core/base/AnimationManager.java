package com.tencent.kuikly.core.base;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010#\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b&\u0010'J$\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J&\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rJ\u0006\u0010\u0011\u001a\u00020\u000fJ\u000e\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u0004J3\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00042#\u0010\u0016\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u000b\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u000f0\u0013J\u000e\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u0004J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0005\u001a\u00020\u0004RO\u0010\u001f\u001a6\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u0006\u0012\u0004\u0012\u00020\b0\u001aj\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u0006\u0012\u0004\u0012\u00020\b`\u001b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0012\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR[\u0010\"\u001aB\u0012\u0004\u0012\u00020\u0004\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u00060 0\u001aj \u0012\u0004\u0012\u00020\u0004\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u00060 `\u001b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\u001c\u001a\u0004\b!\u0010\u001eR\u0016\u0010%\u001a\u0004\u0018\u00010\u00028BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b#\u0010$\u00a8\u0006("}, d2 = {"Lcom/tencent/kuikly/core/base/AnimationManager;", "", "", "propertyKey", "", "viewRef", "Lkotlin/Pair;", "f", "Lcom/tencent/kuikly/core/base/c;", "b", "j", "Lcom/tencent/kuikly/core/base/b;", "animation", "", "makeDirty", "", "k", "d", "a", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "trigger", "l", "e", "c", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Lkotlin/Lazy;", "g", "()Ljava/util/HashMap;", "animationsHashMap", "", "i", "viewRefToKeys", tl.h.F, "()Ljava/lang/String;", "currentChangingProperty", "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class AnimationManager {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Lazy animationsHashMap;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final Lazy viewRefToKeys;

    public AnimationManager() {
        Lazy lazy;
        Lazy lazy2;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        lazy = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<HashMap<Pair<? extends String, ? extends Integer>, c>>() { // from class: com.tencent.kuikly.core.base.AnimationManager$animationsHashMap$2
            @Override // kotlin.jvm.functions.Function0
            public final HashMap<Pair<? extends String, ? extends Integer>, c> invoke() {
                return new HashMap<>();
            }
        });
        this.animationsHashMap = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<HashMap<Integer, Set<Pair<? extends String, ? extends Integer>>>>() { // from class: com.tencent.kuikly.core.base.AnimationManager$viewRefToKeys$2
            @Override // kotlin.jvm.functions.Function0
            public final HashMap<Integer, Set<Pair<? extends String, ? extends Integer>>> invoke() {
                return new HashMap<>();
            }
        });
        this.viewRefToKeys = lazy2;
    }

    private final c b(int viewRef) {
        String h16;
        if (!g().isEmpty() && (h16 = h()) != null) {
            while (viewRef != 0) {
                c cVar = g().get(f(h16, viewRef));
                if (cVar != null) {
                    return cVar;
                }
                viewRef = j(viewRef);
            }
        }
        return null;
    }

    private final Pair<String, Integer> f(String propertyKey, int viewRef) {
        return new Pair<>(propertyKey, Integer.valueOf(viewRef));
    }

    private final HashMap<Pair<String, Integer>, c> g() {
        return (HashMap) this.animationsHashMap.getValue();
    }

    private final String h() {
        return com.tencent.kuikly.core.manager.c.f117352a.i().getCurrentChangingPropertyKey();
    }

    private final HashMap<Integer, Set<Pair<String, Integer>>> i() {
        return (HashMap) this.viewRefToKeys.getValue();
    }

    private final int j(int viewRef) {
        AbstractBaseView<?, ?> viewWithNativeRef = com.tencent.kuikly.core.manager.c.f117352a.g().getViewWithNativeRef(viewRef);
        if (viewWithNativeRef != null) {
            return viewWithNativeRef.getParentRef();
        }
        return 0;
    }

    public final void a(int viewRef) {
        Set<Pair<String, Integer>> set = i().get(Integer.valueOf(viewRef));
        if (set != null) {
            Iterator<Pair<String, Integer>> it = set.iterator();
            while (it.hasNext()) {
                g().remove(it.next());
            }
            i().remove(Integer.valueOf(viewRef));
        }
    }

    public final b c(int viewRef) {
        c b16 = b(viewRef);
        if (b16 != null) {
            return b16.d();
        }
        return null;
    }

    public final void d() {
        i().clear();
        g().clear();
    }

    public final void e(int viewRef) {
        String h16 = h();
        if (h16 != null) {
            c cVar = g().get(f(h16, viewRef));
            if (cVar != null) {
                cVar.c();
            }
        }
    }

    public final void k(String propertyKey, int viewRef, b animation, boolean makeDirty) {
        Intrinsics.checkNotNullParameter(propertyKey, "propertyKey");
        Intrinsics.checkNotNullParameter(animation, "animation");
        Pair<String, Integer> f16 = f(propertyKey, viewRef);
        HashMap<Pair<String, Integer>, c> g16 = g();
        c cVar = g16.get(f16);
        if (cVar == null) {
            cVar = new c();
            g16.put(f16, cVar);
        }
        c cVar2 = cVar;
        HashMap<Integer, Set<Pair<String, Integer>>> i3 = i();
        Integer valueOf = Integer.valueOf(viewRef);
        Set<Pair<String, Integer>> set = i3.get(valueOf);
        if (set == null) {
            set = new LinkedHashSet<>();
            i3.put(valueOf, set);
        }
        set.add(f16);
        cVar2.a(animation, makeDirty);
    }

    public final void l(int viewRef, Function1<? super b, Unit> trigger) {
        Intrinsics.checkNotNullParameter(trigger, "trigger");
        String h16 = h();
        if (h16 != null) {
            c cVar = g().get(f(h16, viewRef));
            if (cVar != null) {
                cVar.f();
            }
        }
        c b16 = b(viewRef);
        if (b16 != null) {
            b16.e(trigger);
            b b17 = b16.b();
            if (b17 != null) {
                trigger.invoke(b17);
            }
        }
    }
}
