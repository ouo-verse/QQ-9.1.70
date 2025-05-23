package com.tencent.mobileqq.avatar.dynamicavatar;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes11.dex */
public class c implements BusinessObserver {
    static IPatchRedirector $redirector_;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    protected void a(boolean z16, b bVar, Long l3, int i3, int i16, int i17, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), bVar, l3, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Boolean.valueOf(z17));
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessObserver
    public void onUpdate(int i3, boolean z16, Object obj) {
        long j3;
        int i16;
        int i17;
        int i18;
        b bVar;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
            return;
        }
        if (i3 == 1001) {
            Object[] objArr = (Object[]) obj;
            if (objArr != null && objArr.length == 6) {
                b bVar2 = (b) objArr[0];
                j3 = ((Long) objArr[1]).longValue();
                int intValue = ((Integer) objArr[2]).intValue();
                int intValue2 = ((Integer) objArr[3]).intValue();
                int intValue3 = ((Integer) objArr[4]).intValue();
                z17 = ((Boolean) objArr[5]).booleanValue();
                i17 = intValue2;
                i16 = intValue;
                i18 = intValue3;
                bVar = bVar2;
            } else {
                j3 = -1;
                i16 = -1;
                i17 = -1;
                i18 = -1;
                bVar = null;
                z17 = false;
            }
            a(z16, bVar, Long.valueOf(j3), i16, i17, i18, z17);
        }
    }
}
