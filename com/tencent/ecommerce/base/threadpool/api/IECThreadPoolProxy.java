package com.tencent.ecommerce.base.threadpool.api;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/ecommerce/base/threadpool/api/IECThreadPoolProxy;", "", "execOnSubThread", "", "runnable", "Lkotlin/Function0;", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public interface IECThreadPoolProxy {
    void execOnSubThread(@NotNull Function0<Unit> runnable);
}
