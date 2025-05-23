package com.tencent.opentelemetry.sdk.trace.export;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.opentelemetry.sdk.common.CompletableResultCode;
import com.tencent.opentelemetry.sdk.trace.data.SpanData;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes22.dex */
final class NoopSpanExporter implements SpanExporter {
    static IPatchRedirector $redirector_;
    private static final SpanExporter INSTANCE;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11714);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new NoopSpanExporter();
        }
    }

    NoopSpanExporter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static SpanExporter getInstance() {
        return INSTANCE;
    }

    @Override // com.tencent.opentelemetry.sdk.trace.export.SpanExporter, java.io.Closeable, java.lang.AutoCloseable
    public /* synthetic */ void close() {
        f.a(this);
    }

    @Override // com.tencent.opentelemetry.sdk.trace.export.SpanExporter
    public CompletableResultCode export(Collection<SpanData> collection) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (CompletableResultCode) iPatchRedirector.redirect((short) 2, (Object) this, (Object) collection);
        }
        return CompletableResultCode.ofSuccess();
    }

    @Override // com.tencent.opentelemetry.sdk.trace.export.SpanExporter
    public CompletableResultCode flush() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (CompletableResultCode) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return CompletableResultCode.ofSuccess();
    }

    @Override // com.tencent.opentelemetry.sdk.trace.export.SpanExporter
    public CompletableResultCode shutdown() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (CompletableResultCode) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return CompletableResultCode.ofSuccess();
    }
}
