package com.tencent.mobileqq.qqbattery.feature;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqbattery.feature.d;
import java.util.Comparator;

/* compiled from: P */
/* loaded from: classes16.dex */
class c implements Comparator<d.a.c> {
    static IPatchRedirector $redirector_;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(d.a.c cVar, d.a.c cVar2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) cVar, (Object) cVar2)).intValue();
        }
        long longValue = cVar.b().longValue() - cVar2.b().longValue();
        if (longValue == 0) {
            return 0;
        }
        if (longValue > 0) {
            return -1;
        }
        return 1;
    }
}
