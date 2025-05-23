package com.tencent.mobileqq.transfile.ipv6;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes19.dex */
public class IpFirstAsMSFStrategy extends IpStrategyAbstract {
    static IPatchRedirector $redirector_;
    private int mMSFConnType;

    /* JADX INFO: Access modifiers changed from: package-private */
    public IpFirstAsMSFStrategy(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3);
        } else {
            this.mMSFConnType = i3;
        }
    }

    @Override // com.tencent.mobileqq.transfile.ipv6.IpStrategyAbstract
    protected ArrayList selectIpListWhenDual(ArrayList arrayList, ArrayList arrayList2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ArrayList) iPatchRedirector.redirect((short) 2, (Object) this, (Object) arrayList, (Object) arrayList2);
        }
        if (this.mMSFConnType == 2) {
            return selectIpv6First(arrayList, arrayList2);
        }
        return selectIpv4First(arrayList, arrayList2);
    }
}
