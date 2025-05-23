package com.tencent.opentelemetry.sdk.metrics.internal.state;

import com.tencent.opentelemetry.sdk.metrics.internal.aggregator.Aggregator;
import java.util.function.BiFunction;

/* compiled from: P */
/* loaded from: classes22.dex */
public final /* synthetic */ class o implements BiFunction {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Aggregator f341891a;

    @Override // java.util.function.BiFunction
    public final Object apply(Object obj, Object obj2) {
        return this.f341891a.merge(obj, obj2);
    }
}
