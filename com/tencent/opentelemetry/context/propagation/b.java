package com.tencent.opentelemetry.context.propagation;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes22.dex */
public final /* synthetic */ class b {
    public static TextMapPropagator a(Iterable<TextMapPropagator> iterable) {
        IPatchRedirector iPatchRedirector = TextMapPropagator.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (TextMapPropagator) iPatchRedirector.redirect((short) 2, (Object) iterable);
        }
        ArrayList arrayList = new ArrayList();
        Iterator<TextMapPropagator> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        if (arrayList.isEmpty()) {
            return NoopTextMapPropagator.getInstance();
        }
        if (arrayList.size() == 1) {
            return (TextMapPropagator) arrayList.get(0);
        }
        return new MultiTextMapPropagator(arrayList);
    }

    public static TextMapPropagator b(TextMapPropagator... textMapPropagatorArr) {
        IPatchRedirector iPatchRedirector = TextMapPropagator.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (TextMapPropagator) iPatchRedirector.redirect((short) 1, (Object) textMapPropagatorArr);
        }
        return a(Arrays.asList(textMapPropagatorArr));
    }

    public static TextMapPropagator c() {
        IPatchRedirector iPatchRedirector = TextMapPropagator.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (TextMapPropagator) iPatchRedirector.redirect((short) 3);
        }
        return NoopTextMapPropagator.getInstance();
    }
}
