package com.tencent.mobileqq.app.identity;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.util.u;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes11.dex */
public class b extends a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final List<IDelayReporter> f195783a;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        ArrayList arrayList = new ArrayList();
        this.f195783a = arrayList;
        arrayList.add(new t());
    }

    @Override // com.tencent.mobileqq.app.identity.a, com.tencent.mobileqq.app.identity.c
    public void onAccountLoginOrSwitch() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else if (u.a()) {
            u.b(this.f195783a);
        }
    }
}
