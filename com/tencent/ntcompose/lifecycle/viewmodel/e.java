package com.tencent.ntcompose.lifecycle.viewmodel;

import com.tencent.ntcompose.lifecycle.viewmodel.i;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* compiled from: P */
@ViewModelFactoryDsl
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J7\u0010\u000b\u001a\u00020\n\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00028\u00000\u0006\u00a2\u0006\u0002\b\bJ\u0006\u0010\r\u001a\u00020\fR(\u0010\u0011\u001a\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000f0\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/ntcompose/lifecycle/viewmodel/e;", "", "Lcom/tencent/ntcompose/lifecycle/viewmodel/g;", "T", "Lkotlin/reflect/KClass;", "clazz", "Lkotlin/Function1;", "Lcom/tencent/ntcompose/lifecycle/viewmodel/b;", "Lkotlin/ExtensionFunctionType;", "initializer", "", "a", "Lcom/tencent/ntcompose/lifecycle/viewmodel/i$b;", "b", "", "Lcom/tencent/ntcompose/lifecycle/viewmodel/h;", "Ljava/util/Map;", "initializers", "<init>", "()V", "ntcompose_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Map<KClass<?>, h<?>> initializers = new LinkedHashMap();

    public final <T extends g> void a(KClass<T> clazz, Function1<? super b, ? extends T> initializer) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(initializer, "initializer");
        if (!this.initializers.containsKey(clazz)) {
            this.initializers.put(clazz, new h<>(clazz, initializer));
            return;
        }
        throw new IllegalArgumentException(("A `initializer` with the same `clazz` has already been added: " + xo3.e.a(clazz) + '.').toString());
    }

    public final i.b b() {
        return xo3.d.f448243a.a(this.initializers.values());
    }
}
