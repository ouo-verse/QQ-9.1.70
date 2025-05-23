package com.tencent.hippykotlin.demo.pages.vas_base.native_api;

import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class GXHImpl implements INativeApi {
    public final Lazy gxh$delegate;

    public GXHImpl() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<GXH>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.native_api.GXHImpl$gxh$2
            @Override // kotlin.jvm.functions.Function0
            public final GXH invoke() {
                return new GXH();
            }
        });
        this.gxh$delegate = lazy;
    }
}
