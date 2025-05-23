package com.tencent.mobileqq.app;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes11.dex */
public class cy implements BusinessObserver {
    static IPatchRedirector $redirector_;

    public cy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    protected void a(boolean z16, List<Long> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), list);
        }
    }

    protected void b(boolean z16, List<Long> list, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(z16), list, Integer.valueOf(i3));
        }
    }

    protected void c(boolean z16, List<Long> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Boolean.valueOf(z16), list);
        }
    }

    protected void d(boolean z16, List<Long> list, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Boolean.valueOf(z16), list, Integer.valueOf(i3));
        }
    }

    protected void e(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, z16);
        }
    }

    protected void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessObserver
    public void onUpdate(int i3, boolean z16, Object obj) {
        ArrayList arrayList;
        int intValue;
        long[] jArr;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i16 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
            return;
        }
        if (obj != null) {
            arrayList = new ArrayList();
            if (obj instanceof long[]) {
                jArr = (long[]) obj;
                intValue = 0;
            } else {
                Object[] objArr = (Object[]) obj;
                long[] jArr2 = (long[]) objArr[0];
                intValue = ((Integer) objArr[1]).intValue();
                jArr = jArr2;
            }
            int length = jArr.length;
            while (i16 < length) {
                arrayList.add(Long.valueOf(jArr[i16]));
                i16++;
            }
            i16 = intValue;
        } else {
            arrayList = null;
        }
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 == 4) {
                        f();
                        return;
                    }
                    return;
                } else {
                    c(z16, arrayList);
                    d(z16, arrayList, i16);
                    return;
                }
            }
            a(z16, arrayList);
            b(z16, arrayList, i16);
            return;
        }
        e(z16);
    }
}
