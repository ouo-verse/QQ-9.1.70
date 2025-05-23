package com.tencent.opentelemetry.sdk.logs;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.sdk.common.CompletableResultCode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes22.dex */
public final /* synthetic */ class b {
    public static void a(LogProcessor logProcessor) {
        IPatchRedirector iPatchRedirector = LogProcessor.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) logProcessor);
        } else {
            logProcessor.shutdown().join(10L, TimeUnit.SECONDS);
        }
    }

    public static CompletableResultCode b(LogProcessor logProcessor) {
        IPatchRedirector iPatchRedirector = LogProcessor.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (CompletableResultCode) iPatchRedirector.redirect((short) 4, (Object) logProcessor);
        }
        return CompletableResultCode.ofSuccess();
    }

    public static CompletableResultCode c(LogProcessor logProcessor) {
        IPatchRedirector iPatchRedirector = LogProcessor.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (CompletableResultCode) iPatchRedirector.redirect((short) 3, (Object) logProcessor);
        }
        return logProcessor.forceFlush();
    }

    public static LogProcessor d(Iterable<LogProcessor> iterable) {
        IPatchRedirector iPatchRedirector = LogProcessor.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (LogProcessor) iPatchRedirector.redirect((short) 2, (Object) iterable);
        }
        ArrayList arrayList = new ArrayList();
        Iterator<LogProcessor> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        if (arrayList.isEmpty()) {
            return NoopLogProcessor.getInstance();
        }
        if (arrayList.size() == 1) {
            return (LogProcessor) arrayList.get(0);
        }
        return MultiLogProcessor.create(arrayList);
    }

    public static LogProcessor e(LogProcessor... logProcessorArr) {
        IPatchRedirector iPatchRedirector = LogProcessor.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (LogProcessor) iPatchRedirector.redirect((short) 1, (Object) logProcessorArr);
        }
        return d(Arrays.asList(logProcessorArr));
    }
}
