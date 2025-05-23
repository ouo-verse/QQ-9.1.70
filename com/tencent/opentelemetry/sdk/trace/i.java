package com.tencent.opentelemetry.sdk.trace;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.sdk.common.CompletableResultCode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes22.dex */
public final /* synthetic */ class i {
    public static void a(SpanProcessor spanProcessor) {
        IPatchRedirector iPatchRedirector = SpanProcessor.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) spanProcessor);
        } else {
            spanProcessor.shutdown().join(10L, TimeUnit.SECONDS);
        }
    }

    public static CompletableResultCode b(SpanProcessor spanProcessor) {
        IPatchRedirector iPatchRedirector = SpanProcessor.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (CompletableResultCode) iPatchRedirector.redirect((short) 4, (Object) spanProcessor);
        }
        return CompletableResultCode.ofSuccess();
    }

    public static void c(SpanProcessor spanProcessor) {
        IPatchRedirector iPatchRedirector = SpanProcessor.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) spanProcessor);
        }
    }

    public static CompletableResultCode d(SpanProcessor spanProcessor) {
        IPatchRedirector iPatchRedirector = SpanProcessor.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (CompletableResultCode) iPatchRedirector.redirect((short) 3, (Object) spanProcessor);
        }
        return spanProcessor.forceFlush();
    }

    public static SpanProcessor e(Iterable<SpanProcessor> iterable) {
        IPatchRedirector iPatchRedirector = SpanProcessor.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (SpanProcessor) iPatchRedirector.redirect((short) 2, (Object) iterable);
        }
        ArrayList arrayList = new ArrayList();
        Iterator<SpanProcessor> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        if (arrayList.isEmpty()) {
            return NoopSpanProcessor.getInstance();
        }
        if (arrayList.size() == 1) {
            return (SpanProcessor) arrayList.get(0);
        }
        return MultiSpanProcessor.create(arrayList);
    }

    public static SpanProcessor f(SpanProcessor... spanProcessorArr) {
        IPatchRedirector iPatchRedirector = SpanProcessor.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (SpanProcessor) iPatchRedirector.redirect((short) 1, (Object) spanProcessorArr);
        }
        return e(Arrays.asList(spanProcessorArr));
    }
}
