package com.tencent.mobileqq.transfile.ipv6;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes19.dex */
public abstract class IpStrategyAbstract implements IpStrategy {
    static IPatchRedirector $redirector_;

    public IpStrategyAbstract() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.transfile.ipv6.IpStrategy
    public ArrayList selectIpList(ArrayList arrayList, ArrayList arrayList2, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ArrayList) iPatchRedirector.redirect((short) 2, this, arrayList, arrayList2, Integer.valueOf(i3));
        }
        if (i3 == 2) {
            return arrayList;
        }
        if (i3 == 3) {
            return selectIpListWhenDual(arrayList, arrayList2);
        }
        return arrayList2;
    }

    protected abstract ArrayList selectIpListWhenDual(ArrayList arrayList, ArrayList arrayList2);

    /* JADX INFO: Access modifiers changed from: protected */
    public ArrayList selectIpv4First(ArrayList arrayList, ArrayList arrayList2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ArrayList) iPatchRedirector.redirect((short) 4, (Object) this, (Object) arrayList, (Object) arrayList2);
        }
        ArrayList arrayList3 = new ArrayList();
        if (arrayList2 != null && arrayList2.size() > 0) {
            arrayList3.addAll(arrayList2);
        }
        if (arrayList != null && arrayList.size() > 0) {
            arrayList3.add(arrayList.get(0));
        }
        return arrayList3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ArrayList selectIpv6First(ArrayList arrayList, ArrayList arrayList2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ArrayList) iPatchRedirector.redirect((short) 3, (Object) this, (Object) arrayList, (Object) arrayList2);
        }
        ArrayList arrayList3 = new ArrayList();
        if (arrayList != null && arrayList.size() > 0) {
            arrayList3.add(arrayList.get(0));
        }
        if (arrayList2 != null && arrayList2.size() > 0) {
            arrayList3.addAll(arrayList2);
        }
        return arrayList3;
    }
}
