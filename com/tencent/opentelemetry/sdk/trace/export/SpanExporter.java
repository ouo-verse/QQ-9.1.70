package com.tencent.opentelemetry.sdk.trace.export;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.sdk.common.CompletableResultCode;
import com.tencent.opentelemetry.sdk.trace.data.SpanData;
import java.io.Closeable;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes22.dex */
public interface SpanExporter extends Closeable {
    public static final IPatchRedirector $redirector_ = null;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    CompletableResultCode export(Collection<SpanData> collection);

    CompletableResultCode flush();

    CompletableResultCode shutdown();
}
