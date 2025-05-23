package com.tencent.kuikly.core.global;

import com.tencent.kuikly.core.kmp.c;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b \u0010!J?\u0010\r\u001a\u00060\u0002j\u0002`\f2\u0006\u0010\u0003\u001a\u00020\u00022+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\b\u0012\u00060\bj\u0002`\t0\u0004j\u0002`\nJ&\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u000e\u001a\u00060\u0002j\u0002`\f2\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0001J\u001a\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0011\u001a\u00060\u0002j\u0002`\fJ\u000e\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u0002R\u0016\u0010\u0016\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0015R\u001b\u0010\u001b\u001a\u00020\u00178BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001c\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0015RE\u0010\u001f\u001a3\u0012/\u0012-\u0012)\u0012'\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\b\u0012\u00060\bj\u0002`\t0\u0004j\u0002`\n0\u001d0\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u001e\u00a8\u0006\""}, d2 = {"Lcom/tencent/kuikly/core/global/GlobalFunctions;", "", "", "pagerId", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "data", "", "Lcom/tencent/kuikly/core/global/KeepFuncAlive;", "Lcom/tencent/kuikly/core/global/GlobalFunction;", "func", "Lcom/tencent/kuikly/core/global/GlobalFunctionRef;", "a", "funcRef", "", "e", "globalFunctionRef", "c", "b", "", "I", "globalFunctionProducer", "Lcom/tencent/kuikly/core/kmp/c;", "Lkotlin/Lazy;", "d", "()Lcom/tencent/kuikly/core/kmp/c;", "rwLock", "kmpGlobalPagerFunctionProducer", "Lcom/tencent/kuikly/core/kmp/b;", "Lcom/tencent/kuikly/core/kmp/b;", "functionMap", "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class GlobalFunctions {

    /* renamed from: a, reason: collision with root package name */
    public static final GlobalFunctions f117252a = new GlobalFunctions();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static int globalFunctionProducer;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final Lazy rwLock;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static int kmpGlobalPagerFunctionProducer;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static final com.tencent.kuikly.core.kmp.b<com.tencent.kuikly.core.kmp.b<Function1<Object, Boolean>>> functionMap;

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) new Function0<c>() { // from class: com.tencent.kuikly.core.global.GlobalFunctions$rwLock$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final c invoke() {
                return new c();
            }
        });
        rwLock = lazy;
        kmpGlobalPagerFunctionProducer = 1000000;
        functionMap = new com.tencent.kuikly.core.kmp.b<>(com.tencent.kuikly.core.manager.c.f117352a.j(), false, 2, null);
    }

    GlobalFunctions() {
    }

    private final c d() {
        return (c) rwLock.getValue();
    }

    public final String a(String pagerId, Function1<Object, Boolean> func) {
        String valueOf;
        Intrinsics.checkNotNullParameter(pagerId, "pagerId");
        Intrinsics.checkNotNullParameter(func, "func");
        com.tencent.kuikly.core.manager.c cVar = com.tencent.kuikly.core.manager.c.f117352a;
        if (cVar.n(pagerId)) {
            d().c();
            int i3 = kmpGlobalPagerFunctionProducer + 1;
            kmpGlobalPagerFunctionProducer = i3;
            valueOf = String.valueOf(i3);
            d().d();
        } else {
            int i16 = globalFunctionProducer + 1;
            globalFunctionProducer = i16;
            valueOf = String.valueOf(i16);
        }
        com.tencent.kuikly.core.kmp.b<com.tencent.kuikly.core.kmp.b<Function1<Object, Boolean>>> bVar = functionMap;
        if (!bVar.a(pagerId)) {
            bVar.e(pagerId, new com.tencent.kuikly.core.kmp.b<>("_kt_none_", cVar.n(pagerId)));
        }
        com.tencent.kuikly.core.kmp.b<Function1<Object, Boolean>> b16 = bVar.b(pagerId);
        if (b16 != null) {
            b16.e(valueOf, func);
        }
        return valueOf;
    }

    public final void b(String pagerId) {
        Intrinsics.checkNotNullParameter(pagerId, "pagerId");
        functionMap.d(pagerId);
    }

    public final void c(String pagerId, String globalFunctionRef) {
        Intrinsics.checkNotNullParameter(pagerId, "pagerId");
        Intrinsics.checkNotNullParameter(globalFunctionRef, "globalFunctionRef");
        com.tencent.kuikly.core.kmp.b<Function1<Object, Boolean>> b16 = functionMap.b(pagerId);
        if (b16 != null) {
            b16.d(globalFunctionRef);
        }
    }

    public final void e(String pagerId, String funcRef, Object data) {
        Intrinsics.checkNotNullParameter(pagerId, "pagerId");
        Intrinsics.checkNotNullParameter(funcRef, "funcRef");
        com.tencent.kuikly.core.kmp.b<Function1<Object, Boolean>> b16 = functionMap.b(pagerId);
        if (b16 != null) {
            Function1<Object, Boolean> b17 = b16.b(funcRef);
            if (Intrinsics.areEqual(b17 != null ? b17.invoke(data) : null, Boolean.TRUE)) {
                return;
            }
            f117252a.c(pagerId, funcRef);
        }
    }
}
