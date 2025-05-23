package com.tencent.opentelemetry.sdk.trace;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.opentelemetry.context.Context;
import com.tencent.opentelemetry.sdk.common.CompletableResultCode;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes22.dex */
public final class NoopSpanProcessor implements SpanProcessor {
    static IPatchRedirector $redirector_;
    private static final NoopSpanProcessor INSTANCE;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13256);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new NoopSpanProcessor();
        }
    }

    NoopSpanProcessor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static SpanProcessor getInstance() {
        return INSTANCE;
    }

    @Override // com.tencent.opentelemetry.sdk.trace.SpanProcessor, java.io.Closeable, java.lang.AutoCloseable
    public /* synthetic */ void close() {
        i.a(this);
    }

    @Override // com.tencent.opentelemetry.sdk.trace.SpanProcessor
    public /* synthetic */ CompletableResultCode forceFlush() {
        return i.b(this);
    }

    @Override // com.tencent.opentelemetry.sdk.trace.SpanProcessor
    public boolean isEndRequired() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.opentelemetry.sdk.trace.SpanProcessor
    public boolean isStartRequired() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.opentelemetry.sdk.trace.SpanProcessor
    public void onEnd(ReadableSpan readableSpan) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) readableSpan);
        }
    }

    @Override // com.tencent.opentelemetry.sdk.trace.SpanProcessor
    public void onStart(Context context, ReadWriteSpan readWriteSpan) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) readWriteSpan);
        }
    }

    @Override // com.tencent.opentelemetry.sdk.trace.SpanProcessor
    public void reopen() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        }
    }

    @Override // com.tencent.opentelemetry.sdk.trace.SpanProcessor
    public /* synthetic */ CompletableResultCode shutdown() {
        return i.d(this);
    }
}
