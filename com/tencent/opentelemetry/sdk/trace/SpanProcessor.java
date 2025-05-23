package com.tencent.opentelemetry.sdk.trace;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.context.Context;
import com.tencent.opentelemetry.sdk.common.CompletableResultCode;
import java.io.Closeable;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
/* loaded from: classes22.dex */
public interface SpanProcessor extends Closeable {
    public static final IPatchRedirector $redirector_ = null;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    CompletableResultCode forceFlush();

    boolean isEndRequired();

    boolean isStartRequired();

    void onEnd(ReadableSpan readableSpan);

    void onStart(Context context, ReadWriteSpan readWriteSpan);

    void reopen();

    CompletableResultCode shutdown();
}
