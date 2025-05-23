package com.tencent.opentelemetry.sdk.logs;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.sdk.common.CompletableResultCode;
import com.tencent.opentelemetry.sdk.logs.data.LogData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes22.dex */
public final class MultiLogProcessor implements LogProcessor {
    static IPatchRedirector $redirector_;
    private final AtomicBoolean isShutdown;
    private final List<LogProcessor> logProcessors;

    MultiLogProcessor(List<LogProcessor> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) list);
        } else {
            this.isShutdown = new AtomicBoolean(false);
            this.logProcessors = list;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static LogProcessor create(List<LogProcessor> list) {
        Objects.requireNonNull(list, "logProcessorsList");
        return new MultiLogProcessor(new ArrayList(list));
    }

    @Override // com.tencent.opentelemetry.sdk.logs.LogProcessor, java.io.Closeable, java.lang.AutoCloseable
    public /* synthetic */ void close() {
        b.a(this);
    }

    @Override // com.tencent.opentelemetry.sdk.logs.LogProcessor
    public void emit(LogData logData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) logData);
            return;
        }
        Iterator<LogProcessor> it = this.logProcessors.iterator();
        while (it.hasNext()) {
            it.next().emit(logData);
        }
    }

    @Override // com.tencent.opentelemetry.sdk.logs.LogProcessor
    public CompletableResultCode forceFlush() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (CompletableResultCode) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        ArrayList arrayList = new ArrayList(this.logProcessors.size());
        Iterator<LogProcessor> it = this.logProcessors.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().forceFlush());
        }
        return CompletableResultCode.ofAll(arrayList);
    }

    @Override // com.tencent.opentelemetry.sdk.logs.LogProcessor
    public CompletableResultCode shutdown() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (CompletableResultCode) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        if (this.isShutdown.getAndSet(true)) {
            return CompletableResultCode.ofSuccess();
        }
        ArrayList arrayList = new ArrayList(this.logProcessors.size());
        Iterator<LogProcessor> it = this.logProcessors.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().shutdown());
        }
        return CompletableResultCode.ofAll(arrayList);
    }
}
