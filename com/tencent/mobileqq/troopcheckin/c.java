package com.tencent.mobileqq.troopcheckin;

import android.os.Bundle;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.profilecard.bussiness.qzone.BaseProfileQZoneComponent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes19.dex */
public class c extends d {
    static IPatchRedirector $redirector_;

    public c(a aVar, int i3) {
        super(aVar, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar, i3);
        }
    }

    @Override // com.tencent.mobileqq.troopcheckin.d
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else if (!g(this.f302713a.f302708a)) {
            f();
        }
    }

    @Override // com.tencent.mobileqq.troopcheckin.d
    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else if (this.f302717e) {
            e();
        }
    }

    @Override // com.tencent.mobileqq.troopcheckin.d
    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        Transaction transaction = this.f302718f;
        if (transaction != null) {
            transaction.cancelTransaction();
        }
    }

    @Override // com.tencent.mobileqq.troopcheckin.d
    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        Bundle bundle = new Bundle();
        boolean z16 = false;
        bundle.putInt(BaseProfileQZoneComponent.KEY_IS_VIDEO, 0);
        if (this.f302716d != null) {
            z16 = true;
            bundle.putInt("result", 1);
            bundle.putString("url", this.f302716d);
        } else {
            bundle.putInt("result", 0);
            bundle.putString("error", "");
        }
        b.c().d(z16, this.f302715c, bundle);
    }
}
