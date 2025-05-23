package com.tencent.mobileqq.troop.observer;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes19.dex */
public class h implements BusinessObserver {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private static int f298021d;

    /* renamed from: e, reason: collision with root package name */
    public static final int f298022e;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(28785);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f298021d = 0 + 1;
            f298022e = 0;
        }
    }

    public h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void b(int i3, boolean z16, Object obj) {
        if (i3 == f298022e && (obj instanceof Object[])) {
            Object[] objArr = (Object[]) obj;
            boolean z17 = false;
            String str = (String) objArr[0];
            boolean booleanValue = ((Boolean) objArr[1]).booleanValue();
            String str2 = (String) objArr[2];
            String str3 = (String) objArr[3];
            if (objArr.length >= 5) {
                z17 = ((Boolean) objArr[4]).booleanValue();
            }
            a(z16, str, booleanValue, str2, str3, z17);
        }
    }

    protected void a(boolean z16, String str, boolean z17, String str2, String str3, boolean z18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), str, Boolean.valueOf(z17), str2, str3, Boolean.valueOf(z18));
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessObserver
    public void onUpdate(int i3, boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
        } else {
            b(i3, z16, obj);
        }
    }
}
