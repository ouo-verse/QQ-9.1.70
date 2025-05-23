package com.tencent.cache.core.manager.control;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class g<T> implements Comparator<T> {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ List f98740d;

    public g(List list) {
        this.f98740d = list;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) list);
        }
    }

    @Override // java.util.Comparator
    public final int compare(T t16, T t17) {
        int compareValues;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            compareValues = ComparisonsKt__ComparisonsKt.compareValues(Integer.valueOf(this.f98740d.indexOf(((Map.Entry) t17).getKey())), Integer.valueOf(this.f98740d.indexOf(((Map.Entry) t16).getKey())));
            return compareValues;
        }
        return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) t16, (Object) t17)).intValue();
    }
}
