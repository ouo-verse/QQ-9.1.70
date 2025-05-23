package com.tencent.opentelemetry.otlp.logging;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.opentelemetry.sdk.common.CompletableResultCode;
import com.tencent.opentelemetry.sdk.common.InstrumentationLibraryInfo;
import com.tencent.opentelemetry.sdk.trace.data.SpanData;
import com.tencent.opentelemetry.sdk.trace.export.SpanExporter;
import com.tencent.opentelemetry.sdk.trace.export.f;
import java.util.Collection;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class LoggingSpanExporter implements SpanExporter {
    static IPatchRedirector $redirector_;
    private static final Logger logger;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(8641);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            logger = Logger.getLogger(LoggingSpanExporter.class.getName());
        }
    }

    public LoggingSpanExporter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.opentelemetry.sdk.trace.export.SpanExporter, java.io.Closeable, java.lang.AutoCloseable
    public /* synthetic */ void close() {
        f.a(this);
    }

    @Override // com.tencent.opentelemetry.sdk.trace.export.SpanExporter
    public CompletableResultCode export(Collection<SpanData> collection) {
        String version;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (CompletableResultCode) iPatchRedirector.redirect((short) 2, (Object) this, (Object) collection);
        }
        StringBuilder sb5 = new StringBuilder(60);
        for (SpanData spanData : collection) {
            sb5.setLength(0);
            InstrumentationLibraryInfo instrumentationLibraryInfo = spanData.getInstrumentationLibraryInfo();
            sb5.append("'");
            sb5.append(spanData.getName());
            sb5.append("' : ");
            sb5.append(spanData.getTraceId());
            sb5.append(" ");
            sb5.append(spanData.getSpanId());
            sb5.append(" ");
            sb5.append(spanData.getKind());
            sb5.append(" [tracer: ");
            sb5.append(instrumentationLibraryInfo.getName());
            sb5.append(":");
            if (instrumentationLibraryInfo.getVersion() == null) {
                version = "";
            } else {
                version = instrumentationLibraryInfo.getVersion();
            }
            sb5.append(version);
            sb5.append("] ");
            sb5.append(spanData.getAttributes());
            logger.log(Level.INFO, sb5.toString());
        }
        return CompletableResultCode.ofSuccess();
    }

    @Override // com.tencent.opentelemetry.sdk.trace.export.SpanExporter
    public CompletableResultCode flush() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (CompletableResultCode) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        CompletableResultCode completableResultCode = new CompletableResultCode();
        for (Handler handler : logger.getHandlers()) {
            try {
                handler.flush();
            } catch (Throwable unused) {
                completableResultCode.fail();
            }
        }
        return completableResultCode.succeed();
    }

    @Override // com.tencent.opentelemetry.sdk.trace.export.SpanExporter
    public CompletableResultCode shutdown() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (CompletableResultCode) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return flush();
    }
}
