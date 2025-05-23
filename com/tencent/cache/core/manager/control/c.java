package com.tencent.cache.core.manager.control;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Comparator;
import java.util.Map;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class c<T> implements Comparator<T> {
    static IPatchRedirector $redirector_;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // java.util.Comparator
    public final int compare(T t16, T t17) {
        int compareValues;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            compareValues = ComparisonsKt__ComparisonsKt.compareValues((Integer) ((Map.Entry) t17).getValue(), (Integer) ((Map.Entry) t16).getValue());
            return compareValues;
        }
        return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) t16, (Object) t17)).intValue();
    }
}
