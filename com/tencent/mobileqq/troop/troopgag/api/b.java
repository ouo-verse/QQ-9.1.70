package com.tencent.mobileqq.troop.troopgag.api;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes19.dex */
public class b implements BusinessObserver {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private static int f300218d;

    /* renamed from: e, reason: collision with root package name */
    public static final int f300219e;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(29455);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f300218d = 0 + 1;
            f300219e = 0;
        }
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void b(int i3, boolean z16, Object obj) {
        if (i3 != f300219e) {
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("TroopGagObserver", 4, "TroopHandler.TYPE_TROOP_GAG_STATUS");
        }
        a((com.tencent.mobileqq.troop.troopgag.data.a) obj);
    }

    protected void a(com.tencent.mobileqq.troop.troopgag.data.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessObserver
    public void onUpdate(int i3, boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
        } else {
            b(i3, z16, obj);
        }
    }
}
