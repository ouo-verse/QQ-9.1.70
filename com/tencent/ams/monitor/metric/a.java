package com.tencent.ams.monitor.metric;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Comparator;

/* compiled from: P */
/* loaded from: classes3.dex */
class a implements Comparator<i> {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(i iVar, i iVar2) {
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) iVar, (Object) iVar2)).intValue();
        }
        long j16 = 0;
        if (iVar != null) {
            j3 = iVar.getTimeMillis();
        } else {
            j3 = 0;
        }
        if (iVar2 != null) {
            j16 = iVar2.getTimeMillis();
        }
        return Long.compare(j3, j16);
    }
}
