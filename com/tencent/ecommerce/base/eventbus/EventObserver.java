package com.tencent.ecommerce.base.eventbus;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u00e6\u0080\u0001\u0018\u0000*\f\b\u0000\u0010\u0001*\u00060\u0002j\u0002`\u00032\u00020\u0002J\u0015\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00028\u0000H&\u00a2\u0006\u0002\u0010\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/ecommerce/base/eventbus/EventObserver;", "T", "", "Lcom/tencent/ecommerce/base/eventbus/EVENT;", "onEvent", "", "event", "(Ljava/lang/Object;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes32.dex */
public interface EventObserver<T> {
    void onEvent(T event);
}
