package com.tencent.mobileqq.tofumsg;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;
import tencent.im.oidb.cmd0xe61.oidb_0xe61$BeancurdCubeInfoResult;

/* compiled from: P */
/* loaded from: classes18.dex */
public class n implements BusinessObserver {
    static IPatchRedirector $redirector_;

    public n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public void a(boolean z16, String str, String str2, List<oidb_0xe61$BeancurdCubeInfoResult> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), str, str2, list);
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessObserver
    public void onUpdate(int i3, boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
        } else if (i3 == 0) {
            Object[] objArr = (Object[]) obj;
            a(z16, (String) objArr[0], (String) objArr[1], (List) objArr[2]);
        }
    }
}
