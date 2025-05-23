package com.tencent.hippykotlin.demo.pages.vas_base.native_api;

import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class FriendsImpl implements INativeApi {
    public final Lazy friends$delegate;

    public FriendsImpl() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Friends>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.native_api.FriendsImpl$friends$2
            @Override // kotlin.jvm.functions.Function0
            public final Friends invoke() {
                return new Friends();
            }
        });
        this.friends$delegate = lazy;
    }
}
