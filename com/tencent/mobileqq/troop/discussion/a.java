package com.tencent.mobileqq.troop.discussion;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a implements b {
    static IPatchRedirector $redirector_;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void a(boolean z16, Object obj) {
        if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            boolean z17 = false;
            String str = (String) objArr[0];
            boolean booleanValue = ((Boolean) objArr[1]).booleanValue();
            int intValue = ((Integer) objArr[2]).intValue();
            int intValue2 = ((Integer) objArr[3]).intValue();
            if (objArr.length >= 5) {
                z17 = ((Boolean) objArr[4]).booleanValue();
            }
            c(z16, str, booleanValue, intValue, intValue2, z17);
        }
    }

    protected void b(boolean z16, Long l3) {
        throw null;
    }

    protected void c(boolean z16, String str, boolean z17, int i3, int i16, boolean z18) {
        throw null;
    }

    protected void d(boolean z16, Long l3, Long l16) {
        throw null;
    }

    protected void e(boolean z16, Long l3) {
        throw null;
    }

    @Override // com.tencent.mobileqq.app.BusinessObserver
    public void onUpdate(int i3, boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Discussion", 2, "Discussion DiscussObserver onUpdate type" + i3);
        }
        switch (i3) {
            case 1015:
                long[] jArr = (long[]) obj;
                d(z16, Long.valueOf(jArr[0]), Long.valueOf(jArr[1]));
                return;
            case 1016:
                b(z16, (Long) obj);
                return;
            case 1017:
                e(z16, (Long) obj);
                return;
            case 1018:
                a(z16, obj);
                return;
            default:
                return;
        }
    }
}
