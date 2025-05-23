package com.tencent.mobileqq.transfile.ipv6;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes19.dex */
public class Ipv6FirstStrategy extends IpStrategyAbstract {
    static IPatchRedirector $redirector_;

    public Ipv6FirstStrategy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.transfile.ipv6.IpStrategyAbstract
    protected ArrayList selectIpListWhenDual(ArrayList arrayList, ArrayList arrayList2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ArrayList) iPatchRedirector.redirect((short) 2, (Object) this, (Object) arrayList, (Object) arrayList2);
        }
        return selectIpv6First(arrayList, arrayList2);
    }
}
