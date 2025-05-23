package com.tencent.opentelemetry.sdk.trace;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.context.Context;
import com.tencent.opentelemetry.sdk.common.CompletableResultCode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes22.dex */
public final class MultiSpanProcessor implements SpanProcessor {
    static IPatchRedirector $redirector_;
    private final AtomicBoolean isShutdown;
    private final List<SpanProcessor> spanProcessorsAll;
    private final List<SpanProcessor> spanProcessorsEnd;
    private final List<SpanProcessor> spanProcessorsStart;

    MultiSpanProcessor(List<SpanProcessor> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) list);
            return;
        }
        this.isShutdown = new AtomicBoolean(false);
        this.spanProcessorsAll = list;
        this.spanProcessorsStart = new ArrayList(list.size());
        this.spanProcessorsEnd = new ArrayList(list.size());
        for (SpanProcessor spanProcessor : list) {
            if (spanProcessor.isStartRequired()) {
                this.spanProcessorsStart.add(spanProcessor);
            }
            if (spanProcessor.isEndRequired()) {
                this.spanProcessorsEnd.add(spanProcessor);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static SpanProcessor create(List<SpanProcessor> list) {
        Objects.requireNonNull(list, "spanProcessorList");
        return new MultiSpanProcessor(new ArrayList(list));
    }

    @Override // com.tencent.opentelemetry.sdk.trace.SpanProcessor, java.io.Closeable, java.lang.AutoCloseable
    public /* synthetic */ void close() {
        i.a(this);
    }

    @Override // com.tencent.opentelemetry.sdk.trace.SpanProcessor
    public CompletableResultCode forceFlush() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (CompletableResultCode) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        ArrayList arrayList = new ArrayList(this.spanProcessorsAll.size());
        Iterator<SpanProcessor> it = this.spanProcessorsAll.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().forceFlush());
        }
        return CompletableResultCode.ofAll(arrayList);
    }

    @Override // com.tencent.opentelemetry.sdk.trace.SpanProcessor
    public boolean isEndRequired() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return !this.spanProcessorsEnd.isEmpty();
    }

    @Override // com.tencent.opentelemetry.sdk.trace.SpanProcessor
    public boolean isStartRequired() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return !this.spanProcessorsStart.isEmpty();
    }

    @Override // com.tencent.opentelemetry.sdk.trace.SpanProcessor
    public void onEnd(ReadableSpan readableSpan) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) readableSpan);
            return;
        }
        Iterator<SpanProcessor> it = this.spanProcessorsEnd.iterator();
        while (it.hasNext()) {
            it.next().onEnd(readableSpan);
        }
    }

    @Override // com.tencent.opentelemetry.sdk.trace.SpanProcessor
    public void onStart(Context context, ReadWriteSpan readWriteSpan) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) readWriteSpan);
            return;
        }
        Iterator<SpanProcessor> it = this.spanProcessorsStart.iterator();
        while (it.hasNext()) {
            it.next().onStart(context, readWriteSpan);
        }
    }

    @Override // com.tencent.opentelemetry.sdk.trace.SpanProcessor
    public void reopen() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            this.isShutdown.set(false);
        }
    }

    @Override // com.tencent.opentelemetry.sdk.trace.SpanProcessor
    public CompletableResultCode shutdown() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (CompletableResultCode) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        if (this.isShutdown.getAndSet(true)) {
            return CompletableResultCode.ofSuccess();
        }
        ArrayList arrayList = new ArrayList(this.spanProcessorsAll.size());
        Iterator<SpanProcessor> it = this.spanProcessorsAll.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().shutdown());
        }
        return CompletableResultCode.ofAll(arrayList);
    }
}
