package com.tencent.mobileqq.app;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;
import tencent.im.nearfield_discuss.nearfield_discuss$BusiRespHead;
import tencent.im.nearfield_discuss.nearfield_discuss$UserProfile;

/* compiled from: P */
/* loaded from: classes11.dex */
public class bw implements BusinessObserver {
    static IPatchRedirector $redirector_;

    public bw() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    protected void a(boolean z16, List<nearfield_discuss$UserProfile> list, int i3, int i16, nearfield_discuss$BusiRespHead nearfield_discuss_busiresphead, int i17, int i18, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), list, Integer.valueOf(i3), Integer.valueOf(i16), nearfield_discuss_busiresphead, Integer.valueOf(i17), Integer.valueOf(i18), Long.valueOf(j3));
        }
    }

    protected void b(boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), obj);
        }
    }

    protected void c(boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), obj);
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessObserver
    public void onUpdate(int i3, boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
            return;
        }
        switch (i3) {
            case 1020:
                b(z16, obj);
                return;
            case 1021:
                if (z16) {
                    Object[] objArr = (Object[]) obj;
                    a(z16, (List) objArr[0], ((Integer) objArr[1]).intValue(), ((Integer) objArr[2]).intValue(), (nearfield_discuss$BusiRespHead) objArr[3], ((Integer) objArr[4]).intValue(), ((Integer) objArr[5]).intValue(), ((Long) objArr[6]).longValue());
                    return;
                } else {
                    a(z16, null, -1, -1, null, -1, -1, -1L);
                    return;
                }
            case 1022:
                if (z16) {
                    c(z16, obj);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
