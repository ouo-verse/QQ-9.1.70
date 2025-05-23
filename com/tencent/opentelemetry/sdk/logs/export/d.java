package com.tencent.opentelemetry.sdk.logs.export;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes22.dex */
public final /* synthetic */ class d {
    public static LogExporter a(Iterable<LogExporter> iterable) {
        IPatchRedirector iPatchRedirector = LogExporter.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (LogExporter) iPatchRedirector.redirect((short) 2, (Object) iterable);
        }
        ArrayList arrayList = new ArrayList();
        Iterator<LogExporter> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        if (arrayList.isEmpty()) {
            return NoopLogExporter.getInstance();
        }
        if (arrayList.size() == 1) {
            return (LogExporter) arrayList.get(0);
        }
        return MultiLogExporter.create(arrayList);
    }

    public static LogExporter b(LogExporter... logExporterArr) {
        IPatchRedirector iPatchRedirector = LogExporter.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (LogExporter) iPatchRedirector.redirect((short) 1, (Object) logExporterArr);
        }
        return a(Arrays.asList(logExporterArr));
    }
}
