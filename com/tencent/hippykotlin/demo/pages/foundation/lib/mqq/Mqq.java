package com.tencent.hippykotlin.demo.pages.foundation.lib.mqq;

import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class Mqq {
    public static final Mqq INSTANCE = new Mqq();
    public static final Lazy device$delegate;
    public static final Lazy ui$delegate;
    public static final Lazy util$delegate;

    static {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        lazy = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<MqqUi>() { // from class: com.tencent.hippykotlin.demo.pages.foundation.lib.mqq.Mqq$ui$2
            @Override // kotlin.jvm.functions.Function0
            public final MqqUi invoke() {
                return new MqqUi();
            }
        });
        ui$delegate = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<MqqUtil>() { // from class: com.tencent.hippykotlin.demo.pages.foundation.lib.mqq.Mqq$util$2
            @Override // kotlin.jvm.functions.Function0
            public final MqqUtil invoke() {
                return new MqqUtil();
            }
        });
        util$delegate = lazy2;
        LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<MqqHttp>() { // from class: com.tencent.hippykotlin.demo.pages.foundation.lib.mqq.Mqq$http$2
            @Override // kotlin.jvm.functions.Function0
            public final MqqHttp invoke() {
                return new MqqHttp();
            }
        });
        LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<MqqData>() { // from class: com.tencent.hippykotlin.demo.pages.foundation.lib.mqq.Mqq$data$2
            @Override // kotlin.jvm.functions.Function0
            public final MqqData invoke() {
                return new MqqData();
            }
        });
        lazy3 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<MqqDevice>() { // from class: com.tencent.hippykotlin.demo.pages.foundation.lib.mqq.Mqq$device$2
            @Override // kotlin.jvm.functions.Function0
            public final MqqDevice invoke() {
                return new MqqDevice();
            }
        });
        device$delegate = lazy3;
        LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<MqqApp>() { // from class: com.tencent.hippykotlin.demo.pages.foundation.lib.mqq.Mqq$app$2
            @Override // kotlin.jvm.functions.Function0
            public final MqqApp invoke() {
                return new MqqApp();
            }
        });
        LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<MqqRedpoint>() { // from class: com.tencent.hippykotlin.demo.pages.foundation.lib.mqq.Mqq$redpoint$2
            @Override // kotlin.jvm.functions.Function0
            public final MqqRedpoint invoke() {
                return new MqqRedpoint();
            }
        });
        LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<MqqWidget>() { // from class: com.tencent.hippykotlin.demo.pages.foundation.lib.mqq.Mqq$widget$2
            @Override // kotlin.jvm.functions.Function0
            public final MqqWidget invoke() {
                return new MqqWidget();
            }
        });
    }

    public final MqqUi getUi() {
        return (MqqUi) ui$delegate.getValue();
    }

    public final MqqUtil getUtil() {
        return (MqqUtil) util$delegate.getValue();
    }
}
