package com.tencent.opentelemetry.sdk.trace.export;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes22.dex */
public final /* synthetic */ class f {
    public static void a(SpanExporter spanExporter) {
        IPatchRedirector iPatchRedirector = SpanExporter.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) spanExporter);
        } else {
            spanExporter.shutdown().join(10L, TimeUnit.SECONDS);
        }
    }

    public static SpanExporter b(Iterable<SpanExporter> iterable) {
        IPatchRedirector iPatchRedirector = SpanExporter.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (SpanExporter) iPatchRedirector.redirect((short) 2, (Object) iterable);
        }
        ArrayList arrayList = new ArrayList();
        Iterator<SpanExporter> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        if (arrayList.isEmpty()) {
            return NoopSpanExporter.getInstance();
        }
        if (arrayList.size() == 1) {
            return (SpanExporter) arrayList.get(0);
        }
        return MultiSpanExporter.create(arrayList);
    }

    public static SpanExporter c(SpanExporter... spanExporterArr) {
        IPatchRedirector iPatchRedirector = SpanExporter.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (SpanExporter) iPatchRedirector.redirect((short) 1, (Object) spanExporterArr);
        }
        return b(Arrays.asList(spanExporterArr));
    }
}
