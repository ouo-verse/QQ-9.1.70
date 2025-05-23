package com.tencent.mobileqq.quicklogin.business;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes17.dex */
public class a implements BusinessObserver {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public final String f276996d;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f276996d = "QuickLoginObserver";
        }
    }

    private void b(boolean z16, Object obj) {
        if (c(obj)) {
            a(z16, ((Long) ((Object[]) obj)[0]).longValue());
        } else {
            QLog.e("QuickLoginObserver", 2, "onUpdateSetPCVerify error");
        }
    }

    private boolean c(Object obj) {
        if (obj != null && (obj instanceof Object[]) && ((Object[]) obj).length == 1) {
            return true;
        }
        return false;
    }

    public void a(boolean z16, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), Long.valueOf(j3));
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessObserver
    public void onUpdate(int i3, boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
        } else if (i3 == 1) {
            b(z16, obj);
        }
    }
}
