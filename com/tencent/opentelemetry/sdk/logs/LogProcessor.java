package com.tencent.opentelemetry.sdk.logs;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.sdk.common.CompletableResultCode;
import com.tencent.opentelemetry.sdk.logs.data.LogData;
import java.io.Closeable;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
/* loaded from: classes22.dex */
public interface LogProcessor extends Closeable {
    public static final IPatchRedirector $redirector_ = null;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    void emit(LogData logData);

    CompletableResultCode forceFlush();

    CompletableResultCode shutdown();
}
