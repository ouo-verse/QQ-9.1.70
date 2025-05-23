package com.tencent.opentelemetry.api.trace;

import javax.annotation.concurrent.ThreadSafe;

/* compiled from: P */
@ThreadSafe
/* loaded from: classes22.dex */
public interface Tracer {
    SpanBuilder spanBuilder(String str);
}
