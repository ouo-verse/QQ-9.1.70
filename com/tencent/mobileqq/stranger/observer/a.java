package com.tencent.mobileqq.stranger.observer;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;
import tencent.im.oidb.cmd0x5d4.oidb_0x5d4$DelResult;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a implements BusinessObserver {
    static IPatchRedirector $redirector_;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public void a(List<String> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) list);
        }
    }

    public void b(boolean z16, PBRepeatMessageField<oidb_0x5d4$DelResult> pBRepeatMessageField) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), pBRepeatMessageField);
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessObserver
    public void onUpdate(int i3, boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
        } else if (i3 == 3) {
            b(z16, (PBRepeatMessageField) obj);
        } else if (i3 == 4) {
            a((List) obj);
        }
    }
}
