package com.tencent.opentelemetry.api.trace;

/* compiled from: P */
/* loaded from: classes22.dex */
public interface TraceStateBuilder {
    TraceState build();

    TraceStateBuilder put(String str, String str2);

    TraceStateBuilder remove(String str);
}
