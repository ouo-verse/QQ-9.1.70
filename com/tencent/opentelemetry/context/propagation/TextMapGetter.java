package com.tencent.opentelemetry.context.propagation;

import javax.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes22.dex */
public interface TextMapGetter<C> {
    @Nullable
    String get(@Nullable C c16, String str);

    Iterable<String> keys(C c16);
}
