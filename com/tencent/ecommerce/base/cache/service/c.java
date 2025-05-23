package com.tencent.ecommerce.base.cache.service;

import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a*\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\"\u0004\b\u0000\u0010\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u00a8\u0006\u0007"}, d2 = {"T", "Lcom/tencent/ecommerce/base/cache/service/SCOPE;", "scope", "Lkotlin/Function0;", "initializer", "Lkotlin/Lazy;", "a", "ecommerce_sdk_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes32.dex */
public final class c {
    public static final <T> Lazy<T> a(SCOPE scope, Function0<? extends T> function0) {
        Lazy<T> lazy;
        int i3 = b.f100640a[scope.ordinal()];
        if (i3 == 1) {
            lazy = LazyKt__LazyJVMKt.lazy(function0);
            return lazy;
        }
        if (i3 == 2) {
            return new a(function0);
        }
        if (i3 == 3) {
            return new d(function0);
        }
        throw new NoWhenBranchMatchedException();
    }

    public static /* synthetic */ Lazy b(SCOPE scope, Function0 function0, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            scope = SCOPE.ACCOUNT;
        }
        return a(scope, function0);
    }
}
