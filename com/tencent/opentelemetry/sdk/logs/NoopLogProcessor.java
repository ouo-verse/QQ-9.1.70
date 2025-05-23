package com.tencent.opentelemetry.sdk.logs;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.opentelemetry.sdk.common.CompletableResultCode;
import com.tencent.opentelemetry.sdk.logs.data.LogData;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes22.dex */
public final class NoopLogProcessor implements LogProcessor {
    static IPatchRedirector $redirector_;
    private static final NoopLogProcessor INSTANCE;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(9673);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new NoopLogProcessor();
        }
    }

    NoopLogProcessor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static LogProcessor getInstance() {
        return INSTANCE;
    }

    @Override // com.tencent.opentelemetry.sdk.logs.LogProcessor, java.io.Closeable, java.lang.AutoCloseable
    public /* synthetic */ void close() {
        b.a(this);
    }

    @Override // com.tencent.opentelemetry.sdk.logs.LogProcessor
    public void emit(LogData logData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) logData);
        }
    }

    @Override // com.tencent.opentelemetry.sdk.logs.LogProcessor
    public /* synthetic */ CompletableResultCode forceFlush() {
        return b.b(this);
    }

    @Override // com.tencent.opentelemetry.sdk.logs.LogProcessor
    public /* synthetic */ CompletableResultCode shutdown() {
        return b.c(this);
    }
}
