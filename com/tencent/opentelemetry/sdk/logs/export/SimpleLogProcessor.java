package com.tencent.opentelemetry.sdk.logs.export;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.opentelemetry.sdk.common.CompletableResultCode;
import com.tencent.opentelemetry.sdk.logs.LogProcessor;
import com.tencent.opentelemetry.sdk.logs.data.LogData;
import java.util.Collections;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes22.dex */
public final class SimpleLogProcessor implements LogProcessor {
    static IPatchRedirector $redirector_;
    private static final Logger logger;
    private final AtomicBoolean isShutdown;
    private final LogExporter logExporter;
    private final Set<CompletableResultCode> pendingExports;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(8702);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            logger = Logger.getLogger(SimpleLogProcessor.class.getName());
        }
    }

    SimpleLogProcessor(LogExporter logExporter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) logExporter);
            return;
        }
        this.pendingExports = Collections.newSetFromMap(new ConcurrentHashMap());
        this.isShutdown = new AtomicBoolean(false);
        Objects.requireNonNull(logExporter, "logExporter");
        this.logExporter = logExporter;
    }

    public static LogProcessor create(LogExporter logExporter) {
        Objects.requireNonNull(logExporter, "exporter");
        return new SimpleLogProcessor(logExporter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$emit$0(CompletableResultCode completableResultCode) {
        this.pendingExports.remove(completableResultCode);
        if (!completableResultCode.isSuccess()) {
            logger.log(Level.FINE, "Exporter failed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$shutdown$1(CompletableResultCode completableResultCode, CompletableResultCode completableResultCode2, CompletableResultCode completableResultCode3) {
        if (completableResultCode.isSuccess() && completableResultCode2.isSuccess()) {
            completableResultCode3.succeed();
        } else {
            completableResultCode3.fail();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$shutdown$2(final CompletableResultCode completableResultCode, final CompletableResultCode completableResultCode2) {
        final CompletableResultCode shutdown = this.logExporter.shutdown();
        shutdown.whenComplete(new Runnable() { // from class: com.tencent.opentelemetry.sdk.logs.export.f
            @Override // java.lang.Runnable
            public final void run() {
                SimpleLogProcessor.lambda$shutdown$1(CompletableResultCode.this, shutdown, completableResultCode2);
            }
        });
    }

    @Override // com.tencent.opentelemetry.sdk.logs.LogProcessor, java.io.Closeable, java.lang.AutoCloseable
    public /* synthetic */ void close() {
        com.tencent.opentelemetry.sdk.logs.b.a(this);
    }

    @Override // com.tencent.opentelemetry.sdk.logs.LogProcessor
    public void emit(LogData logData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) logData);
            return;
        }
        try {
            final CompletableResultCode export = this.logExporter.export(Collections.singletonList(logData));
            this.pendingExports.add(export);
            export.whenComplete(new Runnable() { // from class: com.tencent.opentelemetry.sdk.logs.export.e
                @Override // java.lang.Runnable
                public final void run() {
                    SimpleLogProcessor.this.lambda$emit$0(export);
                }
            });
        } catch (RuntimeException e16) {
            logger.log(Level.WARNING, "Exporter threw an Exception", (Throwable) e16);
        }
    }

    @Override // com.tencent.opentelemetry.sdk.logs.LogProcessor
    public CompletableResultCode forceFlush() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (CompletableResultCode) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return CompletableResultCode.ofAll(this.pendingExports);
    }

    @Override // com.tencent.opentelemetry.sdk.logs.LogProcessor
    public CompletableResultCode shutdown() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (CompletableResultCode) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        if (this.isShutdown.getAndSet(true)) {
            return CompletableResultCode.ofSuccess();
        }
        final CompletableResultCode completableResultCode = new CompletableResultCode();
        final CompletableResultCode forceFlush = forceFlush();
        forceFlush.whenComplete(new Runnable() { // from class: com.tencent.opentelemetry.sdk.logs.export.g
            @Override // java.lang.Runnable
            public final void run() {
                SimpleLogProcessor.this.lambda$shutdown$2(forceFlush, completableResultCode);
            }
        });
        return completableResultCode;
    }
}
