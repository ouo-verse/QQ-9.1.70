package com.tencent.mobileqq.confess;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes5.dex */
public class b implements BusinessObserver {
    static IPatchRedirector $redirector_;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public void a(String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
        }
    }

    public void b(boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), obj);
        }
    }

    public void c(ConfessConfig confessConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) confessConfig);
        }
    }

    public void d(boolean z16, long j3, long j16, int i3, int i16, int i17, int i18, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Boolean.valueOf(z16), Long.valueOf(j3), Long.valueOf(j16), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Boolean.valueOf(z17));
        }
    }

    public void e(boolean z16, String str, int i3, int i16, int i17, String str2, ConfessInfo confessInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(z16), str, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), str2, confessInfo);
        }
    }

    public void f(boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), obj);
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessObserver
    public void onUpdate(int i3, boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
            return;
        }
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 != 8) {
                            if (i3 == 9 && (obj instanceof Object[])) {
                                Object[] objArr = (Object[]) obj;
                                if (objArr.length >= 3) {
                                    a((String) objArr[0], ((Integer) objArr[1]).intValue(), ((Integer) objArr[2]).intValue());
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        if (obj instanceof Object[]) {
                            Object[] objArr2 = (Object[]) obj;
                            if (objArr2.length >= 7) {
                                d(z16, ((Long) objArr2[0]).longValue(), ((Long) objArr2[1]).longValue(), ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue(), ((Integer) objArr2[4]).intValue(), ((Integer) objArr2[5]).intValue(), ((Boolean) objArr2[6]).booleanValue());
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    if (obj != null && (obj instanceof ConfessConfig)) {
                        c((ConfessConfig) obj);
                        return;
                    }
                    return;
                }
                if (obj != null && (obj instanceof Object[])) {
                    Object[] objArr3 = (Object[]) obj;
                    if (objArr3.length == 6) {
                        e(z16, (String) objArr3[0], ((Integer) objArr3[1]).intValue(), ((Integer) objArr3[2]).intValue(), ((Integer) objArr3[3]).intValue(), (String) objArr3[4], (ConfessInfo) objArr3[5]);
                        return;
                    }
                    return;
                }
                return;
            }
            f(z16, obj);
            return;
        }
        b(z16, obj);
    }
}
