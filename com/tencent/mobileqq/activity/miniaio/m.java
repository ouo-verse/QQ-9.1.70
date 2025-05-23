package com.tencent.mobileqq.activity.miniaio;

import android.os.Bundle;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zplan.aio.IZPlanMiniAIOHelper;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes10.dex */
public class m {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    protected Map<String, a> f183506a;

    public m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f183506a = new HashMap();
        }
    }

    private void b(Bundle bundle) {
        Iterator<Map.Entry<String, a>> it = this.f183506a.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().b(bundle);
        }
    }

    private void c(Bundle bundle) {
        Iterator<Map.Entry<String, a>> it = this.f183506a.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().a(bundle);
        }
    }

    public void a(int i3, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) bundle);
        } else if (i3 == 1) {
            c(bundle);
        } else if (i3 == 2) {
            b(bundle);
        }
    }

    public void d(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3);
        } else if (i3 == 30) {
            Object miniAioObserver = ((IZPlanMiniAIOHelper) QRoute.api(IZPlanMiniAIOHelper.class)).getMiniAioObserver();
            if (miniAioObserver instanceof a) {
                this.f183506a.put(miniAioObserver.getClass().getName(), (a) miniAioObserver);
            }
        }
    }

    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            this.f183506a.clear();
        }
    }
}
