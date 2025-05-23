package com.tencent.opentelemetry.sdk.trace.export;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.opentelemetry.api.logging.DefaultPrintLogger;
import com.tencent.opentelemetry.context.Context;
import com.tencent.opentelemetry.sdk.common.CompletableResultCode;
import com.tencent.opentelemetry.sdk.trace.ReadWriteSpan;
import com.tencent.opentelemetry.sdk.trace.ReadableSpan;
import com.tencent.opentelemetry.sdk.trace.SpanProcessor;
import com.tencent.opentelemetry.sdk.trace.i;
import java.util.Collections;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes22.dex */
public final class SimpleSpanProcessor implements SpanProcessor {
    static IPatchRedirector $redirector_;
    private static final String TAG;
    private final AtomicBoolean isShutdown;
    private final Set<CompletableResultCode> pendingExports;
    private final boolean sampled;
    private final SpanExporter spanExporter;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11705);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            TAG = SimpleSpanProcessor.class.getName();
        }
    }

    SimpleSpanProcessor(SpanExporter spanExporter, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, spanExporter, Boolean.valueOf(z16));
            return;
        }
        this.pendingExports = Collections.newSetFromMap(new ConcurrentHashMap());
        this.isShutdown = new AtomicBoolean(false);
        Objects.requireNonNull(spanExporter, "spanExporter");
        this.spanExporter = spanExporter;
        this.sampled = z16;
    }

    public static SpanProcessor create(SpanExporter spanExporter) {
        Objects.requireNonNull(spanExporter, "exporter");
        return new SimpleSpanProcessor(spanExporter, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onEnd$0(CompletableResultCode completableResultCode) {
        this.pendingExports.remove(completableResultCode);
        if (!completableResultCode.isSuccess() && DefaultPrintLogger.isDebug()) {
            DefaultPrintLogger.e(TAG, "Exporter failed");
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
        final CompletableResultCode shutdown = this.spanExporter.shutdown();
        shutdown.whenComplete(new Runnable() { // from class: com.tencent.opentelemetry.sdk.trace.export.c
            @Override // java.lang.Runnable
            public final void run() {
                SimpleSpanProcessor.lambda$shutdown$1(CompletableResultCode.this, shutdown, completableResultCode2);
            }
        });
    }

    @Override // com.tencent.opentelemetry.sdk.trace.SpanProcessor, java.io.Closeable, java.lang.AutoCloseable
    public /* synthetic */ void close() {
        i.a(this);
    }

    @Override // com.tencent.opentelemetry.sdk.trace.SpanProcessor
    public CompletableResultCode forceFlush() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (CompletableResultCode) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return CompletableResultCode.ofAll(this.pendingExports);
    }

    @Override // com.tencent.opentelemetry.sdk.trace.SpanProcessor
    public boolean isEndRequired() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.opentelemetry.sdk.trace.SpanProcessor
    public boolean isStartRequired() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.opentelemetry.sdk.trace.SpanProcessor
    public void onEnd(ReadableSpan readableSpan) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) readableSpan);
            return;
        }
        if (this.sampled && !readableSpan.getSpanContext().isSampled()) {
            return;
        }
        try {
            final CompletableResultCode export = this.spanExporter.export(Collections.singletonList(readableSpan.toSpanData()));
            this.pendingExports.add(export);
            export.whenComplete(new Runnable() { // from class: com.tencent.opentelemetry.sdk.trace.export.d
                @Override // java.lang.Runnable
                public final void run() {
                    SimpleSpanProcessor.this.lambda$onEnd$0(export);
                }
            });
        } catch (RuntimeException e16) {
            if (DefaultPrintLogger.isDebug()) {
                DefaultPrintLogger.e(TAG, "Exporter threw an Exception", e16);
            }
        }
    }

    @Override // com.tencent.opentelemetry.sdk.trace.SpanProcessor
    public void onStart(Context context, ReadWriteSpan readWriteSpan) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) readWriteSpan);
        }
    }

    @Override // com.tencent.opentelemetry.sdk.trace.SpanProcessor
    public void reopen() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            this.isShutdown.set(false);
        }
    }

    @Override // com.tencent.opentelemetry.sdk.trace.SpanProcessor
    public CompletableResultCode shutdown() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (CompletableResultCode) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        if (this.isShutdown.getAndSet(true)) {
            return CompletableResultCode.ofSuccess();
        }
        final CompletableResultCode completableResultCode = new CompletableResultCode();
        final CompletableResultCode forceFlush = forceFlush();
        forceFlush.whenComplete(new Runnable() { // from class: com.tencent.opentelemetry.sdk.trace.export.e
            @Override // java.lang.Runnable
            public final void run() {
                SimpleSpanProcessor.this.lambda$shutdown$2(forceFlush, completableResultCode);
            }
        });
        return completableResultCode;
    }
}
